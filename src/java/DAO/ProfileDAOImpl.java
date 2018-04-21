/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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

public class ProfileDAOImpl implements ProfileDAO
{

    public static final String SALT = "my-salt-text";

    @Override
    public int createProfile(ProfileBean aProfile)
    {
        int rowCount = 0;
        String userId = aProfile.getUserId();
        
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } 
        catch (ClassNotFoundException e)
        {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        
        if (checkUserIdValid(userId))
        {
            try
            {
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
                
                if (rowCount == 1)
                {

                    if (aProfile.getUserType().equalsIgnoreCase("Student"))
                    {
                        rowCount = 0;
                        insertString1 = "INSERT INTO ProjectLinkedU.StudentDetail (USERNAME) VALUES('"
                                + aProfile.getUserId()
                                + "')";
                        rowCount = stmt.executeUpdate(insertString1);
                    } else
                    {
                        rowCount = 0;
                        insertString1 = "INSERT INTO ProjectLinkedU.RecruiterDetail (USERNAME) VALUES('"
                                + aProfile.getUserId()
                                + "')";
                        rowCount = stmt.executeUpdate(insertString1);
                    }
                }
                System.out.println("insert string =" + insertString);
                DBConn.close();
            } catch (SQLException e)
            {
                System.err.println(e.getMessage());
            }
        }
        // if insert is successful, rowCount will be set to 1 (1 row inserted successfully). Else, insert failed.
        return rowCount;
    }

    @Override
    public int checkCredentials(ProfileBean aProfile)
    {
        String pwd = null;
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e)
        {
            System.err.println(e.getMessage());
            System.exit(0);
        }

        try
        {
            String myDB = "jdbc:derby://localhost:1527/ProjectLinkedU";// connection string
            Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");
            String selectString;
            Statement stmt = DBConn.createStatement();
            selectString = "select * from ProjectLinkedU.LoginInfo where username = "
                    + "'" + aProfile.getUserId() + "'";

            ResultSet rs = stmt.executeQuery(selectString);
            while (rs.next())
            {

                pwd = rs.getString("password");
            }
            // remember to use the same SALT value use used while storing password
            // for the first time.
            String pwd1 = aProfile.getPassword();
            String saltedPassword = SALT + pwd1;
            String hashedPassword = generateHash(saltedPassword);

            if (hashedPassword.equals(pwd))
            {
                return 1;
            }
            DBConn.close();
        } catch (SQLException e)
        {
            System.err.println(e.getMessage());
        }
        return 0;
    }

    public static String generateHash(String input)
    {
        StringBuilder hash = new StringBuilder();

        try
        {
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            byte[] hashedBytes = sha.digest(input.getBytes());
            char[] digits =
            {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'
            };
            for (int idx = 0; idx < hashedBytes.length; ++idx)
            {
                byte b = hashedBytes[idx];
                hash.append(digits[(b & 0xf0) >> 4]);
                hash.append(digits[b & 0x0f]);
            }
        } catch (NoSuchAlgorithmException e)
        {
            // handle error here.
        }

        return hash.toString();
    }

    @Override
    public ProfileBean[] findAll()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private Boolean checkUserIdValid(String userId)
    {
        Boolean value = false;
        try
        {
            String myDB = "jdbc:derby://localhost:1527/ProjectLinkedU";         // connection string
            Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");

            Statement stmt = DBConn.createStatement();
            String query = "SELECT USERNAME FROM ProjectLinkedU.LoginInfo ";
            query += "WHERE UserName = '" + userId + "'";

            ResultSet rs = stmt.executeQuery(query);
            if (rs.next())
            {
                value = false;
            } else
            {
                value = true;
            }
            DBConn.close();
        } catch (SQLException e)
        {
            System.err.println(e.getMessage());
        }
        return value;
    }

    @Override
    public int insertStudentDetails(String UserId, StudentBean astudent)
    {
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e)
        {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        int rowCount = 0;

        try
        {
            String myDB = "jdbc:derby://localhost:1527/ProjectLinkedU";// connection string
            Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");
            String insertString;
            Statement stmt = DBConn.createStatement();

            insertString = "UPDATE ProjectLinkedU.STUDENTDETAIL SET"
                    + " DOB = '" + astudent.getDateOfBirth() + "'"
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
                    + ", ESSAY = '" + astudent.getEssayOfChoice() + "'"
                    + ", UNIVERSITY = '" + astudent.getUniversitiesOfChoice() + "'"
                    + ", MAJOR = '" + astudent.getMajorsOfChoice() + "'"
                    + " WHERE USERNAME = '" + UserId + "'";

            rowCount = stmt.executeUpdate(insertString);

            System.out.println("insert string =" + insertString);
            DBConn.close();
        } catch (SQLException e)
        {
            System.err.println(e.getMessage());
        }
        // if insert is successful, rowCount will be set to 1 (1 row inserted successfully). Else, insert failed.
        return rowCount;
    }

    @Override
    public int insertRecruiterDetails(String UserId, RecruiterBean arecruiter)
    {
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e)
        {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        int rowCount = 0;

        try
        {
            String myDB = "jdbc:derby://localhost:1527/ProjectLinkedU";// connection string
            Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");
            String insertString;
            Statement stmt = DBConn.createStatement();

            insertString = "UPDATE ProjectLinkedU.RECRUITERDETAIL SET"
                    + " UNIVERSITY = '" + arecruiter.getUniversity() + "'"
                    + ", DEPARTMENT = '" + arecruiter.getDepartment() + "'"
                    + ", PhoneNo = '" + arecruiter.getPhoneNo() + "'"
                    + " WHERE USERNAME = '" + UserId + "'";

            rowCount = stmt.executeUpdate(insertString);

            System.out.println("insert string =" + insertString);
            DBConn.close();
        } catch (SQLException e)
        {
            System.err.println(e.getMessage());
        }
        // if insert is successful, rowCount will be set to 1 (1 row inserted successfully). Else, insert failed.
        return rowCount;
    }

    @Override
    public String passwordUpdate(String userId)
    {
        String value = "No Value";
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } 
        catch (ClassNotFoundException e)
        {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        
        if (checkUserIdValid(userId)==false)
        {
            try
            {
                String myDB = "jdbc:derby://localhost:1527/ProjectLinkedU";// connection string
                Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");
                String selectString;
                Statement stmt = DBConn.createStatement();
                selectString = "SELECT EMAIL FROM ProjectLinkedU.LoginInfo WHERE USERNAME = '"
                        + userId+ "'";
                ResultSet rs = stmt.executeQuery(selectString);
                if (rs.next())
                {
                value = rs.getString("EMAIL");
                }   
                System.out.println("select string =" + selectString);
                DBConn.close();
            } catch (SQLException e)
            {
                System.err.println(e.getMessage());
            }
        }
        // if insert is successful, rowCount will be set to 1 (1 row inserted successfully). Else, insert failed.
        return value;
    }

    
    @Override
    public int newpasswordUpdate(String userId, String pwd)
    {
        int rowCount = 0;
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } 
        catch (ClassNotFoundException e)
        {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        
        if (checkUserIdValid(userId)==false)
        {
            try
            {
                String myDB = "jdbc:derby://localhost:1527/ProjectLinkedU";// connection string
                Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");
                String updateString;
                
                Statement stmt = DBConn.createStatement();

                String saltedPassword = SALT + pwd;
                String hashedPassword = generateHash(saltedPassword);

                updateString = "UPDATE ProjectLinkedU.LoginInfo SET PASSWORD = '" + hashedPassword 
                        + "' WHERE USERNAME = '" + userId + "'";
                rowCount = stmt.executeUpdate(updateString);
                
                System.out.println("select string =" + updateString);
                DBConn.close();
            } catch (SQLException e)
            {
                System.err.println(e.getMessage());
            }
        }
        // if insert is successful, rowCount will be set to 1 (1 row inserted successfully). Else, insert failed.
        return rowCount;
    }
