USE PARTNER_PORTAL; 

DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
  id int(11) NOT NULL AUTO_INCREMENT,
  first_name varchar(45) DEFAULT NULL,
  last_name varchar(45) DEFAULT NULL,
  email varchar(45) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table employee
--

INSERT INTO employee VALUES 
	(1,'Leslie','Andrews','leslie@luv2code.com'),
	(2,'Emma','Baumgarten','emma@luv2code.com'),
	(3,'Avani','Gupta','avani@luv2code.com'),
	(4,'Yuri','Petrov','yuri@luv2code.com'),
	(5,'Juan','Vega','juan@luv2code.com');
    
--
-- Table structure for table user
--
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS user;

CREATE TABLE user (
  id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(50) NOT NULL,
  password char(80) NOT NULL,
  first_name varchar(50) NOT NULL,
  last_name varchar(50) NOT NULL,
  email varchar(50) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Dumping data for table user
--
-- NOTE: The passwords are encrypted using BCrypt
--
-- A generation tool is avail at: http://www.luv2code.com/generate-bcrypt-password
--
-- Default passwords here are: password
--

INSERT INTO user (username,password,first_name,last_name,email)
VALUES 
('mario.rossi','$2a$10$vfKc4NYxiitYGXjXUySj1uEorw2OK/B/nC/crMqau2ljVYzZiju22','Mario','Rossi','mario@mail.com'),
('luigi.verdi','$2a$10$vfKc4NYxiitYGXjXUySj1uEorw2OK/B/nC/crMqau2ljVYzZiju22','Luigi','Verdi','luigi@mail.com'),
('ruben.garruto','$2a$10$vfKc4NYxiitYGXjXUySj1uEorw2OK/B/nC/crMqau2ljVYzZiju22','Ruben','Garruto','ruben@mail.com');


--
-- Table structure for table role
--

DROP TABLE IF EXISTS role;

CREATE TABLE role (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(50) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Dumping data for table roles
--

INSERT INTO role (name)
VALUES 
('ROLE_USER'),('ROLE_PARTNER'),('ROLE_ADMIN');

--
-- Table structure for table users_roles
--
DROP TABLE IF EXISTS users_roles;
CREATE TABLE users_roles (
  user_id int(11) NOT NULL,
  role_id int(11) NOT NULL,
  
  PRIMARY KEY (user_id,role_id),
  
  KEY FK_ROLE_idx (role_id),
  
  CONSTRAINT FK_USER_05 FOREIGN KEY (user_id) 
  REFERENCES user (id) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT FK_ROLE FOREIGN KEY (role_id) 
  REFERENCES role (id) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;

--
-- Dumping data for table users_roles
--

INSERT INTO users_roles (user_id,role_id)
VALUES 
(1, 1),
(2, 1),
(2, 2),
(3, 1),
(3, 2),
(3, 3);