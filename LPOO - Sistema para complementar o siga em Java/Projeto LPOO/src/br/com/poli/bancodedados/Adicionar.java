package br.com.poli.bancodedados;

import java.sql.SQLException;
import java.sql.Statement;

import br.com.poli.sistema.Aluno;
import br.com.poli.sistema.Coordenador;
import br.com.poli.sistema.Disciplina;
import br.com.poli.sistema.Professor;

public class Adicionar {
	Buscar buscar = new Buscar();

	/* adicionando aluno ao banco de dados */
	public void adicinarAluno(Aluno aluno) throws SQLException {
		/* abrindo o banco de dados */
		Conexao conexao = new Conexao();

		/* s� entra se a pessoa adicionada ainda n�o existe no banco de dados */
		if (buscar.buscarAluno(aluno.getLogin()) == null) {

			try {
				/* cria o statement */
				Statement stmt = conexao.criarStatement();

				/* para substituir o boolean status */
				int blocado = 0;

				/*
				 * se o status for true ele coloca 1, se n�o fica 0 (false) como j� foi
				 * instanciado
				 */
				if (aluno.isStatus()) {
					blocado = 1;
				}

				/* criando o comando que ser� executado pelo statement logo abaixo */
				String comando = "INSERT INTO tbl_alunos(nome, cpf, status, ranking, periodo, login, senha)"
						+ "VALUES('" + aluno.getNome() + "','" + aluno.getCpf() + "','" + blocado + "','"
						+ aluno.getRanking() + "','" + aluno.getPeriodo() + "','" + aluno.getLogin() + "','"
						+ aluno.getSenha() + "');";

				/* executando o comando atrav�s do statement */
				stmt.executeUpdate(comando);
				/* fechando o statement */
				stmt.close();

			} catch (SQLException e) {
				System.err.println();
			} finally {
				/*
				 * se a conex�o estiver aberta, ou seja, diferente de null, ele vai fecha-la
				 */
				if (conexao != null) {
					conexao.desconectar();
				}
			}
		}
	}

	/* adicionando professor ao banco de dados */
	public void adicinarProfessor(Professor professor) throws SQLException {
		/* abrindo o banco de dados */
		Conexao conexao = new Conexao();

		/* s� entra se a pessoa adicionada ainda n�o existe no banco de dados */
		if (buscar.buscarProfessor(professor.getLogin()) == null) {
			try {
				/* cria o statement */
				Statement stmt = conexao.criarStatement();

				/* criando o comando que ser� executado pelo statement logo abaixo */
				String comando = "INSERT INTO tbl_professores(nome, cpf, login, senha)" + "VALUES('"
						+ professor.getNome() + "','" + professor.getCpf() + "','" + professor.getLogin() + "','"
						+ professor.getSenha() + "');";

				/* executando o comando atrav�s do statement */
				stmt.executeUpdate(comando);
				/* fechando o statement */
				stmt.close();
			} catch (SQLException e) {
				System.err.println();
			} finally {
				/*
				 * se a conex�o estiver aberta, ou seja, diferente de null, ele vai fecha-la
				 */
				if (conexao != null) {
					conexao.desconectar();
				}
			}
		}
	}

	/* adicionando professor ao banco de dados */
	public void adicinarCoordenador(Coordenador coordenador) throws SQLException {
		/* abrindo o banco de dados */
		Conexao conexao = new Conexao();

		/* s� entra se a pessoa adicionada ainda n�o existe no banco de dados */
		if (buscar.buscarCoordenador(coordenador.getLogin()) == null) {
			try {
				/* cria o statement */
				Statement stmt = conexao.criarStatement();

				/* criando o comando que ser� executado pelo statement logo abaixo */
				String comando = "INSERT INTO tbl_professores(nome, cpf, login, senha)" + "VALUES('"
						+ coordenador.getNome() + "','" + coordenador.getCpf() + "','" + coordenador.getLogin() + "','"
						+ coordenador.getSenha() + "');";

				/* executando o comando atrav�s do statement */
				stmt.executeUpdate(comando);
				/* fechando o statement */
				stmt.close();
			} catch (SQLException e) {
				System.err.println();
			} finally {
				/*
				 * se a conex�o estiver aberta, ou seja, diferente de null, ele vai fecha-la
				 */
				if (conexao != null) {
					conexao.desconectar();
				}
			}
		}
	}

	public void adicionarDisciplina(Disciplina disciplina) throws SQLException {
		/* abrindo o banco de dados */
		Conexao conexao = new Conexao();

		/* s� entra se a pessoa adicionada ainda n�o existe no banco de dados */
		if (buscar.buscarDisciplina(disciplina.getCodigoDisciplina()) == null) {
			try {
				/* cria o statement */
				Statement stmt = conexao.criarStatement();

				/* criando o comando que ser� executado pelo statement logo abaixo */
				String comando = "INSERT INTO tbl_disciplinas(nome, codigo, vagas, horario, professor, periodo)"
						+ "VALUES('" + disciplina.getNomeDisciplina() + "','" + disciplina.getCodigoDisciplina() + "','"
						+ disciplina.getNumVagasAlunos() + "','" + disciplina.getHorarioDisciplina() + "','"
						+ disciplina.getProfessor().getNome() + "','" + disciplina.getPeriodoDisciplina() + "');";

				/* executando o comando atrav�s do statement */
				stmt.executeUpdate(comando);
				/* fechando o statement */
				stmt.close();
				
				Tabelas tabela = new Tabelas();
				
				tabela.criarTabelaDisciplina(disciplina.getCodigoDisciplina());
			} catch (SQLException e) {
				System.err.println();
			} finally {
				/*
				 * se a conex�o estiver aberta, ou seja, diferente de null, ele vai fecha-la
				 */
				if (conexao != null) {
					conexao.desconectar();
				}
			}
		}
	}
}
