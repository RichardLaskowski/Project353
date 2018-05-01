/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.UniversityNameBean;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author IT353S843
 */
public class ShowcaseUniversityDAOImpl implements ShowcaseUniversityDAO {

    private ArrayList resultList;
    private Connection DBConn = null;
    private String myDB = "jdbc:derby://localhost:1527/Project353";
    private String driver = "org.apache.derby.jdbc.ClientDriver";

    public void connect2DB() {
        DBHelper.loadDriver(driver);
        DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");
    }

    @Override
    public ArrayList<String> GetShowCaseUniversities() {
        resultList = new ArrayList();
        String selectString = "SELECT * FROM itkstu.ShowCaseUniversity "
                + "WHERE isshowcase = '1'";

        try {
            connect2DB();
            String image = "";
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(selectString);
            while (rs.next()) {
                // universityName = rs.getString("UNIVERSITYNAME");
                image = rs.getString("IMAGENAME");
                resultList.add(image);
            }
            stmt.close();
            rs.close();
            DBConn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return resultList;
    }

    @Override
    public int updateUniversityShowcase(String universityName) {
        int rowCount = 0;
        String query = "UPDATE itkstu.SHOWCASEUNIVERSITY"
                + " SET ISSHOWCASE = '1'"
                + " WHERE UNIVERSITYNAME = '" + universityName + "'";
        try {
            connect2DB();
            Statement stmt = DBConn.createStatement();
            rowCount = stmt.executeUpdate(query);
            DBConn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rowCount;
    }

    @Override
    public int updateUniversityUnShowcase(String universityName) {
        int rowCount = 0;
        String query = "UPDATE itkstu.SHOWCASEUNIVERSITY"
                + " SET ISSHOWCASE = '0'"
                + " WHERE UNIVERSITYNAME = '" + universityName + "'";
        try {
            connect2DB();
            Statement stmt = DBConn.createStatement();
            rowCount = stmt.executeUpdate(query);
            DBConn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rowCount;
    }

    @Override
    public int adminEmail(String text) {
        int rowCount = 0;
        String query = "SELECT EMAIL FROM ITKSTU.USERS WHERE EMAILSUBSCRIPTION = '1'";
        try {
            connect2DB();
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {

                String to = rs.getString("EMAIL");

                // Sender's email ID needs to be mentioned
                String from = "email address";
                String password = "password";

                // Assuming you are sending email from this host
                String host = "outlook.office365.com";

                // Get system properties
                Properties properties = System.getProperties();

                // Setup mail server
                properties.setProperty("mail.smtp.host", host);
                properties.setProperty("mail.smtp.starttls.enable", "true");
                properties.setProperty("mail.smtp.auth", "true");
                properties.setProperty("mail.smtp.port", "587");

                // Get the default Session object.
                Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from, password);
                    }
                });

                try {
                    session.setDebug(true);
                    Transport transport = session.getTransport();
                    // Create a default MimeMessage object.
                    MimeMessage message = new MimeMessage(session);
                    message.setSubject("NewsLetter from LinkedU");
                    // Set From: header field of the header.
                    message.setFrom(new InternetAddress(from));

                    // Set To: header field of the header.
                    message.addRecipient(Message.RecipientType.TO,
                            new InternetAddress(to));

            // This HTML mail have to 2 part, the BODY and the embedded image
                    //
                    MimeMultipart multipart = new MimeMultipart("related");

                    // first part  (the html)
                    BodyPart messageBodyPart = new MimeBodyPart();
                    String htmlText = "<center><H1>"+text+"</H1></center>";
                    messageBodyPart.setContent(htmlText, "text/html");

                    // add it
                    multipart.addBodyPart(messageBodyPart);

                    // second part (the image)
                    messageBodyPart = new MimeBodyPart();
                    DataSource fds = new FileDataSource("I:\\GitHub\\Project353\\web\\resources\\images\\book.jpg");
                    messageBodyPart.setDataHandler(new DataHandler(fds));
                    messageBodyPart.setHeader("Content-ID", "<image>");

                    // add it
                    multipart.addBodyPart(messageBodyPart);

                    // put everything together
                    message.setContent(multipart);

                    transport.connect();
                    transport.sendMessage(message,
                            message.getRecipients(Message.RecipientType.TO));
                    transport.close();

                    System.out.println("Sent message successfully....");
                    rowCount+=rowCount;
                } catch (MessagingException mex) {
                    mex.printStackTrace();
                    System.out.println(mex);
                }
            }
            DBConn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rowCount;
    }

}
