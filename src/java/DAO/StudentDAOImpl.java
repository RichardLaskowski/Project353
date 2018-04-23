package DAO;

import Model.StudentBean;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentDAOImpl implements StudentDAO
{
    private int profileId;
    private String dateOfBirth;
    private int height;
    private int weight;
    private String street;
    private String city;
    private String country;
    private String zipcode;
    private String phone;
    private String school;
    private int endYear;
    private int sat;
    private int act;
    private int psat;
    private String certification;
    private String essay;
    private String hobbies;
    private String username;

    private ArrayList resultList;
    private Connection DBConn = null;
    private String myDB = "jdbc:derby://localhost:1527/Project353";
    private String driver = "org.apache.derby.jdbc.ClientDriver";
    private StudentBean targetStudent;

    public void connect2DB()
    {
        DBHelper.loadDriver(driver);
        DBConn = DBHelper.connect2DB(myDB, "itkstu","student");
    }

    @Override
    public int createStudent(StudentBean studentModel)
    {
        int rowCount = 0;
        resultList = selectStudentByUsername(studentModel.getUsername());
        
        if(!resultList.isEmpty())
        {
            try 
            {
                connect2DB();
                String insertString;
                Statement stmt = DBConn.createStatement();
//                insertString = "INSERT INTO itkstu.student "
//                    + "(dateOfBirth, height, weight, address, country, zipcode, phone, school, endYear, "
//                    + "sat, act, psat, certification, essay, hobbies, username) "
//                    + "VALUES ('" + studentModel.getDateOfBirth()
//                    + "', '" + studentModel.getHeight()
//                    + "', '" + studentModel.getWeight()
//                    + "', '" + studentModel.getStreet() + " " + studentModel.getCity()
//                    + "', '" + studentModel.getCountry()
//                    + "', '" + studentModel.getZipcode()
//                    + "', '" + studentModel.getPhone()
//                    + "', '" + studentModel.getSchool()
//                    + "', '" + studentModel.getEndYear()
//                    + "', '" + studentModel.getSat()
//                    + "', '" + studentModel.getAct()
//                    + "', '" + studentModel.getPsat()
//                    + "', '" + studentModel.getCertification()
//                    + "', '" + studentModel.getEssay()
//                    + "', '" + studentModel.getHobbies()
//                    + "', '" + studentModel.getUsername()
//                    + "')";
           
 //               rowCount = stmt.executeUpdate(insertString);
                
                 insertString = "UPDATE itkstu.STUDENT SET"
                        + " DOB = '" + studentModel.getDateOfBirth() +"'" 
                        + ", HEIGHT = " + studentModel.getHeight() 
                        + ", WEIGHT = " + studentModel.getWeight() 
                        + ", ADDRESS = '" + studentModel.getStreet() + "'"
                        + ", CITY = '" + studentModel.getCity() + "'"
                        + ", COUNTRY = '" + studentModel.getCountry() + "'"
                        + ", ZIPCODE = '" + studentModel.getZipcode()+ "'"
                        + ", PHONE = '" + studentModel.getPhone()+ "'"
                        + ", SCHOOL = '" + studentModel.getSchool()+ "'"
                        + ", ENDYEAR = '" + studentModel.getEndYear() + "'"
                        + ", SAT = " + studentModel.getSat()
                        + ", ACT = " + studentModel.getAct()
                        + ", PSAT = " + studentModel.getPsat()  
                        + ", CERTIFICATION = '" + studentModel.getCertification() + "'"
                        + ", HOBBIES = '" + studentModel.getHobbies() + "'"
                        + ", ESSAY = '" + studentModel.getEssay()+ "'"
                        + " WHERE USERNAME = '" + studentModel.getUsername() + "'";
                
                rowCount = stmt.executeUpdate(insertString);
                
                DBConn.close();
            } 
            catch (SQLException e) 
            {
                System.err.println(e.getMessage());
            }
        }
        else
        {
            System.err.println("STUDENDAOIMPL: Student not Exists");
        }
        return rowCount;
    }

    @Override 
    public ArrayList selectStudentByUsername(String targetUsername)
    {
        resultList = new ArrayList();
        String selectString = "SELECT * FROM itkstu.student "
            + "WHERE username = '" + targetUsername + "'";

        try
        {
            connect2DB();
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(selectString);

            while(rs.next())
            {
                profileId = rs.getInt("profileId");
                dateOfBirth = rs.getString("dateOfBirth");
                height = rs.getInt("height");
                weight = rs.getInt("weight");
                street = rs.getString("address");
                city = rs.getString("address");
                country = rs.getString("country");
                zipcode = rs.getString("zipcode");
                phone = rs.getString("phone");
                school = rs.getString("school");
                endYear = rs.getInt("endYear");
                sat = rs.getInt("sat");
                act = rs.getInt("act");
                psat = rs.getInt("psat");
                certification = rs.getString("certification");
                essay = rs.getString("essay");
                hobbies = rs.getString("hobbies");
                username = rs.getString("username");

                targetStudent = new StudentBean(profileId, dateOfBirth, height, weight, street, city, country, zipcode,
                phone, school, endYear, sat, act, psat, certification, essay, hobbies, username);
                resultList.add(targetStudent);
            }
            DBConn.close();
        }
        catch(Exception e)
        {
            System.err.println("ERROR SELECT STUDENT BY USERNAME FAILED");
            System.err.println("TARGET: " + targetUsername);
            e.printStackTrace();
        }
        return resultList;
    }
}