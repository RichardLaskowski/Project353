/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.SearchDAO;
import DAO.SearchDAOImpl;
import Model.ProfileBean;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;



/**
 *
 * @author ericz
 */
@ManagedBean
@SessionScoped
public class SearchController {
    private String search;
    private List<ProfileBean> results;
    
    
    public String searchByName(){
        List<ProfileBean> retVal;
        SearchDAO dao= new SearchDAOImpl();
        results= dao.SearchByName(search);
        return "SearchResults.xhtml";
    }   

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public List<ProfileBean> getResults() {
        return results;
    }

    public void setResults(List<ProfileBean> results) {
        this.results = results;
    }
    
    
    
}

    
