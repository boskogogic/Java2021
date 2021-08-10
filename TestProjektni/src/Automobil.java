import java.util.ArrayList;

/**	
 * 
 * @author Bosko Gogic
 * @version java 1.8
 * 
 * 	Klasa Automobil koja sluzi za reprezentaciju pojedinacnog vozila - automobil.
 */


public class Automobil extends Vozilo{

	private int brojVrata;
	//private Mapa mapa;
	
	public Automobil() {
		
	}
	
	public Automobil(String marka, String model, int godiste, int brojVrata/*, Object[][] mapa*/) {
		super(marka,model,godiste/*,mapa*/);
		this.brojVrata = brojVrata;
	}
	
	public void setMapa(Object[][] mapa) {
		super.setMapa(mapa);
	}
	
	public int getBrojVrata() {
		return brojVrata;
	}
	
	public void setBrojVrata(int brojVrata) {
		this.brojVrata = brojVrata;
	}
	
	public void postaviMapu(Mapa mapa) {
		super.postaviMapu(mapa);
	}
	
	public Object vratiPolje(int indexI, int indexJ) {
		return super.vratiVrijednostPolja(indexI, indexJ);
	}
	
	public void setKompozicije(ArrayList<Kompozicija> kompozicije) {
		super.setKompozicije(kompozicije);
	}
	
	@Override
	public String toString() {
		return "Automobil: " + super.toString() + " broj vrata na automobilu: " + this.brojVrata;
	}
	
	@Override
	public boolean equals(Object o) {
		/*	Da li postoji objekat koji je poslan kao parametar? */
		if(o == null){
			return false;
		}
		
		/*	Da li je objekat instanca date klase? */
		if(!(o instanceof Automobil)) {
			return false;
		}
		
		/*	Da li se pokusava uporediti sa samim sobom? */
		if(o.equals(this)) {
			return true;
		}
		
		Automobil a = (Automobil)o;
		
		return ((super.equals(o)) && (a.brojVrata == this.brojVrata));
		
	
	}

}
