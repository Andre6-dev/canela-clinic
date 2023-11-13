-- ROLES
INSERT INTO roles (name, created_at, last_modified_at)
VALUES
    ('ADMIN', now(), now()),
    ('VETERINARY', now(), now()),
    ('ADMINISTRATIVE', now(), now());


-- USERS
INSERT INTO users (created_at, last_modified_at, username, password, enabled)
VALUES
    (now(), now(), 'admin@gmail.com', 'adminpass', TRUE),
    (now(), now(), 'veterinary1@gmail.com', 'veterinary1pass', TRUE),
    (now(), now(), 'veterinary2@gmail.com', 'veterinary2pass',TRUE),
    (now(), now(), 'administrative@gmail.com', 'administrativepass', FALSE);

-- USERS-ROLES

INSERT INTO user_roles (role_id, user_id)
VALUES
    (1, 1),
    (2, 2),
    (2, 3),
    (3, 4);

-- CATEGORIES FOR MEDICINES
INSERT INTO categories_medicines (created_at, last_modified_at, name)
VALUES
    (now(), now(), 'Antibiotics'),
    (now(), now(), 'Anti-inflammatory'),
    (now(), now(), 'Pain Relief'),
    (now(), now(), 'Antiparasitic'),
    (now(), now(), 'Heartworm Prevention'),
    (now(), now(), 'Dewormers'),
    (now(), now(), 'Vitamins and Supplements'),
    (now(), now(), 'Dental Care'),
    (now(), now(), 'Flea and Tick Control'),
    (now(), now(), 'Joint Health'),
    (now(), now(), 'Allergy Relief'),
    (now(), now(), 'Digestive Health');

-- MEDICINE STOCKS
INSERT INTO medicine_stocks (
    created_at,
    last_modified_at,
    quantity,
    expiration_date
) VALUES
      (CURRENT_TIMESTAMP, NULL, 100, '2024-01-31'),
      (CURRENT_TIMESTAMP, NULL, 50, '2023-12-15'),
      (CURRENT_TIMESTAMP, NULL, 75, '2024-02-28'),
      (CURRENT_TIMESTAMP, NULL, 30, '2023-11-30'),
      (CURRENT_TIMESTAMP, NULL, 60, '2024-03-15'),
      (CURRENT_TIMESTAMP, NULL, 40, '2023-12-31'),
      (CURRENT_TIMESTAMP, NULL, 25, '2024-04-30'),
      (CURRENT_TIMESTAMP, NULL, 45, '2023-11-15'),
      (CURRENT_TIMESTAMP, NULL, 80, '2024-05-31'),
      (CURRENT_TIMESTAMP, NULL, 35, '2023-12-01');

-- MEDICINES
INSERT INTO medicines (
    created_at,
    last_modified_at,
    name,
    description,
    laboratory,
    label_volume,
    quantity_per_stock,
    manufacturer,
    supplier,
    label_whole,
    label_stock,
    price,
    category_id,
    stock_id
) VALUES
      (CURRENT_TIMESTAMP, NULL, 'Amoxicillin', 'Broad-spectrum antibiotic for pets', 'Pfizer Laboratories', '50ml', 30, 'Pfizer', 'Pet Pharmacy', 'Amoxicillin Label', 'Amoxicillin Stock', 15.99, 1, 1),
      (CURRENT_TIMESTAMP, NULL, 'Rimadyl', 'Non-steroidal anti-inflammatory drug', 'Bayer Laboratories', '75ml', 25, 'Bayer', 'Vet Supply Co.', 'Rimadyl Label', 'Rimadyl Stock', 29.99, 2, 2),
      (CURRENT_TIMESTAMP, NULL, 'Tramadol', 'Pain relief medication for pets', 'Novartis', '60ml', 20, 'Novartis', 'Pet Meds Ltd.', 'Tramadol Label', 'Tramadol Stock', 19.99, 3, 3),
      (CURRENT_TIMESTAMP, NULL, 'Heartgard', 'Heartworm prevention tablets', 'Merial', '10 tablets', 10, 'Merial', 'Pet Health Solutions', 'Heartgard Label', 'Heartgard Stock', 45.99, 5, 5),
      (CURRENT_TIMESTAMP, NULL, 'Drontal', 'Broad-spectrum dewormer for pets', 'Bayer Laboratories', '6 tablets', 6, 'Bayer', 'Vet Supply Co.', 'Drontal Label', 'Drontal Stock', 14.99, 6, 6),
      (CURRENT_TIMESTAMP, NULL, 'Nutri-Vet', 'Vitamins and Supplements', 'Nutri-Vet', '120ml', 60, 'Nutri-Vet', 'Pet Nutrition Co.', 'Nutri-Vet Label', 'Nutri-Vet Stock', 24.99, 7, 7),
      (CURRENT_TIMESTAMP, NULL, 'CET Toothpaste', 'Dental Care for pets', 'Virbac', '100g', 40, 'Virbac', 'Dental Health Inc.', 'CET Toothpaste Label', 'CET Toothpaste Stock', 12.99, 8, 8),
      (CURRENT_TIMESTAMP, NULL, 'Frontline Plus', 'Flea and Tick Control', 'Merial', '3 doses', 3, 'Merial', 'Flea & Tick Supplies', 'Frontline Plus Label', 'Frontline Plus Stock', 39.99, 9, 9),
      (CURRENT_TIMESTAMP, NULL, 'Cosequin', 'Joint Health Supplement', 'Nutramax Laboratories', '90 tablets', 30, 'Nutramax', 'Joint Health Co.', 'Cosequin Label', 'Cosequin Stock', 34.99, 10, 10);

