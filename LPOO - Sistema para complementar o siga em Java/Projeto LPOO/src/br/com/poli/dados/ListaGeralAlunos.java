package br.com.poli.dados;

import br.com.poli.sistema.Aluno;

public abstract class ListaGeralAlunos {
	private static int posicaoUltimoAlunoAdd = 0;
	private static Aluno listaGeralAlunos[] = new Aluno[1];

	public static void printarListaAlunosGeral() {
		for (int i = 0; i < listaGeralAlunos.length; i++) {
			System.out.println(listaGeralAlunos[i].getNome());
		}
		System.out.println("POSIÇÕES DO ARRAY: " + listaGeralAlunos.length);
	}

	/* método responsavel por procurar um aluno na lista geral de alunos */
	public static Aluno procurarAluno(String numMatricula) {
		int i;

		// vai varrer o array geral de alunos a procura do aluno
		for (i = 0; i < listaGeralAlunos.length; i++) {
			if (listaGeralAlunos[i] != null) {
				// se a string informada for igual ao número de matricula do aluno, retorna o
				// aluno
				if (listaGeralAlunos[i].getNumMatricula().equals(numMatricula)) {
					return listaGeralAlunos[i];
				}
			}
		}
		// caso não ache o aluno retorna null
		return null;
	}

	// ----- GETTERS E SETTERS -----
	public static int getPosicaoUltimoAlunoAdd() {
		return posicaoUltimoAlunoAdd;
	}

	public static void setPosicaoUltimoAlunoAdd(int posicaoUltimoAlunoAdd) {
		ListaGeralAlunos.posicaoUltimoAlunoAdd = posicaoUltimoAlunoAdd;
	}

	public static Aluno[] getListaGeralAlunos() {
		return listaGeralAlunos;
	}

	public static void setListaGeralAlunos(Aluno[] listaGeralAlunos) {
		ListaGeralAlunos.listaGeralAlunos = listaGeralAlunos;
	}
}
