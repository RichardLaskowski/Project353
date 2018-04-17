package DAO;

import Model.UserBean;
import java.util.ArrayList;

public interface UserDAO 
{
    public int createUser(UserBean userModel);
    public ArrayList selectUserByUsername(String targetUsername);
    public ArrayList selectUserByUsertype(String targetUsertype); 
}
