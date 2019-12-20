/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szoleszet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author Gábor
 */
public class Szoleszet {

    public static void main(String[] args) {
        List<Termes> termesek = AllomanyMuveletek.termeseketBeolvas("termes.csv");
        List<Termelo> termelok = AllomanyMuveletek.termeloketBeolvas("termelok.csv");
        System.out.println("\n2. feladat: " + termelok.size() + " gazdáról vannak adataink.");
        System.out.println("\n3. feladat: " + egyediSzolofajtak(termesek).size() + " különböző szőlőfajtát termelnek.");
        System.out.println("\n4. feladat: " + legtobbetTermoSzolofajta(termesek) + " fajtából termett a legtöbb");
        // 5. feladat állomány kiírás
        AllomanyMuveletek.mennyisegeketKiir(adatbovito(termesek, termelok), "mennyiseg.txt");
        System.out.print("\n6. feladat: Kérek egy vezetéknevet: ");
        rangsorolo(termesek, termelok, new Scanner(System.in, "ISO-8859-2").nextLine());
        System.out.println("\n7. feladat: Nem termelt szőlőfajták:");
        nemTermeltSzolofajtak(termesek, termelok);
    }

    static void nemTermeltSzolofajtak(List<Termes> termesek, List<Termelo> termelok) {
        String[] teruletek = {"I", "II", "III", "IV", "V"};
        for (Termes termes : termesek) {
            for (int i = 0; i < termes.getTeruletenkentiLiter().length; i++) {
                if (termes.getTeruletenkentiLiter()[i] == 0) {
                    System.out.println(gazdaNeve(termelok, termes.getGazda()) + " " + termes.getSzolo() + " " + teruletek[i]);
                }
            }
        }
    }

    static String gazdaNeve(List<Termelo> termelok, int gazdaAzonosito) {
        for (Termelo termelo : termelok) {
            if (termelo.getAzonosito() == gazdaAzonosito) {
                return termelo.getNev();
            }
        }
        return "-- --";
    }

    static void rangsorolo(List<Termes> termesek, List<Termelo> termelok, String vezeteknev) {
        List<Termelo> bovitettTermelok = adatbovito(termesek, termelok);
        String nev;
        int darab = 0;
        for (int i = 0; i < bovitettTermelok.size(); i++) {
            nev = bovitettTermelok.get(i).getNev();
            if (nev.substring(0, nev.indexOf(" ")).equals(vezeteknev)) {
                darab++;
                System.out.println(nev + " a bortermelők listájában a(z) " + (i + 1) + ". helyen áll");
            }
        }
        if (darab == 0) {
            System.out.println("Nincs ilyen vezetéknevű bortermelő");
        }
    }

    static List<Termelo> adatbovito(List<Termes> termesek, List<Termelo> termelok) {
        for (Termelo termelo : termelok) {
            termelo.setKeszitettBorHektoLiter(egyGazdaOsszHektoLiter(termesek, termelo.getAzonosito()));
        }
        Collections.sort(termelok, Collections.reverseOrder());
        /*
        A következő alakot is használjuk:
        Collections.sort(termelok);
        Collections.reverse(termelok);
         */
        return termelok;
    }

    static int egyGazdaOsszHektoLiter(List<Termes> termesek, int gazdaAzonosito) {
        int osszeg = 0;
        for (Termes termes : termesek) {
            if (termes.getGazda() == gazdaAzonosito) {
                osszeg += termes.getOsszesTermeltLiter();
            }
        }
        return (int) (Math.round(osszeg / 100.0));
    }

    static int egyfajtaSzolobolBorLiter(List<Termes> termesek, String fajta) {
        int liter = 0;
        for (Termes termes : termesek) {
            if (termes.getSzolo().equals(fajta)) {
                liter += termes.getOsszesTermeltLiter();
            }
        }
        return liter;
    }

    static String legtobbetTermoSzolofajta(List<Termes> termesek) {
        int maxindex = 0;
        for (int i = 1; i < termesek.size(); i++) {
            if (egyfajtaSzolobolBorLiter(termesek, termesek.get(i).getSzolo()) > egyfajtaSzolobolBorLiter(termesek, termesek.get(maxindex).getSzolo())) {
                maxindex = i;
            }
        }
        return termesek.get(maxindex).getSzolo();
    }

    static TreeSet<String> egyediSzolofajtak(List<Termes> termesek) {
        TreeSet<String> szolofajtak = new TreeSet<>();
        for (Termes termes : termesek) {
            szolofajtak.add(termes.getSzolo());
        }
        return szolofajtak;
    }
}
