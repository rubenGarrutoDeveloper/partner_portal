ALTER TABLE `partner_portal`.`users_roles` 
ADD COLUMN `id` INT NULL AFTER `role_id`;


UPDATE `partner_portal`.`users_roles` SET `id` = '1' WHERE (`user_id` = '1') and (`role_id` = '1');
UPDATE `partner_portal`.`users_roles` SET `id` = '2' WHERE (`user_id` = '1') and (`role_id` = '2');
UPDATE `partner_portal`.`users_roles` SET `id` = '3' WHERE (`user_id` = '1') and (`role_id` = '3');
UPDATE `partner_portal`.`users_roles` SET `id` = '4' WHERE (`user_id` = '2') and (`role_id` = '1');
UPDATE `partner_portal`.`users_roles` SET `id` = '5' WHERE (`user_id` = '2') and (`role_id` = '2');
UPDATE `partner_portal`.`users_roles` SET `id` = '6' WHERE (`user_id` = '3') and (`role_id` = '1');
UPDATE `partner_portal`.`users_roles` SET `id` = '7' WHERE (`user_id` = '3') and (`role_id` = '2');
UPDATE `partner_portal`.`users_roles` SET `id` = '8' WHERE (`user_id` = '3') and (`role_id` = '3');


-- Drop the foreign key constraint referencing the primary key
ALTER TABLE users_roles
DROP FOREIGN KEY FK_ROLE;

ALTER TABLE `partner_portal`.`users_roles` 
CHANGE COLUMN `id` `id` INT NOT NULL AUTO_INCREMENT ,
ADD PRIMARY KEY (`id`);

-- Id setted as primary key
ALTER TABLE `partner_portal`.`users_roles` 
CHANGE COLUMN `id` `id` INT NOT NULL AUTO_INCREMENT FIRST;

-- Recovery of secondary keys
ALTER TABLE `partner_portal`.`users_roles` 
ADD CONSTRAINT `FK_USER_ROLE_1`
  FOREIGN KEY (`role_id`)
  REFERENCES `partner_portal`.`role` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `FK_USER_ROLE_2`
  FOREIGN KEY (`user_id`)
  REFERENCES `partner_portal`.`user` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

