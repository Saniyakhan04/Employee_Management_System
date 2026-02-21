package com.ems.main;

import com.ems.dao.EmployeeDAO;
import com.ems.dao.EmployeeDAOImpl;
import com.ems.model.Employee;

public class TestApp {
    public static void main(String[] args) {

        EmployeeDAO dao = new EmployeeDAOImpl();

        dao.addEmployee(new Employee(1, "Saniya", "IT" ,50000, "saniya@gmail.com"));
        dao.addEmployee(new Employee(2, "Aman","HR" ,45000, "Aman@gmail.com"));

        System.out.println("All Employees:");
        for (Employee e : dao.getAllEmployees()) {
            System.out.println(
                e.getEmpId() + " | " +
                e.getName() + " | " +
                e.getSalary() + " | " +
                e.getDepartment()
            );
        }
    }
}
