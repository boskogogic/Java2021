

/**	
 * 
 * @author Bosko Gogic
 * @version java 1.8
 * 
 * 	Klasa Kamion koja sluzi za reprezentaciju pojedinacnog vozila - Kamion.
 */

public class Kamion extends Vozilo {
	private int nosivost;
	
	public Kamion() {
		
	}
	
	public Kamion(String marka, String model, int godiste, int nosivost) {
		super(marka,model,godiste);
		this.nosivost = nosivost;
	}
	
	public int getNosivost() {
		return nosivost;
	}
	
	public void setNosivost(int nosivost) {
		this.nosivost = nosivost;
	}
	
	public void setMapa(Object[][] mapa) {
		super.setMapa(mapa);
	}
	
	public void postaviMapu(Mapa mapa) {
		super.postaviMapu(mapa);
	}
	
	@Override
	public String toString() {
		return "Kamion: " + super.toString() + " broj vrata na Kamionu: " + this.nosivost;
	}
	
	@Override
	public boolean equals(Object o) {
		/*	Da li postoji objekat koji je poslan kao parametar? */
		if(o == null){
			return false;
		}
		
		/*	Da li je objekat instanca date klase? */
		if(!(o instanceof Kamion)) {
			return false;
		}
		
		/*	Da li se pokusava uporediti sa samim sobom? */
		if(o.equals(this)) {
			return true;
		}
		
		Kamion a = (Kamion)o;
		
		return ((super.equals(o)) && (a.nosivost == this.nosivost));
		
	
	}
}
