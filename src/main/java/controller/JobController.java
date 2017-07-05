package controller;

import fluvial.model.job.JobFactory;
import fluvial.model.job.JobMetadata;
import fluvial.model.job.JobScheduler;
import fluvial.model.job.JobStorage;
import model.dal.JobRepository;
import model.job.JobEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by superttmm on 02/06/2017.
 */
@RestController
@RequestMapping("rest/jobs")
public class JobController {
    @Autowired
    @Qualifier("jobFactory")
    JobFactory jobFactory;

    @Autowired
    JobScheduler jobScheduler;

    @Autowired
    JobRepository jobRepository;

    @RequestMapping(value="/check")
    public String checkJobFactory(){
        int mapSize = jobFactory.jobMetadataMap.size();
        return String.valueOf(mapSize);
    }

    @RequestMapping(value="/metadata")
    public Map<String, JobMetadata> getJobMetadata(){
        return jobFactory.jobMetadataMap;
    }

    @RequestMapping(value="/create", method = RequestMethod.POST)
    public JobEntity createJob(@RequestBody JobEntity jobEntity){
        return (JobEntity) jobFactory.setupJob(jobEntity);
    }

    @RequestMapping(value = "/start/{id}")
    public JobEntity startJob(@PathVariable Long id){
        JobStorage jobStorage = jobRepository.findOne(id);
        return (JobEntity) jobScheduler.scheduleCurrentJob(jobStorage);
    }

    @RequestMapping(value = "/ready/{id}")
    public JobEntity setJobReady(@PathVariable Long id){
        JobStorage jobStorage = jobRepository.findOne(id);
        jobStorage.getSpecificJob().setReady();
        return (JobEntity) jobStorage;
    }
}
