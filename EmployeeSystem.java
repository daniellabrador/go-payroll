/**
 * Employee System
 * 
 * This file contains the main method of the Employee System. It is responsible
 * for displaying the menu of the employee system.
*/

import java.util.Scanner;

public class EmployeeSystem {
  // EMPLOYEE DETAILS
  public static void openMenu() {
    Router employeeSystem = new Router("Employee Details",
      Employees.getEmployeesDetails(), new String[] {
        "Add Employee",
        "Remove Employee",
        "Update Employee",
        "View Employee Details",
        "Back to Main Menu",
        "Exit"
      });

    employeeSystem.showOptions();
    InterfaceUtil.printMenu(employeeSystem.getMenuOptions());
    employeeSystem.routeUser(5);
  }




  // CREATE NEW EMPLOYEE OBJECT
  public static void addEmployee() {
    InterfaceUtil.printHeader("ADD EMPLOYEE");
    Scanner scanner = new Scanner(System.in);

    // Request employee details
    System.out.print("Enter 4-digit ID: ");
    int id = scanner.nextInt();
    scanner.nextLine();

    System.out.print("Enter first name: ");
    String firstName = scanner.nextLine();

    System.out.print("Enter last name: ");
    String lastName = scanner.nextLine();

    System.out.print("Enter position: ");
    String position = scanner.nextLine();

    System.out.print("Enter basic salary: ");
    double basicSalary = scanner.nextDouble();
    scanner.nextLine();

    // Pass down info to employees arraylist
    Employees.addEmployeeToList(id, firstName, lastName, position, basicSalary);

    // Return to menu
    System.out.println("Employee added successfully.");
    openMenu();
  }





  // REMOVE EMPLOYEE
  public static void removeEmployee(){
    InterfaceUtil.printHeader("REMOVE EMPLOYEE");
    Scanner scanner = new Scanner(System.in);

    System.out.print(Employees.getEmployeesDetails());
    System.out.println("");

    System.out.print("Enter ID of employee to remove: ");
    int id = scanner.nextInt();

    if (Employees.hasRemovedEmployee(id)){
      System.out.println("Employee removed successfully.");
      EmployeeSystem.openMenu();
    } else {
      System.out.println("Employee with ID " + id + " not found.");
      EmployeeSystem.openMenu();
    }
  }





  // UPDATE EMPLOYEE
  public static void updateEmployee(){
    InterfaceUtil.printHeader("UPDATE EMPLOYEE");

    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter ID of employee to update: ");
    int id = scanner.nextInt();
    scanner.nextLine();

    Employees.updateEmployee(id);
  }


  




  // Todo VIEW DETAILS
  public static void viewEmployee(){
    InterfaceUtil.printHeader("SELECT EMPLOYEE ID TO VIEW");
    System.out.print(Employees.getEmployeesDetails());
    System.out.println("");

    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the employee ID: ");
    int id = scanner.nextInt();
    scanner.nextLine(); // consume newline character
    String info = Employees.getEmployeeDetailsById(id);

    
    Router employeeSystem = new Router("View Employee Details",
      info, new String[] {
        "Back to Employees Menu",
        "Back to Main Menu",
        "Exit"
      });

    employeeSystem.showOptions();
    InterfaceUtil.printMenu(employeeSystem.getMenuOptions());
    employeeSystem.routeUser(5);

  }

  // Start/Test the Payroll System

  public static void start(){
    openMenu();
  }

  public static void main(String[] args) {
    start();
  }
}