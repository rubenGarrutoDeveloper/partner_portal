-- Added the id of the phase in view_rel_project_phase
CREATE OR REPLACE VIEW view_rel_project_phase AS
    SELECT 
        p.idProject AS id_project,
        pp.id AS id_phase,
        pp.title AS title,
        pp.description AS description,
        pp.start_time AS start_time,
        pp.end_time AS end_time,
        pp.fund_raised AS fund_raised,
        pp.total_fund AS total_fund
    FROM
        ((project p
        JOIN rel_project_phase rpp ON ((p.idProject = rpp.id_project)))
        JOIN project_phase pp ON ((rpp.id_phase = pp.id)));
  
-- Added unique constraint between phase and project
ALTER TABLE rel_project_phase ADD CONSTRAINT UQ_REL_PROJECT_PHASE UNIQUE (id_project, id_phase);