import java.io.IOException;

public class OyunYoneticisi {
     OyunGorunumu oyun;
	OyunYoneticisi() throws IOException{
		oyun=new OyunGorunumu();//�a�r�ld��� anda oyunGorunumu nesnesi yarat�r.
		surec();//kendi surec metodunu caggirir
	}
	public void surec() {
		oyun.baslangicEkrani(); //sirasiyla uygun metodlari davet ederek oyun s�recini y�netir
		oyun.anaMenuyuGoster();
		oyun.menudenSecimYap();
		
	}
}
