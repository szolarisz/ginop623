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
public class Korong implements Comparable<Korong> {

    private final int ALAPAR = 32;
    private double sugarCm;
    private int magassagMm;
    private String szin;
    private int szorzo;

    public Korong(String sor) {
        sor = sor.replace("/", ";");
        String[] szeletek = sor.split(";");
        this.szin = szeletek[2];
        try {
            this.sugarCm = Double.parseDouble(szeletek[0]);
            this.magassagMm = Integer.parseInt(szeletek[1]);
            this.szorzo = Integer.parseInt(szeletek[3]);
        } catch (NumberFormatException exception) {
            System.out.println("Hiba: " + exception.getMessage());
        }
    }

    public double getTerfogatMm3() {
        return Math.pow(this.sugarCm * 10, 2) * Math.PI * this.magassagMm;
    }

    public int getAlapar() {
        return ALAPAR;
    }

    public double getSugarCm() {
        return sugarCm;
    }

    public int getMagassagMm() {
        return magassagMm;
    }

    public String getSzin() {
        return szin;
    }

    public int getSzorzo() {
        return szorzo;
    }

    @Override
    public String toString() {
        return this.sugarCm + "/" + this.magassagMm + ";" + this.szin + ";" + this.szorzo;
    }

    @Override
    public int compareTo(Korong other) {
        return this.szorzo - other.szorzo;
    }
    
    public int getTenylegesAr(){
        return (int)(Math.round(ALAPAR * (1 + this.szorzo / 10.0)));
    }
    
    public boolean egyezoSzinu(String szin){
        return this.szin.equals(szin);
    }
}
