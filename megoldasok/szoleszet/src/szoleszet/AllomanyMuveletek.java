/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szoleszet;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gábor
 */
public class AllomanyMuveletek {
    
    static void mennyisegeketKiir(List<Termelo> bovitettTermelok, String file){
        RandomAccessFile kiir;
        try {
            kiir = new RandomAccessFile(file, "rw");
            for (Termelo termelo : bovitettTermelok) {
                kiir.writeBytes(termelo.getNev()+" "+termelo.getKeszitettBorHektoLiter()+"\r\n");
            }
            kiir.close();
        } catch (IOException e) {
            System.out.println("Hiba a kiírás során: "+e.getMessage());
        }
        
    }
    
    static ArrayList<Termes> termeseketBeolvas(String file){
        ArrayList<Termes> list = new ArrayList<>();
        RandomAccessFile be;
        try {
            be = new RandomAccessFile(file, "r");
            be.readLine();
            while(be.getFilePointer()<be.length()){
                list.add(new Termes(be.readLine()));
            }
            be.close();
        } catch (IOException e) {
            System.out.println("Hiba: "+e.getMessage());
        }
        return list;
    }
    static ArrayList<Termelo> termeloketBeolvas(String file){
        ArrayList<Termelo> list = new ArrayList<>();
        RandomAccessFile be;
        try {
            be = new RandomAccessFile(file, "r");
            while(be.getFilePointer()<be.length())
                list.add(new Termelo(be.readLine()));
            be.close();
        } catch (IOException e) {
            System.out.println("Hiba: "+e.getMessage());
        }
        return list;
    }
}
