package br.com.poli.dados;

import br.com.poli.sistema.Professor;

public abstract class ListaGeralProfessores {
	private static int posicaoUltimoProfessor = 0;
	private static Professor listaGeralProfessores[] = new Professor[1];

	/* método responsavel por procurar professor na lista geral de professores */
	public static Professor procurarProfessor(String cpfSemPontos) {
		int i;

		// vai varrer o array geral dos professores atrás do pprofessor
		for (i = 0; i < listaGeralProfessores.length; i++) {
			if (listaGeralProfessores[i] != null) {
				// se a string informada for igual cpf do professor sem pontos, retorna o
				// professor
				if (listaGeralProfessores[i].getCpf().equals(cpfSemPontos)) {
					return listaGeralProfessores[i];
				}
			}
		}
		// caso não ache o professor retorna null
		return null;
	}

	// ----- GETTERS E SETTERS -----
	public static int getPosicaoUltimoProfessor() {
		return posicaoUltimoProfessor;
	}

	public static void setPosicaoUltimoProfessor(int posicaoUltimoProfessor) {
		ListaGeralProfessores.posicaoUltimoProfessor = posicaoUltimoProfessor;
	}

	public static Professor[] getListaGeralProfessores() {
		return listaGeralProfessores;
	}

	public static void setListaGeralProfessores(Professor[] listaGeralProfessores) {
		ListaGeralProfessores.listaGeralProfessores = listaGeralProfessores;
	}
}
