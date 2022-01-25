--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.0
-- Dumped by pg_dump version 9.3.0
-- Started on 2019-12-11 15:19:20

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET search_path = public, pg_catalog;

--
-- TOC entry 2146 (class 0 OID 98786)
-- Dependencies: 175
-- Data for Name: marca; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO marca (codmarca, nombmarca) VALUES (1, 'Toyota');
INSERT INTO marca (codmarca, nombmarca) VALUES (2, 'Audi');
INSERT INTO marca (codmarca, nombmarca) VALUES (3, 'Lamborghini');
INSERT INTO marca (codmarca, nombmarca) VALUES (4, 'Ferrari');
INSERT INTO marca (codmarca, nombmarca) VALUES (5, 'Geele');
INSERT INTO marca (codmarca, nombmarca) VALUES (6, 'Hiunday');


--
-- TOC entry 2147 (class 0 OID 98792)
-- Dependencies: 176
-- Data for Name: modelo; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO modelo (codmodelo, nombmodelo, codmarca) VALUES (1, 'Prado', 1);
INSERT INTO modelo (codmodelo, nombmodelo, codmarca) VALUES (2, 'Corolla', 1);
INSERT INTO modelo (codmodelo, nombmodelo, codmarca) VALUES (3, 'GT 86', 1);
INSERT INTO modelo (codmodelo, nombmodelo, codmarca) VALUES (4, 'A4', 2);
INSERT INTO modelo (codmodelo, nombmodelo, codmarca) VALUES (5, 'A6', 2);
INSERT INTO modelo (codmodelo, nombmodelo, codmarca) VALUES (6, 'A8', 2);
INSERT INTO modelo (codmodelo, nombmodelo, codmarca) VALUES (7, 'Diablo', 3);
INSERT INTO modelo (codmodelo, nombmodelo, codmarca) VALUES (8, 'Gallardo', 3);
INSERT INTO modelo (codmodelo, nombmodelo, codmarca) VALUES (10, 'FX', 4);
INSERT INTO modelo (codmodelo, nombmodelo, codmarca) VALUES (9, 'Murciélago', 3);
INSERT INTO modelo (codmodelo, nombmodelo, codmarca) VALUES (11, 'F12', 4);
INSERT INTO modelo (codmodelo, nombmodelo, codmarca) VALUES (12, 'FK 10', 5);
INSERT INTO modelo (codmodelo, nombmodelo, codmarca) VALUES (13, 'CK 12', 5);
INSERT INTO modelo (codmodelo, nombmodelo, codmarca) VALUES (14, 'Haccent', 6);
INSERT INTO modelo (codmodelo, nombmodelo, codmarca) VALUES (15, 'Atos', 6);
INSERT INTO modelo (codmodelo, nombmodelo, codmarca) VALUES (16, 'Elentra', 6);


--
-- TOC entry 2150 (class 0 OID 98834)
-- Dependencies: 184
-- Data for Name: situacion; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO situacion (codsituac, nombsituac) VALUES (1, 'Taller');
INSERT INTO situacion (codsituac, nombsituac) VALUES (2, 'Alquilado');
INSERT INTO situacion (codsituac, nombsituac) VALUES (3, 'Disponible');


--
-- TOC entry 2159 (class 0 OID 98872)
-- Dependencies: 196
-- Data for Name: tarifa; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tarifa (codtarifa, ingreso, ingresoespecial) VALUES (16, 30, 50);
INSERT INTO tarifa (codtarifa, ingreso, ingresoespecial) VALUES (18, 30, 60);
INSERT INTO tarifa (codtarifa, ingreso, ingresoespecial) VALUES (19, 30, 40);
INSERT INTO tarifa (codtarifa, ingreso, ingresoespecial) VALUES (21, 30, 80);
INSERT INTO tarifa (codtarifa, ingreso, ingresoespecial) VALUES (22, 60, 100);
INSERT INTO tarifa (codtarifa, ingreso, ingresoespecial) VALUES (23, 40, 90);
INSERT INTO tarifa (codtarifa, ingreso, ingresoespecial) VALUES (24, 20, 50);
INSERT INTO tarifa (codtarifa, ingreso, ingresoespecial) VALUES (39, 30, 60);
INSERT INTO tarifa (codtarifa, ingreso, ingresoespecial) VALUES (40, 20, 40);
INSERT INTO tarifa (codtarifa, ingreso, ingresoespecial) VALUES (41, 20, 40);
INSERT INTO tarifa (codtarifa, ingreso, ingresoespecial) VALUES (42, 30, 40);


