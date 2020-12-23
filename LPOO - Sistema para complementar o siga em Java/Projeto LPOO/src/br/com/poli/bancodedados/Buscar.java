package br.com.poli.bancodedados;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.poli.sistema.Aluno;
import br.com.poli.sistema.Coordenador;
import br.com.poli.sistema.Disciplina;
import br.com.poli.sistema.Professor;

public class Buscar {

	public Aluno buscarAluno(String login) throws SQLException {
		/* abri o banco de dados */
		Conexao conexao = new Conexao();

		Statement stmt = conexao.criarStatement();

		/*
		 * qual informação você quer buscar? nesse caso ele quer buscar pelo login que
		 * nesse caso é igual ao número de matricula
		 */
		String sql = "SELECT * " + " FROM tbl_alunos" + " WHERE login = " + login + ";";
		try {
			/*
			 * executa o comando da String sql, ou seja, busca na tbl_alunos a linha que
			 * corresponde ao número de matricula
			 */
			ResultSet resultSet = stmt.executeQuery(sql);

			/*
			 * se o resultSet for igual a null ele vai returnar null pois não existe aluno
			 */
			if (resultSet == null) {
				return null;
			}

			boolean status = false;

			/*
			 * como o banco de dados não armazena boolean, foi armazenado 1 para true e 0
			 * para false
			 */
			if (resultSet.getInt("status") == 1) {
				status = true;
			}

			/* cria o aluno e coloca as informações que o resultSet tem armazenado */
			Aluno aluno = new Aluno(resultSet.getString("nome"), resultSet.getString("cpf"), status,
					resultSet.getFloat("ranking"), resultSet.getInt("periodo"));
			aluno.setLogin(resultSet.getString("login"));
			aluno.setSenha(resultSet.getString("senha"));

			resultSet.close();

			return aluno;

		} catch (SQLException e) {
			System.err.println();
			/*
			 * finally é utilizado para como "final" para fechar o que foi aberto
			 * anteriormente
			 */
		} finally {
			stmt.close();
			conexao.desconectar();
		}
		return null;
	}

	public Professor buscarProfessor(String login) throws SQLException {
		/* abri o banco de dados */
		Conexao conexao = new Conexao();

		ResultSet resultSet = null;
		Statement stmt = conexao.criarStatement();

		/*
		 * qual informação você quer buscar? nesse caso ele quer buscar pelo login que
		 * nesse caso é igual ao número de matricula
		 */
		String sql = "SELECT * " + " FROM tbl_professores" + " WHERE login = " + login + ";";
		try {
			/*
			 * executa o comando da String sql, ou seja, busca na tbl_alunos a linha que
			 * corresponde ao número de matricula
			 */
			resultSet = stmt.executeQuery(sql);

			/*
			 * se o resultSet for igual a null ele vai returnar null pois não existe aluno
			 */
			if (resultSet == null) {
				return null;
			}

			/* cria o professor e coloca as informações que o resultSet tem armazenado */
			Professor professor = new Professor(resultSet.getString("nome"), resultSet.getString("cpf"));
			professor.setLogin(resultSet.getString("login"));
			professor.setSenha(resultSet.getString("senha"));

			return professor;

		} catch (SQLException e) {
			System.err.println();
			/*
			 * finally é utilizado para como "final" para fechar o que foi aberto
			 * anteriormente
			 */
		} finally {
			stmt.close();
			resultSet.close();
			conexao.desconectar();
		}
		return null;
	}

	public Professor buscarProfessorNome(String nome) throws SQLException {
		/* abri o banco de dados */
		Conexao conexao = new Conexao();

		ResultSet resultSet = null;
		Statement stmt = conexao.criarStatement();

		/*
		 * qual informação você quer buscar? nesse caso ele quer buscar pelo login que
		 * nesse caso é igual ao número de matricula
		 */
		String sql = "SELECT * " + " FROM tbl_professores" + " WHERE nome = '" + nome + "';";
		try {
			/*
			 * executa o comando da String sql, ou seja, busca na tbl_alunos a linha que
			 * corresponde ao número de matricula
			 */
			resultSet = stmt.executeQuery(sql);

			/*
			 * se o resultSet for igual a null ele vai returnar null pois não existe aluno
			 */
			if (resultSet == null) {
				return null;
			}

			/* cria o professor e coloca as informações que o resultSet tem armazenado */
			Professor professor = new Professor(resultSet.getString("nome"), resultSet.getString("cpf"));
			professor.setLogin(resultSet.getString("login"));
			professor.setSenha(resultSet.getString("senha"));

			resultSet.close();
			
			return professor;

		} catch (SQLException e) {
			System.err.println();
			/*
			 * finally é utilizado para como "final" para fechar o que foi aberto
			 * anteriormente
			 */
		} finally {
			stmt.close();
			conexao.desconectar();
			
			
		}
		return null;
	}

