--
-- PostgreSQL database dump
--

-- Dumped from database version 13.1
-- Dumped by pg_dump version 13.1

-- Started on 2021-02-05 16:41:41

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

--
-- TOC entry 221 (class 1255 OID 98381)
-- Name: ControlloRitardoTrue(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public."ControlloRitardoTrue"() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
UPDATE public."Tratta"
SET "Ritardo" = 'true'
WHERE "CodTratta" = (
SELECT CC."CodTratta"
FROM (((public."Slot" NATURAL JOIN public."Coda di imbarco")
AS AA 
NATURAL JOIN public."Gate" )
AS B 
NATURAL JOIN public."Tratta"
) AS CC

WHERE NEW."CodSlot" = CC."CodSlot" AND CC."TempoDiImbarcoEffettivo" > CC."TempoDiImbarcoStimato" AND NEW."Data" = CC."Data"
);
RETURN NULL;
END;
$$;


ALTER FUNCTION public."ControlloRitardoTrue"() OWNER TO postgres;

--
-- TOC entry 225 (class 1255 OID 131265)
-- Name: DataCorrettaCodaDiImbarco(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public."DataCorrettaCodaDiImbarco"() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
UPDATE public."Coda di imbarco"
SET "Data" = (SELECT "Data" FROM public."Gate" WHERE NEW."CodGate" = "CodGate"); 
RETURN null;
END;
$$;


ALTER FUNCTION public."DataCorrettaCodaDiImbarco"() OWNER TO postgres;

--
-- TOC entry 222 (class 1255 OID 131261)
-- Name: DataCorrettaGate(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public."DataCorrettaGate"() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
UPDATE public."Gate"
SET "Data" = (SELECT "Data" FROM public."Tratta" WHERE NEW."CodGate" = "CodGate"); 
RETURN null;
END;
$$;


ALTER FUNCTION public."DataCorrettaGate"() OWNER TO postgres;

--
-- TOC entry 224 (class 1255 OID 131267)
-- Name: DataCorrettaSlot(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public."DataCorrettaSlot"() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
UPDATE public."Slot"
SET "Data" = (SELECT "Data" FROM public."Coda di imbarco" WHERE NEW."CodCoda" = "CodCoda"); 
RETURN null;
END;
$$;


ALTER FUNCTION public."DataCorrettaSlot"() OWNER TO postgres;

--
-- TOC entry 208 (class 1255 OID 98355)
-- Name: DifferenzaNprenotazioni(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public."DifferenzaNprenotazioni"() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
UPDATE public."Tratta" 
SET  "Nprenotazioni" = public."Tratta"."Nprenotazioni" - 1
WHERE old."CodTratta" = "CodTratta";  
RETURN NULL; 
END;
$$;


ALTER FUNCTION public."DifferenzaNprenotazioni"() OWNER TO postgres;

--
-- TOC entry 220 (class 1255 OID 32806)
-- Name: SommaNprenotazioni(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public."SommaNprenotazioni"() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
UPDATE public."Tratta" 
SET  "Nprenotazioni" = "Nprenotazioni" + 1
WHERE NEW."CodTratta" = "CodTratta";  
RETURN NULL; 
END;
$$;


ALTER FUNCTION public."SommaNprenotazioni"() OWNER TO postgres;

--
-- TOC entry 223 (class 1255 OID 131259)
-- Name: UpdateCodGateInTratta(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public."UpdateCodGateInTratta"() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
UPDATE public."Tratta"
SET "CodGate" = new."CodGate"
WHERE "CodTratta" = new."CodTratta";
RETURN null;
END;
$$;


ALTER FUNCTION public."UpdateCodGateInTratta"() OWNER TO postgres;

--
-- TOC entry 226 (class 1255 OID 131263)
-- Name: UpdateCodSlotInCodaDiImbarco(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public."UpdateCodSlotInCodaDiImbarco"() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
UPDATE public."Coda di imbarco"
SET "CodSlot" = new."CodSlot"
WHERE "CodCoda" = new."CodCoda";
RETURN null;
END;
$$;


ALTER FUNCTION public."UpdateCodSlotInCodaDiImbarco"() OWNER TO postgres;

--
-- TOC entry 228 (class 1255 OID 172241)
-- Name: UpdateNgateInGate(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public."UpdateNgateInGate"() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
begin
update public."Gate" AS ga
set "Ngate" = (select Ngate
			   from public."Tratta" as tr
			   where new."CodTratta" = tr."CodTratta")
where ga."CodGate" = new."CodGate";
return null;
end;
$$;


ALTER FUNCTION public."UpdateNgateInGate"() OWNER TO postgres;

--
-- TOC entry 227 (class 1255 OID 172236)
-- Name: VerificaTrattaGate(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public."VerificaTrattaGate"() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
begin
if exists(
select
from public."Tratta" as tr
where new."OrarioDiPartenza" <= tr."OrarioDiPartenza" + interval '1 hour' AND 
new."OrarioDiPartenza" >= tr."OrarioDiPartenza" AND tr."Data" = new."Data" AND tr."Ngate" = new."Ngate" And "CodTratta" != new."CodTratta")

then
delete from "Tratta"
where "CodTratta" = new."CodTratta";

raise exception'il gate scelto è già occupato in quel periodo, inserisci una tratta che abbia Ngate diverso o che non si trovi nella stessa data di un altra tratta con OrarioDiPartenza compreso tra: OrarioDiPartenza della tratta + 1 ora';
end if;

return null;
end;
$$;


ALTER FUNCTION public."VerificaTrattaGate"() OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 206 (class 1259 OID 147656)
-- Name: Biglietto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Biglietto" (
    "CodFiscale" character varying(16) NOT NULL,
    "Tipo di biglietto" character varying(40) NOT NULL,
    "CodBiglietto" character varying(6) NOT NULL,
    "CodTratta" text NOT NULL,
    "Posto" character varying(3) NOT NULL
);


ALTER TABLE public."Biglietto" OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16624)
-- Name: Cliente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Cliente" (
    "CodFiscale" character varying(16) NOT NULL,
    "Nome" text NOT NULL,
    "Cognome" text NOT NULL
);


ALTER TABLE public."Cliente" OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 98434)
-- Name: Coda di imbarco; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Coda di imbarco" (
    "CodCoda" text NOT NULL,
    "Tipo di coda" character varying(40) NOT NULL,
    "CodGate" text NOT NULL,
    "CodSlot" text,
    "Data" date
);


ALTER TABLE public."Coda di imbarco" OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 16605)
-- Name: Compagnia; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Compagnia" (
    "CodIATA" text NOT NULL,
    "Nome compagnia" text NOT NULL
);


ALTER TABLE public."Compagnia" OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 16613)
-- Name: Fedeltà; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Fedeltà" (
    "CodIATA" character varying(2) NOT NULL,
    "CodFiscale" character varying(16) NOT NULL,
    "Punti" integer NOT NULL,
    "CentoKilometri" character(5)
);


ALTER TABLE public."Fedeltà" OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 98419)
-- Name: Gate; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Gate" (
    "CodGate" text NOT NULL,
    "CodTratta" text,
    "Ngate" text,
    "Data" date
);