--
-- TOC entry 2144 (class 0 OID 98774)
-- Dependencies: 173
-- Data for Name: auto; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO auto (placauto, codauto, cantkm, colauto, codtarifa, codmodelo, codsituac) VALUES ('T001456', 10, 50, 'Azul', 16, 5, 3);
INSERT INTO auto (placauto, codauto, cantkm, colauto, codtarifa, codmodelo, codsituac) VALUES ('T005765', 12, 50, 'Amarillo', 19, 12, 3);
INSERT INTO auto (placauto, codauto, cantkm, colauto, codtarifa, codmodelo, codsituac) VALUES ('T098123', 11, 20, 'Negro', 18, 2, 3);
INSERT INTO auto (placauto, codauto, cantkm, colauto, codtarifa, codmodelo, codsituac) VALUES ('T098123', 16, 20, 'Amarillo', 24, 13, 3);
INSERT INTO auto (placauto, codauto, cantkm, colauto, codtarifa, codmodelo, codsituac) VALUES ('T098123', 15, 0, 'Blanco', 23, 5, 3);
INSERT INTO auto (placauto, codauto, cantkm, colauto, codtarifa, codmodelo, codsituac) VALUES ('T981234', 14, 40, 'Morado', 22, 14, 3);
INSERT INTO auto (placauto, codauto, cantkm, colauto, codtarifa, codmodelo, codsituac) VALUES ('T098123', 13, 40, 'Rojo', 21, 11, 3);


--
-- TOC entry 2171 (class 0 OID 0)
-- Dependencies: 189
-- Name: auto_codauto_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('auto_codauto_seq', 16, true);


--
-- TOC entry 2148 (class 0 OID 98813)
-- Dependencies: 180
-- Data for Name: chofer; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO chofer (codchof, idchof, nombchof, apellchof, dirchof, catchof, disponible, email) VALUES (2, '99123176231', 'Donatelo', 'Nuñez Gutierrez', '23 # 231 / A y B', 'A', true, 'dona@gilmail.com');
INSERT INTO chofer (codchof, idchof, nombchof, apellchof, dirchof, catchof, disponible, email) VALUES (23, '87123456213', 'Harol Pedro', 'Rodriguez Gonzales', 'Punta Brava', 'B', true, 'rodri@gilmail.com');
INSERT INTO chofer (codchof, idchof, nombchof, apellchof, dirchof, catchof, disponible, email) VALUES (21, '97111508122', 'Lázaro Rey', 'Gil Gomez', '9na #5467 / L y M	', 'A', true, 'rey@gilmail.com');
INSERT INTO chofer (codchof, idchof, nombchof, apellchof, dirchof, catchof, disponible, email) VALUES (14, '9906160868', 'Julio', 'Fernandez Leal', 'San Miguel', 'C', true, 'july@gilmail.com');
INSERT INTO chofer (codchof, idchof, nombchof, apellchof, dirchof, catchof, disponible, email) VALUES (25, '86769504595', 'Cristiano Ronaldo', 'Guerreiro', 'Porto #21 / 43 y 46', 'D', true, 'cristi@gilmail.com');
INSERT INTO chofer (codchof, idchof, nombchof, apellchof, dirchof, catchof, disponible, email) VALUES (20, '97111508122', 'Michael Enrique', 'Gomez Perez ', 'San Lazaro', 'C', true, 'miche@gilmail.com');
INSERT INTO chofer (codchof, idchof, nombchof, apellchof, dirchof, catchof, disponible, email) VALUES (24, '87123455623', 'Damian', 'Principe Tigresco', 'Marianao #43', 'C', true, 'dami@gilmail.com');
INSERT INTO chofer (codchof, idchof, nombchof, apellchof, dirchof, catchof, disponible, email) VALUES (15, '9812345672', 'Miguel', 'Mesa Roja', 'Playa', 'B', true, 'migue@gilmail.com');


