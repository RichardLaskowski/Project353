
--Student detail table
create table Project353.StudentDetail (
  --ID INTEGER not null GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  USERNAME		VARCHAR(30),
  PASSWORD LONG         VARCHAR,
  DOB			VARCHAR(50),
  HEIGHT		INT,
  WEIGHT		INT,
  ADDRESS		VARCHAR(500),
  CITY			VARCHAR(20),
  COUNTRY		VARCHAR(20),
  POSTALCODE		VARCHAR(20),
  PHONENO		VARCHAR(20),
  SCHOOL		VARCHAR(500),
  ENDYEAR		VARCHAR(10),
  SAT			INT,
  PSAT			INT,
  ACT			INT,
  CERTIFICATION		VARCHAR(500),
  HOBBIES		VARCHAR(500),
  ESSAY			VARCHAR(1200),
  UNIVERSITY		VARCHAR(500),
  MAJOR			VARCHAR(500),
  FIRSTNAME             VARCHAR (30),
  LASTNAME              VARCHAR (30),
  EMAIL                 VARCHAR(50),
  SECQUES               VARCHAR(100),
  SECANS                VARCHAR(50),
  USERTYPE              VARCHAR(50),
  CONSTRAINT USERID_PK PRIMARY KEY (USERNAME)
);

--Recruiter detail table
create table Project353.RecruiterDetail (
  --ID INTEGER not null GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  USERNAME		VARCHAR(30),
  UNIVERSITY            VARCHAR(100),
  DEPARTMENT            VARCHAR(100),
  PHONENO		VARCHAR(20),
  FIRSTNAME             VARCHAR (30),
  LASTNAME              VARCHAR (30),
  EMAIL                 VARCHAR(50),
  SECQUES               VARCHAR(100),
  SECANS                VARCHAR(50),
  USERTYPE              VARCHAR(50),
  CONSTRAINT USERNAME_PK PRIMARY KEY (USERNAME)
);

CREATE TABLE Project353.PROFILES(
    PROFILE_ID INTEGER not null GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    RECRUITER_UNAME VARCHAR(30),
    STUDENT_UNAME VARCHAR(30),
    PROFILE_PIC_PATH VARCHAR(200),
   -- POST_ID INT,
   -- PICTURES_ID INT(200);,
    --VIDEOS_ID   INT(200);,
    CONSTRAINT PROFILE_ID_PK PRIMARY KEY (PROFILE_ID),
   -- CONSTRAINT PICTURES_ID_FK FOREIGN KEY(PICTURES_ID)
   --     REFERENCES Project353.PICTURES(PICTURES_ID),
   -- CONSTRAINT VID_ID_FK FOREIGN KEY (VIDEOS_ID)
   --     REFERENCES Project353.VIDEOS (VIDEO_ID),
  --  CONSTRAINT POST_ID_FK FOREIGN KEY (POST_ID),
   --     REFERENCES Project353.POSTS(POST_ID),
    CONSTRAINT UNAME_FK FOREIGN KEY (RECRUITER_UNAME)
        REFERENCES Project353.RecruiterDetail(USERNAME),
    CONSTRAINT UNAME_FK2 FOREIGN KEY (STUDENT_UNAME)
        REFERENCES Project353.StudentDetail(USERNAME)
);

CREATE TABLE Project353.PICTURES(
    PICTURES_ID INTEGER not null GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    RECRUITER_UNAME VARCHAR(30),
    STUDENT_UNAME VARCHAR(30),
    FILE_PATH VARCHAR(200),
    CONSTRAINT PIC_ID_PK PRIMARY KEY(PICTURES_ID),
    CONSTRAINT REC_UNAME_FK FOREIGN KEY (RECRUITER_UNAME)
        REFERENCES Project353.RecruiterDetail(USERNAME),
    CONSTRAINT STU_UNAME_FK2 FOREIGN KEY (STUDENT_UNAME)
        REFERENCES Project353.StudentDetail(USERNAME)
);

CREATE TABLE Project353.VIDEOS(
    VIDEO_ID INTEGER not null GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    RECRUITER_UNAME VARCHAR(30),
    STUDENT_UNAME VARCHAR(30),
    FILE_PATH VARCHAR(200),
    CONSTRAINT VID_ID_PK PRIMARY KEY(VIDEO_ID),
    CONSTRAINT REC_UNAME_VID_FK FOREIGN KEY (RECRUITER_UNAME)
        REFERENCES Project353.RecruiterDetail(USERNAME),
    CONSTRAINT STU_UNAME_VID_FK2 FOREIGN KEY (STUDENT_UNAME)
        REFERENCES Project353.StudentDetail(USERNAME)
);

