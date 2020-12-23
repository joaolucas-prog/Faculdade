package br.com.poli.bancodedados;

import java.sql.SQLException;
import java.sql.Statement;

public class Tabelas {

	/* criando a tabela para os alunos */
	public void criarTabelaAlunos() {
		/*
		 * a tabela será composta por String nome | String cpf | int status, ou seja 1 =
		 * TRUE e 0 = FALSE (SUBSTITUI boolean status) | double ranking | int periodo |
		 * String login | String senha
		 */
		String sql = "CREATE TABLE IF NOT EXISTS tbl_alunos"
					+ "("
					+ "id integer PRIMARY KEY AUTOINCREMENT NOT NULL,"
					+ "nome STRING," 
					+ "cpf text," 
					+ "status integer," 
					+ "ranking REAL," 
					+ "periodo integer,"
					+ "login text," 
					+ "senha STRING" 
					+ ");";

		try {
			/*abrindo o banco de dados*/
			Conexao conexao = new Conexao();
			
			/*cria o statement*/
			Statement stmt = conexao.criarStatement();

			/*executa o stetament com a String sql criada acima*/
			stmt.execute(sql);
			
			/*desconecta o banco de dados*/
			conexao.desconectar();
		} catch (SQLException e) {
			System.err.println();
		}

	}
	
	/* criando a tabela para os professores */
	public void criarTabelaProfessores() {
		/*
		 * a tabela será composta por String nome | String cpf | 
		 * String login | String senha
		 */
		String sql = "CREATE TABLE IF NOT EXISTS tbl_professores"
					+ "("
					+ "id integer PRIMARY KEY AUTOINCREMENT NOT NULL,"
					+ "nome STRING," 
					+ "cpf text,"
					+ "login text," 
					+ "senha STRING" 
					+ ");";

		try {
			/*abrindo o banco de dados*/
			Conexao conexao = new Conexao();
			
			/*cria o statement*/
			Statement stmt = conexao.criarStatement();

			/*executa o stetament com a String sql criada acima*/
			stmt.execute(sql);
			
			/*desconecta o banco de dados*/
			conexao.desconectar();
		} catch (SQLException e) {
			System.err.println();
		}

	}
	
	/* criando a tabela para os coordenadores */
	public void criarTabelaCoordenadores() {
		/*
		 * a tabela será composta por String nome | String cpf | 
		 * String login | String senha
		 */
		String sql = "CREATE TABLE IF NOT EXISTS tbl_coordenadores"
					+ "("
					+ "id integer PRIMARY KEY AUTOINCREMENT NOT NULL,"
					+ "nome STRING," 
					+ "cpf text,"
					+ "login text," 
					+ "senha STRING" 
					+ ");";

		try {
			/*abrindo o banco de dados*/
			Conexao conexao = new Conexao();
			
			/*cria o statement*/
			Statement stmt = conexao.criarStatement();

			/*executa o stetament com a String sql criada acima*/
			stmt.execute(sql);
			
			/*desconecta o banco de dados*/
			conexao.desconectar();
		} catch (SQLException e) {
			System.err.println();
		}

	}

	public void criarTabelaDisciplina() {
		/*
		 * a tabela será composta por String nome | String codigo | 
		 * int vagas | String horario | String professor | int periodo
		 */
		String sql = "CREATE TABLE IF NOT EXISTS tbl_disciplinas"
					+ "("
					+ "id integer PRIMARY KEY AUTOINCREMENT NOT NULL,"
					+ "nome STRING," 
					+ "codigo text,"
					+ "vagas integer," 
					+ "horario text," 
					+ "professor text," 
					+ "periodo integer" 
					+ ");";

		try {
			/*abrindo o banco de dados*/
			Conexao conexao = new Conexao();
			
			/*cria o statement*/
			Statement stmt = conexao.criarStatement();

			/*executa o stetament com a String sql criada acima*/
			stmt.execute(sql);
			
			/*desconecta o banco de dados*/
			conexao.desconectar();
		} catch (SQLException e) {
			System.err.println();
		}

	}
	
	public void criarTabelaDisciplina(String codigo) {
		/*
		 * a tabela será composta apenas pelo cpf dos alunos
		 */		
		String sql = "CREATE TABLE IF NOT EXISTS tbl_disciplina_" + codigo
					+ "("
					+ "codigoalunos text"
					+ ");";

		try {
			/*abrindo o banco de dados*/
			Conexao conexao = new Conexao();
			
			/*cria o statement*/
			Statement stmt = conexao.criarStatement();

			/*executa o stetament com a String sql criada acima*/
			stmt.execute(sql);
			
			/*desconecta o banco de dados*/
			conexao.desconectar();
		} catch (SQLException e) {
			System.err.println();
		}
	}
}
