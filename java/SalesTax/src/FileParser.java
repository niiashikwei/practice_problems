import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileParser {
    public static Item parseLine(String inputLine) {
        String stringPattern = "(\\d+) (.*) at (\\d+.\\d{2})";
        Pattern inputPattern = Pattern.compile(stringPattern);
        Matcher matcher = inputPattern.matcher(inputLine);
        if(matcher.matches()){
            int itemQuantity = Integer.parseInt(matcher.group(1));
            String itemName = matcher.group(2);
            double itemPrice = Double.parseDouble(matcher.group(3));
            return new Item(itemQuantity, itemName, itemPrice);
        }
        return null;
    }
}