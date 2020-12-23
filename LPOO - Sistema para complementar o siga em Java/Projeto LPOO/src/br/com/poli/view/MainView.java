package br.com.poli.view;

import br.com.poli.bancodedados.Tabelas;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainView extends Application {
	
	public static Stage stage;

	public static void main(String[] args) {
		//Inicializacao da View
	launch(MainView.class);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		/* INICIAR TABELAS DO BANCO DE DADOS */
		Tabelas tabela = new Tabelas();

		tabela.criarTabelaAlunos();
		tabela.criarTabelaCoordenadores();
		tabela.criarTabelaProfessores();
		tabela.criarTabelaDisciplina();

		// Instanciacao da classe principal da View
		Parent cena = FXMLLoader.load(getClass().getResource("telaLogin.fxml"));

		Scene scene = new Scene(cena);

		MainView.stage = primaryStage;
		stage.setScene(scene);
		stage.setTitle("Login");
		stage.show();
	}
}
