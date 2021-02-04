package ControllerPackage;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import DAOPostgres.*;
import Entità.Biglietto;
import Entità.Cliente;
import Entità.CodaDiImbarco;
import Entità.Compagnia;
import Entità.Fedeltà;
import Entità.Gate;
import Entità.Slot;
import Entità.Tempistica;
import Entità.Tratta;
import GUI.BigliettoGUI;
import GUI.ClienteGUI;
import GUI.CodaDiImbarcoGUI;
import GUI.CompagniaGUI;
import GUI.Dialog;
import GUI.FedeltàGUI;
import GUI.GateGUI;
import GUI.MenùGUI;
import GUI.SlotGUI;
import GUI.TrattaGUI;
import RisultatiGUI.RisultatiBigliettoGUI;
import RisultatiGUI.RisultatiClienteGUI;
import RisultatiGUI.RisultatiCodaDiImbarcoGUI;
import RisultatiGUI.RisultatiCompagniaGUI;
import RisultatiGUI.RisultatiFedeltàGUI;
import RisultatiGUI.RisultatiGateGUI;
import RisultatiGUI.RisultatiSlotGUI;
import RisultatiGUI.RisultatiTempisticheGateGUI;
import RisultatiGUI.RisultatiTrattaGUI;

public class Controller {
	
	private SlotGUI slot;
	private MenùGUI menù;
	private GateGUI gate;
	private TrattaGUI tratta;
	private FedeltàGUI fedeltà;
	private CompagniaGUI compagnia;
	private CodaDiImbarcoGUI codaDiImbarco;
	private ClienteGUI cliente;
	private BigliettoGUI biglietto;
	
	private RisultatiSlotGUI risultatiSlot;
	private RisultatiGateGUI risultatiGate;
	private RisultatiTrattaGUI risultatiTratta;
	private RisultatiFedeltàGUI risultatiFedeltà;
	private RisultatiCompagniaGUI risultatiCompagnia;
	private RisultatiCodaDiImbarcoGUI risultatiCodaDiImbarco;
	private RisultatiClienteGUI risultatiCliente;
	private RisultatiBigliettoGUI risultatiBiglietto;
	private RisultatiTempisticheGateGUI risultatiTempisticheGateGUI; 
	private static SingletonPostgres singleton;
	
	public Controller() {
		menù = new MenùGUI(this);
		menù.setVisible(true);
		slot = new SlotGUI(this);
		tratta = new TrattaGUI(this);
 		fedeltà = new FedeltàGUI(this);
		compagnia = new CompagniaGUI(this);
		codaDiImbarco = new CodaDiImbarcoGUI(this);
		cliente = new ClienteGUI(this);
		biglietto = new BigliettoGUI(this);
		gate = new GateGUI(this);
		 
	}
	
	public static void main(String[] args) {

	Controller controller = new Controller();
	singleton = SingletonPostgres.getInstance();
	}
	
	
	
	
	public void openSlot() {
		if(risultatiSlot != null) {
			risultatiSlot.setVisible(false);
		}
		menù.setVisible(false);
		slot.setVisible(true);
	
	}
	
	public void openGate() {
		if(risultatiTempisticheGateGUI != null) {
			risultatiTempisticheGateGUI.setVisible(false);
		}
		
		if(risultatiGate != null) {
			risultatiGate.setVisible(false);
		}
		menù.setVisible(false);
		gate.setVisible(true);
		
	
	}
	
	public void openTratta() {
		if(risultatiTratta != null) {
			risultatiTratta.setVisible(false);
		}
		menù.setVisible(false);
		tratta.setVisible(true);
	
	}
	
	public void openFedeltà() {
		if(risultatiFedeltà != null) {
			risultatiFedeltà.setVisible(false);
		}
		menù.setVisible(false);
		fedeltà.setVisible(true);
	
	}
	
