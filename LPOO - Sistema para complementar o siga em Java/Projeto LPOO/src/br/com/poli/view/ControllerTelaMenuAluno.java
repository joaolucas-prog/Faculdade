package br.com.poli.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class ControllerTelaMenuAluno {

	@FXML
	private Label lblNomeAluno;

	@FXML
	private Label lblCpfAluno;

	@FXML
	private Hyperlink btnLogOut;

	@FXML
	private Hyperlink lnkIntencaoMatricula;

	@FXML
	private Hyperlink lnkFzrMatricula;

	@FXML
	private Hyperlink lnkGradeDeHorario;

	@FXML
	private ImageView imgLogOut;

	// Inicializacao do Controller da tela
	public void initialize() {
		lblNomeAluno.setText(SegundaTela.pessoaAtual.getNome());
		lblCpfAluno.setText(SegundaTela.pessoaAtual.getCpf());
	}

	public void fazerMatricula() {

		try {
			new SegundaTela("telaAlunoFzrMatricula.fxml", null).start(MainView.stage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickGradeDeHorario() {
	
	   try {
		new SegundaTela("telaAlunoPrintarGrade.fxml", null).start(MainView.stage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
}
	public void clickBotaoHome() throws Exception {
		// para chamar o view "HOME"
		try {
			new SegundaTela("telaLogin.fxml", null).start(MainView.stage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}