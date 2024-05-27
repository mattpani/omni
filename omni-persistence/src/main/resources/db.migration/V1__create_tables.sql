-- this the initialization using flyway for database that can be run from docker compose file
-- it is necessary to use the standard naming conventions for sql scripts
-- flyway_schema_history is created automatically and is used for tracking the changes in migration schema for example by checksum
-- great tool over all, for easy project transfer

-- Create the Person table
CREATE TABLE Person (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    date_of_birth DATE
);

-- Create the Contact table for person and organization
CREATE TABLE Contact (
    id SERIAL PRIMARY KEY,
    phone_number VARCHAR(15),
    email VARCHAR(100),
    address VARCHAR(255),
    person_id INT,
    organization_id INT
);

-- Create the Organization table
CREATE TABLE Organization (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100)
);

-- Create the OrganizationPerson relation many to many
CREATE TABLE Organization_person (
    organization_id INT,
    person_id INT,
    PRIMARY KEY (organization_id, person_id)
);

-- Adding constraint to Contact
ALTER TABLE Contact
ADD CONSTRAINT fk_contact_person
FOREIGN KEY (person_id) REFERENCES Person(id),
ADD CONSTRAINT fk_contact_organization
FOREIGN KEY (organization_id) REFERENCES Organization(id);

-- Add constraints to OrganizationPerson
ALTER TABLE Organization_person
ADD CONSTRAINT fk_organization_person
FOREIGN KEY (organization_id) REFERENCES Organization(id),
ADD CONSTRAINT fk_person_organization_person
FOREIGN KEY (person_id) REFERENCES Person(id);