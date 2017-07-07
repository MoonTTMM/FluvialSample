package model.performer;

import fluvial.model.performer.Performer;

/**
 * Created by superttmm on 06/07/2017.
 */
public class AGV extends Performer {
    @Override
    public void moveTo(String args){
        System.out.println("Will move to " + args);
    }

    public void speak(String content) { System.out.println("Hello " + content);}
}
