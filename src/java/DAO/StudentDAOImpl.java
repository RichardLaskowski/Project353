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
    private String address;
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
        System.out.println(studentModel.getDateOfBirth());
        System.out.println(studentModel.getHeight());
        System.out.println(studentModel.getWeight());
        System.out.println(studentModel.getStreet());
        System.out.println(studentModel.getCity());
        System.out.println(studentModel.getCountry());
        System.out.println(studentModel.getZipcode());
        System.out.println(studentModel.getPhone());
        System.out.println(studentModel.getSchool());
        System.out.println(studentModel.getEndYear());
        System.out.println(studentModel.getSat());
        System.out.println(studentModel.getAct());
        System.out.println(studentModel.getPsat());
        System.out.println(studentModel.getEssay());
        System.out.println(studentModel.getHobbies());
        System.out.println(studentModel.getCertification());
        System.out.println(studentModel.getUsername());
        
        if(resultList.isEmpty())
        {
            try 
            {
                connect2DB();
                String insertString;
                Statement stmt = DBConn.createStatement();
                insertString = "INSERT INTO itkstu.student "
                    + "(dateOfBirth, height, weight, address, country, zipcode, phone, school, endYear, "
                    + "sat, act, psat, certification, essay, hobbies, username) "
                    + "VALUES ('" + studentModel.getDateOfBirth()
                    + "', '" + studentModel.getHeight()
                    + "', '" + studentModel.getWeight()
                    + "', '" + studentModel.getStreet() + " " + studentModel.getCity()
                    + "', '" + studentModel.getCountry()
                    + "', '" + studentModel.getZipcode()
                    + "', '" + studentModel.getPhone()
                    + "', '" + studentModel.getSchool()
                    + "', '" + studentModel.getEndYear()
                    + "', '" + studentModel.getSat()
                    + "', '" + studentModel.getAct()
                    + "', '" + studentModel.getPsat()
                    + "', '" + studentModel.getCertification()
                    + "', '" + studentModel.getEssay()
                    + "', '" + studentModel.getHobbies()
                    + "', '" + studentModel.getUsername()
                    + "')";      
             
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
    public int updateStudent(StudentBean studentModel)
    {
        int rowCount = 0;
        resultList = selectStudentByUsername(studentModel.getUsername());
        System.out.println(studentModel.getDateOfBirth());
        System.out.println(studentModel.getHeight());
        System.out.println(studentModel.getWeight());
        System.out.println(studentModel.getStreet());
        System.out.println(studentModel.getCity());
        System.out.println(studentModel.getCountry());
        System.out.println(studentModel.getZipcode());
        System.out.println(studentModel.getPhone());
        System.out.println(studentModel.getSchool());
        System.out.println(studentModel.getEndYear());
        System.out.println(studentModel.getSat());
        System.out.println(studentModel.getAct());
        System.out.println(studentModel.getPsat());
        System.out.println(studentModel.getEssay());
        System.out.println(studentModel.getHobbies());
        System.out.println(studentModel.getCertification());
        System.out.println(studentModel.getUsername());
        
        if(!resultList.isEmpty())
        {
            try 
            {
                connect2DB();
                String insertString;
                Statement stmt = DBConn.createStatement();
                insertString = "UPDATE itkstu.student "
                        + "SET dateOfBirth = '" + studentModel.getDateOfBirth()
                        + "', height = '" + studentModel.getHeight()
                        + "', weight = '" + studentModel.getWeight()
                        + "', address = '" + studentModel.getStreet() + " " + studentModel.getCity()
                        + "', country = '" + studentModel.getCountry()
                        + "', zipcode = '" + studentModel.getZipcode()
                        + "', phone =  '" + studentModel.getPhone()
                        + "', school = '" + studentModel.getSchool()
                        + "', endYear = '" + studentModel.getEndYear()
                        + "', sat = '" + studentModel.getSat()
                        + "', act = '" + studentModel.getAct()
                        + "', psat = '" + studentModel.getPsat()
                        + "', essay = '" + studentModel.getEssay()
                        + "', hobbies = '" + studentModel.getHobbies()
                        + "', certification = '" + studentModel.getCertification()
                        + "' WHERE username = '" + studentModel.getUsername() + "'";
             
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
        System.out.println("STUDENTDAOIMPL: Target Student Username - " + targetUsername);
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
                address = rs.getString("address");
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
                
                street = address.substring(0,address.indexOf(" "));
                city = address.substring(address.indexOf(" ") + 1);

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