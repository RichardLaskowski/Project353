package DAO;

import java.util.ArrayList;
import Model.ProfileBean;
import Model.RecruiterBean;
import Model.StudentBean;

public interface ProfileDAO {
    
    public int createProfile(ProfileBean aProfile);
    public ProfileBean[] findAll();   
    public int checkCredentials(ProfileBean aProfile);
    public int insertStudentDetails(String UserId, StudentBean astudent);
    public int insertRecruiterDetails(String UserId, RecruiterBean recruiterBean);
}
