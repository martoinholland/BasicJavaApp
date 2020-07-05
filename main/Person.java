package main;

import java.time.LocalDate;
import java.time.Period;


public class Person {

    public String firstName;
    public String lastName;
    public int id;
    public LocalDate birthDate;
    public int age;
    public PersonType type;
    public String userName;
    public String password;

    //empty constructor
    public Person() {
    }

    public Person(String firstName, String lastName, int id, LocalDate birthDate, PersonType type, String userName, String password) {
        setFirstName(firstName);
        setLastName(lastName);
        setId(id);
        setBirthDate(birthDate);
        setType(type);
        setUserName(userName);
        setPassword(password);
        setAge(Period.between(birthDate, LocalDate.now()).getYears());
    }

    //getters and setters

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public PersonType getType() {
        return this.type;
    }

    public void setType(PersonType type) {
        this.type = type;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(LocalDate date) {
        this.birthDate = date;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

