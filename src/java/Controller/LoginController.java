package Controller;

import DAO.ProfileDAO;
import DAO.ProfileDAOImpl;
import javax.faces.bean.ManagedBean;
import Model.ProfileBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author IT353S843
 */
@ManagedBean
@SessionScoped
public class LoginController
{

    private ProfileBean theModel;
    private String loginStatus;
    private int loginAttempt = 0;

    /**
     * Creates a new instance of LoginController
     */
    public LoginController()
    {
        theModel = new ProfileBean();
    }

    public ProfileBean getTheModel()
    {
        return theModel;
    }

    public void setTheModel(ProfileBean theModel)
    {
        this.theModel = theModel;
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
    public String loginAuthentication()
    {
        if (loginAttempt < 3)
        {
            ProfileDAO aProfileDAO = new ProfileDAOImpl();    // Creating a new object each time.
            int status = aProfileDAO.checkCredentials(theModel); // Doing anything with the object after this?
            if (status == 1)
            {
                return "LoginGood.xhtml";
            } else
            {
                loginAttempt += 1;
                setLoginStatus("Invalid Credentials");
                return "";
            }
        } else
        {
            setLoginStatus("Exceed max number of trials! Try after some time");
            return "";
        }
    }
}
