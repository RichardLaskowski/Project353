package Model;

/**
 *
 * @author Ricky
 */
public class UserBean
{
    // These correspond to the form elements
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String securityQuestion;
    private String securityAnswer;
    private String userType;
    private StudentBean targetStudent;
    private RecruiterBean targetRecruiter;

    public UserBean()
    {
        
    }
 
    public UserBean(String username, String password, String firstName, String lastName, String email, String secQuestion, String secAnswer, String userType)
    {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.securityQuestion = secQuestion;
        this.securityAnswer = secAnswer;
        this.userType = userType;
    }
    
    public UserBean(String username, String password, String firstName, String lastName, String email, String secQuestion, String secAnswer)
    {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.securityQuestion = secQuestion;
        this.securityAnswer = secAnswer;
    }

    /**
     * @return the username
     */
    public String getUsername()
    {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username)
    {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password)
    {
        this.password = password;
    }

    /**
     * @return the firstName
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * @return the email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    /**
     * @return the securityQuestion
     */
    public String getSecurityQuestion()
    {
        return securityQuestion;
    }

    /**
     * @param securityQuestion the securityQuestion to set
     */
    public void setSecurityQuestion(String securityQuestion)
    {
        this.securityQuestion = securityQuestion;
    }

    /**
     * @return the securityAnswer
     */
    public String getSecurityAnswer()
    {
        return securityAnswer;
    }

    /**
     * @param securityAnswer the securityAnswer to set
     */
    public void setSecurityAnswer(String securityAnswer)
    {
        this.securityAnswer = securityAnswer;
    }

    /**
     * @return the userType
     */
    public String getUserType()
    {
        return userType;
    }

    /**
     * @param userType the userType to set
     */
    public void setUserType(String userType)
    {
        this.userType = userType;
    }
    
    /**
     * @return the targetStudent
     */
    public StudentBean getTargetStudent()
    {
        return targetStudent;
    }

    /**
     * @param targetStudent the targetStudent to set
     */
    public void setTargetStudent(StudentBean targetStudent)
    {
        this.targetStudent = targetStudent;
    }

    /**
     * @return the targetRecruiter
     */
    public RecruiterBean getTargetRecruiter()
    {
        return targetRecruiter;
    }

    /**
     * @param targetRecruiter the targetRecruiter to set
     */
    public void setTargetRecruiter(RecruiterBean targetRecruiter)
    {
        this.targetRecruiter = targetRecruiter;
    }

    @Override
    public String toString() {
        return "UserBean{" + "username=" + username + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", userType=" + userType + '}';
    }
    
    
 
}