package ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;

import datastr.ComparisonCriteria;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import model.FIBARequests;
import model.Player;
import model.TreeCriteria;

public class FIBARequestsController {

	FIBARequests fiba;
	
	//mainPane fields
	@FXML
    private AnchorPane mainPane;
	
	//fibaPrincipalPane fields
	@FXML
	private Label lblAddCsv;
	
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
    
    @FXML
    private JFXTextField tfAvgAssists;
	
    //searchPlayerPane fields
    @FXML
    private JFXTextField tfSearchPlayer;

    @FXML
    private JFXToggleButton btnEdit;

    @FXML
    private Pane playerFieldsPane;
    
    private Player searchedPlayer;
    
    //searchStatPane fields
    @FXML
    private JFXTextField tfStatValue;

    @FXML
    private JFXComboBox<ComparisonCriteria> chboxCriterion;

    @FXML
    private TableView<Player> tvPlayers;

    @FXML
    private TableColumn<Player, String> colName;

    @FXML
    private TableColumn<Player, Integer> colAge;

    @FXML
    private TableColumn<Player, String> colTeam;

    @FXML
    private TableColumn<Player, Double> colScore;

    @FXML
    private TableColumn<Player, Double> colBlocks;

    @FXML
    private TableColumn<Player, Double> colSteals;

    @FXML
    private TableColumn<Player, Double> colBounces;
    
    @FXML
    private TableColumn<Player, Double> colAssists;
    
    @FXML
    private JFXComboBox<TreeCriteria> chboxStat;
    
    @FXML
    private JFXButton btnSaveChanges;
    
    @FXML
    private Label lblTime;
    
    public FIBARequestsController(FIBARequests fiba) {
		this.fiba = fiba;
	}
    
	//fibaPrincipalPane methods
    @FXML
    public void loadFibaPrincipalPane(MouseEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fibaPrincipalPane.fxml"));
		fxmlLoader.setController(this);
		Parent fibaPrincial = fxmlLoader.load();
		
		mainPane.getChildren().clear();
		mainPane.getChildren().setAll(fibaPrincial);
		
		addTipToShapes();
		searchedPlayer = null;
    }
    
	private void addTipToShapes() {
		Tooltip lblTip = new Tooltip();
		lblTip.setText("The csv must have format:\n" + 
						  "name;age;team;avgScore;avgAssists;avgBlocks;avgSteals;avgBounces");
		lblAddCsv.setTooltip(lblTip);
		
	}

	@FXML
	public void addCsv(ActionEvent event) throws FileNotFoundException, IOException {
		FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Search input");
    	File inputFile = fileChooser.showOpenDialog(null);
    	if(inputFile != null) {
    		String path = inputFile.getAbsolutePath();
    		fiba.addWithCSV(path);
    	}
    }

    @FXML
    public void loadAddPlayer(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addPane.fxml"));
		fxmlLoader.setController(this);
		Parent addPlayer = fxmlLoader.load();
		
		mainPane.getChildren().clear();
		mainPane.getChildren().setAll(addPlayer);
		loadPlayerFieldsPane();
    }

    @FXML
    public void loadSearchByStat(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("searchStatPane.fxml"));
		fxmlLoader.setController(this);
		Parent searchStat = fxmlLoader.load();
		
