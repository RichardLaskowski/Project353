package Controller;

import Model.RecruiterBean;
import Model.StudentBean;
import Model.UserBean;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class SignupController implements Serializable
{
    private UserController userController;
    private StudentController studentController;
    private RecruiterController recruiterController;
    private UserBean userModel;
    private StudentBean studentModel;
    private RecruiterBean recruiterModel;
    boolean userInserted = false;
    boolean studentInserted = false;
    boolean recruiterInserted = false;
    private String signupStatus = "";
    
    public String signUp()
    {   
        String returnString = "signUp.xhtml";
        
        switch(userModel.getUserType().toLowerCase())
        {
            case "student": 
                                studentModel.setUsername(userModel.getUsername());
                                studentInserted = studentController.createStudent(studentModel);
                                System.out.println("SINGUPCONTROLLER: " + studentInserted);
                                if(studentInserted)
                                {
                                    returnString = "logIn.xhtml";
                                }
                                break;
                 
            case "recruiter": 
                                recruiterModel.setUsername(userModel.getUsername());
                                recruiterInserted = recruiterController.createRecruiter(recruiterModel);
                                System.out.println("SINGUPCONTROLLER: " + recruiterInserted);
                                if(recruiterInserted)
                                {
                                    returnString = "logIn.xhtml";
                                }
                                break;                        
        }
        
        return returnString;
    }
    
    public String createUser()
    {
       String returnString = "";
       
       System.out.println("SIGNUPCONTROLLER: createUser()");
       System.out.println(userModel.getUsername());
       System.out.println(userModel.getPassword());
       System.out.println(userModel.getFirstName());
       System.out.println(userModel.getLastName());
       System.out.println(userModel.getEmail());
       System.out.println(userModel.getSecurityAnswer());
       System.out.println(userModel.getSecurityQuestion());
       System.out.println(userModel.getUserType());
       
       userInserted = userController.createUser(userModel);
     
       System.out.println("SIGNUPCONTROLLER: " + userInserted);
       
       switch(userModel.getUserType().toLowerCase())
       {       
           case "student":
                                if(userInserted)
                                {
                                   return "details.xhtml";                                   
                                }
                                else {
                                    signupStatus = "UserId already exist!";                               
                                }
                                break;
           case "recruiter":
                                if(userInserted)
                                {
                                    returnString = "recruiterDetails.xhtml";
                                }
                                else {
                                    signupStatus = "UserId already exist!";                               
                                }
                                break;
       }
       return returnString;
    }
    
    /**
     * Creates a new instance of SignupController
     */
    public SignupController()
    {
        userController = new UserController();
        studentController = new StudentController();
        recruiterController = new RecruiterController();
        userModel = new UserBean();
        studentModel = new StudentBean();
        recruiterModel = new RecruiterBean();
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
     * @return the signupStatus
     */
    public String getSignupStatus()
    {
        return signupStatus;
    }

    /**
     * @param signupStatus the signupStatus to set
     */
    public void setSignupStatus(String signupStatus)
    {
        this.signupStatus = signupStatus;
    }
}
