package DAO;

import Model.ImageBean;
import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

public class ImageDAOImpl implements ImageDAO
{

    private ArrayList resultList;
    private Connection DBConn = null;
    private String myDB = "jdbc:derby://localhost:1527/Project353";
    private String driver = "org.apache.derby.jdbc.ClientDriver";
    private ImageBean targetImage;
    private long imageId;
    private String source;

    public void connect2DB() {
        DBHelper.loadDriver(driver);
        DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");
    }

    @Override
    public StreamedContent getImage() {
        StreamedContent image= null;
        try {
            connect2DB();
            String insert = "SELECT IMAGE FROM IMAGES WHERE IMAGEID= 3";
            System.out.println(insert);
            PreparedStatement stmt = DBConn.prepareStatement(insert);
//            stmt.setBinaryStream(1, file.getInputstream());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
               image= new DefaultStreamedContent(new ByteArrayInputStream(rs.getBytes(1)));
            }
            DBConn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return image;

    }

    @Override
    public long createImage(UploadedFile file, String username) {
        int rowCount = 0;
        long imgID = -1;
        try {
            connect2DB();
            String type = file.getFileName().substring(file.getFileName().indexOf("."));
            String insert = "INSERT INTO IMAGES VALUES (default, ?, '" + username + "')";
            System.out.println(insert);
            PreparedStatement stmt = DBConn.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            stmt.setBinaryStream(1, file.getInputstream());
            rowCount = stmt.executeUpdate();
            if (rowCount == 1) {
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    imgID = rs.getLong(1);
                }
                System.out.println(imgID);
            }
//            insertString = "INSERT INTO itkstu.images "
//                + "(imageId, source) "
//                + "VALUES ('" + imageModel.getImageId()
//                + "', '" + imageModel.getSource()
//                + "')";

            DBConn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return imgID;
    }

    @Override
    public ArrayList selectImageByImageId(int targetImageId) {
        resultList = new ArrayList();
        String selectString = "SELECT * FROM itkstu.images "
                + "WHERE imageId = '" + targetImageId + "'";

        try {
            connect2DB();
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(selectString);

            while (rs.next()) {
                imageId = rs.getInt("imageId");
                source = rs.getString("source");

                // targetImage = new ImageBean(imageId, source);
                resultList.add(targetImage);
            }
            DBConn.close();
        } catch (Exception e) {
            System.err.println("ERROR: SELECT IMAGE BY IMAGEID FAILED.");
            System.err.println("TARGET: " + targetImageId);
            e.printStackTrace();
        }
        return resultList;
    }

}
