package br.com.poli.sistema;

import br.com.poli.dados.ListaDisciplinas;

public class Disciplina {
	private String nomeDisciplina;
	private String codigoDisciplina;
	private String horarioDisciplina;
	private int numVagasAlunos;
	private int ultimoAlunoMatriculado;
	private Aluno listaAlunos[];
	private Professor professor;
	private int periodoDisciplina;

	public Disciplina(String nomeDisciplina, String codigoDisciplina, int numTotalAlunos, String horarioDisciplina,
			Professor professor, int periodoDisiciplina) {
		this.nomeDisciplina = nomeDisciplina;
		this.codigoDisciplina = codigoDisciplina;
		this.numVagasAlunos = numTotalAlunos;
		this.horarioDisciplina = horarioDisciplina; // inserir dia(hora)
		this.ultimoAlunoMatriculado = 0;
		this.listaAlunos = new Aluno[1];
		this.professor = professor;
		this.periodoDisciplina = periodoDisiciplina;

	}

	public String informacaoDisciplina() {
		return "------ STATUS DISCIPLINA ------\n" + "Disciplina: " + this.getNomeDisciplina() + "\nCódigo: "
				+ this.getCodigoDisciplina() + "\nProfessor: " + this.getProfessor().getNome() + "\nDia (Hora): "
				+ this.getHorarioDisciplina() + "\nNúmero de Vagas: " + this.getNumVagasAlunos() +
				// o -1 é pq o ultimoAlunoMatriculado foi adicionado mais 1 após a matricula do
				// último aluno
				"\nAlunos Matriculados: " + this.ultimoAlunoMatriculado;
	}

	public String alterarProfessorDisciplina(Professor professor) {
		this.setProfessor(professor);

		return "Professor alterado para " + professor.getNome();
	}

		/*
	 * Metodo para adicionar a disciplina ao array geral de disciplina que está
	 * localizada em dados
	 */
	public void adicionarDisciplinaListaGeral() {
		// se a disciplina for do primeiro período
		if (this.periodoDisciplina == 1) {
			// cria um arrau auxiliar com uma posição a mais que o array geral de alunos
			Disciplina listaAux[] = new Disciplina[ListaDisciplinas.getPosicaoUltimaDisciplinaPrimeiro() + 1];

			// coloca todos os alunos que estão no array geral no array auxiliar
			for (int i = 0; i < ListaDisciplinas.getListaDisciplinasPrimeiroPeriodo().length; i++) {
				listaAux[i] = ListaDisciplinas.getListaDisciplinasPrimeiroPeriodo()[i];
			}

			// coloca o aluno na última posição do array auxiliar
			listaAux[ListaDisciplinas.getPosicaoUltimaDisciplinaPrimeiro()] = this;

			// aumentar +1 no último aluno adicionado
			ListaDisciplinas
					.setPosicaoUltimaDisciplinaPrimeiro(ListaDisciplinas.getPosicaoUltimaDisciplinaPrimeiro() + 1);

			// envia o novo array para a classe Dados
			ListaDisciplinas.setListaDisciplinasPrimeiroPeriodo(listaAux);
			listaAux = null; // liberando espaço da memoria

			// se a disciplina for do segundo periodo
		} else if (this.periodoDisciplina == 2) {
			// cria um arrau auxiliar com uma posição a mais que o array geral de alunos
			Disciplina listaAux[] = new Disciplina[ListaDisciplinas.getPosicaoUltimaDisciplinaSegundo() + 1];

			// coloca todos os alunos que estão no array geral no array auxiliar
			for (int i = 0; i < ListaDisciplinas.getListaDisciplinasSegundoPeriodo().length; i++) {
				listaAux[i] = ListaDisciplinas.getListaDisciplinasSegundoPeriodo()[i];
			}

			// coloca o aluno na última posição do array auxiliar
			listaAux[ListaDisciplinas.getPosicaoUltimaDisciplinaSegundo()] = this;

			// aumentar +1 no último aluno adicionado
			ListaDisciplinas
					.setPosicaoUltimaDisciplinaSegundo(ListaDisciplinas.getPosicaoUltimaDisciplinaSegundo() + 1);

			// envia o novo array para a classe Dados
			ListaDisciplinas.setListaDisciplinasSegundoPeriodo(listaAux);
			listaAux = null; // liberando espaço da memoria

		}
	}

	/* é responsavel por aumentar o número de vagas de uma disciplina */
	public int adicionarNumVagasDisciplina(int numVagasAdicionais) {
		/*
		 * envia para o atributo numVagasAlunos o valor atual + o num de vagas que
		 * deseja adicionar
		 */
		this.setNumVagasAlunos(getNumVagasAlunos() + numVagasAdicionais);
		return getNumVagasAlunos() + numVagasAdicionais;
	}