--
-- TOC entry 2172 (class 0 OID 0)
-- Dependencies: 190
-- Name: chofer_codchof_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('chofer_codchof_seq', 77, true);


--
-- TOC entry 2151 (class 0 OID 98844)
-- Dependencies: 186
-- Data for Name: pais; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO pais (codpais, nombpais) VALUES (1, 'Albania');
INSERT INTO pais (codpais, nombpais) VALUES (2, 'Alemania');
INSERT INTO pais (codpais, nombpais) VALUES (3, 'Andorra');
INSERT INTO pais (codpais, nombpais) VALUES (4, 'Angola');
INSERT INTO pais (codpais, nombpais) VALUES (5, 'Arabia Saudita');
INSERT INTO pais (codpais, nombpais) VALUES (6, 'Argelia');
INSERT INTO pais (codpais, nombpais) VALUES (7, 'Argentina');
INSERT INTO pais (codpais, nombpais) VALUES (8, 'Armenia');
INSERT INTO pais (codpais, nombpais) VALUES (9, 'Australia');
INSERT INTO pais (codpais, nombpais) VALUES (10, 'Austria');
INSERT INTO pais (codpais, nombpais) VALUES (11, 'Azerbaiyán');
INSERT INTO pais (codpais, nombpais) VALUES (12, 'Bahamas');
INSERT INTO pais (codpais, nombpais) VALUES (13, 'Barbados');
INSERT INTO pais (codpais, nombpais) VALUES (14, 'Bélgica');
INSERT INTO pais (codpais, nombpais) VALUES (15, 'Belice');
INSERT INTO pais (codpais, nombpais) VALUES (16, 'Bielorrusia');
INSERT INTO pais (codpais, nombpais) VALUES (17, 'Birmania');
INSERT INTO pais (codpais, nombpais) VALUES (18, 'Bolivia');
INSERT INTO pais (codpais, nombpais) VALUES (19, 'Bosnia');
INSERT INTO pais (codpais, nombpais) VALUES (20, 'Brasil');
INSERT INTO pais (codpais, nombpais) VALUES (21, 'Bulgaria');
INSERT INTO pais (codpais, nombpais) VALUES (22, 'Cabo Verde');
INSERT INTO pais (codpais, nombpais) VALUES (23, 'Camboya');
INSERT INTO pais (codpais, nombpais) VALUES (24, 'Camerún');
INSERT INTO pais (codpais, nombpais) VALUES (25, 'Canadá');
INSERT INTO pais (codpais, nombpais) VALUES (26, 'Chile');
INSERT INTO pais (codpais, nombpais) VALUES (27, 'China');
INSERT INTO pais (codpais, nombpais) VALUES (28, 'Chipre');
INSERT INTO pais (codpais, nombpais) VALUES (29, 'Colombia');
INSERT INTO pais (codpais, nombpais) VALUES (30, 'Corea del Norte');
INSERT INTO pais (codpais, nombpais) VALUES (31, 'Corea de Sur');
INSERT INTO pais (codpais, nombpais) VALUES (32, 'Costa de Marfil');
INSERT INTO pais (codpais, nombpais) VALUES (33, 'Costa Rica');
INSERT INTO pais (codpais, nombpais) VALUES (34, 'Croacia');
INSERT INTO pais (codpais, nombpais) VALUES (35, 'Cuba');
INSERT INTO pais (codpais, nombpais) VALUES (36, 'Dinamarca');
INSERT INTO pais (codpais, nombpais) VALUES (37, 'Dominicana');
INSERT INTO pais (codpais, nombpais) VALUES (38, 'Ecuador');
INSERT INTO pais (codpais, nombpais) VALUES (39, 'Egipto');
INSERT INTO pais (codpais, nombpais) VALUES (40, 'El Salvador');
INSERT INTO pais (codpais, nombpais) VALUES (41, 'Emiratos Arabes Unidos');
INSERT INTO pais (codpais, nombpais) VALUES (42, 'Eslovaquia');
INSERT INTO pais (codpais, nombpais) VALUES (43, 'Eslovenia');
INSERT INTO pais (codpais, nombpais) VALUES (44, 'España');
INSERT INTO pais (codpais, nombpais) VALUES (45, 'Estados Unidos');
INSERT INTO pais (codpais, nombpais) VALUES (46, 'Estonia');
INSERT INTO pais (codpais, nombpais) VALUES (47, 'Etiopia');
INSERT INTO pais (codpais, nombpais) VALUES (48, 'Filipinas');
INSERT INTO pais (codpais, nombpais) VALUES (49, 'Finlandia');
INSERT INTO pais (codpais, nombpais) VALUES (50, 'Francia');
INSERT INTO pais (codpais, nombpais) VALUES (51, 'Gabón');
INSERT INTO pais (codpais, nombpais) VALUES (52, 'Georgia');
INSERT INTO pais (codpais, nombpais) VALUES (53, 'Ghana');
INSERT INTO pais (codpais, nombpais) VALUES (54, 'Granada');
INSERT INTO pais (codpais, nombpais) VALUES (55, 'Grecia');
INSERT INTO pais (codpais, nombpais) VALUES (56, 'Guatemala');
INSERT INTO pais (codpais, nombpais) VALUES (57, 'Guinea');
INSERT INTO pais (codpais, nombpais) VALUES (58, 'Guyana');
INSERT INTO pais (codpais, nombpais) VALUES (59, 'Haití');
INSERT INTO pais (codpais, nombpais) VALUES (60, 'Honduras');
INSERT INTO pais (codpais, nombpais) VALUES (61, 'Hungría');
INSERT INTO pais (codpais, nombpais) VALUES (62, 'India');
INSERT INTO pais (codpais, nombpais) VALUES (63, 'Indonesia');
INSERT INTO pais (codpais, nombpais) VALUES (64, 'Irán');
INSERT INTO pais (codpais, nombpais) VALUES (65, 'Irlanda');
INSERT INTO pais (codpais, nombpais) VALUES (66, 'Islandia');
INSERT INTO pais (codpais, nombpais) VALUES (67, 'Israel');
INSERT INTO pais (codpais, nombpais) VALUES (68, 'Italia');
INSERT INTO pais (codpais, nombpais) VALUES (69, 'Jamaica');
INSERT INTO pais (codpais, nombpais) VALUES (70, 'Japón');
INSERT INTO pais (codpais, nombpais) VALUES (71, 'Jordania');
INSERT INTO pais (codpais, nombpais) VALUES (72, 'Kazajistán');
INSERT INTO pais (codpais, nombpais) VALUES (73, 'Kenia');
INSERT INTO pais (codpais, nombpais) VALUES (74, 'Kirguistán');
INSERT INTO pais (codpais, nombpais) VALUES (75, 'Kuwait');
INSERT INTO pais (codpais, nombpais) VALUES (76, 'Laos');
INSERT INTO pais (codpais, nombpais) VALUES (77, 'Lesoto');
INSERT INTO pais (codpais, nombpais) VALUES (78, 'Letonia');
INSERT INTO pais (codpais, nombpais) VALUES (79, 'Líbano');
INSERT INTO pais (codpais, nombpais) VALUES (80, 'Libia');
INSERT INTO pais (codpais, nombpais) VALUES (81, 'Lituania');
INSERT INTO pais (codpais, nombpais) VALUES (82, 'Luxemburgo');
INSERT INTO pais (codpais, nombpais) VALUES (83, 'Madagascar');
INSERT INTO pais (codpais, nombpais) VALUES (84, 'Malasia');
INSERT INTO pais (codpais, nombpais) VALUES (85, 'Maldivas');
INSERT INTO pais (codpais, nombpais) VALUES (86, 'Malta');
INSERT INTO pais (codpais, nombpais) VALUES (87, 'Marruecos');
INSERT INTO pais (codpais, nombpais) VALUES (88, 'México');
INSERT INTO pais (codpais, nombpais) VALUES (89, 'Moldovia');
INSERT INTO pais (codpais, nombpais) VALUES (90, 'Mongolia');
INSERT INTO pais (codpais, nombpais) VALUES (91, 'Montenegro');
INSERT INTO pais (codpais, nombpais) VALUES (92, 'Mozambique');
INSERT INTO pais (codpais, nombpais) VALUES (93, 'Namibia');
INSERT INTO pais (codpais, nombpais) VALUES (94, 'Afganistán');
INSERT INTO pais (codpais, nombpais) VALUES (95, 'Antigua y Barbuda');
INSERT INTO pais (codpais, nombpais) VALUES (96, 'Burkina Faso');
INSERT INTO pais (codpais, nombpais) VALUES (97, 'Irak');
INSERT INTO pais (codpais, nombpais) VALUES (98, 'Liberia');
INSERT INTO pais (codpais, nombpais) VALUES (99, 'Nepal');
INSERT INTO pais (codpais, nombpais) VALUES (100, 'Nicaragua');
INSERT INTO pais (codpais, nombpais) VALUES (101, 'Níger');
INSERT INTO pais (codpais, nombpais) VALUES (102, 'Nigeria');
INSERT INTO pais (codpais, nombpais) VALUES (103, 'Noruega');
INSERT INTO pais (codpais, nombpais) VALUES (104, 'Nueva Zelanda');
INSERT INTO pais (codpais, nombpais) VALUES (105, 'Holanda');
INSERT INTO pais (codpais, nombpais) VALUES (106, 'Pakistán');
INSERT INTO pais (codpais, nombpais) VALUES (107, 'Panamá');
INSERT INTO pais (codpais, nombpais) VALUES (108, 'Paraguay');
INSERT INTO pais (codpais, nombpais) VALUES (109, 'Perú');
INSERT INTO pais (codpais, nombpais) VALUES (110, 'Polonia');
INSERT INTO pais (codpais, nombpais) VALUES (111, 'Portugal');
INSERT INTO pais (codpais, nombpais) VALUES (112, 'Reino Unido');
INSERT INTO pais (codpais, nombpais) VALUES (113, 'República Checa');
INSERT INTO pais (codpais, nombpais) VALUES (114, 'República del Congo');
INSERT INTO pais (codpais, nombpais) VALUES (115, 'Rumanía');
INSERT INTO pais (codpais, nombpais) VALUES (116, 'Rusia');
INSERT INTO pais (codpais, nombpais) VALUES (117, 'San Marino');
INSERT INTO pais (codpais, nombpais) VALUES (118, 'Granada');
INSERT INTO pais (codpais, nombpais) VALUES (119, 'Senegal');
INSERT INTO pais (codpais, nombpais) VALUES (120, 'Serbia');
INSERT INTO pais (codpais, nombpais) VALUES (121, 'Sierra Leona');
INSERT INTO pais (codpais, nombpais) VALUES (122, 'Singapur');
INSERT INTO pais (codpais, nombpais) VALUES (123, 'Siria');
INSERT INTO pais (codpais, nombpais) VALUES (124, 'Somalia');
INSERT INTO pais (codpais, nombpais) VALUES (125, 'Sudáfrica');
INSERT INTO pais (codpais, nombpais) VALUES (126, 'Suecia');
INSERT INTO pais (codpais, nombpais) VALUES (127, 'Suiza');
INSERT INTO pais (codpais, nombpais) VALUES (128, 'Surinam');
INSERT INTO pais (codpais, nombpais) VALUES (129, 'Tailandia');
INSERT INTO pais (codpais, nombpais) VALUES (130, 'Tanzania');
INSERT INTO pais (codpais, nombpais) VALUES (131, 'Tongo');
INSERT INTO pais (codpais, nombpais) VALUES (132, 'Trinidad y Tobago');
INSERT INTO pais (codpais, nombpais) VALUES (133, 'Túnez');
INSERT INTO pais (codpais, nombpais) VALUES (134, 'Turquía');
INSERT INTO pais (codpais, nombpais) VALUES (135, 'Ucrania');
INSERT INTO pais (codpais, nombpais) VALUES (136, 'Uruguay');
INSERT INTO pais (codpais, nombpais) VALUES (137, 'Uzbekistán');
INSERT INTO pais (codpais, nombpais) VALUES (138, 'Venezuela');
INSERT INTO pais (codpais, nombpais) VALUES (139, 'Vietnam');
INSERT INTO pais (codpais, nombpais) VALUES (140, 'Yemen');
INSERT INTO pais (codpais, nombpais) VALUES (141, 'Zambia');
INSERT INTO pais (codpais, nombpais) VALUES (142, 'Zimbabue');


