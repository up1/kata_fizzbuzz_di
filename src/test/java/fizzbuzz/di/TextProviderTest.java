package fizzbuzz.di;

import static org.junit.Assert.*;

import org.junit.Test;

public class TextProviderTest {
    
    @Test
    public void sameInput() {
        TextProvider textProvider = new TextProvider();
        String actualResult = textProvider.getText(1);
        assertEquals("1", actualResult);
    }
    
    @Test
    public void devideByThreeShouldBeFizz() {
        TextProvider textProvider = new TextProvider();
        String actualResult = textProvider.getText(3);
        assertEquals("Fizz", actualResult);
    }
    
    @Test
    public void devideByFiveShouldBeBuzz() {
        TextProvider textProvider = new TextProvider();
        String actualResult = textProvider.getText(5);
        assertEquals("Buzz", actualResult);
    }
    
    @Test
    public void devideByThreeAndFiveShouldBeFizzBuzz() {
        TextProvider textProvider = new TextProvider();
        String actualResult = textProvider.getText(15);
        assertEquals("FizzBuzz", actualResult);
    }
    

}
