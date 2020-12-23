package br.com.poli.view;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.poli.bancodedados.Adicionar;
import br.com.poli.sistema.Aluno;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControllerTelaCoordenadorAddAluno {

	@FXML
	private TextField txtRankingDoAluno;

	@FXML
	private TextField txtNomeDoAluno;

	@FXML
	private Button botaoConfirmarInfo;

	@FXML
	private TextField txtCpfDoAluno;

	@FXML
	private Hyperlink lnkVoltar;

	@FXML
	private TextField txtPeriodoDoAluno;

	@FXML
	private CheckBox chkBlocado;

	@FXML
	private CheckBox chkDesblocado;

	@FXML
	private Label lblNenhumaOpcao;

	@FXML
	private Label lblUmaOpcao;

	// Inicializacao do Controller da tela
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	public void clickAdicionarAluno() {
	try {

			boolean status = false;

			/* se os dois check estiver selecionados vai aparecer uma mensagem */
			if (this.chkBlocado.isSelected() && this.chkDesblocado.isSelected()) {
				this.lblNenhumaOpcao.setVisible(false);
				this.lblUmaOpcao.setVisible(true);

				/* se nenhum dos dois estvier selecionado vai aparecer outra mensagem */
		} else if (!this.chkBlocado.isSelected() && !this.chkDesblocado.isSelected()) {
				this.lblUmaOpcao.setVisible(false);
				this.lblNenhumaOpcao.setVisible(true);
			}

			/* se o blocado estiver ticado, coloca true no status */
			if (this.chkBlocado.isSelected()) {
				status = true;
			}

			Aluno aluno = new Aluno(this.txtNomeDoAluno.getText(), this.txtCpfDoAluno.getText(), status,
					this.txtRankingDoAluno.getRotate(), this.txtPeriodoDoAluno.getLength());

			System.out.println(aluno.informacao());

			Adicionar adicionar = new Adicionar();

			adicionar.adicinarAluno(aluno);

			new SegundaTela("telaCoordenadorAddAluno.fxml", null).start(MainView.stage);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickBotaoVoltar() throws Exception {
		// para chamar o view "HOME"
		try {
			new SegundaTela("telaMenuCoordenador.fxml", null).start(MainView.stage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
