package ui;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
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
    
    public FIBARequestsController(FIBARequests fiba) {
		this.fiba = fiba;
	}
    
	//fibaPrincipalPane methods
	@FXML
    void loadAddCsv(ActionEvent event) {

    }

    @FXML
    void loadAddPlayer(ActionEvent event) {

    }

    @FXML
    void loadSearchByStat(ActionEvent event) {

    }

    @FXML
    void loadSearchPlayer(ActionEvent event) {

    }

    //playerFieldsPane methods
    void loadPlayerFieldsPane() {}
    
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

    }
    
    //searchStatPane methods
    @FXML
    void seacrhByStat(ActionEvent event) {

    }
    
}
