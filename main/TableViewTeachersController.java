package main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class TableViewTeachersController implements Initializable {
    public Label labelTeachers;
    public TableView tableViewTeachers;
    public TableColumn idCol;
    public TableColumn fNameCol;
    public TableColumn lNameCol;
    public TableColumn bDateCol;
    public TableColumn ageCol;
    public TableColumn salaryCol;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Data data = new Data();
        ObservableList<Teacher> teachers = FXCollections.observableArrayList(data.RetrieveTeachers());

        //set cells' value factories so that they get appropriate getters from Teacher class
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        fNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        bDateCol.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));
        salaryCol.setCellValueFactory(new PropertyValueFactory<>("salary"));

        tableViewTeachers.setItems(teachers);
    }
}
