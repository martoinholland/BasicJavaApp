package main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class TableViewStudentsController implements Initializable {

    public TableColumn<Student, Integer> cshCol;
    public TableColumn<Student, Integer> javaCol;
    public TableColumn<Student, Integer> pythonCol;
    public TableColumn<Student, Integer> phpCol;
    boolean grades;
    @FXML
    private Label labelStudents;
    @FXML
    private TableView<Student> tableViewStudents;
    @FXML
    private TableColumn<Student, Integer> idCol;
    @FXML
    private TableColumn<Student, String> fNameCol;
    @FXML
    private TableColumn<Student, String> lNameCol;
    @FXML
    private TableColumn<Student, LocalDate> bDateCol;
    @FXML
    private TableColumn<Student, Integer> ageCol;
    @FXML
    private TableColumn<Student, String> groupCol;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Data data = new Data();
        ObservableList<Student> students = FXCollections.observableArrayList(data.RetrieveStudents());

        //set cells' value factories so that they get appropriate getters from Student class
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        fNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        bDateCol.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));
        groupCol.setCellValueFactory(new PropertyValueFactory<>("group"));
        cshCol.setCellValueFactory(new PropertyValueFactory<>("cSharpGrade"));
        pythonCol.setCellValueFactory(new PropertyValueFactory<>("pythonGrade"));
        phpCol.setCellValueFactory(new PropertyValueFactory<>("phpGrade"));
        javaCol.setCellValueFactory(new PropertyValueFactory<>("javaGrade"));

        tableViewStudents.setItems(students);
    }

    //display grades if user has the privileges
    public void CheckGrades(boolean grades) {
        if (grades) {
            cshCol.setVisible(true);
            pythonCol.setVisible(true);
            phpCol.setVisible(true);
            javaCol.setVisible(true);
        } else {
            cshCol.setVisible(false);
            pythonCol.setVisible(false);
            phpCol.setVisible(false);
            javaCol.setVisible(false);
        }
    }

}
