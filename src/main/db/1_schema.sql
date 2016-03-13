--- creates an athletes_id_seq sequence which is owned by the athletes.id (dropping the table also drop the sequence)
CREATE TABLE athletes (
  id BIGSERIAL,
	first_name varchar(255) not null,
	last_name varchar(255) not null,
	PRIMARY KEY (id)
);