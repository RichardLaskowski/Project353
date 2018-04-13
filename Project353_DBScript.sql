---------------------------------------------------------------------------------------------------

-- Break all table constraints.

---------------------------------------------------------------------------------------------------

ALTER TABLE users
    DROP CONSTRAINT users_profileId_fk;

ALTER TABLE profiles 
    DROP CONSTRAINT profiles_userName_fk;

ALTER TABLE hobbiesList
    DROP CONSTRAINT hobbiesList_hobbyId_fk;

ALTER TABLE hobbiesList
    DROP CONSTRAINT hobbieList_profileId_fk;

ALTER TABLE universityList
    DROP CONSTRAINT universityList_universityId_fk;

ALTER TABLE universityList
    DROP CONSTRAINT universityList_profileId_fk;

ALTER TABLE majorList
    DROP CONSTRAINT majorList_majorId_fk;

ALTER TABLE majorList
    DROP CONSTRAINT majorList_profileId_fk;

ALTER TABLE posts
    DROP CONSTRAINT posts_imageId_fk;

ALTER TABLE posts
    DROP CONSTRAINT posts_videoId_fk;

ALTER TABLE posts
    DROP CONSTRAINT posts_profileId_fk;

ALTER TABLE commentList
    DROP CONSTRAINT commentList_commentId_fk;

ALTER TABLE commentList
    DROP CONSTRAINT commentList_postId_fk;

---------------------------------------------------------------------------------------------------

-- If database has been established drop tables.

---------------------------------------------------------------------------------------------------

DROP TABLE users;
DROP TABLE profiles;
DROP TABLE hobbies;
DROP TABLE hobbiesList;
DROP TABLE university;
DROP TABLE universityList;
DROP TABLE major;
DROP TABLE majorList;
DROP TABLE posts;
DROP TABLE images;
DROP TABLE videos;
DROP TABLE comments;
DROP TABLE commentList;

---------------------------------------------------------------------------------------------------

--  Table Creation with CONSTRAINTS

---------------------------------------------------------------------------------------------------

CREATE TABLE users(
    userName VARCHAR(20),
    password VARCHAR(20) NOT NULL,
    firstName VARCHAR(20) NOT NULL,
    lastName VARCHAR(20) NOT NULL,
    email VARCHAR(30),
    securityQuestion VARCHAR(100),
    securityAnswer VARCHAR(100),
    userType VARCHAR(15) NOT NULL,
    profileId INTEGER,
    CONSTRAINT users_userName_pk PRIMARY KEY (userName));

CREATE TABLE profiles(
    profileId INTEGER,
    dateOfBirth VARCHAR(20),
    height INTEGER,
    weight INTEGER,
    address VARCHAR(500),
    country VARCHAR(20),
    zipcode VARCHAR(20),
    phone VARCHAR(13),
    school VARCHAR(20),
    endYear INTEGER,
    sat INTEGER,
    act INTEGER,
    psat INTEGER,
    certification VARCHAR(500),
    essay VARCHAR(1200),
    userName VARCHAR(20),
    CONSTRAINT profiles_profileId_pk PRIMARY KEY (profileId),
    CONSTRAINT profiles_userName_fk  FOREIGN KEY (userName)
        REFERENCES users(userName));

ALTER TABLE users
    ADD CONSTRAINT users_profileId_fk FOREIGN KEY (profileId)
        REFERENCES profiles(profileId);

CREATE TABLE hobbies (
    hobbyId INTEGER,
    hobbieName VARCHAR(20),
    hobbieDesc VARCHAR(20),
    CONSTRAINT hobbies_hobbieId_pk PRIMARY KEY (hobbyId));

CREATE TABLE hobbiesList (
    listId INTEGER,
    hobbyId INTEGER,
    profileId INTEGER,
    CONSTRAINT hobbiesList_listId_pk PRIMARY KEY (listId),
    CONSTRAINT hobbiesList_hobbyId_fk FOREIGN KEY (hobbyId)
        REFERENCES hobbies(hobbyId) ON DELETE CASCADE,
    CONSTRAINT hobbieList_profileId_fk FOREIGN KEY (profileId)
        REFERENCES profiles(profileId) ON DELETE CASCADE);

CREATE TABLE university(
    universityId INTEGER,
    universityName VARCHAR(20),
    CONSTRAINT university_universityId_pk PRIMARY KEY (universityId));

CREATE TABLE universityList(
    listId INTEGER,
    universityId INTEGER,
    profileId INTEGER,
    CONSTRAINT universityList_listId_pk PRIMARY KEY (listId),
    CONSTRAINT universityList_universityId_fk FOREIGN KEY (universityId)
        REFERENCES university(universityId) ON DELETE CASCADE,
    CONSTRAINT universityList_profileId_fk FOREIGN KEY (profileId)
        REFERENCES profiles(profileId) ON DELETE CASCADE);

CREATE TABLE major(
    majorId INTEGER,
    majorName VARCHAR(20),
    majorDesc VARCHAR(100),
    CONSTRAINT major_majorId_pk PRIMARY KEY (majorId));

CREATE TABLE majorList(
    listId INTEGER,
    majorId INTEGER,
    profileId INTEGER,
    CONSTRAINT majorList_listId_pk PRIMARY KEY (listId),
    CONSTRAINT majorList_majorId_fk FOREIGN KEY (majorId)
        REFERENCES major(majorId) ON DELETE CASCADE,
    CONSTRAINT majorList_profileId_fk FOREIGN KEY (profileId)
        REFERENCES profiles(profileId) ON DELETE CASCADE);

CREATE TABLE images(
    imageId INTEGER,
    source VARCHAR(50),
    CONSTRAINT images_imageId_pk PRIMARY KEY (imageId));
 
CREATE TABLE videos(
    videoId INTEGER,
    postId INTEGER,
    source VARCHAR(50),
    CONSTRAINT videos_videoId_pk PRIMARY KEY (videoId));

CREATE TABLE posts(
    postId INTEGER,
    profileId INTEGER,
    imageId INTEGER,
    videoId INTEGER,
    CONSTRAINT posts_postId_pk PRIMARY KEY (postId),
    CONSTRAINT posts_profileId_fk FOREIGN KEY (profileId)
        REFERENCES profiles(profileId) ON DELETE CASCADE,
    CONSTRAINT posts_imageId_fk FOREIGN KEY (imageId)
        REFERENCES images(imageId) ON DELETE CASCADE,
    CONSTRAINT posts_videoId_fk FOREIGN KEY (videoId)
        REFERENCES videos(videoId) ON DELETE CASCADE);

CREATE TABLE comments(
    commentId INTEGER,
    content VARCHAR(250),
    CONSTRAINT comments_commentId_pk PRIMARY KEY (commentId));

CREATE TABLE commentList(
    listId INTEGER,
    commentId INTEGER,
    postId INTEGER,
    CONSTRAINT commentList_listId_pk PRIMARY KEY (listId),
    CONSTRAINT commentList_commentId_fk FOREIGN KEY (commentId)
        REFERENCES comments(commentId) ON DELETE CASCADE,
    CONSTRAINT commentList_postId_fk FOREIGN KEY (postId)
        REFERENCES posts(postId) ON DELETE CASCADE);