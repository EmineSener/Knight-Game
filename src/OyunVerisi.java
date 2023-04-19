//cagrilmasina gerek yok oyungorunu cagiriyor  
import java.util.ArrayList;
 import java.util.Random;
public class OyunVerisi {
	public int guclusayisi1; //sovalyelerden kaci guclu;eger birden fazlayasa kullanýcý bir guvluyu iki zayif yapabilir.Bu degisekn kac tane oldugunu bulamamiza yarayack.
	ArrayList<Sovalye> sovalyeler = new ArrayList<>();  //henuz aktif olmayan,oyun baslatilinca aktiflenecek  sovalyeler
	ArrayList<Sovalye> aktifsovalyeler = new ArrayList<>();
	ArrayList<Dusman> dusmanlar = new ArrayList<>();
	ArrayList<Dusman> aktifdusmanlar = new ArrayList<>();

	OyunVerisi(){    
		for(int i=0;i<5;i++) {     //5 tane guclu sovalye yaratýldý  
			sovalyeler.add(new Guclusovalye ("S"+i,i));
			sovalyeler.get(i).setsovalyeTipiGuclu();
		}
		for(int i=5;i<10;i++) {//5 tane zayýf sovalye yaratýldý 
			sovalyeler.add(new ZayifSovalyee("S"+i,i));
			sovalyeler.get(i).setsovalyeTipiZayif();
		}
		
		//dusmanlarý yaratmak 
		for(int i=0;i<5;i++) {     //5 tane guclu dusman yaratýldý  
			dusmanlar.add(new GucluDusman("D"+i,i));
			dusmanlar.get(i).setdusmanTipiGuclu();
		}
		for(int i=5;i<10;i++) {//5 tane zayýf dusman yaratýldý 
			dusmanlar.add(new ZayifDusman("D"+i,i));
			dusmanlar.get(i).setdusmanTipiZayif();      //sovalyelere tip burda atanýr 
		}
	 
		Random random=new Random();
		  //guclu sayisi 1 yada 2 burda karar verilir 
		int b=random.nextInt(4);
		if(b%2==0)//random uretilen sayinin tek/cift olmasýna gore 1 ya da 2 guclu sovalye olacak.
			guclusayisi1=2;
		else 
			guclusayisi1=1;
		for(int i=0;i<guclusayisi1;i++) {   //guclu sovalyelerim ilk 5 te oldugundan 5 sayýsýna dek sayi urettim guclu sayisi kadar 
			int k=random.nextInt(5);
			aktifsovalyeler.add(sovalyeler.get(k));  //guclusayisis kadar sovalye 5 sayýsna kadar uretien sayikardan birinde bulunan sovalyeler listesinden;aktiflere kopyalandý
			
		}
		
		for(int i=0;i<(5-guclusayisi1);i++) { // sovalye sayisi - guclu sayisi zayif sayisini verir zayiflar 5. index ten baslar 
			int l=random.nextInt(5)+5;
			aktifsovalyeler.add(sovalyeler.get(l));
			

		}
		    int dusmansayisi=random.nextInt(3)+3; //en az 3 dusman en fazla 5 dusman sayisi uretir 
		    
			int guclusayisi2;
			int a=random.nextInt();   //ayný rastgelelik teknigiyle guclu sayisi 1 yada 2 olarak belirlenir
			if(a%2==0)
				guclusayisi2=2;
			else 
				guclusayisi2=1;
			
			for(int i=0;i<guclusayisi2;i++) {
				int c=random.nextInt(5);
				aktifdusmanlar.add(dusmanlar.get(c));  //gucludusman ata
				
			}
			
			for(int i=0;i<(dusmansayisi-guclusayisi2);i++) {//kalan dusmanlar zayiflarla dolduruldu 
				int d=random.nextInt(5)+5;
				aktifdusmanlar.add(dusmanlar.get(d));
				

			}
	}
			//metodlar 
				ArrayList<Sovalye> getSovalyeler() {
					
					return sovalyeler;
				}
				ArrayList<Dusman> getDusmanlar() {
								
								return dusmanlar;
							}
				
				ArrayList<Dusman> getAktifDusmanlar() {
					
					return aktifdusmanlar;
				}
				
				ArrayList<Sovalye> getAktifSovalyeler() {
								
								return aktifsovalyeler;
							}
				
				Sovalye getSovalye(String ad) {
					for(int i=0;i<10;i++) {
						if(sovalyeler.get(i).getAd().equals(ad))
							return sovalyeler.get(i);
					}
					 
						return sovalyeler.get(0);   
				}
}
