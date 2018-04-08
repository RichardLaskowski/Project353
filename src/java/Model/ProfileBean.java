/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAO.ProfileDAOImpl;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class ProfileBean {
    
    // These correspond to the form elements
private String firstName;
private String lastName;
private String userId;
private String password;
private String email;
private String securityQuestion;
private String securityAnswer;
private String userName;
private String password1;
private String password2;
private String userType;

   public ProfileBean() {
    }
   
       public ProfileBean(String firstName, String lastName, String userName, String email, String securityQues, String securityAns) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.securityQuestion = securityQues;
        this.securityAnswer = securityAns;
    }


    
    
    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the securityQues
     */
    public String getSecurityQuestion() {
        return securityQuestion;
    }

    /**
     * @param securityQues the securityQues to set
     */
    public void setSecurityQuestion(String securityQues) {
        this.securityQuestion = securityQues;
    }

    /**
     * @return the securityAns
     */
    public String getSecurityAnswer() {
        return securityAnswer;
    }

    /**
     * @param securityAns the securityAns to set
     */
    public void setSecurityAnswer(String securityAns) {
        this.securityAnswer = securityAns;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
        
    }

    /**
     * @return the password1
     */
    public String getPassword1() {
        return password1;
    }

    /**
     * @param password1 the password1 to set
     */
    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    /**
     * @return the password2
     */
    public String getPassword2() {
        return password2;
    }

    /**
     * @param password2 the password2 to set
     */
    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    /**
     * @return the userType
     */
    public String getUserType() {
        return userType;
    }

    /**
     * @param userType the userType to set
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }
    
    
}
