DROP DATABASE IF EXISTS DBKNK;
CREATE DATABASE DBKNK;
USE DBKNK;

CREATE TABLE Studenti (
Student_ID VARCHAR(20),
Emri VARCHAR(50) NOT NULL,
Mbiemri VARCHAR(50) NOT NULL,
Fakulteti VARCHAR(50) NOT NULL,
Departamenti VARCHAR(50) NOT NULL,
VitiLindjes VARCHAR(50) NOT NULL,
VendiLindjes VARCHAR(50) NOT NULL,
MbaroiStudimet VARCHAR(50),
VitiRegjistrimit VARCHAR(50) NOT NULL,
Titulli VARCHAR(70) NOT NULL DEFAULT 'Student',
PRIMARY KEY (Student_ID));

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
FOREIGN KEY (Student_ID) REFERENCES Studenti(Student_ID),
PRIMARY KEY(Student_ID));

CREATE TABLE Notat (
Stud_ID VARCHAR(50) NOT NULL,
Lenda VARCHAR(50) NOT NULL,
ECTS INT NOT NULL,
Profesori VARCHAR(50) NOT NULL,
Nota INT NOT NULL,
FOREIGN KEY (Student_ID) REFERENCES Studenti(Student_ID),
FOREIGN KEY (Profesori) REFERENCES Profesori(Profesori));

INSERT INTO `dbknk`.`Lendet` (`Lenda`, `ECTS`, `Profesori`) VALUES ('Matematika 1', '7', 'Valdete Hamiti');
INSERT INTO `dbknk`.`Lendet` (`Lenda`, `ECTS`, `Profesori`) VALUES ('Fizika 1', '6', 'Skender Ahmetaj');
INSERT INTO `dbknk`.`Lendet` (`Lenda`, `ECTS`, `Profesori`) VALUES ('Bazat e Elektroteknikes', '7', 'Luan Ahma');
INSERT INTO `dbknk`.`Lendet` (`Lenda`, `ECTS`, `Profesori`) VALUES ('Qarqe Digjitale', '5', 'Sabrije Osmanaj');
INSERT INTO `dbknk`.`Lendet` (`Lenda`, `ECTS`, `Profesori`) VALUES ('Anglisht', '5', 'Gazmend Pula');
INSERT INTO `dbknk`.`Lendet` (`Lenda`, `ECTS`, `Profesori`) VALUES ('Matematika2', '7', 'Valdete Hamiti');
INSERT INTO `dbknk`.`Lendet` (`Lenda`, `ECTS`, `Profesori`) VALUES ('Fizika 2', '6', 'Skender Ahmetaj');
INSERT INTO `dbknk`.`Lendet` (`Lenda`, `ECTS`, `Profesori`) VALUES ('Qarqe Elektrike', '7', 'Luan Ahma');
INSERT INTO `dbknk`.`Lendet` (`Lenda`, `ECTS`, `Profesori`) VALUES ('Algoritmet dhe Struktura e Te Dhenave', '5', 'Avni Rexhepi');
INSERT INTO `dbknk`.`Lendet` (`Lenda`, `ECTS`, `Profesori`) VALUES ('Gjuhe Programuese', '5', 'Avni Rexhepi');
/*Viti dyte */
INSERT INTO `dbknk`.`Lendet` (`Lenda`, `ECTS`, `Profesori`) VALUES ('Sinjale dhe Sisteme', '5', 'Vjosa Shatri');
INSERT INTO `dbknk`.`Lendet` (`Lenda`, `ECTS`, `Profesori`) VALUES ('Elektronike', '5', 'Qamil Kabashi');
INSERT INTO `dbknk`.`Lendet` (`Lenda`, `ECTS`, `Profesori`) VALUES ('Matematike 3K', '5', 'Qefsere Gjonbalaj');
INSERT INTO `dbknk`.`Lendet` (`Lenda`, `ECTS`, `Profesori`) VALUES ('Interneti', '5', 'Lule Ahmedi');
INSERT INTO `dbknk`.`Lendet` (`Lenda`, `ECTS`, `Profesori`) VALUES ('Baze e te dhenave', '5', 'Lule Ahmedi');
INSERT INTO `dbknk`.`Lendet` (`Lenda`, `ECTS`, `Profesori`) VALUES ('Programim i orientuar ne objekte', '5', 'Isak Shabani');
INSERT INTO `dbknk`.`Lendet` (`Lenda`, `ECTS`, `Profesori`) VALUES ('Siguri e te dhenave', '5', 'Blerim Rexha');
INSERT INTO `dbknk`.`Lendet` (`Lenda`, `ECTS`, `Profesori`) VALUES ('Rrjeta Kompjuterike', '5', 'Blerim Rexha');
INSERT INTO `dbknk`.`Lendet` (`Lenda`, `ECTS`, `Profesori`) VALUES ('Programimi ne Internet', '5', 'Valon Raca');
INSERT INTO `dbknk`.`Lendet` (`Lenda`, `ECTS`, `Profesori`) VALUES ('Arkitektura e Kompjutereve', '5', 'Valon Raca');
INSERT INTO `dbknk`.`Lendet` (`Lenda`, `ECTS`, `Profesori`) VALUES ('Komunikimi njeri-kompjuter', '5', 'Isak Shabani');
INSERT INTO `dbknk`.`Lendet` (`Lenda`, `ECTS`, `Profesori`) VALUES ('Menaxhim i Projekteve', '5', 'Sevdije Alshiqi');


