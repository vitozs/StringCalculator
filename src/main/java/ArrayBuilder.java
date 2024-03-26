import java.util.Arrays;
import java.util.List;
public class ArrayBuilder {
    StringValidator stringValidator = new StringValidator();
    public List<String> getListOfNumbers(String values){
        if(values.isEmpty()){
            return List.of("0");
        }
        return returnArrayWithDelimiter(values);
    }
    private List<String> returnArrayWithDelimiter(String values){
        stringValidator.checkEndOfString(values);
        if(stringValidator.hasACustomDelimiter(values)){
            return buildListWithCustomDelimiter(values);
        }
        return buildListWithDefaultDelimiter(values);
    }
    private List<String> buildListWithDefaultDelimiter(String values) {
        List<String> list = Arrays.asList(values.split("[\n,]"));
        int indexOfInvalidDelimiter = 1;

        for(String num : list){
            indexOfInvalidDelimiter += num.length();
            if(num.isEmpty()){
                throw new RuntimeException("Number expected but '\\n' found at position " + (indexOfInvalidDelimiter));
            }
        }
        return list;
    }
    private List<String> buildListWithCustomDelimiter(String values){
        String delimiterFromString = values.substring(2, values.indexOf("\n"));
        int beginOfString = values.indexOf("\n") + 1;
        List<String> arrayFormatted = Arrays.asList(
                values.substring(beginOfString)
                        .split("\\Q" + delimiterFromString + "\\E")
        );
        stringValidator.checkCustomDelimiter(delimiterFromString, arrayFormatted);
        return arrayFormatted;
    }


}
