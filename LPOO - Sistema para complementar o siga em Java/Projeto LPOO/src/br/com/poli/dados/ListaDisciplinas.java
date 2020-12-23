package br.com.poli.dados;

import br.com.poli.sistema.Disciplina;

public abstract class ListaDisciplinas {
	private static int posicaoUltimaDisciplinaPrimeiro = 0;
	private static Disciplina listaDisciplinasPrimeiroPeriodo[] = new Disciplina[10];
	
	private static int posicaoUltimaDisciplinaSegundo = 0;
	private static Disciplina listaDisciplinasSegundoPeriodo[] = new Disciplina[10];
	
	/*metodo para procurar uma disciplina na lista de todos as disciplinas*/
	public Disciplina procurarDisciplina(String codigoDisciplina, int periodo) {
		int i;

		if (periodo == 1) {
			// vai varrer o array geral de disciplinas do primeiro periodo
			for (i = 0; i < listaDisciplinasPrimeiroPeriodo.length; i++) {
				// se a string informada for igual ao codigo da disciplina, retorna a disciplina
				if (listaDisciplinasPrimeiroPeriodo[i].getCodigoDisciplina().equals(codigoDisciplina)) {
					return listaDisciplinasPrimeiroPeriodo[i];
				}
			}
		} else if (periodo == 2) {
			// vai varrer o array geral de disciplinas do segundo periodo
			for (i = 0; i < listaDisciplinasSegundoPeriodo.length; i++) {
				// se a string informada for igual ao codigo da disciplina, retorna a disciplina
				if (listaDisciplinasSegundoPeriodo[i].getCodigoDisciplina().equals(codigoDisciplina)) {
					return listaDisciplinasSegundoPeriodo[i];
				}
			}
		}
		// caso não ache o aluno retorna null
		return null;
	}
	
	//----- GETTERS E SETTERS -----
	public static int getPosicaoUltimaDisciplinaPrimeiro() {
		return posicaoUltimaDisciplinaPrimeiro;
	}
	public static void setPosicaoUltimaDisciplinaPrimeiro(int posicaoUltimaDisciplinaPrimeiro) {
		ListaDisciplinas.posicaoUltimaDisciplinaPrimeiro = posicaoUltimaDisciplinaPrimeiro;
	}
	public static Disciplina[] getListaDisciplinasPrimeiroPeriodo() {
		return listaDisciplinasPrimeiroPeriodo;
	}
	public static void setListaDisciplinasPrimeiroPeriodo(Disciplina[] listaDisciplinasPrimeiroPeriodo) {
		ListaDisciplinas.listaDisciplinasPrimeiroPeriodo = listaDisciplinasPrimeiroPeriodo;
	}
	public static int getPosicaoUltimaDisciplinaSegundo() {
		return posicaoUltimaDisciplinaSegundo;
	}
	public static void setPosicaoUltimaDisciplinaSegundo(int posicaoUltimaDisciplinaSegundo) {
		ListaDisciplinas.posicaoUltimaDisciplinaSegundo = posicaoUltimaDisciplinaSegundo;
	}
	public static Disciplina[] getListaDisciplinasSegundoPeriodo() {
		return listaDisciplinasSegundoPeriodo;
	}
	public static void setListaDisciplinasSegundoPeriodo(Disciplina[] listaDisciplinasSegundoPeriodo) {
		ListaDisciplinas.listaDisciplinasSegundoPeriodo = listaDisciplinasSegundoPeriodo;
	}	
}
