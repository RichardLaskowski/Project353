/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ProfileBean;
import java.util.List;

/**
 *
 * @author ericz
 */
public interface SearchDAO {
    public List SearchByName(String name);
    
}