import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Kompozicija extends Mapa{
	private ArrayList<Lokomotiva> lokomotive = new ArrayList<Lokomotiva>();
	private ArrayList<Vagon> vagoni = new ArrayList<Vagon>();
	private int brojLokomotiva;
	private int brojVagona;
	private static final int brojStanica = 4;//maksimalno moze da prodje 4 stanice
	private String[] stanice = new String[brojStanica];
	private final static Logger loger = Logger.getLogger(Kompozicija.class.getName());
	private static BufferedReader procitaj = null;
	private String putanja;
	private int[] pozicijaStaniceA = new int[4];//2 ulaza na stanicu
	private int[] pozicijaStaniceB = new int[4];//2 ulaza na stanicu
	private int[] pozicijaStaniceC = new int[6];//3 ulaza na stanicu
	private int[] pozicijaStaniceD = new int[2];//1 ulaz na stanicu
	private int[] pozicijaStaniceE = new int[4];//2 ulaza na stanicu
	private String id;
	Mapa mapa;
	private static int brojPredjenihPolja =0 ;
	
	public Kompozicija() {
		super();
	}
	
	public Kompozicija(Object[][] mapa) { 
		super(mapa);
	}
	

	
	public void setId(String id) {
		this.id = id;
	}
	public void setBrojLokomotiva(int brojLokomotiva) {
		this.brojLokomotiva = brojLokomotiva;
	}
	
	public void setBrojVagona(int brojVagona) {
		this.brojVagona = brojVagona;
	}
	
	/**	Obratiti paznju - stavlja osam this.mapa = mapa, pravilno je da mijenjam RODITELJSKI objekat!*/
	public void setMapa(Object[][] mapa) {
		super.setMapa(mapa);
	}
	
	public void setKompozicije(ArrayList<Kompozicija> kompozicije) {
		super.setKompozicije(kompozicije);
	}
	
	//mora ici getID umjesto getId jer mi kompajler javlja gresku da overrajdam Thread metodu getId
	public String getID() {
		return id;
	}
	
	public int getBrojPredjenihPolja() {
		return brojPredjenihPolja;
	}
	public String vratiStanicu(int index) {
		return stanice[index];
	}
	
	/** Smatrati da kompozicija krece od neke stanice i zavrsava sa nekom drugom(maks 4 stanice) */
	public void setStanice(String[] stanice) {
		this.stanice = stanice;
	}
	
	public int getBrojLokomotiva() {
		return brojLokomotiva;
	}
	
	public int getBrojVagona() {
		return brojVagona;
	}
	
	public void postaviMapu(Mapa mapa) {
		this.mapa = mapa;
	}
	
	/**	Metoda koja inicijalizuje pozicije gdje se nalaze stanice. */
	public void postaviStanice() {
		//pozicija kada se ide od mape do stanice A
		pozicijaStaniceA[0] = 28; // i;
		pozicijaStaniceA[1] = 2; //j
		//pozicija stanice kada se ide od A prema B
		pozicijaStaniceA[2] = 27; //i + 1
		pozicijaStaniceA[3] = 2; //j+1
		
		//pozicija stanice  kada se ide od A do B
		pozicijaStaniceB[0] = 6; //i
		pozicijaStaniceB[1] = 6; //j
		//pozicija stanice B kada se ide od C ka B
		pozicijaStaniceB[2] = 6; //i+1
		pozicijaStaniceB[3] = 7; //j+1
		
		//pozicija stanice C kada se ide od B 
		pozicijaStaniceC[0] = 12;//i
		pozicijaStaniceC[1] = 19;//j
		//pozicija stanice C kada se ide od D
		pozicijaStaniceC[2] = 12;//i 
		pozicijaStaniceC[3] = 20;//j+1
		//pozicija stanice C kada se ide od E
		pozicijaStaniceC[4] = 13;//i+1
		pozicijaStaniceC[5] = 20;//j
		
		//pozicija stanice D kada se ide od C prema D
		pozicijaStaniceD[0] = 1;//i
		pozicijaStaniceD[1] = 26;//j
				
		//pozicija stanice E kada se ide od C prema E(i kada se ide uopsteno)
		pozicijaStaniceE[0] = 25;//i
		pozicijaStaniceE[1] = 26;//j

 	}
	
	/**	Broj fajlova unutar foldera gdje se nalaze txt fajlovi za kompozicije i linije. */
	public int brojKompozicija() {
		int brojKompozicija;
		File direktorijum = new File(putanja);
		int brojFajlova = direktorijum.list().length; //broj fajlova u folderu - parovi kompozicija i linija
		brojKompozicija = brojFajlova / 2; // jer ce za svaki fajl kompozicije biti fajl linija
		return brojKompozicija;
	}
	
	//iz nekog razloga mi prijavljuje gresku kad ne stavim u metodu 
	public void setLogerLevel() {
		loger.setLevel(Level.ALL);
	}
	
	
	/**	Metoda za citanje putanje iz konfiguracionog fajla. */
	public void iscitajPutanju(String file) {
		BufferedReader iscitajPutanju = null ; //desavalo mi se da nece da ucita kada ga odmah napravim
		try{
			iscitajPutanju = new BufferedReader(new FileReader(file));
			String pomocni;
			if((pomocni = iscitajPutanju.readLine()) != null) {
				String[] linija = pomocni.split("#");
				putanja = linija[5];//jer ce u konfiguracionom fajlu putanja biti naznacena poslije 4-te #
			}
		}catch(Exception e) {
			loger.log(Level.ALL, "Problemi sa citanjem iz fajla",e); //hvatanje pomocu Logera
		}
		
	}
	
	/**	Metoda za dodavanje lokomotive u kompoziciju 
	 * 
	 * @param lokomotiva reperezentuje objekat klase Lokomotiva.
	 * 
	 */
	public void dodajLokomotivu(Lokomotiva lokomotiva) {
		//ako je prazna kolekcija dodaj lokomotivu
		if(lokomotive.isEmpty()) { 	
			this.lokomotive.add(new Lokomotiva(lokomotiva.getTipLokomotive(), lokomotiva.getVrstaPogonaLokomotive(), lokomotiva.getSnaga(), lokomotiva.getOznaka()));
		}
		else {
			//provjera za tip lokomotive! (moraju biti jednaki tipovi lokomotive ili univerzalna - drugi tip lokomotive slucaj )
			 if( !(lokomotive.get(0).getTipLokomotive().equals(lokomotiva.getTipLokomotive())) && !(lokomotive.get(0).getTipLokomotive().equals("univerzalna")) && !(lokomotiva.getTipLokomotive().equals("univerzalna"))){
				System.out.println("Nije moguce dodati datu lokomotivu u kompoziciju jer nije jednak tip lokomotive!");
			}
			else {
				this.lokomotive.add(new Lokomotiva(lokomotiva.getTipLokomotive(), lokomotiva.getVrstaPogonaLokomotive(), lokomotiva.getSnaga(), lokomotiva.getOznaka()));
			}
		}
	}
	
	/**	Eventualno je moguce unutar main-a ograniciti da se ne poziva metoda za 
	 * 	tip vagona koji nije isti kao tip lokomotive
	 * @param vagonPutnicki reprezentuje objekat klase VagonPutnicki
	 */
	//napomena za mene -> Dok nije VagonPutnicki naslijedio Vagon, ovo nije moglo proci
	public void dodajVagonPutnicki(VagonPutnicki vagonPutnicki) {
		this.vagoni.add(new VagonPutnicki(vagonPutnicki.getDuzina(), vagonPutnicki.getOznaka(), vagonPutnicki.getBrojMjesta()));
	}
	
	/**
	 * Metoda za dodavanje vagona - restoran u kompoziciju.
	 * @param vagonRestoran reprezentuje objekat klase VagonRestoran.
	 */
	public void dodajVagonRestoran(VagonRestoran vagonRestoran) {
		this.vagoni.add(new VagonRestoran(vagonRestoran.getDuzina(), vagonRestoran.getOznaka(), vagonRestoran.getOpis()));
	}
	
	/**
	 * Metoda za dodavanje teretnog vagona u kompoziciju.
	 * @param vagonTeretni reprezentuje objekat klase VagonTeretni.
	 */
	public void dodajVagonTeretni(VagonTeretni vagonTeretni) {
		this.vagoni.add(new VagonTeretni(vagonTeretni.getDuzina(), vagonTeretni.getOznaka(), vagonTeretni.getMaksimalnaNosivost()));
	}
	
	
	@Override
	public void run() {
		int brojac=0;
		
		
		
		//stanice[brojac] je pocetna stanica, stanice[brojac+1] sledeca stanica
		try {
			
			// da li je pametno porediti char sa 0 ?! // proces se ponavlja dok ima stanica do kojih kompozicija nije dosla
			while( (!(stanice[brojac] == null) ) && ( !(stanice[brojac+1] == null ))) {
				
				
				/*slucaj kada ide od A do B -> TESTIRANO radi dobro(testirano za jednu kompoziciju, sada i za 2 kompozicije)*/
				if( ("A".equals(stanice[brojac])) && ("B".equals(stanice[brojac+1])) ) {
					//inicijalizacija pocetne tacke tj. stanice A
					while(provjeriSmjerBA()) {
						Thread.sleep(1000);
					}
					int[] pozicijaStaniceA = new int[2]; 
					pozicijaStaniceA = this.vratiPozicijuStaniceA();
					System.out.println("BREAK POINT 3.1 pozicija stanice A je : " + pozicijaStaniceA[0] + " " +pozicijaStaniceA[1]);
					int indexVrsta = pozicijaStaniceA[0];
					int indexKolona = pozicijaStaniceA[1];
					//super.postaviDionicuAB();//nece da radi bez ovog ! Kao da je mapa izmjenjena .. 
					boolean kretanje = false; //okidac o saznanju da li je kompozicija krenula
					
					System.out.println("BREAK POINT PROVJERI SMJER AB :  " + this.provjeriSmjerAB());
		
					System.out.println("BREAK POINT PROVJERI DIONICU AB : " + this.provjeriDionicuAB());
					if(super.provjeriSmjerAB()){
						System.out.println("Koja kompozicija se uspavala ? " + this.getID());
						Thread.sleep(10000);
					}
				
					
					while(!(kretanje)) {
						System.out.println("Provjera dionice u run metodi : " + this.provjeriDionicuAB());
						//ako vec ima neko na prugi, odpsavaj da ne bi doslo do utrkivanj 
						if(super.provjeriSmjerAB()){
							System.out.println("Koja kompozicija se uspavala ? " + this.getID());
							Thread.sleep(10000);
						}
						
						

						if((provjeriDionicuAB()) ) { //zbog cega ovde radi samo kada sam stavio !iskaz ? 
							System.out.println("BREAK POINT 5: Kompozicija " + this.getID() + "  se nalaz na polju: " + (indexVrsta) + " " + indexKolona );
							kretanje = true;
							brojac++; //ako je krenuo - uvecaj brojac da moze preci na drugu stanicu kada stigne]
							if(super.provjeriSmjerAB()){
								System.out.println("Koja kompozicija se uspavala ? " + this.getID());
								Thread.sleep(10000);
							}
							while(!(this.provjeraDaLiJeKompozicijaStiglaNaStanicuBpravacA(indexVrsta, indexKolona))) {
								
								
								
								System.out.println("BREAK POINT DA LI JE STIGAO NA STANICU!");
								System.out.println();
								System.out.println("=============================================");
								
								if(this.brojPredjenihPolja ==5) {
									super.setResurs(false);
								}
								/*prvi slucaj - provjeri gore*/ //paznja sklonjeno dis !
								if((this.prugaProvjeriGore(indexVrsta, indexKolona))) {
									System.out.println("BREAK POINT 7: Lokomotiva " + this.lokomotive.get(0).getOznaka() + " se nalaz na polju: " + (indexVrsta) + " " + indexKolona );
									//prijavljuje kompajler gresku ako ih ne inicijalizujem
									int indexVrstaZadnjegElementa = 0;
									int indexKolonaZadnjegElementa = 0;
									String poljePomocno = null;
									System.out.println("BREAK POINT 7.1 Indeksi su : " + indexVrsta + " " + indexKolona);
									System.out.println();

									
									System.out.println();

									this.zauzmiPoziciju(indexVrsta-1, indexKolona, this);
									this.brojPredjenihPolja++;
									System.out.println("BREAK POINT PROVJERI SMJER AB KAD JE VOZ KRENUO:  " + this.provjeriSmjerAB());
									if(provjeriSmjerAB()) {
										Thread.sleep(2000);
									}
									System.out.println("BREAK POINT PROVJERI DIONICU AB KAD JE VOZ KRENUO : " + this.provjeriDionicuAB());

					
									this.oslobodiPoziciju(indexVrsta, indexKolona);
									indexVrsta--;//smanji vrstu jer se ide gore
									int brojPolja = this.getBrojLokomotiva() + this.getBrojVagona() - 1;//oduzima se vodeca lokomotiva
									//zauzmi i sve ostale pozicije ako je to moguce (ako je pruga u pitanju)
									
									//sve promjenljive ovde inicijalizovati -> Mogla se desiti masovna greska da su promjenljive ostale unutar while
									int indexVrstaElemenata = indexVrsta;
									int indexKolonaElemenata = indexKolona;
									while(brojPolja>0) {
										
										
										
										if(this.provjeriTrenutnuPoziciju(indexVrstaElemenata, indexKolonaElemenata)) {
											this.zauzmiPoziciju(indexVrstaElemenata, indexKolonaElemenata, this);
										}
										
										//gledaj suprotno od tog gdje je vodeca lokomotiva -> najcesci slucaj
										if(this.prugaProvjeriDole(indexVrstaElemenata, indexKolonaElemenata)) {
											zauzmiPoziciju(indexVrstaElemenata+1, indexKolonaElemenata, this);
											brojPredjenihPolja++;

											oslobodiPoziciju(indexVrstaElemenata, indexKolonaElemenata);
											
											System.out.println("BREAK POINT 8: Kompozicija se nalaz na polju: " + (indexVrstaElemenata) + " " + indexKolonaElemenata );

											indexVrstaElemenata++; 
											System.out.println("BREAK POINT 8.1 : INDEX VRSTE ELEMENTA JE : " + indexVrstaElemenata);
										}
										else if(/*(this.prugaProvjeriDole(indexVrstaElemenata, indexKolonaElemenata) &&*/ this.prugaProvjeriLijevo(indexVrstaElemenata, indexKolonaElemenata)){
											this.zauzmiPoziciju(indexVrstaElemenata, indexKolonaElemenata-1, this);
											System.out.println("BREAK POINT 9: Kompozicija se nalaz na polju: " + (indexVrsta) + " " + indexKolona );
											brojPredjenihPolja++;

											this.oslobodiPoziciju(indexVrstaElemenata, indexKolonaElemenata);
											indexKolonaElemenata--;
										}
										else if(this.prugaProvjeriDesno(indexVrstaElemenata, indexKolonaElemenata)) {
											this.zauzmiPoziciju(indexVrstaElemenata, indexKolonaElemenata+1, this);
											System.out.println("BREAK POINT 10: Kompozicija se nalaz na polju: " + (indexVrsta) + " " + indexKolona );
											brojPredjenihPolja++;

											this.oslobodiPoziciju(indexVrstaElemenata, indexKolonaElemenata);
											indexKolonaElemenata++;
										}
										else {
											System.out.println("Dio kompozicije + " + (brojPolja) + " se nalaze na stanici!");
										}
										
										if(brojPolja == 1) {
											this.oslobodiPoziciju(indexVrstaElemenata, indexKolonaElemenata);
										}
										brojPolja--;
										
									}
									/*
									this.oslobodiPoziciju(indexVrstaZadnjegElementa, indexKolonaZadnjegElementa, );//oslobodi zadnje poljeZadnje
									this.oslobodiPoziciju(indexVrsta, indexKolona, "");*/
									
									//indexVrsta--;//smanji vrstu jer se ide gore
									Thread.sleep(500);
								}
								
								/*drugi slucaj provjeri desno ako nije gore (da li je suvisan uslov za gore ? )*/
								else if( !(this.prugaProvjeriGore(indexVrsta, indexKolona)) && (this.prugaProvjeriDesno(indexVrsta, indexKolona)) ) {
									
									System.out.println("BREAK POINT 8: Kompozicija se nalaz na polju: " + (indexVrsta) + " " + indexKolona );

									int indexVrstaZadnjegElementa = 0;
									int indexKolonaZadnjegElementa = 0;
									String poljePomocno = null;
									
									this.zauzmiPoziciju(indexVrsta, indexKolona+1, this);
									//poljePomocno = this.provjeriPolje(indexVrsta, indexKolona);
									this.oslobodiPoziciju(indexVrsta, indexKolona);
									indexKolona++;//uvecaj kolone jer se ide desno
									
									int indexVrstaElemenata = indexVrsta;
									int indexKolonaElemenata = indexKolona;

									int brojPolja = this.getBrojLokomotiva() + this.getBrojVagona() - 1;
									
									while(brojPolja > 0) {
										
										System.out.println("Kompozicija dio " + brojPolja+ " se nalaz na polju: " + (indexVrstaElemenata) + " " + indexKolonaElemenata );

										
										//prvi slucaj provjeri suprotno(ako je lokomotiva otisla desno - provjeri lijevo
										if(this.prugaProvjeriLijevo(indexVrstaElemenata, indexKolonaElemenata)){
											this.zauzmiPoziciju(indexVrstaElemenata, indexKolonaElemenata-1, this);
											System.out.println("BREAK POINT LIJEVO ZAUZMI : Kompozicija se nalaz na polju: " + (indexVrsta) + " " + indexKolona );

											this.oslobodiPoziciju(indexVrstaElemenata, indexKolonaElemenata);
											indexKolonaElemenata--;
										}
										else if(this.prugaProvjeriDole(indexVrstaElemenata, indexKolonaElemenata)) {
											this.zauzmiPoziciju(indexVrstaElemenata+1, indexKolonaElemenata, this);
											
											this.oslobodiPoziciju(indexVrstaElemenata, indexKolonaElemenata);
											
											System.out.println("BREAK POINT LIJEVO DOLE: Kompozicija se nalaz na polju: " + (indexVrstaElemenata) + " " + indexKolonaElemenata );

											indexVrstaElemenata++; 
										}
										else if(this.prugaProvjeriGore(indexVrstaElemenata, indexKolonaElemenata)) {
											this.zauzmiPoziciju(indexVrstaElemenata-1, indexKolonaElemenata, this);
											this.oslobodiPoziciju(indexVrstaElemenata, indexKolonaElemenata);
											indexVrstaElemenata--;
										}
										else {
											System.out.println("Dio kompozicije + " + (brojPolja) + "se nalaze na stanici!");
										}
										
										if(brojPolja == 1) {
											this.oslobodiPoziciju(indexVrstaElemenata, indexKolonaElemenata);
										}
										
										brojPolja--;
									}
									
									//this.oslobodiPoziciju(indexVrstaZadnjegElementa, indexKolonaZadnjegElementa, poljeZadnje);
									//indexKolona++;//uvecaj kolone jer se ide desno
									System.out.println("BREAK POINT DESNO -> INDEXI SU: " + indexVrsta + " " + indexKolona);
									
										
									Thread.sleep(500);
									
								}
								/*treci slucaj provjeri lijevo ako nije desno i gore*/
								else if( !(prugaProvjeriGore(indexVrsta, indexKolona)) && !(prugaProvjeriDesno(indexVrsta, indexKolona)) && (prugaProvjeriLijevo(indexVrsta, indexKolona))) {
									int indexVrstaZadnjegElementa = 0;
									int indexKolonaZadnjegElementa = 0;
									String poljeZadnje = null;
									String poljePrvo = null;
									
									System.out.println("Kompozicija se nalaz na polju: " + (indexVrsta) + " " + indexKolona );

									zauzmiPoziciju(indexVrsta, indexKolona-1, this);
									oslobodiPoziciju(indexVrsta, indexKolona);
									indexKolona--;//smanj kolone jer se ide lijevo
									
									int indexVrstaElemenata = indexVrsta;
									int indexKolonaElemenata = indexKolona;

									int brojPolja = this.getBrojLokomotiva() + this.getBrojVagona() - 1;
									
									while(brojPolja > 0) {
										
										System.out.println("Kompozicija dio " + brojPolja+ " se nalaz na polju: " + (indexVrstaElemenata) + " " + indexKolonaElemenata );
										
										
										//provjeri suprotno od lokomotive -> otisla lijevo - provjeri desno
										if(prugaProvjeriDesno(indexVrstaElemenata, indexKolonaElemenata)) {
												zauzmiPoziciju(indexVrstaElemenata, indexKolonaElemenata+1, this);
												indexKolonaElemenata++;
										}
										else if(prugaProvjeriDole(indexVrstaElemenata, indexKolonaElemenata)) {
											this.zauzmiPoziciju(indexVrstaElemenata+1, indexKolonaElemenata, this);
											indexVrstaElemenata++; 
										}
										else if(prugaProvjeriGore(indexVrstaElemenata, indexKolonaElemenata)) {
											this.zauzmiPoziciju(indexVrstaElemenata-1, indexKolonaElemenata, this);
											indexVrstaElemenata--;
										}
										else {
											System.out.println("Dio kompozicije + " + (brojPolja) + "se nalaze na stanici!");
										}
										brojPolja--;
									}
									//this.oslobodiPoziciju(indexVrstaZadnjegElementa, indexKolonaZadnjegElementa);
									//indexKolona--;//smanj kolone jer se ide lijevo
									Thread.sleep(500);
								 }
							}
							System.out.println("=============================================");

							
							//Kada kompozicije stigne na stanicu - izmjesti je sa pruge
							if((this.provjeraDaLiJeKompozicijaStiglaNaStanicuBpravacA(indexVrsta, indexKolona))) {
								System.out.println("Vodeca lokomotiva je stigla na stanicu !");
								this.oslobodiPoziciju(indexVrsta, indexKolona);
								this.zauzmiPoziciju(indexVrsta, indexKolona-1, this);//skloni je lijevo od pruge(simuliraj dolazak na kolosijek stanice)
								int indexVrstaElemenata = indexVrsta;
								int indexKolonaElemenata = indexKolona;
								System.out.println("BREAK POINT STANICA - INDEKSI SU " + indexVrstaElemenata + " " + indexKolonaElemenata);
								int brojPolja = this.getBrojVagona() + this.getBrojLokomotiva() - 1;
								while(brojPolja > 0) {
									//System.out.println(" BREAK POINT dolazak kompozicija na stanicu");
									if((this.provjeraDaLiJeKompozicijaStiglaNaStanicuBpravacA(indexVrstaElemenata, indexKolonaElemenata))) {
										//if(this.prugaProvjeriGore(indexVrstaElemenata, indexKolonaElemenata)) {
											System.out.println("Dio kompozicije " + brojPolja + " je stigao na stanicu");
											this.zauzmiPoziciju(indexVrstaElemenata, indexKolonaElemenata-1, this);
											this.oslobodiPoziciju(indexVrstaElemenata, indexKolonaElemenata);
											brojPolja--;
										//}
									}
								}
							}
						}
						else {
							//odpsavaj 4 sekundi pa opet provjeri
							Thread.sleep(4000);
						}
						
					}
					postaviDionicuAB();//nakon sto je voz prosao dionicu vrati je na normalnu 
					System.out.println("************************************");
					System.out.println("Kompozicija " + this.getID() + " je stigla do stanice");
					System.out.println("************************************");

				}
				
			
				/*slucaj kada ide od B ka A*/ 
				else if( ("B".equals(stanice[brojac])) && ("A".equals(stanice[brojac+1])) ) {
					//inicijalizacija pocetne tacke tj. stanice A
					while(provjeriSmjerBA()) {
						Thread.sleep(1000);
					}
					int[] pozicijaStaniceA = new int[2]; 
					pozicijaStaniceA = this.vratiPozicijuStaniceA();
					System.out.println("BREAK POINT 3.1 pozicija stanice A je : " + pozicijaStaniceA[0] + " " +pozicijaStaniceA[1]);
					int indexVrsta = pozicijaStaniceB[0];
					int indexKolona = pozicijaStaniceB[1];
					//super.postaviDionicuAB();//nece da radi bez ovog ! Kao da je mapa izmjenjena .. 
					boolean kretanje = false; //okidac o saznanju da li je kompozicija krenula
					
					System.out.println("BREAK POINT PROVJERI SMJER AB :  " + this.provjeriSmjerBA());
		
					System.out.println("BREAK POINT PROVJERI DIONICU AB : " + this.provjeriDionicuAB());
				
					if(super.provjeriSmjerBA()){
						System.out.println("Koja kompozicija se uspavala ? " + this.getID());
						Thread.sleep(10000);
					}
					
					while(!(kretanje)) {
						System.out.println("Provjera dionice u run metodi : " + this.provjeriDionicuAB());
						//ako vec ima neko na prugi, odpsavaj da ne bi doslo do utrkivanj 
						if(super.provjeriSmjerBA()){
							System.out.println("Koja kompozicija se uspavala ? " + this.getID());
							Thread.sleep(10000);
						}
						
						

						if((provjeriDionicuAB())) { //zbog cega ovde radi samo kada sam stavio !iskaz ? 
							System.out.println("BREAK POINT 5: Kompozicija " + this.getID() + "  se nalaz na polju: " + (indexVrsta) + " " + indexKolona );
							kretanje = true;
							brojac++; //ako je krenuo - uvecaj brojac da moze preci na drugu stanicu kada stigne]
							if(super.provjeriSmjerAB()){
								System.out.println("Koja kompozicija se uspavala ? " + this.getID());
								Thread.sleep(10000);
							}
							while(!(this.provjeraDaLiJeKompozicijaStiglaNaStanicuApravacB(indexVrsta, indexKolona))) {
								
								
								
								System.out.println("BREAK POINT DA LI JE STIGAO NA STANICU!");
								System.out.println();
								System.out.println("=============================================");
								
								if(this.brojPredjenihPolja ==5) {
									super.setResurs(false);
								}
								/*prvi slucaj - provjeri lijevo*/ //paznja sklonjeno dis !
								if((prugaProvjeriLijevo(indexVrsta, indexKolona))) {
									System.out.println("BREAK POINT BA: Lokomotiva " + this.lokomotive.get(0).getOznaka() + " se nalaz na polju: " + (indexVrsta) + " " + indexKolona );
									System.out.println("BREAK POINT BA.1 Indeksi su : " + indexVrsta + " " + indexKolona);
									System.out.println();

									
									System.out.println();

									zauzmiPoziciju(indexVrsta, indexKolona-1, this);
									this.brojPredjenihPolja++;
									System.out.println("BREAK POINT PROVJERI SMJER AB KAD JE VOZ KRENUO:  " + this.provjeriSmjerAB());
									if(provjeriSmjerAB()) {
										Thread.sleep(2000);
									}
									System.out.println("BREAK POINT PROVJERI DIONICU AB KAD JE VOZ KRENUO : " + this.provjeriDionicuAB());

					
									oslobodiPoziciju(indexVrsta, indexKolona);
									indexKolona--;//smanji vrstu jer se ide gore
									int brojPolja = this.getBrojLokomotiva() + this.getBrojVagona() - 1;//oduzima se vodeca lokomotiva
									//zauzmi i sve ostale pozicije ako je to moguce (ako je pruga u pitanju)
									
									//sve promjenljive ovde inicijalizovati -> Mogla se desiti masovna greska da su promjenljive ostale unutar while
									int indexVrstaElemenata = indexVrsta;
									int indexKolonaElemenata = indexKolona;
									while(brojPolja>0) {
										
										
										if(provjeriTrenutnuPoziciju(indexVrstaElemenata, indexKolonaElemenata)) {
											zauzmiPoziciju(indexVrstaElemenata, indexKolonaElemenata, this);
										}
										
										//gledaj suprotno od tog gdje je vodeca lokomotiva -> najcesci slucaj
										if((prugaProvjeriDesno(indexVrstaElemenata, indexKolonaElemenata))) {
											zauzmiPoziciju(indexVrstaElemenata, indexKolonaElemenata+1, this);
											brojPredjenihPolja++;

											oslobodiPoziciju(indexVrstaElemenata, indexKolonaElemenata);
											
											System.out.println("BREAK POINT 8: Kompozicija se nalaz na polju: " + (indexVrstaElemenata) + " " + indexKolonaElemenata );

											indexKolonaElemenata++; 
											System.out.println("BREAK POINT 8.1 : INDEX VRSTE ELEMENTA JE : " + indexVrstaElemenata);
										}
										else if(prugaProvjeriLijevo(indexVrstaElemenata, indexKolonaElemenata)){
											zauzmiPoziciju(indexVrstaElemenata, indexKolonaElemenata-1, this);
											System.out.println("BREAK POINT 9: Kompozicija se nalaz na polju: " + (indexVrsta) + " " + indexKolona );
											brojPredjenihPolja++;

											oslobodiPoziciju(indexVrstaElemenata, indexKolonaElemenata);
											indexKolonaElemenata--;
										}
										else if(prugaProvjeriDole(indexVrstaElemenata, indexKolonaElemenata)) {
											zauzmiPoziciju(indexVrstaElemenata+1, indexKolonaElemenata, this);
											System.out.println("BREAK POINT 10: Kompozicija se nalaz na polju: " + (indexVrsta) + " " + indexKolona );
											brojPredjenihPolja++;

											oslobodiPoziciju(indexVrstaElemenata, indexKolonaElemenata);
											indexVrstaElemenata++;
										}
										else {
											System.out.println("Dio kompozicije + " + (brojPolja) + " se nalaze na stanici!");
										}
										
										if(brojPolja == 1) {
											
											oslobodiPoziciju(indexVrstaElemenata, indexKolonaElemenata);
										}
										brojPolja--;
										
									}
									/*
									this.oslobodiPoziciju(indexVrstaZadnjegElementa, indexKolonaZadnjegElementa, );//oslobodi zadnje poljeZadnje
									this.oslobodiPoziciju(indexVrsta, indexKolona, "");*/
									
									//indexVrsta--;//smanji vrstu jer se ide gore
									Thread.sleep(500);
								}
								
								/*drugi slucaj provjeri dole ako nije lijevo (da li je suvisan uslov za gore ? )*/
								else if( !(this.prugaProvjeriLijevo(indexVrsta, indexKolona)) && (this.prugaProvjeriDole(indexVrsta, indexKolona)) ) {
									
									System.out.println("BREAK POINT 8: Kompozicija se nalaz na polju: " + (indexVrsta) + " " + indexKolona );

									int indexVrstaZadnjegElementa = 0;
									int indexKolonaZadnjegElementa = 0;
									
									this.zauzmiPoziciju(indexVrsta+1, indexKolona, this);
									//poljePomocno = this.provjeriPolje(indexVrsta, indexKolona);
									this.oslobodiPoziciju(indexVrsta, indexKolona);
									indexVrsta++;//uvecaj kolone jer se ide desno
									
									int indexVrstaElemenata = indexVrsta;
									int indexKolonaElemenata = indexKolona;

									int brojPolja = this.getBrojLokomotiva() + this.getBrojVagona() - 1;
									
									while(brojPolja > 0) {
										
										System.out.println("Kompozicija dio " + brojPolja+ " se nalaz na polju: " + (indexVrstaElemenata) + " " + indexKolonaElemenata );

										//prvi slucaj provjeri suprotno(ako je lokomotiva otisla desno - provjeri lijevo
										 if(prugaProvjeriGore(indexVrstaElemenata, indexKolonaElemenata)) {
												this.zauzmiPoziciju(indexVrstaElemenata-1, indexKolonaElemenata, this);
												this.oslobodiPoziciju(indexVrstaElemenata, indexKolonaElemenata);
												indexVrstaElemenata--;
										 }
										
										else if((prugaProvjeriDesno(indexVrstaElemenata, indexKolonaElemenata))) {
											zauzmiPoziciju(indexVrstaElemenata, indexKolonaElemenata+1, this);
											brojPredjenihPolja++;

											oslobodiPoziciju(indexVrstaElemenata, indexKolonaElemenata);
											
											System.out.println("BREAK POINT 8: Kompozicija se nalaz na polju: " + (indexVrstaElemenata) + " " + indexKolonaElemenata );

											indexKolonaElemenata++; 
											System.out.println("BREAK POINT 8.1 : INDEX VRSTE ELEMENTA JE : " + indexVrstaElemenata);
										}
										else if(this.prugaProvjeriLijevo(indexVrstaElemenata, indexKolonaElemenata)){
											zauzmiPoziciju(indexVrstaElemenata, indexKolonaElemenata-1, this);
											System.out.println("BREAK POINT LIJEVO ZAUZMI : Kompozicija se nalaz na polju: " + (indexVrsta) + " " + indexKolona );

											oslobodiPoziciju(indexVrstaElemenata, indexKolonaElemenata);
											indexKolonaElemenata--;
										} 
										
										else {
											System.out.println("Dio kompozicije + " + (brojPolja) + "se nalaze na stanici!");
										}
										
										if(brojPolja == 1) {
											this.oslobodiPoziciju(indexVrstaElemenata, indexKolonaElemenata);
										}
										
										brojPolja--;
									}
									
									//this.oslobodiPoziciju(indexVrstaZadnjegElementa, indexKolonaZadnjegElementa, poljeZadnje);
									//indexKolona++;//uvecaj kolone jer se ide desno
									System.out.println("BREAK POINT DESNO -> INDEXI SU: " + indexVrsta + " " + indexKolona);
									
										
									Thread.sleep(500);
									
								}
								/*treci slucaj provjeri lijevo ako nije desno i gore*/
								else if( !(this.prugaProvjeriGore(indexVrsta, indexKolona)) && !(this.prugaProvjeriDesno(indexVrsta, indexKolona)) && (this.prugaProvjeriLijevo(indexVrsta, indexKolona))) {
									int indexVrstaZadnjegElementa = 0;
									int indexKolonaZadnjegElementa = 0;
									String poljeZadnje = null;
									String poljePrvo = null;
									
									System.out.println("Kompozicija se nalaz na polju: " + (indexVrsta) + " " + indexKolona );

									this.zauzmiPoziciju(indexVrsta, indexKolona-1, this);
									this.oslobodiPoziciju(indexVrsta, indexKolona);
									indexKolona--;//smanj kolone jer se ide lijevo
									
									int indexVrstaElemenata = indexVrsta;
									int indexKolonaElemenata = indexKolona;

									int brojPolja = this.getBrojLokomotiva() + this.getBrojVagona() - 1;
									
									while(brojPolja > 0) {
										
										System.out.println("Kompozicija dio " + brojPolja+ " se nalaz na polju: " + (indexVrstaElemenata) + " " + indexKolonaElemenata );

										
										//uslov da bi se oslobodilo poslednje poljeZadnje(nakon sto zadnj element zauzme narednu poziciju, zadnja zauzeta ce se osloboditi)
										/*if(brojPolja == 1) {
											indexVrstaZadnjegElementa = indexVrstaElemenata;
											indexKolonaZadnjegElementa = indexKolonaElemenata;
											poljeZadnje = this.provjeriPolje(indexVrstaZadnjegElementa, indexKolonaZadnjegElementa);
										}*/
										
										//provjeri suprotno od lokomotive -> otisla lijevo - provjeri desno
										if(this.prugaProvjeriDesno(indexVrstaElemenata, indexKolonaElemenata)) {
												this.zauzmiPoziciju(indexVrstaElemenata, indexKolonaElemenata+1, this);
												indexKolonaElemenata++;
										}
										else if(this.prugaProvjeriDole(indexVrstaElemenata, indexKolonaElemenata)) {
											this.zauzmiPoziciju(indexVrstaElemenata+1, indexKolonaElemenata, this);
											indexVrstaElemenata++; 
										}
										else if(this.prugaProvjeriGore(indexVrstaElemenata, indexKolonaElemenata)) {
											this.zauzmiPoziciju(indexVrstaElemenata-1, indexKolonaElemenata, this);
											indexVrstaElemenata--;
										}
										else {
											System.out.println("Dio kompozicije + " + (brojPolja) + "se nalaze na stanici!");
										}
										brojPolja--;
									}
									//this.oslobodiPoziciju(indexVrstaZadnjegElementa, indexKolonaZadnjegElementa);
									//indexKolona--;//smanj kolone jer se ide lijevo
									Thread.sleep(500);
								 }
							}
							System.out.println("=============================================");

							
							//Kada kompozicije stigne na stanicu - izmjesti je sa pruge
							if((this.provjeraDaLiJeKompozicijaStiglaNaStanicuBpravacA(indexVrsta, indexKolona))) {
								System.out.println("Vodeca lokomotiva je stigla na stanicu !");
								this.oslobodiPoziciju(indexVrsta, indexKolona);
								this.zauzmiPoziciju(indexVrsta, indexKolona-1, this);//skloni je lijevo od pruge(simuliraj dolazak na kolosijek stanice)
								int indexVrstaElemenata = indexVrsta;
								int indexKolonaElemenata = indexKolona;
								System.out.println("BREAK POINT STANICA - INDEKSI SU " + indexVrstaElemenata + " " + indexKolonaElemenata);
								int brojPolja = this.getBrojVagona() + this.getBrojLokomotiva() - 1;
								while(brojPolja > 0) {
									//System.out.println(" BREAK POINT dolazak kompozicija na stanicu");
									if((this.provjeraDaLiJeKompozicijaStiglaNaStanicuBpravacA(indexVrstaElemenata, indexKolonaElemenata))) {
										//if(this.prugaProvjeriGore(indexVrstaElemenata, indexKolonaElemenata)) {
											System.out.println("Dio kompozicije " + brojPolja + " je stigao na stanicu");
											this.zauzmiPoziciju(indexVrstaElemenata, indexKolonaElemenata-1, this);
											this.oslobodiPoziciju(indexVrstaElemenata, indexKolonaElemenata);
											brojPolja--;
										//}
									}
								}
							}
						}
						else {
							//odpsavaj 4 sekundi pa opet provjeri
							Thread.sleep(4000);
						}
						
					}
					this.postaviDionicuAB();//nakon sto je voz prosao dionicu vrati je na normalnu 
					System.out.println("************************************");
					System.out.println("Kompozicija " + this.getID() + " je stigla do stanice");
					System.out.println("************************************");
					
				
				}
				
				/*slucaj kada ide od B do C*/
				else if( ("B".equals(stanice[brojac])) && ("C".equals(stanice[brojac+1])) ) {
					
				}
				
				//slucaj kada ide od C do B
				else if( ("C".equals(stanice[brojac])) && ("B".equals(stanice[brojac+1]))) {
					
				}
				
				//slucaj kada ide od C do D
				else if( ("C".equals(stanice[brojac])) && ("D".equals(stanice[brojac+1])) ){
					
				}
				
				//slucaj kada ide od D do C
				else if( ("D".equals(stanice[brojac])) && ("C".equals(stanice[brojac+1]))) {
					
				}
				
				//slucaj kada ide od C do E
				else if( ("C".equals(stanice[brojac])) && ("E".equals(stanice[brojac+1])) ) {
					
				}
				
				//slucaj kada ide od E do C
				else if ( ("E".equals(stanice[brojac])) && ( "C".equals(stanice[brojac+1]))){
					
				}
				else {
					System.out.println("Kompozicija " + this.getID() + " je zavrsila sa kretanjem");
				}
				
			}
		}catch(Exception e) {
			loger.log(Level.ALL, "Greska unutar run metode niti kompozicija!",e); //hvatanje pomocu Logera

		}
	}
	
}
	
	



/**	Metoda za citanje i kreiranje kompozicija iz fajlova. - postaviti u MAIN - u */
/**public void procitajKompozicije() {
	int brojKompozicija = this.brojKompozicija();
	try {
		while()
		procitaj = new BufferedReader(new FileReader(""))
	}
}**/