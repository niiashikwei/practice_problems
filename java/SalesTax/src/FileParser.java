import static java.lang.Integer.*;

public class FileParser {
    public static Item parseLine(String inputLine) {
        String[] splitUpInput = inputLine.split(" ");
        String itemName = splitUpInput[1];
        String firstCharacter = splitUpInput[0];
        double itemPrice = Double.parseDouble(splitUpInput[splitUpInput.length -1]);
        return new Item(parseInt(firstCharacter), itemName, itemPrice);
    }
}
