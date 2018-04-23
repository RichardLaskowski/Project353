
package Controller;

import DAO.ProfileDAOImpl;
import DAO.ProfileDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import Model.ProfileBean;
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

@ManagedBean
@SessionScoped
public class ProfileController {

    // This corresponds to the response to be sent back to the client
    
    private ProfileBean theModel;
    private String resultStr = "";
    private String signupStatus;
    private String signupStatus1;

    /**
     * Creates a new instance of ProfileController
     */
    public ProfileController() {
        theModel = new ProfileBean();
    }

    public ProfileBean getTheModel() {
        return theModel;
    }

    public void setTheModel(ProfileBean theModel) {
        this.theModel = theModel;
    }


    public String createProfile() {
        ProfileDAO aProfileDAO = new ProfileDAOImpl();    // Creating a new object each time.
            int status = aProfileDAO.createProfile(theModel); // Doing anything with the object after this?
            if (status == 1 ){
                if(theModel.getUserType().equalsIgnoreCase("Student")) {
                return "details.xhtml"; // navigate to "details.xhtml"
                }
                else{
                    return "recruiterDetails.xhtml";
                }
            }
                else {
                signupStatus = "UserId already exist!";
                return "";
            }
    }

    
    public String forgotPassword(String UserID) {
        ProfileDAO aProfileDAO = new ProfileDAOImpl();    // Creating a new object each time.   
        String email = aProfileDAO.passwordUpdate(UserID); // Doing anything with the object after this?
            signupStatus1 = "";
                String to = email;

                // Sender's email ID needs to be mentioned
                String from = "emailId";

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
                        return new PasswordAuthentication("emailId", "password");
                    }
                });

                try {
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
                            + "<br/> http://localhost:8080/Project353/faces/resetPassword.xhtml</H1></center>";
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
                } catch (MessagingException mex) {
                    mex.printStackTrace();
                }
                return "linkEmailed.xhtml"; // navigate to "echo.xhtml"
                }
    /**
     * @return the signupStatus
     */
    public String getSignupStatus() {
        return signupStatus;
    }

    /**
     * @param signupStatus the signupStatus to set
     */
    public void setSignupStatus(String signupStatus) {
        this.signupStatus = signupStatus;
    }

    /**
     * @return the signupStatus1
     */
    public String getSignupStatus1() {
        return signupStatus1;
    }

    /**
     * @param signupStatus1 the signupStatus1 to set
     */
    public void setSignupStatus1(String signupStatus1) {
        this.signupStatus1 = signupStatus1;
    }
    
    public String resetPassword(String UserID) {
        ProfileDAO aProfileDAO = new ProfileDAOImpl();    // Creating a new object each time.   
        int status = aProfileDAO.newpasswordUpdate(UserID, theModel.getPassword()); // Doing anything with the object after this?
    if(status == 1)
        return "logIn.xhtml";
    else
        return "resetPassword.xhtml";
    }
}
