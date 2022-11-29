<!-- hsqldb URL -->
jdbc:hsqldb:hsql://localhost/oneDB

<!-- for creating user table -->
CREATE TABLE USER
(
id INTEGER IDENTITY, 
name VARCHAR(32) NOT NULL,
email VARCHAR(32) NOT NULL,
password VARCHAR(32) NOT NULL
);

<!-- for creating grade table -->
CREATE TABLE GRADES
(
id INTEGER IDENTITY,
year VARCHAR(32) NOT NULL,
module VARCHAR(32) NOT NULL,
grade VARCHAR(32) NOT NULL
);