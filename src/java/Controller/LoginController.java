package Controller;
import Model.UserBean;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author IT353S843
 */
@ManagedBean
@SessionScoped
public class LoginController
{
    private UserBean userModel;
    private String loginStatus;
    private int loginAttempt;
    private RecruiterController recruiterController; 
    private StudentController studentController;
    private UserController userController; 

    /**
     * Creates a new instance of LoginController
     */
    public LoginController()
    {
       recruiterController = new RecruiterController();
       studentController = new StudentController();
       userController = new UserController();
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

    /*method for login authentication*/
//    public String loginAuthentication()
//    {
//        if (loginAttempt < 3)
//        {
//            ProfileDAO aProfileDAO = new ProfileDAOImpl();    // Creating a new object each time.
//            int status = aProfileDAO.checkCredentials(theModel); // Doing anything with the object after this?
//            if (status == 1)
//            {
//                return "LoginGood.xhtml";
//            } else
//            {
//                loginAttempt += 1;
//                setLoginStatus("Invalid Credentials");
//                return "";
//            }
//        } else
//        {
//            setLoginStatus("Exceed max number of trials! Try after some time");
//            return "";
//        }
//    }

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
}