		mainPane.getChildren().clear();
		mainPane.getChildren().setAll(searchStat);
		loadChoiceStats();
		laodChoiceCriterion();
    }

    private void laodChoiceCriterion() {
		ComparisonCriteria[] criteria = {ComparisonCriteria.MINOR, ComparisonCriteria.MINOR_EQUAL,
										 ComparisonCriteria.EQUAL, ComparisonCriteria.GREATER,
										 ComparisonCriteria.GREATER_EQUAL};
		
		chboxCriterion.getItems().setAll(criteria);
	}

	private void loadChoiceStats() {
		TreeCriteria[] stats = {TreeCriteria.ASSISTS, TreeCriteria.BLOCKS,
								TreeCriteria.BOUNCES, TreeCriteria.SCORE,
								TreeCriteria.STEALS};

		chboxStat.getItems().setAll(stats);
	}

	@FXML
    public void loadSearchPlayer(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("searchPlayerPane.fxml"));
		fxmlLoader.setController(this);
		Parent searchPlayer = fxmlLoader.load();
		
		mainPane.getChildren().clear();
		mainPane.getChildren().setAll(searchPlayer);
		loadPlayerFieldsPane();
		editFields(null);
    }

    //playerFieldsPane methods
    public void loadPlayerFieldsPane() throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("playerFieldsPane.fxml"));
		fxmlLoader.setController(this);
		Parent fields = fxmlLoader.load();
		
		playerFieldsPane.getChildren().clear();
		playerFieldsPane.getChildren().setAll(fields);
    }
    
    //addPlayerPane methods
    @FXML
    public void addPlayer(ActionEvent event) {
    	if(!emptyFields()) {
			Player newPlayer = new Player(tfName.getText(), Integer.valueOf(tfAge.getText()), tfTeam.getText(), 
										  Double.valueOf(tfAvgScore.getText()), Double.valueOf(tfAvgAssists.getText()), 
										  Double.valueOf(tfAvgBlocks.getText()), Double.valueOf(tfAvgSteals.getText()),
										  Double.valueOf(tfAvgBounces.getText()));
			fiba.addPlayer(newPlayer);
		}
    }
	
    //searchPlayerPane methods
    @FXML
    public void searchPlayer(MouseEvent event) {
    	String playerName = tfSearchPlayer.getText();
    	searchedPlayer = fiba.searchPlayer(playerName, 0, fiba.getPlayerList().size() - 1);
    	if(searchedPlayer != null) {
    		fillFields();
    	}
    }
    
    private void fillFields() {
    	tfName.setText(searchedPlayer.getName());
    	tfAge.setText(searchedPlayer.getAge() + "");
    	tfTeam.setText(searchedPlayer.getTeam());
    	tfAvgBlocks.setText(searchedPlayer.getAverageBlocks() + "");
    	tfAvgBounces.setText(searchedPlayer.getAverageBounces() + "");
    	tfAvgScore.setText(searchedPlayer.getAverageScore() + "");
    	tfAvgSteals.setText(searchedPlayer.getAverageSteals() + "");
    	tfAvgAssists.setText(searchedPlayer.getAverageAssists() + "");
	}

	@FXML
	public void editPlayer(ActionEvent event) {
		if(!emptyFields()) {
			Player newPlayer = new Player(tfName.getText(), Integer.valueOf(tfAge.getText()), tfTeam.getText(), 
										  Double.valueOf(tfAvgScore.getText()), Double.valueOf(tfAvgAssists.getText()), 
										  Double.valueOf(tfAvgBlocks.getText()), Double.valueOf(tfAvgSteals.getText()),
										  Double.valueOf(tfAvgBounces.getText()));
			fiba.modifyPlayer(searchedPlayer, newPlayer);
			searchedPlayer = null;
		}
    }
    
    private boolean emptyFields() {
		boolean empty = tfName.getText().trim().equals("") ||
    	tfAge.getText().trim().equals("") ||
    	tfTeam.getText().trim().equals("") ||
    	tfAvgBlocks.getText().trim().equals("") ||
    	tfAvgBounces.getText().trim().equals("") ||
    	tfAvgScore.getText().trim().equals("") ||
    	tfAvgSteals.getText().trim().equals("") ||
    	tfAvgAssists.getText().trim().equals("");
		return empty;
	}

	@FXML
    public void deletePlayer(ActionEvent event) {
    	if(searchedPlayer != null) {
    		fiba.deletePlayer(searchedPlayer);
    	}
    }
    
    @FXML
    public void editFields(ActionEvent event) {
    	boolean enable = btnEdit.isSelected();
    	tfName.setEditable(enable);
    	tfAge.setEditable(enable);
    	tfTeam.setEditable(enable);
    	tfAvgBlocks.setEditable(enable);
    	tfAvgBounces.setEditable(enable);
    	tfAvgScore.setEditable(enable);
    	tfAvgSteals.setEditable(enable);
    	tfAvgAssists.setEditable(enable);
    	btnSaveChanges.setDisable(!enable);
    }
    
    //searchStatPane methods
    @FXML
    public void seacrhByStat(ActionEvent event) {
    	if(!tfStatValue.getText().isEmpty()) {
    		Double value = Double.valueOf(tfStatValue.getText());
    		List<Player> players = fiba.searchCriteria(chboxStat.getValue(), value, chboxCriterion.getValue());
    		initializePlayersTable(players);
    	}
    }
    
    public void initializePlayersTable(List<Player> players) {
    	ObservableList<Player> playersList = FXCollections.observableArrayList(players);
    	
    	colName.setCellValueFactory(new PropertyValueFactory<Player,String>("Name"));
    	colAge.setCellValueFactory(new PropertyValueFactory<Player,Integer>("Age"));
    	colTeam.setCellValueFactory(new PropertyValueFactory<Player,String>("Team"));
    	colScore.setCellValueFactory(new PropertyValueFactory<Player,Double>("Score"));
    	colBlocks.setCellValueFactory(new PropertyValueFactory<Player,Double>("Blocks"));
    	colSteals.setCellValueFactory(new PropertyValueFactory<Player,Double>("Steals"));
    	colBounces.setCellValueFactory(new PropertyValueFactory<Player,Double>("Bounces"));
    	colAssists.setCellValueFactory(new PropertyValueFactory<Player,Double>("Assists"));
    	
    	tvPlayers.setItems(playersList);
    }
    
}
