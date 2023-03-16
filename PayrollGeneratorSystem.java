/**
 * Payroll Generator System
 * 
 * This file is responsible for creating the payroll table as seen in option
 * 2 of the Payroll System menu.
*/

public class PayrollGeneratorSystem {
  
  public static void openMenu() {
    Router payrollGenerator = new Router("SEMI-MONTHLY PAYROLL",
      getPayrollTable(), new String[] {
        "Back to Main Menu",
        "Exit"
      });

    payrollGenerator.showOptions();
  }

  public static String getPayrollTable() {
    String table = String.format("%-25s %-15s %-10s %-10s %-15s %-15s %-20s %-15s\n", "Employee Name", "Gross Salary", "Tax", "SSS", "Philhealth", "Pag-ibig", "Total Deductions", "Net Salary");
    for (Employee employee : Employees.getEmployees()) {
      String employeeName = employee.getFirstName() + " " + employee.getLastName();
      double basicSalary = employee.getBasicSalary();
      double tax = employee.getTaxDeduction();
      double sss = employee.getSSSDeduction();
      double philhealth = employee.getPhilHealthDeduction();
      double pagibig = employee.getPagIbigDeduction();
      double totalDeductions = employee.getTotalDeduction();
      double netSalary = employee.getNetSalary();
      table += String.format("%-25s %-15.2f %-10.2f %-10.2f %-15.2f %-15.2f %-20.2f %-15.2f\n", employeeName, basicSalary, tax, sss, philhealth, pagibig, totalDeductions, netSalary);
    }
    return table;
  }
  
  public static void main(String[] args){
    openMenu();
  }
}
