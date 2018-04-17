
package Controller;

import DAO.SearchDAO;
import DAO.SearchDAOImpl;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author ericz
 */
@ManagedBean
@SessionScoped
public class SearchController
{

    private String search;

    public String searchByName()
    {

        //SearchDAO dao = new SearchDAOImpl();

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
