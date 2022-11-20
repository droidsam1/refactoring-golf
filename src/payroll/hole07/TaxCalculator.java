package payroll.hole07;

public class TaxCalculator {

    public double taxFor(final double grossSalary) {
        int upperTaxBracketStart = 40000;
        double upperTaxBracketRate = 0.4;
        TaxBand upperTaxBand = new TaxBand(upperTaxBracketStart, upperTaxBracketRate);
        final double upperTaxBracketGross = upperTaxBand.grossToTaxInBand(grossSalary, upperTaxBracketStart);
        int middleTaxBracketStart = 20000;
        double middleTaxBracketRate = 0.2;
        final double middleTaxBracketGross = TaxBand.grossToTaxInBand(TaxBand.grossToTaxInBandsBelowCurrent(grossSalary, upperTaxBracketStart), middleTaxBracketStart);
        int lowerTaxBracketStart = 5000;
        double lowerTaxBracketRate = 0.1;
        final double lowerTaxBracketGross = TaxBand.grossToTaxInBand(TaxBand.grossToTaxInBandsBelowCurrent(grossSalary, middleTaxBracketStart), lowerTaxBracketStart);
        return TaxBand.taxInBand(lowerTaxBracketGross, lowerTaxBracketRate) + TaxBand.taxInBand(middleTaxBracketGross, middleTaxBracketRate) + TaxBand.taxInBand(upperTaxBracketGross, upperTaxBracketRate);
    }

    public static class TaxBand {

        private final int taxBracketStart;
        private final double taxBracketRate;

        public TaxBand(int taxBracketStart, double taxBracketRate) {
            this.taxBracketStart = taxBracketStart;
            this.taxBracketRate = taxBracketRate;
        }

        private static double taxInBand(double lowerTaxBracketGross, double lowerTaxBracketRate) {
            return lowerTaxBracketGross * lowerTaxBracketRate;
        }

        private static double grossToTaxInBand(double grossSalary, double bracketMinimumGross) {
            return Math.max(grossSalary - bracketMinimumGross, 0.0);
        }

        private static double grossToTaxInBandsBelowCurrent(double grossSalary, double bracketMinimumGross) {
            return Math.min(grossSalary, bracketMinimumGross);
        }
    }
}
