package seedu.linkedout.model.job;

import static java.util.Objects.requireNonNull;
import static seedu.linkedout.commons.util.AppUtil.checkArgument;

/**
 * Represents a Applicant's applied job in LinkedOUT
 * Guarantees: immutable; is valid as declared in {@link #isValidJob(String)}
 */
public class Job {

    public static final String MESSAGE_CONSTRAINTS =
            "Jobs should only contain alphanumeric characters and spaces, and it should not be blank";

    /**
     * The first character of Job must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";

    public final String value;

    /**
     * Constructs a {@code Job}
     *
     * @param job A valid job.
     */
    public Job(String job) {
        requireNonNull(job);
        checkArgument(isValidJob(job), MESSAGE_CONSTRAINTS);
        value = job;
    }

    /**
     * Returns true if a given string is a valid email.
     */
    public static boolean isValidJob(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Job) // instanceof handles nulls
                && value.equals(((Job) other).value); // state check
    }
}
