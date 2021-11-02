package ui;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import model.FIBARequests;

public class FIBARequestsController {

	FIBARequests fiba;
	
	//mainPane fields
	@FXML
    private AnchorPane mainPane;
	
	//playerFieldsPane fields
    @FXML
    private JFXTextField tfName;

    @FXML
    private JFXTextField tfAge;

    @FXML
    private JFXTextField tfTeam;

    @FXML
    private JFXTextField tfAvgScore;

    @FXML
    private JFXTextField tfAvgBlocks;

    @FXML
    private JFXTextField tfAvgSteals;

    @FXML
    private JFXTextField tfAvgBounces;
	
    //searchPlayerPane fields
    @FXML
    private JFXTextField tfSearchPlayer;

    @FXML
    private JFXToggleButton btnEdit;

    @FXML
    private Pane playerFieldsPane;
    
    //searchStatPane fields
    @FXML
    private JFXTextField tfStatValue;

    @FXML
    private JFXComboBox<?> chboxCriterion;

    @FXML
    private TableView<?> tvPlayers;

    @FXML
    private JFXComboBox<?> chboxStat;
    
    @FXML
    private JFXButton btnSaveChanges;
    
    public FIBARequestsController(FIBARequests fiba) {
		this.fiba = fiba;
	}
    
	//fibaPrincipalPane methods
    @FXML
    void loadFibaPrincipalPane(MouseEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fibaPrincipalPane.fxml"));
		fxmlLoader.setController(this);
		Parent fibaPrincial = fxmlLoader.load();
		
		mainPane.getChildren().clear();
		mainPane.getChildren().setAll(fibaPrincial);
    }
    
	@FXML
    void loadAddCsv(ActionEvent event) {

    }

    @FXML
    void loadAddPlayer(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addPane.fxml"));
		fxmlLoader.setController(this);
		Parent addPlayer = fxmlLoader.load();
		
		mainPane.getChildren().clear();
		mainPane.getChildren().setAll(addPlayer);
		loadPlayerFieldsPane();
    }

    @FXML
    void loadSearchByStat(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("searchStatPane.fxml"));
		fxmlLoader.setController(this);
		Parent searchStat = fxmlLoader.load();
		
		mainPane.getChildren().clear();
		mainPane.getChildren().setAll(searchStat);
    }

    @FXML
    void loadSearchPlayer(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("searchPlayerPane.fxml"));
		fxmlLoader.setController(this);
		Parent searchPlayer = fxmlLoader.load();
		
		mainPane.getChildren().clear();
		mainPane.getChildren().setAll(searchPlayer);
		loadPlayerFieldsPane();
    }

    //playerFieldsPane methods
    void loadPlayerFieldsPane() throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("playerFieldsPane.fxml"));
		fxmlLoader.setController(this);
		Parent fields = fxmlLoader.load();
		
		playerFieldsPane.getChildren().clear();
		playerFieldsPane.getChildren().setAll(fields);
    }
    
    //addPlayerPane methods
    @FXML
    void addPlayer(ActionEvent event) {

    }
	
    //searchPlayerPane methods
    @FXML
    void editPlayer(ActionEvent event) {

    }
    
    @FXML
    void editFields(ActionEvent event) {
    	boolean enable = btnEdit.isSelected();
    	tfName.setEditable(enable);
    	tfAge.setEditable(enable);
    	tfTeam.setEditable(enable);
    	tfAvgBlocks.setEditable(enable);
    	tfAvgBounces.setEditable(enable);
    	tfAvgScore.setEditable(enable);
    	tfAvgSteals.setEditable(enable);
    	btnSaveChanges.setDisable(!enable);
    }
    
    //searchStatPane methods
    @FXML
    void seacrhByStat(ActionEvent event) {

    }
    
}
