/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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
public class SearchDAOImpl  {

//    @Override
//    public List <ProfileBean> SearchByName(String name) {
//        List<ProfileBean> pb= new ArrayList<>();
//        ProfileBean user;
//        
//        try {
//            Class.forName("org.apache.derby.jdbc.ClientDriver");
//        }catch (ClassNotFoundException e) {
//            System.err.println(e.getMessage());
//            System.exit(0);
//        }
//        try {
//            String myDB = "jdbc:derby://localhost:1527/Project353";// connection string
//            Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");
//            String insertString, insertString1;
//            Statement stmt = DBConn.createStatement();
//            
//            String query="SELECT * FROM Project353.StudentDetail WHERE "
//                    + "FIRSTNAME= '"+name
//                    +"'"+" OR LASTNAME= '"+name+"'";
//            String query2= "SELECT * FROM Project353.RecruiterDetail WHERE "
//                    + "FIRSTNAME= '"+name
//                    +"'"+" OR LASTNAME= '"+name+"'";
//            ResultSet rs= stmt.executeQuery(query);
//           
//            while(rs.next()){
//                user= new ProfileBean();
//                user.setUserId(rs.getString("USERNAME"));
//              //  user.setPassword(rs.getString("PASSWORD"));
//                user.setFirstName(rs.getString("FIRSTNAME"));
//                user.setLastName(rs.getString("LASTNAME"));
//                user.setEmail(rs.getString("EMAIL"));
//              //  user.setSecurityQuestion(rs.getString("SECQUES"));
//              //  user.setSecurityAnswer(rs.getString("SECANS"));
//                user.setUserType(rs.getString("USERTYPE"));
//                
//                pb.add(user);
//            }
////            rs= stmt.executeQuery(query2);
////            while(rs.next()){
////                user= new ProfileBean();
////                user.setUserId(rs.getString("USERNAME"));
////              //  user.setPassword(rs.getString("PASSWORD"));
////                user.setFirstName(rs.getString("FIRSTNAME"));
////                user.setLastName(rs.getString("LASTNAME"));
////                user.setEmail(rs.getString("EMAIL"));
////              //  user.setSecurityQuestion(rs.getString("SECQUES"));
////              //  user.setSecurityAnswer(rs.getString("SECANS"));
////                user.setUserType(rs.getString("USERTYPE"));
////                
////                pb.add(user);
////                
////            }          
//            
//        } catch (SQLException e) {
//            System.err.println(e.getMessage());
//        }
//
//        return pb;
//    }
    
//    public static void main(String[] args){
//        SearchDAOImpl x= new SearchDAOImpl();
//        List<ProfileBean> pb= x.SearchByName("James");
//        pb.forEach((ProfileBean i) -> {
//            System.out.println(i.toString());
//        });
//        
//    }

}
