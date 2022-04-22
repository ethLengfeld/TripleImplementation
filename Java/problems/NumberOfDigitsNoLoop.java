package problems;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class NumberOfDigitsNoLoop {

    public static int numDigitsNoLoop(int num) {
        if(num < 10) {
            return 1;
        }
        return 1 + numDigitsNoLoop(num/10);
    }

    @Test
    public void numDigitsNoLoopTest() {
        int num = 11;
        int numDigits = NumberOfDigitsNoLoop.numDigitsNoLoop(num);
        assertEquals("two digits in 11", 2, numDigits);
    }

}
