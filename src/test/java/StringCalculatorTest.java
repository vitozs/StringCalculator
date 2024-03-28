import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    StringCalculator stringCalculator;
    @BeforeEach
    void setUp(){
        stringCalculator = new StringCalculator();
    }

    @Test
    void testAddNumbers(){
        String result = stringCalculator.add("1.1, 1.2, 3");
        Assertions.assertEquals("5.3", result);
    }
    @Test
    void testReturnZeroIfEmptyString(){
        String result = stringCalculator.add("");
        Assertions.assertEquals("0.0", result);
    }
    @Test
    void testDelimiter(){
        String result = stringCalculator.add("1\n2,3");
        Assertions.assertEquals("6.0", result);
    }
    @Test
    void testInvalidDelimiter(){
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, ()->{
            stringCalculator.add("175.2,\n35");
        });
        Assertions.assertEquals("Number expected but '\\n' found at position 6", exception.getMessage());
    }
    @Test
    void testCustomDelimiters(){
        String result = stringCalculator.add("//;\n1;2");
        Assertions.assertEquals("3.0", result);

        String result2 = stringCalculator.add("//|\n1|2|3");
        Assertions.assertEquals("6.0", result2);

        String result3 = stringCalculator.add("//sep\n2sep3");
        Assertions.assertEquals("5.0", result3);
    }
    @Test
    void testInvalidCustomDelimiter(){
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, ()->{
            stringCalculator.add("//|\n1|2,4");
        });
        Assertions.assertEquals("'|' expected but '2,4' found at position 3.", exception.getMessage());
    }
    @Test
    void testInvalidEndOfString(){
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, ()->{
            stringCalculator.add("1\n2,");
        });
        Assertions.assertEquals("Number expected but EOF found.", exception.getMessage());
    }
    @Test
    void testAddNegativeNumbers(){
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, ()->{
            stringCalculator.add("-1,-4,5");
        });
        Assertions.assertEquals("Negative not allowed: -1, -4", exception.getMessage());
    }

}
