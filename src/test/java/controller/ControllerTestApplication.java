package controller;

import fluvial.FluvialConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by superttmm on 03/07/2017.
 */
@SpringBootApplication
@Import(FluvialConfig.class)
@ComponentScan(basePackages = {"controller"})
@EnableJpaRepositories("model.dal")
@EntityScan("model")
public class ControllerTestApplication {
    public static void main(String[] args){
        SpringApplication.run(ControllerTestApplication.class,args);
    }
}
