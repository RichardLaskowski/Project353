/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.UserBean;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
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
 * @author Richa
 */
@Named(value = "passwordResetController")
@SessionScoped
public class PasswordResetController implements Serializable
{

    private UserController userController;
    private UserBean userModel;
    private UserBean targetUser;

    public PasswordResetController()
    {
        userController = new UserController();
        targetUser = new UserBean();
        userModel = new UserBean();
    }
    
    public String updateUser()
    {
        userController.updateUser(targetUser);    
        return "logIn.xhtml";
    }

    //Returns a UserBean. Saves into targetUser
    public String selectUserByUsername()
    {
        String returnString = "";
        userController.setUserModel(userModel);
        targetUser = userController.selectUserByUsername();

        if (targetUser.getUsername().equalsIgnoreCase(userModel.getUsername()))
        {
            returnString = sendResetEmail();
        } 
        else
        {
            //User not found logic.
            //Give user feedback that username is not registered.
            //After so many attempts to recover password, maybe give user option of signup. 
        }
        
        return returnString;
    }

    public String sendResetEmail()
    {   
        String email = targetUser.getEmail(); 
        String to = email;

        // Sender's email ID needs to be mentioned
        String from = "rllask1@ilstu.edu";
        String password = "Banditcleo12";

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
        Session session = Session.getInstance(properties, new javax.mail.Authenticator()
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(from, password);
            }
        });

        try
        {
            session.setDebug(true);
            Transport transport = session.getTransport();
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);
            message.setSubject("Reset Password");
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
            String htmlText = "<center><H1>Click the link to reset your password"
                    + "<br/> http://localhost:8080/Project353/resetPassword.xhtml</H1></center>";
            messageBodyPart.setContent(htmlText, "text/html");

            // add it
            multipart.addBodyPart(messageBodyPart);

            // second part (the image)
            messageBodyPart = new MimeBodyPart();
            DataSource fds = new FileDataSource("C:\\Users\\Richa\\Documents\\NetBeansProjects\\Project353\\web\\resources\\images\\book.jpg");
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
        } 
        
        catch (MessagingException mex)
        {
            mex.printStackTrace();
        }
        
        return "linkEmailed.xhtml"; // navigate to "echo.xhtml"
    }

    /**
     * @return the userController
     */
    public UserController getUserController()
    {
        return userController;
    }

    /**
     * @param userController the userController to set
     */
    public void setUserController(UserController userController)
    {
        this.userController = userController;
    }

    /**
     * @return the userModel
     */
    public UserBean getUserModel()
    {
        return userModel;
    }

    /**
     * @param userModel the userModel to set
     */
    public void setUserModel(UserBean userModel)
    {
        this.userModel = userModel;
    }

    /**
     * @return the targetUser
     */
    public UserBean getTargetUser()
    {
        return targetUser;
    }

    /**
     * @param targetUser the targetUser to set
     */
    public void setTargetUser(UserBean targetUser)
    {
        this.targetUser = targetUser;
    }

}