ALTER TABLE public."Gate" OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 98411)
-- Name: Slot; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Slot" (
    "CodSlot" text NOT NULL,
    "TempoDiImbarcoStimato" integer NOT NULL,
    "TempoDiImbarcoEffettivo" integer,
    "Data" date,
    "CodCoda" text NOT NULL
);


ALTER TABLE public."Slot" OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 147673)
-- Name: Tratta; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Tratta" (
    "CodTratta" text NOT NULL,
    "Nprenotazioni" integer NOT NULL,
    "OrarioDiPartenza" time with time zone NOT NULL,
    "Data" date NOT NULL,
    "CodIATA" character varying(2),
    "Destinazione" text NOT NULL,
    "Scali" text,
    "CodGate" text,
    "Ritardo" boolean,
    "Ngate" text
);


ALTER TABLE public."Tratta" OWNER TO postgres;


--
-- TOC entry 2905 (class 2606 OID 147660)
-- Name: Biglietto Biglietto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Biglietto"
    ADD CONSTRAINT "Biglietto_pkey" PRIMARY KEY ("CodBiglietto");


--
-- TOC entry 2897 (class 2606 OID 16631)
-- Name: Cliente Cliente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Cliente"
    ADD CONSTRAINT "Cliente_pkey" PRIMARY KEY ("CodFiscale");


