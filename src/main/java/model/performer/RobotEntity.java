package model.performer;

import fluvial.model.performer.PerformerStorage;

import javax.persistence.Entity;

/**
 * Created by superttmm on 27/06/2017.
 */
@Entity
public class RobotEntity extends PerformerStorage {
    private String position;

    public String getPosition() {return position;}
    public void setPosition(String position) {this.position = position;}
}
