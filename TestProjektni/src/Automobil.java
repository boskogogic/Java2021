

/**	
 * 
 * @author Bosko Gogic
 * @version java 1.8
 * 
 * 	Klasa Automobil koja sluzi za reprezentaciju pojedinacnog vozila - automobil.
 */


public class Automobil extends Vozilo{

	private int brojVrata;
	
	public Automobil() {
		
	}
	
	public Automobil(String marka, String model, int godiste, int brojVrata) {
		super(marka,model,godiste);
		this.brojVrata = brojVrata;
	}
	
	public int getBrojVrata() {
		return brojVrata;
	}
	
	public void setBrojVrata(int brojVrata) {
		this.brojVrata = brojVrata;
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
