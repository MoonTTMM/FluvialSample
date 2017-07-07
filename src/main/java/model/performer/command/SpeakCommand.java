package model.performer.command;

import fluvial.model.performer.command.Command;
import model.performer.AGV;

/**
 * Created by superttmm on 06/07/2017.
 */
public class SpeakCommand extends Command {
    private AGV agv;

    public SpeakCommand(AGV agv){
        this.agv = agv;
    }

    @Override
    public void execute(String... args){
        if(args.length > 0){
            agv.speak(args[0]);
        }
    }
}
