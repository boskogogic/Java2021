import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 	@author Bosko Gogic
 * 	@version java 1.8
 * 
 * 	Klasa Vozilo koja predstavlja pojedinacno vozilo sa svojim parametrima (marka,model,godiste).
 *
 */

public class Vozilo extends Mapa {

	private String marka;
	private String model;
	private int godiste;
	private int brzina = 0;
	private final static Logger loger = Logger.getLogger(Vozilo.class.getName());
	private Mapa mapa;
	public static int odspavaj = 2000;
	
	
	public Vozilo() {
		//super();
	}
	
	public Vozilo(String marka, String model, int godiste/*, Object[][] mapa*/) {
		/*super(mapa);*/
		this.marka = marka;
		this.model = model;
		this.godiste = godiste;
	}
	
	public String getMarka() {
		return marka;
	}
	
	public String getModel() {
		return model;
	}
	
	public int getGodiste() {
		return godiste;
	}
	
	public int getBrzina() {
		return brzina;
	}

	public void setMapa(Object[][] mapa) {
		super.setMapa(mapa);
	}
	
	public void setMarka(String marka) {
		this.marka = marka;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public void setGodiste(int godiste) {
		this.godiste = godiste;
	}
	
	public void setBrzina(int brzina) {
		this.brzina = brzina;
	}
	
	public void postaviMapu(Mapa mapa) {
		this.mapa = mapa;
	}
	
	public void setKompozicije(ArrayList<Kompozicija> kompozicije) {
		super.setKompozicije(kompozicije);
	}
	
	/*public void procitajBrzinu(PrintReader citaj) {
		
		
	}*/
	
	
	
	//iz nekog razloga mi prijavljuje gresku kad ne stavim u metodu 
	public void setLogerLevel() {
		loger.setLevel(Level.ALL);
	}
	
	/**	Funkcija za generisanje slucajnog broja */
	public int generisiSlucajanBroj(int min, int max) {
		int slucajanBroj = (int)Math.floor(Math.random()*(max-min+1)+min);
		return slucajanBroj;
	}
	
	@Override
	public String toString() {
		return "Marka: " + this.marka + " Model: " + this.model + " Godiste: " + this.godiste;
	}
	
	@Override
	public boolean equals(Object o) {
		/* Da li je objekat null? */
		if(o == null) {
			return false;
		}
		
		/* Da li je objekat instanca date klase? */
		if(!(o instanceof Vozilo)) {
			return false;
		}
		
		/* Da li je u pitanju poredjenje sa samim sobom */
		if(o.equals(this)) {
			return true;
		}
		
		Vozilo v = (Vozilo)o;
		
		return ( (v.marka.equals(this.marka)) && (v.model.equals(this.model)) && (v.godiste == this.godiste));
	}
	
	public int brojac = 0; // bezveze samo da provjerim run metodu
	@Override
	public void run() {
		//prvo se bira dionica puta PU1 PU2 ili PU3 (na mapi sa lijeva na desno respektivno)
		/*int dionica = generisiSlucajanBroj(1,3);*/
		//nakon toga bira se strana kojom se krece - PU1L, PU1D, PU2L, PU2D, PU3L, PU3D gdje je 1 lijevo, 2 desno
		/*int traka = generisiSlucajanBroj(1,2);*/
		System.out.println("----------------------------------------");
		System.out.println("Vozilo: " + this.getMarka() + " " + this.getModel() + " je poceo kretanje");
		int dionica = 1;
		int traka = 1; // Test za traku i Dionicu
		
		try{
			/* 6 mogucih slucajeva */
			/* prvi slucaj - dionica PU1 LIJEVA traka*/
			if(dionica==1 && traka==1) {
				
				int indexVrsta = 0;//pocetno I za lijevu traku PU1
				int indexKolona = 0;//pocetno J za lijevu traku PU1
				
				if(voziloProvjeriDaLiImaVoziloIspredPU1(21,0)) {
					indexVrsta=21;
					indexKolona=0;
				}else {
					Thread.sleep(2000);
					System.out.println("U Prvom IF-ELSE iskazu uspava se vozilo " + model + " " + marka);
				}
				
				int brojPredjenihPolja = 0;
				//voziloOslobodiPozicijuLijevaTrakaPut1(21,2);

					while(!(voziloLijevaTrakaPut1ProvjeriDaLiJeKraj(indexVrsta, indexKolona))){
						
						if(voziloProvjeriDaLiImaVoziloIspredPU1(indexVrsta, indexKolona)) {
							odspavaj+=1000;
							mapa.pristupiVozilu(brojac).sleep(odspavaj);
							System.out.println("Uspavalo se " + this.getModel() + " " + this.getMarka() + " vozilo u if iskazu za provjeru da li ima nesto na putu na " + odspavaj + " milisekundi");
							//Thread.wait();
							brojac++;
						}
						
						System.out.println("Provjera za provjeri desno za POSLIJE pruznog prelaza : " + voziloProvjeriDesno(21,2));
						System.out.println("Sta se nalazi na poziciji " + indexVrsta + " " + indexKolona + " : " + vratiVrijednostPolja(indexVrsta,indexKolona) + " provjerava " + model + " " + marka);
						 //da odmjeri ako je auto iza da moze on otici par polja ispred
						//prva provjera je za pruzni prelaz
				
					
						if((voziloProvjeriDesno(indexVrsta, indexKolona))) {
							voziloZauzmiPoziciju(indexVrsta, indexKolona+1, this);
							voziloOslobodiPozicijuLijevaTrakaPut1(indexVrsta, indexKolona);
							indexKolona++;
							brojPredjenihPolja++;
							System.out.println("BREAK POINT RUN VOZILO " + this.getMarka() + " " + this.getModel() + " Nalazi se na polju : " + indexVrsta + " " + indexKolona + " i preslo je polja: " + (brojPredjenihPolja));
						
							Thread.sleep(1500);
						}
						else if((voziloProvjeriDole(indexVrsta, indexKolona))) {
							voziloZauzmiPoziciju(indexVrsta+1, indexKolona, this);
							voziloOslobodiPozicijuLijevaTrakaPut1(indexVrsta, indexKolona);
							indexVrsta++;
							brojPredjenihPolja++;
							System.out.println("BREAK POINT RUN VOZILO : Nalazi se na polju : " + indexVrsta + " " + indexKolona + " i preslo je polja: " + brojPredjenihPolja);

							Thread.sleep(1500);
						}
				
						//pokusaj samo sa  else
						else if(voziloProvjeriDaLiJePruzniPrelaz(indexVrsta, indexKolona)){					
							boolean slobodan = false;
							System.out.println("BREAK POINT Vozilo : Da li udje u if iskaz PRUZNI PRELAZ? " + model + " " + marka);
							
							while(!(slobodan)) {
								//if( !(voziloProvjeriSmjerKompozicijeAB()) && !(voziloProvjeriSmjerKompozicijeBA()) ){
								/*	Provjera da li su svi signali pozitivni vezano za prelaz */
								boolean slobodanPrelaz;
								
								int brojac = 0;
								boolean okidac = true;
								slobodanPrelaz = mapa.voziloProvjeriDaLiJePruzniPrelaz1Zauzet();
							
								System.out.println("U RUN metodi vozila vrijednost za prelaz je : " + slobodanPrelaz);
								if( slobodanPrelaz ) {	
										voziloZauzmiPoziciju(indexVrsta, indexKolona+2, this);
										voziloOslobodiPozicijuLijevaTrakaPut1(indexVrsta, indexKolona);
										System.out.println("BREAK POINT - Vozilo je preslo preko pruznog prelaza : " + indexVrsta + " " + indexKolona + " i zauzelo poziciju " + indexVrsta + " " + (indexKolona+2) + " " + marka + " " + model);

										indexKolona +=2;//preskoci pruzni prelaz ako je slobodno
										brojPredjenihPolja+=2;
									
										slobodan = true;
									//	}
									}
								
								else {
									System.out.println("Uspavalo se vozilo!");
									Thread.sleep(7*2500);
									}	
								}
							}
						
						else {
							System.out.println("Uspavalo se vozilo " + model + " " + marka + " u konacnom ELSE na 2500 milisek");
							Thread.sleep(2500);
						}
						System.out.println("----------------------------------------");
						
				
						if(indexVrsta == 29 && indexKolona==7) {
							voziloZauzmiPoziciju(indexVrsta++, indexKolona, this);
							voziloOslobodiPozicijuLijevaTrakaPut1(indexVrsta, indexKolona);
							System.out.println("Vozilo je doslo do kraja puta PU1L");
							brojPredjenihPolja++;
							System.out.println("----------------------------------------");

						}
						
						System.out.println("Je l uopste prodje kroz ove silne iskaze i petlje? Inace se vozilo " + model + " " + marka+ " uspava");//NE
						Thread.sleep(2500);
					}
			
			}
			
			/* drugi slucaj - dionica PU1 DESNA traka*/
			else if(dionica==1 && traka==2) {
			
			}
			/* treci slucaj - dionica PU2 LIJEVA traka*/
			else if(dionica==2 && traka==1) {
			
			}
			/* cetvrti slucaj - dionica PU2 DESNA traka*/
			else if(dionica==2 && traka==2) {
			
			}
			/* peti slucaj - dionica PU3 LIJEVA traka*/
			else if(dionica==3 && traka==1) {
			
			}
			/* sesti slucaj - dionica PU3 DESNA traka*/
			else {
			
			}
		}catch(Exception e ) {
			loger.log(Level.ALL, "Greska unutar run metode niti vozilo!",e); //hvatanje pomocu Logera
		}
		
	}


}	

