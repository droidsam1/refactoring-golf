package payroll.hole07;

public class TaxCalculator {

    public double taxFor(final double grossSalary) {
        int upperTaxBracketStart = 40000;
        double upperTaxBracketRate = 0.4;
        TaxBand upperTaxBand = new TaxBand(upperTaxBracketStart, upperTaxBracketRate);
        final double upperTaxBracketGross = upperTaxBand.grossToTaxInBand(grossSalary, upperTaxBracketStart);
        int middleTaxBracketStart = 20000;
        double middleTaxBracketRate = 0.2;
        TaxBand middleTaxBand = new TaxBand(middleTaxBracketStart, middleTaxBracketRate);
        final double middleTaxBracketGross = middleTaxBand.grossToTaxInBand(upperTaxBand.grossToTaxInBandsBelowCurrent(grossSalary), middleTaxBracketStart);
        int lowerTaxBracketStart = 5000;
        double lowerTaxBracketRate = 0.1;
        TaxBand lowerTaxBand = new TaxBand(lowerTaxBracketStart, lowerTaxBracketRate);
        final double lowerTaxBracketGross = lowerTaxBand.grossToTaxInBand(middleTaxBand.grossToTaxInBandsBelowCurrent(grossSalary), lowerTaxBracketStart);
        return lowerTaxBand.taxInBand(lowerTaxBracketGross) + middleTaxBand.taxInBand(middleTaxBracketGross) + upperTaxBand.taxInBand(upperTaxBracketGross);
    }

    public class TaxBand {

        private final int taxBracketStart;
        private final double taxBracketRate;

        public TaxBand(int taxBracketStart, double taxBracketRate) {
            this.taxBracketStart = taxBracketStart;
            this.taxBracketRate = taxBracketRate;
        }

        private double taxInBand(double lowerTaxBracketGross) {
            return lowerTaxBracketGross * taxBracketRate;
        }

        private double grossToTaxInBand(double grossSalary, double taxBracketStart) {
            return Math.max(grossSalary - taxBracketStart, 0.0);
        }

        private double grossToTaxInBandsBelowCurrent(double grossSalary) {
            return Math.min(grossSalary, taxBracketStart);
        }
    }
}
