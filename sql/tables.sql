CREATE TABLE items_master ( -- this table lists all possible parts, both fittings and nodes
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  part_number VARCHAR(200) NOT NULL,
  description VARCHAR(500) NULL,
  item_class VARCHAR(30) NULL -- fitting,node
)
ENGINE = InnoDB;

CREATE TABLE connectors_master ( -- this table lists all possible end connectors for fittings and nodes
	id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(200) NOT NULL,
);

CREATE TABLE connectors_items_link ( -- each part will have at least one entry here, listing the end connectors for it and direction (input/output)
	id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	items_id BIGINT NOT NULL,
	connectors_id BIGINT NOT NULL,
	direction int NOT NULL -- 1=input,2=output
);

CREATE TABLE connectors_match ( -- list all connectors and their matching connecting parts. may include duplicates (in terms of switching the combinations about between root and matching connectors)
	id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	root_connector_id BIGINT NOT NULL,
	matching_connector_id BIGINT NOT NULL
);

CREATE TABLE working_chain ( -- this builds the persistent chain flow, in recursive fashion. the table is emptied of user's chain objects whenever user wants to create a new chain
	id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	items_id BIGINT NOT NULL,
	label varchar(100) NOT NULL, -- user defines this for easy and logical identification later
	parent_id BIGINT NOT NULL, -- this refers to this table's id field - allows 1-to-N relationships. root chain objects have id of 0
	login_id BIGINT NOT NULL -- allows each user to have their own persistent work
);

CREATE TABLE login_master (
	id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name varchar(20),
	password varchar(30),
	acc_type varchar(10),
	date_created datetime,
	date_updated datetime
);

CREATE TABLE general_config_master (
	id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name varchar(50),
	contents varchar(500)
);

insert into login_master(name,password,acc_type,date_created,date_updated)values('admin','admin','admin',now(),now());
insert into login_master(name,password,acc_type,date_created,date_updated)values('normal','normal','normal',now(),now());




		
