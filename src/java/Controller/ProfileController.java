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
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Richa
 */
@Named(value = "profileController")
@SessionScoped
public class ProfileController implements Serializable
{
    private UserBean userToReturn;
    private UserBean userModel;
    private PostController postController;
    private int imageId = 1;
    private int videoId = 1;
    
    public ProfileController()
    {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        LoginController loginSession = (LoginController)session.getAttribute("loginController");
        userModel = loginSession.getTargetUser();
        postController = new PostController();
       
    }
    
    public void createPost()
    {
        postController.getPostModel().setUsername(userModel.getUsername());
        postController.getPostModel().setImageId(imageId);
        postController.getPostModel().setVideoId(videoId);
        postController.createPost();
        postController.selectAllPosts();
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
     * @return the postController
     */
    public PostController getPostController()
    {
        return postController;
    }

    /**
     * @param postController the postController to set
     */
    public void setPostController(PostController postController)
    {
        this.postController = postController;
    }

    /**
     * @return the imageId
     */
    public int getImageId()
    {
        return imageId;
    }

    /**
     * @param imageId the imageId to set
     */
    public void setImageId(int imageId)
    {
        this.imageId = imageId;
    }

    /**
     * @return the videoId
     */
    public int getVideoId()
    {
        return videoId;
    }

    /**
     * @param videoId the videoId to set
     */
    public void setVideoId(int videoId)
    {
        this.videoId = videoId;
    }
    
    public String profilePage(){
        
        
        return "profile_1.xhtml";
    }
    
}
