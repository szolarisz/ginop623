/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.KimosasraVar;
import controller.NemSzamFormatum;
import controller.NincsAdat;
import controller.VeszelyesenTele;
import java.util.ArrayList;

/**
 *
 * @author Gábor
 */
public final class Hordo {
    private int urmertek;
    private ArrayList<Integer> hordok;
    private ArrayList<Double> toltottsegSzazalek;
    private ArrayList<String> hibasAdatok;
    private ArrayList<String> hibaTipusok;

    public Hordo(String sor){ 
        String[] szeletek;
        this.hordok = new ArrayList<>();
        this.toltottsegSzazalek = new ArrayList<>();
        this.hibasAdatok = new ArrayList<>();
        this.hibaTipusok = new ArrayList<>();
        int liter;
        try {
            this.urmertek = Integer.parseInt(sor.split(":")[0]);
            szeletek = sor.split(":")[1].split(" ");
            for (String szelet : szeletek) {
              try{
                if(szelet.length()==0)
                    throw new NincsAdat(szelet+";nincs adat");
                else if(szelet.length()!=szelet.replaceAll("[^0-9 ]", "").length())
                    throw new NemSzamFormatum(szelet+";nem szám");
                else {
                    liter = Integer.parseInt(szelet);
                    if(liter<this.urmertek/10.0)
                        throw new KimosasraVar(liter+";<10%");
                    else if(liter>this.urmertek/100.0*97)
                        throw new VeszelyesenTele(liter+";>97%");
                    else {
                        this.hordok.add(liter);
                        this.toltottsegSzazalek.add((double)liter/this.urmertek*100);
                    }
                }
              } catch (NincsAdat e){
                    // System.out.println("Hiba: "+e.getMessage());
                    this.setHibasAdatok(e.getSor());
                } catch (NemSzamFormatum e){
                    this.setHibasAdatok(e.getSor());
                } catch (KimosasraVar e){
                    this.setHibasAdatok(e.getSor());
                } catch (VeszelyesenTele e){
                    this.setHibasAdatok(e.getSor());
                }
            }
        } catch(NumberFormatException e){
            System.out.println("Hiba: "+e.getMessage());
        } 
    }
    
    public void setHibasAdatok(String adatpar){
        this.hibasAdatok.add(adatpar.split(";")[0]);
        this.hibaTipusok.add(adatpar.split(";")[1]);
    }
            
    public int getUrmertek() {
        return urmertek;
    }

    public ArrayList<Integer> getHordok() {
        return hordok;
    }

    public ArrayList<Double> getToltottsegSzazalek() {
        return toltottsegSzazalek;
    }

    public ArrayList<String> getHibasAdatok() {
        return hibasAdatok;
    }

    public ArrayList<String> getHibaTipusok() {
        return hibaTipusok;
    }

    @Override
    public String toString() {
        return "Hordo{" + "urmertek=" + urmertek + ", hordok=" + hordok + ", toltottsegSzazalek=" + toltottsegSzazalek + '}';
    }


    
}
