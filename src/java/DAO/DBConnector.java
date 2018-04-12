<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ericz
 */
public class DBConnector {

    /*This will return a USER object once the class is created
    as of now this is just a holder spot 
    I will create a insert user also once it is created as well
    */
   public static String get_user_by_id(int i){
        DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
        String myDB = "jdbc:derby://localhost:1527/Test";
        Connection DBConn = DBHelper.connect2DB(myDB, "ejzumba", "Eric2018");
        String query= "SELECT * FROM EJZUMBA.USERS where USERID= "+ i;
        String retVal= "";
        
        try {

            // With the connection made, create a statement to talk to the DB server.
            // Create a SQL statement to query, retrieve the rows one by one (by going to the
            // columns), and formulate the result string to send back to the client.
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            String userName, lastName, firstName;
            java.util.Date hireDate;
            int deptNo, signingBonus, empNo;
            double salary;
            while (rs.next()) {
              
                userName = rs.getString("USERNAME");
                lastName = rs.getString("lastname");
                firstName = rs.getString("firstname");
                         
                retVal+= userName+", ";
                retVal+= lastName+", ";
                retVal+= firstName;                       
               
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            System.err.println("ERROR: Problems with SQL select");
            e.printStackTrace();
        }
        try {
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        try{
            //aDepartment.setEmployees(anEmployeeCollection);
        }catch(NullPointerException e){
            e.printStackTrace();
            
        }
        
        return retVal;
    }
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ericz
 */
public class DBConnector {

    /*This will return a USER object once the class is created
    as of now this is just a holder spot 
    I will create a insert user also once it is created as well
    */
   public static String get_user_by_id(int i){
        DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
        String myDB = "jdbc:derby://localhost:1527/Test";
        Connection DBConn = DBHelper.connect2DB(myDB, "ejzumba", "Eric2018");
        String query= "SELECT * FROM EJZUMBA.USERS where USERID= "+ i;
        String retVal= "";
        
        try {

            // With the connection made, create a statement to talk to the DB server.
            // Create a SQL statement to query, retrieve the rows one by one (by going to the
            // columns), and formulate the result string to send back to the client.
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            String userName, lastName, firstName;
            java.util.Date hireDate;
            int deptNo, signingBonus, empNo;
            double salary;
            while (rs.next()) {
              
                userName = rs.getString("USERNAME");
                lastName = rs.getString("lastname");
                firstName = rs.getString("firstname");
                         
                retVal+= userName+", ";
                retVal+= lastName+", ";
                retVal+= firstName;                       
               
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            System.err.println("ERROR: Problems with SQL select");
            e.printStackTrace();
        }
        try {
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        try{
            //aDepartment.setEmployees(anEmployeeCollection);
        }catch(NullPointerException e){
            e.printStackTrace();
            
        }
        
        return retVal;
   }
//sql for users->profile->posts
   
   

}
>>>>>>> origin
