package com.example.prac02;

public class Employee {
    private String id;
    private String name;
    private String birthDate;
    private String salary;

    public Employee(String id, String name, String birthDate, String salary) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return id + "-" + name + "-" + birthDate + "-" + salary;
    }
}
