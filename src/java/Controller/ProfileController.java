/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.UserBean;
import Model.StudentBean;
import javax.inject.Named;
import java.io.Serializable;
import javax.faces.bean.SessionScoped;
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
    private UserController userController;
    private PostController postController;
    private CommentController commentController;
    private int imageId = 1;
    private int videoId = 1;

    public ProfileController() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        LoginController loginSession = (LoginController) session.getAttribute("loginController");
        userModel = loginSession.getTargetUser();
        postController = new PostController();
<<<<<<< HEAD
        commentController = new CommentController();
        userController = new UserController();
       
=======

>>>>>>> master
    }

    public void createPost() {
        postController.getPostModel().setUsername(userModel.getUsername());
        postController.getPostModel().setImageId(imageId);
        postController.getPostModel().setVideoId(videoId);
        postController.createPost();
        postController.getPostModel().setTextContent("");
        StudentBean studentModel = (StudentBean)userModel.getProfile();
        studentModel.setPost(getPosts());
        userModel.setTargetStudent(studentModel);
    }
    
    public void createComment(int postId)
    {
        System.out.println(postId);
        commentController.getCommentModel().setPostId(postId);
        commentController.createComment();
        commentController.getCommentModel().setContent("");
        userController.setUserModel(userModel);
        userModel = userController.selectUserByUsername();
        
    }

    public ArrayList getPosts()
    {
        return postController.selectPostsByUsername(userModel.getUsername());
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

    /**
     * @return the commentController
     */
    public CommentController getCommentController()
    {
        return commentController;
    }

    /**
     * @param commentController the commentController to set
     */
    public void setCommentController(CommentController commentController)
    {
        this.commentController = commentController;
    }
    

    public String profilePage(){


        return "profile_1.xhtml";
    }


}
