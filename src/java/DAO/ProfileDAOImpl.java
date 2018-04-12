/*
<<<<<<< HEAD
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
=======
 * To change this template, choose Tools | Templates
>>>>>>> origin
 * and open the template in the editor.
 */
package DAO;

<<<<<<< HEAD
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
=======
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Model.ProfileBean;
import Model.RecruiterBean;
import Model.StudentBean;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ProfileDAOImpl implements ProfileDAO {

    public static final String SALT = "my-salt-text";

    @Override
    public int createProfile(ProfileBean aProfile) {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        int rowCount = 0;
        String userId = aProfile.getUserId();
        if (checkUserIdValid(userId)) {

            try {
                String myDB = "jdbc:derby://localhost:1527/ProjectLinkedU";// connection string
                Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");
                String insertString, insertString1;
                Statement stmt = DBConn.createStatement();
                
                String saltedPassword = SALT + aProfile.getPassword();
                String hashedPassword = generateHash(saltedPassword);

                insertString = "INSERT INTO ProjectLinkedU.LoginInfo VALUES ('"
                        + aProfile.getUserId()
                        + "','" + hashedPassword
                        + "','" + aProfile.getFirstName()
                        + "','" + aProfile.getLastName()
                        + "','" + aProfile.getEmail()
                        + "','" + aProfile.getSecurityQuestion()
                        + "','" + aProfile.getSecurityAnswer()
                        + "','" + aProfile.getUserType()
                        + "')";
                
                rowCount = stmt.executeUpdate(insertString);
                if(rowCount==1){
                    
                    if(aProfile.getUserType().equalsIgnoreCase("Student")){
                rowCount = 0;
                insertString1 = "INSERT INTO ProjectLinkedU.StudentDetail (USERNAME) VALUES('"
                        + aProfile.getUserId()
                        + "')";
                rowCount = stmt.executeUpdate(insertString1);
                }
                    else{
                        rowCount = 0;
                insertString1 = "INSERT INTO ProjectLinkedU.RecruiterDetail (USERNAME) VALUES('"
                        + aProfile.getUserId()
                        + "')";
                rowCount = stmt.executeUpdate(insertString1);
                    }
                }
                System.out.println("insert string =" + insertString);
                DBConn.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        // if insert is successful, rowCount will be set to 1 (1 row inserted successfully). Else, insert failed.
        return rowCount;
    }

    @Override
    public int checkCredentials(ProfileBean aProfile) {
        String pwd = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }

        try {
            String myDB = "jdbc:derby://localhost:1527/ProjectLinkedU";// connection string
            Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");
            String selectString;
            Statement stmt = DBConn.createStatement();
            selectString = "select * from ProjectLinkedU.LoginInfo where username = "
                    + "'" + aProfile.getUserId() + "'";

            ResultSet rs = stmt.executeQuery(selectString);
            while (rs.next()) {

                pwd = rs.getString("password");
            }
            // remember to use the same SALT value use used while storing password
            // for the first time.
            String pwd1 = aProfile.getPassword();
            String saltedPassword = SALT + pwd1;
            String hashedPassword = generateHash(saltedPassword);

            if (hashedPassword.equals(pwd)) {
                return 1;
            }
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return 0;
    }

    public static String generateHash(String input) {
        StringBuilder hash = new StringBuilder();

        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            byte[] hashedBytes = sha.digest(input.getBytes());
            char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
            for (int idx = 0; idx < hashedBytes.length; ++idx) {
                byte b = hashedBytes[idx];
                hash.append(digits[(b & 0xf0) >> 4]);
                hash.append(digits[b & 0x0f]);
            }
        } catch (NoSuchAlgorithmException e) {
            // handle error here.
        }

        return hash.toString();
    }

    @Override
    public ProfileBean[] findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private Boolean checkUserIdValid(String userId) {
        Boolean value = false;
        try {
            String myDB = "jdbc:derby://localhost:1527/ProjectLinkedU";         // connection string
            Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");

            Statement stmt = DBConn.createStatement();
            String query = "SELECT USERNAME FROM ProjectLinkedU.LoginInfo ";
            query += "WHERE UserName = '" + userId + "'";

            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                value = false;
            } else {
                value = true;
            }
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return value;
    }
    
    @Override
    public int insertStudentDetails(String UserId, StudentBean astudent) {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        int rowCount = 0;

            try {
                String myDB = "jdbc:derby://localhost:1527/ProjectLinkedU";// connection string
                Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");
                String insertString;
                Statement stmt = DBConn.createStatement();
                
                insertString = "UPDATE ProjectLinkedU.STUDENTDETAIL SET"
                        + " DOB = '" + astudent.getDateOfBirth() +"'" 
                        + ", HEIGHT = " + astudent.getHeight() 
                        + ", WEIGHT = " + astudent.getWeight() 
                        + ", ADDRESS = '" + astudent.getStreet() + "'"
                        + ", CITY = '" + astudent.getCity() + "'"
                        + ", COUNTRY = '" + astudent.getCountry() + "'"
                        + ", POSTALCODE = '" + astudent.getPostalCode() + "'"
                        + ", PHONENO = '" + astudent.getPhoneNo() + "'"
                        + ", SCHOOL = '" + astudent.getSchoolName() + "'"
                        + ", ENDYEAR = '" + astudent.getEndYear() + "'"
                        + ", SAT = " + astudent.getSAT() 
                        + ", PSAT = " + astudent.getPSAT() 
                        + ", ACT = " + astudent.getACT()
                        + ", CERTIFICATION = '" + astudent.getCertification() + "'"
                        + ", HOBBIES = '" + astudent.getHobbies() + "'"
                        + ", ESSAY = '" + astudent.getEssayOfChoice()+ "'"
                        + ", UNIVERSITY = '" + astudent.getUniversitiesOfChoice()+ "'"
                        + ", MAJOR = '" + astudent.getMajorsOfChoice() + "'"
                        + " WHERE USERNAME = '" + UserId + "'";
                
                rowCount = stmt.executeUpdate(insertString);
                
                
                System.out.println("insert string =" + insertString);
                DBConn.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        // if insert is successful, rowCount will be set to 1 (1 row inserted successfully). Else, insert failed.
        return rowCount;
    }

    @Override
    public int insertRecruiterDetails(String UserId, RecruiterBean arecruiter) {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        int rowCount = 0;

            try {
                String myDB = "jdbc:derby://localhost:1527/ProjectLinkedU";// connection string
                Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");
                String insertString;
                Statement stmt = DBConn.createStatement();
                
                insertString = "UPDATE ProjectLinkedU.RECRUITERDETAIL SET"
                        + " UNIVERSITY = '" + arecruiter.getUniversity()+"'" 
                        + ", DEPARTMENT = '" + arecruiter.getDepartment()+"'"
                        + ", PhoneNo = '" + arecruiter.getPhoneNo()+"'"
                        + " WHERE USERNAME = '" + UserId + "'";
                
                rowCount = stmt.executeUpdate(insertString);
                
                
                System.out.println("insert string =" + insertString);
                DBConn.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        // if insert is successful, rowCount will be set to 1 (1 row inserted successfully). Else, insert failed.
        return rowCount;
    }

>>>>>>> origin
}
