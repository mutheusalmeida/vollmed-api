CREATE TABLE doctors(
  id BIGINT NOT NULL AUTO_INCREMENT, 
  name VARCHAR(100) NOT NULL, 
  email VARCHAR(100) NOT NULL UNIQUE, 
  phone VARCHAR(20) NOT NULL, 
  crm VARCHAR(6) NOT NULL UNIQUE, 
  specialty VARCHAR(100) NOT NULL, 
  street VARCHAR(100) NOT NULL, 
  number VARCHAR(20), 
  complement VARCHAR(100), 
  district VARCHAR(100) NOT NULL, 
  city VARCHAR(100) NOT NULL, 
  state VARCHAR(100) NOT NULL, 
  zip_code VARCHAR(9) NOT NULL, 

  PRIMARY KEY(id)
);