-- Insert addresses
INSERT INTO address (id, city, address_line1, address_line2, postal_code) VALUES
(1, 'CityA', 'Street 1', 'Apt 1', '10001'),
(2, 'CityB', 'Street 2', 'Apt 2', '10002'),
(3, 'CityC', 'Street 3', 'Apt 3', '10003'),
(4, 'CityD', 'Street 4', 'Apt 4', '10004'),
(5, 'CityE', 'Street 5', 'Apt 5', '10005'),
(6, 'CityF', 'Street 6', 'Apt 6', '10006'),
(7, 'CityG', 'Street 7', 'Apt 7', '10007'),
(8, 'CityH', 'Street 8', 'Apt 8', '10008'),
(9, 'CityI', 'Street 9', 'Apt 9', '10009'),
(10, 'CityJ', 'Street 10', 'Apt 10', '10010'),
(11, 'CityK', 'Street 11', 'Apt 11', '10011'),
(12, 'CityL', 'Street 12', 'Apt 12', '10012'),
(13, 'CityM', 'Street 13', 'Apt 13', '10013'),
(14, 'CityN', 'Street 14', 'Apt 14', '10014'),
(15, 'CityO', 'Street 15', 'Apt 15', '10015');

-- Insert doctors
INSERT INTO doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization, address_id) VALUES
(1, 'John', 'Doe', '123456789', 'john.doe@example.com', 'DOC001', 'CARDIOLOGY', 1),
(2, 'Jane', 'Smith', '987654321', 'jane.smith@example.com', 'DOC002', 'NEUROLOGY', 2),
(3, 'Alan', 'Turing', '555555555', 'alan.turing@example.com', 'DOC003', 'DERMATOLOGY', 3),
(4, 'Marie', 'Curie', '666666666', 'marie.curie@example.com', 'DOC004', 'ONCOLOGY', 4),
(5, 'Albert', 'Einstein', '777777777', 'albert.einstein@example.com', 'DOC005', 'RADIOLOGY', 5);

-- Insert patients
INSERT INTO patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id, is_male) VALUES
(1, 'Alice', 'Brown', '111222333', 'alice.brown@example.com', 'PAT001', '1985-05-10', 6, false),
(2, 'Bob', 'Green', '444555666', 'bob.green@example.com', 'PAT002', '1990-08-20', 7, true),
(3, 'Charlie', 'White', '555555555', 'charlie.white@example.com', 'PAT003', '1970-02-15', 8, true),
(4, 'Diana', 'Prince', '666666666', 'diana.prince@example.com', 'PAT004', '1995-11-25', 9, false),
(5, 'Eve', 'Black', '777777777', 'eve.black@example.com', 'PAT005', '1988-03-30', 10, false);

-- Insert visits
INSERT INTO visit (id, description, time, doctor_id, patient_id) VALUES
(1, 'Routine check-up', '2025-01-03 10:00:00', 1, 1),
(2, 'Follow-up consultation', '2025-01-04 15:30:00', 2, 2),
(3, 'Skin treatment', '2025-01-05 09:00:00', 3, 3),
(4, 'Cancer diagnosis', '2025-01-06 11:00:00', 4, 4),
(5, 'X-ray examination', '2025-01-07 14:00:00', 5, 5);

-- Insert medical treatments
INSERT INTO medical_treatment (id, description, type, visit_id) VALUES
(1, 'Blood pressure monitoring', 'BASIC', 1),
(2, 'MRI scan', 'ADVANCED', 2),
(3, 'Skin biopsy', 'BASIC', 3),
(4, 'Chemotherapy session', 'ADVANCED', 4),
(5, 'Fracture diagnosis', 'BASIC', 5);
