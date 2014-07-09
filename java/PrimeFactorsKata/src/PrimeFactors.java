import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {
    protected static List<Integer> getPrimeFactors(int number){
        List<Integer> result = new ArrayList<Integer>();

        for(int potentialPrime = 2; number > 1; potentialPrime++){
            for ( ; number % potentialPrime == 0; number /=  potentialPrime){
                result.add(potentialPrime);
            }
        }

        return result;
    }
}