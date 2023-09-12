ALTER TABLE clients ADD active TINYINT;
UPDATE clients SET active = 1;