import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.Assert.assertEquals;

public class ReceiptTest {
    SalesTax salesTax;

    @Before
    public void setUp(){
        List<String> exemptGoods = newArrayList("book", "books", "chocolate", "chocolates", "headache pills");
        salesTax = new SalesTax(.1, exemptGoods, .05);
    }

    @Test
    public void shouldPrintReceiptTitleWithNumberOfInputFiles(){
        InputLine inputLine = new InputLine(1,"hat", 100.00);
        List<InputLine> items = newArrayList(inputLine);
        Receipt actualReceipt = new Receipt(items, salesTax);

        StringBuilder stringBuilder = new StringBuilder();
        String expectedStringReceipt = stringBuilder.append("Output:\n")
                                                    .append("1 hat: 100.00\n")
                                                    .append("Sales Taxes: 10.00\n")
                                                    .append("Total: 110.00")
                                                    .toString();

        assertEquals(expectedStringReceipt, actualReceipt.buildReceipt());
    }
}
