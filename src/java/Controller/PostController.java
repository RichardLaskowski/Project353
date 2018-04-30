/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.PostDAO;
import DAO.PostDAOImpl;
import Model.PostBean;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Richa
 */
@Named(value = "postController")
@SessionScoped
public class PostController implements Serializable
{
    private PostBean postModel;
    
    public void createPost()
    {
        PostDAO postDAO = new PostDAOImpl();
        postDAO.createPost(postModel);
    }

    public ArrayList selectAllPosts()
    {
        PostDAO postDAO = new PostDAOImpl();
        return postDAO.selectAllPosts();
    }
    
    public PostController()
    {
        postModel = new PostBean();
    }

    /**
     * @return the postModel
     */
    public PostBean getPostModel()
    {
        return postModel;
    }

    /**
     * @param postModel the postModel to set
     */
    public void setPostModel(PostBean postModel)
    {
        this.postModel = postModel;
    }
    
}
