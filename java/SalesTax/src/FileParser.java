import static java.lang.Character.*;

public class FileParser {
    public static int parseLine(String inputLine) {
        char firstCharacter = inputLine.charAt(0);
        return getNumericValue(firstCharacter);
    }
}