--
-- TOC entry 2903 (class 2606 OID 98441)
-- Name: Coda di imbarco Coda di imbarco_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Coda di imbarco"
    ADD CONSTRAINT "Coda di imbarco_pkey" PRIMARY KEY ("CodCoda");


--
-- TOC entry 2895 (class 2606 OID 32846)
-- Name: Compagnia Compagnia_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Compagnia"
    ADD CONSTRAINT "Compagnia_pkey" PRIMARY KEY ("CodIATA");


--
-- TOC entry 2901 (class 2606 OID 98426)
-- Name: Gate Gate_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Gate"
    ADD CONSTRAINT "Gate_pkey" PRIMARY KEY ("CodGate");


--
-- TOC entry 2899 (class 2606 OID 98443)
-- Name: Slot Slot_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Slot"
    ADD CONSTRAINT "Slot_pkey" PRIMARY KEY ("CodSlot");


--
-- TOC entry 2907 (class 2606 OID 147680)
-- Name: Tratta Tratta_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Tratta"
    ADD CONSTRAINT "Tratta_pkey" PRIMARY KEY ("CodTratta");


--
-- TOC entry 2893 (class 2606 OID 32857)
-- Name: Compagnia Verifica formato CodIATA; Type: CHECK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE public."Compagnia"
    ADD CONSTRAINT "Verifica formato CodIATA" CHECK ((character_length("CodIATA") = 2)) NOT VALID;


--
-- TOC entry 2921 (class 2620 OID 131260)
-- Name: Gate AggiornamentoCodGateInTratta; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER "AggiornamentoCodGateInTratta" AFTER INSERT ON public."Gate" FOR EACH ROW EXECUTE FUNCTION public."UpdateCodGateInTratta"();


--
-- TOC entry 2918 (class 2620 OID 131264)
-- Name: Slot AggiornamentoCodSlotInCodaDiImbarco; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER "AggiornamentoCodSlotInCodaDiImbarco" AFTER INSERT ON public."Slot" FOR EACH ROW EXECUTE FUNCTION public."UpdateCodSlotInCodaDiImbarco"();


--
-- TOC entry 2924 (class 2620 OID 131266)
-- Name: Coda di imbarco AggiornamentoDataCorrettaCodaDiImbarco; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER "AggiornamentoDataCorrettaCodaDiImbarco" AFTER INSERT ON public."Coda di imbarco" FOR EACH ROW EXECUTE FUNCTION public."DataCorrettaCodaDiImbarco"();


--
-- TOC entry 2923 (class 2620 OID 172243)
-- Name: Gate AggiornamentoDataCorrettaGate; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER "AggiornamentoDataCorrettaGate" AFTER INSERT ON public."Gate" FOR EACH ROW EXECUTE FUNCTION public."DataCorrettaGate"();


--
-- TOC entry 2919 (class 2620 OID 131268)
-- Name: Slot AggiornamentoDataCorrettaSlot; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER "AggiornamentoDataCorrettaSlot" AFTER INSERT ON public."Slot" FOR EACH ROW EXECUTE FUNCTION public."DataCorrettaSlot"();


--
-- TOC entry 2922 (class 2620 OID 172242)
-- Name: Gate AggiornamentoNgateInGate; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER "AggiornamentoNgateInGate" AFTER INSERT ON public."Gate" FOR EACH ROW EXECUTE FUNCTION public."UpdateNgateInGate"();


--
-- TOC entry 2926 (class 2620 OID 147672)
-- Name: Biglietto AggiornamentoNprenotazioniDifferrenza; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER "AggiornamentoNprenotazioniDifferrenza" AFTER DELETE ON public."Biglietto" FOR EACH ROW EXECUTE FUNCTION public."DifferenzaNprenotazioni"();


--
-- TOC entry 2925 (class 2620 OID 147671)
-- Name: Biglietto AggiornamentoNprenotazioniSomma; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER "AggiornamentoNprenotazioniSomma" AFTER INSERT ON public."Biglietto" FOR EACH ROW EXECUTE FUNCTION public."SommaNprenotazioni"();


