DROP DATABASE IF EXISTS contentmanagement;
CREATE DATABASE contentmanagement;

USE contentmanagement;

CREATE TABLE post(
id INT PRIMARY KEY AUTO_INCREMENT,
`title` MEDIUMTEXT NOT NULL,
`userName` VARCHAR(30) NOT NULL,
`bodyOfPost` MEDIUMTEXT NOT NULL,
`dateOfPost` DATE NOT NULL,
`dateOfExpiry` DATE,
`expired` BIT(1) DEFAULT 0);

CREATE TABLE hashtag(
id INT PRIMARY KEY AUTO_INCREMENT,
`hashtag` VARCHAR(30) NOT NULL);

CREATE TABLE category(
id INT PRIMARY KEY AUTO_INCREMENT,
`category` VARCHAR(30) NOT NULL);

CREATE TABLE post_hashtag(
postId INT NOT NULL,
hashtagId INT NOT NULL,
PRIMARY KEY(postId, hashtagId),
FOREIGN KEY (postId) REFERENCES post(id),
FOREIGN KEY (hashtagId) REFERENCES hashtag(id));

CREATE TABLE hashtag_category(
categoryId INT NOT NULL,
hashtagId INT NOT NULL,
PRIMARY KEY(categoryId, hashtagId),
FOREIGN KEY (categoryId) REFERENCES category(id),
FOREIGN KEY (hashtagId) REFERENCES hashtag(id));


INSERT INTO post (title, username, bodyofpost, dateofpost)
VALUES("testTitle", "testName", "testBody", CURDATE());

INSERT INTO hashtag(hashtag)
VALUES("testHashtag");

INSERT INTO category(category)
VALUES("testCategory");

INSERT INTO post_hashtag(postId, hashtagId)
VALUES(1,1);

INSERT INTO hashtag_category(categoryId, hashtagId)
VALUES(1,1);

SELECT * FROM post;
SELECT * FROM hashtag;
SELECT * FROM category;
SELECT * FROM post_hashtag;
SELECT * FROM hashtag_category;