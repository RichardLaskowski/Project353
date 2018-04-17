/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.UserDAO;
import DAO.UserDAOImpl;
import Model.UserBean;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Richa
 */
@Named(value = "userController")
@SessionScoped
public class UserController implements Serializable
{
    private final String USER_TYPE_STUDENT = "student";
    private final String USER_TYPE_RECRUITER = "recruiter";
    private final String USER_TYPE_UNIVERSITY = "university";
    private final String USER_TYPE_ADMIN = "admin";
    
    //Represents the View
    private UserBean userModel;
    //Represents query result
    private UserBean targetUser;
    
    private ArrayList resultList;
          
    public UserController()
    {
        userModel = new UserBean();
    }
    
    public String createUser()      
    {
        UserDAO userDAO = new UserDAOImpl();
        int rowCount = userDAO.createUser(getUserModel());
        String returnString = "";
        if(rowCount == 1)
        {
            returnString += "LoginGood.xhtml";
        }
        
        return returnString;
    }
    
    public UserBean selectUserByUsername()
    {
        UserDAO userDAO = new UserDAOImpl();
        resultList = userDAO.selectUserByUsername(userModel.getUsername());
        if(resultList.size() == 1)
        {
            targetUser = (UserBean)resultList.get(0);
            System.out.println("SELECT BY USERNAME SUCCESSFULL");
            System.out.println("TARGET: " + targetUser.getUsername());
        }
        
       
        if(resultList.size() == 1)
        {
            
        }
        return targetUser;   
    }
    
    public ArrayList selectUserByUsertype()
    {
        UserDAO userDAO = new UserDAOImpl();
        resultList = userDAO.selectUserByUsertype(USER_TYPE_STUDENT);
        for(int i = 0; i < resultList.size(); i++)
        {
            targetUser = (UserBean)resultList.get(i);
            System.out.println("SELECT BY USERTYPE SUCCESSFULL");
            System.out.println("TARGET: " + targetUser.getUsername());
        }
        return resultList;
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
    
}
