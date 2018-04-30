/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ImageDAO;
import DAO.ImageDAOImpl;
import Model.UserBean;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author ericz
 */
 @ManagedBean
 @Named(value="mediaController")
 @ApplicationScoped
public class MediaController implements Serializable {
   
    private UploadedFile file;
    private UserBean currentUser;
    public UploadedFile getFile() {
        return file;
    }
 
    public void setFile(UploadedFile file) {
        this.file = file;
    }
     
    public void upload() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        LoginController loginSession = (LoginController)session.getAttribute("loginController");
        UserBean user = loginSession.getTargetUser();
        System.out.println(user.getUsername());
        if(file != null) {
            ImageDAO dao= new ImageDAOImpl();
            System.out.println(user.getUsername());
            dao.createImage(file, user.getUsername() );
            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    
    public StreamedContent getImage() {
        FacesContext context = FacesContext.getCurrentInstance();

        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            // So, we're rendering the HTML. Return a stub StreamedContent so that it will generate right URL.
            return new DefaultStreamedContent();
        }
        else {
            // So, browser is requesting the image. Return a real StreamedContent with the image bytes.
           // String studentId = context.getExternalContext().getRequestParameterMap().get("studentId");
           ImageDAO dao= new ImageDAOImpl();
           
            return dao.getImage();
        }
    }
    

    public UserBean getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(UserBean currentUser) {
        this.currentUser = currentUser;
    }
    
    
}

