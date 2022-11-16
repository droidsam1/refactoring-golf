package payroll.hole05;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PayslipTest {

    public static final double DELTA = 1e-6;

    @Test
    public void taxIsZeroIfGrossIsBelowTaxFreeLimit() {
        int grossSalary = 5000;
        int expectedNet = 5000;
        final Payslip payslip = new Payslip(grossSalary, new TaxCalculator());
        assertEquals(expectedNet, payslip.getNet(), DELTA);
    }

    @Test
    public void taxOnAmountInLowerTaxBracketExcludesTaxFreeLimit() {
        final Payslip payslip = new Payslip(10000, new TaxCalculator());
        assertEquals(9500, payslip.getNet(), DELTA);

        final Payslip payslip2 = new Payslip(20000, new TaxCalculator());
        assertEquals(18500, payslip2.getNet(), DELTA);
    }

    @Test
    public void taxOnAmountInMiddleTaxBracketIsSumOfLowerTaxBracketAmountAndAdditionalMiddleTaxBracketAmount() {
        final Payslip payslip = new Payslip(25000, new TaxCalculator());
        assertEquals(22500, payslip.getNet(), DELTA);

        final Payslip payslip2 = new Payslip(40000, new TaxCalculator());
        assertEquals(34500, payslip2.getNet(), DELTA);
    }

    @Test
    public void taxOnAmountInUpperTaxBracketIsSumOfLowerTaxBracketAmountAndMiddleTaxBracketAmountAndAdditionalUpperTaxBracketAmount() {
        final Payslip payslip = new Payslip(50000, new TaxCalculator());
        assertEquals(40500, payslip.getNet(), DELTA);

        final Payslip payslip2 = new Payslip(60000, new TaxCalculator());
        assertEquals(46500, payslip2.getNet(), DELTA);
    }
}
