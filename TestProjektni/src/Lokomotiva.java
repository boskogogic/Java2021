
public class Lokomotiva {
	private String tipLokomotive;//putnicke(putnicke komp), teretne(ter komp),univerzalne(put i ter) i manevarske
	private String vrstaPogonaLokomotive;//parna, dizelska ili elektricna
	private String snaga;
	private String oznaka;
	
	public Lokomotiva() {}
	
	public Lokomotiva(String tipLokomotive, String vrstaPogonaLokomotive, String snaga, String oznaka ) {
		this.tipLokomotive = tipLokomotive;
		this.vrstaPogonaLokomotive = vrstaPogonaLokomotive;
		this.snaga = snaga;
		this.oznaka = oznaka;
	}
	
	public String getTipLokomotive() {
		return tipLokomotive;
	}
	
	public String getVrstaPogonaLokomotive() {
		return vrstaPogonaLokomotive;
	}
	
	public String getSnaga() {
		return snaga;
	}
	
	public String getOznaka() {
		return oznaka;
	}
	
	public void setTipLokomotive(String tipLokomotive) {
		this.tipLokomotive = tipLokomotive;
	}
	
	public void setVrstaPogonaLokomotive(String vrstaPogonaLokomotive) {
		this.vrstaPogonaLokomotive = vrstaPogonaLokomotive;
	}
	
	public void setSnaga(String snaga) {
		this.snaga = snaga;
	}
	
	public void setOznaka(String oznaka) {
		this.oznaka = oznaka;
	}
}
