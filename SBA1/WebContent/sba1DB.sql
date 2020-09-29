DROP DATABASE sba1DB;

CREATE DATABASE sba1DB;

USE sba1DB;

CREATE TABLE products(
	pid int not null primary key,
	pname varchar(20) not null,
	pcost decimal not null,
	pdesc varchar(60)
);

INSERT INTO products VALUES
(1, "Face Mask", "30.0", "Reusable Cotton Face Mask"),
(2, "Sanitizer", "100.0", "Alchohol based sanitizer"),
(3, "Remidesivir", "5000.0", "Immunity boosting medicine");