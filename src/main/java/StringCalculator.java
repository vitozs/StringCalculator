import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    ArrayBuilder arrayBuilder = new ArrayBuilder();
    public String add(String values) {
        List<String> list = arrayBuilder.getListOfNumbers(values);
        return makeSum(list);
    }
    public String makeSum(List<String> list){
        double result = 0;
        List<String> negativeNumbers = new ArrayList<>();

        for(String stringNumber : list){
            double number = toDouble(stringNumber);
            if(number < 0){
                negativeNumbers.add(stringNumber);
            }
            result += number;
        }
        checkIfNegativeNumber(negativeNumbers);
        return toString(result);
    }
    public void checkIfNegativeNumber(List<String> negativeNumbers){
        if(!negativeNumbers.isEmpty()){
            throw new RuntimeException("Negative not allowed: " + String.join(", ", negativeNumbers));
        }
    }
    public Double toDouble(String number){
        return Double.valueOf(number);
    }
    public String toString(Double number){
        return String.valueOf(number);
    }
}
