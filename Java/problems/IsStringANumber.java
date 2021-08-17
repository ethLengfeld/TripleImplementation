package problems;

import org.junit.Test;

import static org.junit.Assert.*;

/*Given a string, return whether it represents a number. Here are the different kinds of numbers:

"10", a positive integer
"-10", a negative integer
"10.1", a positive real number
"-10.1", a negative real number
"1e5", a number in scientific notation

NOT
"a"
"x 1"
"a -2"
"-"
 */
public class IsStringANumber {

    public static boolean isNumber(String possNum) {
        boolean hasNumber = false;
        boolean sci = false;
        boolean minus = false;
        boolean plus = false;
        boolean period = false;

        for (int i = 0; i < possNum.length(); i++) {
            char currChar = possNum.charAt(i);
            if (currChar < 48 || currChar > 57) {
                if ((currChar == 'e' || currChar == 'E')) {
                    if (!sci) {
                        sci = true;
                    } else {
                        return false;
                    }
                } else if ((currChar == '-')) {
                    if (!minus) {
                        minus = true;
                    } else {
                        return false;
                    }
                } else if ((currChar == '+')) {
                    if (!plus) {
                        plus = true;
                    } else {
                        return false;
                    }
                } else if ((currChar == '.')) {
                    if (!period) {
                        period = true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                hasNumber = true;
            }
        }

        return hasNumber;
    }

    @Test
    public void testIsNumber_10() {
        String possNumber = "10";
        boolean isNumber = IsStringANumber.isNumber(possNumber);
        assertTrue(isNumber);
    }

    @Test
    public void testIsNumber_Minus10() {
        String possNumber = "-10";
        boolean isNumber = IsStringANumber.isNumber(possNumber);
        assertTrue(isNumber);
    }

    @Test
    public void testIsNumber_10_1() {
        String possNumber = "10.1";
        boolean isNumber = IsStringANumber.isNumber(possNumber);
        assertTrue(isNumber);
    }

    @Test
    public void testIsNumber_Minus10_1() {
        String possNumber = "-10.1";
        boolean isNumber = IsStringANumber.isNumber(possNumber);
        assertTrue(isNumber);
    }

    @Test
    public void testIsNumber_1e5() {
        String possNumber = "1e5";
        boolean isNumber = IsStringANumber.isNumber(possNumber);
        assertTrue(isNumber);
    }

    @Test
    public void testIsNumber_a() {
        String possNumber = "a";
        boolean isNotNumber = IsStringANumber.isNumber(possNumber);
        assertFalse(isNotNumber);
    }

    @Test
    public void testIsNumber_xspace1() {
        String possNumber = "x 1";
        boolean isNotNumber = IsStringANumber.isNumber(possNumber);
        assertFalse(isNotNumber);
    }

    @Test
    public void testIsNumber_aspaceMinus2() {
        String possNumber = "a -2";
        boolean isNotNumber = IsStringANumber.isNumber(possNumber);
        assertFalse(isNotNumber);
    }

    @Test
    public void testIsNumber_minus() {
        String possNumber = "-";
        boolean isNotNumber = IsStringANumber.isNumber(possNumber);
        assertFalse(isNotNumber);
    }
}
