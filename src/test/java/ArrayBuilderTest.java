import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ArrayBuilderTest {
    ArrayBuilder arrayBuilder;
    @BeforeEach
    void setUp(){
        arrayBuilder = new ArrayBuilder();
    }

    @Test
    void testBuildListWithDefaultDelimiter(){
        List<String> numbers = arrayBuilder.buildListWithDefaultDelimiter("1\n3,4");
        List<String> expected = Arrays.asList("1","3","4");

        Assertions.assertEquals(expected, numbers);
    }

    @Test
    void testBuildListWithCustomDelimiter(){
        List<String> numbers = arrayBuilder.buildListWithCustomDelimiter("//g\n1g2g4g");
        List<String> expected = Arrays.asList("1","2","4");

        Assertions.assertEquals(expected, numbers);
    }

    @Test
    void returnArrayWithDelimiter(){
        List<String> numbers = arrayBuilder.returnArrayWithDelimiter("//g\n1g2g4g");
        List<String> expected = Arrays.asList("1","2","4");
        Assertions.assertEquals(expected, numbers);

        List<String> numbers2 = arrayBuilder.returnArrayWithDelimiter("1\n2,3");
        List<String> expected2 = Arrays.asList("1","2","3");
        Assertions.assertEquals(expected2, numbers2);
    }

}