--
-- TOC entry 2149 (class 0 OID 98824)
-- Dependencies: 182
-- Data for Name: turista; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO turista (codturis, numpaspturis, nomturis, apellturis, sexturis, edadturist, contactturist, pais__codpais, email) VALUES (13, 98760543, 'Nicolay ', 'Sheshenko', 'Masculino	', 70, 6890543903, 116, 'nico@gmail.com');
INSERT INTO turista (codturis, numpaspturis, nomturis, apellturis, sexturis, edadturist, contactturist, pais__codpais, email) VALUES (14, 34567820871, 'Leonel Messi', 'Cuchitini', 'Masculino	', 30, 234567821, 7, 'messi@gmail.com');
INSERT INTO turista (codturis, numpaspturis, nomturis, apellturis, sexturis, edadturist, contactturist, pais__codpais, email) VALUES (15, 9812345678, 'Leandro ', 'Hernandez', 'Masculino	', 20, 5467389201, 38, 'leo@gmail.com');
INSERT INTO turista (codturis, numpaspturis, nomturis, apellturis, sexturis, edadturist, contactturist, pais__codpais, email) VALUES (16, 7658435620, 'Daniel', 'Perez Perez', 'Masculino	', 50, 4356728719, 3, 'dani@gmail.com');
INSERT INTO turista (codturis, numpaspturis, nomturis, apellturis, sexturis, edadturist, contactturist, pais__codpais, email) VALUES (17, 6543678212, 'Cristian', 'Torna Retorna', 'Masculino	', 43, 544356298, 117, 'torna@gmail.com');
INSERT INTO turista (codturis, numpaspturis, nomturis, apellturis, sexturis, edadturist, contactturist, pais__codpais, email) VALUES (18, 76895443, 'Karol Gissel', 'Hernandez ', 'Femenino', 25, 764356209, 111, 'karo@gmail.com');


