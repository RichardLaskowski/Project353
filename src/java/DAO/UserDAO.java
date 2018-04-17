/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.UserBean;
import java.util.ArrayList;

public interface UserDAO 
{
    public int createUser(UserBean userModel);
    public ArrayList selectUserByUsername(String targetUsername);
    public ArrayList selectUserByUsertype(String targetUsertype); 
}
