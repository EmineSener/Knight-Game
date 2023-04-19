
public class Dusman extends Karakterler {
	private boolean  durum;
	private String dusmanTipi;
	
	Dusman(){
		
	}
	Dusman(String ad,int id){
		setAd(ad);
		setId(id);
	}
	void setdusmanTipiGuclu() {
		dusmanTipi="guclu";
	}
	void setdusmanTipiZayif() {
		dusmanTipi="zayif";
	}
	String getdusmanTipi() {
		return dusmanTipi;
	}
	
	
}

