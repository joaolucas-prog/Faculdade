package br.com.poli.dados;

import br.com.poli.sistema.Coordenador;

public abstract class ListaGeralCoordenador {
	private static int posicaoUltimoCoordenador = 0;
	private static Coordenador listaGeralCoordenadores[] = new Coordenador[1];
	
	/* método responsavel por procurar professor na lista geral de professores */
	public static Coordenador procurarCoordenador(String cpfSemPontos) {
		int i;

		// vai varrer o array geral dos professores atrás do pprofessor
		for (i = 0; i < listaGeralCoordenadores.length; i++) {
			if (listaGeralCoordenadores[i] != null) {
				// se a string informada for igual cpf do professor sem pontos, retorna o
				// professor
				if (listaGeralCoordenadores[i].getCpf().equals(cpfSemPontos)) {
					return listaGeralCoordenadores[i];
				}
			}
		}
		// caso não ache o professor retorna null
		return null;
	}
	
	// ----- GETTERS E SETTERS -----
	public static int getPosicaoUltimoCoordenador() {
		return posicaoUltimoCoordenador;
	}
	public static void setPosicaoUltimoCoordenador(int posicaoUltimoCoordenador) {
		ListaGeralCoordenador.posicaoUltimoCoordenador = posicaoUltimoCoordenador;
	}
	public static Coordenador[] getListaGeralCoordenadores() {
		return listaGeralCoordenadores;
	}
	public static void setListaGeralCoordenadores(Coordenador[] listaGeralCoordenadores) {
		ListaGeralCoordenador.listaGeralCoordenadores = listaGeralCoordenadores;
	}
}
