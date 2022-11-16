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
        int lowerTaxBracketStart = 5000;
        final double lowerTaxBracketGross = grossToTaxInBand(grossToTaxInBandsBelowCurrent(grossSalary, middleTaxBracketStart), lowerTaxBracketStart);
        int upperTaxBracketStart = 40000;
        final double middleTaxBracketGross = grossToTaxInBand(grossToTaxInBandsBelowCurrent(grossSalary, upperTaxBracketStart), middleTaxBracketStart);
        final double upperTaxBracketGross = grossToTaxInBand(grossSalary, upperTaxBracketStart);
        double lowerTaxBracketRate  = 0.1;
        return taxInBand(lowerTaxBracketGross, lowerTaxBracketRate ) + taxInBand(middleTaxBracketGross, 0.2) + taxInBand(upperTaxBracketGross, 0.4);
    }
}