--
-- TOC entry 2145 (class 0 OID 98780)
-- Dependencies: 174
-- Data for Name: contrato; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO contrato (codauto, codturis, codcontr, fechinicio, fechfin, cantdiasporr, formpago, codchof, fechentrega_auto, importetotal, nombcontratista) VALUES (14, 16, 39, '2019-04-01', '2019-04-17', 9, 'Cheque', 15, '2019-04-26', 1860, 'Pedrón Gonzales');
INSERT INTO contrato (codauto, codturis, codcontr, fechinicio, fechfin, cantdiasporr, formpago, codchof, fechentrega_auto, importetotal, nombcontratista) VALUES (14, 14, 65, '2019-12-09', '2019-12-11', 0, 'Cheque', 15, '2019-12-09', 120, 'Alejandro Baster');


--
-- TOC entry 2173 (class 0 OID 0)
-- Dependencies: 191
-- Name: contrato_codcontr_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('contrato_codcontr_seq', 73, true);


--
-- TOC entry 2174 (class 0 OID 0)
-- Dependencies: 192
-- Name: marca_codmarca_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('marca_codmarca_seq', 1, false);


--
-- TOC entry 2175 (class 0 OID 0)
-- Dependencies: 193
-- Name: modelo_codmodelo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('modelo_codmodelo_seq', 1, false);


