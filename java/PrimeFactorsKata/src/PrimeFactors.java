import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {
    protected static List<Integer> getPrimeFactors(int number){
        List<Integer> result = new ArrayList<Integer>();
        if (number == 2 || number == 3){
            result.add(number);
        }

        if (number == 4){
            result.add(2);
            result.add(2);
        }

        return result;
    }
}