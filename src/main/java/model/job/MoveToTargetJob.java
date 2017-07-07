package model.job;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import fluvial.model.job.Job;
import fluvial.model.job.goal.Goal;
import fluvial.model.performer.command.MoveCommand;
import model.job.goal.PositionGoal;
import model.performer.RobotEntity;

/**
 * Created by superttmm on 03/06/2017.
 */
@JsonDeserialize(as = MoveToTargetJob.class)
public class MoveToTargetJob extends Job {

    public String targetPosition;

    @Override
    public void execute(){
        MoveCommand moveCommand = new MoveCommand(getPerformer().getPerformer());
        moveCommand.execute(targetPosition);
    }

    @Override
    public void createGoals(){
        goals.add(new PositionGoal(targetPosition));
    }

    @Override
    public boolean checkGoal(Goal goal){
        return goal.isReached(((RobotEntity)getPerformer()).getPosition());
    }
}
