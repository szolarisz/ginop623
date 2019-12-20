/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szoleszet;

/**
 *
 * @author Gábor
 */
public class Termelo implements Comparable<Termelo> {

    private int azonosito;
    private String nev;
    private int keszitettBorHektoLiter;

    public Termelo(String sor) {
        try {
            this.azonosito = Integer.parseInt(sor.substring(0, sor.indexOf(" ")));
        } catch (NumberFormatException exception) {
            System.out.println("Nem szám formátum: " + exception.getMessage());
        }
        this.nev = sor.substring(sor.indexOf(" ") + 1);
    }

    public int getAzonosito() {
        return azonosito;
    }

    public String getNev() {
        return nev;
    }

    public int getKeszitettBorHektoLiter() {
        return keszitettBorHektoLiter;
    }

    public void setKeszitettBorHektoLiter(int keszitettBorHektoLiter) {
        this.keszitettBorHektoLiter = keszitettBorHektoLiter;
    }

    @Override
    public String toString() {
        return "Termelo{" + "azonosito=" + azonosito + ", nev=" + nev + '}';
    }

    @Override
    public int compareTo(Termelo other) {
        return this.keszitettBorHektoLiter - other.keszitettBorHektoLiter;
    }
}
