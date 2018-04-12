DROP TABLE user CASCADE CONSTRAINTS;
DROP TABLE profile CASCADE CONSTRAINTS;
DROP TABLE post CASCADE CONSTRAINTS;
DROP TABLE images CASCADE CONSTRAINTS;
DROP TABLE videos CASCADE CONSTRAINTS;

CREATE TABLE user(
    userName VARCHAR(20),
    password VARCHAR(20) NOT NULL,
    firstName VARCHAR(20) NOT NULL,
    lastName VARCHAR(20) NOT NULL,
    userType VARCHAR(15) NOT NULL,
    profileId NUMBER(5,0) NOT NULL,
    CONSTRAINTS user_userName_pk PRIMARY KEY (userName),
    CONSTRAINTS user_profileId_fk FOREIGN KEY (profileId)
        REFERENCES profile(profileId));

CREATE TABLE profile(
    profileId NUMBER(5,0),
    userName VARCHAR(20),
    postId NUMBER(5,0),
    CONSTRAINT profile_profileId_pk PRIMARY KEY (profileId),
    CONSTRAINT profile_userName_fk  FOREIGN KEY (userName)
        REFERENCES user(userName),
    CONSTRAINT profile_postId_fk FOREIGN KEY (postId)
        REFERENCES post(postId));

CREATE TABLE post(
    postId NUMBER(5,0),
    imageId NUMBER(5,0),
    videoId NUMBER(5,0),
    CONSTRAINT post_postId_pk PRIMARY KEY (postId),
    CONSTRAINT post_imageId_fk FOREIGN KEY (imageId)
        REFERENCES images(imageId),
    CONSTRAINT post_videoId_fk FOREIGN KEY (videoId)
        REFERENCES videos(videoId));

CREATE TABLE images(
    imageId NUMBER(5,0),
    postId NUMBER(5,0),
    source VARCHAR(50),
    CONSTRAINT images_imageId_pk PRIMARY KEY (imageId),
    CONSTRAINT images_postId_fk FOREIGN KEY (postId)
        REFERENCES post(postId));

CREATE TABLE videos(
    videoId NUMBER(5,0),
    postId NUMBER(5,0),
    source VARCHAR(50),
    CONSTRAINT videos_videoId_pk PRIMARY KEY (videoId),
    CONSTRAINT videos_postId_fk FOREIGN KEY (postId)
        REFERENCES post(postId));