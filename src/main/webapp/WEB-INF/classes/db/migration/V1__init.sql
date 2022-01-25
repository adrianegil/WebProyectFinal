--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.0
-- Dumped by pg_dump version 9.3.0
-- Started on 2019-12-11 15:17:37

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 204 (class 3079 OID 11750)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner:
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2148 (class 0 OID 0)
-- Dependencies: 204
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner:
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

--
-- TOC entry 217 (class 1255 OID 98748)
-- Name: auto_buscar(integer); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION auto_buscar(idauto integer) RETURNS record
    LANGUAGE plpgsql
    AS $_$

DECLARE
	tupla record;
BEGIN

	SELECT 	INTO tupla *
	FROM 	auto
	WHERE	auto.codauto = $1;

	RETURN tupla;
END;
$_$;


ALTER FUNCTION public.auto_buscar(idauto integer) OWNER TO postgres;

--
-- TOC entry 218 (class 1255 OID 98749)
-- Name: auto_eliminar(integer); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION auto_eliminar(codauto integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$

BEGIN

  DELETE FROM auto
        WHERE auto.codauto = $1;
END;
$_$;


ALTER FUNCTION public.auto_eliminar(codauto integer) OWNER TO postgres;

--
-- TOC entry 219 (class 1255 OID 98750)
-- Name: auto_insertar(character varying, integer, text, integer, integer, integer); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION auto_insertar(placauto character varying, cantkm integer, colauto text, codtarifa integer, codmodelo integer, codsituac integer) RETURNS void
    LANGUAGE plpgsql
    AS $$

BEGIN
         INSERT INTO auto(placauto,cantkm,colauto,codtarifa,codmodelo,codsituac)
                   VALUES(placauto,cantkm,colauto,codtarifa,codmodelo,codsituac);


END;
$$;


ALTER FUNCTION public.auto_insertar(placauto character varying, cantkm integer, colauto text, codtarifa integer, codmodelo integer, codsituac integer) OWNER TO postgres;

--
-- TOC entry 220 (class 1255 OID 98751)
-- Name: auto_modificar(integer, character varying, integer, text, integer, integer, integer); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION auto_modificar(codauto integer, placauto character varying, cantkm integer, colauto text, codtarifa integer, codmodelo integer, codsituac integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$
BEGIN

 UPDATE auto
 SET	placauto = $2, cantkm = $3, colauto = $4,codtarifa=$5,codmodelo=$6,codsituac=$7
 WHERE	auto.codauto = $1;

END;$_$;


ALTER FUNCTION public.auto_modificar(codauto integer, placauto character varying, cantkm integer, colauto text, codtarifa integer, codmodelo integer, codsituac integer) OWNER TO postgres;

--
-- TOC entry 221 (class 1255 OID 98752)
-- Name: chofer_buscar(integer); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION chofer_buscar(codchof integer) RETURNS record
    LANGUAGE plpgsql
    AS $_$
DECLARE

   tupla record;

BEGIN

  SELECT INTO tupla *
  FROM chofer
  WHERE chofer.codchof=$1;

RETURN tupla;

END;$_$;


ALTER FUNCTION public.chofer_buscar(codchof integer) OWNER TO postgres;

--
-- TOC entry 222 (class 1255 OID 98753)
-- Name: chofer_eliminar(integer); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION chofer_eliminar(cod_chofer integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$

BEGIN

DELETE
       FROM chofer
       WHERE chofer.codchof = $1;

END
 $_$;


ALTER FUNCTION public.chofer_eliminar(cod_chofer integer) OWNER TO postgres;

--
-- TOC entry 223 (class 1255 OID 98754)
-- Name: chofer_insertar(character varying, character varying, character varying, text, character, character varying); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION chofer_insertar(idchof character varying, nombchof character varying, apellchof character varying, dirchof text, catchof character, email character varying) RETURNS void
    LANGUAGE plpgsql
    AS $$
BEGIN

   INSERT INTO chofer(idchof,nombchof,apellchof,dirchof,catchof,email)
          VALUES(idchof,nombchof,apellchof,dirchof,catchof,email);

END;
$$;


ALTER FUNCTION public.chofer_insertar(idchof character varying, nombchof character varying, apellchof character varying, dirchof text, catchof character, email character varying) OWNER TO postgres;

--
-- TOC entry 224 (class 1255 OID 98755)
-- Name: chofer_modificar(integer, character varying, character varying, character varying, text, character, boolean, character varying); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION chofer_modificar(codchofer integer, idchofer character varying, nombchof character varying, apellchof character varying, dirchof text, catchof character, disponible boolean, email character varying) RETURNS void
    LANGUAGE plpgsql
    AS $_$
BEGIN
		UPDATE 	 chofer
		SET	idchof = $2, nombchof = $3, apellchof = $4,dirchof=$5,catchof=$6,disponible=$7,email=$8
		WHERE	 chofer.codchof = $1;
END;
$_$;


ALTER FUNCTION public.chofer_modificar(codchofer integer, idchofer character varying, nombchof character varying, apellchof character varying, dirchof text, catchof character, disponible boolean, email character varying) OWNER TO postgres;

--
-- TOC entry 225 (class 1255 OID 98756)
-- Name: contrato_actualizar(integer, date); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION contrato_actualizar(codcontr integer, fechentrega_auto date) RETURNS void
    LANGUAGE plpgsql
    AS $_$

BEGIN
		UPDATE 	 contrato
		SET	 fechentrega_auto = $2
		WHERE	 contrato.codcontr = $1;
END;
$_$;


ALTER FUNCTION public.contrato_actualizar(codcontr integer, fechentrega_auto date) OWNER TO postgres;

--
-- TOC entry 226 (class 1255 OID 98757)
-- Name: contrato_buscar(integer); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION contrato_buscar(codcontr integer) RETURNS record
    LANGUAGE plpgsql
    AS $_$

DECLARE
	tupla record;
BEGIN
	SELECT 	INTO tupla *
	FROM 	contrato
	WHERE	contrato.codcontr = $1;

	RETURN tupla;
END;
$_$;


ALTER FUNCTION public.contrato_buscar(codcontr integer) OWNER TO postgres;

--
-- TOC entry 227 (class 1255 OID 98758)
-- Name: contrato_insertar1(integer, integer, date, date, character varying, integer, double precision, character varying); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION contrato_insertar1(codauto integer, codturis integer, fechinicio date, fechfin date, formpago character varying, codchof integer, importetotal double precision, nombcontratista character varying) RETURNS void
    LANGUAGE plpgsql
    AS $$

BEGIN

  INSERT 	INTO contrato(codauto, codturis,fechinicio,fechfin,formpago,codchof,importetotal,nombcontratista)
	       VALUES(codauto, codturis,fechinicio,fechfin,formpago,codchof,importetotal,nombcontratista);
END;
$$;


ALTER FUNCTION public.contrato_insertar1(codauto integer, codturis integer, fechinicio date, fechfin date, formpago character varying, codchof integer, importetotal double precision, nombcontratista character varying) OWNER TO postgres;

--
-- TOC entry 228 (class 1255 OID 98759)
-- Name: contrato_insertar2(integer, integer, date, date, character varying, double precision, character varying); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION contrato_insertar2(codauto integer, codturis integer, fechinicio date, fechfin date, formpago character varying, importetotal double precision, nombcontratista character varying) RETURNS void
    LANGUAGE plpgsql
    AS $$

BEGIN


 INSERT 	INTO contrato(codauto, codturis,fechinicio,fechfin,formpago,importetotal,nombcontratista)
	       VALUES(codauto, codturis,fechinicio,fechfin,formpago,importetotal,nombcontratista);

END;
$$;


ALTER FUNCTION public.contrato_insertar2(codauto integer, codturis integer, fechinicio date, fechfin date, formpago character varying, importetotal double precision, nombcontratista character varying) OWNER TO postgres;

--
-- TOC entry 229 (class 1255 OID 98760)
-- Name: funcion_auto_situacion_fecha_fin(integer); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION funcion_auto_situacion_fecha_fin(idauto integer) RETURNS date
    LANGUAGE plpgsql
    AS $_$

DECLARE
	fecha date;
	tupla record;
BEGIN
	tupla:= auto_buscar($1);

		IF tupla.codsituac = 2 THEN
			SELECT INTO fecha contrato.fechfin
			FROM contrato
			WHERE contrato.codauto = $1;
		END IF;

	RETURN fecha;
END
$_$;


ALTER FUNCTION public.funcion_auto_situacion_fecha_fin(idauto integer) OWNER TO postgres;

--
-- TOC entry 230 (class 1255 OID 98761)
-- Name: funcion_chofer_cantautos(integer); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION funcion_chofer_cantautos(idchofer integer) RETURNS integer
    LANGUAGE plpgsql
    AS $_$

DECLARE
	contar integer DEFAULT 0;

BEGIN

		SELECT INTO contar COUNT (contrato.codcontr)
		FROM contrato
		WHERE contrato.codchof = $1
		GROUP BY contrato.codchof;
		IF contar IS NULL THEN
			contar := 0;
		END IF;

	RETURN contar;
END;
$_$;


ALTER FUNCTION public.funcion_chofer_cantautos(idchofer integer) OWNER TO postgres;

--
-- TOC entry 231 (class 1255 OID 98762)
-- Name: funcion_modeloImporte(integer, character varying); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION "funcion_modeloImporte"(" codmodelo" integer, " formpago" character varying) RETURNS double precision
    LANGUAGE plpgsql
    AS $_$

DECLARE
	contar double precision;

BEGIN

    SELECT	INTO contar SUM(contrato.importetotal)
		FROM contrato, auto
		WHERE contrato.codauto = auto.codauto AND
		 auto.codmodelo = $1 AND
		 contrato.formpago = $2;
		 IF contar IS NULL THEN
			contar := (0);
		END IF;

	RETURN contar;
END
$_$;


ALTER FUNCTION public."funcion_modeloImporte"(" codmodelo" integer, " formpago" character varying) OWNER TO postgres;

--
-- TOC entry 232 (class 1255 OID 98763)
-- Name: funcion_turista_importeTotal(integer); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION "funcion_turista_importeTotal"(idturis integer) RETURNS double precision
    LANGUAGE plpgsql
    AS $_$

DECLARE
	contar double precision ;

BEGIN

		SELECT INTO contar SUM(contrato.importetotal)
		FROM  contrato
		WHERE contrato.codturis = $1;
		IF contar IS NULL THEN
			contar:= 0;
		END IF;

	RETURN contar;
END
$_$;


ALTER FUNCTION public."funcion_turista_importeTotal"(idturis integer) OWNER TO postgres;

--
-- TOC entry 233 (class 1255 OID 98764)
-- Name: funcion_turista_usado_autos(integer); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION funcion_turista_usado_autos(idturista integer) RETURNS integer
    LANGUAGE plpgsql
    AS $_$

DECLARE
	contar integer;

BEGIN
		SELECT INTO contar COUNT(contrato.codcontr)
		FROM contrato
		WHERE contrato.codturis = $1;
		IF contar IS NULL THEN
			contar:= 0;
		END IF;

	RETURN contar;
END
$_$;


ALTER FUNCTION public.funcion_turista_usado_autos(idturista integer) OWNER TO postgres;

--
-- TOC entry 234 (class 1255 OID 98765)
-- Name: tarifa_buscar(integer); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION tarifa_buscar(codtarifa integer) RETURNS record
    LANGUAGE plpgsql
    AS $_$

DECLARE
	tupla record;
BEGIN
	SELECT 	INTO tupla *
	FROM 	tarifa
	WHERE	tarifa.codtarifa = $1;

	RETURN tupla;
END;
$_$;


ALTER FUNCTION public.tarifa_buscar(codtarifa integer) OWNER TO postgres;

--
-- TOC entry 235 (class 1255 OID 98766)
-- Name: tarifa_insertar(double precision, double precision); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION tarifa_insertar(ingreso double precision, ingresoespecial double precision) RETURNS void
    LANGUAGE plpgsql
    AS $$
BEGIN


INSERT 	INTO tarifa(ingreso, ingresoespecial)
	     VALUES(ingreso, ingresoespecial);

END;
$$;


ALTER FUNCTION public.tarifa_insertar(ingreso double precision, ingresoespecial double precision) OWNER TO postgres;

--
-- TOC entry 236 (class 1255 OID 98767)
-- Name: trigger_TuristaEliminar(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION "trigger_TuristaEliminar"() RETURNS trigger
    LANGUAGE plpgsql
    AS $$

BEGIN

        DELETE FROM contrato
        WHERE contrato.codturis = OLD.codturis;

        RETURN OLD;

END;
$$;


ALTER FUNCTION public."trigger_TuristaEliminar"() OWNER TO postgres;

--
-- TOC entry 243 (class 1255 OID 106496)
-- Name: trigger_UsuarioEliminar(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION "trigger_UsuarioEliminar"() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN

        DELETE FROM user_role
        WHERE user_role.user_id = OLD.id;

        RETURN OLD;

END;$$;


ALTER FUNCTION public."trigger_UsuarioEliminar"() OWNER TO postgres;

--
-- TOC entry 242 (class 1255 OID 98768)
-- Name: trigger_contratImporteTotal(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION "trigger_contratImporteTotal"() RETURNS trigger
    LANGUAGE plpgsql
    AS $$DECLARE

	    contar double precision DEFAULT 0;
        tuplaAut record;
	    tuplaTar record;
        tuplaChof record;

BEGIN

        tuplaAut:= auto_buscar(NEW.codauto);
	    tuplaTar:= tarifa_buscar(tuplaAut.codtarifa);
      	tuplaChof:=chofer_buscar(NEW.codchof);

        tuplaAut:= auto_buscar(NEW.codauto);
	    tuplaTar:= tarifa_buscar(tuplaAut.codtarifa);

      IF NEW.fechentrega_auto > NEW.fechfin THEN

      NEW.cantdiasporr = NEW.fechentrega_auto - NEW.fechfin;
      contar:= (NEW.fechfin - NEW.fechinicio ) * tuplaTar.ingreso + NEW.cantdiasporr * tuplaTar.ingresoespecial;
       NEW.importetotal = contar;

      ELSE
      NEW.cantdiasporr = 0;
      contar:= (NEW.fechfin - NEW.fechinicio ) * tuplaTar.ingreso;
      NEW.importetotal = contar;
       END IF;


      IF tuplaAut.codsituac = 2 THEN

			UPDATE	auto
			SET	codsituac = 3
			WHERE 	auto.codauto = NEW.codauto;

			       IF tuplaChof.codchof IS NOT NULL THEN
                                        UPDATE	chofer
					SET	disponible = TRUE
					WHERE 	chofer.codchof = tuplaChof.codchof;
				END IF;

	END IF;


      RETURN NEW;

END;$$;


ALTER FUNCTION public."trigger_contratImporteTotal"() OWNER TO postgres;

--
-- TOC entry 237 (class 1255 OID 98769)
-- Name: trigger_contratoEliminar(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION "trigger_contratoEliminar"() RETURNS trigger
    LANGUAGE plpgsql
    AS $$DECLARE
	    tuplaAut RECORD;
        tuplaChof RECORD;
BEGIN
		SELECT 	INTO tuplaAut *
		FROM	auto
		WHERE	auto.codauto = OLD.codauto;

		IF tuplaAut.codsituac = 2 THEN

			UPDATE	auto
			SET	codsituac = 3
			WHERE 	auto.codauto = OLD.codauto;

			IF OLD.codchof IS NOT NULL THEN
				SELECT 	INTO tuplaChof *
				FROM	chofer
				WHERE	chofer.codchof = OLD.codchof;

				IF tuplaChof.disponible = FALSE THEN
					UPDATE	chofer
					SET	disponible = TRUE
					WHERE 	chofer.codchof = OLD.codchof;
				END IF;
			END IF;
		END IF;


RETURN OLD;

END;

	$$;


ALTER FUNCTION public."trigger_contratoEliminar"() OWNER TO postgres;

--
-- TOC entry 238 (class 1255 OID 98770)
-- Name: trigger_contratoValidar(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION "trigger_contratoValidar"() RETURNS trigger
    LANGUAGE plpgsql
    AS $$DECLARE

        contar double precision DEFAULT 0;
        tuplaChof record;
        tuplaAut record;
	    tuplaTar record;



BEGIN

     IF NEW.fechinicio > NEW.fechfin THEN

     RAISE EXCEPTION 'La fecha de inicio no puede ser mayor que la fecha final';

      END IF;

        tuplaChof:=chofer_buscar(NEW.codchof);
        tuplaAut:= auto_buscar(NEW.codauto);
	    tuplaTar:= tarifa_buscar(tuplaAut.codtarifa);
	    contar := (NEW.fechfin - NEW.fechinicio ) * tuplaTar.ingreso;

	NEW.importetotal := contar;

	               UPDATE	auto
			SET	codsituac = 2
			WHERE 	auto.codauto = NEW.codauto;

                                        UPDATE	chofer
					SET	disponible = FALSE
					WHERE 	chofer.codchof = NEW.codchof;

   RETURN NEW;
END;
$$;


ALTER FUNCTION public."trigger_contratoValidar"() OWNER TO postgres;

--
-- TOC entry 239 (class 1255 OID 98771)
-- Name: turista_eliminar(bigint); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION turista_eliminar(numpasp bigint) RETURNS void
    LANGUAGE plpgsql
    AS $_$

BEGIN

DELETE
       FROM turista
       WHERE turista.numpaspturis = $1;

END
 $_$;


ALTER FUNCTION public.turista_eliminar(numpasp bigint) OWNER TO postgres;

--
-- TOC entry 240 (class 1255 OID 98772)
-- Name: turista_insertar(bigint, character varying, character varying, character varying, integer, bigint, integer, character varying); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION turista_insertar(numpaspturis bigint, nomturis character varying, apellturis character varying, sexturis character varying, edadturist integer, contactturist bigint, pais__codpais integer, email character varying) RETURNS void
    LANGUAGE plpgsql
    AS $$

BEGIN

   INSERT INTO turista(numpaspturis,nomturis,apellturis,sexturis,edadturist,contactturist,pais__codpais,email)
          VALUES(numpaspturis,nomturis,apellturis,sexturis,edadturist,contactturist,pais__codpais,email);

END;
$$;


ALTER FUNCTION public.turista_insertar(numpaspturis bigint, nomturis character varying, apellturis character varying, sexturis character varying, edadturist integer, contactturist bigint, pais__codpais integer, email character varying) OWNER TO postgres;

--
-- TOC entry 241 (class 1255 OID 98773)
-- Name: turista_modificar(integer, bigint, character varying, character varying, character varying, integer, bigint, integer, character varying); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION turista_modificar(codturis integer, numpaspturis bigint, nomturis character varying, apellturis character varying, sexturis character varying, edadturist integer, contactturist bigint, pais__codpais integer, email character varying) RETURNS void
    LANGUAGE plpgsql
    AS $_$

BEGIN

		UPDATE 	 turista
		SET	numpaspturis = $2, nomturis = $3, apellturis = $4,sexturis=$5,
		        edadturist=$6, contactturist=$7, pais__codpais=$8, email=$9
		WHERE	 turista.codturis = $1;

END;
$_$;


ALTER FUNCTION public.turista_modificar(codturis integer, numpaspturis bigint, nomturis character varying, apellturis character varying, sexturis character varying, edadturist integer, contactturist bigint, pais__codpais integer, email character varying) OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 173 (class 1259 OID 98774)
-- Name: auto; Type: TABLE; Schema: public; Owner: postgres; Tablespace:
--

CREATE TABLE auto (
    placauto character varying NOT NULL,
    codauto integer NOT NULL,
    cantkm integer,
    colauto text NOT NULL,
    codtarifa integer,
    codmodelo integer,
    codsituac integer
);


ALTER TABLE public.auto OWNER TO postgres;

--
-- TOC entry 174 (class 1259 OID 98780)
-- Name: contrato; Type: TABLE; Schema: public; Owner: postgres; Tablespace:
--

CREATE TABLE contrato (
    codauto integer NOT NULL,
    codturis integer NOT NULL,
    codcontr integer NOT NULL,
    fechinicio date NOT NULL,
    fechfin date NOT NULL,
    cantdiasporr integer,
    formpago character varying NOT NULL,
    codchof integer,
    fechentrega_auto date,
    importetotal double precision,
    nombcontratista character varying NOT NULL
);


ALTER TABLE public.contrato OWNER TO postgres;

--
-- TOC entry 175 (class 1259 OID 98786)
-- Name: marca; Type: TABLE; Schema: public; Owner: postgres; Tablespace:
--

CREATE TABLE marca (
    codmarca integer NOT NULL,
    nombmarca character varying NOT NULL
);


ALTER TABLE public.marca OWNER TO postgres;

--
-- TOC entry 176 (class 1259 OID 98792)
-- Name: modelo; Type: TABLE; Schema: public; Owner: postgres; Tablespace:
--

CREATE TABLE modelo (
    codmodelo integer NOT NULL,
    nombmodelo character varying NOT NULL,
    codmarca integer NOT NULL
);


ALTER TABLE public.modelo OWNER TO postgres;

--
-- TOC entry 177 (class 1259 OID 98798)
-- Name: ContratosXMarcasYModelos; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW "ContratosXMarcasYModelos" AS
 SELECT marca.nombmarca,
    modelo.nombmodelo,
    count(DISTINCT auto.codauto) AS cantidaddeautos,
    "funcion_modeloImporte"(modelo.codmodelo, 'Efectivo'::character varying) AS efectivo,
    "funcion_modeloImporte"(modelo.codmodelo, 'Cheque'::character varying) AS cheque,
    "funcion_modeloImporte"(modelo.codmodelo, 'Tarjeta de Crédito'::character varying) AS tarjeta,
    sum(((contrato.fechfin - contrato.fechinicio) + contrato.cantdiasporr)) AS diasalquilados,
    sum(contrato.importetotal) AS pagoxmarca
   FROM auto,
    marca,
    modelo,
    contrato
  WHERE (((auto.codmodelo = modelo.codmodelo) AND (modelo.codmarca = marca.codmarca)) AND (contrato.codauto = auto.codauto))
  GROUP BY modelo.codmodelo, marca.nombmarca, modelo.nombmodelo;


ALTER TABLE public."ContratosXMarcasYModelos" OWNER TO postgres;

--
-- TOC entry 178 (class 1259 OID 98803)
-- Name: ContratosXPaises; Type: TABLE; Schema: public; Owner: postgres; Tablespace:
--

CREATE TABLE "ContratosXPaises" (
    nombpais character varying,
    nombmarca character varying,
    nombmodelo character varying,
    diasprorroga bigint,
    efectivo double precision,
    diasalquilados bigint,
    totalgeneral double precision
);


ALTER TABLE public."ContratosXPaises" OWNER TO postgres;

--
-- TOC entry 179 (class 1259 OID 98809)
-- Name: Listado_Autos; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW "Listado_Autos" AS
 SELECT auto.placauto,
    marca.nombmarca,
    modelo.nombmodelo,
    auto.colauto,
    auto.cantkm
   FROM auto,
    marca,
    modelo
  WHERE ((auto.codmodelo = modelo.codmodelo) AND (modelo.codmarca = marca.codmarca));


ALTER TABLE public."Listado_Autos" OWNER TO postgres;

--
-- TOC entry 180 (class 1259 OID 98813)
-- Name: chofer; Type: TABLE; Schema: public; Owner: postgres; Tablespace:
--

CREATE TABLE chofer (
    codchof integer NOT NULL,
    idchof character varying NOT NULL,
    nombchof character varying NOT NULL,
    apellchof character varying NOT NULL,
    dirchof text NOT NULL,
    catchof character(1) NOT NULL,
    disponible boolean DEFAULT true NOT NULL,
    email character varying
);


ALTER TABLE public.chofer OWNER TO postgres;

--
-- TOC entry 181 (class 1259 OID 98820)
-- Name: Listado_Choferes; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW "Listado_Choferes" AS
 SELECT chofer.idchof,
    chofer.nombchof,
    chofer.apellchof,
    chofer.dirchof,
    chofer.catchof,
    chofer.email,
    funcion_chofer_cantautos(chofer.codchof) AS cantidad_autos
   FROM chofer;


ALTER TABLE public."Listado_Choferes" OWNER TO postgres;

--
-- TOC entry 182 (class 1259 OID 98824)
-- Name: turista; Type: TABLE; Schema: public; Owner: postgres; Tablespace:
--

CREATE TABLE turista (
    codturis integer NOT NULL,
    numpaspturis bigint NOT NULL,
    nomturis character varying NOT NULL,
    apellturis character varying NOT NULL,
    sexturis character varying NOT NULL,
    edadturist integer NOT NULL,
    contactturist bigint NOT NULL,
    pais__codpais integer,
    email character varying
);


ALTER TABLE public.turista OWNER TO postgres;

--
-- TOC entry 183 (class 1259 OID 98830)
-- Name: Listado_Contratos; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW "Listado_Contratos" AS
 SELECT turista.nomturis,
    auto.placauto,
    marca.nombmarca,
    modelo.nombmodelo,
    contrato.formpago,
    contrato.fechinicio,
    contrato.fechentrega_auto,
    contrato.cantdiasporr,
    contrato.importetotal,
    (contrato.codchof IS NOT NULL) AS alquiler_chofer
   FROM turista,
    auto,
    marca,
    modelo,
    contrato
  WHERE ((((auto.codmodelo = modelo.codmodelo) AND (modelo.codmarca = marca.codmarca)) AND (contrato.codauto = auto.codauto)) AND (contrato.codturis = turista.codturis));


ALTER TABLE public."Listado_Contratos" OWNER TO postgres;

--
-- TOC entry 184 (class 1259 OID 98834)
-- Name: situacion; Type: TABLE; Schema: public; Owner: postgres; Tablespace:
--

CREATE TABLE situacion (
    codsituac integer NOT NULL,
    nombsituac character varying NOT NULL
);


ALTER TABLE public.situacion OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 98840)
-- Name: Listado_Situacion_Autos; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW "Listado_Situacion_Autos" AS
 SELECT auto.placauto,
    marca.nombmarca,
    situacion.nombsituac,
    funcion_auto_situacion_fecha_fin(auto.codauto) AS fecha_fin_contrato
   FROM auto,
    modelo,
    marca,
    situacion
  WHERE (((auto.codmodelo = modelo.codmodelo) AND (auto.codsituac = situacion.codsituac)) AND (modelo.codmarca = marca.codmarca));


ALTER TABLE public."Listado_Situacion_Autos" OWNER TO postgres;

--
-- TOC entry 186 (class 1259 OID 98844)
-- Name: pais; Type: TABLE; Schema: public; Owner: postgres; Tablespace:
--

CREATE TABLE pais (
    codpais integer NOT NULL,
    nombpais character varying NOT NULL
);


ALTER TABLE public.pais OWNER TO postgres;

--
-- TOC entry 187 (class 1259 OID 98850)
-- Name: Listado_Turistas; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW "Listado_Turistas" AS
 SELECT pais.nombpais,
    turista.nomturis,
    turista.numpaspturis,
    turista.email,
    funcion_turista_usado_autos(turista.codturis) AS turista_usado_autos,
    "funcion_turista_importeTotal"(turista.codturis) AS turista_importetotal
   FROM turista,
    pais
  WHERE (pais.codpais = turista.pais__codpais);


ALTER TABLE public."Listado_Turistas" OWNER TO postgres;

--
-- TOC entry 188 (class 1259 OID 98854)
-- Name: Listado_Turistas_Incumplidores; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW "Listado_Turistas_Incumplidores" AS
 SELECT turista.nomturis,
    turista.apellturis,
    contrato.fechfin,
    contrato.fechentrega_auto
   FROM contrato,
    turista
  WHERE ((turista.codturis = contrato.codturis) AND (contrato.cantdiasporr > 0));


ALTER TABLE public."Listado_Turistas_Incumplidores" OWNER TO postgres;

--
-- TOC entry 189 (class 1259 OID 98858)
-- Name: auto_codauto_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE auto_codauto_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.auto_codauto_seq OWNER TO postgres;

--
-- TOC entry 2149 (class 0 OID 0)
-- Dependencies: 189
-- Name: auto_codauto_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE auto_codauto_seq OWNED BY auto.codauto;


--
-- TOC entry 190 (class 1259 OID 98860)
-- Name: chofer_codchof_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE chofer_codchof_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.chofer_codchof_seq OWNER TO postgres;

--
-- TOC entry 2150 (class 0 OID 0)
-- Dependencies: 190
-- Name: chofer_codchof_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE chofer_codchof_seq OWNED BY chofer.codchof;


--
-- TOC entry 191 (class 1259 OID 98862)
-- Name: contrato_codcontr_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE contrato_codcontr_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.contrato_codcontr_seq OWNER TO postgres;

--
-- TOC entry 2151 (class 0 OID 0)
-- Dependencies: 191
-- Name: contrato_codcontr_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE contrato_codcontr_seq OWNED BY contrato.codcontr;



--
-- TOC entry 192 (class 1259 OID 98864)
-- Name: marca_codmarca_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE marca_codmarca_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.marca_codmarca_seq OWNER TO postgres;

--
-- TOC entry 2152 (class 0 OID 0)
-- Dependencies: 192
-- Name: marca_codmarca_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE marca_codmarca_seq OWNED BY marca.codmarca;


--
-- TOC entry 193 (class 1259 OID 98866)
-- Name: modelo_codmodelo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE modelo_codmodelo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.modelo_codmodelo_seq OWNER TO postgres;

--
-- TOC entry 2153 (class 0 OID 0)
-- Dependencies: 193
-- Name: modelo_codmodelo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE modelo_codmodelo_seq OWNED BY modelo.codmodelo;


--
-- TOC entry 194 (class 1259 OID 98868)
-- Name: pais_codpais_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE pais_codpais_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pais_codpais_seq OWNER TO postgres;

--
-- TOC entry 2154 (class 0 OID 0)
-- Dependencies: 194
-- Name: pais_codpais_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE pais_codpais_seq OWNED BY pais.codpais;


--
-- TOC entry 172 (class 1259 OID 98739)
-- Name: product; Type: TABLE; Schema: public; Owner: postgres; Tablespace:
--

CREATE TABLE product (
    id integer NOT NULL,
    price double precision,
    name character varying
);


ALTER TABLE public.product OWNER TO postgres;

--
-- TOC entry 171 (class 1259 OID 98737)
-- Name: product_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE product_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.product_id_seq OWNER TO postgres;

--
-- TOC entry 2155 (class 0 OID 0)
-- Dependencies: 171
-- Name: product_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE product_id_seq OWNED BY product.id;


--
-- TOC entry 202 (class 1259 OID 98966)
-- Name: role; Type: TABLE; Schema: public; Owner: postgres; Tablespace:
--

CREATE TABLE role (
    id integer NOT NULL,
    role_name character varying
);


ALTER TABLE public.role OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 98964)
-- Name: role_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.role_id_seq OWNER TO postgres;

--
-- TOC entry 2156 (class 0 OID 0)
-- Dependencies: 201
-- Name: role_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE role_id_seq OWNED BY role.id;


--
-- TOC entry 195 (class 1259 OID 98870)
-- Name: situacion_codsituac_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE situacion_codsituac_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.situacion_codsituac_seq OWNER TO postgres;

--
-- TOC entry 2157 (class 0 OID 0)
-- Dependencies: 195
-- Name: situacion_codsituac_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE situacion_codsituac_seq OWNED BY situacion.codsituac;


--
-- TOC entry 196 (class 1259 OID 98872)
-- Name: tarifa; Type: TABLE; Schema: public; Owner: postgres; Tablespace:
--

CREATE TABLE tarifa (
    codtarifa integer NOT NULL,
    ingreso double precision NOT NULL,
    ingresoespecial double precision NOT NULL
);


ALTER TABLE public.tarifa OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 98875)
-- Name: tarifa_codtarifa_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tarifa_codtarifa_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tarifa_codtarifa_seq OWNER TO postgres;

--
-- TOC entry 2158 (class 0 OID 0)
-- Dependencies: 197
-- Name: tarifa_codtarifa_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tarifa_codtarifa_seq OWNED BY tarifa.codtarifa;


--
-- TOC entry 198 (class 1259 OID 98877)
-- Name: turista_codturis_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE turista_codturis_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.turista_codturis_seq OWNER TO postgres;

--
-- TOC entry 2159 (class 0 OID 0)
-- Dependencies: 198
-- Name: turista_codturis_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE turista_codturis_seq OWNED BY turista.codturis;


--
-- TOC entry 200 (class 1259 OID 98954)
-- Name: user; Type: TABLE; Schema: public; Owner: postgres; Tablespace:
--

CREATE TABLE "user" (
    id integer NOT NULL,
    username character varying,
    fullname character varying,
    email character varying,
    password character varying
);


ALTER TABLE public."user" OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 98952)
-- Name: user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_id_seq OWNER TO postgres;

--
-- TOC entry 2160 (class 0 OID 0)
-- Dependencies: 199
-- Name: user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE user_id_seq OWNED BY "user".id;


--
-- TOC entry 203 (class 1259 OID 98975)
-- Name: user_role; Type: TABLE; Schema: public; Owner: postgres; Tablespace:
--

CREATE TABLE user_role (
    user_id integer NOT NULL,
    role_id integer NOT NULL
);


ALTER TABLE public.user_role OWNER TO postgres;

--
-- TOC entry 1970 (class 2604 OID 98879)
-- Name: codauto; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY auto ALTER COLUMN codauto SET DEFAULT nextval('auto_codauto_seq'::regclass);


--
-- TOC entry 1975 (class 2604 OID 98880)
-- Name: codchof; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY chofer ALTER COLUMN codchof SET DEFAULT nextval('chofer_codchof_seq'::regclass);


--
-- TOC entry 1971 (class 2604 OID 98881)
-- Name: codcontr; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY contrato ALTER COLUMN codcontr SET DEFAULT nextval('contrato_codcontr_seq'::regclass);


--
-- TOC entry 1972 (class 2604 OID 98882)
-- Name: codmarca; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY marca ALTER COLUMN codmarca SET DEFAULT nextval('marca_codmarca_seq'::regclass);


--
-- TOC entry 1973 (class 2604 OID 98883)
-- Name: codmodelo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY modelo ALTER COLUMN codmodelo SET DEFAULT nextval('modelo_codmodelo_seq'::regclass);


--
-- TOC entry 1978 (class 2604 OID 98884)
-- Name: codpais; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pais ALTER COLUMN codpais SET DEFAULT nextval('pais_codpais_seq'::regclass);


--
-- TOC entry 1969 (class 2604 OID 98742)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY product ALTER COLUMN id SET DEFAULT nextval('product_id_seq'::regclass);


--
-- TOC entry 1981 (class 2604 OID 98969)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY role ALTER COLUMN id SET DEFAULT nextval('role_id_seq'::regclass);


--
-- TOC entry 1977 (class 2604 OID 98885)
-- Name: codsituac; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY situacion ALTER COLUMN codsituac SET DEFAULT nextval('situacion_codsituac_seq'::regclass);


--
-- TOC entry 1979 (class 2604 OID 98886)
-- Name: codtarifa; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tarifa ALTER COLUMN codtarifa SET DEFAULT nextval('tarifa_codtarifa_seq'::regclass);


--
-- TOC entry 1976 (class 2604 OID 98887)
-- Name: codturis; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY turista ALTER COLUMN codturis SET DEFAULT nextval('turista_codturis_seq'::regclass);


--
-- TOC entry 1980 (class 2604 OID 98957)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "user" ALTER COLUMN id SET DEFAULT nextval('user_id_seq'::regclass);


--
-- TOC entry 1988 (class 2606 OID 98889)
-- Name: auto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace:
--

ALTER TABLE ONLY auto
    ADD CONSTRAINT auto_pkey PRIMARY KEY (codauto);


--
-- TOC entry 1996 (class 2606 OID 98891)
-- Name: chofer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace:
--

ALTER TABLE ONLY chofer
    ADD CONSTRAINT chofer_pkey PRIMARY KEY (codchof);


--
-- TOC entry 1990 (class 2606 OID 98893)
-- Name: contrato_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace:
--

ALTER TABLE ONLY contrato
    ADD CONSTRAINT contrato_pkey PRIMARY KEY (codcontr);


--
-- TOC entry 1992 (class 2606 OID 98895)
-- Name: marca_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace:
--

ALTER TABLE ONLY marca
    ADD CONSTRAINT marca_pkey PRIMARY KEY (codmarca);


--
-- TOC entry 1994 (class 2606 OID 98897)
-- Name: modelo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace:
--

ALTER TABLE ONLY modelo
    ADD CONSTRAINT modelo_pkey PRIMARY KEY (codmodelo);


--
-- TOC entry 2002 (class 2606 OID 98899)
-- Name: pais_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace:
--

ALTER TABLE ONLY pais
    ADD CONSTRAINT pais_pkey PRIMARY KEY (codpais);


--
-- TOC entry 1986 (class 2606 OID 98747)
-- Name: product_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace:
--

ALTER TABLE ONLY product
    ADD CONSTRAINT product_pkey PRIMARY KEY (id);


--
-- TOC entry 2008 (class 2606 OID 98974)
-- Name: role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace:
--

ALTER TABLE ONLY role
    ADD CONSTRAINT role_pkey PRIMARY KEY (id);


--
-- TOC entry 2000 (class 2606 OID 98901)
-- Name: situacion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace:
--

ALTER TABLE ONLY situacion
    ADD CONSTRAINT situacion_pkey PRIMARY KEY (codsituac);


--
-- TOC entry 2004 (class 2606 OID 98903)
-- Name: tarifa_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace:
--

ALTER TABLE ONLY tarifa
    ADD CONSTRAINT tarifa_pkey PRIMARY KEY (codtarifa);


--
-- TOC entry 1998 (class 2606 OID 98905)
-- Name: turista_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace:
--

ALTER TABLE ONLY turista
    ADD CONSTRAINT turista_pkey PRIMARY KEY (codturis);


--
-- TOC entry 2006 (class 2606 OID 98963)
-- Name: user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace:
--

ALTER TABLE ONLY "user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (id);


--
-- TOC entry 2010 (class 2606 OID 98979)
-- Name: user_role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace:
--

ALTER TABLE ONLY user_role
    ADD CONSTRAINT user_role_pkey PRIMARY KEY (user_id, role_id);

--
-- TOC entry 2140 (class 2618 OID 98906)
-- Name: _RETURN; Type: RULE; Schema: public; Owner: postgres
--

CREATE RULE "_RETURN" AS
    ON SELECT TO "ContratosXPaises" DO INSTEAD  SELECT pais.nombpais,
    marca.nombmarca,
    modelo.nombmodelo,
    sum(contrato.cantdiasporr) AS diasprorroga,
    "funcion_modeloImporte"(modelo.codmodelo, 'Efectivo'::character varying) AS efectivo,
    sum(((contrato.fechfin - contrato.fechinicio) + contrato.cantdiasporr)) AS diasalquilados,
    sum(contrato.importetotal) AS totalgeneral
   FROM auto,
    marca,
    modelo,
    contrato,
    pais,
    turista
  WHERE (((((auto.codmodelo = modelo.codmodelo) AND (modelo.codmarca = marca.codmarca)) AND (contrato.codauto = auto.codauto)) AND (contrato.codturis = turista.codturis)) AND (turista.pais__codpais = pais.codpais))
  GROUP BY pais.nombpais, modelo.codmodelo, marca.nombmarca
  ORDER BY modelo.codmodelo, marca.nombmarca;


--
-- TOC entry 2024 (class 2620 OID 98908)
-- Name: TuristaEliminar; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER "TuristaEliminar" BEFORE DELETE ON turista FOR EACH ROW EXECUTE PROCEDURE "trigger_TuristaEliminar"();


--
-- TOC entry 2025 (class 2620 OID 106497)
-- Name: UsuarioEliminar; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER "UsuarioEliminar" BEFORE DELETE ON "user" FOR EACH ROW EXECUTE PROCEDURE "trigger_UsuarioEliminar"();


--
-- TOC entry 2021 (class 2620 OID 98909)
-- Name: contratoEliminar; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER "contratoEliminar" AFTER DELETE ON contrato FOR EACH ROW EXECUTE PROCEDURE "trigger_contratoEliminar"();


--
-- TOC entry 2022 (class 2620 OID 98910)
-- Name: contratoImporteTotal; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER "contratoImporteTotal" BEFORE UPDATE ON contrato FOR EACH ROW EXECUTE PROCEDURE "trigger_contratImporteTotal"();


--
-- TOC entry 2023 (class 2620 OID 98911)
-- Name: contratoValidar; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER "contratoValidar" BEFORE INSERT ON contrato FOR EACH ROW EXECUTE PROCEDURE "trigger_contratoValidar"();


--
-- TOC entry 2011 (class 2606 OID 98912)
-- Name: auto_codmodelo_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY auto
    ADD CONSTRAINT auto_codmodelo_fkey FOREIGN KEY (codmodelo) REFERENCES modelo(codmodelo);


--
-- TOC entry 2012 (class 2606 OID 98917)
-- Name: fk_auto_situacion; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY auto
    ADD CONSTRAINT fk_auto_situacion FOREIGN KEY (codsituac) REFERENCES situacion(codsituac);


--
-- TOC entry 2013 (class 2606 OID 98922)
-- Name: fk_auto_tarifa; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY auto
    ADD CONSTRAINT fk_auto_tarifa FOREIGN KEY (codtarifa) REFERENCES tarifa(codtarifa);


--
-- TOC entry 2014 (class 2606 OID 98927)
-- Name: fk_contrato_auto; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY contrato
    ADD CONSTRAINT fk_contrato_auto FOREIGN KEY (codauto) REFERENCES auto(codauto);


--
-- TOC entry 2015 (class 2606 OID 98932)
-- Name: fk_contrato_chofer; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY contrato
    ADD CONSTRAINT fk_contrato_chofer FOREIGN KEY (codchof) REFERENCES chofer(codchof);


--
-- TOC entry 2016 (class 2606 OID 98937)
-- Name: fk_contrato_turista; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY contrato
    ADD CONSTRAINT fk_contrato_turista FOREIGN KEY (codturis) REFERENCES turista(codturis);


--
-- TOC entry 2018 (class 2606 OID 98942)
-- Name: fk_turista_pais; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY turista
    ADD CONSTRAINT fk_turista_pais FOREIGN KEY (pais__codpais) REFERENCES pais(codpais);


--
-- TOC entry 2017 (class 2606 OID 98947)
-- Name: modelo_codmarca_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY modelo
    ADD CONSTRAINT modelo_codmarca_fkey FOREIGN KEY (codmarca) REFERENCES marca(codmarca);


--
-- TOC entry 2019 (class 2606 OID 98980)
-- Name: user_role_role_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY user_role
    ADD CONSTRAINT user_role_role_id_fkey FOREIGN KEY (role_id) REFERENCES role(id);


--
-- TOC entry 2020 (class 2606 OID 98985)
-- Name: user_role_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY user_role
    ADD CONSTRAINT user_role_user_id_fkey FOREIGN KEY (user_id) REFERENCES "user"(id);


--
-- TOC entry 2147 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2019-12-11 15:17:38

--
-- PostgreSQL database dump complete
--

