import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.Assert.assertEquals;

public class SalesTaxTest {
    SalesTax salesTax;

    @Before
    public void setUp(){
        BigDecimal BASICSALESTAX = new BigDecimal("0.1");
        List<String> exemptGoods = newArrayList("book", "books", "chocolate", "chocolates", "headache pills");
        BigDecimal IMPORTTAX = new BigDecimal("0.05");
        salesTax = new SalesTax(BASICSALESTAX, exemptGoods, IMPORTTAX);
    }

    @Test
    public void shouldCalculateTenPercentBasicSalesTaxOnNonExemptGoods(){
        InputLine inputLine = new InputLine(1,"hat", new BigDecimal("100.00"));
        BigDecimal expectedBasicSalesTax = new BigDecimal("10.000");
        BigDecimal actualBasicSalesTax = salesTax.getBasicSalesTax(inputLine);
        assertEquals(expectedBasicSalesTax, actualBasicSalesTax);
    }

    @Test
    public void shouldNotCalculateBasicSalesTaxForExemptGoods(){
        InputLine inputLine = new InputLine(1,"book", new BigDecimal("100.00"));
        BigDecimal expectedBasicSalesTax = new BigDecimal("0.00");
        BigDecimal actualBasicSalesTax = salesTax.getBasicSalesTax(inputLine);
        assertEquals(expectedBasicSalesTax, actualBasicSalesTax);
    }

    @Test
    public void shouldCalculateImportDutyForAllImportedGoods(){
        InputLine inputLine = new InputLine(1, "imported box of chocolates", new BigDecimal("10.00"));
        BigDecimal expectedImportDuty = new BigDecimal("0.5000");
        BigDecimal actualImportDuty = salesTax.getImportDuty(inputLine);
        assertEquals(expectedImportDuty, actualImportDuty);
    }

    @Test
    public void shouldNotCalculateImportDutyForLocalGoods(){
        InputLine inputLine = new InputLine(1,"book", new BigDecimal("100.00"));
        BigDecimal expectedImportDuty = new BigDecimal("0.00");
        BigDecimal actualImportDuty = salesTax.getImportDuty(inputLine);
        assertEquals(expectedImportDuty, actualImportDuty);
    }

    @Test
    public void shouldCalculateTheTotalSalesTaxForALocalItem(){
        InputLine inputLine = new InputLine(1, "hat", new BigDecimal("100.00"));
        BigDecimal expectedTotalSalesTax = new BigDecimal("10.000");
        BigDecimal actualTotalSalesTax = salesTax.getSalesTax(inputLine);
        assertEquals(expectedTotalSalesTax, actualTotalSalesTax);
    }

    @Test
    public void shouldCalculateTheTotalSalesTaxForAnImportedItem(){
        InputLine inputLine = new InputLine(1, "imported bottle of perfume", new BigDecimal("100.00"));
        BigDecimal expectedTotalSalesTax = new BigDecimal("15.0000");
        BigDecimal actualTotalSalesTax = salesTax.getSalesTax(inputLine);
        assertEquals(expectedTotalSalesTax, actualTotalSalesTax);
    }

    @Test
    public void shouldCalculateTheTotalSalesTaxForAnExemptImportedItem(){
        InputLine inputLine = new InputLine(1, "imported box of chocolates", new BigDecimal("100.00"));
        BigDecimal expectedTotalSalesTax = new BigDecimal("5.0000");
        BigDecimal actualTotalSalesTax = salesTax.getSalesTax(inputLine);
        assertEquals(expectedTotalSalesTax, actualTotalSalesTax);
    }

    @Test
    public void shouldCalculateTheTotalSalesTaxForAnExemptLocalItemAsZero(){
        InputLine inputLine = new InputLine(1, "packet of headache pills", new BigDecimal("100.00"));
        BigDecimal expectedTotalSalesTax = new BigDecimal("0.00");
        BigDecimal actualTotalSalesTax = salesTax.getSalesTax(inputLine);
        assertEquals(expectedTotalSalesTax, actualTotalSalesTax);
    }

    @Test
    public void shouldCalculatePriceAfterTaxIsApplied(){
        InputLine inputLine = new InputLine(1, "hat", new BigDecimal("100.00"));
        BigDecimal expectedPriceWithTax = new BigDecimal("110.000");
        BigDecimal actualPriceWithTax = salesTax.getShelfPrice(inputLine);
        assertEquals(expectedPriceWithTax, actualPriceWithTax);
    }

    @Test
    public void shouldRoundUpSalesTaxToTheNearestFiveCentAmountForShelfPrice(){
        InputLine inputLine = new InputLine(1, "imported bottle of perfume", new BigDecimal("47.50"));
        BigDecimal expectedShelfPrice = new BigDecimal("54.65");
        BigDecimal actualShelfPrice = salesTax.getShelfPrice(inputLine);
        assertEquals(expectedShelfPrice, actualShelfPrice);
    }

}
