---------------------------------------------------------------------------------------------------

-- Break all table constraints.

---------------------------------------------------------------------------------------------------

ALTER TABLE student 
    DROP CONSTRAINT student_username_fk;

ALTER TABLE recruiter 
    DROP CONSTRAINT recruiter_university_fk;

ALTER TABLE recruiter 
    DROP CONSTRAINT recruiter_username_fk;

ALTER TABLE universityBridge
    DROP CONSTRAINT universityBridge_profileId_fk;

ALTER TABLE universityBridge
    DROP CONSTRAINT universityBridge_username_fk;

ALTER TABLE majorBridge
    DROP CONSTRAINT majorList_major_fk;

ALTER TABLE majorBridge
    DROP CONSTRAINT majorList_username_fk;

ALTER TABLE posts
    DROP CONSTRAINT posts_imageId_fk;

ALTER TABLE posts
    DROP CONSTRAINT posts_videoId_fk;

ALTER TABLE posts
    DROP CONSTRAINT posts_username_fk;

ALTER TABLE commentList
    DROP CONSTRAINT commentList_commentId_fk;

ALTER TABLE commentList
    DROP CONSTRAINT commentList_postId_fk;

ALTER TABLE images
    DROP CONSTRAINT USERNAME_FK;

---------------------------------------------------------------------------------------------------

-- If database has been established drop tables.

---------------------------------------------------------------------------------------------------

DROP TABLE users;
DROP TABLE profiles;
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
    userName VARCHAR(100),
    password VARCHAR(100) NOT NULL,
    firstName VARCHAR(100) NOT NULL,
    lastName VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    securityQuestion VARCHAR(100),
    securityAnswer VARCHAR(100),
    userType VARCHAR(15) NOT NULL,
    CONSTRAINT users_userName_pk PRIMARY KEY (userName));

ALTER TABLE USERS
    ADD COLUMN PROFILEPICTUREID INTEGER;
ALTER TABLE USERS
    ADD CONSTRAINT profile_pic FOREIGN KEY (PROFILEPICTUREID)
        REFERENCES IMAGES(IMAGEID);
ALTER TABLE USERS
    ALTER COLUMN PASSWORD SET DATA TYPE VARCHAR(100);

ALTER TABLE USERS
    ALTER COLUMN USERNAME SET DATA TYPE VARCHAR(100);

CREATE TABLE student(
    profileId INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
    dateOfBirth VARCHAR(100),
    height VARCHAR(4),
    weight VARCHAR(4),
    address VARCHAR(500),
    country VARCHAR(100),
    zipcode VARCHAR(20),
    phone VARCHAR(13),
    school VARCHAR(100),
    endYear VARCHAR(4),
    sat VARCHAR(4),
    act VARCHAR(4),
    psat VARCHAR(4),
    certification VARCHAR(500),
    essay VARCHAR(1200),
    userName VARCHAR(100),
    hobbies VARCHAR(500),
    CONSTRAINT student_profileId_pk PRIMARY KEY (profileId),
    CONSTRAINT student_username_fk  FOREIGN KEY (userName)
        REFERENCES users(username));

CREATE TABLE university(
    profileId VARCHAR(100),
    universityEmail VARCHAR(100),
    username VARCHAR(100),
    CONSTRAINT university_profileId_pk PRIMARY KEY (profileId),
    CONSTRAINT university_username_fk FOREIGN KEY (username)
        REFERENCES users(username));

CREATE TABLE universityBridge(
    bridgeId INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    profileId VARCHAR(100),
    username VARCHAR(100),
    CONSTRAINT universityBridge_bridgeId_pk PRIMARY KEY (bridgeId),
    CONSTRAINT universityBridge_profileId_fk FOREIGN KEY (profileId)
        REFERENCES university(profileId),
    CONSTRAINT universityBridge_username_fk FOREIGN KEY (username)
        REFERENCES users(username));

CREATE TABLE recruiter(
    profileId INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
    university VARCHAR(100),
    username VARCHAR(100),
    department VARCHAR(100),
    phone VARCHAR(13),
    CONSTRAINT recruiter_profileId_pk PRIMARY KEY (profileId),
    CONSTRAINT recruiter_username_fk FOREIGN KEY (username)
        REFERENCES users(username),
    CONSTRAINT recruiter_university_fk FOREIGN KEY (university)
        REFERENCES university(profileId));

-- CREATE TABLE hobbies (
--     hobbyId INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
--     hobbieName VARCHAR(20),
--     hobbieDesc VARCHAR(20),
--     CONSTRAINT hobbies_hobbieId_pk PRIMARY KEY (hobbyId));

-- CREATE TABLE hobbiesList (
--     listId INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
--     hobbyId INTEGER,
--     profileId INTEGER,
--     CONSTRAINT hobbiesList_listId_pk PRIMARY KEY (listId),
--     CONSTRAINT hobbiesList_hobbyId_fk FOREIGN KEY (hobbyId)
--         REFERENCES hobbies(hobbyId) ON DELETE CASCADE,
--     CONSTRAINT hobbieList_profileId_fk FOREIGN KEY (profileId)
--         REFERENCES profiles(profileId) ON DELETE CASCADE);


CREATE TABLE major(
    major VARCHAR(100),
    majorDesc VARCHAR(100),
    CONSTRAINT major_major_pk PRIMARY KEY (major));

