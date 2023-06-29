-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema servicojbs
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema servicojbs
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `servicojbs` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `servicojbs` ;

-- -----------------------------------------------------
-- Table `servicojbs`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `servicojbs`.`cliente` (
  `idcliente` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(30) NOT NULL,
  `setor` VARCHAR(40) NOT NULL,
  `telefone` VARCHAR(25) NULL DEFAULT NULL,
  PRIMARY KEY (`idcliente`))
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `servicojbs`.`funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `servicojbs`.`funcionario` (
  `idfuncionario` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(30) NOT NULL,
  `telefone` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`idfuncionario`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `servicojbs`.`prestarservico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `servicojbs`.`prestarservico` (
  `prestarservico` INT NOT NULL AUTO_INCREMENT,
  `data` DATE NULL DEFAULT NULL,
  `descricao` VARCHAR(200) NULL DEFAULT NULL,
  `horario` TIME NULL DEFAULT NULL,
  `valor` FLOAT NULL DEFAULT NULL,
  `idcliente` INT NOT NULL,
  `idfuncionario` INT NULL DEFAULT NULL,
  PRIMARY KEY (`prestarservico`, `idcliente`),
  INDEX `FK_prestarservico_idcliente` (`idcliente` ASC) VISIBLE,
  INDEX `FK_prestarservico_idfuncionario` (`idfuncionario` ASC) VISIBLE,
  CONSTRAINT `FK_prestarservico_idcliente`
    FOREIGN KEY (`idcliente`)
    REFERENCES `servicojbs`.`cliente` (`idcliente`),
  CONSTRAINT `FK_prestarservico_idfuncionario`
    FOREIGN KEY (`idfuncionario`)
    REFERENCES `servicojbs`.`funcionario` (`idfuncionario`))
ENGINE = InnoDB
AUTO_INCREMENT = 22
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `servicojbs`.`prestarservico_cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `servicojbs`.`prestarservico_cliente` (
  `prestarservico` INT NOT NULL,
  `idcliente` INT NOT NULL,
  `listarTodos_idcliente` INT NOT NULL,
  PRIMARY KEY (`prestarservico`, `idcliente`, `listarTodos_idcliente`),
  INDEX `FK_prestarservico_cliente_listarTodos_idcliente` (`listarTodos_idcliente` ASC) VISIBLE,
  CONSTRAINT `FK_prestarservico_cliente_listarTodos_idcliente`
    FOREIGN KEY (`listarTodos_idcliente`)
    REFERENCES `servicojbs`.`cliente` (`idcliente`),
  CONSTRAINT `FK_prestarservico_cliente_prestarservico`
    FOREIGN KEY (`prestarservico` , `idcliente`)
    REFERENCES `servicojbs`.`prestarservico` (`prestarservico` , `idcliente`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
