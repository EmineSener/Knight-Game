import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class SavasMotoru {  //bu class'da oyuncu secimlerini yapacak
	
	ArrayList<Sovalye> aktifsovalyeler;
	ArrayList<Dusman> aktifdusmanlar ;
	CSVOyunVerisi dosya;
	
	     Scanner input=new Scanner(System.in);
	     
		SavasMotoru(ArrayList<Sovalye> aktifsovalyeler,
		ArrayList<Dusman> aktifdusmanlar)throws IOException{
			this.aktifsovalyeler=aktifsovalyeler;//arrayListlerin referansý kopyalandý 
			this.aktifdusmanlar=aktifdusmanlar;
			
			dosya=new CSVOyunVerisi();//CSVOyunVerisi nesnensi olusturuldu
			dosya.kayitVerileriniYukle();//dosya nesnesinin kayitVerileriniYukle metodu() karakter havuzunu dosyaya yazar.
		}
		
		public void sovalyesayisiarttir() {//kullanicininn 2 guclu sovalyei varsa birini degistirmek isterse dedistirir:2 zayif sovalyyele 
			int cevap=0;
				System.out.println("Bir guclu sovalyenizi iki zayýf sovalyeye cevirmek istiyorsanýz 1; istemiyorsaniz 2 tuslayin");
				cevap=input.nextInt();
			
			if(cevap==1) {
				aktifsovalyeler.remove(0);
				aktifsovalyeler.add(new ZayifSovalyee("S1yeni",123));
			    aktifsovalyeler.get(4).setsovalyeTipiZayif();
			    aktifsovalyeler.add(new ZayifSovalyee("S2yeni",125));
			    aktifsovalyeler.get(5).setsovalyeTipiZayif();
			}
		}
		public void sovalyesavastir(int sovalyeNo,int dusmanNo) {
			if(sovalyeNo!=-1&&dusmanNo!=-1) {//kullanýcý eger sovalye veya dusman no lardan birini -1 girdiyse oyundan çýkmak istediði anlamýna gelir 
				if((aktifsovalyeler.get(sovalyeNo).getsovalyeTipi().equals("guclu"))){// sovalye guclu olursa dusmana bakýlmaksýzýn hamle ile dusman olür.
					aktifsovalyeler.get(sovalyeNo).setVurusHakkiAzalt();//dusmana sans atandýysa hamle yaptýðýnda hemen ölmeyebilir.	
					
					dosya.oyunVerileriniYukle(aktifsovalyeler.get(sovalyeNo).getAd()+"sovalyesi "+aktifdusmanlar.get(dusmanNo).getAd()+"dusmanina vurdu");
					dosya.oyunVerileriniYukle("dusman etkisiz hale getirildi hedef vuruldu");
					System.out.println("Hedef vuruldu ");
					System.out.println("Dusman etkisiz hale getirildi");
					aktifdusmanlar.remove(dusmanNo);//dusmana tek hamle ve olur.
}
				else if((aktifsovalyeler.get(sovalyeNo).getsovalyeTipi().equals("zayif")&&aktifdusmanlar.get(dusmanNo).getdusmanTipi().equals("zayif"))) {	
					aktifsovalyeler.get(sovalyeNo).setVurusHakkiAzalt();	
					dosya.oyunVerileriniYukle(aktifsovalyeler.get(sovalyeNo).getAd()+"sovalyesi "+aktifdusmanlar.get(dusmanNo).getAd()+"dusmanina vurdu");
					aktifdusmanlar.remove(dusmanNo);
					dosya.oyunVerileriniYukle("dusman etkisiz hale getirildi hedef vuruldu");
					System.out.println("Hedef vuruldu ");
					System.out.println("Dusman etkisiz hale getirildi");}
				else //guclu dusman zayif sovalye 
				{
					dosya.oyunVerileriniYukle(aktifsovalyeler.get(sovalyeNo).getAd()+"sovalyesi "+aktifdusmanlar.get(dusmanNo).getAd()+"dusmanina vurdu");
					dosya.oyunVerileriniYukle("dusman etkisiz hale getirilemedi");
					aktifsovalyeler.get(sovalyeNo).setVurusHakkiAzalt();
					System.out.println("Dusman etkisiz hale getirilemedi ");}	
		}
		
		  else {//oyun bitmeden lkullanýcý girdilere -1 vererek oyunu sonlandýrdý 
			  dosya.oyunVerileriniYukle("Oyun kullanici isegiyle sona erdi");
			  System.out.println("Oyun kullanici isegiyle sona erdi");
		  }
		}
		public void oyunBitir(int a) {
			if(a==1) {//+1 ise kazandin
				dosya.oyunVerileriniYukle("Oyunu kullanici kazandi");
				System.out.println("Oyunu kazandiniz");
				dosya.kapat();
			}
			else {//-1 ise kaybettin 
				dosya.oyunVerileriniYukle("Oyunu kullanici kaybetti");
				System.out.println("Oyunu kaybettiniz");
				dosya.kapat();
				}
		}
		
		
}
