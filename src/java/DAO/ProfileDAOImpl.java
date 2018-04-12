/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ProfileBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

/**
 *
 * @author Richa
 */
public class ProfileDAOImpl implements ProfileDAO
{
    @Override
    public int createProfile(ProfileBean profile)
    {
        //local variables
        int rowCount = 0;
        String insertString = "";
        
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        }
        catch(ClassNotFoundException e)
        {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        
//        try
//        {
//            //Logging into database. Need to make sure username and password are correct
//            String myDB = "jdbc:derby://localhost:1527/Project353";
//            Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");
//            
//            //Checking to see if the Username already exist by running SELECT statement
//            //where username = profile.getUserId()
//            ArrayList target = selectByUsername();
//            
//            //If SELECT statment returned a non empty ArrayList we know that
//            //that the username already exist and can handle the error before throwing the exception
//            if(target.isEmpty())
//            {
//                //Username was not found.... continue creating profile.
//                Statement stmt = DBConn.createStatement();
//                //insertString = "INSERT INTO "
//            }
//        }
//        catch
//        {
//
//        }
        
    }
    
    @Override
    public ArrayList selectAllProfiles()
    {
        
    }
    
    @Override
    public ArrayList selectByUsername()
    {
        
    }
}
