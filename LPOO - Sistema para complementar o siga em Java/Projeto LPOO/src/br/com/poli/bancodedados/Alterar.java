package br.com.poli.bancodedados;

import java.sql.SQLException;
import java.sql.Statement;

public class Alterar {

	public void alterarAluno(String nome, String cpf, boolean status, double ranking, int periodo,
			String senha, String loginAntigo) {
		
		/* o login será alterado automaticamente, ao alterar o cpf você altera o login
		 * as duas linhas de código abaixo são para retirar os "." e "-" caso exista no cpf*/
		String login = cpf.replaceAll("\\.", "");
		login = cpf.replaceAll("-", "");
		
		/*0 = FALSE | 1 = TRUE, pois o banco de dados não aceita boolean como está explicado na classe Tabelas*/
		int statustabela = 0;
		
		if(status == true) {
			statustabela = 1;
		}
		
		/*inicia a conexão com o banco de dados*/
		Conexao conexao = new Conexao();

		/*cria o stamtemente com o banco de dados*/
		Statement stmt = conexao.criarStatement();

		/*criando o comando para ser realizado no bando de dados*/
		String sql = "UPDATE tbl_alunos" 
				   + " SET" 
				   + " nome = '" + nome + "',"
				   + " cpf = '" + cpf + "',"
				   + " status = '" + statustabela + "',"
				   + " ranking = '" + ranking + "',"
				   + " periodo = '" + periodo + "',"
				   + " login = '" + login + "',"
				   + " senha = '" + senha
				   + "' WHERE login = " + loginAntigo;
		
		try {
			System.out.println("estrou para alterar");
			/*executando o comando criado acima*/
			stmt.executeUpdate(sql);
			
		}catch(Exception e) {
			System.out.println("deu merdana alteração");
			System.err.println();
			
		}finally {
			
			try {
				/*fechando o que foi aberto anteriormente*/
				stmt.close();
				conexao.desconectar();
			}catch(SQLException ex) {
				System.err.println();
			}
			
		}
	}
	
	public void alterarProfessorCoordenador(String cargoAlteracao, String nome, String cpf, String senha) {
		
		/* o login será alterado automaticamente, ao alterar o cpf você altera o login
		 * as duas linhas de código abaixo são para retirar os "." e "-" caso exista no cpf*/
		String login = cpf.replaceAll("\\.", "");
		login = cpf.replaceAll("-", "");
		
		String tabela = null;
		
		/*esse if vai fazer com que a alteração seja direcionada ao banco de dados dos professores ou coordenadores*/
		if(cargoAlteracao.equals("Professor") || cargoAlteracao.equals("professor")) {
			tabela = "tbl_professores";
		}else if(cargoAlteracao.equals("Coordenador") || cargoAlteracao.equals("coordenador")) {
			tabela = "tbl_coordenadores";
		}
		
		/*inicia a conexão com o banco de dados*/
		Conexao conexao = new Conexao();

		/*cria o stamtemente com o banco de dados*/
		Statement stmt = conexao.criarStatement();

		/*criando o comando para ser realizado no bando de dados*/
		String sql = "UPDATE " + tabela 
				   + " SET" 
				   + " nome = '" + nome + "',"
				   + " cpf = '" + cpf + "',"
				   + " login = '" + login + "',"
				   + " senha = '" + senha
				   + "' WHERE login = " + login;
		
		try {
			/*executando o comando criado acima*/
			stmt.executeUpdate(sql);
			
		}catch(Exception e) {
			System.err.println();
			
		}finally {
			
			try {
				/*fechando o que foi aberto anteriormente*/
				stmt.close();
				conexao.desconectar();
			}catch(SQLException ex) {
				System.err.println();
			}
			
		}
	}

	public void alterarSenha(String login, String senha) throws SQLException {
		Buscar buscar = new Buscar();
		String tabela = null;
		
		if (buscar.buscarAluno(login) != null) {
			tabela = "tbl_alunos";
		}else if(buscar.buscarProfessor(login) != null) {
			tabela = "tbl_professores";
		}
		/*inicia a conexão com o banco de dados*/
		Conexao conexao = new Conexao();

		/*cria o stamtemente com o banco de dados*/
		Statement stmt = conexao.criarStatement();

		/*criando o comando para ser realizado no bando de dados*/
		String sql = "UPDATE " + tabela 
				   + " SET" 
				   + " senha = '" + senha
				   + "' WHERE login = " + login;
		
		try {
			/*executando o comando criado acima*/
			stmt.executeUpdate(sql);
			
		}catch(Exception e) {
			System.err.println();
			
		}finally {
			
			try {
				/*fechando o que foi aberto anteriormente*/
				stmt.close();
				conexao.desconectar();
			}catch(SQLException ex) {
				System.err.println();
			}
			
		}
	}
}
