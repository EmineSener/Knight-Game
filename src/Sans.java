 import java.util.Random;
 
public class Sans {
	private boolean iyiSans;//ek vurus sagla 
	private boolean kotuSans;//hic birsey saglama 
	
	private int sans;
	Random random;
	Sans(){
		random=new Random();//sans random olarak verilecek 
	}
	public void sansAta(Sovalye s) {//aktif sovalyelerden birni verceksin.Bu bir nesnedir 
		int y=random.nextInt(2); //0 ise kotu sans 1 isese iyi sans 
		if(y==0)
			kotuSans=true;
		else 
			iyiSans=true;
		if(iyiSans=true) {//iyisans aktif olduysa ek vurus atanabilir.
		sans=random.nextInt(3);
		s.setVurusHakki(1+sans);
		}
	}
	public String toString() {
		return "sans atandi";
	}
}