CREATE TABLE majorBridge(
    bridgeId INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    major VARCHAR(100),
    username VARCHAR(100),
    CONSTRAINT majorList_bridgeId_pk PRIMARY KEY (bridgeId),
    CONSTRAINT majorList_major_fk FOREIGN KEY (major)
        REFERENCES major(major),
    CONSTRAINT majorList_username_fk FOREIGN KEY (username)
        REFERENCES users(username));

SELECT * FROM IMAGES;
CREATE TABLE IMAGES(
    IMAGEID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    IMAGE BLOB,
    USERNAME VARCHAR(100),
    DATESTIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT images_imageId_pk PRIMARY KEY (IMAGEID),
    CONSTRAINT IMAGES_USERNAME_FK FOREIGN KEY (USERNAME)
        REFERENCES USERS(USERNAME)); 

ALTER TABLE IMAGES ADD COLUMN IMAGE BLOB;
ALTER TABLE IMAGES ADD COLUMN USERNAME VARCHAR(100);
ALTER TABLE IMAGES ADD CONSTRAINT IMAGES_USERNAME_FK FOREIGN KEY (USERNAME) REFERENCES USERS (username);
ALTER TABLE IMAGES DROP SOURCE;

CREATE TABLE videos(
    VIDEOID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    VIDEO BLOB,
    USERNAME VARCHAR(100),
    DATESTIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT videos_videoId_pk PRIMARY KEY (videoId),
    CONSTRAINT VIDEOS_USERNAME_FK FOREIGN KEY (USERNAME)
        REFERENCES USERS(USERNAME)); 

ALTER TABLE VIDEOS DROP SOURCE;

CREATE TABLE posts(
    postId INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    textContent VARCHAR(120),
    username VARCHAR(100),
    imageId INTEGER,
    videoId INTEGER,
    datesTime TIMESTAMP default CURRENT_TIMESTAMP,
    CONSTRAINT posts_postId_pk PRIMARY KEY (postId),
    CONSTRAINT posts_username_fk FOREIGN KEY (username)
        REFERENCES users(username),
    CONSTRAINT posts_imageId_fk FOREIGN KEY (imageId)
        REFERENCES images(imageId),
    CONSTRAINT posts_videoId_fk FOREIGN KEY (videoId)
        REFERENCES videos(videoId));

ALTER TABLE posts
    ADD datesTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP;

CREATE TABLE comments(
    commentId INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    content VARCHAR(250),
    DATESTIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT comments_commentId_pk PRIMARY KEY (commentId));

ALTER TABLE comments
    ADD datesTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP;

CREATE TABLE commentList(
    listId INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    commentId INTEGER,
    postId INTEGER,
    CONSTRAINT commentList_listId_pk PRIMARY KEY (listId),
    CONSTRAINT commentList_commentId_fk FOREIGN KEY (commentId)
        REFERENCES comments(commentId),
    CONSTRAINT commentList_postId_fk FOREIGN KEY (postId)
        REFERENCES posts(postId));


CREATE TABLE imageBridge(
     bridgeId INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
     postId INTEGER,
     imageId INTEGER,
     CONSTRAINT imageBridge_bridgeId_pk PRIMARY KEY (bridgeId),
     CONSTRAINT imageBridge_postId_fk  FOREIGN KEY (postId)
        REFERENCES posts(postId),
    CONSTRAINT imageBridge_imageId_fk FOREIGN KEY (imageId)
        REFERENCES images(imageId));

CREATE TABLE videoBridge(
    bridgeId INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
     postId INTEGER,
     videoId INTEGER,
     CONSTRAINT videoBridge_bridgeId_pk PRIMARY KEY (bridgeId),
     CONSTRAINT videoBridge_postId_fk  FOREIGN KEY (postId)
        REFERENCES posts(postId),
    CONSTRAINT videoBridge_videoId_fk FOREIGN KEY (videoId)
        REFERENCES videos(videoId));

CREATE TABLE ShowcaseUniversity(
	ShowcaseID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
	UniversityName VARCHAR(100),
    ImageName VARCHAR(50),
    IsShowCase CHAR(1),
    CONSTRAINT showcaseUniversity_showcaseID_pk PRIMARY KEY (ShowcaseID));


-----------------------------------INSERT STATEMENTS
        INSERT into ShowcaseUniversity (UniversityName,ImageName,IsShowCase) VALUES ('Harvard University','harvard.png','1');
	INSERT into ShowcaseUniversity (UniversityName,ImageName,IsShowCase) VALUES ('Princeton University','princeton.png','1');
	INSERT into ShowcaseUniversity (UniversityName,ImageName,IsShowCase) VALUES ('Illinois State University','ISU1.png','0');
	INSERT into ShowcaseUniversity (UniversityName,ImageName,IsShowCase) VALUES ('University of Illinois Chicago','UIC.png','0');
	INSERT into ShowcaseUniversity (UniversityName,ImageName,IsShowCase) VALUES ('University of Illinois at Urbana-Champaign','UIUC.jpg','0');
	INSERT into ShowcaseUniversity (UniversityName,ImageName,IsShowCase) VALUES ('Yale University','yale.jpg','0');
	INSERT into ShowcaseUniversity (UniversityName,ImageName,IsShowCase) VALUES ('University of Chicago','universitychicago.jpg','0');
	INSERT into ShowcaseUniversity (UniversityName,ImageName,IsShowCase) VALUES ('Columbia University','columbia.jpg','0');
	INSERT into ShowcaseUniversity (UniversityName,ImageName,IsShowCase) VALUES ('Stanford University','stanford.png','0');
	INSERT into ShowcaseUniversity (UniversityName,ImageName,IsShowCase) VALUES ('Duke University','duke.jpg','0');
