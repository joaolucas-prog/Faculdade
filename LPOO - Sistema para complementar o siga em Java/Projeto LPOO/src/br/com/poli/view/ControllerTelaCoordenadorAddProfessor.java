package br.com.poli.view;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.poli.bancodedados.Adicionar;
import br.com.poli.sistema.Professor;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class ControllerTelaCoordenadorAddProfessor {

	@FXML
	private ImageView imgLogoPoli;

	@FXML
	private TextField txtNomeProfessor;

	@FXML
	private TextField txtCpfProfessor;

	@FXML
	private Button btnConfirmarAddProfessor;

	@FXML
	private Text txtProfessor;

	@FXML
	private Hyperlink hplVoltar;

	// Inicializacao do Controller da tela
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	public void adicionarProfessor() {
		try {

			Professor professor = new Professor(this.txtNomeProfessor.getText(), this.txtCpfProfessor.getText());

			Adicionar adicionar = new Adicionar();

			adicionar.adicinarProfessor(professor);

			new SegundaTela("telaCoordenadorAddProfessor.fxml", null).start(MainView.stage);
		} catch (Exception e) {
			System.err.println("Erro ao adicionar Professor");
		}
	}

	public void clickhplVoltar() throws Exception {
		// para chamar o view "HOME"
		try {
			new SegundaTela("telaMenuCoordenador.fxml", null).start(MainView.stage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