	public void openCompagnia() {
		if(risultatiCompagnia != null) {
			risultatiCompagnia.setVisible(false);
		}
		menù.setVisible(false);
		compagnia.setVisible(true);
	
	}
	
	public void openCodaDiImbarco() {
		if(risultatiCodaDiImbarco != null) {
			risultatiCodaDiImbarco.setVisible(false);
		}
		menù.setVisible(false);
		codaDiImbarco.setVisible(true);
	
	}
	
	public void openCliente() {
		if(risultatiCliente != null) {
			risultatiCliente.setVisible(false);
		}
		menù.setVisible(false);
		cliente.setVisible(true);
	
	}
	
	public void openBiglietto() {
		if(risultatiBiglietto != null) {
			risultatiBiglietto.setVisible(false);
		}
		menù.setVisible(false);
		biglietto.setVisible(true);
	}
	
	public void backToMenù() {
		biglietto.setVisible(false);
		cliente.setVisible(false);
		codaDiImbarco.setVisible(false);
		compagnia.setVisible(false);
		fedeltà.setVisible(false);
		tratta.setVisible(false);
		gate.setVisible(false);
		slot.setVisible(false);
		menù.setVisible(true);
	}
	
	

	
	public void openRisultatiGate(String ricerca, String valore, String data) {
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date date = null;
		try {
			date = sdf1.parse(data);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date sqlDate = new java.sql.Date(date.getTime());  
		
		
		GateDAOPostgres gatePostgres = new GateDAOPostgres(singleton);
		List<Gate> list = new LinkedList<Gate>();
		if(ricerca.equals("N gate")) {
			list = gatePostgres.getGateByNGate(valore, sqlDate);
		}
		else if(ricerca == "CodGate") {
			list.add(gatePostgres.getGateByCodGate(valore));
		}
		else if(ricerca == "CodTratta") {
			list.add(gatePostgres.getGateByCodTratta(valore));
		}
		
		risultatiGate = new RisultatiGateGUI(list, this);
		gate.setVisible(false);
		risultatiGate.setVisible(true);
		
	}
	
	public void openRisultatiTratta(String ricerca, String valore, String data) {
		
		TrattaDAOPostgres trattaPostgres = new TrattaDAOPostgres(singleton);
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date date = null;
		try {
			date = sdf1.parse(data);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date sqlDate = new java.sql.Date(date.getTime());  
		
		List<Tratta> list = new LinkedList<Tratta>();
		if(ricerca == "CodTratta") {
			list.add(trattaPostgres.getTrattaByCodTratta(valore));
		}
		else if(ricerca == "Data") {
			list = (trattaPostgres.getTrattaByData(sqlDate));
		}
		
		else if(ricerca == "CodIATA e data") {
			list = (trattaPostgres.getTrattaByCodIATA(valore, sqlDate));
		}
		
		else if(ricerca == "Destinazione e data") {
			list = (trattaPostgres.getTrattaByDestinazione(valore, sqlDate));
		}	
		
		
		risultatiTratta = new RisultatiTrattaGUI(list, this);
		tratta.setVisible(false);
		risultatiTratta.setVisible(true);
		
	}
	
	public void openRisultatiSlot(String ricerca, String valore) {
		
	
		
		
		SlotDAOPostgres slotPostgres = new SlotDAOPostgres(singleton);
		List<Slot> list = new LinkedList<Slot>();
		
		if(ricerca == "CodSlot") {
			list.add(slotPostgres.getSlotByCodSlot("CodSlot"));
		}
	
		else if(ricerca == "CodCoda") {
			list.add(slotPostgres.getSlotByCodCoda(valore));
			
		}
		
		else if(ricerca == "Data") {
			
			SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
			java.util.Date date = null;
			try {
				date = sdf1.parse(valore);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Date sqlDate = new java.sql.Date(date.getTime());  
			
			
			list = slotPostgres.getSlotByData(sqlDate);
			
		}
		
		risultatiSlot = new RisultatiSlotGUI(list, this);
		slot.setVisible(false);
		risultatiSlot.setVisible(true);
				
	}
	
	public void openRisultatiFedeltà(String ricerca, String valore) {
		
		FedeltàDAOPostgres fedeltàPostgres = new FedeltàDAOPostgres(singleton);
		
		List<Fedeltà> list = null;
		
		if(ricerca == "CentoKilometri") {
			list = fedeltàPostgres.getFedeltàByCentoKilometri(valore);
		}
		
		else if(ricerca == "CodiATA") {
			list = fedeltàPostgres.getFedeltàByCodIATA(valore);
		}
		
		else if(ricerca == "CodFiscale") {
			list = fedeltàPostgres.getFedeltàByCodFiscale(valore);
		}
		
		
		
		risultatiFedeltà = new RisultatiFedeltàGUI(list, this);
		fedeltà.setVisible(false);
		risultatiFedeltà.setVisible(true);
		
	}
	
	public void openRisultatiCompagnia(String ricerca, String valore) {
		CompagniaDAOPostgres compagniaPostgres= new CompagniaDAOPostgres(singleton);
		List<Compagnia> list = new LinkedList<Compagnia>();
		
		if (ricerca == "Seleziona tutti") {
			list = compagniaPostgres.getAllCompagnia();
		}
		
		else if(ricerca == "CodIATA") {
			list.add(compagniaPostgres.getCompagniaByCodIATA(valore));
		}
		
		else if(ricerca == "Nome Compagnia") {
			list.add(compagniaPostgres.getCompagniaByNomeCompagnia(valore));
		}
		risultatiCompagnia = new RisultatiCompagniaGUI(list, this);
		compagnia.setVisible(false);
		risultatiCompagnia.setVisible(true);
		
	}	
		
	public void openRisultatiCodaDiImbarco(String ricerca, String valore) {
		CodaDiImbarcoDAOPostgres codaDiImbarcoPostgres = new CodaDiImbarcoDAOPostgres(singleton);
		List<CodaDiImbarco> list = new LinkedList<CodaDiImbarco>();
		
	
		if(ricerca == "Codice Coda") {
			list.add(codaDiImbarcoPostgres.getCodaDiImbarcoByCodCoda(valore));
		}
		else if(ricerca == "Codice Slot") {
			list.add(codaDiImbarcoPostgres.getCodaDiImbarcoByCodSlot(valore));
		}
	
		else if(ricerca == "Codice Gate") {
			list.add(codaDiImbarcoPostgres.getCodaDiImbarcoByCodGate(valore));
		}
		risultatiCodaDiImbarco = new RisultatiCodaDiImbarcoGUI(list, this);
		codaDiImbarco.setVisible(false);
		risultatiCodaDiImbarco.setVisible(true);
	
	}
	
	public void openRisultatiCliente(String ricerca, String valore) {
		ClienteDAOPostgres clientePostgres = new ClienteDAOPostgres(singleton);
		List<Cliente> list = new LinkedList<Cliente>();
		
		if (ricerca == "Codice Fiscale") {
			list.add(clientePostgres.getClienteByCodFiscale(valore));	
		}
		risultatiCliente = new RisultatiClienteGUI(list, this);
		cliente.setVisible(false);
		risultatiCliente.setVisible(true);
	}
	
	public void openRisultatiBiglietto(String ricerca, String valore) {
		BigliettoDAOPostgres bigliettoPostgres = new BigliettoDAOPostgres(singleton);
		List<Biglietto> list = null;
		
		if(ricerca == "Codice Fiscale") {
			list = bigliettoPostgres.getBigliettoByCodFiscale(valore);
		}
		else if(ricerca == ("Codice Tratta") ) {
			list = bigliettoPostgres.getBigliettoByCodTratta(valore);
		}
		risultatiBiglietto = new RisultatiBigliettoGUI(list, this);
		biglietto.setVisible(false);
		risultatiBiglietto.setVisible(true);
	}
	
	public void openRisultatiTempisticheGateGUI(List<Tempistica> list, String scelta) { 
		risultatiTempisticheGateGUI = new RisultatiTempisticheGateGUI(list, this, scelta); 
		gate.setVisible(false); 
		risultatiTempisticheGateGUI.setVisible(true); 
	}
	
	public void inserisciTratta(String codTratta, String nPrenotazioni,String orarioDiPartenza, String data,String CodIATA, String destinazione, String scali) throws ParseException{
		
		if(checkBlank(codTratta, nPrenotazioni, orarioDiPartenza, data, CodIATA, destinazione, scali)) {
			return;
		}
		
		if(checkCodTratta(codTratta)) {
			return;
		}
		
		if(checkCodIATA(CodIATA)) {
			return;
		}
		
		if(checkSoloNumeri(nPrenotazioni)) {
			return;
		}
		
		if(checkSoloLettere(destinazione)) {
			return;
		}
		
		if(checkSoloLettere(scali)) {
			return;
		}
		
		
		
		
		int intNPrenotazioni = Integer.valueOf(nPrenotazioni);
		
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
		long ms = sdf.parse(orarioDiPartenza).getTime();
		Time tempo = new Time(ms);
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date date = sdf1.parse(data);
		Date sqlDate = new java.sql.Date(date.getTime());  
		
		TrattaDAOPostgres tratta = new TrattaDAOPostgres(singleton);
		String testo = tratta.insertTratta(codTratta, intNPrenotazioni, tempo, sqlDate,CodIATA, destinazione, scali);
		openDialog(testo);
	}
	
	public void inserisciCliente(String CodFiscale, String Nome, String Cognome, String Email) {
		
		if (checkBlank(CodFiscale, Nome, Cognome, Email)) {
			return;
		}
		
		if(checkCodFiscale(CodFiscale)) {
			return;
		}
		
		if(checkEmail(Email)) {
			return;
		}
		
		if(checkSoloLettere(Nome) || checkSoloLettere(Cognome)) {
			return;
		}
		
		
		
		ClienteDAOPostgres cliente = new ClienteDAOPostgres(singleton);
		String testo = cliente.insertCliente(CodFiscale, Nome, Cognome, Email);
		openDialog(testo);
	}

	public void inserisciCodaDiImbarco(String CodCoda, String TipoDiCoda, String CodGate) {
		
		if(checkBlank(CodCoda, TipoDiCoda, CodGate)) {
			return;
		}
		
		
		
		CodaDiImbarcoDAOPostgres codadiimbarco = new CodaDiImbarcoDAOPostgres(singleton);
		String testo = codadiimbarco.insertCodaDiImbarco(CodCoda, TipoDiCoda, CodGate);
		openDialog(testo);
	}

	public void inserisciInCompagnia(String CodIATA, String NomeCompagnia) {
		
		if(checkBlank(CodIATA, NomeCompagnia)) {
			return;
		}
		
		if(checkCodIATA(CodIATA)) {
			return;
		}
		
		if(checkSoloLettere(NomeCompagnia)) {
			return;
		}
		
		CompagniaDAOPostgres comp = new CompagniaDAOPostgres(singleton);
		String testo = comp.insertCompagnia(CodIATA, NomeCompagnia);
		openDialog(testo);
	}

	public void inserisciSlot(String CodSlot, String TempoDiImbarcoStimato, String TempoDiImbarcoEffettivo, String CodCoda) throws ParseException {
		
		
		if(checkBlank(CodSlot, TempoDiImbarcoStimato, TempoDiImbarcoEffettivo, CodCoda)) {
			return;
		}
		
		if(checkSoloNumeri(TempoDiImbarcoStimato, TempoDiImbarcoEffettivo)) {
			return;
		}
		
		if(checkSoloLettere(CodSlot)) {
			return;
		}
		
		
		SlotDAOPostgres slot = new SlotDAOPostgres(singleton);
		int tempoDiImbarcoStimato =  Integer.valueOf(TempoDiImbarcoStimato);
		int tempoDiImbarcoEffettivo =  Integer.valueOf(TempoDiImbarcoEffettivo);
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date date = null;
				
				
		String testo = slot.insertSlot(CodSlot,tempoDiImbarcoStimato,tempoDiImbarcoEffettivo, CodCoda);
		openDialog(testo);
	}

	public void inserisciFedeltà(String CentoKilometri, String CodIATA, String CodFiscale) {
		
		if(checkBlank(CentoKilometri, CodIATA, CodFiscale)) {
			return;
		}
		
		if(checkCodFiscale(CodFiscale)) {
			return;
		}
		
		if(checkCodIATA(CodIATA)) {
			return;
		}
		
		if(checkCentoKilometri(CentoKilometri)){
			return;
		}
		
		FedeltàDAOPostgres fedeltà = new FedeltàDAOPostgres(singleton);
		
		String testo = fedeltà.insertFedeltà(CentoKilometri, CodIATA, CodFiscale);
		openDialog(testo);
	}

	public void inserisciBiglietto(String CodFiscale, String TipoDiBiglietto, String CodBiglietto, String CodTratta, String Posto) {
		
		if(checkBlank(CodFiscale, TipoDiBiglietto, CodBiglietto, CodTratta, Posto)) {
			return;
		}
		
		if(checkCodFiscale(CodFiscale)) {
			return;
		}
		
		if(checkCodTratta(CodTratta)) {
			return;
		}
		
		if(checkSoloNumeri(CodBiglietto, Posto)) {
			return;
		}
		
		
		BigliettoDAOPostgres biglietto = new BigliettoDAOPostgres(singleton);
		String testo = biglietto.insertBiglietto(CodFiscale, TipoDiBiglietto, CodBiglietto, CodTratta, Posto);
		openDialog(testo);
	}
	
	public void inserisciGate(String CodGate, String Ngate, String CodTratta) {
		if(checkBlank(CodGate, Ngate, CodTratta)) {
			return;
		}

		if(checkCodTratta(CodTratta)) {
			return;
		}

		GateDAOPostgres gate = new GateDAOPostgres(singleton);
		String testo = gate.insertGate(CodGate, Ngate, CodTratta);
		openDialog(testo);
		}
	

	
	
	public void eliminaSlot(String CodSlot) {
		
		if(checkBlank(CodSlot)) {
			return;
		}
		
		if(checkSoloNumeri(CodSlot)) {
			return;
		}
		
		SlotDAOPostgres slot = new SlotDAOPostgres(singleton);
		String testo = slot.deleteSlot(CodSlot);
		openDialog(testo);
	}

	public void eliminaCodaDiImbarco(String CodCoda) {
		
		if(checkBlank(CodCoda)) {
			return;
		}
		
		CodaDiImbarcoDAOPostgres CodaDiImbarco = new CodaDiImbarcoDAOPostgres(singleton);
		String testo = CodaDiImbarco.deleteCodaDiImbarco(CodCoda);
		openDialog(testo);
	}

	public void eliminaBiglietto(String CodBiglietto) {
		
		if(checkBlank(CodBiglietto)) {
			return;
		}
		
		if(checkSoloNumeri(CodBiglietto)) {
			return;
		}
		
		
		BigliettoDAOPostgres biglietto = new BigliettoDAOPostgres(singleton);
		String testo = biglietto.deleteBiglietto(CodBiglietto);
		openDialog(testo);
	}

	public void eliminaCompagnia(String CodIATA) {
		
		if(checkBlank(CodIATA)) {
			return;
		}
		if(checkCodIATA(CodIATA)) {
			return;
		}
		
		CompagniaDAOPostgres compagnia= new CompagniaDAOPostgres(singleton);
		String testo = compagnia.deleteCompagnia(CodIATA);
		openDialog(testo);
	}

	public void eliminaCliente(String CodFiscale) {
		
		if(checkBlank(CodFiscale)) {
			return;
		}
		if(checkCodFiscale(CodFiscale)) {
			return;
		}
		
		ClienteDAOPostgres cliente = new ClienteDAOPostgres(singleton);
		String testo = cliente.deleteCliente(CodFiscale);
		openDialog(testo);
	}

	public void eliminaTratta(String CodTratta) {
		
		if(checkBlank(CodTratta)) {
			return;
		}
		
		TrattaDAOPostgres tratta = new TrattaDAOPostgres(singleton);
		String testo = tratta.deleteTratta(CodTratta);
		openDialog(testo);

	}

	public void eliminaFedeltà(String CodFiscale, String CodIATA) {  
		
		if(checkBlank(CodFiscale, CodIATA)) {
			return;
		}
		if(checkCodFiscale(CodFiscale)) {
			return;
		}
		
		if(checkCodIATA(CodIATA)) {
			return;
		}
		
		FedeltàDAOPostgres fedeltà = new FedeltàDAOPostgres(singleton);
		String testo = fedeltà.deleteFedeltà(CodFiscale);
		openDialog(testo);
	}
	
	public void eliminaGate(String CodGate) {
		if(checkBlank(CodGate)) {
			return;
		}
		
		GateDAOPostgres gate = new GateDAOPostgres(singleton);
		String testo = gate.deleteGate(CodGate);
		openDialog(testo);
	}
	
	
	
	
	
	public void aggiornaFedeltàCentokilometri(String CentoKilometri, String CodFiscale, String CodIATA) {
		if(checkCodIATA(CodIATA)) {
			return;
		}
		
		if(checkCodFiscale(CodFiscale)) {
			return;
		}

		
		FedeltàDAOPostgres fedeltà = new FedeltàDAOPostgres(singleton);
		
		
		
		String testo = fedeltà.updateCentoKilometriByCodFiscaleANDCodIATA(CentoKilometri, CodFiscale, CodIATA);
		openDialog(testo);
		
		
	}

	public void aggiornaFedeltàPunti(String Punti, String CentoKilometri, String CodIATA) {
		
		if(checkCodIATA(CodIATA)) {
			return;
		}
		
		if(checkSoloNumeri(Punti,CentoKilometri)) {
			return;
		}
		
		FedeltàDAOPostgres fedeltà = new FedeltàDAOPostgres(singleton);
		
		int punti = Integer.valueOf(Punti);
		
		
		String testo = fedeltà.updatePuntiByCentoKilometriANDCodIATA(CentoKilometri, punti, CodIATA);
		openDialog(testo);
	}

	public void aggiornaSlot(String IndicaCodSlot, String AggiornaTempoEffettivo) {
		
		if(checkSoloNumeri(IndicaCodSlot,AggiornaTempoEffettivo)) {
			return;
		}
		
		SlotDAOPostgres slot = new SlotDAOPostgres(singleton);
		
		int tempoEffettivo = Integer.valueOf(AggiornaTempoEffettivo);
		
		String testo = slot.updateTempoDiImbarcoEffettivoByCodSlot(tempoEffettivo, IndicaCodSlot);
		openDialog(testo);
	}
	
	
	
	
	
	public boolean checkBlank(String ... testi) {
		for(String testo:testi) {
			if(testo.isBlank()) {
				openDialog("Uno o più campi vuoti");
				
				return true;
			}
		}
		return false;
	}
	
	public boolean checkCodFiscale(String CF) {
		String espressioneCF = "^[A-Z]{6}[0-9]{2}[A-Z][0-9]{2}[A-Z][0-9]{3}[A-Z]$";
		if(!CF.matches(espressioneCF)) {
			openDialog("Codice Fiscale non corretto!");

			return true;
		}
		return false;
	}
	
	public boolean checkCodIATA(String cod) {
		String espressioneCodIATA = "^[A-Za-z]{2}$";
		if(!cod.matches(espressioneCodIATA)) {
			openDialog("Il codice IATA deve essere di 2 caratteri!");

			return true;
		}
		return false;
	}
	
	public boolean checkCodTratta(String cod) { 
		String espressioneCodTratta = "^[A-Za-z]{3}[A-Za-z0-9]*$";
		if(!cod.matches(espressioneCodTratta)) {
			openDialog("Il codice Tratta deve essere di 3 caratteri!");

			return true;
		}
		return false;
	}
	
	public boolean checkEmail(String email) {
		String espressioneEmail = "^[A-z0-9\\.\\+_-]+@[A-z0-9\\._-]+\\.[A-z]{2,6}$";
		if(!email.matches(espressioneEmail)) {
			openDialog("L'email non è corretta!");

			return true;
		}
		return false;
	}
	
	public boolean checkSoloLettere(String parola) {
		String espressioneSoloLettere = "^[A-Za-z]*$";
		if(!parola.matches(espressioneSoloLettere)) {
			openDialog("Una o più caselle devono avere solo Lettere!");

			return true;
		}
		return false;
	}
	
	public boolean checkSoloNumeri(String ... numeri ) {
		String espressioneSoloNumeri = "^[0-9]*$";
		for(String numero:numeri) {
			if(!numero.matches(espressioneSoloNumeri)) {
				openDialog("Una o più caselle devono avere solo Numeri!");

				return true;
			}
		}
		
		return false;
		
		
	}
	
	public boolean checkCentoKilometri (String parola) {
		String espressioneSoloLettere = "^[A-Za-z]*$";
		if(!parola.matches(espressioneSoloLettere)) {
			openDialog("Una o più caselle devono avere solo Lettere!");

			return true;
		}
		return false;
	}
	
	
	
	
	
	public void openDialog(String text) {
		Dialog dialog = new Dialog(text);
		dialog.setVisible(true);
	}
	
	
	
	
	
	public void ricercaTempisticaGiorniMese(String Ngate ,String mese, String anno) {
		
		if(this.checkSoloNumeri(Ngate)) {
			return;
		}
		
		GateDAOPostgres gateDAOP = new GateDAOPostgres(singleton);
		List<Tempistica> list = gateDAOP.getTempisticheGiorni(Ngate, mese, anno);
		this.openRisultatiTempisticheGateGUI(list, "Giorni");
	}
	
	public void ricercaTempisticaMesi(String Ngate ,String anno) {
		
		if(this.checkSoloNumeri(Ngate)) {
			return;
		}
		
		GateDAOPostgres gateDAOP = new GateDAOPostgres(singleton);
		List<Tempistica> list = gateDAOP.getTempisticheMesi(Ngate, anno);
		this.openRisultatiTempisticheGateGUI(list, "Mesi");
	}
	
	public void ricercaTempisticaSettimane(String Ngate , String anno) {
		
		if(this.checkSoloNumeri(Ngate)) {
			return;
		}
		
		GateDAOPostgres gateDAOP = new GateDAOPostgres(singleton);
		List<Tempistica> list = gateDAOP.getTempisticheSettimane(Ngate, anno);
		this.openRisultatiTempisticheGateGUI(list, "Settimane");
	}

	public void ricercaRitardi(String CentoKilometri) {
		FedeltàDAOPostgres fedeltàDAOP = new FedeltàDAOPostgres(singleton);
		int NumeroRitardi = fedeltàDAOP.GetRitardi(CentoKilometri);
		risultatiFedeltà = new RisultatiFedeltàGUI(NumeroRitardi, this);
		fedeltà.setVisible(false);
		risultatiFedeltà.setVisible(true);
	}
	

}


