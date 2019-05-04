// Check the file "Project1 requirements.txt"

import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static File StudentsFile;
	public static File CriteriaFile;
	public static File studentsAccepted = new File("D:\\Java Programming\\Workspace\\2016Project1_UniversityAdmission\\Output files\\studentsAccepted.txt");
	public static File studentsRejected = new File("D:\\Java Programming\\Workspace\\2016Project1_UniversityAdmission\\Output files\\studentsRejected.txt");
	public static TextArea textArea = new TextArea();
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Pane root = new Pane();
		
		Scene scene = new Scene(root,1300,600);
		primaryStage.setTitle("University Admission");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		// create buttons:
		Button buttonGetStudentsFile = new Button("Choose the students file");
		buttonGetStudentsFile.setLayoutX(20);
		buttonGetStudentsFile.setLayoutY(20);
		
		Button buttonGetFacultiesFile = new Button("Choose the faculties' criteria file");
		buttonGetFacultiesFile.setLayoutX(20);
		buttonGetFacultiesFile.setLayoutY(60);
		buttonGetFacultiesFile.setDisable(true);
		
		Button buttonAccept = new Button("Acceptance");
		buttonAccept.setLayoutX(20);
		buttonAccept.setLayoutY(140);
		buttonAccept.setDisable(true);
		
		Button buttonPrintRejected = new Button("Print Rejected");
		buttonPrintRejected.setLayoutX(20);
		buttonPrintRejected.setLayoutY(220);
		buttonPrintRejected.setDisable(true);
		
		Button buttonPrintAccepted = new Button("Print Accepted");
		buttonPrintAccepted.setLayoutX(20);
		buttonPrintAccepted.setLayoutY(260);
		buttonPrintAccepted.setDisable(true);
		
		Button buttonWriteFiles = new Button("Write files");
		buttonWriteFiles.setLayoutX(20);
		buttonWriteFiles.setLayoutY(340);
		buttonWriteFiles.setDisable(true);
		
		Button buttonOpenOutputFiles = new Button("Open output files");
		buttonOpenOutputFiles.setLayoutX(20);
		buttonOpenOutputFiles.setLayoutY(420);
		buttonOpenOutputFiles.setDisable(true);

		// add another button for exit:
		Button buttonExit = new Button("      Exit      ");
		buttonExit.setLayoutX(750);
		buttonExit.setLayoutY(550);
		
		
		// create a text area:
