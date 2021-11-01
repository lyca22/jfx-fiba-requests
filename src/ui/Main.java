package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.FIBARequests;

public class Main extends Application{

	private FIBARequests fiba;
	private FIBARequestsController controller;
	
	public Main() {
		fiba = new FIBARequests();
		controller = new FIBARequestsController(fiba);
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mainPane.fxml"));
		fxmlLoader.setController(controller);
		Parent root = fxmlLoader.load();
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("FIBA");
		primaryStage.show();
		
	}

}
