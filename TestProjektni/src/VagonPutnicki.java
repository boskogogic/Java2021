//moze i naziv vagon za spavanje
public class VagonPutnicki extends Vagon{
	private String id;
	private int brojMjesta;
	
	public VagonPutnicki() {
		
	}
	
	public VagonPutnicki(String duzina, String oznaka, int brojMjesta) {
		super(duzina,oznaka);
		this.brojMjesta = brojMjesta;
	}
	
	public String getID() {
		return id;
	}
	
	public int getBrojMjesta() {
		return brojMjesta;
	}
	
	public void setID(String id) {
		this.id = id;
	}
	
	public void setBrojMjesta(int brojMjesta) {
		this.brojMjesta = brojMjesta;
	}
}
