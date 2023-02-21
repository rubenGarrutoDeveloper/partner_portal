use partner_portal;

-- Creation of table to relate project and status
create table rel_project_status (
  idRelProjectStatus INT not null auto_increment,
  idProject INT not null,
  idStatus INT not null,
  createdAt TIMESTAMP default CURRENT_TIMESTAMP,
  primary key (idRelProjectStatus),
  constraint FK_rel_project_status_project foreign key (idProject) references project (idProject),
  constraint FK_rel_project_status_anag_state foreign key (idStatus) references anag_state (idStatus)
);
-- Rel project 1 and status
insert into	rel_project_status(idProject, idStatus)values (1,1);

-- Rel project 2 and status
insert	into rel_project_status (idProject,	idStatus)values (2,1);
insert	into rel_project_status (idProject,	idStatus)values (2,2);

-- Rel project 3 and status
insert into rel_project_status (idProject, idStatus)values (3,1);
insert into rel_project_status (idProject, idStatus)values (3,2);
insert into rel_project_status (idProject, idStatus)values (3,3);

-- Deleting the idStatus column from project
alter table project drop column idState;

-- update of the columns idStatus
ALTER TABLE partner_portal.anag_status CHANGE idState idStatus int NOT NULL;
ALTER TABLE partner_portal.rel_project_status  CHANGE idState idStatus int NOT NULL;

-- Modification of view_project to implements the table of the relation with the status of a project
create or replace
view view_project as
select
	p.idProject,
	p.title,
	p.descProject,
	s.idStatus,
	s.dateLastState
from
	project p
join (
	select
		idProject,
		idStatus,
		createdAt as dateLastState
	from
		rel_project_status rps
	where
		rps.createdAt = 
		(
			select
				MAX(createdAt)
			from
				rel_project_status
			where
				idProject = rps.idProject
	  )
) s on
	p.idProject = s.idProject;

