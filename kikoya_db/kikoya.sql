-- Drop table

-- DROP TABLE kikoya.producto;

CREATE TABLE kikoya.producto (
	producto_id serial4 NOT NULL,
	nombre varchar(100) NULL,
	precio varchar(12) NULL,
	marca varchar(150) NULL,
	CONSTRAINT producto_pk PRIMARY KEY (producto_id)
);


-- kikoya.usuario definition

-- Drop table

-- DROP TABLE kikoya.usuario;

CREATE TABLE kikoya.usuario (
	usuario_id serial4 NOT NULL,
	nombre varchar(150) NULL,
	username varchar(150) NULL,
	pwd varchar(150) NULL,
	CONSTRAINT usuario_pk PRIMARY KEY (usuario_id)
);