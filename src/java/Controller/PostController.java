/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.PostDAO;
import DAO.PostDAOImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Richa
 */
@Named(value = "postController")
@SessionScoped
public class PostController implements Serializable
{
    public void createPost()
    {
        PostDAO postDAO = new PostDAOImpl();
        postDAO.createPost();
    }

    public ArrayList selectAllPosts()
    {
        PostDAO postDAO = new PostDAOImpl();
        return postDAO.selectAllPosts();
    }
    
    public PostController()
    {
    }
    
}
