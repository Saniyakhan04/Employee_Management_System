package com.ems.main;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.ems.dao.EmployeeDAO;
import com.ems.dao.EmployeeDAOImpl;
import com.ems.model.Employee;

public class MainApp {
    public static void main(String[] args){
        EmployeeDAO dao = new EmployeeDAOImpl();
        Scanner sc = new Scanner(System.in);
        int choice=0;

        do{
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Search Employee");
            System.out.println("5. View All Employee");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");


            try{
                choice = sc.nextInt();
                sc.nextLine();
            }catch(InputMismatchException e){
                System.out.println("Invalid input! Please enter numbers only.");
                sc.nextLine();
                continue;
            }

            switch(choice){
                //case 1 is for adding the employee
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    if(dao.getEmployeeById(id)!=null){
                        System.out.println("Employee ID is already exist.");
                        break;
                    }
                    System.out.print("Enter Employee Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();


                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();
                    sc.nextLine();


                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();


                    Employee emp = new Employee(id,name,dept,salary,email);
                    dao.addEmployee(emp);
                  //  System.out.println("Employee Added Successfully.");
                    break;

                
                //case 2 is for updating the employee
                case 2:
                    System.out.print("Enter Employee ID to update: ");
                    int upId = sc.nextInt();
                    sc.nextLine();


                    if(dao.getEmployeeById(upId)==null){
                        System.out.println("Employee not found.");
                        break;
                    }

                    System.out.print("Enter New Name: ");
                    String upName = sc.nextLine();


                    System.out.print("Enter New Department: ");
                    String upDept = sc.nextLine();


                    System.out.print("Enter New Salary: ");
                    double upSalary = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter New Email: ");
                    String upEmail = sc.nextLine();



                    Employee updatedEmp = new Employee(upId, upName, upDept, upSalary, upEmail);
                    dao.updateEmployee(upId, updatedEmp);
                    //System.out.println("Employee Updated Successfully.");
                    break;



                //case 3 is for deleting the employee
                case 3:
                    System.out.print("Enter Employee ID to delete: ");
                    int delId = sc.nextInt();
                    sc.nextLine();

                    if(dao.getEmployeeById(delId)==null){
                        System.out.println("Employee not found.");
                        break;
                    }

                    dao.deleteEmployee(delId);
                   // System.out.println("Employee deleted successfully.");
                    break;



                //case 4 is for searching the employee
                case 4:
                    System.out.print("Enter Employee ID to search: ");
                    int searchId = sc.nextInt();
                    sc.nextLine();

                    Employee found = dao.getEmployeeById(searchId);
                    if(found!=null){
                        System.out.println("Employee found:");
                        System.out.println("ID: " + found.getEmpId());
                        System.out.println("Name: " + found.getName());
                        System.out.println("Department: " + found.getDepartment());
                        System.out.println("Salary: " + found.getSalary());
                        System.out.println("Email: " + found.getEmail());
                    }
                    else{
                        System.out.println("Employee not found.");
                    }
                    break;



                //case 5
                case 5:
                    List<Employee> employees = dao.getAllEmployees();
                    if(employees.isEmpty()){
                        System.out.println("No Employee is found.");
                    }
                    else{
                        for(Employee e : employees){
                            System.out.println("------------------------------------");
                            System.out.println("ID: " + e.getEmpId());
                            System.out.println("Name: " + e.getName());
                            System.out.println("Department: " + e.getDepartment());
                            System.out.println("Salary: " + e.getSalary());
                            System.out.println("Email: " + e.getEmail());
                        }
                    }
                    break;



                //case 6 for exiting the application
                case 6:
                    System.out.println("Exiting application...");
                    break;


                //when entered invalid choice
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;

            }

        }while(choice !=6);

        sc.close();
    }
}
