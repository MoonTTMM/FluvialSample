package model.job;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import fluvial.model.job.Job;
import fluvial.model.job.JobStorage;
import fluvial.model.job.goal.FlagGoal;
import fluvial.model.job.goal.Goal;
import fluvial.model.storage.StoreSetter;
import model.performer.AGV;
import model.performer.command.SpeakCommand;

/**
 * Created by superttmm on 03/06/2017.
 */
@JsonDeserialize(as = AuthoriseJob.class)
public class AuthoriseJob extends Job {
    public String position;
    public boolean readyToGo;

    private StoreSetter<JobStorage> setReadyToGo = jobEntity -> {
        AuthoriseJob job = (AuthoriseJob)jobEntity.getSpecificJob();
        job.readyToGo = this.readyToGo;
        return jobEntity;
    };

    @Override
    public void execute(){
        SpeakCommand speakCommand = new SpeakCommand((AGV)getPerformer().getPerformer());
        speakCommand.execute("请认证身份！");
    }

    @Override
    public void createGoals(){
        goals.add(new FlagGoal());
    }

    @Override
    public boolean checkGoal(Goal goal){
        return goal.isReached(readyToGo);
    }

    @Override
    public void setReady(){
        this.readyToGo = true;
        jobStorage = updateJob(setReadyToGo);
    }
}
