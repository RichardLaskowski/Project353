/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.PostBean;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Richa
 */
public class PostDAOImpl implements PostDAO
{
    private ArrayList resultList;
    private Connection DBConn = null;
    private String myDB = "jdbc:derby://localhost:1527/Project353";
    private String driver = "org.apache.derby.jdbc.ClientDriver";
    private PostBean targetPost = new PostBean();
    private File picture;
    private File video;
    private String story;
    private String firstName;
     
    public void connect2DB()
    {
        DBHelper.loadDriver(driver);
        DBConn = DBHelper.connect2DB(myDB, "itkstu","student");
    }
    
    @Override 
    public int createPost()
    {
        
    }
    
    @Override
    public ArrayList selectAllPosts()
    {
        resultList = new ArrayList();
        String story = "";
        String selectString = "SELECT textcontent FROM itkstu.posts";
      try
        {
            connect2DB();
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(selectString);
            
            while(rs.next())
            {
                story = rs.getString("textcontent");
                targetPost = new PostBean(story);
                resultList.add(targetPost);
            }
            DBConn.close();
        }
        catch(Exception e)
        {
            System.err.println("ERROR");
            System.err.println("TARGET: " + targetPost);
            e.printStackTrace();
        }
        return resultList;
    }
}
