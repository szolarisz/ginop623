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
public class Termes {

    private int gazda;
    private String szolo;
    private int[] teruletenkentiLiter;
//    private int osszesTermeltLiter=0;

    public Termes(String sor) {
        this.teruletenkentiLiter = new int[5];
        if (sor.charAt(sor.length() - 1) == ';') {
            sor = sor.concat("0");
            /*
            A következő sor szélesebb körben használható:
            sor += 0;
            */
        }
        String[] szeletek = sor.split(";");
        this.szolo = szeletek[1];
        try {
            this.gazda = Integer.parseInt(szeletek[0]);
            for (int i = 0; i < 5; i++) {
                if (szeletek[i + 2].isEmpty()) {
                    this.teruletenkentiLiter[i] = 0;
                } else {
                    this.teruletenkentiLiter[i] = (int) (Double.parseDouble(szeletek[i + 2].replace(",", ".")) * 1000);
                }
            }
        } catch (NumberFormatException exception) {
            System.out.println("Nem szám formátum: " + exception.getMessage());
        }
    }

    public int getGazda() {
        return gazda;
    }

    public String getSzolo() {
        return szolo;
    }

    public int[] getTeruletenkentiLiter() {
        return teruletenkentiLiter;
    }

    public int getOsszesTermeltLiter() {
        int osszeg = 0;
        for (int i : teruletenkentiLiter) {
            osszeg += i;
        }
        return osszeg;
    }

    @Override
    public String toString() {
        String literek = "";
        for (int i : this.teruletenkentiLiter) {
            literek = literek.concat(" " + i);
        }
        return "Termes{"
                + "gazda=" + gazda
                + ", szolo=" + szolo
                + ", teruletenkentiLiter=" + literek + '}';
    }

}
