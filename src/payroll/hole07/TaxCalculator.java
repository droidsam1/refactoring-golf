package payroll.hole07;

public class TaxCalculator {

    public double taxFor(final double grossSalary) {
        TaxBand upperTaxBand = new TaxBand(40000, 0.4);
        final double upperTaxBracketGross = upperTaxBand.grossToTaxInBand(grossSalary);
        TaxBand middleTaxBand = new TaxBand(20000, 0.2);
        final double middleTaxBracketGross = middleTaxBand.grossToTaxInBand(upperTaxBand.grossToTaxInBandsBelowCurrent(grossSalary));
        TaxBand lowerTaxBand = new TaxBand(5000, 0.1);
        final double lowerTaxBracketGross = lowerTaxBand.grossToTaxInBand(middleTaxBand.grossToTaxInBandsBelowCurrent(grossSalary));
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

        private double grossToTaxInBand(double grossSalaryExcludingPartAlreadyTaxedAtHigherRate) {
            return Math.max(grossSalaryExcludingPartAlreadyTaxedAtHigherRate - taxBracketStart, 0.0);
        }

        private double grossToTaxInBandsBelowCurrent(double grossSalary) {
            return Math.min(grossSalary, taxBracketStart);
        }
    }
}
