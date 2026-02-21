package com.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ems.model.Employee;
import com.ems.util.DBConnection;
import java.sql.SQLException;



public class EmployeeDAOImpl implements EmployeeDAO {
    

    @Override
    public void addEmployee(Employee emp){
        String query = "INSERT INTO employee VALUES (?,?,?,?,?)";
        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query)){

                ps.setInt(1,emp.getEmpId());
                ps.setString(2, emp.getName());
                ps.setString(3, emp.getDepartment());
                ps.setDouble(4, emp.getSalary());
                ps.setString(5, emp.getEmail());

                ps.executeUpdate();
                System.out.println("Employee added successfully!");
            } catch (SQLException e){
                e.printStackTrace();
            }
    }


    @Override
    public void updateEmployee(int empId, Employee emp){
       String query = "Update employee SET name=?, department=?, salary=?, email=? WHERE emp_Id=?";
       try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query)){

            ps.setString(1, emp.getName());
            ps.setString(2, emp.getDepartment());
            ps.setDouble(3, emp.getSalary());
            ps.setString(4, emp.getEmail());
            ps.setInt(5, empId);

            int rows = ps.executeUpdate();

            if(rows>0)
                System.out.println("Employee updated successfully!");
            else
                System.out.println("Employee not found!");

            } catch (SQLException e){
                e.printStackTrace();
            }
    }


    @Override
    public Employee getEmployeeById(int empId){
        String query = "SELECT * FROM employee WHERE emp_Id=?";
        Employee emp = null;

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query)){

                ps.setInt(1,empId);
                ResultSet rs = ps.executeQuery();

                if(rs.next()){
                    emp = new Employee(
                        rs.getInt("emp_Id"),
                        rs.getString("name"),
                        rs.getString("department"),
                        rs.getDouble("salary"),
                        rs.getString("email")
                    );
                } 

            }catch (SQLException e) {
                    e.printStackTrace();
            }
            return emp;
    }


    @Override
    public void deleteEmployee(int empId){
        String query = "DELETE FROM employee WHERE emp_Id=?";
        try (Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query)) {

                ps.setInt(1,empId);
                int rows = ps.executeUpdate();

                if(rows>0)
                    System.out.println("Employee deleted successfully!");
                else
                    System.out.println("Employee not found!");
            } catch (SQLException e){
                e.printStackTrace();
            }
    }


    @Override
    public List<Employee> getAllEmployees(){
       String query = "SELECT * FROM employee";
       List<Employee> list = new ArrayList<>();

       try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery()) {

                while(rs.next()){
                    Employee emp = new Employee(
                        rs.getInt("emp_Id"),
                        rs.getString("name"),
                        rs.getString("department"),
                        rs.getDouble("salary"),
                        rs.getString("email")
                    );
                    list.add(emp);
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
            return list;
    }
    
}
