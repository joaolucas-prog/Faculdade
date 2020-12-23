package br.com.poli.view;

import br.com.poli.bancodedados.Alterar;
import br.com.poli.bancodedados.Buscar;
import br.com.poli.sistema.Aluno;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControllerTelaCoordenadorAlterarAluno {

	@FXML
	private CheckBox chkDesblocado;

	@FXML
	private Hyperlink lnkVoltar;

	@FXML
	private TextField txtRankingDoAluno;

	@FXML
	private TextField txtNomeDoAluno;

	@FXML
	private Button btnConfirmarAlteracao;

	@FXML
	private Button btnConfirmarCpf;

	@FXML
	private TextField txtCpfDoAluno;

	@FXML
	private CheckBox chkBlocado;

	@FXML
	private TextField txtCpfAlteracao;

	@FXML
	private TextField txtPeriodoDoAluno;

	@FXML
	private TextField txtSenhaAluno;

	@FXML
	private Label lblCpfInvalido;

	// Inicializacao do Controller da tela
	public void initialize() {

	}

	public void clickConfirmarCpf() {

		try {

			Buscar buscar = new Buscar();

			/*
			 * vai buscar o aluno e colocar no objeto aluno para poder ser usado mais a
			 * baixo
			 */
			Aluno aluno = null;

			aluno = buscar.buscarAluno(this.txtCpfAlteracao.getText());

			/* se o aluno não existir, vai informar que o aluno não existe */
			if (aluno == null) {
				lblCpfInvalido.setVisible(true);
				/*
				 * se o aluno não for null VAI SETTAR TODAS AS INFORMAÇÕES DO ALUNO
				 */
			} else {
				/* label estiver visivel, vai desaparecer a label */
				if (lblCpfInvalido.isVisible()) {
					lblCpfInvalido.setVisible(false);
				}

				/* setando o nome do aluno */
				txtNomeDoAluno.setText(aluno.getNome());

				/* setando o cpf do aluno */
				txtCpfDoAluno.setText(aluno.getCpf());

				/* setando a senha do aluno */
				txtSenhaAluno.setText(aluno.getSenha());

				/* String.valueOf é para transformar o double em String */
				txtRankingDoAluno.setText(String.valueOf(aluno.getRanking()));

				/* String.valueOf é para transformar o int em String */
				txtPeriodoDoAluno.setText(String.valueOf(aluno.getPeriodo()));

				/* se o aluno for blocado */
				if (aluno.isStatus()) {
					/* caso o desblocado esteja selecionado, vai apagar */
					if (chkDesblocado.isSelected()) {
						chkDesblocado.setSelected(false);
					}
					/* selecionado o blocado */
					chkBlocado.setSelected(true);
					/* caso o aluno seja desblocado */
				} else {
					/* se o check blocado estiver clicado, vai desclicar */
					if (chkBlocado.isSelected()) {
						chkBlocado.setSelected(false);
					}
					/* vai clicar no desblocado */
					chkDesblocado.setSelected(true);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void clickAlterarAluno() {
		Alterar alterar = new Alterar();

		boolean status = false;

		/* se o blocado estiver ticado, coloca true no status */
		if (this.chkBlocado.isSelected()) {
			status = true;
		}

		/*
		 * chamando o método que via alterar o aluno this.txtRankingDoAluno.getRotate(),
		 * this.txtPeriodoDoAluno.getLength()
		 */
		alterar.alterarAluno(this.txtNomeDoAluno.getText(), this.txtCpfDoAluno.getText(), status,
				this.txtRankingDoAluno.getRotate(), this.txtPeriodoDoAluno.getLength(), this.txtSenhaAluno.getText(),
				this.txtCpfAlteracao.getText());

		/*
		 * se tudo der certo vai printar a tela de alterar novamente, ou seja, vai
		 * apagar tudo
		 */
		try {
			new SegundaTela("telaCoordenadorAlterarAluno.fxml", null).start(MainView.stage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickBotaoVoltar() {
		// para chamar o view "HOME"
		try {
			new SegundaTela("telaLogin.fxml", null).start(MainView.stage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
