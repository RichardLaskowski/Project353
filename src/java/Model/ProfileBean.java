<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.File;

/**
 *
 * @author ericz
 */
public class ProfileBean
{

    private PostBean[] posts;
    private File profilePic;
    private File[] pictures;
    private File[] videos;

    ProfileBean()
    {

    }

    public PostBean[] getPosts()
    {
        return posts;
    }

    public void setPosts(PostBean[] posts)
    {
        this.posts = posts;

    }

    public File getProfilePic()
    {
        return profilePic;
    }

    public void setProfilePic(File profilePic)
    {
        this.profilePic = profilePic;
    }

    public File[] getPictures()
    {
        return pictures;
    }

    public void setPictures(File[] pictures)
    {
        this.pictures = pictures;
    }

    public File[] getVideos()
    {
        return videos;
    }

    public void setVideos(File[] videos)
    {
        this.videos = videos;
    }

    public void addPicture(File pic)
    {
        int i = this.pictures.length;
        this.pictures[i] = pic;
    }

    public void addVideo(File vid)
    {
        int i = this.videos.length;
        this.videos[i] = vid;
    }

    public File getPic(int i)
    {
        return this.pictures[i];
    }

    public File getVid(int i)
    {
        return this.videos[i];
    }

}
=======
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
private String userType;

   public ProfileBean() {
    }
   
       public ProfileBean(String firstName, String lastName, String userId, String email, String securityQues, String securityAns) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userId = userId;
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
>>>>>>> origin