--
-- TOC entry 2176 (class 0 OID 0)
-- Dependencies: 194
-- Name: pais_codpais_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('pais_codpais_seq', 1, false);


--
-- TOC entry 2143 (class 0 OID 98739)
-- Dependencies: 172
-- Data for Name: product; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO product (id, price, name) VALUES (1, 15, 'Papa');


--
-- TOC entry 2177 (class 0 OID 0)
-- Dependencies: 171
-- Name: product_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('product_id_seq', 1, true);


--
-- TOC entry 2165 (class 0 OID 98966)
-- Dependencies: 202
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO role (id, role_name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO role (id, role_name) VALUES (2, 'ROLE_GUEST');
INSERT INTO role (id, role_name) VALUES (3, 'ROLE_PLANNER');


--
-- TOC entry 2178 (class 0 OID 0)
-- Dependencies: 201
-- Name: role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('role_id_seq', 3, true);


--
-- TOC entry 2179 (class 0 OID 0)
-- Dependencies: 195
-- Name: situacion_codsituac_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('situacion_codsituac_seq', 1, false);


--
-- TOC entry 2180 (class 0 OID 0)
-- Dependencies: 197
-- Name: tarifa_codtarifa_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tarifa_codtarifa_seq', 42, true);


--
-- TOC entry 2181 (class 0 OID 0)
-- Dependencies: 198
-- Name: turista_codturis_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('turista_codturis_seq', 43, true);


--
-- TOC entry 2163 (class 0 OID 98954)
-- Dependencies: 200
-- Data for Name: user; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO "user" (id, username, fullname, email, password) VALUES (5, 'picayo', 'Fernando Picayo', 'fpicayo@ceis.cujae.edu.cu', '$2a$10$aQxoxwb7my0rS5jXwqLFJOIK6nihhqbz2la57Z3ZYNEDF5UvuFL/i');
INSERT INTO "user" (id, username, fullname, email, password) VALUES (8, 'alvaro', 'Álvaro', 'alvaro@ceis.cujae.edu.cu', '$2a$10$aQxoxwb7my0rS5jXwqLFJOIK6nihhqbz2la57Z3ZYNEDF5UvuFL/i');
INSERT INTO "user" (id, username, fullname, email, password) VALUES (7, 'jbaster', 'Alejandro Baster', 'jbaster@ceis.cujae.edu.cu', '$2a$10$aQxoxwb7my0rS5jXwqLFJOIK6nihhqbz2la57Z3ZYNEDF5UvuFL/i');
INSERT INTO "user" (id, username, fullname, email, password) VALUES (6, 'rodnel', 'Rodnel Sanjuan', 'rsanjuan@ceis.cujae.edu.cu', '$2a$10$aQxoxwb7my0rS5jXwqLFJOIK6nihhqbz2la57Z3ZYNEDF5UvuFL/i');
INSERT INTO "user" (id, username, fullname, email, password) VALUES (9, 'ceagil', 'Adrian Gil', 'agil@gmail.com', '$2a$10$aQxoxwb7my0rS5jXwqLFJOIK6nihhqbz2la57Z3ZYNEDF5UvuFL/i');


--
-- TOC entry 2182 (class 0 OID 0)
-- Dependencies: 199
-- Name: user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('user_id_seq', 23, true);


--
-- TOC entry 2166 (class 0 OID 98975)
-- Dependencies: 203
-- Data for Name: user_role; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO user_role (user_id, role_id) VALUES (5, 1);
INSERT INTO user_role (user_id, role_id) VALUES (5, 2);
INSERT INTO user_role (user_id, role_id) VALUES (5, 3);
INSERT INTO user_role (user_id, role_id) VALUES (7, 3);
INSERT INTO user_role (user_id, role_id) VALUES (6, 3);
INSERT INTO user_role (user_id, role_id) VALUES (7, 2);
INSERT INTO user_role (user_id, role_id) VALUES (7, 1);
INSERT INTO user_role (user_id, role_id) VALUES (9, 1);
INSERT INTO user_role (user_id, role_id) VALUES (9, 2);
INSERT INTO user_role (user_id, role_id) VALUES (9, 3);
INSERT INTO user_role (user_id, role_id) VALUES (8, 1);


-- Completed on 2019-12-11 15:19:21

--
-- PostgreSQL database dump complete
--

