public class Employee {
  private int id;
  private String firstName;
  private String lastName;
  private String position;
  private double basicSalary;
  private double taxDeduction;
  private double SSSDeduction;
  private double PhilHealthDeduction;
  private double PagIbigDeduction;
  private double totalDeduction;
  private double netSalary;

  public Employee(int id, String firstName, String lastName, String position,
  double basicSalary) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.position = position;
    this.basicSalary = basicSalary;
    this.taxDeduction = PayrollCalculations.computeTax(basicSalary);
    this.SSSDeduction = PayrollCalculations.computeSSS(basicSalary);
    this.PhilHealthDeduction = PayrollCalculations.computePhilHealth(basicSalary);
    this.PagIbigDeduction = PayrollCalculations.computePagIbig(basicSalary);
    this.totalDeduction = PayrollCalculations.computeDeductions(basicSalary);
    this.netSalary = PayrollCalculations.computeNetSalary(basicSalary);
  }

  public int getId(){
    return this.id;
  }

  public String getFirstName(){
    return this.firstName;
  }

  public String getLastName(){
    return this.lastName;
  }

  public String getPosition(){
    return this.position;
  }

  public double getBasicSalary(){
    return this.basicSalary;
  }

  public double getTaxDeduction(){
    return this.taxDeduction;
  }

  public double getSSSDeduction(){
    return this.SSSDeduction;
  }

  public double getPhilHealthDeduction(){
    return this.PhilHealthDeduction;
  }

  public double getPagIbigDeduction(){
    return this.PagIbigDeduction;
  }

  public double getTotalDeduction(){
    return this.totalDeduction;
  }

  public double getNetSalary(){
    return this.netSalary;
  }

  public void setId(int id){
    this.id = id;
  }

  public void setFirstName(String firstName){
    this.firstName = firstName;
  }

  public void setLastName(String lastName){
    this.lastName = lastName;
  }

  public void setPosition(String position){
    this.position = position;
  }

  public void setBasicSalary(double basicSalary){
    this.basicSalary = basicSalary;
  }

  public String toString() {
    return "ID: " + this.id + "\nName: " + this.firstName + " " + this.lastName + "\nPosition: " + this.position + "\nBasic Salary: " + this.basicSalary;
  }

}
