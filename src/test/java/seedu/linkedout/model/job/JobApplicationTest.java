package seedu.linkedout.model.job;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class JobApplicationTest {

    private final Stage validStage = new Stage("stage");
    private final Stage validChangedStage = new Stage("stageNew");
    private final Job validJob = new Job("job");

    @Test
    public void viewJob_validJob_jobValue() {
        JobApplication jobApplication = new JobApplication(validJob, validStage);
        assertEquals("job", jobApplication.viewJob());
    }

    @Test
    public void viewStage_validJob_jobValue() {
        JobApplication jobApplication = new JobApplication(validJob, validStage);
        assertEquals("stage", jobApplication.viewStage());
    }

    @Test
    public void changeStage_validChangedStage_jobValueSameStageValueChanged() {
        JobApplication jobApplication = new JobApplication(validJob, validStage);
        jobApplication = jobApplication.changeStage("stageNew");
        assertEquals("stageNew", jobApplication.stage.value);
    }
}
