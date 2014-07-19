import com.google.common.base.Joiner;

import java.util.ArrayList;

import static com.google.common.collect.Lists.newArrayList;
import static java.lang.Integer.parseInt;

public class FileParser {
    public static Item parseLine(String inputLine) {
        ArrayList<String> splitUpInput = newArrayList(inputLine.split(" "));
        String firstCharacter = splitUpInput.remove(0);
        String lastToken = splitUpInput.remove(splitUpInput.size() - 1);
        double itemPrice = Double.parseDouble(lastToken);
        splitUpInput.remove(splitUpInput.size() - 1);
        String itemName = Joiner.on(" ").join(splitUpInput);
        return new Item(parseInt(firstCharacter), itemName, itemPrice);
    }
}
