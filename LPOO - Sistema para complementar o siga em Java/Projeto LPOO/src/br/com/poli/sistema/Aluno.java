package br.com.poli.sistema;

import br.com.poli.dados.ListaGeralAlunos;
import br.com.poli.sistema.Disciplina;

public class Aluno extends Pessoa {
	private String numMatricula;
	private boolean status; // blocado ou n�o blocado
	private double ranking;
	private int periodo;
	private Disciplina listaDisciplinas[];
	private int ultimaDisciplinaMatriculada = 0;
	
	public Aluno(String nome, String cpf, boolean status, double ranking, int periodo) {
		super(nome, cpf);
		
		this.status = status;
		this.ranking = ranking;
		this.periodo = periodo;
		this.listaDisciplinas = new Disciplina[1];
		this.setNumMatricula(this.getLogin());
	}

	public String fazerMatricula(Disciplina disciplina) {
		/*adiciona o aluno na �ltima posi��o do array que j� foi aberto na �ltima vez que um aluno se matriculou*/
		disciplina.setListaAlunos(this);
		
		/*criando um array auxiliar com uma posi��o a mais que o antigo*/
		Aluno[] temp = new Aluno[disciplina.getUltimoAlunoMatriculado() + 1];
		
		/*colocando os objetos do array antigo no array auxiliar*/
		for (int i = 0; i < disciplina.getListaAlunos().length; i++) {
			temp[i] = disciplina.getListaAlunos()[i];
		}
		
		/*enviando o array auxiliar para a lista de alunos que est� em disciplina*/
		disciplina.setListaAlunos(temp);
		/*anulando o array auxiliar que foi criado*/
		temp = null;
		
		/*FAZENDO O MESMO PROCESSO DA PARTE DE CIMA PARA ADICIONAR A DISCIPLINA AO ARRAY DE DISCIPLINAS DO ALUNO*/
		this.setListaDisciplinas(disciplina);
		
		Disciplina[] disciplinaAux = new Disciplina[this.getUltimaDisciplinaMatriculada() + 1];
		
		for (int i = 0; i < this.listaDisciplinas.length; i++) {
			disciplinaAux[i] = this.listaDisciplinas[i];
		}
		
		this.setListaDisciplinas(disciplinaAux);
		disciplinaAux = null;

		return this.getNome() + " foi matriculado na disciplina " + disciplina.getNomeDisciplina();
	}

	public String removerMatricula(Disciplina disciplina) {
		disciplina.removerAlunoDisciplina(this);

		return "Aluno foi removido da disciplina com sucesso";
	}
	
	/*esse m�todo coloca o aluno cadastrado na lista geral de todos os alunos que est� na classe Dados*/
	public void adicionarAlunoListaGeral() {
		//cria um arrau auxiliar com uma posi��o a mais que o array geral de alunos 
		Aluno listaAux[] = new Aluno[ListaGeralAlunos.getPosicaoUltimoAlunoAdd() + 1];
		
		//coloca todos os alunos que est�o no array geral no array auxiliar
		for(int i = 0; i < ListaGeralAlunos.getListaGeralAlunos().length; i++) {
			listaAux[i] = ListaGeralAlunos.getListaGeralAlunos()[i];
		}
		
		//coloca o aluno na �ltima posi��o do array auxiliar
		listaAux[ListaGeralAlunos.getPosicaoUltimoAlunoAdd()] = this;
		
		//aumentar +1 no �ltimo aluno adicionado
		ListaGeralAlunos.setPosicaoUltimoAlunoAdd(ListaGeralAlunos.getPosicaoUltimoAlunoAdd() + 1);
		
		//envia o novo array para a classe Dados
		ListaGeralAlunos.setListaGeralAlunos(listaAux);
		listaAux = null; //liberando espa�o da memoria
	}
	
	/*POLIMORFISMO*/
	@Override
	public String informacao() {
		/*returna o m�todo informacao que est� na classe pessoa + as informa��es do aluno*/
		return super.informacao() + "\nMatricula: " + this.getNumMatricula() + // o pr�prio cpf (sem pontos e tra�o)
				"\nStatus: " + this.isStatus() + "\nPer�odo: " + this.getPeriodo();
	}

