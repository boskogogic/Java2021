
public class Vagon {
	private String duzina;
	private String oznaka;
	
	public Vagon() {
		
	}
	
	public Vagon(String duzina, String oznaka) {
		this.duzina = duzina;
		this.oznaka = oznaka;
	}
	
	public String getDuzina() {
		return duzina;
	}
	
	public String getOznaka() {
		return oznaka;
	}
	
	public void setDuzina(String duzina) {
		this.duzina = duzina;
	}
	
	public void setOznaka(String oznaka) {
		this.oznaka = oznaka;
	}
}
