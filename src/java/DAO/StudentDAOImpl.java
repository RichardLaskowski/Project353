package DAO;

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
    private String endYear;
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

        try 
        {
            connect2DB();
            String insertString;
            Statement stmt = DBConn.createStatement();
            insertString = "INSERT INTO itkstu.student "
                + "(dateOfBirth, height, weight, street, city, country, zipcode, phone, school, endYear,
                    sat, act, psat, certification, essay, hobbies, username"
                + "', '" + studentModel.getDateOfBirth()
                + "', '" + studentModel.getHeight()
                + "', '" + studentModel.getWeight()
                + "', '" + studentModel.getStreet()
                + "', '" + studentModel.getCity()
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
                profileId = rs.getString("profileId");
                dateOfBirth = rs.getString("dateOfBirth");
                height = rs.getInt("height");
                weight = rs.getInt("weight");
                street = rs.getString("street");
                city = rs.getString("city");
                country = rs.getString("country");
                zipcode = rs.getString("zipcode");
                phone = rs.getString("phone");
                school = rs.getString("school");
                endYear = rs.getInt("endYear");
                sat = rs.getInt("sat");
                act = rs.getInt("act");
                psat = rs.getInt("psat");
                cerification = rs.getString("certification");
                essay = rs.getString("essay");
                hobbies = rs.getString("hobbies");
                username = rs.getString("username");
            }
        }
    }
}