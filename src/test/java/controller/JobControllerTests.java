package controller;

import model.job.DeliveryJob;
import model.job.JobEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static java.util.Arrays.asList;

/**
 * Created by superttmm on 03/07/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(ControllerTestApplication.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class JobControllerTests {
    @Autowired
    JobController jobController;

    @Test
    public void setJobReadyTest() throws InterruptedException {
        JobEntity jobEntity = new JobEntity();
        jobEntity.setJobType("DeliveryJob");
        DeliveryJob job = new DeliveryJob();
        job.jobType = "DeliveryJob";
        job.positions = asList("a", "b");
        jobEntity.setSpecificJob(job);
        jobEntity = jobController.createJob(jobEntity);
        jobController.startJob(jobEntity.getId());
        Thread.sleep(1000);
        jobController.setJobReady(jobEntity.getSubJobs().get(1).getId());
    }
}
