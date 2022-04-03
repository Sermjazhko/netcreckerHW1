package com.netcracker.part1;

import java.util.Objects;

public class Employee {
    private  int id;
    private String firstName;
    private String lastName;
    private int salary;

    public Employee(int id, String firstName, String lastName, int salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public int getID() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName(){
        return firstName + ' ' + lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAnnualSalary(){
        return salary * 12;
    }

    public int raiseSalary(int percent){
        return salary * (100+percent) / 100;
    }

    @Override
    public String toString() {
        return "Employee[" +
                "id=" + id +
                ", Name=" + firstName  + " " +
                 lastName +
                ", salary=" + salary +
                ']';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return id == employee.id && salary == employee.salary && this.firstName.equals(employee.firstName) && this.lastName.equals(employee.lastName);
    }

    @Override
    public int hashCode() {
        int result = 17;

        result = 31*result + id;
        result = 31*result + salary;
        result = 31*result + firstName.hashCode();
        result = 31*result + lastName.hashCode();

        return result;
    }
}
