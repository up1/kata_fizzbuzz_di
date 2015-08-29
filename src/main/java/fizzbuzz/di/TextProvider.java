package fizzbuzz.di;

public class TextProvider {

    public String getText(int number) {
        if(dividable(number, 15)) {
            return "FizzBuzz";
        }
        if(dividable(number, 3)) {
            return "Fizz";
        }
        if(dividable(number, 5)) {
            return "Buzz";
        }
        return String.valueOf(number);
    }
    
    private boolean dividable(int number, int divider) {
        return number % divider == 0;
    }

}
