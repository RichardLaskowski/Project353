/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.File;

/**
 *
 * @author ericz
 */
public class PostBean
{

    private File picture;
    private File video;
    private String story;
    private String firstName;

    public PostBean()
    {
        
    }
    public PostBean(File pic)
    {
        this.setPicture(pic);
    }

    public PostBean(File vid, String st)
    {
        this.setVideo(vid);
        this.setStory(st);
    }

    public PostBean(String st)
    {
        this.setStory(st);
    }

    public File getPicture()
    {
        return picture;
    }

    public void setPicture(File picture)
    {
        this.picture = picture;
    }

    public File getVideo()
    {
        return video;
    }

    public void setVideo(File video)
    {
        this.video = video;
    }

    public String getStory()
    {
        return story;
    }

    public void setStory(String story)
    {
        this.story = story;
    }

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

}
