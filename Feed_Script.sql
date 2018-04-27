ALTER TABLE itkstu.posts
    ADD COLUMN textContent VARCHAR(120);
    
INSERT INTO itkstu.videos (postid)
    VALUES(1);

-- Replace source with content column name if different
INSERT INTO itkstu.images (source)
    VALUES('value');