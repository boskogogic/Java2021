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
	private Boolean kljuc = true;

	
	public Vozilo() {
		
	}
	
	public Vozilo(String marka, String model, int godiste) {
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
	
	@Override
	public void run() {
		//prvo se bira dionica puta PU1 PU2 ili PU3 (na mapi sa lijeva na desno respektivno)
		/*int dionica = generisiSlucajanBroj(1,3);*/
		//nakon toga bira se strana kojom se krece - PU1L, PU1D, PU2L, PU2D, PU3L, PU3D gdje je 1 lijevo, 2 desno
		/*int traka = generisiSlucajanBroj(1,2);*/
		
		int dionica = 1;
		int traka = 1; // Test za traku i Dionicu
		
		try{
			/* 6 mogucih slucajeva */
			/* prvi slucaj - dionica PU1 LIJEVA traka*/
			if(dionica==1 && traka==1) {
				System.out.println("BREAK POINT VOZILO - DA LI UDJE U IF");
				int indexVrsta = 21;//pocetno I za lijevu traku PU1
				int indexKolona = 0;//pocetno J za lijevu traku PU1
				int brojPredjenihPolja = 0; //da odmjeri ako je auto iza da moze on otici par polja ispred
				//kljuc = true;
				//synchronized(kljuc) {
					//provjerit da li ce kljuc odmah izbaciti iz synchronized bloka ili ne
					
					if(brojPredjenihPolja == 4) {
						System.out.println("BREAK POINT BROJ PREDJENIH POLJA");
						kljuc = false;
					}
					
					//prva provjera je za pruzni prelaz
					if(this.voziloProvjeriDaLiJePruzniPrelaz(indexVrsta, indexKolona)){					
						boolean slobodan = false;
						while(!(slobodan)) {
							if( !(this.voziloProvjeriSmjerKompozicijeAB()) && !(this.voziloProvjeriSmjerKompozicijeBA()) ){
								this.voziloZauzmiPoziciju(indexVrsta, indexKolona+2, this);
								this.voziloOslobodiPozicijuLijevaTrakaPut1(indexVrsta, indexKolona);
								System.out.println("BREAK POINT - Vozilo je oslobodilo poziciju: " + indexVrsta + " " + indexKolona + " i zauzelo poziciju" + indexVrsta + " " + (indexKolona+2));
								indexKolona +=2;//preskoci pruzni prelaz ako je slobodno
								brojPredjenihPolja+=2;
								slobodan = true;
								}
							else {
								Thread.sleep(4000);
							}
						}
					}
					
					if((this.voziloProvjeriDesno(indexVrsta, indexKolona))) {
						this.voziloZauzmiPoziciju(indexVrsta, indexKolona+1, this);
						this.voziloOslobodiPozicijuLijevaTrakaPut1(indexVrsta, indexKolona);
						indexKolona++;
						System.out.println("BREAK POINT RUN VOZILO : Nalazi se na polju : " + indexVrsta + " " + indexKolona + " i preslo je polja: " + brojPredjenihPolja);
						brojPredjenihPolja++;
						Thread.sleep(1000);
					}
					else if((this.voziloProvjeriDole(indexVrsta, indexKolona))) {
						this.voziloZauzmiPoziciju(indexVrsta, indexKolona+1, this);
						this.voziloOslobodiPozicijuLijevaTrakaPut1(indexVrsta, indexKolona);
						System.out.println("BREAK POINT RUN VOZILO : Nalazi se na polju : " + indexVrsta + " " + indexKolona + " i preslo je polja: " + brojPredjenihPolja);

						indexKolona++;
						brojPredjenihPolja++;
						Thread.sleep(1000);

					}
					
					
				//}
				
				
				//nakon pruznog prelaza
				if((this.voziloProvjeriDesno(indexVrsta, indexKolona))) {
					this.voziloZauzmiPoziciju(indexVrsta, indexKolona+1, this);
					this.voziloOslobodiPozicijuLijevaTrakaPut1(indexVrsta, indexKolona);
					System.out.println("BREAK POINT RUN VOZILO : Nalazi se na polju : " + indexVrsta + " " + indexKolona + " i preslo je polja: " + brojPredjenihPolja);

					indexKolona++;
					Thread.sleep(1000);

				}
				else if((this.voziloProvjeriDole(indexVrsta, indexKolona))) {
					this.voziloZauzmiPoziciju(indexVrsta, indexKolona+1, this);
					this.voziloOslobodiPozicijuLijevaTrakaPut1(indexVrsta, indexKolona);
					System.out.println("BREAK POINT RUN VOZILO : Nalazi se na polju : " + indexVrsta + " " + indexKolona + " i preslo je polja: " + brojPredjenihPolja);

					indexKolona++;
					Thread.sleep(1000);

				}
				
				if(indexVrsta == 29 && indexKolona==6) {
					System.out.println("Vozilo je doslo do kraja puta PU1L");
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

