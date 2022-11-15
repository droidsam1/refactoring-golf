package payroll.hole04;

public class Payslip {
    private final double grossSalary;
    private final TaxCalculator taxCalculator = new TaxCalculator();

    public Payslip(final double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public double getNet() {
        double taxDeductions = taxCalculator.getTaxDeductions(grossSalary);
        return grossSalary - taxDeductions;
    }

    private double getTaxDeductions(double grossSalary1) {
        return taxCalculator.getTaxDeductions(grossSalary1);
    }
}
