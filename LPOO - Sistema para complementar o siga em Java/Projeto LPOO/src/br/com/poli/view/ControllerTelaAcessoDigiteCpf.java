package br.com.poli.view;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.poli.bancodedados.Buscar;
import br.com.poli.sistema.Aluno;
import br.com.poli.sistema.Pessoa;
import br.com.poli.sistema.Professor;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControllerTelaAcessoDigiteCpf {

	@FXML
	private TextField txtNome;
	@FXML
	private Button bntConfirmar;

	@FXML
	private Hyperlink lnkHome;

	@FXML
	private TextField txtCPF;

	@FXML
	private Label lblCpfInvalido;

	@FXML
	private Label lblSenhaAlterada;

	public void initialize(URL arg0, ResourceBundle arg1) {
		// Inicializa o view
	}

	public void clickBotaoHome() throws Exception {
		// para chamar o view "HOME"
		try {
			new SegundaTela("TelaLogin.fxml", null).start(MainView.stage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickBotaoConfirmar() throws Exception {

		try {
			Buscar buscar = new Buscar();

			Aluno aluno = buscar.buscarAluno(this.txtCPF.getText());

			Professor professor = buscar.buscarProfessor(this.txtCPF.getText());

			Pessoa pessoa = (aluno == null) ? (professor) : (aluno);
			
			/*
			 * se for um aluno ou professor e a senha for diferente de null (primeiro
			 * acesso), pode passar para a próxima tela
			 */
			
			if ((aluno != null || professor != null) && buscar.verificaSenhaAlterada(this.txtCPF.getText()) == true) {
				new SegundaTela("telaAcessoSenha.fxml", pessoa).start(MainView.stage);
				/* se o usuario não existir no sistema, vai avisar que não existe */
			} else if (aluno == null && professor == null) {
				/* apaga a label senha já alterada e printa cpf invalido */
				if (this.lblSenhaAlterada.isVisible()) {
					this.lblSenhaAlterada.setVisible(false);
				}
				this.lblCpfInvalido.setVisible(true);
				/* se o usuario já tiver alterado a senha vai avisar que já foi alterada */
			} else if (!buscar.verificaSenhaAlterada(this.txtCPF.getText())) {
				/* apaga a label cpf invalido se estiver lá e printa o senha alterada */
				if (this.lblCpfInvalido.isVisible()) {
					this.lblCpfInvalido.setVisible(false);
				}
				this.lblSenhaAlterada.setVisible(true);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
