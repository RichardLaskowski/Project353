package Controller;

import DAO.SearchDAO;
import DAO.SearchDAOImpl;
import Model.UserBean;
import java.io.Serializable;
import java.util.List;
import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author ericz
 */
@Named(value= "searchController")
@ManagedBean
@SessionScoped
public class SearchController implements Serializable{


    private String search;
    private List<UserBean> results;

    public String searchByName() {
        System.out.println("search by name");
        SearchDAO dao = new SearchDAOImpl();
        results = dao.SearchByName(search);
        return "SearchResults.xhtml";
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
