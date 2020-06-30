DROP DATABASE IF EXISTS DBKNK;
CREATE DATABASE DBKNK;
USE DBKNK;

CREATE TABLE Studenti (
Stud_ID VARCHAR(20),
Emri VARCHAR(50) NOT NULL,
Mbiemri VARCHAR(50) NOT NULL,
Fakulteti VARCHAR(50) NOT NULL,
Departamenti VARCHAR(50) NOT NULL,
VitiLindjes VARCHAR(50) NOT NULL,
VendiLindjes VARCHAR(50) NOT NULL,
MbaroiStudimet VARCHAR(50),
VitiRegjistrimit VARCHAR(50) NOT NULL,
Titulli VARCHAR(70) NOT NULL DEFAULT 'Student',
PRIMARY KEY (Stud_ID));

CREATE TABLE Lendet (
Lenda VARCHAR(50) NOT NULL,
ECTS INT NOT NULL,
Profesori VARCHAR(50) NOT NULL,
PRIMARY KEY(Lenda));

CREATE TABLE Profesori (
Profesori VARCHAR(50),
Prof_Password VARCHAR(50) NOT NULL,
PRIMARY KEY (Profesori));


CREATE TABLE Login (
Stud_ID VARCHAR(50),
Stud_Password VARCHAR(50) NOT NULL,
FOREIGN KEY (Stud_ID) REFERENCES Studenti(Stud_ID),
PRIMARY KEY(Stud_ID));

CREATE TABLE Notat (
Stud_ID VARCHAR(50) NOT NULL,
Lenda VARCHAR(50) NOT NULL,
ECTS INT NOT NULL,
Profesori VARCHAR(50) NOT NULL,
Nota INT NOT NULL,
FOREIGN KEY (Stud_ID) REFERENCES Studenti(Stud_ID),
FOREIGN KEY (Profesori) REFERENCES Profesori(Profesori));

INSERT INTO `dbknk`.`Lendet` (`Lenda`, `ECTS`, `Profesori`) VALUES ('Komunikimi Njeri Kompjuter', '7', 'Isak Shabani');
INSERT INTO `dbknk`.`Lendet` (`Lenda`, `ECTS`, `Profesori`) VALUES ('Arkitektura e Kompjutereve', '6', 'Valon Raca');
INSERT INTO `dbknk`.`Lendet` (`Lenda`, `ECTS`, `Profesori`) VALUES ('Interneti', '7', 'Lule Ahmeti');
INSERT INTO `dbknk`.`Lendet` (`Lenda`, `ECTS`, `Profesori`) VALUES ('Qarqe Digjitale', '5', 'Agni Dika');
INSERT INTO `dbknk`.`Lendet` (`Lenda`, `ECTS`, `Profesori`) VALUES ('Anglisht', '5', 'Gazmend Pula');
INSERT INTO `dbknk`.`Lendet` (`Lenda`, `ECTS`, `Profesori`) VALUES ('Matematika2', '7', 'Marjan Dema');
INSERT INTO `dbknk`.`Lendet` (`Lenda`, `ECTS`, `Profesori`) VALUES ('Siguria ne Internet', '6', 'Valon Raca');
INSERT INTO `dbknk`.`Lendet` (`Lenda`, `ECTS`, `Profesori`) VALUES ('Databaze', '7', 'Lule Ahmeti');
INSERT INTO `dbknk`.`Lendet` (`Lenda`, `ECTS`, `Profesori`) VALUES ('Algoritmet dhe Struktura e Te Dhenave', '5', 'Avni Rexhepi');
INSERT INTO `dbknk`.`Lendet` (`Lenda`, `ECTS`, `Profesori`) VALUES ('Gjuhe Programuese', '5', 'Avni Rexhepi');


INSERT INTO `dbknk`.`Profesori` (`Profesori`, `Prof_Password`) VALUES ('Isak Shabani', '123');
INSERT INTO `dbknk`.`Profesori` (`Profesori`, `Prof_Password`) VALUES ('Valon Raca', '123');
INSERT INTO `dbknk`.`Profesori` (`Profesori`, `Prof_Password`) VALUES ('Lule Ahmeti', '123');
INSERT INTO `dbknk`.`Profesori` (`Profesori`, `Prof_Password`) VALUES ('Agni Dika', '123');
INSERT INTO `dbknk`.`Profesori` (`Profesori`, `Prof_Password`) VALUES ('Gazmend Pula', '123');
INSERT INTO `dbknk`.`Profesori` (`Profesori`, `Prof_Password`) VALUES ('Avni Rexhepi', '123');

