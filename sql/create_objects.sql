CREATE TABLE IF NOT EXISTS `site_datacenter` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NULL,
  `properties` TEXT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `site_location` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `datacenter_id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `site` VARCHAR(45) NULL,
  `floor` VARCHAR(45) NULL,
  `room` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  `properties` TEXT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `site_cabinet` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `location_id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `size` INT NULL,
  `properties` TEXT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;