-- EMPLOYEES
INSERT INTO employees (
    first_name,
    last_name,
    email,
    phone,
    address,
    profile_photo,
    birth_date,
    gender,
    type_employee,
    legend_color
) VALUES
      ('John', 'Doe', 'john.doe@example.com', '555-1234', '123 Main St, Cityville', 'john_doe.jpg', '1985-05-15', 'MALE', 'VETERINARY', 'Blue'),
      ('Jane', 'Smith', 'jane.smith@example.com', '555-5678', '456 Oak St, Townsville', 'jane_smith.jpg', '1990-08-22', 'FEMALE', 'ASSISTANT', 'Green'),
      ('Robert', 'Johnson', 'robert.johnson@example.com', '555-9876', '789 Pine St, Villagetown', 'robert_johnson.jpg', '1988-03-10', 'MALE', 'VETERINARY', 'Red'),
      ('Emily', 'Brown', 'emily.brown@example.com', '555-4321', '101 Cedar St, Hamletsville', 'emily_brown.jpg', '1995-11-03', 'FEMALE', 'ADMINISTRATIVE', 'Yellow'),
      ('Michael', 'Davis', 'michael.davis@example.com', '555-8766', '202 Elm St, Suburbia', 'michael_davis.jpg', '1980-12-18', 'MALE', 'VETERINARY', 'Purple'),
      ('Olivia', 'Wilson', 'olivia.wilson@example.com', '555-2345', '303 Maple St, Ruralville', 'olivia_wilson.jpg', '1993-09-27', 'FEMALE', 'ASSISTANT', 'Orange'),
      ('William', 'White', 'william.white@example.com', '555-6789', '404 Birch St, Countryside', 'william_white.jpg', '1983-06-08', 'MALE', 'ADMINISTRATIVE', 'Pink'),
      ('Sophia', 'Jones', 'sophia.jones@example.com', '555-3456', '505 Redwood St, Outskirts', 'sophia_jones.jpg', '1997-04-14', 'FEMALE', 'VETERINARY', 'Brown'),
      ('Daniel', 'Miller', 'daniel.miller@example.com', '555-8765', '606 Pine St, Farmland', 'daniel_miller.jpg', '1982-01-25', 'MALE', 'ASSISTANT', 'Gray'),
      ('Ava', 'Taylor', 'ava.taylor@example.com', '555-5432', '707 Oak St, Countryside', 'ava_taylor.jpg', '1998-07-09', 'FEMALE', 'ADMINISTRATIVE', 'Teal');

-- SCHEDULES
INSERT INTO schedules (
    title,
    time_start,
    time_end,
    employee_id
) VALUES
      ('Pet Check-up', '2023-11-10 09:00:00', '2023-11-10 12:00:00', 1), -- John Doe
      ('Pet Surgery', '2023-11-10 13:30:00', '2023-11-10 17:00:00', 3), -- Robert Johnson
      ('Vaccination Clinic', '2023-11-11 10:00:00', '2023-11-11 12:30:00', 5), -- Michael Davis
      ('Wellness Check', '2023-11-11 14:00:00', '2023-11-11 16:30:00', 8), -- Sophia Jones
      ('Emergency Care', '2023-11-12 08:00:00', '2023-11-12 11:30:00', 1), -- John Doe
      ('Dental Health Session', '2023-11-12 13:00:00', '2023-11-12 16:00:00', 3), -- Robert Johnson
      ('Ultrasound Session', '2023-11-13 11:00:00', '2023-11-13 13:30:00', 5), -- Michael Davis
      ('X-ray for Pets', '2023-11-13 15:00:00', '2023-11-13 17:00:00', 8), -- Sophia Jones
      ('Pet Consultation', '2023-11-14 09:30:00', '2023-11-14 12:30:00', 1), -- John Doe
      ('Pet Surgery', '2023-11-14 14:00:00', '2023-11-14 18:00:00', 3); -- Robert Johnson

