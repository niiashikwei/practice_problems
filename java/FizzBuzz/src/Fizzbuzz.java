import java.io.PrintStream;

public class Fizzbuzz {

    public static void main(String args[]){
        fizzBuzz(System.out);
    }

    protected static void fizzBuzz(PrintStream printStream) {
        for (int i = 1; i < 101; i++){
            printStream.printf("%s \n", fizzBuzzInterpreter(i));
        }
    }

    protected static String fizzBuzzInterpreter(Integer numberToPrint) {
        boolean isMultipleOfFive = numberToPrint % 5 == 0;
        boolean isMultipleOfThree = numberToPrint % 3 == 0;

        if (isMultipleOfFive && isMultipleOfThree){
            return "FizzBuzz";
        }

        if (isMultipleOfThree){
            return "Fizz";
        }

        if (isMultipleOfFive){
            return "Buzz";
        }

        return numberToPrint.toString();
    }
}
