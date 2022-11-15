package payroll.hole04;

public class TaxCalculator {
    public TaxCalculator() {
    }

    public double getTaxDeductions(double grossSalary1) {
        final double grossSalarySubjectToLowerTaxBracket = Math.max(Math.min(grossSalary1, 20000.0) - 5000, 0.0);
        final double grossSalarySubjectToMediumTaxBracket = Math.max(Math.min(grossSalary1, 40000) - 20000, 0.0);
        final double grossSalarySubjectToUpperTaxBracket = Math.max(grossSalary1 - 40000, 0.0);
        return grossSalarySubjectToLowerTaxBracket * 0.1 + grossSalarySubjectToMediumTaxBracket * 0.2 + grossSalarySubjectToUpperTaxBracket * 0.4;
    }
}