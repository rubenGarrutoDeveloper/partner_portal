-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: partner_portal
-- ------------------------------------------------------

-- Init Users

INSERT INTO `user` VALUES (1,'mario.rossi','$2a$10$vfKc4NYxiitYGXjXUySj1uEorw2OK/B/nC/crMqau2ljVYzZiju22','Mario','Rossi','mario@mail.com'),(2,'luigi.verdi','$2a$10$vfKc4NYxiitYGXjXUySj1uEorw2OK/B/nC/crMqau2ljVYzZiju22','Luigi','Verdi','luigi@mail.com'),(3,'ruben.garruto','$2a$10$vfKc4NYxiitYGXjXUySj1uEorw2OK/B/nC/crMqau2ljVYzZiju22','Ruben','Garruto','ruben@mail.com'),(4,'mimmo','$2a$10$vfKc4NYxiitYGXjXUySj1uEorw2OK/B/nC/crMqau2ljVYzZiju22','mimmo','memmo','mimmo@mail.com');

-- Init Role

INSERT INTO `role` VALUES (1,'ROLE_USER'),(2,'ROLE_PARTNER'),(3,'ROLE_ADMIN');

-- Init Employee

INSERT INTO `employee` VALUES (1,'Leslie','Andrews','leslie@luv2code.com'),(2,'Emma','Baumgarten','emma@luv2code.com'),(3,'Avani','Gupta','avani@luv2code.com'),(4,'Yuri','Petrov','yuri@luv2code.com'),(5,'Juan','Vega','juan@luv2code.com');

-- Init Projects

-- INSERT INTO `projects` VALUES (1,'project 1','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque condimentum tortor et vehicula hendrerit. Vestibulum vehicula eu libero in convallis. Nunc blandit vestibulum urna, in tempus dolor. Maecenas posuere id dui et efficitur. Mauris volutpat ultricies nulla, eu blandit ligula finibus a. Sed tincidunt vulputate mi, in posuere magna laoreet et. Aliquam rutrum urna et dolor pulvinar scelerisque. Vivamus justo nisi, placerat nec sollicitudin at, semper quis nisl. Curabitur et orci nec nunc egestas mattis a et velit. Maecenas blandit felis et augue consectetur faucibus. Integer sollicitudin ligula et sollicitudin rutrum. Praesent placerat lectus at tellus elementum, et tincidunt tellus mattis. Mauris eget felis et orci fermentum cursus id sed nibh. Ut porta sapien ut felis ultricies, nec facilisis lectus dapibus. Etiam at elit tristique, interdum odio interdum, laoreet tortor.'),(2,'project 2','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque condimentum tortor et vehicula hendrerit. Vestibulum vehicula eu libero in convallis. Nunc blandit vestibulum urna, in tempus dolor. Maecenas posuere id dui et efficitur. Mauris volutpat ultricies nulla, eu blandit ligula finibus a. Sed tincidunt vulputate mi, in posuere magna laoreet et. Aliquam rutrum urna et dolor pulvinar scelerisque. Vivamus justo nisi, placerat nec sollicitudin at, semper quis nisl. Curabitur et orci nec nunc egestas mattis a et velit. Maecenas blandit felis et augue consectetur faucibus. Integer sollicitudin ligula et sollicitudin rutrum. Praesent placerat lectus at tellus elementum, et tincidunt tellus mattis. Mauris eget felis et orci fermentum cursus id sed nibh. Ut porta sapien ut felis ultricies, nec facilisis lectus dapibus. Etiam at elit tristique, interdum odio interdum, laoreet tortor.'),(3,'project 3','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque condimentum tortor et vehicula hendrerit. Vestibulum vehicula eu libero in convallis. Nunc blandit vestibulum urna, in tempus dolor. Maecenas posuere id dui et efficitur. Mauris volutpat ultricies nulla, eu blandit ligula finibus a. Sed tincidunt vulputate mi, in posuere magna laoreet et. Aliquam rutrum urna et dolor pulvinar scelerisque. Vivamus justo nisi, placerat nec sollicitudin at, semper quis nisl. Curabitur et orci nec nunc egestas mattis a et velit. Maecenas blandit felis et augue consectetur faucibus. Integer sollicitudin ligula et sollicitudin rutrum. Praesent placerat lectus at tellus elementum, et tincidunt tellus mattis. Mauris eget felis et orci fermentum cursus id sed nibh. Ut porta sapien ut felis ultricies, nec facilisis lectus dapibus. Etiam at elit tristique, interdum odio interdum, laoreet tortor.'),(4,'project 4','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque condimentum tortor et vehicula hendrerit. Vestibulum vehicula eu libero in convallis. Nunc blandit vestibulum urna, in tempus dolor. Maecenas posuere id dui et efficitur. Mauris volutpat ultricies nulla, eu blandit ligula finibus a. Sed tincidunt vulputate mi, in posuere magna laoreet et. Aliquam rutrum urna et dolor pulvinar scelerisque. Vivamus justo nisi, placerat nec sollicitudin at, semper quis nisl. Curabitur et orci nec nunc egestas mattis a et velit. Maecenas blandit felis et augue consectetur faucibus. Integer sollicitudin ligula et sollicitudin rutrum. Praesent placerat lectus at tellus elementum, et tincidunt tellus mattis. Mauris eget felis et orci fermentum cursus id sed nibh. Ut porta sapien ut felis ultricies, nec facilisis lectus dapibus. Etiam at elit tristique, interdum odio interdum, laoreet tortor.'),(5,'project 5','coming soon..');


-- Init Roles

INSERT INTO `users_roles` VALUES (1,1),(2,1),(3,1),(2,2),(3,2),(3,3);