	/* esse metodo remove um aluno da lista de aluno da disciplina */
	public void removerAlunoDisciplina(Aluno aluno) {
		int i, j;

		for (i = 0; i < this.listaAlunos.length; i++) {
			if (this.listaAlunos[i] == aluno) {
				this.listaAlunos[i] = null;

				for (j = i; j < this.listaAlunos.length; j++) {
					if (j == this.listaAlunos.length - 1) {
						this.listaAlunos[j] = null;
						this.setUltimoAlunoMatriculado(this.getUltimoAlunoMatriculado() - 1);
						break;
					} else {
						this.listaAlunos[j] = this.listaAlunos[j + 1];
					}
				}
			}
		}

		// algoritmo para remover a posição de ficou vazia no array
		Aluno[] temp = new Aluno[this.getUltimoAlunoMatriculado()];

		for (i = 0; i < this.getUltimoAlunoMatriculado(); i++) {
			temp[i] = this.listaAlunos[i];
		}

		this.listaAlunos = temp;
		temp = null;
	}

	// método printa todos os alunos MATRICULADOS NA DISCIPLINA
	public String printarAlunosOrdenados() {
		int i;
		/* essa string vai servir para return a lista de alunos matriculados */
		String aux = null;

		/* se o nº de vagas for MENOR que o nº total do array */
		if (this.getNumVagasAlunos() < (this.getUltimoAlunoMatriculado())) {
			/* colocando a primeira linha na string aux */
			aux = "Com vaga para os seguintes alunos:\n";
			/*
			 * a cada passagem pelo for, vai ser ADICIONADO (por isso o +=) o aluno na
			 * string aux
			 */
			for (i = 0; i < this.getNumVagasAlunos(); i++) {
				aux += (i + 1) + ". " + this.listaAlunos[i].getNome() + "(" + this.listaAlunos[i].getNumMatricula()
						+ ")" + "\t" + this.listaAlunos[i].getRanking() + "\t" + this.listaAlunos[i].isStatus() + "\n";
			}

			/*
			 * agora vai adicionar os alunos que não conseguiram vagas, no for vai acontecer
			 * a mesma coisa
			 */
			aux += "\nSem vaga para os seguintes alunos:\n";
			for (i = this.getNumVagasAlunos(); i < this.listaAlunos.length; i++) {
				if (this.listaAlunos[i] != null) {
					aux += (i + 1) + ". " + this.listaAlunos[i].getNome() + "(" + this.listaAlunos[i].getNumMatricula()
							+ ")" + "\t" + this.listaAlunos[i].getRanking() + "\t" + this.listaAlunos[i].isStatus()
							+ "\n";
				}
			}
			/*
			 * se o nº de vagas for IGUAL ou MAIOR que o nº total de alunos que desejam a
			 * cadeira
			 */
		} else if (this.getNumVagasAlunos() == (this.ultimoAlunoMatriculado)
				|| this.getNumVagasAlunos() > (this.ultimoAlunoMatriculado)) {
			/* cria a primeira linha da string aux */
			aux = "Todos os alunos conseguiram vaga:\n";
			/*
			 * a cada passagem pelo for, vai ser ADICIONADO (por isso o +=) o aluno na
			 * string aux
			 */
			for (i = 0; i < this.getNumVagasAlunos(); i++) {
				/*
				 * se a posição do array for null, sai do for, se não adiciona o aluno a string
				 */
				if (this.listaAlunos[i] == null) {
					break;
				} else {
					aux += (i + 1) + ". " + this.listaAlunos[i].getNome() + "(" + this.listaAlunos[i].getNumMatricula()
							+ ")" + "\t" + this.listaAlunos[i].getRanking() + "\t" + this.listaAlunos[i].isStatus()
							+ "\n";
				}
			}
		}
		return aux;
	}

	// metodo private pq só é usutizado dentro do metodo ordenarAlunosDisciplina
	private void algoritmoOrdenacao(Aluno[] aluno) {
		Aluno aux = null;

		for (int i = 0; i < aluno.length; i++) { // função para ordenar
			for (int j = 0; j < aluno.length; j++) {
				if (aluno[j] == null || (j + 1) == aluno.length) {
					break;
				} else if (aluno[j].getRanking() < aluno[j + 1].getRanking()) {
					aux = aluno[j];
					aluno[j] = aluno[j + 1];
					aluno[j + 1] = aux;
				}
			}
		}
	}

