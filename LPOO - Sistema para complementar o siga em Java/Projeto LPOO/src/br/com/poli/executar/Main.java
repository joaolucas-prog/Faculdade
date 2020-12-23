package br.com.poli.executar;

import java.sql.SQLException;

import br.com.poli.bancodedados.Buscar;
import br.com.poli.bancodedados.Tabelas;

public class Main {

	public static void main(String[] args) throws SQLException {
		// MAIN PARA TESTES DE COMO IR� RODAR O C�DIGO NA INTERFACE
		//Conexao conexao = new Conexao();
		
		Tabelas tabela = new Tabelas();
		
		tabela.criarTabelaAlunos();
		
		tabela.criarTabelaProfessores();
		tabela.criarTabelaCoordenadores();
		
		Buscar buscar = new Buscar();
		
		if(buscar.buscarProfessor("0000") == null) {
			System.out.println("DEU CERTO");
		}
		
		/*Deletar deletar = new Deletar();
		
		deletar.deletarAluno("0000");*/
		
		
		/*Buscar buscar = new Buscar();
		Aluno aluno = null;

		try {
			aluno = buscar.buscarAluno("123");
		} catch (SQLException e) {
			System.out.println("ERRO NO BUSCAR");
		}
		System.out.println(aluno.getNome());*/
		
		
		

		//conexao.desconectar();
		// conexao.desconectar();

		// bancodados.criarTabelaAlunos();

		/*
		 * Scanner scan = new Scanner(System.in); Aluno aluno = new Aluno(null,
		 * "0000000", true, 0, 0);
		 * 
		 * while (true) { System.out.print("Nome: "); aluno.setNome(scan.nextLine());
		 * 
		 * System.out.print("CPF: "); aluno.setCpf(scan.nextLine());
		 * aluno.setNumMatricula(aluno.getLogin());
		 * 
		 * System.out.print("Blocado: "); if (scan.nextLine().equals("sim")) {
		 * aluno.setStatus(true); } else { aluno.setStatus(false); }
		 * 
		 * System.out.print("Ranking: "); aluno.setRanking(scan.nextFloat());
		 * 
		 * 
		 * 
		 * System.out.print("Periodo: "); aluno.setPeriodo(scan.nextInt());
		 * 
		 * bancodados.adicinarAluno(aluno);
		 * 
		 * System.out.println(aluno.informacao());
		 * 
		 * scan = new Scanner(System.in); System.out.print("Deseja sair (s/n)? "); if
		 * (scan.nextLine().equals("s")) { break; } }
		 * 
		 * System.out.
		 * println("PRIMEIRO ACESSO!!!\nDigite o matricula do aluno desejado: "); aluno
		 * = ListaGeralAlunos.procurarAluno(scan.nextLine()); System.out.println("ok - "
		 * + aluno.getNome());
		 * 
		 * System.out.println("Digite sua senha: ");
		 * aluno.primeiroAcesso(scan.nextLine());
		 * 
		 * System.out.println(aluno.informacao());
		 * 
		 * scan.close();
		 */
	}
}