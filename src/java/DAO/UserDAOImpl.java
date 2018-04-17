/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.UserBean;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDAOImpl implements UserDAO
{
    private ArrayList resultList;
    private Connection DBConn = null;
    private String myDB = "jdbc:derby://localhost:1527/Project353";
    private String driver = "org.apache.derby.jdbc.ClientDriver";
    private UserBean targetUser;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String secQuestion;
    private String secAnswer;
    private String userType;
    
    public void connect2DB()
    {
        DBHelper.loadDriver(driver);
        DBConn = DBHelper.connect2DB(myDB, "itkstu","student");
    }
    
    @Override
    public int createUser(UserBean userModel)
    {
        int rowCount = 0;
        
        try
        {
            connect2DB();
            String insertString;
            Statement stmt = DBConn.createStatement();
            insertString = "INSERT INTO itkstu.users "
                + "(username, password, firstname, lastname, email, securityquestion, securityanswer, usertype) "
                + "VALUES ('" + userModel.getUsername()
                + "', '" + userModel.getPassword()
                + "', '" + userModel.getFirstName()
                + "', '" + userModel.getLastName()
                + "', '" + userModel.getEmail()
                + "', '" + userModel.getSecurityQuestion()
                + "', '" + userModel.getSecurityAnswer()
                + "', '" + userModel.getUserType()
                + "')";

            rowCount = stmt.executeUpdate(insertString);
            DBConn.close();
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
        return rowCount;
    }
    
    @Override
    public ArrayList selectUserByUsername(String targetUsername)
    {   
        resultList = new ArrayList();
        String selectString = "SELECT * FROM itkstu.users "
                + "WHERE username = '" + targetUsername + "'";
        
        try
        {
            connect2DB();
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(selectString);
            
            while(rs.next())
            {
                username = rs.getString("username");
                password = rs.getString("password");
                firstName = rs.getString("firstname");
                lastName = rs.getString("lastname");
                email = rs.getString("email");
                secQuestion = rs.getString("securityquestion");
                secAnswer = rs.getString("securityanswer");
                userType = rs.getString("userType");
                
                targetUser = new UserBean(username, password, firstName, lastName, email, secQuestion, secAnswer, userType);
                resultList.add(targetUser);
            }
            DBConn.close();
        }
        catch(Exception e)
        {
            System.err.println("ERROR: SELECT USER BY USERNAME FAILED.");
            System.err.println("TARGET: " + targetUsername);
            e.printStackTrace();
        }
        return resultList;
    }
    
    @Override
    public ArrayList selectUserByUsertype(String targetUserType)
    {   
        
        resultList = new ArrayList();
        String selectString = "SELECT * FROM itkstu.users "
                + "WHERE usertype = '" + targetUserType + "'";
        
        try
        {
            connect2DB();
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(selectString);
            
            while(rs.next())
            {
                username = rs.getString("username");
                password = rs.getString("password");
                firstName = rs.getString("firstname");
                lastName = rs.getString("lastname");
                email = rs.getString("email");
                secQuestion = rs.getString("securityquestion");
                secAnswer = rs.getString("securityanswer");
                userType = rs.getString("userType");
                
                targetUser = new UserBean(username, password, firstName, lastName, email, secQuestion, secAnswer, userType);
                resultList.add(targetUser);
            }
            DBConn.close();
        }
        catch(Exception e)
        {
            System.err.println("ERROR: SELECT USER BY USERTYPE FAILED.");
            System.err.println("TARGET:" + targetUserType);
            e.printStackTrace();
        }
        return resultList;
    }   
}
