package payroll.hole06;

public class TaxCalculator {
    private static double taxInBand(double lowerTaxBracketGross, double x) {
        return lowerTaxBracketGross * x;
    }

    private static double grossToTaxInBand(double grossSalary, int x) {
        return Math.max(grossSalary - x, 0.0);
    }

    private static double grossToTaxInBandsBelowCurrent(double grossSalary, double b) {
        return Math.min(grossSalary, b);
    }

    public double taxFor(final double grossSalary) {
        int middleTaxBracketStart = 20000;
        int lowerTaxBracketStart  = 5000;
        final double lowerTaxBracketGross = grossToTaxInBand(grossToTaxInBandsBelowCurrent(grossSalary, middleTaxBracketStart), lowerTaxBracketStart );
        final double middleTaxBracketGross = grossToTaxInBand(grossToTaxInBandsBelowCurrent(grossSalary, 40000), middleTaxBracketStart);
        final double upperTaxBracketGross = grossToTaxInBand(grossSalary, 40000);
        return taxInBand(lowerTaxBracketGross, 0.1) + taxInBand(middleTaxBracketGross, 0.2) + taxInBand(upperTaxBracketGross, 0.4);
    }
}
