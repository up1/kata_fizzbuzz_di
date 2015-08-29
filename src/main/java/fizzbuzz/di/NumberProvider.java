package fizzbuzz.di;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumberProvider {

    public Stream<Integer> getNumbers() {
        return IntStream.rangeClosed(1, 100).boxed();
    }

}
