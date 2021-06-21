
public class VagonRestoran extends Vagon{
	private String opis;
	
	public VagonRestoran() { }
	
	public VagonRestoran(String duzina, String oznaka, String opis) {
		super(duzina,oznaka);
		this.opis = opis;
	}
	
	public String getOpis() {
		return opis;
	}
	
	public void setOpis(String opis) {
		this.opis = opis;
	}
}
