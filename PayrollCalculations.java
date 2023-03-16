/**
 * Payroll Calculations
 * 
 * This file contains the methods for calculating the payroll of an employee.
*/

public class PayrollCalculations {
  // Define contants for tax rates and contribution rates
  private static class TaxBracket {
    double lowerBound, taxRate, upperBound, baseTax;

    TaxBracket(double lowerBound, double taxRate, double upperBound, double baseTax) {
      this.lowerBound = lowerBound;
      this.taxRate = taxRate;
      this.upperBound = upperBound;
      this.baseTax = baseTax;
    }
  }

  private static TaxBracket[] taxBrackets = {
    new TaxBracket(0, 0, 10417, 0),
    new TaxBracket(10417, 0.15, 16666, 0),
    new TaxBracket(16667, 0.20, 33332, 937.50),
    new TaxBracket(33333, 0.25, 83332, 4270.70),
    new TaxBracket(83333, 0.30, 333332, 16770.70),
    new TaxBracket(333333, 0.35, Double.MAX_VALUE, 91770.70)
  };

  // Income Tax
  public static double computeTax(double salary) {
    double withholdingTax = 0;
    for (TaxBracket bracket : taxBrackets) {
      if (salary > bracket.lowerBound) {
        withholdingTax = bracket.baseTax + ((salary - bracket.lowerBound) * bracket.taxRate);
      } else {
        break;
      }
    }

    return withholdingTax = Math.round(withholdingTax * 100.0) / 100.0;
  }

  public static double computeSSS(double salary) {
    if (salary <= 0) { return 0.0; }

    double semiMonthlyContribution = 0.0;
    double[] salaryRanges = {
      4249.99, 4749.99, 5249.99, 5749.99, 6249.99,
      6749.99, 7249.99, 7749.99, 8249.99, 8749.99,
      9249.99, 9749.99, 10249.99, 10749.99, 11249.99,
      11749.99, 12249.99, 12749.99, 13249.99, 13749.99,
      14249.99, 14749.99, 15249.99, 15749.99, 16249.99,
      16749.99, 17249.99, 17749.99, 18249.99, 18749.99,
      19249.99, 19749.99, Double.POSITIVE_INFINITY};
    double[] employeeContribution = {
      180.0, 202.5, 225.5, 247.5, 270.0, 
      292.50, 315.0, 337.5, 360.0, 382.5, 
      405.0, 427.5, 450.0, 472.5, 495.0, 
      517.5, 540.0, 562.5, 585.0, 607.5, 
      630.0, 652.5, 675.0, 697.5, 720.0, 
      742.5, 765.0, 787.5, 810.0, 832.5, 
      855.0, 877.5, 900.0};

    // Find the correct salary range and compute the semi-monthly contribution
    for (int i = 0; i < salaryRanges.length; i++) {
        if (salary <= salaryRanges[i]) {
            semiMonthlyContribution = employeeContribution[i] / 2;
            break;
        }
    }

    // Return the semi-monthly contribution
    return Math.round(semiMonthlyContribution * 100.0) / 100.0;
  }


  public static double computePagIbig(double salary) {
    if (salary <= 0.0) return 0.0;
    return 50.0;
  }

  public static double computePhilHealth(double salary) {
    if (salary <= 0) return 0.0;
    return Math.round(salary * 0.02 * 100.0) / 100.0;
  }

  public static double computeDeductions(double salary) {
    if (salary <= 0) {
      throw new IllegalArgumentException("Salary must be greater than 0");
    }
    
    double totalDeductions = 
      computeSSS(salary)
      + computePhilHealth(salary)
      + computePagIbig(salary)
      + computeTax(salary);

    return Math.round(totalDeductions * 100.0) / 100.0;
  }

  
  public static double computeNetSalary(double salary) {
    return salary - computeDeductions(salary);
  }
}

