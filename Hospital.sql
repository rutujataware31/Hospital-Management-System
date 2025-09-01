-- Hospital Management Database Dump
-- Combined file for patients, doctors, appointments

DROP DATABASE IF EXISTS hospital;
CREATE DATABASE hospital;
USE hospital;

-- -------------------------------
-- Table: patients
-- -------------------------------

create table Patients(
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(255) NOT NULL,
age INT NOT NULL,
gender VARCHAR(10) NOT NULL )

-- -------------------------------
-- Table: doctors
-- -------------------------------

create table Doctors(
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(255) NOT NULL,
dept VARCHAR(255) NOT NULL);

-- -------------------------------
-- Table: appointments
-- -------------------------------

create table Appointments(
id INT AUTO_INCREMENT PRIMARY KEY,
pat_id INT NOT NULL,
doc_id INT NOT NULL,
appointment_date DATE NOT NULL,
foreign key (pat_id) REFERENCES Patients(id),
foreign key (doc_id) REFERENCES Doctors(id)
);


show tables;


-- -------------------------------
-- Sample Data
-- -------------------------------

-- Doctors

INSERT INTO Doctors (name, dept) VALUES 
('Rutuja Taware', 'Physician'),
('Ruchika Taware', 'Neurosurgeon');

-- Patients


INSERT INTO Patients (name, age, gender) VALUES 
('Alex', 20, 'Male'),
('Joy', 22, 'Male'),
('Milli', 18, 'Female');

-- Appointments
INSERT INTO Appointments (pat_id, doc_id, appointment_date) VALUES
(1, 1, '2025-09-01'),
(2, 2, '2025-09-02');