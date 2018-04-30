/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.UniversityNameBean;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author IT353S843
 */
public class ShowcaseUniversityDAOImpl implements ShowcaseUniversityDAO{

    private ArrayList resultList;
    private Connection DBConn = null;
    private String myDB = "jdbc:derby://localhost:1527/Project353";
    private String driver = "org.apache.derby.jdbc.ClientDriver";
    
    public void connect2DB()
    {
        DBHelper.loadDriver(driver);
        DBConn = DBHelper.connect2DB(myDB, "itkstu","student");
    }
    
    @Override
    public ArrayList<String> GetShowCaseUniversities() {
        resultList = new ArrayList();
        String selectString = "SELECT * FROM itkstu.ShowCaseUniversity "
                + "WHERE isshowcase = '1'";
        
        try
        {
            connect2DB();
            String image = "";
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(selectString);
            while(rs.next())
            {      
               // universityName = rs.getString("UNIVERSITYNAME");
                image = rs.getString("IMAGENAME");
                resultList.add(image);
            }
            stmt.close();
            rs.close();
            DBConn.close();
        }
        catch(Exception ex)
        {
           ex.printStackTrace();
        }
        return resultList;
    }


    @Override
    public int updateUniversityShowcase(String universityName) {
        int rowCount = 0;
        String query = "UPDATE itkstu.SHOWCASEUNIVERSITY"
                    + " SET ISSHOWCASE = '1'"
                    + " WHERE UNIVERSITYNAME = '" + universityName + "'";
         try
            {
                connect2DB();
                Statement stmt = DBConn.createStatement();
                rowCount = stmt.executeUpdate(query);              
                DBConn.close();
            }
         catch(Exception ex){
             ex.printStackTrace();
         }
        return rowCount;
    }

    @Override
    public int updateUniversityUnShowcase(String universityName) {
         int rowCount = 0;
        String query = "UPDATE itkstu.SHOWCASEUNIVERSITY"
                    + " SET ISSHOWCASE = '0'"
                    + " WHERE UNIVERSITYNAME = '" + universityName + "'";
         try
            {
                connect2DB();
                Statement stmt = DBConn.createStatement();
                rowCount = stmt.executeUpdate(query);              
                DBConn.close();
            }
         catch(Exception ex){
             ex.printStackTrace();
         }
        return rowCount;
    }
}  
    
    
