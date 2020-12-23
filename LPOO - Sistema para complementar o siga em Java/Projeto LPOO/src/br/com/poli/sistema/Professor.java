package br.com.poli.sistema;

import br.com.poli.dados.ListaGeralProfessores;

public class Professor extends Pessoa {
	
	public Professor(String nome, String cpf) {
		super(nome, cpf);
	}
	
	public void adicionarProfessorListaGeral() {
		//cria um arrau auxiliar com uma posi��o a mais que o array geral de alunos 
		Professor listaAux[] = new Professor[ListaGeralProfessores.getPosicaoUltimoProfessor() + 1];
		
		//coloca todos os alunos que est�o no array geral no array auxiliar
		for(int i = 0; i < ListaGeralProfessores.getListaGeralProfessores().length; i++) {
			listaAux[i] = ListaGeralProfessores.getListaGeralProfessores()[i];
		}
		
		//coloca o aluno na �ltima posi��o do array auxiliar
		listaAux[ListaGeralProfessores.getPosicaoUltimoProfessor()] = this;
		
		//aumentar +1 no �ltimo aluno adicionado
		ListaGeralProfessores.setPosicaoUltimoProfessor(ListaGeralProfessores.getPosicaoUltimoProfessor() + 1);
		
		//envia o novo array para a classe Dados
		ListaGeralProfessores.setListaGeralProfessores(listaAux);
		listaAux = null; //liberando espa�o da memoria
	}

}
