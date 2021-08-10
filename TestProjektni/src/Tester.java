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
		
		Lokomotiva lokomotiva1 = new Lokomotiva("putnicka", "parna","100W","L11TEST");
		Lokomotiva lokomotiva2 = new Lokomotiva("putnicka", "parna", "100W", "L12TEST");
		VagonRestoran vagonRestoran1 = new VagonRestoran("10M", "VR1TEST", "Vagon restoran da se okrijepite dobrim picem!");
		VagonPutnicki vagonPutnicki1 = new VagonPutnicki("15M", "VP1TEST", 20);
		VagonPutnicki vagonPutnicki2 = new VagonPutnicki("15M", "VP2TEST",20);
		
		Kompozicija kompozicijaTest = new Kompozicija(mapa.getMapa());
		
		String[] stanice = { "A", "B" };
		String[] staniceSuprotno = { "B", "A" };
 		
		Lokomotiva lokomotiva3 = new Lokomotiva("teretna", "parna","100W","L21TEST");
		Lokomotiva lokomotiva4 = new Lokomotiva("univerzalna", "parna", "100W", "L22TEST");
		VagonRestoran vagonRestoran2 = new VagonRestoran("10M", "VR2TEST", "Vagon restoran da se okrijepite dobrim picem!");
		VagonPutnicki vagonPutnicki3 = new VagonPutnicki("15M", "VP3TEST", 20);
		
		Kompozicija kompozicijaTest2 = new Kompozicija(mapa.getMapa());
		
		
		Lokomotiva lokomotiva5 = new Lokomotiva("teretna", "parna","100W","L3TEST");
		VagonRestoran vagonRestoran3 = new VagonRestoran("10M", "VR2TEST", "Vagon restoran da se okrijepite dobrim picem!");
		VagonPutnicki vagonPutnicki4 = new VagonPutnicki("15M", "VP3TEST", 20);
		
		Kompozicija kompozicijaTest3 = new Kompozicija(mapa.getMapa());

		
		Lokomotiva lokomotiva6 = new Lokomotiva("teretna", "parna", "100W" , "L4BATEST");
		VagonRestoran vagonRestoran4 = new VagonRestoran("10M", "VR2TEST", "Vagon restoran da se okrijepite dobrim picem!");
		VagonPutnicki vagonPutnicki5 = new VagonPutnicki("15M", "VP3TEST", 20);
		
		Kompozicija kompozicijaTestBA = new Kompozicija(mapa.getMapa());
		
		
		//	public Automobil(String marka, String model, int godiste, int brojVrata) {
		Automobil automobil = new Automobil("AUDI", "Q8", 2020, 5/*, mapa.getMapa()*/);
		
		Kamion kamion = new Kamion("MERCEDES", "SLEPER", 2019, 300);
		
		
		ArrayList<Kompozicija> kompozicije = new ArrayList<Kompozicija>();
		kompozicije.add(kompozicijaTest);
		kompozicije.add(kompozicijaTest2);
		kompozicije.add(kompozicijaTest3);
		kompozicije.add(kompozicijaTestBA);

		
		//mapa.ispisiDionicuAB();
		boolean provjera;
		provjera = mapa.provjeriDionicuAB();
		System.out.println("PROVJERA JE : " +  mapa.provjeriDionicuAB());
		System.out.println("PROVJERA U MAINU KOMPOZICIJA 2 JE " + kompozicijaTest.provjeriDionicuAB());

		mapa.postaviStanice();
		mapa.postaviDionicuAB();
		
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
		kompozicijaTest.setBrojKompozicije(0);
		
		kompozicijaTest2.dodajLokomotivu(lokomotiva3);
		kompozicijaTest2.dodajLokomotivu(lokomotiva4);
		kompozicijaTest2.dodajVagonRestoran(vagonRestoran2);
		kompozicijaTest2.dodajVagonPutnicki(vagonPutnicki3);
		kompozicijaTest2.setStanice(stanice);
		kompozicijaTest2.setBrojLokomotiva(2);
		kompozicijaTest2.setBrojVagona(2);
		kompozicijaTest2.postaviStanice();
		kompozicijaTest2.setId("KOM2");
		kompozicijaTest2.setBrojKompozicije(1);

		
		kompozicijaTest3.dodajLokomotivu(lokomotiva5);
		kompozicijaTest3.dodajVagonRestoran(vagonRestoran3);
		kompozicijaTest3.dodajVagonPutnicki(vagonPutnicki4);
		kompozicijaTest3.setStanice(stanice);
		kompozicijaTest3.setBrojLokomotiva(1);
		kompozicijaTest3.setBrojVagona(2);
		kompozicijaTest3.postaviStanice();
		kompozicijaTest3.setId("KOM3");
		kompozicijaTest3.setBrojKompozicije(2);

		
		kompozicijaTestBA.dodajLokomotivu(lokomotiva6);
		kompozicijaTestBA.dodajVagonRestoran(vagonRestoran4);
		kompozicijaTestBA.dodajVagonPutnicki(vagonPutnicki5);
		kompozicijaTestBA.setStanice(staniceSuprotno);
		kompozicijaTestBA.setBrojLokomotiva(1);
		kompozicijaTestBA.setBrojVagona(2);
		kompozicijaTestBA.postaviStanice();
		kompozicijaTestBA.setId("KOM4BA");
		kompozicijaTestBA.setBrojKompozicije(3);

		//mapa.dodajUKolekciju(kompozicijaTest2);
		//mapa.dodajUKolekciju(kompozicijaTest3);
		//mapa.dodajUKolekciju(kompozicijaTestBA);
		
		//mapa.setKompozicije(kompozicije);
		//for(int i = 0 ; i < mapa.kompozicije.size(); i++) {
		//	System.out.println("Kompozicije su : " + mapa.kompozicije.get(i).getID());
		//}
		
		
		kompozicijaTest.setMapa(mapa.getMapa());//apdejtuj novu mapu
		kompozicijaTest.setKompozicije(kompozicije);
		kompozicijaTest2.setMapa(mapa.getMapa());//apdejtuj novu mapu
		kompozicijaTest2.setKompozicije(kompozicije);
		kompozicijaTest3.setMapa(mapa.getMapa());
		kompozicijaTest3.setKompozicije(kompozicije);
		kompozicijaTestBA.setMapa(mapa.getMapa());
		kompozicijaTestBA.setKompozicije(kompozicije);
		
		kompozicijaTest.postaviMapu(mapa);
		kompozicijaTest2.postaviMapu(mapa);
		kompozicijaTest3.postaviMapu(mapa);
		kompozicijaTestBA.postaviMapu(mapa);
		
		mapa.dodajUKolekciju(kompozicijaTest);
		mapa.dodajUKolekciju(kompozicijaTest2);
		mapa.dodajUKolekciju(kompozicijaTest3);

		boolean okidac = true;
		int brojac = 0;
		
		/*prebrojavanje 
		 * while(okidac) {
		
			if(mapa.pristupiKompoziciji(brojac) == null) {
				okidac=false;

			}else {
				System.out.println(" KOMPOZICIJE : " + mapa.pristupiKompoziciji(brojac).getID());

			}
			brojac++;
		
		}
		*/
		
		System.out.println("BROJ KOMPOZICIJA U MAPI JE : " + mapa.getBrojKompozicija());
		//mapa.sinhronizuj();
		System.out.println("BREAK POINT MAIN - PROVJERA KOMPOZICIJA ID 1 : " + mapa.provjeriKompozicijeID(kompozicijaTest));
		System.out.println("BREAK POINT MAIN - PROVJERA KOMPOZICIJA ID 2 : " + mapa.provjeriKompozicijeID(kompozicijaTest2));
		System.out.println("PROVJERA DA LI IMA NEKO NA DIONICU - U MAINU KOMPOZICIJA JE (true = nema) " + kompozicijaTest.provjeriDionicuAB());
		
		System.out.println("BREAK POINT U MAINU PROVJERA SMJERA 0 : " + kompozicijaTest.provjeriSmjerAB());
		System.out.println("BREAK POINT U MAINU PROVJERA SMJERA 1 : " + kompozicijaTest2.provjeriSmjerAB());
		System.out.println("BREAK POINT U MAINU PROVJERA SMJERA 2 : " + kompozicijaTest3.provjeriSmjerAB());
		
		Vozilo v = new Vozilo("AUDI", "Q8", 2020/*, mapa.getMapa()*/);//prije je bilo inicijalizovano prije nego sto se sve dodavalo u mapi
		v.setMapa(mapa.getMapa());
		v.postaviMapu(mapa);
		v.setKompozicije(kompozicije);
		
		Vozilo v2 = new Vozilo("MERCEDES", "E KLASA", 2020);
		v2.setMapa(mapa.getMapa());
		v2.postaviMapu(mapa);
		
		
		kamion.setMapa(mapa.getMapa());
		kamion.postaviMapu(mapa);
		kamion.setKompozicije(kompozicije);
		
		/*automobil.setMapa(mapa.getMapa());
		automobil.postaviMapu(mapa);
		automobil.setKompozicije(kompozicije);*/
		
		/* Provjera za vozilo - kad se postavi nesto drugo na pruzni prelaz
		 * VOZILO - prolazi

		mapa.postaviPolje(21, 2, kompozicijaTest);
		mapa.postaviPolje(20, 2, kompozicijaTest);
		
		System.out.println("STA je na datom polju ? " + mapa.vratiVrijednostPolja(21, 2));
		System.out.println("Sta je na datom polju 2 ? " + mapa.vratiVrijednostPolja(20, 2));
		
		System.out.println("Sta je na datom polju ? " + automobil.vratiPolje(21,2));
		System.out.println("Sta je na datom polju 2 ? " + automobil.vratiPolje(20,2));*/



		
		/*kompozicijaTest.start();
		kompozicijaTest2.start();
		boolean provjera2 = ( kompozicijaTest2.provjeriDionicuAB()) ;
		kompozicijaTest3.start();
		;*/
		int pomocna = 0;
		int pomocneSekunde = 0;
		
		System.out.println("DA li je istina da KOM1 i KOM2 imaju iste stanice : " + ( (kompozicije.get(1).vratiStanicu(0).equals(kompozicije.get(2).vratiStanicu(0))) && (kompozicije.get(1).vratiStanicu(1).equals(kompozicije.get(2).vratiStanicu(1)))) );			
		System.out.println("Duzina kolekcije kompozicije: " + kompozicije.size());
		System.out.println("ZAVRSETAK TEST ISPISA U MAIN-U");
		System.out.println("________________________________________________");
		/*	 radi malo usporeno ALI RADI ipak */
		/*for(int i=0; i < kompozicije.size() + 1; i++) {
			for(int j=i+1; j < kompozicije.size(); j++) {
				if( (kompozicije.get(i).vratiStanicu(0).equals(kompozicije.get(j).vratiStanicu(0))) && (kompozicije.get(i).vratiStanicu(1).equals(kompozicije.get(j).vratiStanicu(1))) ) {			
					try{
						kompozicije.get(j).sleep(2500 + pomocneSekunde);
						
						System.out.println("Uspavala se kompozicija " + kompozicije.get(j).getID() + " " + ((double)(pomocneSekunde + 2500)/1000) + " sekundi");
						System.out.println("Koliko puta se prodje kroz j petlju: " + j);
						pomocneSekunde+= 3000;
					}catch(Exception e) {
						System.out.println("BILO STA");
					}
				}
			}
			kompozicije.get(i).start();
			System.out.println("Pokrenula se kompozicija " + kompozicije.get(i).getID());
			System.out.println("Koliko puta se prodje kroz i petlju: " + (i+1));

		}*/

		/*kompozicijaTest.start();
		kompozicijaTest2.start();
		kompozicijaTest3.start();
		kompozicijaTestBA.start();*/
		mapa.dodajUKolekcijuVozilo(v);
		mapa.dodajUKolekcijuVozilo(kamion);
		mapa.dodajUKolekcijuVozilo(v2);
		
		//zaustavi kretanje kompozicija i isprobavaj auta
		/*mapa.pristupiKompoziciji(kompozicijaTest.getBrojKompozicije()).start();
		mapa.pristupiKompoziciji(kompozicijaTest2.getBrojKompozicije()).start();
		mapa.pristupiKompoziciji(kompozicijaTest3.getBrojKompozicije()).start();*/

		//automobil.start();
		mapa.pristupiVozilu(0).start();
		mapa.pristupiVozilu(1).start();
		mapa.pristupiVozilu(2).start();
	
		//mapa.ispisiDionicuAB();
	}

}
