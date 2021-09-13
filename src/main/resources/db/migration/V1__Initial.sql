-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema provaseduc
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema provaseduc
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `provaseduc` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `provaseduc` ;

-- -----------------------------------------------------
-- Table `provaseduc`.`aluno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `provaseduc`.`aluno` (
  `aluno_id` BIGINT NOT NULL AUTO_INCREMENT,
  `cidade_natal` VARCHAR(100) NOT NULL,
  `dt_nascimento` DATE NOT NULL,
  `bairro` VARCHAR(100) NOT NULL,
  `cidade` VARCHAR(100) NOT NULL,
  `estado` VARCHAR(60) NOT NULL,
  `num_casa` VARCHAR(10) NOT NULL,
  `rua` VARCHAR(100) NOT NULL,
  `matricula` VARCHAR(100) NOT NULL,
  `nome` VARCHAR(100) NOT NULL,
  `sexo` INT NOT NULL,
  PRIMARY KEY (`aluno_id`),
  UNIQUE INDEX `UK_prosr3jo55p8vlcu7e0g7s2ov` (`matricula` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `provaseduc`.`turma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `provaseduc`.`turma` (
  `turma_id` BIGINT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `turno` INT NOT NULL,
  PRIMARY KEY (`turma_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `provaseduc`.`aluno_turma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `provaseduc`.`aluno_turma` (
  `aluno_id` BIGINT NOT NULL,
  `turma_id` BIGINT NOT NULL,
  PRIMARY KEY (`aluno_id`, `turma_id`),
  INDEX `FKmy58tj0pmjjv5tcv89ik43344` (`turma_id` ASC) VISIBLE,
  CONSTRAINT `FK2fj61l46624xf38hvfb9kqgrw`
    FOREIGN KEY (`aluno_id`)
    REFERENCES `provaseduc`.`aluno` (`aluno_id`),
  CONSTRAINT `FKmy58tj0pmjjv5tcv89ik43344`
    FOREIGN KEY (`turma_id`)
    REFERENCES `provaseduc`.`turma` (`turma_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `provaseduc`.`professor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `provaseduc`.`professor` (
  `professor_id` BIGINT NOT NULL AUTO_INCREMENT,
  `cpf` VARCHAR(11) NOT NULL,
  `nome` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`professor_id`),
  UNIQUE INDEX `UK_pk1omryj5cud6uslkepgyfrca` (`cpf` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `provaseduc`.`disciplina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `provaseduc`.`disciplina` (
  `disciplina_id` BIGINT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `professor_id` BIGINT NULL DEFAULT NULL,
  `turma_id` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`disciplina_id`),
  UNIQUE INDEX `UniqueDisciplinaAndTurma` (`nome` ASC, `turma_id` ASC) VISIBLE,
  INDEX `FKoqie7f1kx32b1atco9fpgxd7g` (`professor_id` ASC) VISIBLE,
  INDEX `FKfye6gx28bftfg2xmxomp60te0` (`turma_id` ASC) VISIBLE,
  CONSTRAINT `FKfye6gx28bftfg2xmxomp60te0`
    FOREIGN KEY (`turma_id`)
    REFERENCES `provaseduc`.`turma` (`turma_id`),
  CONSTRAINT `FKoqie7f1kx32b1atco9fpgxd7g`
    FOREIGN KEY (`professor_id`)
    REFERENCES `provaseduc`.`professor` (`professor_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