-- CLIENTS
INSERT INTO clients (
    first_name,
    last_name,
    email,
    phone,
    address,
    profile_photo,
    birth_date,
    gender,
    dni,
    status
) VALUES
      ('Alice', 'Johnson', 'alice.johnson@example.com', '555-1234', '123 Oak St, Cityville', 'alice_johnson.jpg', '1980-06-15', 'FEMALE', '12345678', 'ACTIVE'),
      ('Bob', 'Smith', 'bob.smith@example.com', '555-5678', '456 Maple St, Townsville', 'bob_smith.jpg', '1975-09-22', 'MALE', '87654321', 'ACTIVE'),
      ('Charlie', 'Davis', 'charlie.davis@example.com', '555-9876', '789 Pine St, Villagetown', 'charlie_davis.jpg', '1982-03-10', 'MALE', '23456789', 'ACTIVE'),
      ('Diana', 'Wilson', 'diana.wilson@example.com', '555-4321', '101 Elm St, Hamletsville', 'diana_wilson.jpg', '1970-11-03', 'FEMALE', '34567890', 'ACTIVE'),
      ('Edward', 'Miller', 'edward.miller@example.com', '555-8765', '202 Cedar St, Suburbia', 'edward_miller.jpg', '1985-12-18', 'MALE', '45678901', 'ACTIVE'),
      ('Fiona', 'Taylor', 'fiona.taylor@example.com', '555-2345', '303 Birch St, Ruralville', 'fiona_taylor.jpg', '1978-09-27', 'FEMALE', '56789012', 'ACTIVE'),
      ('George', 'White', 'george.white@example.com', '555-6789', '404 Oak St, Countryside', 'george_white.jpg', '1988-06-08', 'MALE', '67890123', 'ACTIVE'),
      ('Helen', 'Jones', 'helen.jones@example.com', '555-3456', '505 Redwood St, Outskirts', 'helen_jones.jpg', '1975-04-14', 'FEMALE', '78901234', 'ACTIVE'),
      ('Ivan', 'Brown', 'ivan.brown@example.com', '555-8768', '606 Pine St, Farmland', 'ivan_brown.jpg', '1983-01-25', 'MALE', '89012345', 'ACTIVE'),
      ('Julia', 'Smith', 'julia.smith@example.com', '555-5432', '707 Cedar St, Countryside', 'julia_smith.jpg', '1990-07-09', 'FEMALE', '90123456', 'ACTIVE');

-- PETS
INSERT INTO pets (
    created_at,
    last_modified_at,
    name,
    breed,
    color,
    species,
    birth_date,
    gender,
    microchip_id,
    weight,
    next_visit,
    photo_url,
    client_id
) VALUES
      ('2023-01-15 10:00:00', NULL, 'Buddy', 'Labrador Retriever', 'Golden', 'Dog', '2019-05-20', 'MALE', '123456789', 25.0, '2023-11-15', 'buddy_photo.jpg', 1),
      ('2022-12-05 14:30:00', NULL, 'Mittens', 'Persian', 'White', 'Cat', '2020-07-10', 'FEMALE', '987654321', 8.5, '2023-01-10', 'mittens_photo.jpg', 2),
      ('2023-02-20 09:45:00', NULL, 'Rocky', 'German Shepherd', 'Black and Tan', 'Dog', '2021-01-03', 'MALE', '456123789', 30.2, '2023-12-20', 'rocky_photo.jpg', 3),
      ('2023-03-10 16:20:00', NULL, 'Whiskers', 'Siamese', 'Cream', 'Cat', '2018-11-15', 'MALE', '789123456', 10.5, '2023-11-10', 'whiskers_photo.jpg', 4),
      ('2022-11-08 11:10:00', NULL, 'Daisy', 'Beagle', 'Tri-color', 'Dog', '2020-04-25', 'FEMALE', '321987654', 18.7, '2023-01-08', 'daisy_photo.jpg', 5),
      ('2023-04-05 13:45:00', NULL, 'Fluffy', 'Ragdoll', 'Blue Bicolor', 'Cat', '2019-08-12', 'FEMALE', '654321987', 12.0, '2023-12-05', 'fluffy_photo.jpg', 1),
      ('2023-05-15 08:30:00', NULL, 'Max', 'Golden Retriever', 'Cream', 'Dog', '2020-02-18', 'MALE', '789456123', 28.3, '2023-05-15', 'max_photo.jpg', 2),
      ('2023-06-20 14:15:00', NULL, 'Luna', 'Maine Coon', 'Silver Tabby', 'Cat', '2018-09-05', 'FEMALE', '123789456', 14.5, '2023-12-20', 'luna_photo.jpg', 3),
      ('2022-10-12 10:45:00', NULL, 'Charlie', 'Shih Tzu', 'White and Brown', 'Dog', '2019-04-01', 'MALE', '987654321', 15.8, '2023-01-12', 'charlie_photo.jpg', 4),
      ('2023-07-01 09:30:00', NULL, 'Oreo', 'Domestic Shorthair', 'Black and White', 'Cat', '2020-11-20', 'FEMALE', '456789123', 11.2, '2023-12-01', 'oreo_photo.jpg', 6);

