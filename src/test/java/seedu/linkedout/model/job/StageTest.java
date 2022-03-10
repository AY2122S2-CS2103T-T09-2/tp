package seedu.linkedout.model.job;

import static org.junit.jupiter.api.Assertions.*;
import static seedu.linkedout.model.job.Stage.isValidStage;
import static seedu.linkedout.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class StageTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Stage(null));
    }

    @Test
    public void constructor_emptyStage_throwsIllegalArgumentException() {
        String emptyStage = "";
        assertThrows(IllegalArgumentException.class, () -> new Stage(emptyStage));
    }

    @Test
    public void constructor_invalidStage_throwsIllegalArgumentException() {
        String invalidStage = "#";
        assertThrows(IllegalArgumentException.class, () -> new Stage(invalidStage));
    }

    @Test
    public void constructor_invalidStageWhitespace_throwsIllegalArgumentException() {
        String invalidStage = " ";
        assertThrows(IllegalArgumentException.class, () -> new Stage(invalidStage));
    }

    @Test
    public void constructor_validStage_valueEqualsParameter() {
        String validStage = "stage1";
        Stage stage = new Stage(validStage);
        assertEquals(stage.value, "stage1");
    }

    @Test
    public void isValidStage_whitespace_false() {
        String invalidStage = " ";
        assertFalse(isValidStage(invalidStage));
    }

    @Test
    public void isValidStage_nonAlphaNumeric_false() {
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
            String stageValue = String.valueOf(character);
            assertFalse(isValidStage(stageValue));
            character++;
        }

        character = ASCII_CHARACTER_COLON;
        while (character <= ASCII_CHARACTER_AT) {
            String stageValue = String.valueOf(character);
            assertFalse(isValidStage(stageValue));
            character++;
        }

        character = ASCII_CHARACTER_SQUARE_BRACKET;
        while (character < ASCII_CHARACTER_BACK_TICK) {
            String stageValue = String.valueOf(character);
            assertFalse(isValidStage(stageValue));
            character++;
        }

        character = ASCII_CHARACTER_LEFT_CURLY_BRACE;
        while (character < ASCII_CHARACTER_DEL) {
            String stageValue = String.valueOf(character);
            assertFalse(isValidStage(stageValue));
            character++;
        }
    }

    @Test
    public void equals_thisObject_true() {
        Stage stage = new Stage("stage");
        assertTrue(stage.equals(stage));
    }

    @Test
    public void equals_otherType_false() {
        Stage stage = new Stage("stage");
        String string = "stage";
        assertFalse(stage.equals(string));
    }

    @Test
    public void equals_otherStageSameValue_true() {
        Stage stage = new Stage("stage");
        Stage otherStage = new Stage("otherStage");
        assertFalse(stage.equals(otherStage));
    }
}