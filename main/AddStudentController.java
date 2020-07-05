package main;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.time.Period;

public class AddStudentController {

    public Label labelSuccess;
    public Button buttonSave;
    public TextField fieldUser;
    public TextField fieldPassword;
    public TextField fieldFName;
    public TextField fieldLName;
    public TextField fieldGroup;
    public DatePicker dateBirth;


    public void AddStudent(ActionEvent actionEvent) {
        Data data = new Data();

        //fill in data from text fields
        Student student = new Student();
        student.setId(data.RetrieveAll().size() + 2);
        student.setGroup(fieldGroup.getText());
        student.setCSharpGrade(0);
        student.setJavaGrade(0);
        student.setPhpGrade(0);
        student.setPythonGrade(0);
        student.setUserName(fieldUser.getText());
        student.setPassword(fieldPassword.getText());
        student.setFirstName(fieldFName.getText());
        student.setLastName(fieldLName.getText());
        student.setType(PersonType.BASIC);
        student.setBirthDate(dateBirth.getValue());
        student.setAge(Period.between(dateBirth.getValue(), LocalDate.now()).getYears());

        //student is added but removed the moment the data object is deleted.
        //It doesn't show up in the "list students" window and you cannot log in with it,
        //since a new data object is created and only the hardcoded values are there.
        data.UpdateList(student);

        //display add was successfull
        labelSuccess.setVisible(true);
    }
}
