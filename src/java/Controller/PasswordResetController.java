/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.UserBean;
import javax.inject.Named;
import java.io.Serializable;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Richa
 */
@Named(value = "passwordResetController")
@SessionScoped
public class PasswordResetController implements Serializable
{
    private UserController userController;
    private UserBean userModel;
    private UserBean targetUser;
    
    
    public PasswordResetController()
    {
        userController = new UserController();
        targetUser = new UserBean();
        userModel = new UserBean();
    }
    
    //Returns a UserBean. Saves into targetUser
    public String selectUserByUsername()
    {
        String returnString = "";
       userController.setUserModel(userModel);
       targetUser = userController.selectUserByUsername();
       
       if(targetUser.getUsername().equalsIgnoreCase(userModel.getUsername()))
       {
           //Send Email Here
           returnString = "linkEmailed.xhtml";
       }
       else
       {
           //User not found logic.
           //Give user feedback that username is not registered.
           //After so many attempts to recover password, maybe give user option of signup. 
       }
       
       return returnString;
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
     * @return the targetUser
     */
    public UserBean getTargetUser()
    {
        return targetUser;
    }

    /**
     * @param targetUser the targetUser to set
     */
    public void setTargetUser(UserBean targetUser)
    {
        this.targetUser = targetUser;
    }
    
   
    
}
