use partner_portal;
-- Rename the table rel_project_partner to rel_project_user
ALTER TABLE `rel_project_partner` RENAME TO `rel_project_user`;

-- Update the definition of the table rel_project_user
-- Change the name of the field idPartner to idUser and modify the type to int
-- Remove the foreign key constraint `rel_project_partner_ibfk_2` that references the table partner
ALTER TABLE `rel_project_user` CHANGE COLUMN `idPartner` `idUser` INT NOT NULL;
ALTER TABLE `rel_project_user` CHANGE COLUMN `idRelProjectPartner` `id` INT NOT NULL;
ALTER TABLE `rel_project_user`  DROP FOREIGN KEY `rel_project_user_ibfk_2`;

-- Add a new foreign key constraint to reference the table user
-- The foreign key references the id column in the table user
ALTER TABLE `rel_project_user` ADD CONSTRAINT `fk_user` FOREIGN KEY (`idUser`) REFERENCES `user` (`id`);

-- Update the index name to reflect the changes
ALTER TABLE `rel_project_user`   RENAME INDEX `idPartner` TO `idUser`;

-- delete unused table and view: partner
DROP TABLE IF EXISTS `partner`;
DROP VIEW IF EXISTS `view_partner`;

-- creation of the view: view_rel_project_user
CREATE VIEW view_rel_project_user AS
SELECT rp.idProject AS id_project, u.id AS id_User, u.first_name, u.last_name, u.email
FROM rel_project_user rp
INNER JOIN user u ON rp.idUser = u.id;

