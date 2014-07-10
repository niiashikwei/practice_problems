import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class StringCalculator {

    public List<Integer> convertString(String inputNumber) {
        List<Integer> result = newArrayList();
        if(!inputNumber.isEmpty()){
            String[] charArray = inputNumber.split(",");
            for(int index = 0; index < charArray.length; index++){
                String stringNumber = charArray[index].trim();
                result.add(Integer.parseInt(stringNumber));
            }
        }
        return result;
    }

    public int sum(String inputString) {
        List<Integer> integers = convertString(inputString);
        int sum = 0;
        for(int integer : integers){
            sum += integer;
        }
        return sum;
    }
}
