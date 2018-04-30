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
import javax.faces.context.FacesContext;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Richa
 */
@Named(value = "profileController")
@SessionScoped
public class ProfileController implements Serializable {

    private UserBean userModel;
    private PostController postController;
    private int imageId = 1;
    private int videoId = 1;

    public ProfileController() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        LoginController loginSession = (LoginController) session.getAttribute("loginController");
        userModel = loginSession.getTargetUser();
        postController = new PostController();

    }

    public void createPost() {
        postController.getPostModel().setUsername(userModel.getUsername());
        postController.getPostModel().setImageId(imageId);
        postController.getPostModel().setVideoId(videoId);
        postController.createPost();
        postController.selectAllPosts();
    }

    /**
     * @return the userModel
     */
    public UserBean getUserModel() {
        return userModel;
    }

    /**
     * @param userModel the userModel to set
     */
    public void setUserModel(UserBean userModel) {
        this.userModel = userModel;
    }

    /**
     * @return the postController
     */
    public PostController getPostController() {
        return postController;
    }

    /**
     * @param postController the postController to set
     */
    public void setPostController(PostController postController) {
        this.postController = postController;
    }

    /**
     * @return the imageId
     */
    public int getImageId() {
        return imageId;
    }

    /**
     * @param imageId the imageId to set
     */
    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    /**
     * @return the videoId
     */
    public int getVideoId() {
        return videoId;
    }

    /**
     * @param videoId the videoId to set
     */
    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public int getHeight() {
        
        //if(userModel.getUserType().)
        return userModel.getTargetStudent().getHeight();

    }

    public int getWeight() {

        return userModel.getTargetStudent().getWeight();
    }

    public String getCountry() {

        return userModel.getTargetStudent().getCountry();
    }

    public String getDOB() {

        return userModel.getTargetStudent().getDateOfBirth();
    }

    public String getSchool() {
        return userModel.getTargetStudent().getSchool();

    }

    public String getUserName() {

        return userModel.getTargetStudent().getUsername();

    }

    public int getEndYear() {

        return userModel.getTargetStudent().getEndYear();
    }
    public int getSAT(){
        
        return userModel.getTargetStudent().getSat();
    }
    public int getACT(){
        
        return userModel.getTargetStudent().getAct();
        
    }
    public int getPSAT(){
        
        return userModel.getTargetStudent().getPsat();
    }
    public String getCertifications(){
        
        return userModel.getTargetStudent().getCertification();
        
    }
    public String getHobbies(){
        return userModel.getTargetStudent().getHobbies();
        
    }
    public String getDepartment(){
  
        return userModel.getTargetRecruiter().getDepartment();
    } 
    public String getUniversity(){
        
        
        return userModel.getTargetRecruiter().getUniversity();
    }  
    public String getPhone(){
        
        return userModel.getTargetRecruiter().getPhone();
        
    }
    public String sendInfoEmail()
    {   
        String email = userModel.getEmail(); 
        String to = email;

        // Sender's email ID needs to be mentioned
        String from = "EMAIL ADDRESS";
        String password = "PASSWORD";

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
            message.setSubject("Request For More Info");
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
            String htmlText = "<center><H1>A recruiter from LinkedU has requested more info from you,"
                    + "<br/> please log on to LinkedU to contact the recruiter</H1></center>";
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
        
        return "profileStudentFriend.xhtml"; // navigate to "echo.xhtml"
    }

}
