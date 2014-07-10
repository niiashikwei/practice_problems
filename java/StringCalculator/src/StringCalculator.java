public class StringCalculator {

    public int sum(String inputString) {
        int sum = 0;
        if(!inputString.isEmpty()){
            String[] charArray = inputString.split(",");
            for(int index = 0; index < charArray.length; index++){
                String stringNumber = charArray[index].trim();
                sum += Integer.parseInt(stringNumber);
            }
        }
        return sum;
    }
}
