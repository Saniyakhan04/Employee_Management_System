package com.ems.dao;

import com.ems.model.Employee;
import java.util.List;
public interface EmployeeDAO {
    void addEmployee(Employee emp);
    void updateEmployee(int empId, Employee emp);
    void deleteEmployee(int empId);
    Employee getEmployeeById(int empId);
    List<Employee> getAllEmployees();
}
