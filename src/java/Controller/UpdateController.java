/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Model.StudentBean;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FlowEvent;
import javax.inject.Named;
import javax.servlet.http.HttpSession;


@Named(value = "updateController")
@SessionScoped
public class UpdateController implements Serializable
{
    private StudentController studentController;
    private StudentBean studentBean;
    private String updateStatus;
    private boolean skip;

    public UpdateController()
    {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        LoginController loginSession = (LoginController)session.getAttribute("loginController");
        studentBean = loginSession.getTargetUser().getTargetStudent();
        studentController = new StudentController();
        System.out.println(studentBean.getUsername());
    }
    
    public String updateStudent()
    {
        String resultString = "";
        if(studentController.updateStudent(studentBean))
        {
            resultString = "profile.xhtml";
        }       
        
        return resultString;
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
