package seedu.linkedout.model.job;

import static java.util.Objects.requireNonNull;
import static seedu.linkedout.commons.util.AppUtil.checkArgument;

/**
 * Represents a Applicant's stage in a job application
 * Guarantees: immutable; is valid as declared in {@link #isValidStage(String)}
 */
public class Stage {

    public static final String MESSAGE_CONSTRAINTS =
            "Stages should only contain alphanumeric characters and spaces, and it should not be blank";

    /**
     * The first character of stage must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";

    public final String value;

    /**
     * Constructs a {@code stage}.
     *
     * @param stage A valid stage.
     */
    public Stage(String stage) {
        requireNonNull(stage);
        checkArgument(isValidStage(stage), MESSAGE_CONSTRAINTS);
        value = stage;
    }

    /**
     * Returns true if a given string is a valid email.
     */
    public static boolean isValidStage(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    /**
     * Clones the current object but edits the value.
     *
     * @param stage The edited stage.
     * @return A cloned stage with an edited value.
     */
    public Stage changeStage(String stage) {
        return new Stage(stage);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Stage) // instanceof handles nulls
                && value.equals(((Stage) other).value); // state check
    }
}