	/*
	 * o aluno que seja fazer a inten��o de matricula tera que informar em qual
	 * cadeira deseja fazer a inte��o o intuito desse m�todo � apenas retornar a
	 * posi��o que o aluno ficaria caso fa�a a matricula ATEN��O: ESSE M�TODO N�O
	 * IRA MODIFICAR A LISTA DE ALUNOS MATRICULADOS
	 */
	public String fazerIntencaoMatricula(Disciplina disciplina) {
		Aluno listaAuxAlunos[] = disciplina.getListaAlunos();
		Aluno[] temp = new Aluno[disciplina.getUltimoAlunoMatriculado() + 1];

		/* criando mais uma posi��o no array listaAuxAlunos */
		for (int i = 0; i < listaAuxAlunos.length; i++) {
			temp[i] = listaAuxAlunos[i];
		}

		listaAuxAlunos = temp;
		temp = null;

		/* colocando aluno que quer fazer a inte��o na posi��o criada */
		listaAuxAlunos[disciplina.getUltimoAlunoMatriculado()] = this;

		/*
		 * ordenando a listaAuxAlunos para saber em que posi��o ele vai ficar caso fa�a
		 * a matricula no exato momento
		 */
		listaAuxAlunos = disciplina.ordenarAlunosDisciplina(listaAuxAlunos);

		/* esse metodo vai retornar uma string da posi��o dele */
		return this.verificarPosicaoAluno(listaAuxAlunos);
	}

	/*
	 * esse m�todo � private pq s� ser� utilizado pelo m�todo fazerIntencaoMatricula
	 */
	private String verificarPosicaoAluno(Aluno[] listaAlunos) {
		int posicaoAtual;
		boolean alunoExiste = false;

		// esse "for" vai rodar toda lista de alunos da disciplina at� que o numero de
		// matricula seja igual
		for (posicaoAtual = 0; posicaoAtual < listaAlunos.length; posicaoAtual++) {
			// se o numero de matricula for igual ele da um break no for
			if (listaAlunos[posicaoAtual].getNumMatricula().equals(this.getNumMatricula())) {
				alunoExiste = true;
				break;
			}
		}

		if (alunoExiste == true) {
			/*
			 * vai retornar a posi��o do for + 1 (pq come�a em 0) e o length da lista de
			 * alunos -1 � pq nessa lista esta o aluno que pediu a inten��o de matricula
			 */
			return "Posi��o Atual: " + (posicaoAtual + 1) + " de " + (listaAlunos.length - 1) + " vagas!";
		} else {
			return "Aluno ainda n�o foi matriculado";
		}
	}

	// ---------- GETTERS E SETTERS ------------------------
	
	public String getNumMatricula() {
		return numMatricula;
	}

	public void setNumMatricula(String numMatricula) {
		this.numMatricula = numMatricula;
		/*
		 * numMatricula = numMatricula.replaceAll("\\.", ""); this.numMatricula =
		 * numMatricula.replaceAll("-", ""); this.setLogin(this.numMatricula); // coloca
		 * o n�mero de matricula no login
		 */ }

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isStatus() {
		return status;
	}

	public void setRanking(float ranking) {
		this.ranking = ranking;
	}

	public double getRanking() {
		return ranking;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
	
	public Disciplina[] getListaDisciplinas() {
		return listaDisciplinas;
	}

	public void setListaDisciplinas(Disciplina disciplina) {
		this.listaDisciplinas[this.getUltimaDisciplinaMatriculada()] = disciplina;
		this.setUltimaDisciplinaMatriculada(this.getUltimaDisciplinaMatriculada() + 1);
	}
	
	public void setListaDisciplinas(Disciplina[] listaDisciplinas) {
		this.listaDisciplinas = listaDisciplinas;
	}

	public int getUltimaDisciplinaMatriculada() {
		return ultimaDisciplinaMatriculada;
	}

	public void setUltimaDisciplinaMatriculada(int ultimaDisciplinaMatriculada) {
		this.ultimaDisciplinaMatriculada = ultimaDisciplinaMatriculada;
	}

	public void setRanking(double ranking) {
		this.ranking = ranking;
	}
}
