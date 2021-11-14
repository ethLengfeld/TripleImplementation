package utils;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InputValidationUtil {

    /**
     *
     * @param solution
     * @return true - if the solution is a valid Hangman solution
     *                i.e. no letters or symbols
     */
    public static final boolean validateHangmanSolution(String solution) {
        for(Character currChar : solution.toUpperCase().toCharArray()) {
            int charVal = currChar;
            // A - 65, Z - 90, Space - 32
            if ((charVal < 65 || charVal > 90) && charVal != 32) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testValidateHangmanSolutionValid() {
        String solution = "AppleZebra";
        boolean isValid = InputValidationUtil.validateHangmanSolution(solution);
        assertTrue("Validate AppleZebra is valid", isValid);
    }

    @Test
    public void testValidateHangmanSolutionValidWithSpace() {
        String solution = "Apple Zebrazz";
        boolean isValid = InputValidationUtil.validateHangmanSolution(solution);
        assertTrue("Validate Apple Zebrazz is valid", isValid);
    }

    @Test
    public void testValidateHangmanSolutionInvalid() {
        String solution = "1234Apple Zebrazz";
        boolean isValid = InputValidationUtil.validateHangmanSolution(solution);
        assertFalse("1234Apple Zebrazz is invalid", isValid);
    }
}
