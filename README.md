# Spring Security Demo

## accounts app
`user:user`
`admin:admin`

## database
postgreSQL 
`db_name: spring`

```sql
create table if not exists users (
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

alter table users owner to postgres;

create unique index if not exists users_email_uindex
	on users (email);
```

```sql
INSERT INTO users ("id", "email", "first_name", "last_name", "password", "role", "status") VALUES (1, 'admin@mail.ru', 'admin', 'admin', '$2y$12$aBdQ6lkYRNbyyk4ZWywU8uNLRXGpYLRDRgJAzFag.MUWItPUkuQXu', 'ADMIN', 'ACTIVE')
INSERT INTO users ("id", "email", "first_name", "last_name", "password", "role", "status") VALUES (2, 'user@mail.ru', 'user', 'user', '$2y$12$wRKxf3Y9azwS.T16Pag6UOIFF5mxoWHwHF2nYcIykJ9wBMo0GIfo.', 'USER', 'BANNED')
```

https://bcrypt-generator.com/ for encode password
## jwt

https://www.jsonwebtoken.io/
```json
{
 "role":"admin",
 "email": "admin@mail.ru",
 "iat": 1614279964,
 "exp": 1614283564
}
```
```json
{
 "typ": "JWT",
 "alg": "HS256"
}
```
`Signing Key: oxi-mix`

### Request
POST http://localhost:8080/api/v1/auth/login
```json
{
    "email": "admin@mail.ru",
    "password": "admin"
}
```

for `user` change `status: ACTIVE`
```json
{
    "email": "user@mail.ru",
    "password": "user"
}
```

add request `header: Authorization; value: token`

https://www.base64decode.org/