@Override
    public StudentBean findByName(String userId) {
        // if interested in matching wild cards, use: LIKE and '%" + aName + "%'";
        String query = "SELECT * FROM ProjectLinkedU.studentdetail ";
        query += "WHERE UserName = '" + userId + "'";

        StudentBean aStudentCollection = selectDetailsFromDB(query);
        return aStudentCollection;
    }
    
    private StudentBean selectDetailsFromDB(String query) {
        StudentBean aStudentBean = new StudentBean();
        //ArrayList aProfileBeanCollection = new ArrayList();
        Connection DBConn = null;
        try {
            DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
            // if doing the above in Oracle: DBHelper.loadDriver("oracle.jdbc.driver.OracleDriver");
            String myDB = "jdbc:derby://localhost:1527/projectLinkedU";
            // if doing the above in Oracle:  String myDB = "jdbc:oracle:thin:@oracle.itk.ilstu.edu:1521:ora478";
            DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");

            // With the connection made, create a statement to talk to the DB server.
            // Create a SQL statement to query, retrieve the rows one by one (by going to the
            // columns), and formulate the result string to send back to the client.
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            String dateOfBirth = "", height1 = "", weight1 = "", street = "", city = "", country = "", postalCode = "", phoneNo = "", schoolName = "", endYear = "",
                    SAT1 = "", PSAT1 = "", ACT1 = "", certification = "", hobbies = "", essayOfChoice = "", universitiesOfChoice = "", majorsOfChoice = "";
            int height = 0, weight = 0, SAT = 0, PSAT = 0, ACT = 0;
            while (rs.next()) {
                dateOfBirth = rs.getString("DOB");
                height1 = rs.getString("HEIGHT");
                weight1 = rs.getString("WEIGHT");
                street = rs.getString("ADDRESS");
                city = rs.getString("CITY");
                country = rs.getString("COUNTRY");
                postalCode = rs.getString("POSTALCODE");
                phoneNo = rs.getString("PHONENO");
                schoolName = rs.getString("SCHOOL");
                endYear = rs.getString("ENDYEAR");
                SAT1 = rs.getString("SAT");
                PSAT1 = rs.getString("PSAT");
                ACT1 = rs.getString("ACT");
                certification = rs.getString("CERTIFICATION");
                hobbies = rs.getString("HOBBIES");
                essayOfChoice = rs.getString("ESSAY");
                universitiesOfChoice = rs.getString("UNIVERSITY");
                majorsOfChoice = rs.getString("MAJOR");
                }
            if(height1!=null)
                height = Integer.parseInt(height1);
             
            if(weight1!=null)
                weight = Integer.parseInt(weight1);
            
            if(SAT1!=null)
                SAT = Integer.parseInt(SAT1);
            
            if(PSAT1!=null)
                PSAT = Integer.parseInt(PSAT1);
            
            if(ACT1!=null)
                ACT = Integer.parseInt(ACT1);
            
                aStudentBean = new StudentBean(dateOfBirth, height, weight, street, city, country, postalCode, phoneNo, schoolName, endYear,
                    SAT, PSAT, ACT, certification, hobbies, essayOfChoice, universitiesOfChoice, majorsOfChoice);
              
            rs.close();
            stmt.close();
            
        } catch (Exception e) {
            System.err.println("ERROR: Problems with SQL select");
            e.printStackTrace();
            return aStudentBean = null;
        }
        try {
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return aStudentBean;
    }

}
