package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {
    public Label labelWelcome;
    public Button buttonStudents;
    public Button buttonTeachers;
    public Button buttonAddStudent;
    public Button buttonSave;
    public Label labelDetailedReport;
    public TextField fieldID;
    public Button buttonDetailedReport;
    public Button buttonReport;
    private PersonType type;

    //open students window
    public void OpenStudents(ActionEvent actionEvent) {
        try {
            OpenWindow("TableViewStudents.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //open teachers window
    public void OpenTeachers(ActionEvent actionEvent) {
        try {
            OpenWindow("TableViewTeachers.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //open window method
    public void OpenWindow(String window) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(window));
        Parent root1 = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
    }

    //determine level of access depending on the person's privileges
    public void SetType(PersonType type) {
        this.type = type;
        if (type == PersonType.BASIC) {
            buttonReport.setVisible(false);
            buttonAddStudent.setVisible(false);
            buttonSave.setVisible(false);
            buttonDetailedReport.setVisible(false);
            labelDetailedReport.setVisible(false);
            fieldID.setVisible(false);
        } else if (type == PersonType.EDITOR) {
            buttonReport.setVisible(true);
            buttonAddStudent.setVisible(true);
            buttonSave.setVisible(false);
            buttonDetailedReport.setVisible(true);
            labelDetailedReport.setVisible(true);
            fieldID.setVisible(true);
        } else {
            buttonReport.setVisible(true);
            buttonAddStudent.setVisible(true);
            buttonSave.setVisible(true);
            buttonDetailedReport.setVisible(true);
            labelDetailedReport.setVisible(true);
            fieldID.setVisible(true);
        }
    }

    //Open Reports window
    public void DisplayReports(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TableViewStudents.fxml"));
        Parent root1 = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));

        //enable grades to be viewed by passing a bool to new window
        TableViewStudentsController controller = fxmlLoader.getController();
        controller.CheckGrades(true);
        stage.show();
    }

    //open add student window
    public void AddStudent(ActionEvent actionEvent) throws IOException {
        OpenWindow("AddStudent.fxml");
    }

    //export reports
    public void SaveReport(ActionEvent actionEvent) {
    }

    //open detailed report window
    public void DetailedReport(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DetailedReport.fxml"));
        Parent root1 = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));

        //pass student id to new window
        DetailedReportController controller = fxmlLoader.getController();
        controller.getStudent(Integer.parseInt(fieldID.getText()));
        stage.show();
    }
}
