/**
 * CSV Handler
 * 
 * This class contains methods that are used to read and write CSV files.
 * The CSV file is used to store the employees' data. Data is loaded from
 * the CSV file when the application starts and is written to the CSV file
 * every time the user creates, edits, or deletes an employee.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CSVHandler {
    
    private static final String CSV_SEPARATOR = ",";
    
    // Read CSV file and return ArrayList of Employee objects
    public static ArrayList<Employee> readCSV(String fileName) {
        ArrayList<Employee> employees = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, CSV_SEPARATOR);
                int id = Integer.parseInt(st.nextToken());
                String firstName = st.nextToken();
                String lastName = st.nextToken();
                String position = st.nextToken();
                double basicSalary = Double.parseDouble(st.nextToken());
                Employee employee = new Employee(id, firstName, lastName, position, basicSalary);
                employees.add(employee);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employees;
    }
    
    // Write ArrayList of Employee objects to CSV file
    public static void writeCSV(String fileName, ArrayList<Employee> employees) {
        try (FileWriter fw = new FileWriter(fileName)) {
            for (Employee employee : employees) {
                fw.append(Integer.toString(employee.getId()));
                fw.append(CSV_SEPARATOR);
                fw.append(employee.getFirstName());
                fw.append(CSV_SEPARATOR);
                fw.append(employee.getLastName());
                fw.append(CSV_SEPARATOR);
                fw.append(employee.getPosition());
                fw.append(CSV_SEPARATOR);
                fw.append(Double.toString(employee.getBasicSalary()));
                fw.append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
