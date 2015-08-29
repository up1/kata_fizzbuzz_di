package fizzbuzz.di;

import static org.junit.Assert.*;

import java.util.stream.Stream;

import org.junit.Test;

public class NumberProviderTest {

    @Test
    public void numberStartWithOne() {
        NumberProvider numberProvider = new NumberProvider();
        Stream<Integer> numbers = numberProvider.getNumbers();
        assertEquals(1, numbers.findFirst().get().intValue());
    }
    
    @Test
    public void checkSize() {
        NumberProvider numberProvider = new NumberProvider();
        Stream<Integer> numbers = numberProvider.getNumbers();
        assertTrue(numbers.count() == 100);
    }

}
