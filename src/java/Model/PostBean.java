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
    private int postId;
    private int imageId;
    private int videoId;
    private String textContent;
    private String username;

    public PostBean(int postId, int imageId, int videoId, String textContent, String username)
    {
        this.postId = postId;
        this.imageId = imageId;
        this.videoId = videoId;
        this.textContent = textContent;
        this.username = username;
    }
    
     public PostBean(int imageId, int videoId, String textContent, String username)
    {
        this.imageId = imageId;
        this.videoId = videoId;
        this.textContent = textContent;
        this.username = username;
    }
     
    public PostBean(String textContent)
    {
        this.textContent = textContent;
    }
    
    public PostBean()
    {
        
    }

    /**
     * @return the pictureId
     */
    public int getImageId()
    {
        return imageId;
    }

    /**
     * @param pictureId the pictureId to set
     */
    public void setImageId(int imageId)
    {
        this.imageId = imageId;
    }

    /**
     * @return the videoId
     */
    public int getVideoId()
    {
        return videoId;
    }

    /**
     * @param videoId the videoId to set
     */
    public void setVideoId(int videoId)
    {
        this.videoId = videoId;
    }

    /**
     * @return the textContent
     */
    public String getTextContent()
    {
        return textContent;
    }

    /**
     * @param textContent the textContent to set
     */
    public void setTextContent(String textContent)
    {
        this.textContent = textContent;
    }

    /**
     * @return the username
     */
    public String getUsername()
    {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username)
    {
        this.username = username;
    }

    /**
     * @return the postId
     */
    public int getPostId()
    {
        return postId;
    }

    /**
     * @param postId the postId to set
     */
    public void setPostId(int postId)
    {
        this.postId = postId;
    }
    
}
