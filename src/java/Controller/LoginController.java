package Controller;
import Model.RecruiterBean;
import Model.StudentBean;
import Model.UserBean;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class LoginController
{
    private RecruiterBean recruiterModel;
    private StudentBean studentModel;
    private UserBean userModel;
    private UserBean targetUser;
    private RecruiterController recruiterController; 
    private StudentController studentController;
    private UserController userController; 
    
    private String loginStatus;
    private int loginAttempt;
    
    /*method for login authentication*/
    public String loginAuthentication()
    {
        String returnString = "";
        if (loginAttempt < 3)
        {
            userController.setUserModel(userModel);
            targetUser = userController.selectUserByUsername(); 
            if(userModel.getPassword().equals(targetUser.getPassword()))
            {
                returnString = "profile.xhtml";
            }
            else
            {
                setLoginStatus("Invalid Credentials");
                returnString = "logIn.xhtml";
            }
        } 
        else
        {
            setLoginStatus("Exceed max number of trials! Try after some time");
            
        }
        
        return returnString;
    }

    /**
     * Creates a new instance of LoginController
     */
    public LoginController()
    {
       recruiterController = new RecruiterController();
       studentController = new StudentController();
       userController = new UserController();
       userModel = new UserBean();
       targetUser = null;
       loginAttempt = 0;
    }

    /**
     * @return the loginStatus
     */
    public String getLoginStatus()
    {
        return loginStatus;
    }

    /**
     * @param loginStatus the loginStatus to set
     */
    public void setLoginStatus(String loginStatus)
    {
        this.loginStatus = loginStatus;
    }


    /**
     * @return the loginAttempt
     */
    public int getLoginAttempt()
    {
        return loginAttempt;
    }

    /**
     * @param loginAttempt the loginAttempt to set
     */
    public void setLoginAttempt(int loginAttempt)
    {
        this.loginAttempt = loginAttempt;
    }

    /**
     * @return the recruiterController
     */
    public RecruiterController getRecruiterController()
    {
        return recruiterController;
    }

    /**
     * @param recruiterController the recruiterController to set
     */
    public void setRecruiterController(RecruiterController recruiterController)
    {
        this.recruiterController = recruiterController;
    }

    /**
     * @return the studentController
     */
    public StudentController getStudentController()
    {
        return studentController;
    }

    /**
     * @param studentController the studentController to set
     */
    public void setStudentController(StudentController studentController)
    {
        this.studentController = studentController;
    }

    /**
     * @return the userController
     */
    public UserController getUserController()
    {
        return userController;
    }

    /**
     * @param userController the userController to set
     */
    public void setUserController(UserController userController)
    {
        this.userController = userController;
    }

    /**
     * @return the userModel
     */
    public UserBean getUserModel()
    {
        return userModel;
    }

    /**
     * @param userModel the userModel to set
     */
    public void setUserModel(UserBean userModel)
    {
        this.userModel = userModel;
    }

    /**
     * @return the recruiterModel
     */
    public RecruiterBean getRecruiterModel()
    {
        return recruiterModel;
    }

    /**
     * @param recruiterModel the recruiterModel to set
     */
    public void setRecruiterModel(RecruiterBean recruiterModel)
    {
        this.recruiterModel = recruiterModel;
    }

    /**
     * @return the studentModel
     */
    public StudentBean getStudentModel()
    {
        return studentModel;
    }

    /**
     * @param studentModel the studentModel to set
     */
    public void setStudentModel(StudentBean studentModel)
    {
        this.studentModel = studentModel;
    }
}
