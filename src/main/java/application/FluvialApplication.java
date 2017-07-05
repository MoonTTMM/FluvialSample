package application;

import fluvial.FluvialConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by superttmm on 02/06/2017.
 */
@SpringBootApplication
@Import(FluvialConfig.class)
@ComponentScan(basePackages = {"controller"})
@EnableJpaRepositories("model.dal")
@EntityScan("model")
public class FluvialApplication {
    public static void main(String[] args){
        SpringApplication.run(FluvialApplication.class,args);
    }
}
