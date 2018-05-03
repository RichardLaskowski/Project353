/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.UserBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;


/**
 *
 * @author ericz
 */
public class SearchDAOImpl implements SearchDAO {

    @Override
    public List <UserBean> SearchByName(String name) {
        List<UserBean> pb= new ArrayList<>();
        UserBean user;
        
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        }catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        try {
            String myDB = "jdbc:derby://localhost:1527/Project353";
            Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");
            String insertString, insertString1;
            Statement stmt = DBConn.createStatement();
            
            String query="SELECT * FROM USERS WHERE "
                    + "FIRSTNAME= '"+name
                    +"'"+" OR LASTNAME= '"+name+"'";
            ResultSet rs= stmt.executeQuery(query);
           
            while(rs.next()){
                user= new UserBean();
                user.setUsername(rs.getString("USERNAME"));
              //  user.setPassword(rs.getString("PASSWORD"));
                user.setFirstName(rs.getString("FIRSTNAME"));
                user.setLastName(rs.getString("LASTNAME"));
                user.setEmail(rs.getString("EMAIL"));
              //  user.setSecurityQuestion(rs.getString("SECQUES"));
              //  user.setSecurityAnswer(rs.getString("SECANS"));
                user.setUserType(rs.getString("USERTYPE"));
                
                pb.add(user);
            }
       
            
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return pb;
    }
    
    public static void main(String[] args){
        SearchDAOImpl x= new SearchDAOImpl();
        List<UserBean> pb= x.SearchByName("Daniel");
        pb.forEach((UserBean i) -> {
            System.out.println(i.toString());
        });
        
    }

}
