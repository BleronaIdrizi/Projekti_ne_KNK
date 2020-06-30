DROP DATABASE IF EXISTS KNK_Databaze;
CREATE DATABASE KNK_Databaze;
USE KNK_Databaze;

CREATE TABLE Student (
Nr_ID VARCHAR(12),
S_Emri VARCHAR(20) NOT NULL,
S_Mbiemri VARCHAR(20) NOT NULL,
Fakulteti VARCHAR(30) NOT NULL,
Departamenti VARCHAR(30) NOT NULL,
Datelindja VARCHAR(20) NOT NULL,
Filloi_Studimet VARCHAR(20) NOT NULL,
Mbaroi_Studimet VARCHAR(20)NOT NULL,
Titulli VARCHAR(70) NOT NULL DEFAULT 'Bachelor Student',
PRIMARY KEY (Nr_ID));

CREATE TABLE Profesor (
Profesori VARCHAR(20),
Prof_Password VARCHAR(20) NOT NULL,
PRIMARY KEY (Profesor));

CREATE TABLE Lendet (
Lenda VARCHAR(30) NOT NULL,
ECTS INT NOT NULL,
Profesor VARCHAR(20) NOT NULL,
PRIMARY KEY(Lenda));

CREATE TABLE Login (
Nr_ID VARCHAR(12),
Stud_Password VARCHAR(20) NOT NULL,
FOREIGN KEY (Nr_ID) REFERENCES Student(Nr_ID),
PRIMARY KEY(Nr_ID));

CREATE TABLE Notat (
Nr_ID VARCHAR(50) NOT NULL,
Lenda VARCHAR(30) NOT NULL,
ECTS INT NOT NULL,
Profesor VARCHAR(20) NOT NULL,
Nota INT NOT NULL,
FOREIGN KEY (Nr_ID) REFERENCES Student(Nr_ID),
FOREIGN KEY (Profesor) REFERENCES Profesor(Profesor));

CREATE TABLE Vit (
Viti VARCHAR(30) NOT NULL,
Nr_ID VARCHAR(50) NOT NULL,
Lenda VARCHAR(30) NOT NULL,
ECTS INT NOT NULL,
Profesor VARCHAR(20) NOT NULL,
FOREIGN KEY (Nr_ID) REFERENCES Student(Nr_ID),
FOREIGN KEY (Notat) REFERENCES Notat(Notat),
FOREIGN KEY (Profesor) REFERENCES Profesor(Profesor));

INSERT INTO `KNK_Databaze`.`Lendet` (`Viti`,`Lenda`, `ECTS`, `Profesor`) VALUES ('1','Matematika 1', '8', 'Valdete Hamiti');
INSERT INTO `KNK_Databaze`.`Lendet` (`Viti`,`Lenda`, `ECTS`, `Profesor`) VALUES ('1','Bazat e Elektroteknikes', '8', 'Luan Ahma');
INSERT INTO `KNK_Databaze`.`Lendet` (`Viti`,`Lenda`, `ECTS`, `Profesor`) VALUES ('1','Fizika 1', '9', 'Skender Ahmetaj');
INSERT INTO `KNK_Databaze`.`Lendet` (`Viti`,`Lenda`, `ECTS`, `Profesor`) VALUES ('1','Gjuhe Programuese', '8', 'Avni Rexhepi');
INSERT INTO `KNK_Databaze`.`Lendet` (`Viti`,`Lenda`, `ECTS`, `Profesor`) VALUES ('1','Qarqe Digjitale', '7', 'Sabrije Osmanaj');
INSERT INTO `KNK_Databaze`.`Lendet` (`Viti`,`Lenda`, `ECTS`, `Profesor`) VALUES ('1','Anglisht', '9', 'Gazmend Pula');
INSERT INTO `KNK_Databaze`.`Lendet` (`Viti`,`Lenda`, `ECTS`, `Profesor`) VALUES ('1','Matematika 2', '7', 'Valdete Hamiti');
INSERT INTO `KNK_Databaze`.`Lendet` (`Viti`,`Lenda`, `ECTS`, `Profesor`) VALUES ('1','Fizika 2', '8', 'Skender Ahmetaj');
INSERT INTO `KNK_Databaze`.`Lendet` (`Viti`,`Lenda`, `ECTS`, `Profesor`) VALUES ('1','Qarqe Elektrike', '7', 'Luan Ahma');
INSERT INTO `KNK_Databaze`.`Lendet` (`Viti`,`Lenda`, `ECTS`, `Profesor`) VALUES ('1','Algoritmet dhe Struktura e Te Dhenave', '9', 'Avni Rexhepi');

