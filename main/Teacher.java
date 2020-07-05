package main;

import java.time.LocalDate;

public class Teacher extends Person {

    public double salary;

    public Teacher() {
    }

    public Teacher(String firstname, String lastName, int id, LocalDate birthDate,
                   PersonType type, String userName, String password, double salary) {
        super(firstname, lastName, id, birthDate, type, userName, password);
        setSalary(salary);
    }

    //getter and setter

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}
