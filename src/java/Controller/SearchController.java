package Controller;

import DAO.SearchDAO;
import DAO.SearchDAOImpl;
import Model.UserBean;
import java.util.List;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author ericz
 */
@Named(value = "searchController")
@SessionScoped
public class SearchController implements Serializable {

    private String search;
    private List<UserBean> results;
    UserBean user;

    public String searchByName() {
        String retVal;
        System.out.println("search by name");
        SearchDAO dao = new SearchDAOImpl();
        results = dao.SearchByName(search);
        if (results.size() == 1) {
            user = results.get(0);
            if (user.getFirstName().equalsIgnoreCase("University of Illinois Chicago")) {
                retVal = "uic.xhtml??faces-redirect=true";
            } else if (user.getFirstName().equalsIgnoreCase("Illinois State University")) {
                retVal = "isu.xhtml?faces-redirect=true";
            } else if (user.getFirstName().equalsIgnoreCase("University of Illinois Urbana Champaign")) {
                retVal = "uiuc.xhtml?faces-redirect=true";
            } else if (user.getFirstName().equalsIgnoreCase("Harvard")) {
                retVal = "harvard.xhtml?faces-redirect=true";
            } else if (user.getFirstName().equalsIgnoreCase("Princeton")) {
                retVal = "princeton.xhtml?faces-redirect=true";
            } else {
                retVal = "SearchResults.xhtml?faces-redirect=true";
            }
        } else {
            retVal = "SearchResults.xhtml?faces-redirect=true";
        }
        return retVal;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public List<UserBean> getResults() {
        return results;
    }
    
    public int getHeight() {
        
        //if(userModel.getUserType().)
        return user.getTargetStudent().getHeight();

    }

    public int getWeight() {

        return user.getTargetStudent().getWeight();
    }

    public String getCountry() {

        return user.getTargetStudent().getCountry();
    }

    public String getDOB() {

        int length=user.getTargetStudent().getDateOfBirth().length();
        return user.getTargetStudent().getDateOfBirth().substring(0, length-17);
    }

    public String getSchool() {
        return user.getTargetStudent().getSchool();

    }

    public String getUserName() {

        return user.getTargetStudent().getUsername();

    }

    public int getEndYear() {

        return user.getTargetStudent().getEndYear();
    }
    public int getSAT(){
        
        return user.getTargetStudent().getSat();
    }
    public int getACT(){
        
        return user.getTargetStudent().getAct();
        
    }
    public int getPSAT(){
        
        return user.getTargetStudent().getPsat();
    }
    public String getCertifications(){
        
        return user.getTargetStudent().getCertification();
        
    }
    public String getHobbies(){
        return user.getTargetStudent().getHobbies();
        
    }
    public String getDepartment(){
  
        return user.getTargetRecruiter().getDepartment();
    } 
    public String getUniversity(){
        
        
        return user.getTargetRecruiter().getUniversity();
    }  
    public String getPhone(){
        
        return user.getTargetRecruiter().getPhone();
        
    }
    
}
