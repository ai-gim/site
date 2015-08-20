CREATE TABLE IF NOT EXISTS `site_datacenter` (
  `id` VARCHAR(64) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NULL,
  `properties` TEXT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `site_location` (
  `id` VARCHAR(64) NOT NULL,
  `datacenter_id` VARCHAR(64) NOT NULL,
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
  `id` VARCHAR(64) NOT NULL,
  `location_id` VARCHAR(64) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `size` INT NULL,
  `properties` TEXT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;