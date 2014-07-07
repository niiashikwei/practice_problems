import java.io.PrintStream;

public class Fizzbuzz {
    PrintStream printStream;

    public static void main(String args[]){
        Fizzbuzz fizzbuzz = new Fizzbuzz(System.out);
        fizzbuzz.printNumbersUpTo(100);
    }

    public Fizzbuzz(PrintStream printStream){
        this.printStream = printStream;
    }

    protected void printNumbersUpTo(int maximumNumber) {
        int startingNumber = 1;
        for (int i = startingNumber; i <= maximumNumber; i++){
            fizzBuzzInterpreter(i);
        }
    }

    protected void fizzBuzzInterpreter(Integer numberToPrint) {
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
