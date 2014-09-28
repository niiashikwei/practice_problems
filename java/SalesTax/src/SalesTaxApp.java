import java.io.*;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class SalesTaxApp {
    BigDecimal BASICSALESTAX = new BigDecimal("0.10");
    BigDecimal IMPORTTAX = new BigDecimal("0.05");
    List<String> EXEMPTGOODS = newArrayList("book", "books", "chocolate", "chocolates", "headache pills");
    PrintStream printStream;
    SalesTax salesTax;
    String[] filePaths;

    public static void main(String[] filePaths){
        SalesTaxApp salesTaxApp = new SalesTaxApp(filePaths);
        salesTaxApp.printOutput();
    }

    public SalesTaxApp(String[] filePaths){
        this.filePaths = filePaths;
        this.printStream = System.out;
        this.salesTax = new SalesTax(BASICSALESTAX, EXEMPTGOODS, IMPORTTAX);
    }

    private void printOutput(){
        try {
            for (int i = 0; i < filePaths.length; i++){
                BufferedReader bufferedReader = new BufferedReader(new FileReader(filePaths[i]));
                List<InputLine> inputLines = FileParser.parseInput(bufferedReader);
                Receipt receipt = new Receipt(inputLines, salesTax);
                printStream.print(receipt.buildReceipt(i));
            }
            printStream.print("==========");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
