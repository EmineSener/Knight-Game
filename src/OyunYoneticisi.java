import java.io.IOException;

public class OyunYoneticisi {
     OyunGorunumu oyun;
	OyunYoneticisi() throws IOException{
		oyun=new OyunGorunumu();//çaðrýldýðý anda oyunGorunumu nesnesi yaratýr.
		surec();//kendi surec metodunu caggirir
	}
	public void surec() {
		oyun.baslangicEkrani(); //sirasiyla uygun metodlari davet ederek oyun sürecini yönetir
		oyun.anaMenuyuGoster();
		oyun.menudenSecimYap();
		
	}
}
