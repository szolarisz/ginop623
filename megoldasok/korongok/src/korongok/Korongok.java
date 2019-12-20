/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package korongok;

/**
 *
 * @author Thomas
 */
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

/**
 *
 * @author G�bor
 */
public class Korongok {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Korong> korongok = beolvaso("korongok.txt");  // 1.
        System.out.println("2. feladat: " + korongok.size() + " k�l�nb�z� korongot gy�rtunk"); //2.
        vanIlyenSzinuKorong(korongok); //3.
        legnagyobbKorong(korongok); //4.
        szinenkentiKorongokSzama(korongok); //5.
        limitFelettiekKiirasa(korongok); //6.
        System.out.println("7. feladat: A csomag �ssz�rt�ke: " + osszErtek(korongok)); //7.

    }
    
    static List<Korong> beolvaso(String file){
        List<Korong> result = new ArrayList<>();
        RandomAccessFile bemenet;
        try {
            bemenet = new RandomAccessFile(file, "r");
            while(bemenet.getFilePointer() < bemenet.length()){
                result.add(new Korong(bemenet.readLine()));
            }
            bemenet.close();
        } catch (IOException except) {
            System.out.println("Hiba: "+except.getMessage());
        }        
        return result;
    }

    static void vanIlyenSzinuKorong(List<Korong> korongok) {
        System.out.print("3. feladat: K�rek egy sz�nt: ");
        Scanner billentyu = new Scanner(System.in);
        String szin = billentyu.nextLine();
        if (gyartunkOlyanSzinuKorongot(korongok, szin)) {
            System.out.print("Gy�rtunk ");
        } else {
            System.out.print("Nem gy�rtunk ");
        }
        System.out.println(szin+" sz�n� korongot");
    }

   

    static void limitFelettiekKiirasa(List<Korong> korongok) {
        Scanner billentyuzet = new Scanner(System.in);
        System.out.print("6. feladat: K�rek egy t�rfogatot mm3-ben: ");
        try {
            sorszamozvaRendezveKiir(nagyobbak(korongok, billentyuzet.nextDouble()));
        } catch (NumberFormatException except) {
            System.out.println("Hiba: " + except.getMessage());
        }
    }

    static int osszErtek(List<Korong> korongok) {
        int osszeg = 0;
        for (Korong korong : korongok) {
            osszeg += 1000 * korong.getTenylegesAr();
        }
        osszeg += 1000; // csomagol�s
        osszeg += 85 * Math.ceil(korongok.size() * 1000 / 700.0); // m�retd�j

        return osszeg;
    }

    static void sorszamozvaRendezveKiir(List<Korong> korongok) {
        Collections.sort(korongok);
        for (int i = 0; i < korongok.size(); i++) {
            System.out.println((i + 1) + ": " + korongok.get(i));
        }
    }

    static List<Korong> nagyobbak(List<Korong> korongok, double terfogatLimit) {
        ArrayList<Korong> nagyobbKorongok = new ArrayList<>();
        for (Korong korong : korongok) {
            if (korong.getTerfogatMm3() > terfogatLimit) {
                nagyobbKorongok.add(korong);
            }
        }
        return nagyobbKorongok;
    }

    static void szinenkentiKorongokSzama(List<Korong> korongok) {
        System.out.println("\n5. feladat: Kimutat�s a sz�nenk�nt gy�rtott korongok sz�m�r�l:");
        TreeSet<String> szinek = new TreeSet<>();
        for (Korong korong : korongok) {
            szinek.add(korong.getSzin());
        }
        int darab;
        for (String szin : szinek) {
            darab = 0;
            for (Korong korong : korongok) {
                if ( korong.egyezoSzinu(szin) ) {
                    darab++;
                }
            }
            System.out.println(szin + " sz�nb�l \t" + darab + " darab van");
        }
    }

    static Korong legnagyobbKorong(List<Korong> korongok) {
        System.out.println("\n4. feladat: A legnagyobb t�rfogat� korong:");
        int maxIndex = 0;
        for (int i = 1; i < korongok.size(); i++) {
            if (korongok.get(i).getTerfogatMm3() > korongok.get(maxIndex).getTerfogatMm3()) {
                maxIndex = i;
            }
        }
        return korongok.get(maxIndex);
    }

    static boolean gyartunkOlyanSzinuKorongot(List<Korong> korongok, String szin) {
        boolean result = false; 
        for (Korong egyKorong : korongok) {
            if (egyKorong.egyezoSzinu(szin)) {
                result = true;
                break;
            }
        }
        return result;
        
        /*
            A feladat megoldhat� lenne, hogy a szinenkentiKorongokSzama() met�dusb�l 
            �s ebb�l a met�dusb�l a k�z�s r�szt egy harmadikba rakn�nk ki �s �gy oldan�nk meg a feladatot.
         */
    }
}
