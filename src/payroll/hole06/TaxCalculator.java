package payroll.hole06;

public class TaxCalculator {
	public double taxFor(final double grossSalary) {
		final double lowerTaxBracketGross = grossToTaxInBand(grossToTaxInBandsBelowCurrent(grossSalary, 20000.0), 5000);
		final double middleTaxBracketGross = grossToTaxInBand(grossToTaxInBandsBelowCurrent(grossSalary, 40000), 20000);
		final double upperTaxBracketGross = grossToTaxInBand(grossSalary, 40000);
		return lowerTaxBracketGross * 0.1 + middleTaxBracketGross * 0.2 + upperTaxBracketGross * 0.4;
	}

	private static double grossToTaxInBand(double grossSalary, int x) {
		return Math.max(grossSalary - x, 0.0);
	}

	private static double grossToTaxInBandsBelowCurrent(double grossSalary, double b) {
		return Math.min(grossSalary, b);
	}
}
