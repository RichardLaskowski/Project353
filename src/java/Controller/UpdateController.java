/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Model.StudentBean;
import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FlowEvent;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
/**
 *
 * @author IT353S843
 */
@Named(value = "updateController")
@SessionScoped
public class UpdateController implements Serializable
{
    private LoginController loginSession;
    private StudentBean studentBean;
    private String updateStatus;
    private boolean skip;

    public UpdateController()
    {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        loginSession = (LoginController)session.getAttribute("loginController");
        studentBean = loginSession.getTargetUser().getTargetStudent();
        System.out.println(studentBean.getUsername());
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

    public String getUpdateStatus()
    {
        return updateStatus;
    }

    public void setUpdateStatus(String updateStatus)
    {
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
    public boolean isSkip()
    {
        return skip;
    }

    /**
     * @param skip the skip to set
     */
    public void setSkip(boolean skip)
    {
        this.skip = skip;
    }

}