INSERT INTO `dbknk`.`Studenti` (`Stud_ID`, `Emri`, `Mbiemri`, `Fakulteti`, `Departamenti`, `VitiLindjes`, `VendiLindjes`, `MbaroiStudimet`, `VitiRegjistrimit`, `Titulli`) VALUES ('180715100007', 'Blerona', 'Idrizi', 'Fakulteti i Inxhinierise Elektrike Dhe Kompjuterike', 'Inxhinieri Kompjuterike', '07-12-2000', 'Prishtine', '2019', '01-10-2016', 'Bachelor i Inxhinierise Elektrike Dhe Kompjuterike');
INSERT INTO `dbknk`.`Studenti` (`Stud_ID`, `Emri`, `Mbiemri`, `Fakulteti`, `Departamenti`, `VitiLindjes`, `VendiLindjes`, `MbaroiStudimet`, `VitiRegjistrimit`, `Titulli`) VALUES ('180714100099', 'Isak', 'Shabani', 'Fakulteti i Inxhinierise Elektrike Dhe Kompjuterike', 'Inxhinieri Kompjuterike', '26-03-1998', 'Prishtine', '', '01-10-2016', 'Student');

INSERT INTO `dbknk`.`Login` (`Stud_ID`, `Stud_Password`) VALUES ('180715100007', '123');
INSERT INTO `dbknk`.`Login` (`Stud_ID`, `Stud_Password`) VALUES ('180714100099', '123');

INSERT INTO `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) VALUES ('180715100007', 'Komunikimi Njeri Kompjuter', '7', 'Isak Shabani', '8');
INSERT INTO `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) VALUES ('180715100007', 'Arkitektura e Kompjutereve', '6', 'Valon Raca', '6');
INSERT INTO `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) VALUES ('180715100007', 'Interneti', '7', 'Lule Ahmeti', '8');
INSERT INTO `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) VALUES ('180715100007', 'Matematika 2', '7', 'Isak Shabani', '8');
INSERT INTO `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) VALUES ('180715100007', 'Siguria ne Internet', '6', 'Valon Raca', '6');
INSERT INTO `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) VALUES ('180715100007', 'Gjuhe Programuese', '5', 'Avni Rexhepi', '8');
INSERT INTO `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) VALUES ('180715100007', 'Algoritmet dhe Strukturat e te Dhenave', '5', 'Avni Rexhepi', '6');
INSERT INTO `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) VALUES ('180715100007', 'Qarqe Digjitale', '5', 'Agni Dika', '8');
INSERT INTO `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) VALUES ('180715100007', 'Gjuhe Angleze', '5', 'Gazmend Pula', '8');
INSERT INTO `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) VALUES ('180715100007', 'Databaze', '7', 'Lule Ahmeti', '6');

INSERT INTO `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) VALUES ('180714100099', 'Komunikimi Njeri Kompjuter', '7', 'Isak Shabani', '9');
INSERT INTO `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) VALUES ('180714100099', 'Matematika 2', '7', 'Isak Shabani', '9');
INSERT INTO `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) VALUES ('180714100099', 'Gjuhe Programuese', '5', 'Avni Rexhepi', '9');
INSERT INTO `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) VALUES ('180714100099', 'Siguria ne Internet', '6', 'Valon Raca', '8');
INSERT INTO `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) VALUES ('180714100099', 'Algoritmet dhe Strukturat e te Dhenave', '5', 'Avni Rexhepi', '8');
INSERT INTO `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) VALUES ('180714100099', 'Gjuhe Angleze', '5', 'Gazmend Pula', '8');
INSERT INTO `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) VALUES ('180714100099', 'Databaze', '7', 'Lule Ahmeti', '7');
INSERT INTO `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) VALUES ('180714100099', 'Interneti', '7', 'Lule Ahmeti', '8');

Select * from Notat;

SELECT * FROM Studenti WHERE Stud_ID = "180715100007";

Select * from Notat WHERE Profesori = "Isak Shabani";