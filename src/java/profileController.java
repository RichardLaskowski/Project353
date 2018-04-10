/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Model.Post;
import Model.UserBean;
import static com.sun.faces.facelets.util.Path.context;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

/**
 *
 * @author Richa
 */
@Named(value = "profileController")
@RequestScoped
public class profileController
{
    private UserBean userModel;
    FacesContext context;
    ResponseWriter writer = context.getResponseWriter();
    
    public profileController()
    {
        
    }
    
    public void populatePost()
    {
        
    }
    
}
