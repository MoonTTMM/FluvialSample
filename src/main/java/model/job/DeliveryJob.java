package model.job;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import fluvial.model.job.Job;
import fluvial.model.job.JobStorage;
import fluvial.model.job.RootJob;

import java.util.List;

/**
 * Created by superttmm on 03/06/2017.
 */
@JsonDeserialize(as = DeliveryJob.class)
public class DeliveryJob extends RootJob {
    public List<String> positions;

    @Override
    public List<JobStorage> init(String jobType){
        List<JobStorage> jobs = super.init(jobType);
        Job subJob = jobFactory.createSpecificJob(jobType);
        if(jobType.equals("MoveToTargetJob")){
            ((MoveToTargetJob)subJob).targetPosition = positions.get(0);
        }else if(jobType.equals("AuthoriseJob")){
            ((AuthoriseJob)subJob).position = positions.get(1);
        }
        JobEntity jobEntity = new JobEntity(jobStorage, subJob);
        jobs.add(jobEntity);
        return jobs;
    }
}
