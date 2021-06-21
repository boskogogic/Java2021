
public class VagonTeretni extends Vagon{
	public String maksimalnaNosivost;
	
	public VagonTeretni() { }
	
	public VagonTeretni(String duzina, String oznaka, String maksimalnaNosivost) {
		super(duzina,oznaka);
		this.maksimalnaNosivost = maksimalnaNosivost;
	}
	
	public String getMaksimalnaNosivost() {
		return maksimalnaNosivost;
	}
	
	public void setMaksimalnaNosivost(String maksimalnaNosivost) {
		this.maksimalnaNosivost = maksimalnaNosivost;
	}
}
