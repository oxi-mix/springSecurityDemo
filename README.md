# Spring Security Demo

##accounts app
`user:user`
`admin:admin`

##database
postgreSQL 
`db_name: spring`

```sql
create table if not exists spring.users (
	id bigserial not null
		constraint users_pk  
                primary key,
	email varchar(255) not null,
	first_name varchar(255),
	last_name varchar(100),
	password varchar(255) not null,
	role varchar(20) default 'USER'::character varying not null,
	status varchar(20) default 'ACTIVE'::character varying not null
);

alter table spring.users owner to postgres;

create unique index if not exists users_email_uindex
	on spring.users (email);
```

```sql
INSERT INTO "spring"."users" ("id", "email", "first_name", "last_name", "password", "role", "status") VALUES (1, 'admin@mail.ru', 'admin', 'admin', '$2y$12$aBdQ6lkYRNbyyk4ZWywU8uNLRXGpYLRDRgJAzFag.MUWItPUkuQXu', 'ADMIN', 'ACTIVE')
INSERT INTO "spring"."users" ("id", "email", "first_name", "last_name", "password", "role", "status") VALUES (2, 'user@mail.ru', 'user', 'user', '$2y$12$YhdE77/yehDKezWBN9WyqeMTp4Dqvgy0aRAWjXVtbvsnSW2QjWniO', 'USER', 'BANNED')
```