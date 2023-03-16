import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.opencsv.exceptions.CsvValidationException;

public class CSVReader {
    private static final String CSV_FILE_NAME = "data.csv";

    public static ArrayList<Employee> readFromCSV() throws IOException, CsvValidationException {
        ArrayList<Employee> employees = new ArrayList<>();
        CSVReader reader = new CSVReader(new FileReader(CSV_FILE_NAME));
        String[] header = reader.readNext();

        String[] line;
        while ((line = reader.readNext()) != null) {
            int id = Integer.parseInt(line[0]);
            String firstName = line[1];
            String lastName = line[2];
            String position = line[3];
            double basicSalary = Double.parseDouble(line[4]);
            double taxDeduction = Double.parseDouble(line[5]);
            double sssDeduction = Double.parseDouble(line[6]);
            double philHealthDeduction = Double.parseDouble(line[7]);
            double pagIbigDeduction = Double.parseDouble(line[8]);
            double totalDeduction = Double.parseDouble(line[9]);
            double netSalary = Double.parseDouble(line[10]);

            Employee employee = new Employee(id, firstName, lastName, position, basicSalary);
            employee.setTaxDeduction(taxDeduction);
            employee.setSSSDeduction(sssDeduction);
            employee.setPhilHealthDeduction(philHealthDeduction);
            employee.setPagIbigDeduction(pagIbigDeduction);
            employee.setTotalDeduction(totalDeduction);
            employee.setNetSalary(netSalary);

            employees.add(employee);
        }

        reader.close();
        return employees;
    }
  
    public static ArrayList<Employee> readEmployeesFromFile() {
      ArrayList<Employee> employees = new ArrayList<Employee>();
      try {
          File file = new File("employees.csv");
          if (!file.exists()) {
              return employees;
          }
          Scanner scanner = new Scanner(file);
          scanner.nextLine(); // skip the first line (header)
          while (scanner.hasNextLine()) {
              String line = scanner.nextLine();
              String[] data = line.split(",");
              int id = Integer.parseInt(data[0]);
              String firstName = data[1];
              String lastName = data[2];
              String position = data[3];
              double basicSalary = Double.parseDouble(data[4]);
              double taxDeduction = Double.parseDouble(data[5]);
              double SSSDeduction = Double.parseDouble(data[6]);
              double PhilHealthDeduction = Double.parseDouble(data[7]);
              double PagIbigDeduction = Double.parseDouble(data[8]);
              double totalDeduction = Double.parseDouble(data[9]);
              double netSalary = Double.parseDouble(data[10]);
              Employee employee = new Employee(id, firstName, lastName, position, basicSalary);
              employee.setTaxDeduction(taxDeduction);
              employee.setSSSDeduction(SSSDeduction);
              employee.setPhilHealthDeduction(PhilHealthDeduction);
              employee.setPagIbigDeduction(PagIbigDeduction);
              employee.setTotalDeduction(totalDeduction);
              employee.setNetSalary(netSalary);
              employees.add(employee);
          }
          scanner.close();
      } catch (FileNotFoundException e) {
          System.out.println("The file was not found.");
          e.printStackTrace();
      }
      return employees;
  }
  
}
