/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.PostBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    private int imageId;
    private int videoId;
    private String textContent;
    private int postId;
     
    public void connect2DB()
    {
        DBHelper.loadDriver(driver);
        DBConn = DBHelper.connect2DB(myDB, "itkstu","student");
    }
    
    @Override
    public ArrayList selectPostsByUsername(String targetUsername)
    {
        resultList = new ArrayList();
        String selectString = "SELECT textcontent FROM itkstu.posts "
                + "WHERE username = '" + targetUsername + "' "
                + "ORDER BY postId DESC ";
        
        try
        {
            connect2DB();
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(selectString);
            
            while(rs.next())
            {
                textContent = rs.getString("textcontent");
                targetPost = new PostBean(textContent);
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
    
    @Override 
    public int createPost(PostBean postModel)
    {
        int rowCount = 0;
        
        try
        {
            connect2DB();
            String insert = "INSERT INTO itkstu.posts (username, imageId, videoId, textcontent) "
                    + "VALUES ('" + postModel.getUsername()
                    + "', " + postModel.getImageId()
                    + ", " + postModel.getVideoId()
                    + ", ?)";
            System.out.println(insert);
            PreparedStatement pstmt = DBConn.prepareStatement(insert);
            pstmt.setString(1,postModel.getTextContent());
            rowCount = pstmt.executeUpdate();
            DBConn.close();
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
        return rowCount;
    }
    
    @Override
    public ArrayList selectAllPosts()
    {
        resultList = new ArrayList();
        String selectString = "SELECT textcontent FROM itkstu.posts"
                + " ORDER BY postId DESC";
        
        try
        {
            connect2DB();
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(selectString);
            
            while(rs.next())
            {
                textContent = rs.getString("textcontent");
                targetPost = new PostBean(textContent);
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
