//cagrilmasina gerek yok oyunGorunum zaten cagiryor i
import java.io.*;
import java.util.Scanner;
public class CSVOyunVerisi extends OyunVerisi  {
	 PrintWriter output;
	  DosyaOkuyucu read;
	public CSVOyunVerisi() throws IOException {
		File file = new File("oyun.txt");
	    if (!file.exists()) {
	        file.createNewFile();
	    }
	    output = new  PrintWriter(file);
	    
	    read=new DosyaOkuyucu();
	    Scanner input = new Scanner(file);
	    while(input.hasNext()) {
	    	read.bilgiler.add(input.nextLine()) ;}
	}
	
	public void oyunVerileriniYukle(String s) { //oyun sürecini dosyaya yazar 
		output.println(s);
		
	}
	public void kapat() { //oyun bittiðinde çaðrýlýr ve dosyayý kapaatir
		output.close();
	}
	public void kayitVerileriniYukle() {  //karakter havuzunu dosyaya yazr.
		for(int i=0;i<aktifsovalyeler.size();i++) {
			output.println((i)+"*******************\r\n"
					+ "Sovalye adý:"+aktifsovalyeler.get(i).getAd()+"\r\n"
					+ "sovalye Tipi:"+aktifsovalyeler.get(i).getsovalyeTipi()+"\r\n"
					+ "Sovalye id:"+aktifsovalyeler.get(i).getId()+"\r\n"
					+ "Sovalye vurus hakki:  "+aktifsovalyeler.get(i).getVurusHakki()+"\r\n"
					+"*******************\r\n");
		}
		for(int i=0;i<aktifdusmanlar.size();i++) {
			output.println((i)+"*******************\r\n"
					+ "Dusman adý:"+aktifdusmanlar.get(i).getAd()+"\r\n"
					+"*******************\r\n");
		}
	}
	
	
	
	
	
	
	
	
}
