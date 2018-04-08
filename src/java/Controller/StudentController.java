/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.StudentBean;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author IT353S843
 */
@ManagedBean
@RequestScoped
public class StudentController implements Serializable {

    
    private StudentBean studentBean;
    private boolean skip;
    
    /**
     * Creates a new instance of StudentController
     */
    public StudentController() {
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
    
    
    
    public void save() {        
        FacesMessage msg = new FacesMessage("Successful", "Welcome :");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public boolean isSkip() {
        return skip;
    }
 
    public void setSkip(boolean skip) {
        this.skip = skip;
    }
    
    public String onFlowProcess(FlowEvent event) {
        if(skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
    }
}
