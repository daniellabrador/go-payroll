/**
 * Employees
 *
 * This class contains the methods that are used to manage the employees being
 * housed as an ArrayList.
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Employees {
  // ARRAYLIST OF EMPLOYEES
  private static ArrayList<Employee> employees = new ArrayList<Employee>();

  public static ArrayList<Employee> getEmployees() {
    return employees;
  }

  public static void setEmployees(ArrayList<Employee> employees) {
    Employees.employees = employees;
  }


  
  // GETTERS
  public static String getEmployeesDetails() {
    String table = "";
    table += String.format("%-6s %-20s %s\n", "ID", "Name", "Position");
    if (employees.size() == 0) {
      table += "\nNo employees found.\n";
      return table;
    }
    for (Employee employee : employees) {
        String name = employee.getFirstName().charAt(0) + ". " + employee.getLastName();
        table += String.format("%04d   %-20s %s\n", employee.getId(), name, employee.getPosition());
    }
    return table;
  }



  // ADD EMPLOYEE OBJECT TO ARRAYLIST
  public static void addEmployeeToList(int id, String firstName, String lastName, String position, double basicSalary) {
    Employee employee = new Employee(id, firstName, lastName, position, basicSalary);
    employees.add(employee);
  }


  
  // REMOVE EMPLOYEE AND INFORM IF SUCCESSFUL
  public static boolean hasRemovedEmployee(int id) {
    for (int i = 0; i < employees.size(); i++) {
      if (employees.get(i).getId() == id) {
        employees.remove(i);
        return true;
      }
    }
  
    return false;
  }
  


  // Update an employees information
  public static void updateEmployee(int id) {
    Scanner scanner = new Scanner(System.in);
    Employee employeeToUpdate = null;
  
    for (int i = 0; i < employees.size(); i++) {
      if (employees.get(i).getId() == id) {
        employeeToUpdate = employees.get(i);
        break;
      }
    }
  
    if (employeeToUpdate == null) {
      System.out.println("Employee with ID " + id + " not found.");
      EmployeeSystem.openMenu();
      return;
    }
  
    System.out.print("Enter new first name (leave empty to keep current value '" + employeeToUpdate.getFirstName() + "'): ");
    String firstName = scanner.nextLine();
    if (!firstName.isEmpty()) {
      employeeToUpdate.setFirstName(firstName);
    }
  
    System.out.print("Enter new last name (leave empty to keep current value '" + employeeToUpdate.getLastName() + "'): ");
    String lastName = scanner.nextLine();
    if (!lastName.isEmpty()) {
      employeeToUpdate.setLastName(lastName);
    }
  
    System.out.print("Enter new position (leave empty to keep current value '" + employeeToUpdate.getPosition() + "'): ");
    String position = scanner.nextLine();
    if (!position.isEmpty()) {
      employeeToUpdate.setPosition(position);
    }
  
    System.out.print("Enter new basic salary (leave empty to keep current value '" + employeeToUpdate.getBasicSalary() + "'): ");
    String basicSalaryInput = scanner.nextLine();
    if (!basicSalaryInput.isEmpty()) {
      double basicSalary = Double.parseDouble(basicSalaryInput);
      employeeToUpdate.setBasicSalary(basicSalary);
    }
  
    System.out.println("Employee updated successfully.");
    EmployeeSystem.openMenu();
  }





  // RETURN EMPLOYEE DETAILS
  public static String getEmployeeDetailsById(int id) {
    for (Employee employee : employees) {
        if (employee.getId() == id) {
            String name = employee.getFirstName().charAt(0) + ". " + employee.getLastName();
            return String.format("ID: %04d\nName: %s\nPosition: %s\nBasic Salary: %.2f\n", 
                employee.getId(), name, employee.getPosition(), employee.getBasicSalary());
        }
    }
    return "Employee with ID " + id + " not found.";
}


  


  


}
