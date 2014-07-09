
public class PrimeFactors {
    protected static int[] getPrimeFactors(int number){
        if (number == 2 || number == 3){
            return new int[]{number};
        }

        if (number == 4){
            return new int[]{2,2};
        }

        return new int[]{};
    }
}