/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Richa
 */
public class UserBean
{
    private String firstName;
    private ProfileBean userProfile;

    /**
     * @return the firstName
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * @return the userProfile
     */
    public ProfileBean getUserProfile()
    {
        return userProfile;
    }

    /**
     * @param userProfile the userProfile to set
     */
    public void setUserProfile(ProfileBean userProfile)
    {
        this.userProfile = userProfile;
    }
    
}
