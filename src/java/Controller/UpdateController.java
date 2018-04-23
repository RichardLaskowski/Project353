/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

//import DAO.ProfileDAOImpl;
//import DAO.ProfileDAO;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import Model.StudentBean;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author IT353S843
 */
@ManagedBean
@SessionScoped 
public class UpdateController {

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

    
//    public String retrieveProfile(String userId) {
//        ProfileDAO aProfileDAO = new ProfileDAOImpl();    // Creating a new object each time.
//        StudentBean result = aProfileDAO.findByName(userId); // Doing anything with the object after this?
//        studentBean = result; // if multiple found, just pick the 1st one. If none?
//        if (studentBean != null) 
//            return "update.xhtml"; // navigate to "update.xhtml"
//        else
//            return "error.xhtml"; 
//    }
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
    
//    public String insertDetails(String UserId)
//    {
//            String signupStatus = "";
//        ProfileDAO aProfileDAO = new ProfileDAOImpl();    // Creating a new object each time.
//        int status = aProfileDAO.insertStudentDetails(UserId, studentBean); // Doing anything with the object after this?
//        if (status == 1)
//        {
//            return "logIn.xhtml"; // navigate to "logIn.xhtml"
//        } else
//        {
//            signupStatus = "Issue Encounter";
//            return "";
//        }
//
//    }
    
}