	/* metodo principal do projeto, faz a ordenação por nota e depois por blocado e desblocado */
	public Aluno[] ordenarAlunosDisciplina(Aluno[] listaAlunos) {
		int i = 0;
		int j = 0;
		int alunosBlocados = 0;
		int alunosDesblocados = 0;

		for (i = 0; i < listaAlunos.length; i++) {
			if (listaAlunos[i].isStatus() == true) {
				alunosBlocados++;
			} else if (listaAlunos[i].isStatus() == false) {
				alunosDesblocados++;
			}
		}

		Aluno listaBlocados[] = new Aluno[alunosBlocados];
		Aluno listaDesblocados[] = new Aluno[alunosDesblocados];

		for (i = 0; i < listaAlunos.length; i++) {
			if (listaAlunos[i].isStatus() == true) {
				listaBlocados[j] = listaAlunos[i];
				j++;
			}
		}

		j = 0;

		for (i = 0; i < listaAlunos.length; i++) {
			if (listaAlunos[i].isStatus() == false) {
				listaDesblocados[j] = listaAlunos[i];
				j++;
			}
		}

		this.algoritmoOrdenacao(listaBlocados);
		this.algoritmoOrdenacao(listaDesblocados);

		for (i = 0; i < alunosBlocados; i++) {
			listaAlunos[i] = listaBlocados[i];
		}

		for (j = 0; j < alunosDesblocados; j++) {
			listaAlunos[i] = listaDesblocados[j];
			i++;
		}
		return listaAlunos;
	}

	/* o metodo retorna apenas o array de alunos da disciplina */
	public String alunosMatriculados() {
		/* criando a primeira linha da string que sera retornada no final */
		String aux = "Nome Aluno(matricula)\tRanking\tStatus\n";

		/*
		 * a cada passada no for vai ser ADICIONADO (por isso o +=) a String o aluno
		 * matriculado
		 */
		for (int i = 0; i < this.getUltimoAlunoMatriculado(); i++) {
			/* VAI SAIR ASSIM: Nome Aluno(matricula) Ranking Status */
			aux += i + 1 + ". " + this.listaAlunos[i].getNome() + "(" + this.listaAlunos[i].getNumMatricula() + ")"
					+ "\t" + this.listaAlunos[i].getRanking() + "\t" + this.listaAlunos[i].isStatus() + "\n";
		}
		return aux;
	}

	// metodo só returna o número de vagas disponiveis na cadeira
	public int numeroVagasDisciplina() {
		return this.getNumVagasAlunos();
	}

	public String numeroVagasDisponiveis() {
		int vagas = 0;

		if (this.getListaAlunos().length > this.getNumVagasAlunos()
				|| this.getListaAlunos().length == this.getNumVagasAlunos()) {
			vagas = 0;
		} else if (this.getListaAlunos().length < this.getNumVagasAlunos()) {
			vagas = this.getNumVagasAlunos() - this.getListaAlunos().length;
		}
		return "VAGAS DISPONIVEIS: " + vagas;
	}

	// ---------- GETTERS E SETTERS ------------------------
	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public String getCodigoDisciplina() {
		return codigoDisciplina;
	}

	public void setCodigoDisciplina(String codigoDisciplina) {
		this.codigoDisciplina = codigoDisciplina;
	}

	public String getHorarioDisciplina() {
		return horarioDisciplina;
	}

	public void setHorarioDisciplina(String horarioDisciplina) {
		this.horarioDisciplina = horarioDisciplina;
	}

	public int getPeriodoDisciplina() {
		return periodoDisciplina;
	}

	public void setPeriodoDisciplina(int periodoDisiciplina) {
		this.periodoDisciplina = periodoDisiciplina;
	}

	public int getNumVagasAlunos() {
		return numVagasAlunos;
	}

	public void setNumVagasAlunos(int numVagasAlunos) {
		this.numVagasAlunos = numVagasAlunos;
	}

	public int getUltimoAlunoMatriculado() {
		return ultimoAlunoMatriculado;
	}

	public void setUltimoAlunoMatriculado(int ultimoAlunoMatriculado) {
		this.ultimoAlunoMatriculado = ultimoAlunoMatriculado;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Aluno[] getListaAlunos() {
		return listaAlunos;
	}

	/*envia um aluno para a lista de alunos*/
	public void setListaAlunos(Aluno aluno) {
		this.listaAlunos[this.getUltimoAlunoMatriculado()] = aluno;
		this.setUltimoAlunoMatriculado(this.getUltimoAlunoMatriculado() + 1);
	}

	/*envia um novo array para a lista de alunos*/
	public void setListaAlunos(Aluno[] listaAlunos) {
		this.listaAlunos = listaAlunos;
	}
}