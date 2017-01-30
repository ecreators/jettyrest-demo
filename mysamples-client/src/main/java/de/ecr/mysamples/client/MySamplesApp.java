package de.ecr.mysamples.client;

import de.ecr.mysamples.service.model.Answer;
import de.ecr.mysamples.service.model.IClientRestService;
import de.mydata.rest.client.RestConnection;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Bjoern Frohberg, mydata GmbH
 */
public class MySamplesApp {
    
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/mysamples-client-context.xml");
        MySamplesApp                   app     = context.getBean(MySamplesApp.class);
        app.start(args);
    }
    
    private void start(String[] args) {
        RestConnection<IClientRestService> restServer = RestConnection.consume("http://localhost",
                                                                               8080,
                                                                               "/mysamples",
                                                                               IClientRestService.class,
                                                                               null);
        IClientRestService service = restServer.getService();
        Answer             answer  = service.getAnswer();
    }
}
