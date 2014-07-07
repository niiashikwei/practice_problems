import java.io.PrintStream;

public class Fizzbuzz {

    public static void main(String args[]){
        fizzBuzz();
    }

    protected static void fizzBuzz() {
        for (int i = 1; i < 101; i++){
            fizzBuzzInterpreter(i, System.out);
        }
    }

    protected static void fizzBuzzInterpreter(Integer numberToPrint, PrintStream printStream) {
        boolean isMultipleOfFive = numberToPrint % 5 == 0;
        boolean isMultipleOfThree = numberToPrint % 3 == 0;

        if (isMultipleOfThree){
            printStream.print("Fizz");
        }

        if (isMultipleOfFive){
            printStream.print("Buzz");
        }else{
            printStream.print(numberToPrint);
        }

        printStream.println();
    }
}
