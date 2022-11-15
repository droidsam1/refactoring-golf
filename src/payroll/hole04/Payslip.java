package payroll.hole04;

public class Payslip {
    private final double grossSalary;
    private final TaxCalculator taxCalculator;

    public Payslip(final double grossSalary, TaxCalculator taxCalculator) {
        this.grossSalary = grossSalary;
        this.taxCalculator = taxCalculator;
    }

    public double getNet() {
        return grossSalary - taxCalculator.getTaxDeductions(grossSalary);
    }

}
