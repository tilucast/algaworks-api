create table delivery(
	id BIGSERIAL,
	client_id bigint not null,
	fee NUMERIC not null,
	status varchar(20) not null,
	request_date timestamptz not null,
	delivered_date timestamptz not null,
	
	receiver_name varchar(60) not null,
	receiver_address varchar(255) not null,
	receiver_address_number varchar(10),
	
	primary key(id),
	CONSTRAINT fk_client FOREIGN KEY (client_id) REFERENCES client(id)
)