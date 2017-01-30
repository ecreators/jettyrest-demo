package de.ecr.mysamples.service.model;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.glassfish.jersey.client.JerseyClient;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.WebServletConfig;

import javax.jws.WebService;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.WebServiceClient;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Bjoern Frohberg, mydata GmbH
 */
public class RestConnector {
    
    private final String host;
    private final int    port;
    
    public RestConnector(String host, int port) {
        this.host = host;
        this.port = port;
    }
    
    private static String prepareRestUrl(String host, int port) {
        return host + ":" + port + "/";
    }
    
    public Object get(String pathRequest, MediaType type) {
        try {
            
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet           getRequest = new HttpGet(prepareRestUrl(host, port));
            getRequest.addHeader("accept", type.toString());
            
            HttpResponse response = httpClient.execute(getRequest);
            
            if(response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                                           + response.getStatusLine().getStatusCode());
            }
            
            BufferedReader br = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent())));
            
            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
            
            httpClient.getConnectionManager().shutdown();
            
        } catch (ClientProtocolException ignored) {
            
        } catch (IOException ignored) {
        }
        return null;
    }
}