//		TextArea textArea = new TextArea();
		textArea.setLayoutX(250);
		textArea.setLayoutY(10);
		textArea.setPrefRowCount(35);
		textArea.setPrefColumnCount(75);
		textArea.setFont(Font.font("Consolas",12));	// if wanted BOLD:  textArea.setFont(Font.font("Consolas",FontWeight.BOLD, 12));
		textArea.setWrapText(false);
		textArea.setText("\n                    UNIVERSITY STUDENTS ADMISSION\n\n"
				+ "Please follow the following steps:\n\n"
				+ "1.  Choose the file containing the students data\n"
				+ "2.  Choose the file containing the faculties data\n"
				+ "3.  Click of Acceptance button\n"
				+ "4.  Print the accepted students\n"
				+ "5.  Print the rejected students\n"
				+ "6.  Click on Write file button");
		textArea.setEditable(false);
		
		// View the accepted students Pie Chart:
 		ObservableList<Data> pieChartData = FXCollections.observableArrayList();
		PieChart chart = new PieChart(pieChartData);
        
        // setOnAction:
		
		buttonExit.setOnAction(e -> System.exit(0));
		
     	buttonGetStudentsFile.setOnAction(new EventHandler<ActionEvent>(){
    		@Override
    		public void handle(ActionEvent event){	
    			FileChooser fileChooser = new FileChooser();
    			//Set extension filter
    			FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
    			fileChooser.getExtensionFilters().add(extFilter);
    			fileChooser.setInitialDirectory(new File("D:\\Java Programming\\Workspace\\2016Project1_UniversityAdmission\\Input files"));
    			//Show save file dialog
    			StudentsFile = fileChooser.showOpenDialog(primaryStage);
    			if(StudentsFile != null){
    				Acceptance.readStudents(StudentsFile);
    			root.getChildren().remove(chart);
    			buttonGetFacultiesFile.setDisable(false);
    			buttonAccept.setDisable(true);
    			buttonPrintRejected.setDisable(true);
    			buttonPrintAccepted.setDisable(true);
    			buttonWriteFiles.setDisable(true);
    			buttonOpenOutputFiles.setDisable(true);
    			}
    		}
    	});
     	
     	buttonGetFacultiesFile.setOnAction(new EventHandler<ActionEvent>(){
    		@Override
    		public void handle(ActionEvent event){	
    			FileChooser fileChooser = new FileChooser();
    			//Set extension filter
    			FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
    			fileChooser.getExtensionFilters().add(extFilter);
    			fileChooser.setInitialDirectory(new File("D:\\Java Programming\\Workspace\\2016Project1_UniversityAdmission\\Input files"));
    			//Show save file dialog
    			CriteriaFile = fileChooser.showOpenDialog(primaryStage);
    			if(CriteriaFile != null){
    				Acceptance.readCriteria(CriteriaFile);
   				root.getChildren().remove(chart);
   				buttonAccept.setDisable(false);
    			}
    		}
    	});
     	
     	buttonAccept.setOnAction(e -> {
     		if (Main.StudentsFile == null || Main.CriteriaFile == null){
    			System.out.println("\n\nPlease choose students' data and acceptance criteria data files first.");
    			Main.textArea.setText("\n\n\nPlease choose students' data and acceptance criteria data files first.");
    			return;
    		}
     		
     		// Call the students' acceptance method:
     		Acceptance.acceptStudents();
     		buttonGetFacultiesFile.setDisable(true);
     		buttonAccept.setDisable(true);
     		buttonPrintRejected.setDisable(false);
     	});
     	
     	buttonPrintRejected.setOnAction(e -> {
     		if (Main.StudentsFile == null || Main.CriteriaFile == null){
    			System.out.println("\n\nPlease choose students' data and acceptance criteria data files first.");
    			Main.textArea.setText("\n\n\nPlease choose students' data and acceptance criteria data files first.");
    			return;
    		}
     		Print.printRejected();
     		
     		root.getChildren().remove(chart);
     		pieChartData.clear();
    		pieChartData.add(new Data("Accepted", Acceptance.studentsApplied.getSize()));
    		pieChartData.add(new Data("Rejected", Acceptance.studentsRejected.getSize()));
    		chart.setId("BasicPie");
    		chart.setStartAngle(0);
    		chart.setLegendVisible(false);
    		chart.setTranslateX(800);
    		chart.setTranslateY(40);
    		chart.setOnMouseClicked(ee -> root.getChildren().remove(chart));
    		root.getChildren().add(chart);
    		buttonPrintAccepted.setDisable(false);
     	});
     	
     	buttonPrintAccepted.setOnAction(e -> {
     		if (Main.StudentsFile == null || Main.CriteriaFile == null){
    			System.out.println("\n\nPlease choose students' data and acceptance criteria data files first.");
    			Main.textArea.setText("\n\n\nPlease choose students' data and acceptance criteria data files first.");
    			return;
    		}
     		Print.printAccepted();
     		buttonWriteFiles.setDisable(false);
     		root.getChildren().remove(chart);
     	
     		pieChartData.clear();
     		String facName;
     		int noOfaccpeted;
    		for(int i=0 ; i<Acceptance.getNoOfFaculties() ; i++){
    			facName = Acceptance.getFaculties(i).getName();
         		if (facName.length()>15)
         			facName = facName.substring(0, 14)+"\n"+facName.substring(14);
         		noOfaccpeted = Acceptance.getFaculties(i).students.getSize();
    			pieChartData.add(new Data(facName, noOfaccpeted));
    		}
    		chart.setId("BasicPie");
    		chart.setStartAngle(0);
    		chart.setLegendVisible(false);
    		chart.setTranslateX(800);
    		chart.setTranslateY(40);
    		chart.setOnMouseClicked(ee -> root.getChildren().remove(chart));
    		root.getChildren().add(chart);
    		
     	});
     	
     	buttonWriteFiles.setOnAction(e -> {
     		if (Main.StudentsFile == null || Main.CriteriaFile == null){
    			System.out.println("\n\nPlease choose students' data and acceptance criteria data files first.");
    			Main.textArea.setText("\n\n\nPlease choose students' data and acceptance criteria data files first.");
    			return;
    		}
     		FileWrite.accepted(studentsAccepted);
     		FileWrite.rejected(studentsRejected);
     		textArea.setText("\n\n\n\n\n\n" + "You can find the files in:\n\n"
					+ "D:\\Java Programming\\Workspace\\2016Project1_UniversityAdmission\\Output files");
     		buttonOpenOutputFiles.setDisable(false);
     	});
     	
     	buttonOpenOutputFiles.setOnAction(e -> {
     		if (Main.StudentsFile == null || Main.CriteriaFile == null){
    			System.out.println("\n\nPlease choose students' data and acceptance criteria data files first.");
    			Main.textArea.setText("\n\n\nPlease choose students' data and acceptance criteria data files first.");
    			return;
    		}
     		Runtime runtime = Runtime.getRuntime();
     		try {
				runtime.exec("C:\\Windows\\notepad.exe "+ studentsAccepted.getAbsolutePath());
				runtime.exec("C:\\Windows\\notepad.exe "+ studentsRejected.getAbsolutePath());
			} catch (IOException e1) {
				System.out.println("Some error has occurred");
				textArea.setText("\n\n\n\n\n>> Some ERROR has occurred");
				e1.printStackTrace();
			}
     	});
     	
		root.getChildren().addAll(buttonGetStudentsFile, buttonGetFacultiesFile, 
				buttonAccept, buttonPrintAccepted, buttonPrintRejected, 
				buttonWriteFiles, buttonOpenOutputFiles, buttonExit, textArea);
		
	}
}

