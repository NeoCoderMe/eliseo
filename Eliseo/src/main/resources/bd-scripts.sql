CREATE DATABASE app;
 
 CREATE TABLE `courses` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`description` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`price` DECIMAL(8,2) NOT NULL  , 
	`food-type` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`lastUpdate` TIMESTAMP NOT NULL ,  
	PRIMARY KEY (`id`) USING BTREE 
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

 
CREATE TABLE `users` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`email` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`address` VARCHAR(355) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`phone` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	PRIMARY KEY (`id`) USING BTREE 
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB;



CREATE TABLE `orders` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`user_fk` BIGINT(20) NOT NULL ,
	`cours_fk` BIGINT(20) NOT NULL , 
	`comment` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`created` TIMESTAMP NOT NULL , 
	`lastUpdate` TIMESTAMP NOT NULL , 
	PRIMARY KEY (`id`) USING BTREE,
	CONSTRAINT `FKordersUsersId` FOREIGN KEY (`user_fk`) REFERENCES `users` (`id`) ON UPDATE RESTRICT ON DELETE RESTRICT,
	CONSTRAINT `FKordersCoursesId` FOREIGN KEY (`cours_fk`) REFERENCES `courses` (`id`) ON UPDATE RESTRICT ON DELETE RESTRICT
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB;