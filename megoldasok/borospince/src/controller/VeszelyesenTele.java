/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Gábor
 */
public class VeszelyesenTele extends Exception{
    private String sor;
    
    public VeszelyesenTele(String message){
        super(message);
        this.sor = message;
    }

    public String getSor() {
        return sor;
    }
    
    @Override
    public String getMessage(){
        return "Veszélyesen teli hordó";
    }
}
