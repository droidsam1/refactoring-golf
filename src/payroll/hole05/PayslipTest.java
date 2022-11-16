package payroll.hole05;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PayslipTest {

    public static final double DELTA = 1e-6;

    private static void assertNetGivenGross(int grossSalary, int expectedNet) {
        final Payslip payslip = new Payslip(grossSalary, new TaxCalculator());
        assertEquals(expectedNet, payslip.getNet(), DELTA);
    }

    @Test
    public void taxIsZeroIfGrossIsBelowTaxFreeLimit() {
        assertNetGivenGross(5000, 5000);
    }

    @Test
    public void taxOnAmountInLowerTaxBracketExcludesTaxFreeLimit() {
        assertNetGivenGross(10000, 9500);

        assertNetGivenGross(20000, 18500);
    }

    @Test
    public void taxOnAmountInMiddleTaxBracketIsSumOfLowerTaxBracketAmountAndAdditionalMiddleTaxBracketAmount() {
        assertNetGivenGross(25000, 22500);

        assertNetGivenGross(40000, 34500);
    }

    @Test
    public void taxOnAmountInUpperTaxBracketIsSumOfLowerTaxBracketAmountAndMiddleTaxBracketAmountAndAdditionalUpperTaxBracketAmount() {
        assertNetGivenGross(50000, 40500);

        assertNetGivenGross(60000, 46500);
    }
}
