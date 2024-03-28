import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class StringValidatorTest {
    StringValidator stringValidator;

    @BeforeEach
    void setUp(){
        stringValidator = new StringValidator();
    }

    @Test
    void testExceptionIfCommaAtTheEndOfString(){
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, ()->{
            stringValidator.checkEndOfString("1,2,3,");
        });
        Assertions.assertEquals("Number expected but EOF found.", exception.getMessage());
    }

    @Test
    void testIfHasCustomLimiter(){
        Assertions.assertTrue(stringValidator.hasACustomDelimiter("//g\n1g,2g,3g"));
        Assertions.assertFalse(stringValidator.hasACustomDelimiter("1,2,3"));
        Assertions.assertFalse(stringValidator.hasACustomDelimiter("1\n2\n3"));
    }

    @Test
    void testIfValidCustomDelimiter(){
        List<String> list = Arrays.asList("1", "2", "|", "3");
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, ()->{
            stringValidator.checkCustomDelimiter("|", list);
        });
        Assertions.assertEquals("'|' expected but '|' found at position 2.", exception.getMessage());
    }
}
