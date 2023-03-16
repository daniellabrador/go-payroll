public class PayrollSystem {
  //! Runs the menu prompt
  public static void openMenu() {
    String menuInfo = "Welcome to Go Payroll!\n\nWhere managing your employees'";
    menuInfo += " payroll\nis made easy and hassle-free. Choose an\noption below";
    menuInfo += " to navigate through the app.";

    Router payrollSystem = new Router("GO PAYROLL SYSTEM MENU",
    menuInfo, new String[] {
      "Employees Menu",
      "Generate Payroll",
      "Exit"
    });

    payrollSystem.showOptions();
  }

  //! Start/Test the Payroll System
  public static void main(String[] args) {
    start();
  }

  public static void start(){
    openMenu();
  }
}
