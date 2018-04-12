DROP TABLE users CASCADE CONSTRAINTS;
DROP TABLE profiles CASCADE CONSTRAINTS;
DROP TABLE posts CASCADE CONSTRAINTS;
DROP TABLE images CASCADE CONSTRAINTS;
DROP TABLE videos CASCADE CONSTRAINTS;

CREATE TABLE users(
    userName VARCHAR(20),
    password VARCHAR(20) NOT NULL,
    firstName VARCHAR(20) NOT NULL,
    lastName VARCHAR(20) NOT NULL,
    email VARCHAR(30),
    securityQuestion VARCHAR(100),
    securityAnswer VARCHAR(100),
    userType VARCHAR(15) NOT NULL,
    profileId NUMBER(5,0),
    CONSTRAINT users_userName_pk PRIMARY KEY (userName),
    CONSTRAINT users_profileId_fk FOREIGN KEY (profileId)
        REFERENCES profiles(profileId));

CREATE TABLE profiles(
    profileId NUMBER(5,0),
    dateOfBirth VARCHAR(20),
    height NUMBER(3,0),
    weight NUMBER(3,0),
    address VARCHAR(500),
    country VARCHAR(20),
    zipcode VARCHAR(20),
    phone VARCHAR(13),
    school VARCHAR(20),
    endYear NUMBER(4,0),
    sat NUMBER(4,0),
    act NUMBER(2,0),
    psat NUMBER(4,0),
    certification VARCHAR(500),
    essay VARCHAR(1200),
    userName VARCHAR(20),
    CONSTRAINT profiles_profileId_pk PRIMARY KEY (profileId),
    CONSTRAINT profiles_userName_fk  FOREIGN KEY (userName)
        REFERENCES users(userName));

CREATE TABLE hobbies (
    hobbieId NUMBER(2,0),
    hobbieName VARCHAR(20),
    hobbieDesc VARCHAR(20),
    CONSTRAINT hobbies_hobbieId_pk PRIMARY KEY (hobbieId));

CREATE TABLE hobbiesList (
    listId NUMBER(5,0),
    hobbieId NUMBER(2,0),
    profileId NUMBER(5,0),
    CONSTRAINT hobbiesList_listId_pk PRIMARY KEY (listId),
    CONSTRAINT hobbiesList_hobbieId_fk FOREIGN KEY (hobbieId)
        REFERENCES hobbies(hobbieId),
    CONSTRAINT hobbieList_profileId_fk FOREIGN KEY (profileId)
        REFERENCES profiles(profileId));

CREATE TABLE university(
    universityId NUMBER(5,0),
    universityName VARCHAR(20),
    userName VARCHAR(20),
    CONSTRAINT university_universityId_pk PRIMARY KEY (universityId),
    CONSTRAINT university_userName_fk FOREIGN KEY (userName)
        REFERENCES users(userName));

CREATE TABLE universityList(
    listId NUMBER(5,0),
    univeristyId NUMBER(5,0),
    profileId NUMBER(5,0),
    CONSTRAINT universityList_listId_pk PRIMARY KEY (listId),
    CONSTRAINT universityList_universityId_fk FOREIGN KEY (universityId)
        REFERENCES university(universityId),
    CONSTRAINT universityList_profileId_fk FOREIGN KEY (profileId)
        REFERENCES profiles(profileId));

CREATE TABLE major(
    majorId NUMBER(5,0),
    majorName VARCHAR(20),
    majorDesc VARCHAR(100),
    CONSTRAINT major_majorId_pk PRIMARY KEY (majorId),
)

CREATE TABLE majorList(
    listId NUMBER(5,0),
    majorId NUMBER(5,0),
    profileId NUMBER(5,0),
    CONSTRAINT majorList_listId_pk PRIMARY KEY (listId),
    CONSTRAINT majorList_majorId_fk FOREIGN KEY (majorId)
        REFERENCES major(majorId),
    CONSTRAINT majorList_profileId_fk FOREIGN KEY (profileId)
        REFERENCES profiles(profileId));

CREATE TABLE posts(
    postId NUMBER(5,0),
    profileId NUMBER(5,0),
    imageId NUMBER(5,0),
    videoId NUMBER(5,0),
    CONSTRAINT posts_postId_pk PRIMARY KEY (postId),
    CONSTRAINT posts_profileId_fk FOREIGN KEY (profileId)
        REFERENCES profiles(profileId),
    CONSTRAINT posts_imageId_fk FOREIGN KEY (imageId)
        REFERENCES images(imageId),
    CONSTRAINT posts_videoId_fk FOREIGN KEY (videoId)
        REFERENCES videos(videoId));

CREATE TABLE images(
    imageId NUMBER(5,0),
    postId NUMBER(5,0),
    source VARCHAR(50),
    CONSTRAINT images_imageId_pk PRIMARY KEY (imageId),
    CONSTRAINT images_postId_fk FOREIGN KEY (postId)
        REFERENCES posts(postId));

CREATE TABLE videos(
    videoId NUMBER(5,0),
    postId NUMBER(5,0),
    source VARCHAR(50),
    CONSTRAINT videos_videoId_pk PRIMARY KEY (videoId),
    CONSTRAINT videos_postId_fk FOREIGN KEY (postId)
        REFERENCES posts(postId));
