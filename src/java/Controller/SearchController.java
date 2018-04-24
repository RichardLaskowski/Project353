
package Controller;

import DAO.SearchDAO;
import DAO.SearchDAOImpl;
import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;


/**
 *
 * @author ericz
 */
@ManagedBean
@SessionScoped
public class SearchController implements Serializable
{

    private String search;

    public String searchByName()
    {

        SearchDAO dao = new SearchDAOImpl();

        return "SearchResults.xhtml";
    }

    public String getSearch()
    {
        return search;
    }

    public void setSearch(String search)
    {
        this.search = search;
    }
}
