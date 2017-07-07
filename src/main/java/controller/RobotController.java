package controller;

import fluvial.model.performer.PerformerFactory;
import model.dal.RobotRepository;
import model.performer.RobotEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by superttmm on 29/06/2017.
 */
@RestController
@RequestMapping("rest/robots")
public class RobotController {

    @Autowired
    RobotRepository robotRepository;

    @Autowired
    PerformerFactory performerFactory;

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public RobotEntity create(@RequestBody RobotEntity robotEntity){
        System.out.println(robotEntity.getName());
        return (RobotEntity) performerFactory.setup(robotEntity);
    }
}
