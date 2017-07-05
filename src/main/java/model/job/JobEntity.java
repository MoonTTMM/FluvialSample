package model.job;

import fluvial.model.job.Job;
import fluvial.model.job.JobStorage;

import javax.persistence.Entity;

/**
 * Created by superttmm on 03/06/2017.
 */
@Entity
public class JobEntity extends JobStorage {

    public JobEntity(){}

    public JobEntity(JobStorage jobEntity, Job job){
        this.setPerformer(jobEntity.getPerformer());
        this.setSpecificJob(job);
    }
}
