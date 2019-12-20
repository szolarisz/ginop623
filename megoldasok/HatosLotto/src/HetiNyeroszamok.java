
import java.util.List;


public class HetiNyeroszamok {
    private String datum;
    private int[] nyeroszamok = new int [6];

    public HetiNyeroszamok(String datum, int[] nyeroszamok) {
        this.datum = datum;
        for(int i=0; i<nyeroszamok.length; i++)
            this.nyeroszamok[i] = nyeroszamok[i];
    }

    public String getDatum() {
        return datum;
    }

    public int[] getNyeroszamok() {
        return nyeroszamok;
    }

    @Override
    public String toString() {
        String result = "Heti nyerőszámok{" + "dátum: " + datum + ", nyeroszamok: ";
        for(int i=0; i< nyeroszamok.length-1; i++)
            result += nyeroszamok[i]+", ";
        result += nyeroszamok[nyeroszamok.length - 1];
        
        return result;
    }
    
    public HetiNyeroszamok(String sor) throws NumberFormatException {
        String [] szeletek = sor.split(";");
        for(int i=1; i< szeletek.length; i++)
            nyeroszamok[i-1]=Integer.parseInt(szeletek[i]);
        this.datum=szeletek[0];
    }
    
    public int találatokSzáma(List<Integer> tipp){
        int result = 0;
        for(int szám: nyeroszamok)
            if(tipp.contains(szám))
                result++;
        return result;
    }
}


