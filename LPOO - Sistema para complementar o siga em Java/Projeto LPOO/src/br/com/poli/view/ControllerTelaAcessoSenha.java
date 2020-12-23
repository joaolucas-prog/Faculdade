package br.com.poli.view;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.poli.bancodedados.Alterar;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

public class ControllerTelaAcessoSenha {

	@FXML
	private Button txtConfirmar;

	@FXML
	private Hyperlink lnkHome;

    @FXML
    private PasswordField txtTesteSenha;

    @FXML
    private PasswordField txtCriarSenha;

    @FXML
    private Label lblSenhasDiferentes;
    
    @FXML
    private Label lblSenhaNaoAceita;

	public void initialize(URL arg0, ResourceBundle arg1) {
		// Inicializa o view
	}

	public void clickBtnConfirmarSenha() throws Exception {

		try {
			// verificando se a senha eh aceita pelo metodo primeiroAcesso e se as senhas
			// sao iguals
			if (SegundaTela.pessoaAtual.primeiroAcesso(this.txtCriarSenha.getText())
					&& this.txtCriarSenha.getText().equals(this.txtTesteSenha.getText())) {
				Alterar alterar = new Alterar();
				
				alterar.alterarSenha(SegundaTela.pessoaAtual.getLogin(), this.txtCriarSenha.getText());

				new SegundaTela("TelaLogin.fxml", null).start(MainView.stage);
			/*se a senha não estiver de acordo com as restrições para a senha vai aparecer a mensagem*/
			} else if(SegundaTela.pessoaAtual.primeiroAcesso(this.txtCriarSenha.getText()) == false) {
				this.lblSenhasDiferentes.setVisible(false);
				this.lblSenhaNaoAceita.setVisible(true);
			/*se as senhas forem diferentes vai aparecer a mensagem de senhas diferentes*/
			} else if(!this.txtCriarSenha.getText().equals(this.txtTesteSenha.getText())) {
				this.lblSenhaNaoAceita.setVisible(false);
				this.lblSenhasDiferentes.setVisible(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickBotaoHome() throws Exception {
		// para chamar o view "HOME"
		try {
			new SegundaTela("TelaLogin.fxml", null).start(MainView.stage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}