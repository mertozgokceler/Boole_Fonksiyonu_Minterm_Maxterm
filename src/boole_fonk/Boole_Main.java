package boole_fonk;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Boole_Main {

	 public static void main(String[] args) throws FileNotFoundException {

	        File dosyaKonumu = new File("C:\\Users\\merto\\eclipse-workspace\\boole_fonk\\boole");
	        Scanner oku = new Scanner(dosyaKonumu);
	        System.out.println("boole.txt dosyası okundu");
	        System.out.println();

	       
	        String function_oku = oku.nextLine();
	        String[] function_elements = function_oku.split("\\s*=\\s*");
	        String function = function_elements[1];
	        
	        char[] tum_harfler = function.replaceAll("[^a-zA-Z]", "").toCharArray();
	        Arrays.sort(tum_harfler);
	        
	        List <Character> tekrar_etmeyen_harf = new ArrayList<>();
	        
	        for (char harfler : tum_harfler) {
	            if (!tekrar_etmeyen_harf.contains(Character.toUpperCase(harfler))) {
	                tekrar_etmeyen_harf.add(Character.toUpperCase(harfler));
	            }
	        }

	        char[] sırlaı_harfler = new char[tekrar_etmeyen_harf.size()];
	        int i = 0;
	        for (char letter : tekrar_etmeyen_harf) {
	            sırlaı_harfler[i++] = letter;
	        }
	       
	        
	        String[] sutun_harfleri = new String[sırlaı_harfler.length];
	        for (int j = 0; j < sırlaı_harfler.length; j++) {
	             sutun_harfleri[j] = String.valueOf(sırlaı_harfler[j]);
	             
	        }
	       
	        
	        String[] fonksiyonElemanlari = function.split("\\s*\\+\\s*");
	        oku.close();
	        	       
	        System.out.println("doğruluk tablosu:\n");
	        
	        int[][] data = {
	            {0, 0, 0, 0},
	            {0, 0, 0, 1},
	            {0, 0, 1, 0},
	            {0, 0, 1, 1},
	            {0, 1, 0, 0},
	            {0, 1, 0, 1},
	            {0, 1, 1, 0},
	            {0, 1, 1, 1},
	            {1, 0, 0, 0},
	            {1, 0, 0, 1},
	            {1, 0, 1, 0},
	            {1, 0, 1, 1},
	            {1, 1, 0, 0},
	            {1, 1, 0, 1},
	            {1, 1, 1, 0},
	            {1, 1, 1, 1}
	        };
	              
	        Fonksiyon_Olustur fonk = new Fonksiyon_Olustur();
	        fonk.dogruluk_tablo_olustur(sutun_harfleri, fonksiyonElemanlari, data, sırlaı_harfler,function_elements[0]);

	    }
	}