CREATE TABLE Project353.POSTS(
    POST_ID INTEGER not null GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    STORY VARCHAR(300),
    RECRUITER_UNAME VARCHAR(30),
    STUDENT_UNAME VARCHAR (30),
    DATE_TIME   TIMESTAMP,
  --  PICTURES_ID INTEGER;,
  --  VIDEOS_ID   INTEGER;,
  --  CONSTRAINT PICTURES_ID_FK FOREIGN KEY(PICTURES_ID)
  --      REFERENCES Project353.PICTURES(PICTURES_ID),
  --  CONSTRAINT VID_ID_FK FOREIGN KEY (VIDEOS_ID)
  --      REFERENCES Project353.VIDEOS (VIDEO_ID),
    CONSTRAINT POST_ID_PK PRIMARY KEY(POST_ID),
    CONSTRAINT REC_UNAME_POST_FK FOREIGN KEY (RECRUITER_UNAME)
        REFERENCES Project353.RecruiterDetail(USERNAME),
    CONSTRAINT STU_UNAME_POST_FK2 FOREIGN KEY (STUDENT_UNAME)
        REFERENCES Project353.StudentDetail(USERNAME)
);

--BRIDGE TO SOLVE MANY TO MANY PROBLEM BETWEEN POSTS AND PICTURES
CREATE TABLE Project353.PICBRIDGE (
    POST_ID INTEGER,
    PIC_ID INTEGER,
    CONSTRAINT POST_PIC_ID_PK PRIMARY KEY(POST_ID, PIC_ID),
    CONSTRAINT POST_ID_FK FOREIGN KEY (POST_ID)
        REFERENCES Project353.POSTS (POST_ID),
    CONSTRAINT PIC_ID_FK FOREIGN KEY (PIC_ID)
        REFERENCES Project353.PICTURES (PICTURES_ID)
);
--default, 'jax89', 'SleepyHollow', 'Jade', 'Smith', 'jax89@gmail.com', 'Favorite Color', 'blue');


CREATE TABLE Project353.VIDBRIDGE (
    POST_ID INTEGER,
    VID_ID INTEGER,
    CONSTRAINT POST_VID_ID_PK PRIMARY KEY(POST_ID, VID_ID),
    CONSTRAINT VB_POST_ID_FK FOREIGN KEY (POST_ID)
        REFERENCES Project353.POSTS (POST_ID),
    CONSTRAINT VB_VID_ID_FK FOREIGN KEY (VID_ID)
        REFERENCES Project353.VIDEOS (VIDEO_ID)
);

CREATE TABLE Project353.COMMENTS (
    COMMENT_ID INTEGER not null GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    POST_ID INTEGER,
    COMMENT VARCHAR(200),
    CONSTRAINT COMMENT_ID_PK PRIMARY KEY(COMMENT_ID),
    CONSTRAINT COMMENT_POST_ID_FK FOREIGN KEY (POST_ID)
        REFERENCES Project353.POSTS (POST_ID)
);

--select * from Project353.STUDENTDETAIL;

--SELECT * FROM Project353.COMMENTS;

--SELECT * FROM Project353.RECRUITERDETAIL;

--INSERT INTO Project353.RECRUITERDETAIL; values(
--default, 'jax89', 'SleepyHollow', 'Jade', 'Smith', 'jax89@gmail.com', 'Favorite Color', 'blue');

INSERT INTO Project353.STUDENTDETAIL (USERNAME, CITY, FIRSTNAME, LASTNAME, EMAIL, SECQUES, SECANS ) values(
'jax89', 'SleepyHollow', 'James', 'Smith', 'jax89@gmail.com', 'Favorite Color', 'blue');

INSERT INTO Project353.STUDENTDETAIL (USERNAME, CITY, FIRSTNAME, LASTNAME, EMAIL, SECQUES, SECANS ) values(
'dj90', 'Terre Haute', 'Dean', 'James', 'dj90@gmail.com', 'Favorite Color', 'red');

INSERT INTO Project353.STUDENTDETAIL (USERNAME, CITY, FIRSTNAME, LASTNAME, EMAIL, SECQUES, SECANS ) values(
'jj90', 'Terre Haute', 'Jamie', 'Jameson', 'jj90@gmail.com', 'Favorite Color', 'pink');

--drop table Project353.STUDENTDETAIL;
