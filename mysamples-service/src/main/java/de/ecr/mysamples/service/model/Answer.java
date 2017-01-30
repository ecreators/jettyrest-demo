package de.ecr.mysamples.service.model;

import java.io.Serializable;

/**
 * @author Bjoern Frohberg, mydata GmbH
 */
public class Answer implements Serializable {
    
    private boolean status;
    
    public boolean isStatus() {
        return status;
    }
    
    public void setStatus(boolean status) {
        this.status = status;
    }
}