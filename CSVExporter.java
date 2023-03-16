import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVWriter;

public class CSVExporter {
    private static final String CSV_FILE_NAME = "data.csv";

    public static void exportToCSV(ArrayList<Employee> employees) throws IOException {
        File file = new File(CSV_FILE_NAME);
        FileWriter outputfile = new FileWriter(file);

        CSVWriter writer = new CSVWriter(outputfile);
        String[] header = {"ID", "First Name", "Last Name", "Position", "Basic Salary",
                            "Tax Deduction", "SSS Deduction", "PhilHealth Deduction",
                            "PagIbig Deduction", "Total Deduction", "Net Salary"};
        writer.writeNext(header);

        for (Employee employee : employees) {
            String[] data = {String.valueOf(employee.getId()), employee.getFirstName(),
                            employee.getLastName(), employee.getPosition(),
                            String.valueOf(employee.getBasicSalary()),
                            String.valueOf(employee.getTaxDeduction()),
                            String.valueOf(employee.getSSSDeduction()),
                            String.valueOf(employee.getPhilHealthDeduction()),
                            String.valueOf(employee.getPagIbigDeduction()),
                            String.valueOf(employee.getTotalDeduction()),
                            String.valueOf(employee.getNetSalary())};
            writer.writeNext(data);
        }

        writer.close();
    }

    public static void writeEmployeesToFile(ArrayList<Employee> employees) {
        try {
            FileWriter writer = new FileWriter("data.csv");
            writer.write("ID,First Name,Last Name,Position,Basic Salary,Tax,SSS,Philhealth,Pag-ibig,Total Deductions,Net Salary\n");
            for (Employee employee : employees) {
                writer.write(employee.getId() + "," + employee.getFirstName() + "," + employee.getLastName() + "," + employee.getPosition() + "," + employee.getBasicSalary() + "," + employee.getTaxDeduction() + "," + employee.getSSSDeduction() + "," + employee.getPhilHealthDeduction() + "," + employee.getPagIbigDeduction() + "," + employee.getTotalDeduction() + "," + employee.getNetSalary() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
      }
}
