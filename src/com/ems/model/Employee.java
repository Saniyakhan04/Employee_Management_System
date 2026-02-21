package com.ems.model;
public class Employee{
    private int empId;
    private String name;
    private String department;
    private double salary;
    private String email;

    //Constructor
    public Employee(int empId, String name, String department, double salary, String email){
        this.empId = empId;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.email = email;
    }

    //Getters and setters
    public int getEmpId(){
        return empId;
    }
    public void setEmpId(int empId){
        this.empId = empId;
    }


    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }



    public String getDepartment(){
        return department;
    }
    public void setDepartment(String department){
        this.department = department;
    }



    public double getSalary(){
        return salary;
    }
    public void setSalary(double salary){
        this.salary = salary;
    }


    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }


    //toString for displaying employee
    public String toString(){
        return "Employee [ ID=" +empId + ", Name=" + name + ", Department=" + department + ", Salary=" + salary + ", Email=" + email + "]";
    }

}