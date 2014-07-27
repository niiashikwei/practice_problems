import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.Assert.assertEquals;

public class SalesTaxTest {
    SalesTax salesTax;

    @Before
    public void setUp(){
        double BASICSALESTAX = 0.1;
        List<String> exemptGoods = newArrayList("book", "books", "chocolate", "chocolates", "headache pills");
        double IMPORTTAX = 0.05;
        salesTax = new SalesTax(BASICSALESTAX, exemptGoods, IMPORTTAX);
    }

    @Test
    public void shouldCalculateTenPercentBasicSalesTaxOnNonExemptGoods(){
        InputLine inputLine = new InputLine(1,"hat", 100.00);
        double expectedBasicSalesTax = 10.00;
        double actualBasicSalesTax = salesTax.getBasicSalesTax(inputLine);
        assertEquals(expectedBasicSalesTax, actualBasicSalesTax, 0);
    }

    @Test
    public void shouldNotCalculateBasicSalesTaxForExemptGoods(){
        InputLine inputLine = new InputLine(1,"book", 100.00);
        double expectedBasicSalesTax = 0.00;
        double actualBasicSalesTax = salesTax.getBasicSalesTax(inputLine);
        assertEquals(expectedBasicSalesTax, actualBasicSalesTax, 0);
    }

    @Test
    public void shouldCalculateImportDutyForAllImportedGoods(){
        InputLine inputLine = new InputLine(1, "imported box of chocolates", 10.00);
        double expectedImportDuty = 0.50;
        double actualImportDuty = salesTax.getImportDuty(inputLine);
        assertEquals(expectedImportDuty, actualImportDuty, 0);
    }

    @Test
    public void shouldNotCalculateImportDutyForLocalGoods(){
        InputLine inputLine = new InputLine(1,"book", 100.00);
        double expectedImportDuty = 0.00;
        double actualImportDuty = salesTax.getImportDuty(inputLine);
        assertEquals(expectedImportDuty, actualImportDuty, 0);
    }

    @Test
    public void shouldCalculateTheTotalSalesTaxForALocalItem(){
        InputLine inputLine = new InputLine(1, "hat", 100.00);
        double expectedTotalSalesTax = 10.0;
        double actualTotalSalesTax = salesTax.getTotalSalesTax(inputLine);
        assertEquals(expectedTotalSalesTax, actualTotalSalesTax, 0);
    }

    @Test
    public void shouldCalculateTheTotalSalesTaxForAnImportedItem(){
        InputLine inputLine = new InputLine(1, "imported bottle of perfume", 100.00);
        double expectedTotalSalesTax = 15.0;
        double actualTotalSalesTax = salesTax.getTotalSalesTax(inputLine);
        assertEquals(expectedTotalSalesTax, actualTotalSalesTax, 0);
    }

    @Test
    public void shouldCalculateTheTotalSalesTaxForAnExemptImportedItem(){
        InputLine inputLine = new InputLine(1, "imported box of chocolates", 100.00);
        double expectedTotalSalesTax = 5.0;
        double actualTotalSalesTax = salesTax.getTotalSalesTax(inputLine);
        assertEquals(expectedTotalSalesTax, actualTotalSalesTax, 0);
    }

    @Test
    public void shouldCalculateTheTotalSalesTaxForAnExemptLocalItemAsZero(){
        InputLine inputLine = new InputLine(1, "packet of headache pills", 100.00);
        double expectedTotalSalesTax = 0.0;
        double actualTotalSalesTax = salesTax.getTotalSalesTax(inputLine);
        assertEquals(expectedTotalSalesTax, actualTotalSalesTax, 0);
    }

    @Test
    public void shouldCalculatePriceAfterTaxIsApplied(){
        InputLine inputLine = new InputLine(1, "hat", 100.00);
        double expectedPriceWithTax = 110.0;
        double actualPriceWithTax = salesTax.getPriceWithTax(inputLine);
        assertEquals(expectedPriceWithTax, actualPriceWithTax, 0);
    }

}
