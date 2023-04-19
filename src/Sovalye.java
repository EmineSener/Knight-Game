
public class Sovalye extends Karakterler{
	private boolean  durum;
	private int vurusHakki;
	private String sovalyeTipi;
	
	Sovalye(){
		
	}
	Sovalye(String ad,int id){  //miras alinan get ve set metodlariyla atadan alinan degiskenler doldurulacak
		setAd(ad);
		setId(id);
		vurusHakki=1;   // sovalye hamle yaptýgý takdirde 0 atatnacak  zaten sovalye aktif sovalyelerden cokarilacak 
	}
	void  setsovalyeTipi(String s) {
		sovalyeTipi=s;
	}
	void setsovalyeTipiGuclu() { //sovalyenin tipini ayarlayan metodlar 
		sovalyeTipi="guclu";
	}
	void setsovalyeTipiZayif() {//arraylist olusturulurken bu metodlar kullanilir 
		sovalyeTipi="zayif";
	}
	String getsovalyeTipi() {//Sovalyeler savastirilirken sovalyenin ve dusmanin tipini karsilastirmak icin bu metod kullanilir.
		return sovalyeTipi;
	}
	
	
	int getVurusHakki() {  
		return vurusHakki;
	}
	
	void setVurusHakki(int vh) {
		vurusHakki=vh;
	}
	void setVurusHakkiAzalt() {//sans atamasý yapýlan sovalyenin vurus hakki birden buyuk olabilir dolayisiyla bir defa dusmana 
		vurusHakki=vurusHakki-1;;
	}
	void vur(Dusman d) {
		
	}
}
