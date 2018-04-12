/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ProfileBean;
import java.util.ArrayList;

/**
 *
 * @author Richa
 */
public interface ProfileDAO
{
    public int createProfile(ProfileBean profile);
    public ArrayList selectAllProfiles();
    public ArrayList selectByUsername();                                               
}
