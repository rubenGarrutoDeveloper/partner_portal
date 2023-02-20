use partner_portal;

-- Creation view project
create or replace VIEW view_project AS
SELECT 
    project.idProject, 
    project.title, 
    project.descProject, 
    project.idState
FROM 
    project 
JOIN 
    anag_state 
ON 
    project.idState = anag_state.idState;