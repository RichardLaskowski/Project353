/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.UniversityNameBean;
import java.util.ArrayList;

/**
 *
 * @author IT353S843
 */
public interface ShowcaseUniversityDAO {
    
    public ArrayList<String> GetShowCaseUniversities();
    public int updateUniversityUnShowcase(String universityName);
    public int updateUniversityShowcase(String universityName);
}
