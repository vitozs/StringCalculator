import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    ArrayBuilder arrayBuilder = new ArrayBuilder();
    public String add(String s) {
        List<String> list = arrayBuilder.getListOfNumbers(s);
        return makeSum(list);
    }
    private String makeSum(List<String> list){
        double result = 0;
        List<String> negativeNumbers = new ArrayList<>();
        for(String number : list){
            if(toDouble(number) < 0){
                negativeNumbers.add(number);
            }
            result += toDouble(number);
        }
        checkIfNegativeNumber(negativeNumbers);
        return toString(result);
    }
    private void checkIfNegativeNumber(List<String> negativeNumbers){
        if(negativeNumbers.size() > 0){
            throw new RuntimeException("Negative not allowed: " + String.join(", ", negativeNumbers));
        }
    }
    private Double toDouble(String number){
        return Double.valueOf(number);
    }
    private String toString(Double number){
        return String.valueOf(number);
    }
}
