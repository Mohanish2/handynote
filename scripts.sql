CREATE TABLE user (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  email VARCHAR(50) NOT NULL UNIQUE,
  password VARCHAR(50) NULL ,
  created_at TIMESTAMP,
  modified_at TIMESTAMP,
  PRIMARY KEY (id) 
);
  
CREATE TABLE note (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  user_id BIGINT NOT NULL,
  title VARCHAR(50) NOT NULL ,
  description VARCHAR(1000) NULL ,
  created_at TIMESTAMP,
  modified_at TIMESTAMP,
  PRIMARY KEY (id) ,
  FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE
);

insert into user(email,password,created_at,modified_at) values('gp@gmail.com','password',now(),now());