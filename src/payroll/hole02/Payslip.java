package payroll.hole02;


public class Payslip {
    private final double grossSalary;

    public Payslip(final double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public double getNet() {
        final double grossSalarySubjectToLowerTaxBracket = Math.max(Math.min(grossSalary, 20000.0) - 5000, 0.0);
        final double mtbg = Math.max(Math.min(grossSalary, 40000) - 20000, 0.0);
        final double utbg = Math.max(grossSalary - 40000, 0.0);
        return grossSalary - (grossSalarySubjectToLowerTaxBracket * 0.1 + mtbg * 0.2 + utbg * 0.4);
    }
}
