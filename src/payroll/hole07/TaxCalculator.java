package payroll.hole07;

public class TaxCalculator {
    private static double taxInBand(double lowerTaxBracketGross, double lowerTaxBracketRate) {
        return lowerTaxBracketGross * lowerTaxBracketRate;
    }

    private static double grossToTaxInBand(double grossSalary, int bracketMinimumGross) {
        return Math.max(grossSalary - bracketMinimumGross, 0.0);
    }

    private static double grossToTaxInBandsBelowCurrent(double grossSalary, double bracketMinimumGross) {
        return Math.min(grossSalary, bracketMinimumGross);
    }

    public double taxFor(final double grossSalary) {
        int upperTaxBracketStart = 40000;
        double upperTaxBracketRate = 0.4;
        final double upperTaxBracketGross = grossToTaxInBand(grossSalary, upperTaxBracketStart);
        int middleTaxBracketStart = 20000;
        double middleTaxBracketRate = 0.2;
        final double middleTaxBracketGross = grossToTaxInBand(grossToTaxInBandsBelowCurrent(grossSalary, upperTaxBracketStart), middleTaxBracketStart);
        int lowerTaxBracketStart = 5000;
        double lowerTaxBracketRate = 0.1;
        final double lowerTaxBracketGross = grossToTaxInBand(grossToTaxInBandsBelowCurrent(grossSalary, middleTaxBracketStart), lowerTaxBracketStart);
        return taxInBand(lowerTaxBracketGross, lowerTaxBracketRate) + taxInBand(middleTaxBracketGross, middleTaxBracketRate) + taxInBand(upperTaxBracketGross, upperTaxBracketRate);
    }
}
