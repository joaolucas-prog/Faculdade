package br.com.poli.view;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.poli.bancodedados.Buscar;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControllerTelaLogin implements Initializable {

	// Declaracao dos elementos presentes na tela
	@FXML
	private TextField txtLogin;

	@FXML
	private TextField txtSenha;

	@FXML
	private Hyperlink linkPrimeiroAcesso;

	@FXML
	private Button bntLogin;

	@FXML
	private Label lblInvalido;

	

	// Inicializacao do Controller da tela
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	// Configuracao de acoes dos elementos presentes na tela
	// Botao 'Login': Atrelado ao metodo de checar os dados de login inseridos pelo
	// usuario
	public void clickBotaoEntrar() throws Exception {
		Buscar buscar = new Buscar();
		/* cria objeto login */
		String log = Login.logar(this.txtLogin.getText(), this.txtSenha.getText());
		/* se login for diferente de null */
		if (log != null) {
			/* se o retorno for aluno ele vai para a tele de aluno */
			if (log.equals("Aluno")) {
				try {
					new SegundaTela("telaMenuAluno.fxml", buscar.buscarAluno(this.txtLogin.getText()))
							.start(MainView.stage); // Aluno
				} catch (Exception e) {
					e.printStackTrace();
				}
				/* se o retorno for professor vai pra tela de professor */
			} else if (log.equals("Professor")) {
				try {
					new SegundaTela("telaMenuProfessor.fxml", null).start(MainView.stage); // Professor
				} catch (Exception e) {
					e.printStackTrace();
				}
				/* se retornar coord-enador vai ser direcionado para a area do coordenador */
			} else if (log.equals("Coordenador")) {
				try {
					new SegundaTela("telaMenuCoordenador.fxml", null).start(MainView.stage); // Professor
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} else {
			this.lblInvalido.setVisible(true);
		}
	}

	// Link 'Primeiro Acesso': Leva o usuario a uma tela de cadastro, caso nao
	// possua senha ainda
	public void clicklnkPrimeiroAcesso() throws Exception {
		try {

			new SegundaTela("telaAcessoDigiteCpf.fxml", null).start(MainView.stage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
