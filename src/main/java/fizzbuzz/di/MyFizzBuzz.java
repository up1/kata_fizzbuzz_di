package fizzbuzz.di;

public class MyFizzBuzz {

    private NumberProvider numberProvider;
    private TextProvider textProvider;
    private Printer printer;

    public void setNumberProvider(NumberProvider numberProvider) {
       this.numberProvider = numberProvider;
    }
    
    public void setTextProvider(TextProvider textProvider) {
        this.textProvider = textProvider; 
     }

    public void startProcess() {
        this.numberProvider.getNumbers().forEach( number-> {
            String message = this.textProvider.getText(number);
            this.printer.print(message);
        });
    }

    public void setPrinter(Printer printer) {
       this.printer = printer; 
    }

}
