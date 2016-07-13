# All Mysql 5.7 scripts to create and initialize the movies and series schema

CREATE SCHEMA `movies_and_series` DEFAULT CHARACTER SET utf8 ;
## Continue here
# Create the titles table 
CREATE TABLE `movies_and_series`.`titles` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(250) NULL,
  `year` YEAR NULL,
  `rated` VARCHAR(8) NULL,
  `release_date` DATE NULL,
  `runtime` INT NULL,
  `metascore` INT NULL,
  `imdbrating` DECIMAL NULL DEFAULT 0,
  `imdbvotes` BIGINT NULL DEFAULT 0,
  `type` VARCHAR(8) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'Table for all the titles';


# Generes types table 
CREATE TABLE `movies_and_series`.`generes_types` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'Stores the generes codes to be used for each title',
  `genere` VARCHAR(25) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
COMMENT = 'Possible type of generes';


# Store the generes for each title 
CREATE TABLE `movies_and_series`.`title_generes` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `genere_id` INT UNSIGNED NULL,
  `title_id` INT UNSIGNED NULL COMMENT 'Stores the applicable generes for each title',
  PRIMARY KEY (`id`),
  INDEX `genere_idx` (`genere_id` ASC),
  INDEX `title_key_idx` (`title_id` ASC),
  CONSTRAINT `genere_key`
    FOREIGN KEY (`genere_id`)
    REFERENCES `movies_and_series`.`generes_types` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `title_key`
    FOREIGN KEY (`title_id`)
    REFERENCES `movies_and_series`.`titles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
COMMENT = 'Applicable generes for each title';


# cast and crew member names 
CREATE TABLE `movies_and_series`.`cast_and_crew` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
COMMENT = 'Stores all personnel involved in a title';

# Creates the directors
CREATE TABLE `movies_and_series`.`directors` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `director_crew_id` INT UNSIGNED NOT NULL,
  `title_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `director_id_idx` (`director_crew_id` ASC),
  INDEX `title_idx` (`title_id` ASC),
  CONSTRAINT `director_id`
    FOREIGN KEY (`director_crew_id`)
    REFERENCES `movies_and_series`.`cast_and_crew` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `title`
    FOREIGN KEY (`title_id`)
    REFERENCES `movies_and_series`.`titles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
COMMENT = 'Maps title to its directors';


# Creates table to store the writers of a title
CREATE TABLE `movies_and_series`.`writers` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'Writers of title',
  `writer_crew_id` INT UNSIGNED NULL,
  `title_id` INT UNSIGNED NULL,
  PRIMARY KEY (`id`),
  INDEX `writer_crew_idx` (`writer_crew_id` ASC),
  INDEX `title_map_idx` (`title_id` ASC),
  CONSTRAINT `writer_crew`
    FOREIGN KEY (`writer_crew_id`)
    REFERENCES `movies_and_series`.`cast_and_crew` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `title_writer`
    FOREIGN KEY (`title_id`)
    REFERENCES `movies_and_series`.`titles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'Writers of title';

# Create table to store the actors in a title
CREATE TABLE `movies_and_series`.`actors` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `actor_crew_id` INT UNSIGNED NOT NULL,
  `title_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `actor_crew_idx` (`actor_crew_id` ASC),
  INDEX `title_actor_idx` (`title_id` ASC),
  CONSTRAINT `actor_crew`
    FOREIGN KEY (`actor_crew_id`)
    REFERENCES `movies_and_series`.`cast_and_crew` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `title_actors`
    FOREIGN KEY (`title_id`)
    REFERENCES `movies_and_series`.`titles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'Actors in title';

# Create language table
CREATE TABLE `movies_and_series`.`languages` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `language` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `language_UNIQUE` (`language` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'Possible languages';

# Create language join table
CREATE TABLE `movies_and_series`.`title_released_languages` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `title_id` INT UNSIGNED NOT NULL,
  `language_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `title_lan_lnk_idx` (`title_id` ASC),
  INDEX `lang_title_lnk_idx` (`language_id` ASC),
  CONSTRAINT `title_lan_lnk`
    FOREIGN KEY (`title_id`)
    REFERENCES `movies_and_series`.`titles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `lang_title_lnk`
    FOREIGN KEY (`language_id`)
    REFERENCES `movies_and_series`.`languages` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
COMMENT = 'Title released under languages';

# Represents a country
CREATE TABLE `movies_and_series`.`countries` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `countryname` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`id`))
COMMENT = 'All allowed countries';

#Join table for many to many country and title relationship
CREATE TABLE `movies_and_series`.`title_released_country` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `title_id` INT UNSIGNED NOT NULL,
  `country_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `title_ctry_lnk_idx` (`title_id` ASC),
  INDEX `country_title_lnk_idx` (`country_id` ASC),
  CONSTRAINT `title_ctry_lnk`
    FOREIGN KEY (`title_id`)
    REFERENCES `movies_and_series`.`titles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `country_title_lnk`
    FOREIGN KEY (`country_id`)
    REFERENCES `movies_and_series`.`countries` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
COMMENT = 'Title released under these countries';

#Stores the plot of a title
CREATE TABLE `movies_and_series`.`plot` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `plottext` TEXT NOT NULL,
  PRIMARY KEY (`id`))
COMMENT = 'Plot of a title';

# Change the title table to add additional constraints and relationslanguages
ALTER TABLE `movies_and_series`.`titles` 
CHANGE COLUMN `title` `title` VARCHAR(250) NOT NULL ,
CHANGE COLUMN `type` `type` VARCHAR(8) NOT NULL ,
ADD COLUMN `awards` VARCHAR(255) NULL DEFAULT NULL AFTER `type`,
ADD COLUMN `poster` VARCHAR(300) NULL DEFAULT NULL AFTER `awards`;

ALTER TABLE `movies_and_series`.`titles` 
ADD COLUMN `plotid` INT UNSIGNED NULL AFTER `poster`,
ADD INDEX `title_plot_lnk_idx` (`plotid` ASC);
ALTER TABLE `movies_and_series`.`titles` 
ADD CONSTRAINT `title_plot_lnk`
  FOREIGN KEY (`plotid`)
  REFERENCES `movies_and_series`.`plot` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

