package main;

import java.time.LocalDate;
import java.util.ArrayList;

public class Data {

    //Student objects
    Student student1 = new Student("Emma", "Smith", 1, LocalDate.of(1997, 4, 12),
            PersonType.BASIC, "emma", "emma1", "IT-02-A", 54, 50, 66, 54);
    Student student2 = new Student("Jack", "Brown", 2, LocalDate.of(1993, 7, 8),
            PersonType.BASIC, "jack", "jack2", "IT-02-A", 72, 68, 43, 95);
    Student student3 = new Student("Michael", "Garcia", 3, LocalDate.of(1999, 11, 1),
            PersonType.BASIC, "michael", "garcia", "IT-02-A", 45, 71, 55, 84);
    Student student4 = new Student("Lisa", "Jones", 4, LocalDate.of(2000, 4, 29),
            PersonType.BASIC, "lisa", "lisa4", "IT-02-A", 98, 64, 81, 72);
    Student student5 = new Student("John", "Miller", 5, LocalDate.of(2000, 10, 27),
            PersonType.BASIC, "john", "john5", "IT-02-A", 100, 94, 99, 93);
    Student student6 = new Student("Linda", "Martinez", 6, LocalDate.of(2002, 1, 17),
            PersonType.BASIC, "linda", "linda6", "IT-02-A", 55, 79, 81, 55);
    Student student7 = new Student("Richard", "Davis", 7, LocalDate.of(1997, 9, 22),
            PersonType.BASIC, "richard", "richard7", "IT-02-A", 51, 64, 39, 59);
    Student student8 = new Student("Mark", "Lopez", 8, LocalDate.of(1997, 12, 9),
            PersonType.BASIC, "mark", "mark8", "IT-02-A", 78, 98, 89, 99);
    Student student9 = new Student("Debora", "Hernandez", 9, LocalDate.of(1995, 2, 25),
            PersonType.BASIC, "debora", "debora9", "IT-02-A", 59, 55, 67, 99);
    Student student10 = new Student("Rick", "Hernandez", 10, LocalDate.of(2000, 3, 16),
            PersonType.BASIC, "rick", "rick10", "IT-02-A", 96, 87, 55, 82);
    //Teacher objects
    Teacher teacher1 = new Teacher("David", "Taylor", 11,
            LocalDate.of(1965, 6, 15), PersonType.EDITOR, "david", "david11", 5200);
    Teacher teacher2 = new Teacher("Sophy", "Anderson", 12,
            LocalDate.of(1987, 1, 6), PersonType.EDITOR, "sophy", "sophy12", 3500);
    Teacher teacher3 = new Teacher("James", "Jordon", 13,
            LocalDate.of(1956, 3, 19), PersonType.EDITOR, "james", "james13", 6100);
    Teacher teacher4 = new Teacher("Susan", "Jackson", 14,
            LocalDate.of(1978, 12, 25), PersonType.EDITOR, "susan", "susan14", 4520);
    Teacher teacher5 = new Teacher("Mary", "Lee", 15,
            LocalDate.of(1971, 9, 4), PersonType.EDITOR, "mary", "mary15", 5130);
    private final ArrayList<Person> allPeople;
    private final ArrayList<Student> students;
    private final ArrayList<Teacher> teachers;

    public Data() {
        //initialise lists
        allPeople = new ArrayList<>();
        students = new ArrayList<Student>();
        teachers = new ArrayList<Teacher>();

        //add students to students list
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);
        students.add(student7);
        students.add(student8);
        students.add(student9);
        students.add(student10);

        //add teachers to teachers list
        teachers.add(teacher1);
        teachers.add(teacher2);
        teachers.add(teacher3);
        teachers.add(teacher4);
        teachers.add(teacher5);

        //add all teachers and students to "allPeople" list
        allPeople.addAll(teachers);
        allPeople.addAll(students);
    }

    public ArrayList<Person> RetrieveAll() {
        return allPeople;
    }

    public ArrayList<Student> RetrieveStudents() {
        return students;
    }

    public ArrayList<Teacher> RetrieveTeachers() {
        return teachers;
    }

    public void UpdateList(Student student) {
        //student is added but deleted the moment the object is deleted (the window is closed)
        students.add(student);
    }

    //update the grade of a student by replacing at the appropriate index
    public void UpdateGrade(Student student) {

        students.set(student.getId() - 1, student);
        int s = 2;
    }

}
