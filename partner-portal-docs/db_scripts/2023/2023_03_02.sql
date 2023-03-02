-- Table Project: Added new fields
ALTER TABLE `project`
ADD COLUMN `codeProject` varchar(255) NOT NULL,
ADD COLUMN `createdBy` int NOT NULL;

-- Added unique constraint for codeProject
ALTER TABLE project ADD CONSTRAINT uc_code_project UNIQUE (codeProject);

-- View Project: Added new fields
CREATE OR REPLACE VIEW view_project AS
SELECT 
    p.idProject AS idProject,
    p.title AS title,
    p.descProject AS descProject,
    s.idStatus AS idStatus,
    s.dateLastState AS dateLastState,
    CONCAT(u.first_name, ' ', u.last_name) AS nameCreatedBy,
    p.createdBy AS createdBy,
    p.codeProject AS codeProject
FROM 
    project p
    JOIN (
        SELECT 
            rps.idProject AS idProject,
            rps.idStatus AS idStatus,
            rps.createdAt AS dateLastState
        FROM 
            rel_project_status rps
        WHERE 
            rps.createdAt = (
                SELECT 
                    MAX(rel_project_status.createdAt)
                FROM 
                    rel_project_status
                WHERE 
                    rel_project_status.idProject = rps.idProject
            )
    ) s ON p.idProject = s.idProject
    JOIN user u ON p.createdBy = u.id;


