/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import Model.StudentBean;
import java.io.Serializable;
import javax.annotation.ManagedBean;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author IT353S843
 */
@ManagedBean
@SessionScoped 
public class UpdateController implements Serializable{

    // This corresponds to the response to be sent back to the client
//    private String name;
    private StudentBean studentBean;
    private String updateStatus;
    private boolean skip;

    public UpdateController() {
        studentBean = new StudentBean();
    }



    /**
     * @return the studentBean
     */
    public StudentBean getStudentBean() {
        return studentBean;
    }

    /**
     * @param studentBean the studentBean to set
     */
    public void setStudentBean(StudentBean studentBean) {
        this.studentBean = studentBean;
    }
    
    public String getUpdateStatus() {
        return updateStatus;
    }

    public void setUpdateStatus(String updateStatus) {
        this.updateStatus = updateStatus;
    }
    

    public String onFlowProcess(FlowEvent event)
    {
        if (isSkip())
        {
            setSkip(false);   //reset in case user goes back
            return "confirm";
        } else
        {
            return event.getNewStep();
        }
    }

    /**
     * @return the skip
     */
    public boolean isSkip() {
        return skip;
    }

    /**
     * @param skip the skip to set
     */
    public void setSkip(boolean skip) {
        this.skip = skip;
    }
    
}
