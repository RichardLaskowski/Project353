/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ProfileDAO;
import DAO.ProfileDAOImpl;
import Model.StudentBean;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.FlowEvent;


/**
 *
 * @author IT353S843
 */
@ManagedBean
@SessionScoped
public class StudentController implements Serializable
{

    private StudentBean studentBean;
    private boolean skip;

    /**
     * Creates a new instance of StudentController
     */
    public StudentController()
    {
        studentBean = new StudentBean();
    }

    /**
     * @return the studentBean
     */
    public StudentBean getStudentBean()
    {
        return studentBean;
    }

    /**
     * @param studentBean the studentBean to set
     */
    public void setStudentBean(StudentBean studentBean)
    {
        this.studentBean = studentBean;
    }

    public String insertDetails(String UserId)
    {
            String signupStatus = "";
        ProfileDAO aProfileDAO = new ProfileDAOImpl();    // Creating a new object each time.
        int status = aProfileDAO.insertStudentDetails(UserId, studentBean); // Doing anything with the object after this?
        if (status == 1)
        {
            return "logIn.xhtml"; // navigate to "LoginGood.xhtml"
        } else
        {
            signupStatus = "Issue Encounter";
            return "";
        }

    }

    public boolean isSkip()
    {
        return skip;
    }

    public void setSkip(boolean skip)
    {
        this.skip = skip;
    }

    public String onFlowProcess(FlowEvent event)
    {
        if (skip)
        {
            skip = false;   //reset in case user goes back
            return "confirm";
        } else
        {
            return event.getNewStep();
        }
    }
}
