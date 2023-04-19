import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class OyunGorunumu {
	private OyunVerisi oyunVerisi; //bu referans ile yarat�lacak nesne sayesinde karakterlerin bilgilerine erisilecek.
	private SavasMotoru savasMotoru;  //bnesne uretip olay� buna devret  
	private Sans sans;
	int menuSecimi;
	Scanner input;
	int sovalyeNo;
	int dusmanNo;
	ArrayList<Sovalye> aktifsovalyeler ;
	ArrayList<Dusman> aktifdusmanlar ;
	ArrayList<Sovalye> sovalyeler;
	ArrayList<Dusman> dusmanlar;
	
	final int a=20;
	public OyunGorunumu () throws IOException{
	    input=new Scanner(System.in);
		oyunVerisi=new OyunVerisi();
		sans =new Sans();
		aktifsovalyeler=oyunVerisi.getAktifSovalyeler();
		aktifdusmanlar=oyunVerisi.getAktifDusmanlar();
		sovalyeler=oyunVerisi.getSovalyeler();
		dusmanlar=oyunVerisi.getDusmanlar();
		savasMotoru=new SavasMotoru(aktifsovalyeler,aktifdusmanlar);
		
	}
	
	public void baslangicEkrani() {   //giri�
		for(int i=0;i<a;i++) {
			System.out.print("*");
		}
		System.out.println("\n Oyuna Hos Geldiniz");
		for(int i=0;i<a;i++) {
			System.out.print("*");
		}
		System.out.println();
	}
	public void anaMenuyuGoster() {  //bilgileri kullan�c�ya sun
		System.out.println("ANA MEN�\r\n"
				+ "1. T�m ��valyeleri g�ster\r\n"
				+ "2. Aktif olan ��valyeleri g�ster\r\n"
				+ "3. Ad� girilen ��valye bilgilerini g�ster\r\n"
				+ "4. Ad� girilen ��valyeyi de�i�tir\r\n"
				+ "5. Yard�m\r\n"
				+ "6. Oyunu ba�lat\r\n"
				+ "7. Oyundan ��k\r\n"
				+ "L�tfen se�iminizi yap�n�z: ");
		
	}
	public void yardim() {  //yard�m secenegi
		System.out.println("Oyun ile ilgili bilgilere ineternet sitemizden ulasabilirsiniz.");
	}
	
	public void sovalyeleriGoster() {   //tum sovalyeleri gosterir.aktif olsun olmas�n.Sovalye havucunu gosterir
		for(int i=0;i<sovalyeler.size();i++) {
			System.out.println((i+1)+"*******************\r\n"
					+ "Sovalye ad�:"+sovalyeler.get(i).getAd()+"\r\n"
					+ "sovalye Tipi:"+sovalyeler.get(i).getsovalyeTipi()+"\r\n"
					+ "Sovalye id:"+sovalyeler.get(i).getId()+"\r\n"
					+ "Sovalye vurus hakki"+sovalyeler.get(i).getVurusHakki()+"\r\n"
					+"*******************\r\n");
		}
	}
	public void aktifSovalyeleriGoster() {//aktif sovalye havuzunu gosterir 
		for(int i=0;i<aktifsovalyeler.size();i++) {
			System.out.println((i+1)+"*******************\r\n"
					+ "Sovalye ad�:"+aktifsovalyeler.get(i).getAd()+"\r\n"
					+ "sovalye Tipi:"+aktifsovalyeler.get(i).getsovalyeTipi()+"\r\n"
					+ "Sovalye id:"+aktifsovalyeler.get(i).getId()+"\r\n"
					+ "Sovalye vurus hakki:  "+aktifsovalyeler.get(i).getVurusHakki()+"\r\n"
					+"*******************\r\n");
		}
	}
	public void menudenSecimYap() {
		Scanner input =new Scanner(System.in);
		int cevap=input.nextInt();
		
		 if(cevap==1)
			 sovalyeleriGoster();
		 else if(cevap==2)
			 aktifSovalyeleriGoster();
		 else if(cevap==3) {
			 System.out.println("Bilgilerini gormek isteginiz sovalyenin adini giriniz :");
			 sovalyeyiGoster(input.next());}
		 else if(cevap==4) {
			 String ad;
			 String yeniAd;
			 int yeniid;
			 String tip;
			
			 System.out.println("Degistirmek istedi�iniz sovalyenin adini giriniz:");
			 ad=input.next(); 
			 System.out.println("Sovalyenin yeni adini giriniz:");
			 yeniAd=input.next(); 
			 System.out.println("Sovalyenin id'sini giriniz");
			 yeniid=input.nextInt();
			 System.out.println("Sovalyenin tipini girniz:");
			 tip=input.next();
			 sovalyeyiDegistir(ad,yeniAd,yeniid,tip);
		 }
		 else if(cevap==5)
			 yardim();
		 else if(cevap==6) { // bu metod oyunu baslatir aktiferi gosteri
			 System.out.println("Oyun Basladi");
			 System.out.println("Oyunun Karakterleri:");
			 System.out.println("********************");
			 System.out.println("********************");
			 System.out.println("SOVALYELER VE DUSMANLAR ")	;
			 System.out.println("********************");
			 oyunDurumunuGoster();  //aktifleri gosteriri
			 sovalyeSayisi();//sovalye sayisi arttirilacak mi 
			 sansata();//sans atama yapildi 
			 oyundevammi();//
			 
			 
		 }
		 else 
			 
			 oyundanCik();
			 
	}
	
	public void  sovalyeyiGoster(String ad) {  //uygun se�enek durumunda adi girilen sovalye bilgileri gosterir.
		for(int i=0;i<sovalyeler.size();i++) {
			if(sovalyeler.get(i).getAd().equals(ad))//hangi sovalye gosterilecek 
				System.out.println(
						 "Sovalye ad�:"+sovalyeler.get(i).getAd()+"\r\n"
						+ "sovalye Tipi:"+sovalyeler.get(i).getsovalyeTipi()+"\r\n"
						+ "Sovalye id:"+sovalyeler.get(i).getId()+"\r\n"
						+ "Sovalye vurus hakki:  "+sovalyeler.get(i).getVurusHakki()+"\r\n"
						+"*******************\r\n");

		}
	}
	
	public void  sovalyeyiDegistir(String ad,String yeniAd,int yeniid,String tip)//uygn cevap halinde sovalyeyi degistirir.
 {
		for(int i=0;i<sovalyeler.size();i++) {
			if(sovalyeler.get(i).getAd().equals(ad)) {//hangi sovalye degistirlecek
						sovalyeler.get(i).setAd(yeniAd);
						sovalyeler.get(i).setsovalyeTipi(tip);
						sovalyeler.get(i).setId(yeniid);}
		}	
		
	}
	
	public void  oyunDurumunuGoster() {   //arraylistin guncel halini gosterir
		for(int i=0;i<aktifsovalyeler.size();i++) {
			System.out.println((i)+"*******************\r\n"
					+ "Sovalye ad�:"+aktifsovalyeler.get(i).getAd()+"\r\n"
					+ "sovalye Tipi:"+aktifsovalyeler.get(i).getsovalyeTipi()+"\r\n"
					+ "Sovalye id:"+aktifsovalyeler.get(i).getId()+"\r\n"
					+ "Sovalye vurus hakki:  "+aktifsovalyeler.get(i).getVurusHakki()+"\r\n"
					+"*******************\r\n");
		}
		for(int i=0;i<aktifdusmanlar.size();i++) {
			System.out.println((i)+"*******************\r\n"
					+ "Dusman ad�:"+aktifdusmanlar.get(i).getAd()+"\r\n"
					+"*******************\r\n");
		}
	}
	public void  sovalyeSayisi() {//eger guclusayisi1 == 2 ise sovalyesayisi arttir metodu �agrilir.
		if(oyunVerisi.guclusayisi1==2)
			savasMotoru.sovalyesayisiarttir();
	}
	public void oyundanCik() {//oyun ba�latmadan bitiren metod
		System.out.println("Oyun sonland�r�ld�");
		System.exit(1);
		
	}
	public void sansata() { //sovalyeleri sans class�ndaki sansAta metoduna gonderir. 
		for(int i=0;i<aktifsovalyeler.size();i++) {
			sans.sansAta(aktifsovalyeler.get(i));
		}
	}
	
	public void sovalyelerguncelle() {  //vurus hakki biten sovalyeleri siler 
		for(int i=0;i<aktifsovalyeler.size();i++) {
			if(aktifsovalyeler.get(i).getVurusHakki()<=0) {
				aktifsovalyeler.remove(i);
			}
		}
	}
	public void oyundevammi() {//as�l oyun
		oyunDurumunuGoster();//her hamle bas�nda oncelikle aktif karakterler gosterilecek 
		if(aktifdusmanlar.size()!=0) {  //eger dusman varsa  calis
			if(aktifsovalyeler.size()<aktifdusmanlar.size()) {//aktif sovalyelerin daha az kaybeettin
				{
				savasMotoru.oyunBitir(-1);//kaybettin
				
				}
			}
			else {//devam ediyor  ,aktif sovalyelern fazla savasa devam .savas bitince de guncelleme yap.bir daha cagir
				 System.out.println("Kullanacaginiz sovalyenin numaras�n� giriniz ");
				 sovalyeNo=input.nextInt();	
				 	
				 System.out.println("Kullanacaginiz dusmanin numaras�n� giriniz ");
				 dusmanNo=input.nextInt();
				 savasMotoru.sovalyesavastir(sovalyeNo, dusmanNo);
				 sovalyelerguncelle(); //vurus hakki biten sovalyeler silinsin 
				 oyundevammi();//�z yineleme tekni�iyle mtod tekrar kendini �a��r�r.
			}
		}
		else 
			savasMotoru.oyunBitir(1);//kazand�n
	}
		
	}
	

