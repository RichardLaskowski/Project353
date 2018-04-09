/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ProfileDAO;
import DAO.ProfileDAOImpl;
import Model.RecruiterBean;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author IT353S843
 */
@ManagedBean
@RequestScoped
public class RecruiterController {

    
    private RecruiterBean recruiterBean;
    
    /**
     * Creates a new instance of RecruiterController
     */
    public RecruiterController() {
        recruiterBean = new RecruiterBean();
    }

    /**
     * @return the recruiterBean
     */
    public RecruiterBean getRecruiterBean() {
        return recruiterBean;
    }

    /**
     * @param recruiterBean the recruiterBean to set
     */
    public void setRecruiterBean(RecruiterBean recruiterBean) {
        this.recruiterBean = recruiterBean;
    }  
    
    public String insertInfo(String UserId) {
            ProfileDAO aProfileDAO = new ProfileDAOImpl();    // Creating a new object each time.
            int status = aProfileDAO.insertRecruiterDetails(UserId, recruiterBean); // Doing anything with the object after this?
            if (status == 1) {
                return "LoginGood.xhtml"; // navigate to "LoginGood.xhtml"
            } else {
                return "recruiterDetails.xhtml";
            }
    }

}
