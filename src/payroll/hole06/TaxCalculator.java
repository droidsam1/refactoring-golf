package payroll.hole06;

public class TaxCalculator {
	public double taxFor(final double grossSalary) {
		final double lowerTaxBracketGross = Math.max(grossToTaxInBandsBelowCurrent(grossSalary, 20000.0) - 5000, 0.0);
		final double middleTaxBracketGross = Math.max(grossToTaxInBandsBelowCurrent(grossSalary, 40000) - 20000, 0.0);
		final double upperTaxBracketGross = Math.max(grossSalary - 40000, 0.0);
		return lowerTaxBracketGross * 0.1 + middleTaxBracketGross * 0.2 + upperTaxBracketGross * 0.4;
	}

	private static double grossToTaxInBandsBelowCurrent(double grossSalary, double b) {
		return Math.min(grossSalary, b);
	}
}
