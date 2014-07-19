import static java.lang.Integer.*;

public class FileParser {
    public static Item parseLine(String inputLine) {
        String[] splitUpInput = inputLine.split(" ");
        String itemName = splitUpInput[1];
        String firstCharacter = splitUpInput[0];
        return new Item(parseInt(firstCharacter), itemName);
    }
}
