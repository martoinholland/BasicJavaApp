package main;

import java.time.LocalDate;

public class Student extends Person {

    public String group;
    public int phpGrade;
    public int cSharpGrade;
    public int pythonGrade;
    public int javaGrade;

    public Student() {
    }

    public Student(String firstname, String lastName, int id, LocalDate birthDate,
                   PersonType type, String userName, String password, String group,
                   int javaGrade, int cSharpGrade, int pythonGrade, int phpGrade) {
        super(firstname, lastName, id, birthDate, type, userName, password);

        this.group = group;
        this.phpGrade = phpGrade;
        this.cSharpGrade = cSharpGrade;
        this.pythonGrade = pythonGrade;
        this.javaGrade = javaGrade;
    }
    //public Display

    public String getGroup() {
        return this.group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    //getters and setters

    public int getJavaGrade() {
        return this.javaGrade;
    }

    public void setJavaGrade(int java) {
        this.javaGrade = java;
    }

    public int getCSharpGrade() {
        return this.cSharpGrade;
    }

    public void setCSharpGrade(int cSharp) {
        this.cSharpGrade = cSharp;
    }

    public int getPythonGrade() {
        return this.pythonGrade;
    }

    public void setPythonGrade(int python) {
        this.pythonGrade = python;
    }

    public int getPhpGrade() {
        return this.phpGrade;
    }

    public void setPhpGrade(int php) {
        this.phpGrade = php;
    }
}
