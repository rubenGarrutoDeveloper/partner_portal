-- CREAZIONE UTENZA DB
CREATE USER 'PARTNER_PORTAL'@'LOCALHOST' IDENTIFIED BY 'PARTNER_PORTAL';
GRANT ALL PRIVILEGES ON * . * TO 'PARTNER_PORTAL'@'LOCALHOST';

DROP DATABASE IF EXISTS PARTNER_PORTAL;

CREATE DATABASE  IF NOT EXISTS PARTNER_PORTAL;
USE PARTNER_PORTAL;

-- Creazione tabella utenti
DROP TABLE IF EXISTS USERS;
CREATE TABLE USERS
(
  USERNAME VARCHAR(50) NOT NULL,
  PASSWORD VARCHAR(68) NOT NULL,
  ENABLED TINYINT(1) NOT NULL,
  PRIMARY KEY (USERNAME)
) ENGINE=INNODB DEFAULT CHARSET=LATIN1;

-- Inserimento utenti
INSERT INTO USERS
VALUES 
('gabry.pucci','{bcrypt}$2a$10$ycC8YZOGwzGFrT37yGNbVuaZKqhLiZbU.dpPETpvx0W/4Gw3D3EjC',1),
('matteo.bonarriva','{bcrypt}$2a$10$ycC8YZOGwzGFrT37yGNbVuaZKqhLiZbU.dpPETpvx0W/4Gw3D3EjC',1),
('ruben.garruto','{bcrypt}$2a$10$ycC8YZOGwzGFrT37yGNbVuaZKqhLiZbU.dpPETpvx0W/4Gw3D3EjC',1);


-- Creazione tabella dei ruoli
DROP TABLE IF EXISTS AUTHORITIES;
CREATE TABLE AUTHORITIES
(
  USERNAME VARCHAR(50) NOT NULL,
  AUTHORITY VARCHAR(50) NOT NULL,
  UNIQUE KEY AUTHORITIES_IDX_1 (USERNAME,AUTHORITY),
  CONSTRAINT AUTHORITIES_IBFK_1 FOREIGN KEY (USERNAME) REFERENCES USERS (USERNAME)
) ENGINE=INNODB DEFAULT CHARSET=LATIN1;

-- Inserimento ruoli
INSERT INTO AUTHORITIES 
VALUES 
('gabry.pucci','ROLE_USER'),
('matteo.bonarriva','ROLE_USER'),
('ruben.garruto','ROLE_USER'),
('matteo.bonarriva','ROLE_PARTNER'),
('ruben.garruto','ROLE_ADMIN');