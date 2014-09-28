import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.google.common.collect.Lists.newArrayList;

public class FileParser {

    public static InputLine parseLine(String inputLine) {
        String stringPattern = "(\\d+) (.*) at (\\d+.\\d{2})";
        Pattern inputPattern = Pattern.compile(stringPattern);
        Matcher matcher = inputPattern.matcher(inputLine);
        if(matcher.matches()){
            int itemQuantity = Integer.parseInt(matcher.group(1));
            String itemName = matcher.group(2);
            BigDecimal itemPrice = new BigDecimal(matcher.group(3));
            return new InputLine(itemQuantity, itemName, itemPrice);
        }
        return null;
    }

    public static List<InputLine> parseInput(BufferedReader bufferedReader) throws IOException {
        List<InputLine> items = newArrayList();
        String currentLine = bufferedReader.readLine();
        while(currentLine != null){
            if(!currentLine.contains("Input")){
                InputLine item = parseLine(currentLine);
                items.add(item);
            }
            currentLine = bufferedReader.readLine();
        }
        return items;
    }


}