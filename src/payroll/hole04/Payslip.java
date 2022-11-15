package payroll.hole04;

public class Payslip {
    private final double grossSalary;

    public Payslip(final double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public double getNet() {
        double taxDeductions = getTaxDeductions();
        return grossSalary - taxDeductions;
    }

    private double getTaxDeductions() {
        final double grossSalarySubjectToLowerTaxBracket = Math.max(Math.min(grossSalary, 20000.0) - 5000, 0.0);
        final double grossSalarySubjectToMediumTaxBracket = Math.max(Math.min(grossSalary, 40000) - 20000, 0.0);
        final double grossSalarySubjectToUpperTaxBracket = Math.max(grossSalary - 40000, 0.0);
        return grossSalarySubjectToLowerTaxBracket * 0.1 + grossSalarySubjectToMediumTaxBracket * 0.2 + grossSalarySubjectToUpperTaxBracket * 0.4;
    }
}
