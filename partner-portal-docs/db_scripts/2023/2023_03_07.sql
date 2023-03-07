-- Table: partner
CREATE TABLE partner (
    idPartner INT NOT NULL AUTO_INCREMENT,
    codePartner VARCHAR(255) NOT NULL,
    descPartner VARCHAR(255) NOT NULL,
    mail VARCHAR(255) NOT NULL,
    phone VARCHAR(255) NOT NULL,
    timeCreated VARCHAR(255) NOT NULL,
    createdBy INT NOT NULL,
    webSite VARCHAR(255) NOT NULL,
    PRIMARY KEY (idPartner),
    FOREIGN KEY (createdBy) REFERENCES user(id)
);

INSERT INTO partner (idPartner, codePartner, descPartner, mail, phone, timeCreated, createdBy, website) 
VALUES (1, 'PARTNER01', 'Partner 01', 'partner01@partner.com', '+1 123-456-7890', '2022-02-06 15:35:24', 1, 'www.partner01.com');

INSERT INTO partner (idPartner, codePartner, descPartner, mail, phone, timeCreated, createdBy, website) 
VALUES (2, 'PARTNER02', 'Partner 02', 'partner02@partner.com', '+1 234-567-8901', '2022-02-06 15:35:24', 1, 'www.partner02.com');

INSERT INTO partner (idPartner, codePartner, descPartner, mail, phone, timeCreated, createdBy, website) 
VALUES (3, 'PARTNER03', 'Partner 03', 'partner03@partner.com', '+1 345-678-9012', '2022-02-06 15:35:24', 1, 'www.partner03.com');

INSERT INTO partner (idPartner, codePartner, descPartner, mail, phone, timeCreated, createdBy, website) 
VALUES (4, 'PARTNER04', 'Partner 04', 'partner04@partner.com', '+1 456-789-0123', '2022-02-06 15:35:24', 1, 'www.partner04.com');

INSERT INTO partner (idPartner, codePartner, descPartner, mail, phone, timeCreated, createdBy, website) 
VALUES (5, 'PARTNER05', 'Partner 05', 'partner05@partner.com', '+1 567-890-1234', '2022-02-06 15:35:24', 1, 'www.partner05.com');

INSERT INTO partner (idPartner, codePartner, descPartner, mail, phone, timeCreated, createdBy, website) 
VALUES (6, 'PARTNER06', 'Partner 06', 'partner06@partner.com', '+1 678-901-2345', '2022-02-06 15:35:24', 1, 'www.partner06.com');

INSERT INTO partner (idPartner, codePartner, descPartner, mail, phone, timeCreated, createdBy, website) 
VALUES (7, 'PARTNER07', 'Partner 07', 'partner07@partner.com', '+1 789-012-3456', '2022-02-06 15:35:24', 1, 'www.partner07.com');

INSERT INTO partner (idPartner, codePartner, descPartner, mail, phone, timeCreated, createdBy, website) 
VALUES (8, 'PARTNER08', 'Partner 08', 'partner08@partner.com', '+1 890-123-4567', '2022-02-06 15:35:24', 1, 'www.partner08.com');

INSERT INTO partner (idPartner, codePartner, descPartner, mail, phone, timeCreated, createdBy, website) 
VALUES (9, 'PARTNER09', 'Partner 09', 'partner09@partner.com', '+1 901-234-5678', '2022-02-06 15:35:24', 1, 'www.partner09.com');

INSERT INTO partner (idPartner, codePartner, descPartner, mail, phone, timeCreated, createdBy, webSite) 
VALUES (10, 'PTN010', 'Partner 10', 'partner10@example.com', '+39 333 111222', '2022-01-01', 1, 'https://www.partner10.com');

INSERT INTO partner (idPartner, codePartner, descPartner, mail, phone, timeCreated, createdBy, webSite) 
VALUES (11, 'PTN011', 'Partner 11', 'partner11@example.com', '+39 333 222333', '2022-01-01', 1, 'https://www.partner11.com');

INSERT INTO partner (idPartner, codePartner, descPartner, mail, phone, timeCreated, createdBy, webSite) 
VALUES (12, 'PTN012', 'Partner 12', 'partner12@example.com', '+39 333 333444', '2022-01-01', 1, 'https://www.partner12.com');

-- Table: rel_project_partner
CREATE TABLE rel_project_partner (
	idRelProjectPartner INT NOT NULL AUTO_INCREMENT,
    idProject INT NOT NULL,
    idPartner INT NOT NULL,
    PRIMARY KEY (idRelProjectPartner),
    FOREIGN KEY (idProject) REFERENCES project(idProject),
    FOREIGN KEY (idPartner) REFERENCES partner(idPartner)
);

INSERT INTO rel_project_partner (idProject, idPartner) VALUES (1, 1);
INSERT INTO rel_project_partner (idProject, idPartner) VALUES (1, 2);
INSERT INTO rel_project_partner (idProject, idPartner) VALUES (1, 3);
INSERT INTO rel_project_partner (idProject, idPartner) VALUES (1, 4);
INSERT INTO rel_project_partner (idProject, idPartner) VALUES (1, 5);
INSERT INTO rel_project_partner (idProject, idPartner) VALUES (1, 6);
INSERT INTO rel_project_partner (idProject, idPartner) VALUES (2, 2);
INSERT INTO rel_project_partner (idProject, idPartner) VALUES (2, 3);
INSERT INTO rel_project_partner (idProject, idPartner) VALUES (2, 4);
INSERT INTO rel_project_partner (idProject, idPartner) VALUES (2, 5);
INSERT INTO rel_project_partner (idProject, idPartner) VALUES (3, 4);
INSERT INTO rel_project_partner (idProject, idPartner) VALUES (3, 5);

-- View of partners
CREATE VIEW view_partner AS
SELECT p.idPartner, p.codePartner, p.descPartner, p.mail, p.phone, p.timeCreated, p.createdBy, p.webSite, rp.idProject
FROM partner p
INNER JOIN rel_project_partner rp ON p.idPartner = rp.idPartner
INNER JOIN project proj ON rp.idProject = proj.idProject;