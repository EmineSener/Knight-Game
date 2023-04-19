
public class Karakterler {
	private String ad;   //sadece bu class'tan erisileblinen alan degiskenler.adlarýnýn cagristirdigi sekilde karakter bilgilerini tutar.
	private int id;
	private boolean aktif;
	public Karakterler() {
		
	}
	public Karakterler(String ad,int id) { //for donguusyle olusturulacak karakter nesnelerine uygun stringler atanacak.
		
		this.id=id;
	}
	void setAd(String ad) {   //set metodlari diger class' tan deðist,rim saglatir 
		this.ad=ad;
	}
	
	String getAd() {// get netodlari deiger class'lardan erisim saglatir.
		return ad;
	}
	void setId(int id) {
		this.id=id;
	}
	int  getId() {
		return id;
	}
	void setAktif(boolean aktif) {
		this.aktif=aktif;
	}
	boolean getAktif() {
		return aktif;
	}
}