--
-- TOC entry 2920 (class 2620 OID 131191)
-- Name: Slot AggiornamentoRitardoTrue; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER "AggiornamentoRitardoTrue" AFTER UPDATE ON public."Slot" FOR EACH ROW EXECUTE FUNCTION public."ControlloRitardoTrue"();


--
-- TOC entry 2927 (class 2620 OID 172244)
-- Name: Tratta ControlloTrattaGate; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER "ControlloTrattaGate" AFTER INSERT ON public."Tratta" FOR EACH ROW EXECUTE FUNCTION public."VerificaTrattaGate"();


--
-- TOC entry 2914 (class 2606 OID 147701)
-- Name: Biglietto Biglietto_CodFiscale_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Biglietto"
    ADD CONSTRAINT "Biglietto_CodFiscale_fkey" FOREIGN KEY ("CodFiscale") REFERENCES public."Cliente"("CodFiscale") ON DELETE CASCADE NOT VALID;


--
-- TOC entry 2915 (class 2606 OID 164040)
-- Name: Biglietto Biglietto_CodTratta_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Biglietto"
    ADD CONSTRAINT "Biglietto_CodTratta_fkey" FOREIGN KEY ("CodTratta") REFERENCES public."Tratta"("CodTratta") ON DELETE CASCADE NOT VALID;


--
-- TOC entry 2913 (class 2606 OID 147681)
-- Name: Coda di imbarco Coda di imbarco_CodGate_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Coda di imbarco"
    ADD CONSTRAINT "Coda di imbarco_CodGate_fkey" FOREIGN KEY ("CodGate") REFERENCES public."Gate"("CodGate") ON DELETE CASCADE NOT VALID;


--
-- TOC entry 2912 (class 2606 OID 131197)
-- Name: Coda di imbarco Coda di imbarco_CodSlot_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Coda di imbarco"
    ADD CONSTRAINT "Coda di imbarco_CodSlot_fkey" FOREIGN KEY ("CodSlot") REFERENCES public."Slot"("CodSlot") NOT VALID;


--
-- TOC entry 2909 (class 2606 OID 147711)
-- Name: Fedeltà Fedeltà_CodFiscale_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Fedeltà"
    ADD CONSTRAINT "Fedeltà_CodFiscale_fkey" FOREIGN KEY ("CodFiscale") REFERENCES public."Cliente"("CodFiscale") ON DELETE CASCADE NOT VALID;


--
-- TOC entry 2908 (class 2606 OID 147706)
-- Name: Fedeltà Fedeltà_CodIATA_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Fedeltà"
    ADD CONSTRAINT "Fedeltà_CodIATA_fkey" FOREIGN KEY ("CodIATA") REFERENCES public."Compagnia"("CodIATA") ON DELETE CASCADE NOT VALID;


--
-- TOC entry 2911 (class 2606 OID 147686)
-- Name: Gate Gate_CodTratta_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Gate"
    ADD CONSTRAINT "Gate_CodTratta_fkey" FOREIGN KEY ("CodTratta") REFERENCES public."Tratta"("CodTratta") ON DELETE CASCADE NOT VALID;


--
-- TOC entry 2910 (class 2606 OID 147716)
-- Name: Slot Slot_CodCoda_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Slot"
    ADD CONSTRAINT "Slot_CodCoda_fkey" FOREIGN KEY ("CodCoda") REFERENCES public."Coda di imbarco"("CodCoda") ON DELETE CASCADE NOT VALID;


--
-- TOC entry 2917 (class 2606 OID 147721)
-- Name: Tratta Tratta_CodGate_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Tratta"
    ADD CONSTRAINT "Tratta_CodGate_fkey" FOREIGN KEY ("CodGate") REFERENCES public."Gate"("CodGate") NOT VALID;


--
-- TOC entry 2916 (class 2606 OID 147691)
-- Name: Tratta Tratta_CodIATA_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Tratta"
    ADD CONSTRAINT "Tratta_CodIATA_fkey" FOREIGN KEY ("CodIATA") REFERENCES public."Compagnia"("CodIATA") ON DELETE CASCADE NOT VALID;


-- Completed on 2021-02-05 16:41:41

--
-- PostgreSQL database dump complete
--

