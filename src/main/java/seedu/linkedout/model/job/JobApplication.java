package seedu.linkedout.model.job;

/**
 * Represents a Applicant's job application in LinkedOUT
 */
public class JobApplication {
    /** Represents the job in a job application **/
    public final Job job;
    /** Represents a stage in the job application process **/
    public final Stage stage;

    /**
     * Constructs a JobApplication {@code jobApplication}
     * @param job A valid job.
     * @param stage A valid stage.
     */
    public JobApplication(Job job, Stage stage) {
        this.job = job;
        this.stage = stage;
    }

    /**
     * Views the job.
     *
     */
    public String viewJob() {
        return this.job.value;
    }

    /**
     * Views the stage.
     *
     */
    public String viewStage() {
        return this.stage.value;
    }

    /**
     * Clones the current object but edits the stage.
     *
     * @param stage The edited stage.
     * @return A cloned object with an edited stage.
     */
    public JobApplication changeStage(String stage) {
        return new JobApplication(this.job, this.stage.changeStage(stage));
    }
}
