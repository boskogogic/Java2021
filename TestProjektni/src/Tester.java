import java.util.ArrayList;

/**	Metoda za testiranje tredova i funkcionalnosti sistema. */
public class Tester {
	
	public static void main(String[] args) {
		Object[][] mapa1 = new Object[30][30];
		Mapa mapa = new Mapa(mapa1);
		mapa.postaviStanice();
		mapa.postaviDionicuAB();
		mapa.postaviPutP1();
		mapa.postaviPutP2();
		mapa.postaviPutP3();
		
		Lokomotiva lokomotiva1 = new Lokomotiva("putnicka", "parna","100W","L1TEST");
		Lokomotiva lokomotiva2 = new Lokomotiva("putnicka", "parna", "100W", "L2TEST");
		
		VagonRestoran vagonRestoran1 = new VagonRestoran("10M", "VR1TEST", "Vagon restoran da se okrijepite dobrim picem!");
		VagonPutnicki vagonPutnicki1 = new VagonPutnicki("15M", "VP1TEST", 20);
		VagonPutnicki vagonPutnicki2 = new VagonPutnicki("15M", "VP2TEST",20);
		
		Kompozicija kompozicijaTest = new Kompozicija(mapa.getMapa());
		
		String[] stanice = { "A", "B" };
		String[] staniceSuprotno = { "B", "A" };
 		
		Lokomotiva lokomotiva3 = new Lokomotiva("teretna", "parna","100W","L3TEST");
		Lokomotiva lokomotiva4 = new Lokomotiva("univerzalna", "parna", "100W", "L4TEST");
		
		VagonRestoran vagonRestoran2 = new VagonRestoran("10M", "VR2TEST", "Vagon restoran da se okrijepite dobrim picem!");
		VagonPutnicki vagonPutnicki3 = new VagonPutnicki("15M", "VP3TEST", 20);
		
		Kompozicija kompozicijaTest2 = new Kompozicija(mapa.getMapa());
		
		Lokomotiva lokomotiva5 = new Lokomotiva("teretna", "parna","100W","L4TEST");
		VagonRestoran vagonRestoran3 = new VagonRestoran("10M", "VR2TEST", "Vagon restoran da se okrijepite dobrim picem!");
		VagonPutnicki vagonPutnicki4 = new VagonPutnicki("15M", "VP3TEST", 20);
		
		Kompozicija kompozicijaTest3 = new Kompozicija(mapa.getMapa());

		Lokomotiva lokomotiva6 = new Lokomotiva("teretna", "parna", "100W" , "L5BATEST");
		VagonRestoran vagonRestoran4 = new VagonRestoran("10M", "VR2TEST", "Vagon restoran da se okrijepite dobrim picem!");
		VagonPutnicki vagonPutnicki5 = new VagonPutnicki("15M", "VP3TEST", 20);
		
		Kompozicija kompozicijaTestBA = new Kompozicija(mapa.getMapa());
		
		//	public Automobil(String marka, String model, int godiste, int brojVrata) {
		Automobil automobil = new Automobil("AUDI", "Q8", 2020, 5);
		automobil.setMapa(mapa.getMapa());
		
		
		ArrayList<Kompozicija> kompozicije = new ArrayList<Kompozicija>();
		kompozicije.add(kompozicijaTest);
		kompozicije.add(kompozicijaTest2);
		kompozicije.add(kompozicijaTest3);
		//kompozicije.add(kompozicijaTestBA);
		
		
		//mapa.ispisiDionicuAB();
		boolean provjera;
		provjera = mapa.provjeriDionicuAB();
		System.out.println("PROVJERA JE : " +  mapa.provjeriDionicuAB());
		System.out.println("PROVJERA U MAINU KOMPOZICIJA 2 JE " + kompozicijaTest.provjeriDionicuAB());

		mapa.postaviStanice();
		mapa.postaviDionicuAB();
		System.out.println("BREAK POINT MAIN MAPA: " + mapa.provjeriPolje(27, 2));
		kompozicijaTest.dodajLokomotivu(lokomotiva1);
		kompozicijaTest.dodajLokomotivu(lokomotiva2);
		kompozicijaTest.dodajVagonPutnicki(vagonPutnicki1);
		kompozicijaTest.dodajVagonPutnicki(vagonPutnicki2);
		kompozicijaTest.dodajVagonRestoran(vagonRestoran1);
		kompozicijaTest.setStanice(stanice);
		kompozicijaTest.setBrojLokomotiva(2);
		kompozicijaTest.setBrojVagona(3);
		kompozicijaTest.postaviStanice();
		kompozicijaTest.setId("KOM1");//nisam imao ID uopste
		
		kompozicijaTest2.dodajLokomotivu(lokomotiva3);
		kompozicijaTest2.dodajLokomotivu(lokomotiva4);
		kompozicijaTest2.dodajVagonRestoran(vagonRestoran2);
		kompozicijaTest2.dodajVagonPutnicki(vagonPutnicki3);
		kompozicijaTest2.setStanice(stanice);
		kompozicijaTest2.setBrojLokomotiva(2);
		kompozicijaTest2.setBrojVagona(2);
		kompozicijaTest2.postaviStanice();
		kompozicijaTest2.setId("KOM2");
		
		kompozicijaTest3.dodajLokomotivu(lokomotiva5);
		kompozicijaTest3.dodajVagonRestoran(vagonRestoran3);
		kompozicijaTest3.dodajVagonPutnicki(vagonPutnicki4);
		kompozicijaTest3.setStanice(stanice);
		kompozicijaTest3.setBrojLokomotiva(1);
		kompozicijaTest3.setBrojVagona(2);
		kompozicijaTest3.postaviStanice();
		kompozicijaTest3.setId("KOM3");
		
		kompozicijaTestBA.dodajLokomotivu(lokomotiva6);
		kompozicijaTestBA.dodajVagonRestoran(vagonRestoran4);
		kompozicijaTestBA.dodajVagonPutnicki(vagonPutnicki5);
		kompozicijaTestBA.setStanice(staniceSuprotno);
		kompozicijaTestBA.setBrojLokomotiva(1);
		kompozicijaTestBA.setBrojVagona(2);
		kompozicijaTestBA.postaviStanice();
		kompozicijaTestBA.setId("KOM4BA");
		
		
		mapa.dodajUKolekciju(kompozicijaTest);
		mapa.dodajUKolekciju(kompozicijaTest2);
		mapa.dodajUKolekciju(kompozicijaTest3);
		//mapa.dodajUKolekciju(kompozicijaTestBA);
		mapa.provjeraIteratora();
		
		
		
		kompozicijaTest.setMapa(mapa.getMapa());//apdejtuj novu mapu
		kompozicijaTest.setKompozicije(kompozicije);
		kompozicijaTest2.setMapa(mapa.getMapa());//apdejtuj novu mapu
		kompozicijaTest2.setKompozicije(kompozicije);
		kompozicijaTest3.setMapa(mapa.getMapa());
		kompozicijaTest3.setKompozicije(kompozicije);
		/*kompozicijaTestBA.setMapa(mapa.getMapa());
		kompozicijaTestBA.setKompozicije(kompozicije);*/
		
		kompozicijaTest.postaviMapu(mapa);
		kompozicijaTest2.postaviMapu(mapa);
		kompozicijaTest3.postaviMapu(mapa);
		kompozicijaTestBA.postaviMapu(mapa);
		
		int brojac = 0;
		while(brojac < kompozicije.size()) {
			System.out.println(" KOMPOZICIJE : " + kompozicije.get(brojac).getID());
			brojac++;
		}
		
		//mapa.sinhronizuj();
		System.out.println("BREAK POINT MAIN - PROVJERA KOMPOZICIJA ID 1 : " + mapa.provjeriKompozicijeID(kompozicijaTest));
		System.out.println("BREAK POINT MAIN - PROVJERA KOMPOZICIJA ID 2 : " + mapa.provjeriKompozicijeID(kompozicijaTest2));
		System.out.println("PROVJERA U MAINU KOMPOZICIJA JE " + kompozicijaTest.provjeriDionicuAB());
		System.out.println("Je l se desava nesto?");
		
		System.out.println("BREAK POINT U MAINU PROVJERA SMJERA 0 : " + kompozicijaTest.provjeriSmjerAB());
		System.out.println("BREAK POINT U MAINU PROVJERA SMJERA 1 : " + kompozicijaTest2.provjeriSmjerAB());
		System.out.println("BREAK POINT U MAINU PROVJERA SMJERA 2 : " + kompozicijaTest3.provjeriSmjerAB());
		
		/*kompozicijaTest.start();
		kompozicijaTest2.start();
		boolean provjera2 = ( kompozicijaTest2.provjeriDionicuAB()) ;
		kompozicijaTest3.start();
		automobil.start();*/
		int pomocna = 0;
		int pomocneSekunde = 0;
		/*	 radi malo usporeno ALI RADI ipak */
		for(int i=0; i < kompozicije.size(); i++) {
			for(int j=i+1; j < kompozicije.size(); j++) {
				if( (kompozicije.get(i).vratiStanicu(0).equals(kompozicije.get(j).vratiStanicu(0))) && (kompozicije.get(i).vratiStanicu(1).equals(kompozicije.get(j).vratiStanicu(1))) ) {					try{
						kompozicije.get(j).sleep(1500 /*+ pomocneSekunde*/);
						
						System.out.println("Uspavala se kompozicija " + kompozicije.get(j).getID());
						System.out.println("Koliko puta se prodje kroz j petlju: " + j);
						pomocneSekunde+= 3000;
					}catch(Exception e) {
						System.out.println("BILO STA");
					}
				}
			}
			kompozicije.get(i).start();
			System.out.println("Pokrenula se kompozicija " + kompozicije.get(i).getID());
			System.out.println("Koliko puta se prodje kroz i petlju: " + i);

		}

		//kompozicijaTestBA.start();

	
		//mapa.ispisiDionicuAB();
	}

}
