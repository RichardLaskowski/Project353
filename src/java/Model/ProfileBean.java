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
public class ProfileBean
{

    private PostBean[] posts;
    private File profilePic;
    private File[] pictures;
    private File[] videos;

    ProfileBean()
    {

    }

    public PostBean[] getPosts()
    {
        return posts;
    }

    public void setPosts(PostBean[] posts)
    {
        this.posts = posts;

    }

    public File getProfilePic()
    {
        return profilePic;
    }

    public void setProfilePic(File profilePic)
    {
        this.profilePic = profilePic;
    }

    public File[] getPictures()
    {
        return pictures;
    }

    public void setPictures(File[] pictures)
    {
        this.pictures = pictures;
    }

    public File[] getVideos()
    {
        return videos;
    }

    public void setVideos(File[] videos)
    {
        this.videos = videos;
    }

    public void addPicture(File pic)
    {
        int i = this.pictures.length;
        this.pictures[i] = pic;
    }

    public void addVideo(File vid)
    {
        int i = this.videos.length;
        this.videos[i] = vid;
    }

    public File getPic(int i)
    {
        return this.pictures[i];
    }

    public File getVid(int i)
    {
        return this.videos[i];
    }

}
