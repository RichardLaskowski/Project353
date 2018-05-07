package DAO;

import Model.UniversityBean;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class UniversityDAOImpl implements UniversityDAO
{
    private ArrayList resultList;
    private Connection DBConn = null;
    private String myDB = "jdbc:derby://localhost:1527/Project353";
    private String driver = "org.apache.derby.jdbc.ClientDriver";
    private UniversityBean targetUniversity;
    private String profileId;
    private String universityEmail;
    private String username;
    private ArrayList recruiters;

    public void connect2DB()
    {
        DBHelper.loadDriver(driver);
        DBConn = DBHelper.connect2DB(myDB, "itkstu","student");
    }  

    @Override
    public ArrayList selectUniversityByUsername(String targetUsername)
    {
        resultList = new ArrayList();
        String selectString = "SELECT * FROM itkstu.university "
            + "WHERE username = '" + targetUsername + "'";
        System.out.println("UNIVERSITYDAOIMPL: " + selectString);
        try 
        {
            connect2DB();
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(selectString);
            
            while(rs.next())
            {
                profileId = rs.getString("profileId");
                universityEmail = rs.getString("universityEmail");
                username = rs.getString("username");

                targetUniversity = new UniversityBean(profileId, universityEmail, username);
                resultList.add(targetUniversity);
            }
            DBConn.close();
        } 
        catch (Exception e) 
        {
            System.err.println("ERROR: SELECT UNIVERSITY BY USERNAME FAILED.");
            System.err.println("TARGET: " + targetUsername);
            e.printStackTrace();
        }
        return resultList;
    }
    
    @Override
    public ArrayList selectUniversityByProfileId(String targetProfileId)
    {
        resultList = new ArrayList();
        String selectString = "SELECT * FROM itkstu.university "
            + "WHERE profileId = '" + targetProfileId + "'";
        System.out.println("UNIVERSITYDAOIMPL: " + selectString);

        try 
        {
            connect2DB();
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(selectString);
            
            while(rs.next())
            {
                profileId = rs.getString("profileId");
                universityEmail = rs.getString("universityEmail");
                username = rs.getString("username");

                targetUniversity = new UniversityBean(profileId, universityEmail, username);
                resultList.add(targetUniversity);
            }
            DBConn.close();
        } 
        catch (Exception e) 
        {
            System.err.println("ERROR: SELECT UNIVERSITY BY PROFILEID FAILED.");
            System.err.println("TARGET: " + targetProfileId);
            e.printStackTrace();
        }
        return resultList;
    }
}
