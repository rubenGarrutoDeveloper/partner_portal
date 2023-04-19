-- Creation of the table: project_phase
CREATE TABLE project_phase (
  id INT PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(255) NOT NULL,
  description TEXT,
  start_time DATETIME,
  end_time DATETIME,
  fund_raised DECIMAL(10, 2),
  total_fund DECIMAL(10, 2)
);

ALTER TABLE project_phase ADD CONSTRAINT check_start_end_time CHECK (start_time < end_time);


-- Creation of the table: rel_project_phase
CREATE TABLE rel_project_phase (
 	id INT PRIMARY KEY AUTO_INCREMENT,
 	id_project INT NOT NULL,
 	id_phase INT NOT NULL,
 	FOREIGN KEY (id_project) REFERENCES project(idProject),
 	FOREIGN KEY (id_phase) REFERENCES project_phase(id)
);

ALTER TABLE rel_project_phase ADD CONSTRAINT unique_project_phase UNIQUE (id_project, id_phase);


-- Adding some data for project_phase
-- project with idProject = 1
INSERT INTO project_phase (title, description, start_time, end_time , fund_raised , total_fund)
VALUES ('Phase 1: Found Raising', 'Raising initial funds for the project', '2023-01-01 10:00:00', '2023-01-31 23:59:59', 5000.00, 10000.00);

INSERT INTO project_phase (title, description, start_time, end_time , fund_raised , total_fund)
VALUES ('Phase 2: Payments system', 'Devoloping payments system', '2023-02-01 00:00:00', '2023-03-15 23:59:59', 12000.00, 20000.00);

INSERT INTO project_phase (title, description, start_time, end_time , fund_raised , total_fund)
VALUES ('Phase 3: Beta Testing of Payments System', 'Testing the project with a limited audience', '2023-03-16 00:00:00', '2023-04-15 23:59:59', 18000.00, 25000.00);

INSERT INTO rel_project_phase (id_project, id_phase) VALUES (1, 1);
INSERT INTO rel_project_phase (id_project, id_phase) VALUES (1, 2);
INSERT INTO rel_project_phase (id_project, id_phase) VALUES (1, 3);


-- project with idProject = 2
INSERT INTO project_phase (title, description, start_time, end_time , fund_raised , total_fund)
VALUES ('Phase 1: Design', 'Designing the project', '2023-02-15 10:00:00', '2023-02-28 23:59:59', 5000.00, 10000.00);

INSERT INTO project_phase (title, description, start_time, end_time , fund_raised , total_fund)
VALUES ('Phase 2: Development', 'Developing the project', '2023-03-01 00:00:00', '2023-04-15 23:59:59', 12000.00, 20000.00);

-- per il project 2
INSERT INTO rel_project_phase (id_project, id_phase)
VALUES (2, 4), (2, 5), (2, 6);

-- project with idProject = 3
INSERT INTO project_phase (title, description, start_time, end_time , fund_raised , total_fund)
VALUES ('Phase 1: Prototype', 'Building a prototype of the project', '2023-04-01 10:00:00', '2023-04-30 23:59:59', 5000.00, 10000.00);

INSERT INTO project_phase (title, description, start_time, end_time , fund_raised , total_fund)
VALUES ('Phase 2: Testing', 'Testing the project prototype', '2023-05-01 00:00:00', '2023-05-31 23:59:59', 12000.00, 20000.00);

-- per il project 3
INSERT INTO rel_project_phase (id_project, id_phase)
VALUES (3, 6), (3, 7);

-- Creaion of the view:
CREATE or replace VIEW view_rel_project_phase AS
select UUID() AS uuid, p.idProject, pp.title, pp.description, pp.start_time, pp.end_time, pp.fund_raised, pp.total_fund 
FROM project p
INNER JOIN rel_project_phase rpp ON p.idProject = rpp.id_project
INNER JOIN project_phase pp ON rpp.id_phase = pp.id;
