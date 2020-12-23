package br.com.poli.view;

import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;


public class ControllerTelaMenuCoordenador {

//declarando o que aparece na tela 
    @FXML
    private ImageView imgpoli;

    @FXML
    private ImageView imgAluno;

    @FXML
    private ImageView imgDisci;

    @FXML
    private ImageView imgProfessor;

    @FXML
    private MenuItem btnAddAluno;

    @FXML
    private MenuItem btnEditarAluno;

    @FXML
    private MenuItem btnExcluirAluno;

    @FXML
    private MenuItem btnBuscarAluno;

    @FXML
    private MenuItem btnAddProfessor;

    @FXML
    private MenuItem btnEditarProfessor;

    @FXML
    private MenuItem btnExcluirProfessor;

    @FXML
    private MenuItem btnBuscarProfessor;

    @FXML
    private MenuItem btnAddDisciplina;

    @FXML
    private MenuItem btnEditarDisciplina;

    @FXML
    private MenuItem btnExcluirDisciplina;

    @FXML
    private MenuItem btnBuscarDisciplina;

    @FXML
    private Hyperlink lnkVoltar;

	// Inicializacao do Controller da tela
	public void initialize() {

	}
	
	//caso click em alguma opção do menu de aluno
	public void clickbtnAddAluno() {
		try {
			new SegundaTela("telaCoordenadorAddAluno.fxml", null).start(MainView.stage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void clickbtnEditarAluno() {
		try {
			new SegundaTela("telaCoordenadorAlterarAluno.fxml", null).start(MainView.stage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void clickbtnExcluirAluno() {
		try {
			new SegundaTela("telaCoordenadorAddAluno.fxml", null).start(MainView.stage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void clickbtnBuscarAluno() {
		try {
			new SegundaTela("telaCoordenadorAddAluno.fxml", null).start(MainView.stage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//caso escolha alguma opçao do menu de professor
	public void clickbtnAddProfessor() throws Exception {
		try {
			new SegundaTela("telaCoordenadorAddProfessor.fxml", null).start(MainView.stage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void clickbtnEditarProfessor() throws Exception {
		try {
			new SegundaTela("telaCoordenadorAddProfessor.fxml", null).start(MainView.stage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void clickbtnExcluirProfessor() throws Exception {
		try {
			new SegundaTela("telaCoordenadorAddProfessor.fxml", null).start(MainView.stage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void clickbtnBuscarProfessor() throws Exception {
		try {
			new SegundaTela("telaCoordenadorAddProfessor.fxml", null).start(MainView.stage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//caso escolha alguma opçao de Disciplina
	public void clickbtnAddDisciplina() throws Exception {
		try {
				new SegundaTela("telaCoordenadorAddDisciplina.fxml", null).start(MainView.stage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	public void clickbtnEditarDisciplina() throws Exception {
		try {
				new SegundaTela("telaCoordenadorAddDisciplina.fxml", null).start(MainView.stage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	public void clickbtnExcluirDisciplina() throws Exception {
		try {
				new SegundaTela("telaCoordenadorAddDisciplina.fxml", null).start(MainView.stage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	public void clickbtnBuscarDisciplina() throws Exception {
		try {
				new SegundaTela("telaCoordenadorAddDisciplina.fxml", null).start(MainView.stage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	public void clicklnkVoltar() throws Exception {
		// para chamar o view "HOME"
		try {
			new SegundaTela("telaLogin.fxml", null).start(MainView.stage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