-- PROCEDURES
INSERT INTO procedures (
    created_date,
    medical_procedure,
    remarks,
    next_due_date,
    status,
    weight,
    pet_id,
    employee_id
) VALUES
      ('2023-11-10 10:30:00', 'Vaccination', 'Routine vaccination for dog', '2023-12-10', 'COMPLETED', 12.5, 1, 1), -- John Doe
      ('2023-11-10 14:45:00', 'Spaying', 'Female cat, 2 years old', '2023-11-15', 'PENDING', 4.3, 2, 3), -- Robert Johnson
      ('2023-11-11 11:15:00', 'Dental Cleaning', 'Routine dental cleaning for dog', '2024-05-11', 'SCHEDULED', 18.7, 3, 5), -- Michael Davis
      ('2023-11-11 15:30:00', 'Annual Check-up', 'Overall health examination for cat', '2023-11-11', 'COMPLETED', 8.2, 4, 8), -- Sophia Jones
      ('2023-11-12 09:00:00', 'Emergency Care', 'Injured dog, broken leg', NULL, 'PENDING', 25.0, 5, 1), -- John Doe
      ('2023-11-12 14:00:00', 'Tooth Extraction', 'Extracting a decayed tooth from a dog', '2023-11-17', 'SCHEDULED', 22.6, 6, 3), -- Robert Johnson
      ('2023-11-13 12:00:00', 'Ultrasound Scan', 'Pregnancy check for a dog', NULL, 'PENDING', 15.3, 7, 5), -- Michael Davis
      ('2023-11-13 16:15:00', 'X-ray for Broken Leg', 'Injured cat with a suspected broken leg', '2023-11-13', 'COMPLETED', 7.8, 8, 8), -- Sophia Jones
      ('2023-11-14 10:45:00', 'Skin Allergy Test', 'Checking for skin allergies in a dog', '2023-11-21', 'SCHEDULED', 14.0, 9, 1), -- John Doe
      ('2023-11-14 15:30:00', 'Orthopedic Surgery', 'Corrective surgery for a dog with hip dysplasia', NULL, 'PENDING', 30.5, 10, 3); -- Robert Johnson

-- INVOICES
INSERT INTO invoices (
    created_at,
    last_modified_at,
    number,
    total_amount,
    client_id,
    pet_id,
    medical_procedure_id
) VALUES
      ('2023-11-20 10:30:00', NULL, 'INV20231120001', 150.00, 1, 1, 1), -- Invoice for Buddy's vaccination by John Doe
      ('2023-11-21 14:45:00', NULL, 'INV20231121002', 450.00, 2, 2, 2), -- Invoice for Mittens' spaying by Robert Johnson
      ('2023-11-22 11:15:00', NULL, 'INV20231122003', 120.00, 3, 3, 3), -- Invoice for Rocky's dental cleaning by Michael Davis
      ('2023-11-23 15:30:00', NULL, 'INV20231123004', 80.00, 4, 4, 4),  -- Invoice for Whiskers' annual check-up by Sophia Jones
      ('2023-11-24 09:00:00', NULL, 'INV20231124005', 200.00, 5, 5, 5), -- Invoice for Emergency Care for John Doe
      ('2023-11-25 14:00:00', NULL, 'INV20231125006', 120.00, 1, 6, 6), -- Invoice for Tooth Extraction for Robert Johnson
      ('2023-11-26 12:00:00', NULL, 'INV20231126007', 150.00, 2, 7, 7), -- Invoice for Luna's ultrasound by Michael Davis
      ('2023-11-27 16:15:00', NULL, 'INV20231127008', 100.00, 3, 8, 8), -- Invoice for X-ray for Broken Leg by Sophia Jones
      ('2023-11-28 10:45:00', NULL, 'INV20231128009', 80.00, 4, 9, 9),  -- Invoice for Skin Allergy Test for John Doe
      ('2023-11-29 15:30:00', NULL, 'INV20231129010', 350.00, 5, 10, 10); -- Invoice for Orthopedic Surgery for Robert Johnson



