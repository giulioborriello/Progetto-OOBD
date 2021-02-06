INSERT INTO public."Compagnia"(
	"CodIATA", "Nome compagnia")
	VALUES ('EJ', 'EasyJet');

INSERT INTO public."Compagnia"(
	"CodIATA", "Nome compagnia")
	VALUES ('AL', 'Alitalia');

INSERT INTO public."Compagnia"(
	"CodIATA", "Nome compagnia")
	VALUES ('IA', 'IndiaAirlines');

INSERT INTO public."Cliente"(
	"CodFiscale", "Nome", "Cognome")
	VALUES ('BRRGLI00R23F839F', 'Giulio','Borriello');

INSERT INTO public."Cliente"(
	"CodFiscale", "Nome", "Cognome")
	VALUES ('GRCPMN80D08F839U', 'Paolo','Greco');

INSERT INTO public."Fedeltà"(
	"CodIATA", "CodFiscale", "Punti", "CentoKilometri")
	VALUES ('EJ', 'BRRGLI00R23F839F',0,  'GBR');

INSERT INTO public."Tratta"(
	"CodTratta", "Nprenotazioni", "OrarioDiPartenza", "Data", "CodIATA", "Destinazione", "Scali", "CodGate", "Ritardo", "Ngate")
	VALUES ('AAA', 0, '12:00:00', '23/10/2000', 'EJ', 'Roma', null, null, null, 1);

INSERT INTO public."Tratta"(
	"CodTratta", "Nprenotazioni", "OrarioDiPartenza", "Data", "CodIATA", "Destinazione", "Scali", "CodGate", "Ritardo", "Ngate")
	VALUES ('BBB', 0, '14:00:00', '23/10/2000', 'AL', 'Parigi', null, null, null, 2);

INSERT INTO public."Tratta"(
	"CodTratta", "Nprenotazioni", "OrarioDiPartenza", "Data", "CodIATA", "Destinazione", "Scali", "CodGate", "Ritardo", "Ngate")
	VALUES ('CCC', 0, '17:00:00', '23/10/2000', 'IA', 'Nuova_Delhi', null, null, null, 2);

INSERT INTO public."Gate"(
	"CodGate", "CodTratta", "Ngate", "Data")
	VALUES ('AA', 'AAA', null, null);

INSERT INTO public."Gate"(
	"CodGate", "CodTratta", "Ngate", "Data")
	VALUES ('BB', 'BBB', null, null);

INSERT INTO public."Gate"(
	"CodGate", "CodTratta", "Ngate", "Data")
	VALUES ('CC', 'CCC', null, null);

INSERT INTO public."Coda di imbarco"(
	"CodCoda", "Tipo di coda", "CodGate", "CodSlot", "Data")
	VALUES ('AA', 'Business Class', 'AA', null, null);


INSERT INTO public."Coda di imbarco"(
	"CodCoda", "Tipo di coda", "CodGate", "CodSlot", "Data")
	VALUES ('BB', 'Priority', 'BB', null, null);


INSERT INTO public."Coda di imbarco"(
	"CodCoda", "Tipo di coda", "CodGate", "CodSlot", "Data")
	VALUES ('CC', 'Family', 'CC', null, null);

INSERT INTO public."Slot"(
	"CodSlot", "TempoDiImbarcoStimato", "TempoDiImbarcoEffettivo", "Data", "CodCoda")
	VALUES ('AA', '20', null, null, 'AA');

INSERT INTO public."Slot"(
	"CodSlot", "TempoDiImbarcoStimato", "TempoDiImbarcoEffettivo", "Data", "CodCoda")
	VALUES ('BB', '30', null, null, 'BB');

INSERT INTO public."Slot"(
	"CodSlot", "TempoDiImbarcoStimato", "TempoDiImbarcoEffettivo", "Data", "CodCoda")
	VALUES ('CC', '10', null, null, 'CC');

INSERT INTO public."Biglietto"(
	"CodFiscale", "Tipo di biglietto", "CodBiglietto", "CodTratta", "Posto")
	VALUES ( 'BRRGLI00R23F839F', 'Family', '1', 'AAA', '10');

INSERT INTO public."Biglietto"(
	"CodFiscale", "Tipo di biglietto", "CodBiglietto", "CodTratta", "Posto")
	VALUES ( 'BRRGLI00R23F839F', 'Family', '2', 'BBB', '20');

INSERT INTO public."Biglietto"(
	"CodFiscale", "Tipo di biglietto", "CodBiglietto", "CodTratta", "Posto")
	VALUES ( 'GRCPMN80D08F839U', 'Business Class', '3', 'CCC', '30');





