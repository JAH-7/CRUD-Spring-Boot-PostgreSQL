package pe.creativity.Restfull.configuration;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import pe.creativity.Restfull.controller.HomeController;
import pe.creativity.Restfull.controller.WelcomeRestController;

//Comentar component o configuration es caso de NO usar jersey
//@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig(){
        register(WelcomeRestController.class);
    }

}
