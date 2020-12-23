package br.com.poli.view;

import java.sql.SQLException;

import br.com.poli.bancodedados.Buscar;
import br.com.poli.sistema.Aluno;
import br.com.poli.sistema.Coordenador;
import br.com.poli.sistema.Professor;

public class Login {

	public static String logar(String login, String senha) throws SQLException {
		String resultado = null;
		Professor professor = null;
		Aluno aluno = null;

		Buscar buscar = new Buscar();
		/* vai retornar o professor, se não existir, retorna null */

		Coordenador coordenador = buscar.buscarCoordenador(login);
		if (coordenador != null) {
			if (coordenador.verificarInformacoesLogin(login, senha)) {
				resultado = "Coordenador";
			}
		} else {
			professor = buscar.buscarProfessor(login);
			if (professor != null) {
				if (professor.verificarInformacoesLogin(login, senha)) {
					resultado = "Professor";
				}

			} else {
				aluno = buscar.buscarAluno(login);
				if (aluno != null) {
					if (aluno.verificarInformacoesLogin(login, senha)) {
						resultado = "Aluno";
					}
				}
			}
		}
		return resultado;
	}
}