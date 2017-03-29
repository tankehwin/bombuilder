CREATE TABLE items_master ( -- this table lists all possible parts, both fittings and nodes
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  part_number VARCHAR(200) NOT NULL,
  category VARCHAR(100) NULL,
  description VARCHAR(500) NULL,
  item_class VARCHAR(30) NULL -- fitting,node
);

CREATE TABLE node_fitting_link ( -- this is how we connect the fittings to the nodes
	id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	node_id BIGINT NOT NULL,
	fitting_id BIGINT NOT NULL
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




		
