package DAO;

import java.util.ArrayList;
import Model.ProfileBean;

public interface ProfileDAO {
    
    public int createProfile(ProfileBean aProfile);
    public ProfileBean[] findAll();   
    public int checkCredentials(ProfileBean aProfile);

}
