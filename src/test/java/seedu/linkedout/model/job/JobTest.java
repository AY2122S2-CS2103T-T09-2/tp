package seedu.linkedout.model.job;

import static org.junit.jupiter.api.Assertions.*;
import static seedu.linkedout.model.job.Job.isValidJob;
import static seedu.linkedout.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class JobTest{

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Job(null));
    }

    @Test
    public void constructor_emptyJob_throwsIllegalArgumentException() {
        String emptyJob = "";
        assertThrows(IllegalArgumentException.class, () -> new Job(emptyJob));
    }

    @Test
    public void constructor_invalidJob_throwsIllegalArgumentException() {
        String invalidJob = "#";
        assertThrows(IllegalArgumentException.class, () -> new Job(invalidJob));
    }

    @Test
    public void constructor_invalidJobWhitespace_throwsIllegalArgumentException() {
        String invalidJob = " ";
        assertThrows(IllegalArgumentException.class, () -> new Job(invalidJob));
    }

    @Test
    public void constructor_validJob_valueEqualsParameter() {
        String validJob = "job1";
        Job job = new Job(validJob);
        assertEquals(job.value, "job1");
    }

    @Test
    public void isValidJob_whitespace_false() {
        String invalidJob = " ";
        assertFalse(isValidJob(invalidJob));
    }

    @Test
    public void isValidJob_nonAlphaNumeric_false() {
        final int ASCII_CHARACTER_EXCLAMATION_MARK = 33;
        final int ASCII_CHARACTER_BACKSLASH = 47;
        final int ASCII_CHARACTER_COLON = 58;
        final int ASCII_CHARACTER_AT = 64;
        final int ASCII_CHARACTER_SQUARE_BRACKET = 91;
        final int ASCII_CHARACTER_BACK_TICK = 96;
        final int ASCII_CHARACTER_LEFT_CURLY_BRACE = 123;
        final int ASCII_CHARACTER_DEL = 127;

        char character = ASCII_CHARACTER_EXCLAMATION_MARK;
        while (character <= ASCII_CHARACTER_BACKSLASH) {
            String jobValue = String.valueOf(character);
            assertFalse(isValidJob(jobValue));
            character++;
        }

        character = ASCII_CHARACTER_COLON;
        while(character <= ASCII_CHARACTER_AT) {
            String jobValue = String.valueOf(character);
            assertFalse(isValidJob(jobValue));
            character++;
        }

        character = ASCII_CHARACTER_SQUARE_BRACKET;
        while (character <= ASCII_CHARACTER_BACK_TICK) {
            String jobValue = String.valueOf(character);
            assertFalse(isValidJob(jobValue));
            character++;
        }

        character = ASCII_CHARACTER_LEFT_CURLY_BRACE;
        while (character <= ASCII_CHARACTER_DEL) {
            String jobValue = String.valueOf(character);
            assertFalse(isValidJob(jobValue));
            character++;
        }
    }

    @Test
    public void equals_thisJob_true() {
        Job job = new Job("job");
        assertTrue(job.equals(job));
    }

    @Test
    public void equals_otherType_false() {
        Job job = new Job("job");
        String string = "job";
        assertFalse(job.equals(string));
    }

    @Test
    public void equals_otherJobSameValue_true() {
        Job job = new Job("job");
        Job otherJob = new Job("otherJob");
        assertFalse(job.equals(otherJob));
    }

}
