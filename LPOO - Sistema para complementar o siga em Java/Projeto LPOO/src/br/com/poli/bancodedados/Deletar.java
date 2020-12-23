package br.com.poli.bancodedados;

import java.sql.Statement;

public class Deletar {

	public void deletarAluno(String numMatricula) {
		/*iniciando conexao com o banco de dados*/
		Conexao conexao = new Conexao();

		/*criando o statement para o banco de dados*/
		Statement stmt = conexao.criarStatement();

		/*criando comando que irá deletar a linha, a linha será achada através do número de matricula, que é igual ao login*/
		String sql = "DELETE FROM tbl_alunos"
				   + " WHERE login = '" + numMatricula + "';";

		try {
			/*executando o comando criando na string*/
			stmt.executeUpdate(sql);

		} catch (Exception e) {
			System.err.println();
		} finally {
			try {
				/*fechando o que foi aberto anteriormente*/
				stmt.close();
				conexao.desconectar();

			} catch (Exception e) {
				System.err.println();
			}
		}
	}
	
	public void deletarProfessor(String login) {
		/*iniciando conexao com o banco de dados*/
		Conexao conexao = new Conexao();

		/*criando o statement para o banco de dados*/
		Statement stmt = conexao.criarStatement();

		/*criando comando que irá deletar a linha, a linha será achada através do número de matricula, que é igual ao login*/
		String sql = "DELETE FROM tbl_professores"
				   + " WHERE login = '" + login + "';";

		try {
			/*executando o comando criando na string*/
			stmt.executeUpdate(sql);

		} catch (Exception e) {
			System.err.println();
		} finally {
			try {
				/*fechando o que foi aberto anteriormente*/
				stmt.close();
				conexao.desconectar();

			} catch (Exception e) {
				System.err.println();
			}
		}
	}
	
	public void deletarCoordenador(String login) {
		/*iniciando conexao com o banco de dados*/
		Conexao conexao = new Conexao();

		/*criando o statement para o banco de dados*/
		Statement stmt = conexao.criarStatement();

		/*criando comando que irá deletar a linha, a linha será achada através do número de matricula, que é igual ao login*/
		String sql = "DELETE FROM tbl_coordenadores"
				   + " WHERE login = '" + login + "';";

		try {
			/*executando o comando criando na string*/
			stmt.executeUpdate(sql);

		} catch (Exception e) {
			System.err.println();
		} finally {
			try {
				/*fechando o que foi aberto anteriormente*/
				stmt.close();
				conexao.desconectar();

			} catch (Exception e) {
				System.err.println();
			}
		}
	}
}