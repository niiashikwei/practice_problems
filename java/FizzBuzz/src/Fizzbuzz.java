public class Fizzbuzz {


    public static void main(String args[]){
        for (int i = 1; i < 101; i++){
            System.out.printf("%s \n", fizzBuzzInterpreter(i));
        }
    }

    public static String fizzBuzzInterpreter(Integer numberToPrint) {
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
