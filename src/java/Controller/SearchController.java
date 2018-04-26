package Controller;

import DAO.SearchDAO;
import DAO.SearchDAOImpl;
import Model.UserBean;
import java.util.List;
import java.io.Serializable;
import javax.annotation.ManagedBean;
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

    public String searchByName() {
        String retVal;
        System.out.println("search by name");
        SearchDAO dao = new SearchDAOImpl();
        results = dao.SearchByName(search);
        if (results.size() == 1) {
            UserBean user = results.get(0);
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
}
