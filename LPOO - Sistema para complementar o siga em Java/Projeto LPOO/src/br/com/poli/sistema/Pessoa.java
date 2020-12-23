package br.com.poli.sistema;

public abstract class Pessoa {
	private String nome;
	private String cpf;
	private String login;
	private String senha;

	public Pessoa(String nome, String cpf) {
		this.nome = nome;
		this.setCpf(cpf);
		this.senha = null;
	}

	// metodo para criar senha do usuario no primeiro acesso ao sistema
	public boolean primeiroAcesso(String senha) {
//		 PARAMETROS para criação de Senha
//		 Defina uma senha com:
//		 -No minimo 6 caracteres
//		 -No minimo uma letra minuscula
//		 -No minimo uma letra maiuscula
//		 -No minimo um numero
//		 -No minimo um dos seguintes simbolos: @#$%^&+=
//		 -Sem espacos vazios
		String modeloSenha = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}";

		if (senha.matches(modeloSenha)) {
			this.setSenha(senha);
			return true;
		} else {
			return false;
		}
	}

	// metodo para comparar se a senha e o login estão cadastrados no "banco"
	public boolean verificarInformacoesLogin(String login, String senha) {

		if (login.equals(this.getLogin()) && senha.equals(this.getSenha())) {
			return true;
		} else {
			return false;
		}
	}

	// POLIMORFISMO
	public String informacao() {
		return "------ INFORMAÇÕES ------\n" + "\nNome: " + this.getNome() + "\nCPF: " + this.getCpf() + "\nLogin: "
				+ this.getLogin();
	}

	// ---------- GETTERS E SETTERS ------------------------

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
		cpf = cpf.replaceAll("\\.", "");
		this.setLogin(cpf.replaceAll("-", "")); // coloca o numero de matricula no login
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}