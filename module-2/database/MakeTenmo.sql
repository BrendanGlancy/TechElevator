--
-- This SQL will refresh the tenmo database for the module 2 capstone
--
-- Verify you are in correct database connection and database when you run this
--
-- Be sure the apireview database exists before you run this
-- if it doesn't: 
--    1. Open a Windows command prompt (NOT GitBash!)
--    2. Issue the command: createdb -U postgres tenmo
--       Note: You will be prompted for a password which will not display when you type
--             The password should be: postgres1  

BEGIN TRANSACTION;

DROP TABLE IF EXISTS transfers;
DROP TABLE IF EXISTS accounts;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS transfer_types;
DROP TABLE IF EXISTS transfer_statuses;

DROP SEQUENCE IF EXISTS seq_transfer_type_id;
DROP SEQUENCE IF EXISTS seq_transfer_status_id;
DROP SEQUENCE IF EXISTS seq_user_id;
DROP SEQUENCE IF EXISTS seq_account_id;
DROP SEQUENCE IF EXISTS seq_transfer_id;

drop USER if exists tenmo_owner; 

drop USER if exists tenmo_appuser;

CREATE SEQUENCE seq_transfer_type_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE SEQUENCE seq_transfer_status_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE SEQUENCE seq_account_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE SEQUENCE seq_transfer_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;


CREATE TABLE transfer_types (
	transfer_type_id int DEFAULT nextval('seq_transfer_type_id'::regclass) NOT NULL,
	transfer_type_desc varchar(10) NOT NULL,
	CONSTRAINT PK_transfer_types PRIMARY KEY (transfer_type_id)
);

CREATE TABLE transfer_statuses (
	transfer_status_id int DEFAULT nextval('seq_transfer_status_id'::regclass) NOT NULL,
	transfer_status_desc varchar(10) NOT NULL,
	CONSTRAINT PK_transfer_statuses PRIMARY KEY (transfer_status_id)
);

CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE accounts (
	account_id int DEFAULT nextval('seq_account_id'::regclass) NOT NULL,
	user_id int NOT NULL,
	balance decimal(13, 2) NOT NULL,
	CONSTRAINT PK_accounts PRIMARY KEY (account_id),
	CONSTRAINT FK_accounts_user FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE transfers (
	transfer_id int DEFAULT nextval('seq_transfer_id'::regclass) NOT NULL,
	transfer_type_id int NOT NULL,
	transfer_status_id int NOT NULL,
	account_from int NOT NULL,
	account_to int NOT NULL,
	amount decimal(13, 2) NOT NULL,
	CONSTRAINT PK_transfers PRIMARY KEY (transfer_id),
	CONSTRAINT FK_transfers_accounts_from FOREIGN KEY (account_from) REFERENCES accounts (account_id),
	CONSTRAINT FK_transfers_accounts_to FOREIGN KEY (account_to) REFERENCES accounts (account_id),
	CONSTRAINT FK_transfers_transfer_statuses FOREIGN KEY (transfer_status_id) REFERENCES transfer_statuses (transfer_status_id),
	CONSTRAINT FK_transfers_transfer_types FOREIGN KEY (transfer_type_id) REFERENCES transfer_types (transfer_type_id),
	CONSTRAINT CK_transfers_not_same_account CHECK  ((account_from<>account_to)),
	CONSTRAINT CK_transfers_amount_gt_0 CHECK ((amount>0))
);


INSERT INTO transfer_statuses (transfer_status_desc) VALUES ('Pending');
INSERT INTO transfer_statuses (transfer_status_desc) VALUES ('Approved');
INSERT INTO transfer_statuses (transfer_status_desc) VALUES ('Rejected');

INSERT INTO transfer_types (transfer_type_desc) VALUES ('Request');
INSERT INTO transfer_types (transfer_type_desc) VALUES ('Send');

INSERT INTO users (username,password_hash) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC');
INSERT INTO users (username,password_hash) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC');

INSERT INTO accounts (user_id,balance) VALUES (1,1000);
INSERT INTO accounts (user_id,balance) VALUES (2,1000);

-- ********************************************************************************
-- This script creates the database users and grants them the necessary permissions
-- ********************************************************************************

CREATE USER tenmo_owner
WITH PASSWORD 'tebucks';

GRANT ALL
ON ALL TABLES IN SCHEMA public
TO tenmo_owner;

GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO tenmo_owner;

CREATE USER tenmo_appuser
WITH PASSWORD 'tebucks';

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO tenmo_appuser;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO tenmo_appuser;

COMMIT TRANSACTION;
