/**
 * Go Payroll
 * 
 * This is the main Java file for the Payroll System, which provides
 * functionality for managing employee details, generating payroll, and
 * generating payslips. It includes the following functions:
 *
 * [1] Employees Menu - View and/or edits the details of the employees in the
 *     system
 * [2] Generate Payroll - Generate payroll for all employees in the system
 * [3] Generate Payslip - Generate a payslip for a specific employee
 *
 * The main method of this class initializes the Payroll System and starts the
 * application.
 * 
 * To run the Payroll System application, simply run this Java file.
 * 
 * @author  Thony Danielle Labrador
 *          Jemriz Advincula
 * @version 1.0
 * @since   2023-03-16
 */

public class GoPayroll {
    public static void main(String[] args) {
        CSVReader.readEmployeesFromFile();
        PayrollSystem.start();
    }
}