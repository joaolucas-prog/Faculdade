package br.com.poli.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.poli.bancodedados.Adicionar;
import br.com.poli.bancodedados.Buscar;
import br.com.poli.bancodedados.Conexao;
import br.com.poli.sistema.Disciplina;
import br.com.poli.sistema.Professor;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class ControllerTelaCoordenadorAddDisciplina {

	@FXML
	private Hyperlink lnkVoltar;

	@FXML
	private TextField txtNomeDisc;

	@FXML
	private MenuButton btnSelecionarProfDisiciplina;

	@FXML
	private Button btnConfirmarAddDisciplina;

	@FXML
	private TextField txtCodigoDisc;

	@FXML
	private TextField txtNumVagasDisc;

	@FXML
	private ImageView imgLogoPoli;

	@FXML
	private TextField txtPeriodoDisc;

	@FXML
	private TextField txtHorarioDisc;

	@FXML
	private Text txtDisciplina;

	public ControllerTelaCoordenadorAddDisciplina() {

	}

	// Inicializacao do Controller da tela
	public void initialize() {
		Conexao conexao = new Conexao();

		ResultSet resultSet = null;
		Statement stmt = conexao.criarStatement();

		/*
		 * qual informação você quer buscar? nesse caso ele quer buscar pelo login que
		 * nesse caso é igual ao número de matricula
		 */
		String sql = "SELECT * FROM tbl_professores;";
		try {
			/*
			 * executa o comando da String sql, ou seja, busca na tbl_alunos a linha que
			 * corresponde ao número de matricula
			 */
			resultSet = stmt.executeQuery(sql);

			while (resultSet.next()) {
				MenuItem novoItem = new MenuItem(resultSet.getString("nome"));

				this.btnSelecionarProfDisiciplina.getItems().add(novoItem);

				novoItem.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						String nomeProfessor;

						nomeProfessor = novoItem.getText();
						btnSelecionarProfDisiciplina.setText(nomeProfessor);

					}
				});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void chickAdicionarDisciplina() {
		try {
			
			System.out.println(this.btnSelecionarProfDisiciplina.getText());
			
			Adicionar adicionar = new Adicionar();
			Buscar buscar = new Buscar();
			Professor professor = buscar.buscarProfessorNome(this.btnSelecionarProfDisiciplina.getText());
			
			Disciplina disciplina = new Disciplina(this.txtNomeDisc.getText(), this.txtCodigoDisc.getText(),
					this.txtNumVagasDisc.getLength(), this.txtHorarioDisc.getText(), professor,
					this.txtPeriodoDisc.getLength());
			
			adicionar.adicionarDisciplina(disciplina);

			new SegundaTela("telaCoordenadorAddDisciplina.fxml", null).start(MainView.stage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}