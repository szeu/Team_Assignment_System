package comp3111G15;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RequestWindowController {

	private int user_level;
	
	// all area
    @FXML
    private TextField requestTextField;
    
    @FXML
    private Button submitButton;
    
    // ta area
    
    @FXML
    private TextField filenameTextField;
    
    @FXML
    private Button LoadCSVButton;

    @FXML
    private HBox TA_Area;
    
    @FXML
    private Button energyViewButton;
    
    @FXML
    public void initialize() {
    	TextInputDialog td = new TextInputDialog();
    	td.setHeaderText("Enter TA pw, empty for students");
    	td.showAndWait();
    	user_level = Security.checkPW(td.getEditor().getText());
    	if (user_level == 0) {
    		TA_Area.setVisible(false);
    		// pretend the student data is pre-loaded
        	InputManager.read("StudentData.CSV");
    	} else {
    		System.out.println("you are a TA");
    		TA_Area.setVisible(true);
    	}
    	// Set search and line chart button to disabled
    	submitButton.setDisable(true);
    	energyViewButton.setDisable(true);
    }
    
    @FXML
    private void onEnergyVewButtonPressed(ActionEvent event) {
    	createChartWindow();
    }
    
    @FXML
    private void onLoadCsvButtonPressed(ActionEvent event) {
    	String CSVfilename = filenameTextField.getText();
    	// Set search and line chart button enabled when file is successfully loaded
    	boolean HasLoaded = InputManager.read(CSVfilename);
    	submitButton.setDisable(!HasLoaded);
    	energyViewButton.setDisable(!HasLoaded);
    }

    @FXML
    private void onSubmitButtonPressed(ActionEvent event) {
    	// Verify user input
    	if(verifyInput(requestTextField.getText().trim())) {
    		// Search for team info for that student
    		if(searchForTeam(DisplayWindowController.searching_student)) {
    			createTeamTableWindow();
    		}
    		else {
    			// When that student info is in the system but is not assigned to any team
    			Alert alert = new Alert(Alert.AlertType.ERROR);
        		alert.setTitle("Error");
        		alert.setContentText("Oops. No team is assgined for this student.");
        		alert.showAndWait();
    		}
    	}
    	// When user has entered something but invalid
    	else if(requestTextField.getText().trim().length() > 0) {
    		Alert alert = new Alert(Alert.AlertType.WARNING);
    		alert.setTitle("Invalid Input");
    		alert.setContentText("Incorrect student name or ID. Please try again.");
    		alert.showAndWait();
    	}
    }
    
	private boolean searchForTeam(Student student) {
		for(Team team : tester.teams) {
			for(Student s : team.getMemberList()) {
				if(s.equals(student)) {
					// Identify the team for that searching student
					DisplayWindowController.belonging_team = team;
					return true;
				}
			}
		}
		return false;
	}
    
    private boolean verifyInput(String input) {
    	for(Student student : InputManager.student_data) {
    		if(student.getName().replaceAll(",", "").toLowerCase().equals(input.toLowerCase())
    				|| student.getID().toLowerCase().equals(input.toLowerCase())) {
    			// Identify the searching student
    			DisplayWindowController.searching_student = student;
    			return true;
    		}
    			
    	}
    	return false;
    }
    
    private void createChartWindow() {
    	try {
	    	FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/lineChartUI.fxml"));
			Stage stage = new Stage();
			VBox root = (VBox) loader.load();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Student Key Energies Zoom Out View");
			stage.show();
    	}
    	catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    
    private void createTeamTableWindow() {
    	try {
	    	FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/displayUI.fxml"));
			Stage stage = new Stage();
			VBox root = (VBox) loader.load();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Search Result");
			stage.show();
    	}
    	catch (IOException e) {
    		e.printStackTrace();
    	}
    }
}

