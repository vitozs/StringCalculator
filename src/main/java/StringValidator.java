import java.util.List;

public class StringValidator {
    public void checkCustomDelimiter(String delimiterFromString, List<String> arrayFormatted){
        int indexOfInvalidDelimiter = 0;

        for(String num : arrayFormatted){
            indexOfInvalidDelimiter += num.length();
            if(!num.matches("^-?\\d*\\.?\\d+$")){
                throw new RuntimeException("'"+ delimiterFromString+ "' expected but '"+num+"' found at position " +(indexOfInvalidDelimiter-1) +".");
            }
        }
    }
    public boolean hasACustomDelimiter(String values){
        return values.startsWith("//");
    }
    public void checkEndOfString(String values){
        if(values.endsWith(",")) throw new RuntimeException("Number expected but EOF found.");
    }
}
