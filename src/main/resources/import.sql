use FilmeDB;

INSERT INTO address(creationTimestamp, nr, postalCode, street) VALUES (NOW(), 111, 123456, 'Strada 2');
INSERT INTO address(creationTimestamp, nr, postalCode, street) VALUES (NOW(), 112, 123457, 'Strada 3');
INSERT INTO user(creationTimestamp, name, address_id) VALUES (NOW(), 'Lucian', 1); 
