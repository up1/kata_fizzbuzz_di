package fizzbuzz.di;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class PrinterTest {
    
    @Test
    public void printMessageToConsole() {
        String message = "1";
        Printer printer = new Printer();
        ByteArrayOutputStream expectedOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(expectedOutput));
        
        printer.print(message);
        
        assertEquals(expectedOutput.toString().trim(), message);
        
    }

}
