package main;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DetailedReportController {
    public TextField fieldJava;
    public TextField fieldC;
    public TextField fieldPython;
    public TextField fieldPHP;
    public Button buttonSave;
    public Label labelID;
    public Label labelFName;
    public Label labelLName;
    public Label labelAge;
    public Label labelResult;
    public Label labelRetakes;
    public Label labelTitleName;
    private Student student;

    //save changes to grades
    public void SaveCourses(ActionEvent actionEvent) {
        //set new grades
        student.setPythonGrade(Integer.parseInt(fieldPython.getText()));
        student.setPhpGrade(Integer.parseInt(fieldPHP.getText()));
        student.setJavaGrade(Integer.parseInt(fieldJava.getText()));
        student.setCSharpGrade(Integer.parseInt((fieldC.getText())));

        //update in list
        Data data = new Data();
        data.UpdateGrade(student);
    }


    public void getStudent(int id) {

        Data data = new Data();
        student = data.RetrieveStudents().get(id - 1); //id is always one higher than index

        //set labels and text fields with user data
        labelAge.setText(Integer.toString(student.getAge()));
        labelFName.setText(student.getFirstName());
        labelID.setText(Integer.toString(student.getId()));
        labelTitleName.setText(student.getFirstName() + " " + student.getLastName());
        labelLName.setText(student.getLastName());
        fieldC.setText(Integer.toString(student.getCSharpGrade()));
        fieldJava.setText(Integer.toString(student.getJavaGrade()));
        fieldPHP.setText(Integer.toString(student.getPhpGrade()));
        fieldPython.setText(Integer.toString(student.getPythonGrade()));

        //check how many retakes the student has (retake is a score lower than 55)
        int retakes = 0;
        if (student.getCSharpGrade() < 55) {
            retakes++;
        }
        if (student.getJavaGrade() < 55) {
            retakes++;
        }
        if (student.getPhpGrade() < 55) {
            retakes++;
        }
        if (student.getPythonGrade() < 55) {
            retakes++;
        }

        labelRetakes.setText(Integer.toString(retakes));

        //determine end result
        if (retakes == 0) {
            labelResult.setText("Passed");
        } else {
            labelResult.setText("Not Passed");
        }
    }
}
