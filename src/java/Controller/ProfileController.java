
package Controller;

import DAO.ProfileDAOImpl;
import DAO.ProfileDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import Model.ProfileBean;

@ManagedBean
@SessionScoped
public class ProfileController {

    // This corresponds to the response to be sent back to the client
    
    private ProfileBean theModel;
    private String resultStr = "";
    private String signupStatus;
    private String signupStatus1;

    /**
     * Creates a new instance of ProfileController
     */
    public ProfileController() {
        theModel = new ProfileBean();
    }

    public ProfileBean getTheModel() {
        return theModel;
    }

    public void setTheModel(ProfileBean theModel) {
        this.theModel = theModel;
    }


    public String createProfile() {
        ProfileDAO aProfileDAO = new ProfileDAOImpl();    // Creating a new object each time.
            int status = aProfileDAO.createProfile(theModel); // Doing anything with the object after this?
            if (status == 1 ){
                if(theModel.getUserType().equalsIgnoreCase("Student")) {
                return "details.xhtml"; // navigate to "details.xhtml"
                }
                else{
                    return "recruiterDetails.xhtml";
                }
            }
                else {
                signupStatus = "UserId already exist!";
                return "";
            }
    }

    /**
     * @return the signupStatus
     */
    public String getSignupStatus() {
        return signupStatus;
    }

    /**
     * @param signupStatus the signupStatus to set
     */
    public void setSignupStatus(String signupStatus) {
        this.signupStatus = signupStatus;
    }

    /**
     * @return the signupStatus1
     */
    public String getSignupStatus1() {
        return signupStatus1;
    }

    /**
     * @param signupStatus1 the signupStatus1 to set
     */
    public void setSignupStatus1(String signupStatus1) {
        this.signupStatus1 = signupStatus1;
    }
}
