--
-- PostgreSQL database dump
--

-- Dumped from database version 12.4
-- Dumped by pg_dump version 12.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: producto; Type: TABLE; Schema: public; Owner: kikoyo_user
--

CREATE TABLE public.producto (
    producto_id integer NOT NULL,
    nombre character varying(100),
    precio character varying(12),
    marca character varying(150),
    estatus smallint DEFAULT 1 NOT NULL
);


ALTER TABLE public.producto OWNER TO kikoyo_user;

--
-- Name: producto_producto_id_seq; Type: SEQUENCE; Schema: public; Owner: kikoyo_user
--

CREATE SEQUENCE public.producto_producto_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.producto_producto_id_seq OWNER TO kikoyo_user;

--
-- Name: producto_producto_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: kikoyo_user
--

ALTER SEQUENCE public.producto_producto_id_seq OWNED BY public.producto.producto_id;


--
-- Name: usuario; Type: TABLE; Schema: public; Owner: kikoyo_user
--

CREATE TABLE public.usuario (
    usuario_id integer NOT NULL,
    nombre character varying(150),
    username character varying(150),
    pwd character varying(150),
    fecha_alta timestamp without time zone DEFAULT now() NOT NULL,
    usuario_alta bigint,
    email character varying(150),
    estatus smallint DEFAULT 1 NOT NULL
);


ALTER TABLE public.usuario OWNER TO kikoyo_user;

--
-- Name: usuario_usuario_id_seq; Type: SEQUENCE; Schema: public; Owner: kikoyo_user
--

CREATE SEQUENCE public.usuario_usuario_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.usuario_usuario_id_seq OWNER TO kikoyo_user;

--
-- Name: usuario_usuario_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: kikoyo_user
--

ALTER SEQUENCE public.usuario_usuario_id_seq OWNED BY public.usuario.usuario_id;


--
-- Name: producto producto_id; Type: DEFAULT; Schema: public; Owner: kikoyo_user
--

ALTER TABLE ONLY public.producto ALTER COLUMN producto_id SET DEFAULT nextval('public.producto_producto_id_seq'::regclass);


--
-- Name: usuario usuario_id; Type: DEFAULT; Schema: public; Owner: kikoyo_user
--

ALTER TABLE ONLY public.usuario ALTER COLUMN usuario_id SET DEFAULT nextval('public.usuario_usuario_id_seq'::regclass);


--
-- Data for Name: producto; Type: TABLE DATA; Schema: public; Owner: kikoyo_user
--

COPY public.producto (producto_id, nombre, precio, marca, estatus) FROM stdin;
1	Nombre	25.50	Marca	1
2	Celular	87.80	Samsung	0
\.


--
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: kikoyo_user
--

COPY public.usuario (usuario_id, nombre, username, pwd, fecha_alta, usuario_alta, email, estatus) FROM stdin;
1	riiicks	riiicks	$2a$10$9UxViPZUmxKhogs0VOIObO9V.ApbLan4LKrI172ccIo4AfiOuVgde	2021-09-03 02:17:28.146021	\N	test@test.com	1
2	riiicks	ricks	$2a$10$lol7Kkld.sRQGbjXJGEWW.gLRJVDd15I1xMMVXqL42wKs6hMNXvuO	2021-09-03 02:18:10.425354	\N	test@test.com	1
3	rocky	rocky	$2a$10$jxVdZFtN7kKJtJK0bB8yFOopSD9zfcH0RY3csXC3u7t1WSyXnrtI6	2021-09-03 02:24:35.090046	2	rocky@rocky.com	1
4	RobertA	robertA	$2a$10$AHCcRUEtXxrxSySyIiw7K.JVDvyFZjmofyQFrzhCMtzv3g58.0RWa	2021-09-03 02:37:46.815748	2	test@robert.com	0
5	riiicks1	ricks1	$2a$10$RTFuk0rfWlnsxOtgfiMkW.uyVdRiA7.afy4M7aKbKQKhTyIC7/PXq	2021-09-03 08:51:17.138501	\N	test1@test.com	1
7	Roberto1	robert1	$2a$10$cIJIZ3KbmZOJJioHTmZ/guHHHOi0KWlta4VXdL1LJPUdnF8FjCteW	2021-09-03 08:54:13.529947	5	robert1@robert.com	1
8	Arturo	artur	$2a$10$puHwjwhue3FNpSu684iR0Okgd0N1XFmQUkMzarUG0EqJfeLYPTUfK	2021-09-03 09:05:05.859563	\N	artur@artur.com	1
9	TEST	test	$2a$10$ayiqQYzZ9w7nNegir37NnuDIpn2mMxl9mdhELOGzH46dRScuHxKuG	2021-09-03 09:06:40.653252	8	test@test.com	0
\.


--
-- Name: producto_producto_id_seq; Type: SEQUENCE SET; Schema: public; Owner: kikoyo_user
--

SELECT pg_catalog.setval('public.producto_producto_id_seq', 2, true);


--
-- Name: usuario_usuario_id_seq; Type: SEQUENCE SET; Schema: public; Owner: kikoyo_user
--

SELECT pg_catalog.setval('public.usuario_usuario_id_seq', 9, true);


--
-- Name: producto producto_pk; Type: CONSTRAINT; Schema: public; Owner: kikoyo_user
--

ALTER TABLE ONLY public.producto
    ADD CONSTRAINT producto_pk PRIMARY KEY (producto_id);


--
-- Name: usuario usuario_pk; Type: CONSTRAINT; Schema: public; Owner: kikoyo_user
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pk PRIMARY KEY (usuario_id);


--
-- PostgreSQL database dump complete
--

