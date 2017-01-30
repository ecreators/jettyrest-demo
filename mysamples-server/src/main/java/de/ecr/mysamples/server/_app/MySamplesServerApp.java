package de.ecr.mysamples.server._app;

import com.sun.xml.internal.ws.api.WSBinding;
import com.sun.xml.internal.ws.binding.BindingImpl;
import de.mydata.rest.server.IEmbeddedRestServer;
import de.mydata.rest.server.JettyRestServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.core.env.StandardEnvironment;

/**
 * @author Bjoern Frohberg, mydata GmbH
 */
public class MySamplesServerApp {
    
    private final IEmbeddedRestServer restServer;
    
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/server-application-context.xml");
        MySamplesServerApp             app     = context.getBean(MySamplesServerApp.class);
        app.start(args);
    }
    
    @Autowired
    public MySamplesServerApp(IEmbeddedRestServer restServer) throws Exception {
        this.restServer = restServer;
    }
    
    private void start(String[] args) throws Exception {
        this.restServer.execute();
    }
}