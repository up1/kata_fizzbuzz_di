package fizzbuzz.di;

import static org.junit.Assert.*;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class FizzBuzzDITest {
    private boolean isCalled = false;
    
    @Mock
    TextProvider textProvider;
    
    @Mock
    Printer printer;
    
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getNumbersFromNumberProvider() throws Exception {
        MyFizzBuzz myFizzBuzz = new MyFizzBuzz();
        myFizzBuzz.setNumberProvider(new NumberProvider() {
            public Stream<Integer> getNumbers() {
                isCalled = true;
                return IntStream.rangeClosed(1, 3).boxed();
            }
        });
        
        myFizzBuzz.setTextProvider(textProvider);
        myFizzBuzz.setPrinter(printer);
        
        myFizzBuzz.startProcess();
        
        assertTrue(isCalled);       
    }
    
    @Test
    public void generatedMessage() {
        MyFizzBuzz myFizzBuzz = new MyFizzBuzz();
        myFizzBuzz.setNumberProvider(new NumberProvider() {
            public Stream<Integer> getNumbers() {
                return IntStream.rangeClosed(1, 3).boxed();
            }
        });
        
        myFizzBuzz.setTextProvider(textProvider);
        myFizzBuzz.setPrinter(printer);
        
        myFizzBuzz.startProcess();
       
        InOrder order = Mockito.inOrder(textProvider);
        order.verify(textProvider).getText(1);
        order.verify(textProvider).getText(2);
        order.verify(textProvider).getText(3); 
    }
    
    @Test
    public void printedMessage() {
        MyFizzBuzz myFizzBuzz = new MyFizzBuzz();
        myFizzBuzz.setNumberProvider(new NumberProvider() {
            public Stream<Integer> getNumbers() {
                return IntStream.rangeClosed(1, 3).boxed();
            }
        });
        
        myFizzBuzz.setTextProvider(new TextProvider(){
            public String getText(int number) {
                return "xx" + String.valueOf(number);
            }
        });
        myFizzBuzz.setPrinter(printer);
        
        myFizzBuzz.startProcess();
       
        InOrder order = Mockito.inOrder(printer);
        order.verify(printer).print("xx1");
        order.verify(printer).print("xx2");
        order.verify(printer).print("xx3");
    }
    
}
