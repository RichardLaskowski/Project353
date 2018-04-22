
import DAO.DBHelper;
import Model.ImageBean;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ImageDAOImpl implements ImageDAO
{
    private ArrayList resultList;
    private Connection DBConn = null;
    private String myDB = "jdbc:derby://localhost:1527/Project353";
    private String driver = "org.apache.derby.jdbc.ClientDriver";
    private ImageBean targetImage;
    private int imageId;
    private String source;

    public void connect2DB()
    {
        DBHelper.loadDriver(driver);
        DBConn = DBHelper.connect2DB(myDB, "itkstu","student");
    }

    @Override
    public int createImage(ImageBean imageModel)
    {
        int rowCount = 0;
        
        try 
        {
            connect2DB();
            String insertString;
            Statement stmt = DBConn.createStatement();
            insertString = "INSERT INTO itkstu.images "
                + "(imageId, source) "
                + "VALUES ('" + imageModel.getImageId()
                + "', '" + imageModel.getSource()
                + "')";
            
            rowCount = stmt.executeUpdate(insertString);
            DBConn.close();
        } 
        catch (Exception e) 
        {
            System.err.println(e.getMessage());
        }
        return rowCount;
    }

    @Override
    public ArrayList selectImageByImageId(int targetImageId)
    {
        resultList = new ArrayList();
        String selectString = "SELECT * FROM itkstu.images "
            + "WHERE imageId = '" + targetImageId + "'";

        try
        {
            connect2DB();
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(selectString);

            while(rs.next())
            {
                imageId = rs.getInt("imageId");
                source = rs.getString("source");

                targetImage = new ImageBean(imageId, source);
                resultList.add(targetImage);
            }
            DBConn.close();
        }
        
        catch(Exception e)
        {
            System.err.println("ERROR: SELECT IMAGE BY IMAGEID FAILED.");
            System.err.println("TARGET: " + targetImageId);
            e.printStackTrace();
        }
        return resultList;
    }

}