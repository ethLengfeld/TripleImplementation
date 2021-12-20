package utils;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InputValidationUtil {

    /**
     * @param solution
     * @return true - if the solution is a valid Hangman solution
     * i.e. no letters or symbols
     */
    public static final boolean validateHangmanSolution(String solution) {
        for (Character currChar : solution.toUpperCase().toCharArray()) {
            int charVal = currChar;
            // A - 65, Z - 90, Space - 32
            if ((charVal < 65 || charVal > 90) && charVal != 32) {
                return false;
            }
        }
        return true;
    }

    public static char validateHangmanGuess(String guess, List<Character> lettersGuessed) throws Exception {
        if (guess.length() > 1) {
            // TODO create custom exception
            throw new Exception("Guess was longer than one character.");
        }

        char guessedLetter = guess.charAt(0);
        int charVal = guessedLetter;
        if (charVal < 65 || charVal > 90) {
            // TODO create custom exception
            throw new Exception("Guess was not a valid character.");
        }

        if (!lettersGuessed.contains(Character.valueOf(guessedLetter))) {
            lettersGuessed.add(guessedLetter);
        } else {
            // TODO create custom exception
            throw new Exception("Letter was already guessed.");
        }

        return guessedLetter;
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
