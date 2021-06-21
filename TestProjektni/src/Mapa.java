import java.util.ArrayList;
import java.util.Iterator;



public class Mapa extends Thread{
	private Object[][] mapa;
	private ZeljeznickaStanica[] stanice;
	private ArrayList<Kompozicija> kompozicije = new ArrayList<Kompozicija>();
	private static int i=0;
	private static Boolean resurs = true;
	
	public Mapa() {
		
	}
	
	public Mapa(Object[][] mapa) {
		this.mapa = new Object[30][30];
		this.mapa = mapa;
	}
	
	public void setMapa(Object[][]mapa) {
		this.mapa = mapa;
	}
	
	public Object[][] getMapa(){
		return mapa;
	}
	
	public void setResurs(Boolean resurs) {
		this.resurs = resurs;
	}
	
 	
	public void setKompozicije(ArrayList<Kompozicija> kompozicije) {
		this.kompozicije = kompozicije;
	}
	
	public Boolean getResurs() {
		return resurs;
	}
	
	public void dodajUKolekciju(Kompozicija kompozicija) { 
		kompozicije.add(kompozicija);
		System.out.println("Kompozicija " + kompozicije.get(i).getID());
		System.out.println("Kompozicija " + kompozicije.get(i).getID() + " imaju oznacene stanice " + kompozicije.get(i).vratiStanicu(0) + " " + kompozicije.get(i).vratiStanicu(1));
		System.out.println("Kompozicija ima velicinu : " + kompozicije.size());
		i++;
		
	}
	
	

	
	public void provjeraIteratora() {
		Iterator<Kompozicija> iteratorKompozicije = kompozicije.iterator();//iterator za kretanje(iteraciju) kroz kompoziciju

		while(iteratorKompozicije.hasNext()) {
			System.out.println("BREAK POINT PROVJERA ITERATORA " + iteratorKompozicije.next().getID() + " ");
		}
		
		for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
			System.out.println("BREAK POINT DA LI JE BROJAC I FOR BOLJA OPCIJA ? " + kompozicije.get(brojac).getID());
		}
	}
	
	/**	Metode za inicijalizaciju stanica, pruga, pruznih prelaza i puteva. */
	public void postaviStanice() {
		
		mapa[28][2] = "A";
		mapa[27][2] = "A";
		
		mapa[6][6] = "B";
		mapa[6][7] = "B";
		
		mapa[12][19] = "C";
		mapa[12][20] = "C";
		mapa[13][19] = "C";
		mapa[13][20] = "C";
		
		mapa[1][26] = "D";
		mapa[1][27] = "D";
	}
	
	public void postaviDionicuAB() {
		
		//polje prije A Stanice
		mapa[29][2]= "PR";
		
		//dionica od stanice A do Pruznog prelaza 
		for(int i = 26; i > 21; i--) {
			mapa[i][2] = "PR";
		}
		
		//inicijalizacija pruznog prelaza broj 1 ( lijeva i desna traka)
		mapa[21][2] = "PP1L";
		mapa[20][2] = "PP1D";
		
		
		//dionica do pruznog prelaza do skretanja desno
		for(int i=19; i > 15; i-- ) {
			mapa[i][2] = "PR";
		}
		
		//dionica kada skrene desno
		for(int j=3; j < 6; j++) {
			mapa[16][j] = "PR";
		}
		
		//dionica prema gore do B Stanice
		for(int i = 15; i > 5; i--) {
			mapa[i][5] = "PR";
		}
	}
	
	public void postaviDionicuBC() {
		
		// od stanice b do pruznog prelaza
		for(int j=8; j < 13; j++) {
			mapa[6][j] = "PR";
		}
		
		// inicijalicazacija Pruznog Prelaza 2(jedan za lijevu traku drugi za desnu)
		mapa[6][13] = "PP2L";
		mapa[6][14] = "PP2D";
		
		//od pruznog prlaza 2 do skretanja prema dole
		for(int j=15;  j < 20; j++) {
			mapa[6][j] = "PR";
		}
		
		//dionica kada skrene prema dole pa do stanice C
		for(int i = 6; i < 12; i++) {
			mapa[i][19] = "PR";
		}
	}
	
	public void postaviDionicuCE() {
		
		//dionica kada ide od C prema dole
		for(int i=14; i < 19; i++) {
			mapa[i][20] = "PR";
		}
		
		//dionica puta kada skrene desno
		for(int j = 20; j < 27 ; j++) {
			mapa[18][j] = "PR";
		}
		
		//dionica puta prema dole do kruznog prelaza
		for(int i=18; i <20; i++) {
			mapa[i][26] = "PR";
		}
		
		//inicijalizacija Pruznog Prelaza 3(lijeva i desna traka)
		mapa[20][26] = "PP3L";
		mapa[20][27] = "PP3D";
		
		//dionica od pruznog prelaza do stanice E
		for(int i=22; i < 25; i++) {
			mapa[i][26] = "PR";
		}
		
		//od E prema kraju mape '<=' jer mora inicijalizovati i 29
		for(int j=27; j <= 29; j++) {
			mapa[25][j] = "PR";
		}
	}
	
	public void postaviDionicuCD() {
		
		//dionuica od C stanice desno do skretanja prema gore
		for(int j=21; j < 27; j++) {
			mapa[12][j] = "PR";
		}
		
		//dionica puta od skretanja prema gore
		for(int i=12; i > 8; i--) {
			mapa[i][26] = "PR";
		}
		
		//dionica puta skretanje desno
		for(int j=26; j < 29; j++) {
			mapa[9][j] = "PR";
		}
		
		for(int i=9; i > 4; i--) {
			mapa[i][28] = "PR";
		}
		
		//dionica kada skrene lijevo
		for(int j=28; j > 22; j--) {
			mapa[5][j] = "PR";
		}
		
		//dionica kada skrene gore
		for(int i=5; i > 2; i--) {
			mapa[i][23] = "PR";
		}
		
		//dionica kada skrene lijevo i krene gore
		mapa[3][22] = "PR";
		mapa[2][22] = "PR";
		mapa[1][22] = "PR";
		
		//dionica kada skrene desno prema D stanici
		for(int j=22; j < 26; j++) {
			mapa[1][j] = "PR";
		}
		
	}
	
	public void postaviPutP1() {
		//putevi su podjeljeni na trake, a imamo 3 puta PU1, PU2, PU3
		
		/*lijeva traka za put P1 */
		
		//do pruznog prelaza PP1L
		mapa[21][0] = "PU1L";
		mapa[21][1] = "PU1L";
		
		//od pruzno prelaza do skretanja prema dole
		for(int j=3; j < 8; j++) {
			mapa[21][j] = "PU1L";
		}
		
		for(int i = 21; i < 30; i++) {
			mapa[i][7] = "PU1L";
		}
		
		/*desna traka za put P1 */
		mapa[20][0] = "PU1D";
		mapa[20][1] = "PU1D";
		
		//od pruzno prelaza do skretanja prema dole
		for(int j=3; j < 9; j++) {
			mapa[20][j] = "PU1D";
		}
		
		for(int i = 20; i < 30; i++) {
			mapa[i][8] = "PU1D";
		}

	}
	
	public void postaviPutP2() {
		/* Lijeva strana puta P2 */
		//do pruznog prelaza PP2L
		for(int i=0; i < 6; i++) {
			mapa[i][13] = "PU2L";
		}
		
		//od pruznog prelaza PP2L do kraja mape
		for(int i = 7; i < 30; i++ ) {
			mapa[i][13] = "PU2L";
		}
		
		/*	Desna strana puta P2 */
		
		//do pruznog prelaza PP2D
		for(int i =0; i< 6; i++) {
			mapa[i][14] ="PU2D";
		}
		
		//od pruznog prelaza PP2D do kraja mape
		for(int i = 7 ; i < 30; i++) {
			mapa[i][14] = "PU2D";
		}
	}
	
	public void postaviPutP3() {
		/* Lijeva strana za put P3 */
		
		//od starta mape prema gore do skretanja za desno
		for(int i = 29; i > 19; i--) {
			mapa[i][21] = "PU3L";
		}
		
		//do pruznog prelaza PP3L
		for(int j = 21; j < 26; j++) {
			mapa[20][j] = "PU3L";
		}
		
		//od pruznog prelaza PP3L do kraja mape
		for(int j=27; j < 30; j++) {
			mapa[20][j] = "PU3L";
		}
		
		/* Desna strana za put P3 */
		
		//od starta mape prema gore do skretanja za desno
		for(int i = 29; i > 20; i--) {
			mapa[i][22] = "PU3D";
		}
		
		//do pruznog prelaza PP3D
		for(int j = 22; j < 26; j++) {
			mapa[21][j] = "PU3D";
		}
		
		//od pruznog prelaza PP3D do kraja mape
		for(int j=27; j < 30; j++) {
			mapa[21][j] = "PU3D";
		}
	}
	
	/**	Metode za provjeru da li se na odredjenoj dionici vec nalazi kompozicija. */
	public synchronized boolean provjeriDionicuAB() {
		
		//polje prije A Stanice
		/*if(!(mapa[29][2] instanceof String) && !("PR".equals(mapa[29][2]))) {
			return false;
		}*/
		
		//dionica od stanice A do Pruznog prelaza 
		for(int i = 26; i > 21; i--) {
			if(!(mapa[i][2] instanceof String) && !("PR".equals(mapa[i][2]))) {
				return false;
			}
		}
		
		//PROVJERA pruznog prelaza broj 1
		if(!(mapa[21][2] instanceof String) && !("PP1L".equals(mapa[21][2]))) {
			return false;
		}
		if(!(mapa[20][2] instanceof String) && !("PP1D".equals(mapa[20][2]))) {
			return false;
		}

		//dionica do pruznog prelaza do skretanja desno
		for(int i=19; i > 15; i-- ) {
			if(!(mapa[i][2] instanceof String) && !("PR".equals(mapa[i][2]))) {
				return false;
			}
		}
		
		//dionica kada skrene desno
		for(int j=2; j < 6; j++) {
			if(!(mapa[16][j] instanceof String) && !("PR".equals(mapa[16][j]))) {
				return false;
			}
		}
		
		//dionica prema gore do B Stanice
		for(int i = 16; i > 5; i--) {
			if(!(mapa[i][5] instanceof String) && !("PR".equals(mapa[i][5]))) {
				return false;
			}
		}		
		return true;
	}
	
	public synchronized boolean provjeriDionicuBC() {

		// od stanice b do pruznog prelaza
		for(int j=8; j < 13; j++) {
			if(!(mapa[6][j] instanceof String) && !("PR".equals(mapa[6][j]))) {
				return false;
			}
		}
		
		// inicijalicazacija Pruznog Prelaza 2
		if(!(mapa[6][13] instanceof String) && !("PP2L".equals(mapa[6][13]))) {
			return false;
		}
		
		if(!(mapa[6][14] instanceof String) && !("PP2D".equals(mapa[6][14]))) {
			return false;
		}
		
		//od pruznog prlaza 2 do skretanja prema dole
		for(int j=15;  j < 20; j++) {
			if(!(mapa[6][j] instanceof String) && !("PR".equals(mapa[6][j]))) {
				return false;
			}
		}
		
		//dionica kada skrene prema dole pa do stanice C
		for(int i = 6; i < 12; i++) {
			if(!(mapa[i][19] instanceof String) && !("PR".equals(mapa[i][19]))) {
				return false;
			}
		}
		
		return true;
	}
	
	public synchronized boolean provjeriDionicuCE() {
		
		//dionica kada ide od C prema dole
		for(int i=14; i < 19; i++) {
			if(!(mapa[i][20] instanceof String) && !("PR".equals(mapa[i][20]))) {
				return false;
			}
		}
		
		//dionica puta kada skrene desno
		for(int j = 20; j < 27 ; j++) {
			if(!(mapa[18][j] instanceof String) && !("PR".equals(mapa[18][j]))) {
				return false;
			}
		}
		
		//dionica puta prema dole do kruznog prelaza
		for(int i=18; i <20; i++) {
			if(!(mapa[i][26] instanceof String) && !("PR".equals(mapa[i][26]))) {
				return false;
			}
		}
		
		//inicijalizacija Pruznog Prelaza 3
		if(!(mapa[20][26] instanceof String) && !("PP3".equals(mapa[20][26]))) {
			return false;
		}
		if(!(mapa[20][27] instanceof String) && !("PP3".equals(mapa[20][27]))) {
			return false;
		}
		
		//dionica od pruznog prelaza do stanice E
		for(int i=22; i < 25; i++) {
			if(!(mapa[i][26] instanceof String) && !("PR".equals(mapa[i][26]))) {
				return false;
			}
		}
		
		//od E prema kraju mape '<=' jer mora inicijalizovati i 29
		for(int j=27; j <= 29; j++) {
			if(!(mapa[25][j] instanceof String) && !("PR".equals(mapa[25][j]))) {
				return false;
			}
		}
		
		return true;
	}
	
	public synchronized boolean provjeriDionicuCD() {
		
		//dionuica od C stanice desno do skretanja prema gore
		for(int j=21; j < 27; j++) {
			if(!(mapa[12][j] instanceof String) && !("PR".equals(mapa[12][j]))) {
				return false;
			}
		}
		
		//dionica puta od skretanja prema gore
		for(int i=12; i > 8; i--) {
			if(!(mapa[i][26] instanceof String) && !("PR".equals(mapa[i][26]))) {
				return false;
			}
		}
		
		//dionica puta skretanje desno
		for(int j=26; j < 29; j++) {
			if(!(mapa[9][j] instanceof String) && !("PR".equals(mapa[9][j]))) {
				return false;
			}
		}
		
		for(int i=9; i > 4; i--) {
			if(!(mapa[i][28] instanceof String) && !("PR".equals(mapa[i][28]))) {
				return false;
			}
		}
		
		//dionica kada skrene lijevo
		for(int j=28; j > 22; j--) {
			if(!(mapa[5][j] instanceof String) && !("PR".equals(mapa[5][j]))) {
				return false;
			}
		}
		
		//dionica kada skrene gore
		for(int i=5; i > 2; i--) {
			if(!(mapa[i][23] instanceof String) && !("PR".equals(mapa[i][23]))) {
				return false;
			}
		}
		
		//dionica kada skrene lijevo i krene gore
		if(!(mapa[3][22] instanceof String) && !("PR".equals(mapa[3][22]))) {
			return false;
		}
		
		if(!(mapa[2][22] instanceof String) && !("PR".equals(mapa[2][22]))) {
			return false;
		}
		if(!(mapa[1][22] instanceof String) && !("PR".equals(mapa[1][22]))) {
			return false;
		}
		
		//dionica kada skrene desno prema D stanici
		for(int j=22; j < 26; j++) {
			if(!(mapa[1][j] instanceof String) && !("PR".equals(mapa[1][j]))) {
				return false;
			}
		}		
		return true;
	}
	
	/**	Metode za provjeru da li se u nekom smjeru nalazi pruga ili pruzni prelaz. */
	public synchronized boolean prugaProvjeriGore(int trenutnoI, int trenutnoJ) {
		//provjera za gore -> gore moze  biti pruga, pruzni prelaz 1 i pruzni prelaz 3
		if( ("PR".equals(mapa[trenutnoI-1][trenutnoJ])) ||  ("PP1L".equals(mapa[trenutnoI-1][trenutnoJ])) ||  ("PP1D".equals(mapa[trenutnoI-1][trenutnoJ])) ||  ("PP3L".equals(mapa[trenutnoI-1][trenutnoJ])) ||  ("PP3D".equals(mapa[trenutnoI-1][trenutnoJ])) ){
			return true;
		}
		return false;
	}
	
	public boolean prugaProvjeriDole(int trenutnoI, int trenutnoJ) {
		//provjera za dole -> isto kao gore samo obrnuti indeksi
		if( ("PR".equals(mapa[trenutnoI+1][trenutnoJ])) || ("PP1L".equals(mapa[trenutnoI+1][trenutnoJ])) || ("PP1D".equals(mapa[trenutnoI+1][trenutnoJ])) || ("PP3L".equals(mapa[trenutnoI+1][trenutnoJ])) || ("PP3D".equals(mapa[trenutnoI+1][trenutnoJ])) ) {
			return true;
		}
		return false;
	}
	
	public boolean prugaProvjeriLijevo(int trenutnoI, int trenutnoJ) {
		//provjera za lijevo -> lijevo moze biti pruga ili pruzni prelaz 2
		if( ("PR".equals(mapa[trenutnoI][trenutnoJ-1])) || ("PP2L".equals(mapa[trenutnoI][trenutnoJ-1])) ||  ("PP2D".equals(mapa[trenutnoI][trenutnoJ-1]))  ) {
			return true;
		}
		return false;
	}
	
	public boolean prugaProvjeriDesno(int trenutnoI, int trenutnoJ) {
		//provjera za desno -> uslovi identicni kao za lijevo
		if( ("PR".equals(mapa[trenutnoI][trenutnoJ+1])) || ("PP2L".equals(mapa[trenutnoI][trenutnoJ+1])) ||  ("PP2D".equals(mapa[trenutnoI][trenutnoJ+1]))  ) {
			return true;
		}
		return false;
	}
	
	public boolean provjeriTrenutnuPoziciju(int trenutnoI, int trenutnoJ) {
		if( ("PR".equals(mapa[trenutnoI][trenutnoJ])) || ("PP2L".equals(mapa[trenutnoI][trenutnoJ])) ||  ("PP2D".equals(mapa[trenutnoI][trenutnoJ]))  ) {
			return true;
		}
		return false;
	}
	
	/**	Metode za provjere da li su kompozicije stigle do stanice(a). */
	public boolean provjeraDaLiJeKompozicijaStiglaNaStanicuApravacB(int trenutnoI, int trenutnoJ) {
		if( ("A".equals(mapa[trenutnoI+1][trenutnoJ])) ) {
			return true;
		}
		return false;
	}
	
	public boolean provjeraDaLiJeKompozicijaStiglaNaStanicuBpravacA(int trenutnoI, int trenutnoJ) {
		//gleda desno jer je donekle logicno
		if( ("B".equals(mapa[trenutnoI][trenutnoJ+1])) ) {
			System.out.println("BREAK POINT PROVJERA STANICE B -> Indeksi su: " + trenutnoI + " " + trenutnoJ);
			return true;
		}
		return false;
	}
	
	public boolean provjeraDaLiJeKompozicijaStiglaNaStanicuBPravacC(int trenutnoI, int trenutnoJ) {
		if( ("B".equals(mapa[trenutnoI][trenutnoJ-1])) ) {
			return true;
		}
		return false;
	}
	
	public boolean provjeraDaLiJeKompozicijaStiglaNaStanicuCPravacB(int trenutnoI, int trenutnoJ) {
		if( ("C".equals(mapa[trenutnoI+1][trenutnoJ])) ) {
			return true;
		}
		return false;
	}
	
	public boolean provjeraDaLiJeKompozicijaStiglaNaStanicuCPravacD(int trenutnoI, int trenutnoJ) {
		if( ("C".equals(mapa[trenutnoI][trenutnoJ-1])) ) {
			return true;
		}
		return false;
	}
	
	public boolean provjeraDaLiJeKompozicijaStiglaNaStanicuCPravacE(int trenutnoI, int trenutnoJ) {
		if( ("C".equals(mapa[trenutnoI-1][trenutnoJ])) ) {
			return true;
		}
		return false;
	}
	
	public boolean provjeraDaLiJeKompozicijaStiglaNaStanicuDPravacC(int trenutnoI, int trenutnoJ) {
		if( ("D".equals(mapa[trenutnoI][trenutnoJ+1])) ) {
			return true;
		}
		return false;
	}
	
	public boolean provjeraDaLiJeKompozicijaStiglaNaStanicuEPravacC(int trenutnoI, int trenutnoJ) {
		if( ("E".equals(mapa[trenutnoI+1][trenutnoJ])) ) {
			return true;
		}
		return false;
		
	}
	
	
	/**Metode za provjeru smjera kompozicija. */
	public synchronized boolean provjeriSmjerAB() {
		// A = 0 B = 1 jer je A pocetna stanica
		Iterator<Kompozicija> iteratorKompozicije = kompozicije.iterator();//iterator za kretanje(iteraciju) kroz kompoziciju

		//polje prije A Stanice
		if( (mapa[29][2] instanceof Kompozicija)) {
			Kompozicija kompozicija = (Kompozicija)mapa[29][2];
			int k=0;
			//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
			for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
				if(kompozicije.get(k).getID().equals(kompozicija.getID())) {
					if( ("A".equals(kompozicija.vratiStanicu(0))) && ("B".equals(kompozicija.vratiStanicu(1))) ) {
						return true;
					}
				}
				k++;
			}
		}
		
		//dionica od stanice A do Pruznog prelaza 
		for(int i = 26; i > 21; i--) {
			if( (mapa[i][2] instanceof Kompozicija) ) {
				Kompozicija kompozicija = (Kompozicija)mapa[i][2];
				System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U for i if GDJE BI TREBAO UC" ); // DA UDJE - ZNACI PREPOZNA GA NA MAPI
				int k=0;
				//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
				for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
					String id = kompozicije.get(k).getID();
					//ne udje - zastO ? 
					if(id.equals(kompozicija.getID())) {
						if( ("A".equals(kompozicija.vratiStanicu(0))) && ("B".equals(kompozicija.vratiStanicu(1))) ) {
							return true;
						}
					}
					k++;
				}
			}
		}
		
		//PROVJERA pruznog prelaza broj 1
		if((mapa[21][2] instanceof Kompozicija) ) {
			Kompozicija kompozicija = (Kompozicija)mapa[21][2];
			int k=0;
			//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
			for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
				String id = kompozicije.get(k).getID();
				System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
				if(id.equals(kompozicija.getID())) {
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
					if( ("A".equals(kompozicija.vratiStanicu(0))) && ("B".equals(kompozicija.vratiStanicu(1))) ) {
						return true;
					}
				}
				k++;
			}
		}
		
		if( (mapa[20][2] instanceof Kompozicija)) {
			Kompozicija kompozicija = (Kompozicija)mapa[20][2];
			int k=0;
			//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
			for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
				String id = kompozicije.get(k).getID();
				System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
				if(id.equals(kompozicija.getID())) {
					if( ("A".equals(kompozicija.vratiStanicu(0))) && ("B".equals(kompozicija.vratiStanicu(1))) ) {
						return true;
					}
				}
				k++;
			}
		}

		//dionica do pruznog prelaza do skretanja desno
		for(int i=19; i > 15; i-- ) {
			if( (mapa[i][2] instanceof Kompozicija)) {
				Kompozicija kompozicija = (Kompozicija)mapa[i][2];
				int k=0;
				//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
				for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
					String id = kompozicije.get(k).getID();
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
					if(id.equals(kompozicija.getID())) {
						if( ("A".equals(kompozicija.vratiStanicu(0))) && ("B".equals(kompozicija.vratiStanicu(1))) ) {
							return true;
						}
					}
					k++;
				}
			}
		}
		
		//dionica kada skrene desno
		for(int j=3; j < 6; j++) {
			if( (mapa[16][j] instanceof Kompozicija) ) {
				Kompozicija kompozicija = (Kompozicija)mapa[16][j];
				int k=0;
				//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
				for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
					String id = kompozicije.get(k).getID();
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
					if(id.equals(kompozicija.getID())) {
						if( ("A".equals(kompozicija.vratiStanicu(0))) && ("B".equals(kompozicija.vratiStanicu(1))) ) {
							return true;
						}
					}
					k++;
				}
			}
		}
		
		//dionica prema gore do B Stanice
		for(int i = 15; i > 5; i--) {
			if( (mapa[i][5] instanceof Kompozicija) ) {
				Kompozicija kompozicija = (Kompozicija)mapa[i][5];
				int k=0;
				//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
				for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
					String id = kompozicije.get(k).getID();
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
					if(id.equals(kompozicija.getID())) {
						if( ("A".equals(kompozicija.vratiStanicu(0))) && ("B".equals(kompozicija.vratiStanicu(1))) ) {
							return true;
						}
					}
					k++;
				}
			}
		}
		
		return false;
		
	}
	
	public boolean provjeriSmjerBA() {
		// A = 3 i B = 2 ako ides od E ili D i A = 2 B = 1 ako ides od C
		
		//dionica od stanice A do Pruznog prelaza 
		for(int i = 26; i > 21; i--) {
			if( (mapa[i][2] instanceof Kompozicija) ) {
				Kompozicija kompozicija = (Kompozicija)mapa[i][2];
				System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U for i if GDJE BI TREBAO UC" ); // DA UDJE - ZNACI PREPOZNA GA NA MAPI
				int k=0;
				//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
				for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
					String id = kompozicije.get(k).getID();
					//ne udje - zastO ? 
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
					if(id.equals(kompozicija.getID())) {
						System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
						if( (("A".equals(kompozicija.vratiStanicu(3))) && ("B".equals(kompozicija.vratiStanicu(2)))) || (("A".equals(kompozicija.vratiStanicu(2))) && ("B".equals(kompozicija.vratiStanicu(1))))  ||  (("A".equals(kompozicija.vratiStanicu(1))) && ("B".equals(kompozicija.vratiStanicu(0))))) {
							return true;
						}
					}
					k++;
				}
			}
		}
		
		//PROVJERA pruznog prelaza broj 1
		if((mapa[21][2] instanceof Kompozicija) ) {
			Kompozicija kompozicija = (Kompozicija)mapa[21][2];
			int k=0;
			//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
			for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
				String id = kompozicije.get(k).getID();
				System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
				if(id.equals(kompozicija.getID())) {
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
					if( (("A".equals(kompozicija.vratiStanicu(3))) && ("B".equals(kompozicija.vratiStanicu(2)))) || (("A".equals(kompozicija.vratiStanicu(2))) && ("B".equals(kompozicija.vratiStanicu(1)))) ||  (("A".equals(kompozicija.vratiStanicu(1))) && ("B".equals(kompozicija.vratiStanicu(0)))) ) {
						return true;
					}
				}
				k++;
			}
		}
		
		if( (mapa[20][2] instanceof Kompozicija)) {
			Kompozicija kompozicija = (Kompozicija)mapa[20][2];
			int k=0;
			//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
			for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
				String id = kompozicije.get(k).getID();
				System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
				if(id.equals(kompozicija.getID())) {
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
					if( (("A".equals(kompozicija.vratiStanicu(3))) && ("B".equals(kompozicija.vratiStanicu(2)))) || (("A".equals(kompozicija.vratiStanicu(2))) && ("B".equals(kompozicija.vratiStanicu(1))))  ||  (("A".equals(kompozicija.vratiStanicu(1))) && ("B".equals(kompozicija.vratiStanicu(0))))) {
						return true;
					}
				}
				k++;
			}
		}

		//dionica do pruznog prelaza do skretanja desno
		for(int i=19; i > 15; i-- ) {
			if( (mapa[i][2] instanceof Kompozicija)) {
				Kompozicija kompozicija = (Kompozicija)mapa[i][2];
				int k=0;
				//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
				for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
					String id = kompozicije.get(k).getID();
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
					if(id.equals(kompozicija.getID())) {
						System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
						if( (("A".equals(kompozicija.vratiStanicu(3))) && ("B".equals(kompozicija.vratiStanicu(2)))) || (("A".equals(kompozicija.vratiStanicu(2))) && ("B".equals(kompozicija.vratiStanicu(1)))) ||  (("A".equals(kompozicija.vratiStanicu(1))) && ("B".equals(kompozicija.vratiStanicu(0)))) ) {
							return true;
						}
					}
					k++;
				}
			}
		}
		
		//dionica kada skrene desno
		for(int j=3; j < 6; j++) {
			if( (mapa[16][j] instanceof Kompozicija) ) {
				Kompozicija kompozicija = (Kompozicija)mapa[16][j];
				int k=0;
				//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
				for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
					String id = kompozicije.get(k).getID();
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
					if(id.equals(kompozicija.getID())) {
						System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
						if( (("A".equals(kompozicija.vratiStanicu(3))) && ("B".equals(kompozicija.vratiStanicu(2)))) || (("A".equals(kompozicija.vratiStanicu(2))) && ("B".equals(kompozicija.vratiStanicu(1)))) ||  (("A".equals(kompozicija.vratiStanicu(1))) && ("B".equals(kompozicija.vratiStanicu(0))))) {
							return true;
						}
					}
					k++;
				}
			}
		}
		
		//dionica prema gore do B Stanice
		for(int i = 15; i > 5; i--) {
			if( (mapa[i][5] instanceof Kompozicija) ) {
				Kompozicija kompozicija = (Kompozicija)mapa[i][5];
				int k=0;
				//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
				for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
					String id = kompozicije.get(k).getID();
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
					if(id.equals(kompozicija.getID())) {
						System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
						if( (("A".equals(kompozicija.vratiStanicu(3))) && ("B".equals(kompozicija.vratiStanicu(2)))) || (("A".equals(kompozicija.vratiStanicu(2))) && ("B".equals(kompozicija.vratiStanicu(1)))) ) {
							return true;
						}
					}
					k++;
				}
			}
		}
		
		return false;		
	}
	
	public boolean provjeriSmjerBC() {
		// B = 1 C = 2 (ako ide od stanice A ) ili  B = 0 i C=1 (ako ide od B kao C i eventualno dalje produzava)
		
		// od stanice b do pruznog prelaza
		for(int j=8; j < 13; j++) {
			if((mapa[6][j] instanceof Kompozicija)) {
				Kompozicija kompozicija = (Kompozicija)mapa[6][j];
				int k=0;
				//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
				for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
					String id = kompozicije.get(k).getID();
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
					if(id.equals(kompozicija.getID())) {
						System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
						if( (("B".equals(kompozicija.vratiStanicu(1))) && ("C".equals(kompozicija.vratiStanicu(2)))) || (("B".equals(kompozicija.vratiStanicu(0))) && ("C".equals(kompozicija.vratiStanicu(1)))) ) {
							return true;
						}
					}
					k++;
				}
			}
		}
		
		// inicijalicazacija Pruznog Prelaza 2
		if((mapa[6][13] instanceof Kompozicija)) {
			Kompozicija kompozicija = (Kompozicija)mapa[6][13];
			int k=0;
			//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
			for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
				String id = kompozicije.get(k).getID();
				System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
				if(id.equals(kompozicija.getID())) {
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
					if( (("B".equals(kompozicija.vratiStanicu(1))) && ("C".equals(kompozicija.vratiStanicu(2)))) || (("B".equals(kompozicija.vratiStanicu(0))) && ("C".equals(kompozicija.vratiStanicu(1)))) ) {
						return true;
					}
				}
				k++;
			}
		}
		
		if((mapa[6][14] instanceof Kompozicija) ) {
			Kompozicija kompozicija = (Kompozicija)mapa[6][14];
			int k=0;
			//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
			for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
				String id = kompozicije.get(k).getID();
				System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
				if(id.equals(kompozicija.getID())) {
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
					if( (("B".equals(kompozicija.vratiStanicu(1))) && ("C".equals(kompozicija.vratiStanicu(2)))) || (("B".equals(kompozicija.vratiStanicu(0))) && ("C".equals(kompozicija.vratiStanicu(1)))) ) {
						return true;
					}
				}
				k++;
			}
		}
		
		//od pruznog prlaza 2 do skretanja prema dole
		for(int j=15;  j < 20; j++) {
			if((mapa[6][j] instanceof Kompozicija) ) {
				Kompozicija kompozicija = (Kompozicija)mapa[6][j];
				int k=0;
				//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
				for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
					String id = kompozicije.get(k).getID();
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
					if(id.equals(kompozicija.getID())) {
						System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
						if( (("B".equals(kompozicija.vratiStanicu(1))) && ("C".equals(kompozicija.vratiStanicu(2)))) || (("B".equals(kompozicija.vratiStanicu(0))) && ("C".equals(kompozicija.vratiStanicu(1)))) ) {
							return true;
						}
					}
					k++;
				}
			}
		}
		
		//dionica kada skrene prema dole pa do stanice C
		for(int i = 6; i < 12; i++) {
			if((mapa[i][19] instanceof Kompozicija) ) {
				Kompozicija kompozicija = (Kompozicija)mapa[i][19];
				int k=0;
				//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
				for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
					String id = kompozicije.get(k).getID();
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
					if(id.equals(kompozicija.getID())) {
						System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
						if( (("B".equals(kompozicija.vratiStanicu(1))) && ("C".equals(kompozicija.vratiStanicu(2)))) || (("B".equals(kompozicija.vratiStanicu(0))) && ("C".equals(kompozicija.vratiStanicu(1)))) ) {
							return true;
						}
					}
					k++;
				}
			}
		}
		
		return false;
	}
	
	public boolean provjeriSmjerCB() {
		// Ako je C = 1  i B = 2 (kada ide od D ili E) ili C = 0  i B = 1 (kada je to prva linija kojom ide)
		// od stanice b do pruznog prelaza
				for(int j=8; j < 13; j++) {
					if((mapa[6][j] instanceof Kompozicija)) {
						Kompozicija kompozicija = (Kompozicija)mapa[6][j];
						int k=0;
						//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
						for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
							String id = kompozicije.get(k).getID();
							System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
							if(id.equals(kompozicija.getID())) {
								System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
								if( (("C".equals(kompozicija.vratiStanicu(1))) && ("B".equals(kompozicija.vratiStanicu(2)))) || (("C".equals(kompozicija.vratiStanicu(0))) && ("B".equals(kompozicija.vratiStanicu(1)))) ) {
									return true;
								}
							}
							k++;
						}
					}
				}
				
				// inicijalicazacija Pruznog Prelaza 2
				if((mapa[6][13] instanceof Kompozicija)) {
					Kompozicija kompozicija = (Kompozicija)mapa[6][13];
					int k=0;
					//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
					for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
						String id = kompozicije.get(k).getID();
						System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
						if(id.equals(kompozicija.getID())) {
							System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
							if( (("C".equals(kompozicija.vratiStanicu(1))) && ("B".equals(kompozicija.vratiStanicu(2)))) || (("C".equals(kompozicija.vratiStanicu(0))) && ("B".equals(kompozicija.vratiStanicu(1)))) ) {
								return true;
							}
						}
						k++;
					}
				}
				
				if((mapa[6][14] instanceof Kompozicija) ) {
					Kompozicija kompozicija = (Kompozicija)mapa[6][14];
					int k=0;
					//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
					for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
						String id = kompozicije.get(k).getID();
						System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
						if(id.equals(kompozicija.getID())) {
							System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
							if( (("C".equals(kompozicija.vratiStanicu(1))) && ("B".equals(kompozicija.vratiStanicu(2)))) || (("C".equals(kompozicija.vratiStanicu(0))) && ("B".equals(kompozicija.vratiStanicu(1)))) ) {
								return true;
							}
						}
						k++;
					}
				}
				
				//od pruznog prlaza 2 do skretanja prema dole
				for(int j=15;  j < 20; j++) {
					if((mapa[6][j] instanceof Kompozicija) ) {
						Kompozicija kompozicija = (Kompozicija)mapa[6][j];
						int k=0;
						//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
						for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
							String id = kompozicije.get(k).getID();
							System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
							if(id.equals(kompozicija.getID())) {
								System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
								if( (("C".equals(kompozicija.vratiStanicu(1))) && ("B".equals(kompozicija.vratiStanicu(2)))) || (("C".equals(kompozicija.vratiStanicu(0))) && ("B".equals(kompozicija.vratiStanicu(1)))) ) {
									return true;
								}
							}
							k++;
						}
					}
				}
				
				//dionica kada skrene prema dole pa do stanice C
				for(int i = 6; i < 12; i++) {
					if((mapa[i][19] instanceof Kompozicija) ) {
						Kompozicija kompozicija = (Kompozicija)mapa[i][19];
						int k=0;
						//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
						for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
							String id = kompozicije.get(k).getID();
							System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
							if(id.equals(kompozicija.getID())) {
								System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
								if( (("C".equals(kompozicija.vratiStanicu(1))) && ("B".equals(kompozicija.vratiStanicu(2)))) || (("C".equals(kompozicija.vratiStanicu(0))) && ("B".equals(kompozicija.vratiStanicu(1)))) ) {
									return true;
								}
							}
							k++;
						}
					}
				}
				
				return false;
	}
	
	public boolean provjeriSmjerCE() {
		
		// C = 0 E = 1 (ako je to jedina linija) C = 1 E = 2 (ako ima stanica prije npr B ili D) i C=2 E=3 (ako ide od A)//dionica kada ide od C prema dole
		for(int i=14; i < 19; i++) {
			if((mapa[i][20] instanceof Kompozicija)) {
				Kompozicija kompozicija = (Kompozicija)mapa[i][20];
				int k=0;
				//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
				for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
					String id = kompozicije.get(k).getID();
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
					if(id.equals(kompozicija.getID())) {
						System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
						if( (("C".equals(kompozicija.vratiStanicu(1))) && ("B".equals(kompozicija.vratiStanicu(2)))) || (("C".equals(kompozicija.vratiStanicu(0))) && ("B".equals(kompozicija.vratiStanicu(1)))) || (("C".equals(kompozicija.vratiStanicu(2))) && ("B".equals(kompozicija.vratiStanicu(3)))) ) {
							return true;
						}
					}
					k++;
				}
			}
			
		}
		
		//dionica puta kada skrene desno
		for(int j = 20; j < 27 ; j++) {
			if((mapa[18][j] instanceof Kompozicija)) {
				Kompozicija kompozicija = (Kompozicija)mapa[18][j];
				int k=0;
				//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
				for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
					String id = kompozicije.get(k).getID();
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
					if(id.equals(kompozicija.getID())) {
						System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
						if( (("C".equals(kompozicija.vratiStanicu(1))) && ("B".equals(kompozicija.vratiStanicu(2)))) || (("C".equals(kompozicija.vratiStanicu(0))) && ("B".equals(kompozicija.vratiStanicu(1)))) || (("C".equals(kompozicija.vratiStanicu(2))) && ("B".equals(kompozicija.vratiStanicu(3)))) ) {
							return true;
						}
					}
					k++;
				}
			}
		}
		
		//dionica puta prema dole do kruznog prelaza
		for(int i=18; i <20; i++) {
			if((mapa[i][26] instanceof Kompozicija)) {
				Kompozicija kompozicija = (Kompozicija)mapa[i][26];
				int k=0;
				//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
				for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
					String id = kompozicije.get(k).getID();
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
					if(id.equals(kompozicija.getID())) {
						System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
						if( (("C".equals(kompozicija.vratiStanicu(1))) && ("E".equals(kompozicija.vratiStanicu(2)))) || (("C".equals(kompozicija.vratiStanicu(0))) && ("E".equals(kompozicija.vratiStanicu(1)))) || (("C".equals(kompozicija.vratiStanicu(2))) && ("E".equals(kompozicija.vratiStanicu(3)))) ) {
							return true;
						}
					}
					k++;
				}
			}
		}
		
		//dionica gdje su pruzni prelazi
		if((mapa[20][26] instanceof Kompozicija)) {
			Kompozicija kompozicija = (Kompozicija)mapa[20][26];
			int k=0;
			//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
			for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
				String id = kompozicije.get(k).getID();
				System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
				if(id.equals(kompozicija.getID())) {
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
					if( (("C".equals(kompozicija.vratiStanicu(1))) && ("E".equals(kompozicija.vratiStanicu(2)))) || (("C".equals(kompozicija.vratiStanicu(0))) && ("E".equals(kompozicija.vratiStanicu(1)))) || (("C".equals(kompozicija.vratiStanicu(2))) && ("E".equals(kompozicija.vratiStanicu(3)))) ) {
						return true;
					}
				}
				k++;
			}
		}
		
		if((mapa[20][27] instanceof Kompozicija)) {
			Kompozicija kompozicija = (Kompozicija)mapa[20][27];
			int k=0;
			//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
			for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
				String id = kompozicije.get(k).getID();
				System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
				if(id.equals(kompozicija.getID())) {
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
					if( (("C".equals(kompozicija.vratiStanicu(1))) && ("E".equals(kompozicija.vratiStanicu(2)))) || (("C".equals(kompozicija.vratiStanicu(0))) && ("E".equals(kompozicija.vratiStanicu(1)))) || (("C".equals(kompozicija.vratiStanicu(2))) && ("E".equals(kompozicija.vratiStanicu(3)))) ) {
						return true;
					}
				}
				k++;
			}
		}
		
		//dionica od pruznog prelaza do stanice E - razmisliti o ovom dijelu
		for(int i=22; i < 25; i++) {
			if((mapa[i][26] instanceof Kompozicija)) {
				Kompozicija kompozicija = (Kompozicija)mapa[i][26];
				int k=0;
				//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
				for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
					String id = kompozicije.get(k).getID();
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
					if(id.equals(kompozicija.getID())) {
						System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
						if( (("C".equals(kompozicija.vratiStanicu(1))) && ("E".equals(kompozicija.vratiStanicu(2)))) || (("C".equals(kompozicija.vratiStanicu(0))) && ("E".equals(kompozicija.vratiStanicu(1)))) || (("C".equals(kompozicija.vratiStanicu(2))) && ("E".equals(kompozicija.vratiStanicu(3)))) ) {
							return true;
						}
					}
					k++;
				}
			}
		}
		
		//od E prema kraju mape '<=' jer mora inicijalizovati i 29
		for(int j=27; j <= 29; j++) {
			if((mapa[25][j] instanceof Kompozicija)) {
				Kompozicija kompozicija = (Kompozicija)mapa[25][j];
				int k=0;
				//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
				for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
					String id = kompozicije.get(k).getID();
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
					if(id.equals(kompozicija.getID())) {
						System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
						if( (("C".equals(kompozicija.vratiStanicu(1))) && ("E".equals(kompozicija.vratiStanicu(2)))) || (("C".equals(kompozicija.vratiStanicu(0))) && ("E".equals(kompozicija.vratiStanicu(1)))) || (("C".equals(kompozicija.vratiStanicu(2))) && ("E".equals(kompozicija.vratiStanicu(3)))) ) {
							return true;
						}
					}
					k++;
				}
			}
		}
		
		return false;
		
	}
	
	public boolean provjeriSmjerEC() {
	
	// E = 0 C = 1, ako ide i dalje a i ako je samo ta linija moguca
		for(int i=14; i < 19; i++) {
			if((mapa[i][20] instanceof Kompozicija)) {
				Kompozicija kompozicija = (Kompozicija)mapa[i][20];
				int k=0;
				//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
				for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
					String id = kompozicije.get(k).getID();
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
					if(id.equals(kompozicija.getID())) {
						System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
						if( (("E".equals(kompozicija.vratiStanicu(0))) && ("C".equals(kompozicija.vratiStanicu(1))))) {
							return true;
						}
					}
					k++;
				}
			}
			
		}
		
		//dionica puta kada skrene desno
		for(int j = 20; j < 27 ; j++) {
			if((mapa[18][j] instanceof Kompozicija)) {
				Kompozicija kompozicija = (Kompozicija)mapa[18][j];
				int k=0;
				//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
				for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
					String id = kompozicije.get(k).getID();
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
					if(id.equals(kompozicija.getID())) {
						System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
						if( (("E".equals(kompozicija.vratiStanicu(0))) && ("C".equals(kompozicija.vratiStanicu(1)))) ) {
							return true;
						}
					}
					k++;
				}
			}
		}
		
		//dionica puta prema dole do kruznog prelaza
		for(int i=18; i <20; i++) {
			if((mapa[i][26] instanceof Kompozicija)) {
				Kompozicija kompozicija = (Kompozicija)mapa[i][26];
				int k=0;
				//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
				for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
					String id = kompozicije.get(k).getID();
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
					if(id.equals(kompozicija.getID())) {
						System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
						if( (("E".equals(kompozicija.vratiStanicu(0))) && ("C".equals(kompozicija.vratiStanicu(1)))) ) {
							return true;
						}
					}
					k++;
				}
			}
		}
		
		//inicijalizacija Pruznog Prelaza 3
		mapa[20][26] = "PP3";
		if((mapa[20][26] instanceof Kompozicija)) {
			Kompozicija kompozicija = (Kompozicija)mapa[20][26];
			int k=0;
			//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
			for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
				String id = kompozicije.get(k).getID();
				System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
				if(id.equals(kompozicija.getID())) {
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
					if( (("E".equals(kompozicija.vratiStanicu(0))) && ("C".equals(kompozicija.vratiStanicu(1))))) {
						return true;
					}
				}
				k++;
			}
		}
		
		if((mapa[20][27] instanceof Kompozicija)) {
			Kompozicija kompozicija = (Kompozicija)mapa[20][27];
			int k=0;
			//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
			for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
				String id = kompozicije.get(k).getID();
				System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
				if(id.equals(kompozicija.getID())) {
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
					if( (("E".equals(kompozicija.vratiStanicu(0))) && ("C".equals(kompozicija.vratiStanicu(1))))) {
						return true;
					}
				}
				k++;
			}
		}
		
		//dionica od pruznog prelaza do stanice E
		for(int i=22; i < 25; i++) {
			if((mapa[i][26] instanceof Kompozicija)) {
				Kompozicija kompozicija = (Kompozicija)mapa[i][26];
				int k=0;
				//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
				for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
					String id = kompozicije.get(k).getID();
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
					if(id.equals(kompozicija.getID())) {
						System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
						if( (("E".equals(kompozicija.vratiStanicu(0))) && ("C".equals(kompozicija.vratiStanicu(1))))) {
							return true;
						}
					}
					k++;
				}
			}
		}
		
		//od E prema kraju mape '<=' jer mora inicijalizovati i 29
		for(int j=27; j <= 29; j++) {
			if((mapa[25][j] instanceof Kompozicija)) {
				Kompozicija kompozicija = (Kompozicija)mapa[25][j];
				int k=0;
				//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
				for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
					String id = kompozicije.get(k).getID();
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
					if(id.equals(kompozicija.getID())) {
						System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
						if( (("E".equals(kompozicija.vratiStanicu(0))) && ("C".equals(kompozicija.vratiStanicu(1)))) )  {
							return true;
						}
					}
					k++;
				}
			}
		}
		
		return false;
		
	}
	
	public boolean provjeriSmjerCD() {
		// C = 0 D = 1 (ako voz ide samo od C do D) ili C = 1 D = 2 (ako ide od E ili B) ili C = 2 D = 3 (ako ide od A)
		//dionuica od C stanice desno do skretanja prema gore
		for(int j=21; j < 27; j++) {
			if((mapa[12][j] instanceof Kompozicija)) {
				Kompozicija kompozicija = (Kompozicija)mapa[12][j];
				int k=0;
				//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
				for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
					String id = kompozicije.get(k).getID();
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
					if(id.equals(kompozicija.getID())) {
						System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
						if( (("C".equals(kompozicija.vratiStanicu(1))) && ("D".equals(kompozicija.vratiStanicu(2)))) || (("C".equals(kompozicija.vratiStanicu(0))) && ("D".equals(kompozicija.vratiStanicu(1)))) || (("C".equals(kompozicija.vratiStanicu(2))) && ("D".equals(kompozicija.vratiStanicu(3)))) ) {
							return true;
						}
					}
					k++;
				}
			}
		}
		
		//dionica puta od skretanja prema gore
		for(int i=12; i > 8; i--) {
			if((mapa[i][26] instanceof Kompozicija)) {
				Kompozicija kompozicija = (Kompozicija)mapa[i][26];
				int k=0;
				//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
				for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
					String id = kompozicije.get(k).getID();
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
					if(id.equals(kompozicija.getID())) {
						System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
						if( (("C".equals(kompozicija.vratiStanicu(1))) && ("D".equals(kompozicija.vratiStanicu(2)))) || (("C".equals(kompozicija.vratiStanicu(0))) && ("D".equals(kompozicija.vratiStanicu(1)))) || (("C".equals(kompozicija.vratiStanicu(2))) && ("D".equals(kompozicija.vratiStanicu(3)))) ) {
							return true;
						}
					}
					k++;
				}
			}
		}
		
		//dionica puta skretanje desno
		for(int j=26; j < 29; j++) {
			if((mapa[9][j] instanceof Kompozicija)) {
				Kompozicija kompozicija = (Kompozicija)mapa[9][j];
				int k=0;
				//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
				for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
					String id = kompozicije.get(k).getID();
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
					if(id.equals(kompozicija.getID())) {
						System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
						if( (("C".equals(kompozicija.vratiStanicu(1))) && ("D".equals(kompozicija.vratiStanicu(2)))) || (("C".equals(kompozicija.vratiStanicu(0))) && ("D".equals(kompozicija.vratiStanicu(1)))) || (("C".equals(kompozicija.vratiStanicu(2))) && ("D".equals(kompozicija.vratiStanicu(3)))) ) {
							return true;
						}
					}
					k++;
				}
			}
		}
		
		for(int i=9; i > 4; i--) {
			if((mapa[i][28] instanceof Kompozicija)) {
				Kompozicija kompozicija = (Kompozicija)mapa[i][28];
				int k=0;
				//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
				for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
					String id = kompozicije.get(k).getID();
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
					if(id.equals(kompozicija.getID())) {
						System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
						if( (("C".equals(kompozicija.vratiStanicu(1))) && ("D".equals(kompozicija.vratiStanicu(2)))) || (("C".equals(kompozicija.vratiStanicu(0))) && ("D".equals(kompozicija.vratiStanicu(1)))) || (("C".equals(kompozicija.vratiStanicu(2))) && ("D".equals(kompozicija.vratiStanicu(3)))) ) {
							return true;
						}
					}
					k++;
				}
			}
		}
		
		//dionica kada skrene lijevo
		for(int j=28; j > 22; j--) {
			if((mapa[5][j] instanceof Kompozicija)) {
				Kompozicija kompozicija = (Kompozicija)mapa[5][j];
				int k=0;
				//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
				for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
					String id = kompozicije.get(k).getID();
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
					if(id.equals(kompozicija.getID())) {
						System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
						if( (("C".equals(kompozicija.vratiStanicu(1))) && ("D".equals(kompozicija.vratiStanicu(2)))) || (("C".equals(kompozicija.vratiStanicu(0))) && ("D".equals(kompozicija.vratiStanicu(1)))) || (("C".equals(kompozicija.vratiStanicu(2))) && ("D".equals(kompozicija.vratiStanicu(3)))) ) {
							return true;
						}
					}
					k++;
				}
			}
		}
		
		//dionica kada skrene gore
		for(int i=5; i > 2; i--) {
			if((mapa[i][23] instanceof Kompozicija)) {
				Kompozicija kompozicija = (Kompozicija)mapa[i][23];
				int k=0;
				//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
				for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
					String id = kompozicije.get(k).getID();
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
					if(id.equals(kompozicija.getID())) {
						System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
						if( (("C".equals(kompozicija.vratiStanicu(1))) && ("D".equals(kompozicija.vratiStanicu(2)))) || (("C".equals(kompozicija.vratiStanicu(0))) && ("D".equals(kompozicija.vratiStanicu(1)))) || (("C".equals(kompozicija.vratiStanicu(2))) && ("D".equals(kompozicija.vratiStanicu(3)))) ) {
							return true;
						}
					}
					k++;
				}
			}
		}
		
		//dionica kada skrene lijevo i krene gore
		if((mapa[3][22] instanceof Kompozicija)) {
			Kompozicija kompozicija = (Kompozicija)mapa[3][22];
			int k=0;
			//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
			for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
				String id = kompozicije.get(k).getID();
				System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
				if(id.equals(kompozicija.getID())) {
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
					if( (("C".equals(kompozicija.vratiStanicu(1))) && ("D".equals(kompozicija.vratiStanicu(2)))) || (("C".equals(kompozicija.vratiStanicu(0))) && ("D".equals(kompozicija.vratiStanicu(1)))) || (("C".equals(kompozicija.vratiStanicu(2))) && ("D".equals(kompozicija.vratiStanicu(3)))) ) {
						return true;
					}
				}
				k++;
			}
		}
		
		if((mapa[2][22] instanceof Kompozicija)) {
			Kompozicija kompozicija = (Kompozicija)mapa[2][22];
			int k=0;
			//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
			for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
				String id = kompozicije.get(k).getID();
				System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
				if(id.equals(kompozicija.getID())) {
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
					if( (("C".equals(kompozicija.vratiStanicu(1))) && ("D".equals(kompozicija.vratiStanicu(2)))) || (("C".equals(kompozicija.vratiStanicu(0))) && ("D".equals(kompozicija.vratiStanicu(1)))) || (("C".equals(kompozicija.vratiStanicu(2))) && ("D".equals(kompozicija.vratiStanicu(3)))) ) {
						return true;
					}
				}
				k++;
			}
		}
		if((mapa[1][22] instanceof Kompozicija)) {
			Kompozicija kompozicija = (Kompozicija)mapa[1][22];
			int k=0;
			//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
			for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
				String id = kompozicije.get(k).getID();
				System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
				if(id.equals(kompozicija.getID())) {
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
					if( (("C".equals(kompozicija.vratiStanicu(1))) && ("D".equals(kompozicija.vratiStanicu(2)))) || (("C".equals(kompozicija.vratiStanicu(0))) && ("D".equals(kompozicija.vratiStanicu(1)))) || (("C".equals(kompozicija.vratiStanicu(2))) && ("D".equals(kompozicija.vratiStanicu(3)))) ) {
						return true;
					}
				}
				k++;
			}
		}
		
		//dionica kada skrene desno prema D stanici
		for(int j=22; j < 26; j++) {
			if((mapa[1][j] instanceof Kompozicija)) {
				Kompozicija kompozicija = (Kompozicija)mapa[1][j];
				int k=0;
				//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
				for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
					String id = kompozicije.get(k).getID();
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
					if(id.equals(kompozicija.getID())) {
						System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
						if( (("C".equals(kompozicija.vratiStanicu(1))) && ("D".equals(kompozicija.vratiStanicu(2)))) || (("C".equals(kompozicija.vratiStanicu(0))) && ("D".equals(kompozicija.vratiStanicu(1)))) || (("C".equals(kompozicija.vratiStanicu(2))) && ("D".equals(kompozicija.vratiStanicu(3)))) ) {
							return true;
						}
					}
					k++;
				}
			}
		}		
		return false;
	}
	
	public boolean provjeriSmjerDC() {
		
		// D = 0 C = 1 (ako ide i dalje, a i ako je to jedina linija )
		
		for(int j=21; j < 27; j++) {
			if((mapa[12][j] instanceof Kompozicija)) {
				Kompozicija kompozicija = (Kompozicija)mapa[12][j];
				int k=0;
				//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
				for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
					String id = kompozicije.get(k).getID();
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
					if(id.equals(kompozicija.getID())) {
						System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
						if((("D".equals(kompozicija.vratiStanicu(0))) && ("C".equals(kompozicija.vratiStanicu(1))))) {
							return true;
						}
					}
					k++;
				}
			}
		}
		
		//dionica puta od skretanja prema gore
		for(int i=12; i > 8; i--) {
			if((mapa[i][26] instanceof Kompozicija)) {
				Kompozicija kompozicija = (Kompozicija)mapa[i][26];
				int k=0;
				//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
				for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
					String id = kompozicije.get(k).getID();
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
					if(id.equals(kompozicija.getID())) {
						System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
						if((("D".equals(kompozicija.vratiStanicu(0))) && ("C".equals(kompozicija.vratiStanicu(1))))) {
							return true;
						}
					}
					k++;
				}
			}
		}
		
		//dionica puta skretanje desno
		for(int j=26; j < 29; j++) {
			if((mapa[9][j] instanceof Kompozicija)) {
				Kompozicija kompozicija = (Kompozicija)mapa[9][j];
				int k=0;
				//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
				for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
					String id = kompozicije.get(k).getID();
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
					if(id.equals(kompozicija.getID())) {
						System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
						if((("D".equals(kompozicija.vratiStanicu(0))) && ("C".equals(kompozicija.vratiStanicu(1))))) {
							return true;
						}
					}
					k++;
				}
			}
		}
		
		for(int i=9; i > 4; i--) {
			if((mapa[i][28] instanceof Kompozicija)) {
				Kompozicija kompozicija = (Kompozicija)mapa[i][28];
				int k=0;
				//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
				for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
					String id = kompozicije.get(k).getID();
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
					if(id.equals(kompozicija.getID())) {
						System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
						if((("D".equals(kompozicija.vratiStanicu(0))) && ("C".equals(kompozicija.vratiStanicu(1))))) {
							return true;
						}
					}
					k++;
				}
			}
		}
		
		//dionica kada skrene lijevo
		for(int j=28; j > 22; j--) {
			if((mapa[5][j] instanceof Kompozicija)) {
				Kompozicija kompozicija = (Kompozicija)mapa[5][j];
				int k=0;
				//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
				for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
					String id = kompozicije.get(k).getID();
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
					if(id.equals(kompozicija.getID())) {
						System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
						if((("D".equals(kompozicija.vratiStanicu(0))) && ("C".equals(kompozicija.vratiStanicu(1))))) {
							return true;
						}
					}
					k++;
				}
			}
		}
		
		//dionica kada skrene gore
		for(int i=5; i > 2; i--) {
			if((mapa[i][23] instanceof Kompozicija)) {
				Kompozicija kompozicija = (Kompozicija)mapa[i][23];
				int k=0;
				//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
				for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
					String id = kompozicije.get(k).getID();
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
					if(id.equals(kompozicija.getID())) {
						System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
						if((("D".equals(kompozicija.vratiStanicu(0))) && ("C".equals(kompozicija.vratiStanicu(1))))) {
							return true;
						}
					}
					k++;
				}
			}
		}
		
		//dionica kada skrene lijevo i krene gore
		if((mapa[3][22] instanceof Kompozicija)) {
			Kompozicija kompozicija = (Kompozicija)mapa[3][22];
			int k=0;
			//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
			for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
				String id = kompozicije.get(k).getID();
				System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
				if(id.equals(kompozicija.getID())) {
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
					if((("D".equals(kompozicija.vratiStanicu(0))) && ("C".equals(kompozicija.vratiStanicu(1))))) {
						return true;
					}
				}
				k++;
			}
		}
		
		if((mapa[2][22] instanceof Kompozicija)) {
			Kompozicija kompozicija = (Kompozicija)mapa[2][22];
			int k=0;
			//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
			for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
				String id = kompozicije.get(k).getID();
				System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
				if(id.equals(kompozicija.getID())) {
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
					if((("D".equals(kompozicija.vratiStanicu(0))) && ("C".equals(kompozicija.vratiStanicu(1))))) {
						return true;
					}
				}
				k++;
			}
		}
		if((mapa[1][22] instanceof Kompozicija)) {
			Kompozicija kompozicija = (Kompozicija)mapa[1][22];
			int k=0;
			//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
			for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
				String id = kompozicije.get(k).getID();
				System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
				if(id.equals(kompozicija.getID())) {
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
					if((("D".equals(kompozicija.vratiStanicu(0))) && ("C".equals(kompozicija.vratiStanicu(1))))) {
						return true;
					}
				}
				k++;
			}
		}
		
		//dionica kada skrene desno prema D stanici
		for(int j=22; j < 26; j++) {
			if((mapa[1][j] instanceof Kompozicija)) {
				Kompozicija kompozicija = (Kompozicija)mapa[1][j];
				int k=0;
				//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
				for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
					String id = kompozicije.get(k).getID();
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
					if(id.equals(kompozicija.getID())) {
						System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
						if((("D".equals(kompozicija.vratiStanicu(0))) && ("C".equals(kompozicija.vratiStanicu(1))))) {
							return true;
						}
					}
					k++;
				}
			}
		}		
		return false;
		
	}
	
	/**	Metode za vracanje pozicija od stanica. */
	public int[] vratiPozicijuStaniceA() {
		int[] pozicijaStaniceA = new int[2];
		pozicijaStaniceA[0] = 27;//i
		pozicijaStaniceA[1] = 2; //j
		
		return pozicijaStaniceA;
		
	}
	
	public String provjeriPozicijuStaniceA(int indexVrsta, int indexKolona) {
		return (String)mapa[indexVrsta+1][indexKolona];
	}
	 
	
	public boolean provjeriKompozicijeID(Kompozicija k) {
		int j=0;
		for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
			if(kompozicije.get(j).getID().equals(k.getID())) {
				return true;
			}
			j++;
		}
			return false;
	}
	
	
	/**	Metoda za 'zauzimanje' polja na mapi. */
	public synchronized void zauzmiPoziciju(int i, int j, Kompozicija kompozicija) {
		System.out.println();
		System.out.println("BREAK POINT ZAUZMI POZICIJU - INDEKSI SU  " + i + " " + j);
		System.out.println();
		if("PR".equals(mapa[i][j])) {
			mapa[i][j] = kompozicija;
		}
		else {
			try {
				Thread.sleep(1000);
			}catch(Exception e) {
				System.out.println("AAA A A ");
			}
		}
	
	}
	
	/**	Metoda za provjeru sta se nalazilo na mapi. */
	public String provjeriPolje(int i, int j) {
		String s = mapa[i][j].toString();
		System.out.println("BREAK POINT MAPA -> Metoda provjeri polje string je : " + mapa[i][j]);
		System.out.println("BREAK POINT 2 MAPA -> Indeksi su : " + i + " " + j);
		return s;
	}
	
	/**	Metoda za 'oslobadjanje' polja na mapi. */
	public synchronized void oslobodiPoziciju(int i, int j) {
		//ako je razlicito od stanica i pruznih prelaza inicijalizuj na PRUGA
		 if(i==27 && j==2){
				mapa[i][j] = "A";
				System.out.println("STANICA A BREAK POINT UPISANA NA MJESTO");
			}
		 else if((i != 21 && j !=2) || (i !=20 && j !=2) || (i != 6 && j != 13) || (i != 6 && j != 14) || (i != 20 && j != 26) || (i != 21 && j != 26) && (i!=27 && j!= 2) && (i!= 6 && j !=6) ) {
			mapa[i][j] = "PR";
			System.out.println("BREAK POINT OSLOBODI POZICIJU, STRING JE : " + mapa[i][j]);
		
			System.out.println("BREAK POINT OSLOBODI POZICIJU - INDEKSI SU  " + i + " " + j);
			System.out.println();
		}
		else if(i==21 && j==2) {
			mapa[i][j] = "PU1L";
			System.out.println("BREAK POINT OSLOBODI POZICIJU, STRING JE : " + mapa[i][j]);
		
			System.out.println("BREAK POINT OSLOBODI POZICIJU - INDEKSI SU  " + i + " " + j);
			System.out.println();

		}
		else if(i==20 && j==2) {
			mapa[i][j] = "PU1D";
			System.out.println("BREAK POINT OSLOBODI POZICIJU, STRING JE : " + mapa[i][j]);
			System.out.println("BREAK POINT OSLOBODI POZICIJU - INDEKSI SU  " + i + " " + j);
			System.out.println();

		}
		else if(i==6 && j==13) {
			mapa[i][j] = "PU2L";
		}
		else if(i==6 && j==14) {
			mapa[i][j] = "PU2D";
		}
		else if(i == 20 && j==26) {
			mapa[i][j] = "PU3L";
		}
		else if(i==27 && j==2){
			mapa[i][j] = "A";
			System.out.println("STANICA A BREAK POINT UPISANA NA MJESTO");
		}
		else {
			mapa[i][j] = "PU3D";
		}
		
	}
	
	public void ispisiDionicuAB() {
		//polje prije A Stanice
				System.out.println("Prije stanice A : " + mapa[29][2] + " lokacija: " + 29 + " " + 2);
				
				//dionica od stanice A do Pruznog prelaza 
				for(int i = 26; i > 21; i--) {
					System.out.println("Nalazimo se trenutno na mjestu: " + mapa[i][2] + " lokacija: " + i + " " + 2);
				}
				
				//inicijalizacija pruznog prelaza broj 1 ( lijeva i desna traka)
				System.out.println("Nalazimo se na pruznom prelazu 1 lijevom : " + mapa[21][2] + " lokacija: " + 21 + " " + 2 );
				System.out.println("Nalazimo se na pruznom prelazu 1 desnom : " + mapa[20][2] + " lokacija: " + 20 + " " + 2);
				
				
				//dionica do pruznog prelaza do skretanja desno
				for(int i=19; i > 15; i-- ) {
					System.out.println("Nalazimo se trenutno na mjestu: " + mapa[i][2] + " lokacija: " + i + " " + 2 );
				}
				
				//dionica kada skrene desno
				for(int j=3; j < 6; j++) {
					System.out.println("Nalazimo se trenutno na mjestu: " + mapa[16][j] + " lokacija: " + 16 + " " + j);
				}
				
				//dionica prema gore do B Stanice
				for(int i = 15; i > 5; i--) {
					System.out.println("Nalazimo se trenutno na mjestu: " + mapa[i][5] + " lokacija: " + i + " " + 5);
				}
	}
	
	/**	Metode za provjere pruznih prelaza potrebne za vozila. */
	public boolean voziloProvjeriSmjerKompozicijeAB() {
		//dionica od stanice A do Pruznog prelaza 
				for(int i = 26; i > 21; i--) {
					if( (mapa[i][2] instanceof Kompozicija) ) {
						Kompozicija kompozicija = (Kompozicija)mapa[i][2];
						System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U for i if GDJE BI TREBAO UC" ); // DA UDJE - ZNACI PREPOZNA GA NA MAPI
						int k=0;
						//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
						for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
							String id = kompozicije.get(k).getID();
							System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
							if(id.equals(kompozicija.getID())) {
								if( ("A".equals(kompozicija.vratiStanicu(0))) && ("B".equals(kompozicija.vratiStanicu(1))) ) {
									return true;
								}
							}
							k++;
						}
					}
				}
				
		return false;
	}
	
	public boolean voziloProvjeriSmjerKompozicijeBA() {
		
		//dionica do pruznog prelaza do skretanja desno
		for(int i=19; i > 15; i-- ) {
			if( (mapa[i][2] instanceof Kompozicija)) {
				Kompozicija kompozicija = (Kompozicija)mapa[i][2];
				int k=0;
				//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
				for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
					String id = kompozicije.get(k).getID();
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
					if(id.equals(kompozicija.getID())) {
						System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
						if( (("A".equals(kompozicija.vratiStanicu(3))) && ("B".equals(kompozicija.vratiStanicu(2)))) || (("A".equals(kompozicija.vratiStanicu(2))) && ("B".equals(kompozicija.vratiStanicu(1)))) ||  (("A".equals(kompozicija.vratiStanicu(1))) && ("B".equals(kompozicija.vratiStanicu(0)))) ) {
							return true;
						}
					}
					k++;
				}
			}
		}
		
		//dionica kada skrene desno
		for(int j=3; j < 6; j++) {
			if( (mapa[16][j] instanceof Kompozicija) ) {
				Kompozicija kompozicija = (Kompozicija)mapa[16][j];
				int k=0;
				//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
				for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
					String id = kompozicije.get(k).getID();
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
					if(id.equals(kompozicija.getID())) {
						System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
						if( (("A".equals(kompozicija.vratiStanicu(3))) && ("B".equals(kompozicija.vratiStanicu(2)))) || (("A".equals(kompozicija.vratiStanicu(2))) && ("B".equals(kompozicija.vratiStanicu(1)))) ||  (("A".equals(kompozicija.vratiStanicu(1))) && ("B".equals(kompozicija.vratiStanicu(0))))) {
							return true;
						}
					}
					k++;
				}
			}
		}
		
		//dionica prema gore do B Stanice
		for(int i = 15; i > 5; i--) {
			if( (mapa[i][5] instanceof Kompozicija) ) {
				Kompozicija kompozicija = (Kompozicija)mapa[i][5];
				int k=0;
				//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
				for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
					String id = kompozicije.get(k).getID();
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
					if(id.equals(kompozicija.getID())) {
						System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
						if( (("A".equals(kompozicija.vratiStanicu(3))) && ("B".equals(kompozicija.vratiStanicu(2)))) || (("A".equals(kompozicija.vratiStanicu(2))) && ("B".equals(kompozicija.vratiStanicu(1)))) ) {
							return true;
						}
					}
					k++;
				}
			}
		}
		
		return false;		
		
	}
	
	public boolean voziloProvjeriSmjerKompozicijeBC() {
		
		// od stanice b do pruznog prelaza
		for(int j=8; j < 13; j++) {
			if((mapa[6][j] instanceof Kompozicija)) {
				Kompozicija kompozicija = (Kompozicija)mapa[6][j];
				int k=0;
				//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
				for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
					String id = kompozicije.get(k).getID();
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
					if(id.equals(kompozicija.getID())) {
						System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
						if( (("B".equals(kompozicija.vratiStanicu(1))) && ("C".equals(kompozicija.vratiStanicu(2)))) || (("B".equals(kompozicija.vratiStanicu(0))) && ("C".equals(kompozicija.vratiStanicu(1)))) ) {
							return true;
						}
					}
					k++;
				}
			}
		}
		
		return false;
	}
	
	public boolean voziloProvjeriSmjerKompozicijeCB() {
		
		//od pruznog prlaza 2 do skretanja prema dole
		for(int j=15;  j < 20; j++) {
			if((mapa[6][j] instanceof Kompozicija) ) {
				Kompozicija kompozicija = (Kompozicija)mapa[6][j];
				int k=0;
				//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
				for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
					String id = kompozicije.get(k).getID();
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
					if(id.equals(kompozicija.getID())) {
						System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
						if( (("C".equals(kompozicija.vratiStanicu(1))) && ("B".equals(kompozicija.vratiStanicu(2)))) || (("C".equals(kompozicija.vratiStanicu(0))) && ("B".equals(kompozicija.vratiStanicu(1)))) ) {
							return true;
						}
					}
					k++;
				}
			}
		}
		
		//dionica kada skrene prema dole pa do stanice C
		for(int i = 6; i < 12; i++) {
			if((mapa[i][19] instanceof Kompozicija) ) {
				Kompozicija kompozicija = (Kompozicija)mapa[i][19];
				int k=0;
				//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
				for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
					String id = kompozicije.get(k).getID();
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
					if(id.equals(kompozicija.getID())) {
						System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
						if( (("C".equals(kompozicija.vratiStanicu(1))) && ("B".equals(kompozicija.vratiStanicu(2)))) || (("C".equals(kompozicija.vratiStanicu(0))) && ("B".equals(kompozicija.vratiStanicu(1)))) ) {
							return true;
						}
					}
					k++;
				}
			}
		}
		
		return false;
		
	}
	
	public boolean voziloProvjeriSmjerKompozicijeCE() {
		// C = 0 E = 1 (ako je to jedina linija) C = 1 E = 2 (ako ima stanica prije npr B ili D) i C=2 E=3 (ako ide od A)//dionica kada ide od C prema dole
		for(int i=14; i < 19; i++) {
			if((mapa[i][20] instanceof Kompozicija)) {
				Kompozicija kompozicija = (Kompozicija)mapa[i][20];
				int k=0;
				//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
				for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
					String id = kompozicije.get(k).getID();
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
					if(id.equals(kompozicija.getID())) {
						System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
						if( (("C".equals(kompozicija.vratiStanicu(1))) && ("B".equals(kompozicija.vratiStanicu(2)))) || (("C".equals(kompozicija.vratiStanicu(0))) && ("B".equals(kompozicija.vratiStanicu(1)))) || (("C".equals(kompozicija.vratiStanicu(2))) && ("B".equals(kompozicija.vratiStanicu(3)))) ) {
							return true;
						}
					}
					k++;
				}
			}
			
		}
		
		//dionica puta kada skrene desno
		for(int j = 20; j < 27 ; j++) {
			if((mapa[18][j] instanceof Kompozicija)) {
				Kompozicija kompozicija = (Kompozicija)mapa[18][j];
				int k=0;
				//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
				for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
					String id = kompozicije.get(k).getID();
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
					if(id.equals(kompozicija.getID())) {
						System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
						if( (("C".equals(kompozicija.vratiStanicu(1))) && ("B".equals(kompozicija.vratiStanicu(2)))) || (("C".equals(kompozicija.vratiStanicu(0))) && ("B".equals(kompozicija.vratiStanicu(1)))) || (("C".equals(kompozicija.vratiStanicu(2))) && ("B".equals(kompozicija.vratiStanicu(3)))) ) {
							return true;
						}
					}
					k++;
				}
			}
		}
		
		//dionica puta prema dole do kruznog prelaza
		for(int i=18; i <20; i++) {
			if((mapa[i][26] instanceof Kompozicija)) {
				Kompozicija kompozicija = (Kompozicija)mapa[i][26];
				int k=0;
				//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
				for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
					String id = kompozicije.get(k).getID();
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
					if(id.equals(kompozicija.getID())) {
						System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
						if( (("C".equals(kompozicija.vratiStanicu(1))) && ("E".equals(kompozicija.vratiStanicu(2)))) || (("C".equals(kompozicija.vratiStanicu(0))) && ("E".equals(kompozicija.vratiStanicu(1)))) || (("C".equals(kompozicija.vratiStanicu(2))) && ("E".equals(kompozicija.vratiStanicu(3)))) ) {
							return true;
						}
					}
					k++;
				}
			}
		}
		
		return false;
	}
	
	public boolean voziloProvjeriSmjerKompozicijeEC() {
		//dionica od pruznog prelaza do stanice E
		for(int i=22; i < 25; i++) {
			if((mapa[i][26] instanceof Kompozicija)) {
				Kompozicija kompozicija = (Kompozicija)mapa[i][26];
				int k=0;
				//provjerava da li odredjena kompozicija ima isti smjer kao i ona koja treba da krene na prugu
				for(int brojac = 0 ; brojac < kompozicije.size(); brojac++) {
					String id = kompozicije.get(k).getID();
					System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI UDJE U WHILE KOD ITERATORA " );
					if(id.equals(kompozicija.getID())) {
						System.out.println("BREAK POINT PROVJERA DIONICE AB : DA LI SU ID JEDNAKI ? " + kompozicije.get(k).getID() + " " + kompozicija.getID());
						if( (("E".equals(kompozicija.vratiStanicu(0))) && ("C".equals(kompozicija.vratiStanicu(1))))) {
							return true;
						}
					}
					k++;
				}
			}
		}
		
		return false;
	}

	/**	Metode za kretanje vozila. */
	public boolean voziloProvjeriGore(int trenutnoI, int trenutnoJ) {
		//Gore mogu biti samo desne trake puta
		if( ("PU1D".equals(mapa[trenutnoI-1][trenutnoJ])) || ("PU2D".equals(mapa[trenutnoI-1][trenutnoJ])) || ("PU3D".equals(mapa[trenutnoI-1][trenutnoJ])) ) {
			return true;
		}
		return false;
	}
	
	public boolean voziloProvjeriDole(int trenutnoI, int trenutnoJ) {		
		//Dole mogu biti samo lijeve trake puta
		if( ("PU1L".equals(mapa[trenutnoI+1][trenutnoJ])) || ("PU2L".equals(mapa[trenutnoI+1][trenutnoJ])) || ("PU3L".equals(mapa[trenutnoI+1][trenutnoJ])) ) {
			return true;
		}
	return false;	
	}
	
	public boolean voziloProvjeriLijevo(int trenutnoI, int trenutnoJ) {
		
		if( ("PU1D".equals(mapa[trenutnoI][trenutnoJ-1])) || ("PU3L".equals(mapa[trenutnoI][trenutnoJ-1]))) {
			return true;
		}
		return false;
	}
	
	public boolean voziloProvjeriDesno(int trenutnoI, int trenutnoJ) {
		if( ("PU1L".equals(mapa[trenutnoI][trenutnoJ+1])) || ("PU3D".equals(mapa[trenutnoI][trenutnoJ+1]))) {
			return true;
		}
		return false;
	}
	
	public boolean voziloProvjeriDaLiJePruzniPrelaz(int trenutnoI, int trenutnoJ) {
		if(("PP1L".equals(mapa[trenutnoI][trenutnoJ+1])) || ("PP1D".equals(mapa[trenutnoI][trenutnoJ-1])) || ("PP2L".equals(mapa[trenutnoI+1][trenutnoJ])) || ("PP2D".equals(mapa[trenutnoI-1][trenutnoJ])) || ("PP3L".equals(mapa[trenutnoI][trenutnoJ-1])) || ("PP3D".equals(mapa[trenutnoI][trenutnoJ+1]))) {
			return true;
		}
		return false;
	}
	
	/**	Metoda za zauzimanje pozicije na mapi - vozilo.*/
	public synchronized void voziloZauzmiPoziciju(int i, int j, Vozilo vozilo) {
		/*System.out.println();
		System.out.println("BREAK POINT ZAUZMI POZICIJU - INDEKSI SU  " + i + " " + j);
		System.out.println();*/

		mapa[i][j] = vozilo;
	}
	
	/**	Metoda za 'oslobadjanje' pozicije na mapi - vozilo. */
	public synchronized void voziloOslobodiPozicijuLijevaTrakaPut1(int i, int j) {
		mapa[i][j] = "PP1L";
	}
	
	public synchronized void voziloOslobodiPozicijuLijevaTrakaPut2(int i, int j) {
		mapa[i][j] = "PP2L";
	}
	
	public synchronized void voziloOslobodiPozicijuLijevaTrakaPut3(int i, int j) {
		mapa[i][j] = "PP3L";
	}
	
	public synchronized void voziloOslobodiPozicijuDesnaTrakaPut1(int i, int j) {
		mapa[i][j] = "PP1D";
	}
	
	public synchronized void voziloOslobodiPozicijuDesnaTrakaPut2(int i, int j) {
		mapa[i][j] = "PP2D";
	}
	
	public synchronized void voziloOslobodiPozicijuDesnaTrakaPut3(int i, int j) {
		mapa[i][j] = "PP3D";
	}
}

