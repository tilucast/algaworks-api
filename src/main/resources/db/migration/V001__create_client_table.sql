create table client( 
	id SERIAL PRIMARY KEY, 
	name varchar(255) not null,
	phone varchar(20) not null,
	email varchar(255) not null
)