	public Coordenador buscarCoordenador(String login) throws SQLException {
		/* abri o banco de dados */
		Conexao conexao = new Conexao();

		ResultSet resultSet = null;
		Statement stmt = conexao.criarStatement();

		/*
		 * qual informação você quer buscar? nesse caso ele quer buscar pelo login que
		 * nesse caso é igual ao número de matricula
		 */
		String sql = "SELECT * " + " FROM tbl_coordenadores" + " WHERE login = " + login + ";";
		try {
			/*
			 * executa o comando da String sql, ou seja, busca na tbl_alunos a linha que
			 * corresponde ao número de matricula
			 */
			resultSet = stmt.executeQuery(sql);
			
			/*
			 * se o resultSet for igual a null ele vai returnar null pois não existe
			 */
			if (resultSet == null) {
				return null;
			}

			/* cria o coordenador e coloca as informações que o resultSet tem armazenado */
			Coordenador coordenador = new Coordenador(resultSet.getString("nome"), resultSet.getString("cpf"));
			coordenador.setLogin(resultSet.getString("login"));
			coordenador.setSenha(resultSet.getString("senha"));

			return coordenador;

		} catch (SQLException e) {
			System.err.println();
			/*
			 * finally é utilizado para como "final" para fechar o que foi aberto
			 * anteriormente
			 */
		} finally {
			stmt.close();
			resultSet.close();
			conexao.desconectar();
		}
		return null;
	}

	public Disciplina buscarDisciplina(String codigo) throws SQLException {
		/* abri o banco de dados */
		Conexao conexao = new Conexao();

		ResultSet resultSet = null;
		Statement stmt = conexao.criarStatement();

		/*
		 * qual informação você quer buscar? nesse caso ele quer buscar pelo login que
		 * nesse caso é igual ao número de matricula
		 */
		String sql = "SELECT * " + " FROM tbl_disciplinas" + " WHERE codigo = " + codigo + ";";
		try {
			/*
			 * executa o comando da String sql, ou seja, busca na tbl_alunos a linha que
			 * corresponde ao número de matricula
			 */
			resultSet = stmt.executeQuery(sql);
			
			/*
			 * se o resultSet for igual a null ele vai returnar null pois não existe aluno
			 */
			if (resultSet == null) {
				return null;
			}
			
			Professor professor = this.buscarProfessorNome(resultSet.getString("professor"));
			/*
			 * (String nomeDisciplina, String codigoDisciplina, int numTotalAlunos, String
			 * horarioDisciplina, Professor professor, int periodoDisiciplina)
			 */
			/* cria o coordenador e coloca as informações que o resultSet tem armazenado */
			Disciplina disciplina = new Disciplina(resultSet.getString("nome"), resultSet.getString("codigo"),
					resultSet.getInt("vagas"), resultSet.getString("horario"), professor,
					resultSet.getInt("periodo"));

			resultSet.close();
			
			return disciplina;

		} catch (SQLException e) {
			System.err.println();
			/*
			 * finally é utilizado para como "final" para fechar o que foi aberto
			 * anteriormente
			 */
		} finally {
			stmt.close();
			conexao.desconectar();
		}
		return null;
	}

	/* MÉTODO PARA O USUÁRIO NÃO ACESSAR MAIS DE UMA VEZ O PRIMEIRO ACESSO */
	public boolean verificaSenhaAlterada(String login) throws SQLException {
		Conexao conexao = new Conexao();

		ResultSet resultSet = null;
		Statement stmt = conexao.criarStatement();

		String tabela = null;

		/*
		 * vamos chamar o método logar que está na classe Login para saber se é aluno,
		 * professor ou coordenador
		 */
		if (this.buscarAluno(login) != null) {
			tabela = "tbl_alunos";
		} else if (this.buscarProfessor(login) != null) {
			tabela = "tbl_professores";
		} else if (this.buscarCoordenador(login) != null) {
			tabela = "tbl_coordenadores";
		}
		/*
		 * qual informação você quer buscar? nesse caso ele quer buscar pelo login que
		 * nesse caso é igual ao número de matricula
		 */
		String sql = "SELECT * " + " FROM " + tabela + " WHERE login = " + login + ";";

		try {
			/*
			 * executa o comando da String sql, ou seja, busca na tbl_alunos a linha que
			 * corresponde ao número de matricula
			 */
			resultSet = stmt.executeQuery(sql);

			/*
			 * se a senha for diferente de null ele vai retornar true, ou seja, já foi
			 * alterada uma vez
			 */
			if (resultSet.getString("senha").equals("null")) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			System.err.println();
			/*
			 * finally é utilizado para como "final" para fechar o que foi aberto
			 * anteriormente
			 */
		} finally {
			stmt.close();
			resultSet.close();
			conexao.desconectar();
		}
		return true;
	}
}
