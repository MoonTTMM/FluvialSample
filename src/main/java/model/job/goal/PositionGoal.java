package model.job.goal;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import fluvial.model.job.goal.Goal;

/**
 * Created by superttmm on 03/07/2017.
 */
@JsonDeserialize(as = PositionGoal.class)
public class PositionGoal extends Goal {

    public PositionGoal(){
    }

    public PositionGoal(String position){
        this();
        if(position == null){
            x = null;
            y = null;
            angle = null;
        }else {
            String[] xy = position.split(",");
            if (xy.length == 3) {
                x = Double.parseDouble(xy[0]);
                y = Double.parseDouble(xy[1]);
                angle = Double.parseDouble(xy[2]);
            }
        }
    }

    public Double x;
    public Double y;
    public Double angle;


    @Override
    public boolean isReached(Object status){
        String currentPosition = (String) status;
        if(currentPosition == null){
            return false;
        }
        String[] xy = currentPosition.split(",");
        if (xy.length == 3) {
            double currentX = Double.parseDouble(xy[0]);
            double currentY = Double.parseDouble(xy[1]);
            double currentAngle = Double.parseDouble(xy[2]);

            boolean positionStatus = (Math.pow(x - currentX, 2) + Math.pow(y - currentY, 2)) == 0;
            boolean angleStatus = (angle == null || Math.abs(angle - currentAngle) == 0);
            return positionStatus && angleStatus;
        }
        return false;
    }
}
