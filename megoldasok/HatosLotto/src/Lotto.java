
import java.awt.Color;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Lotto extends javax.swing.JFrame {

    private static Exception HibásSzámException(String nem_megfelelő_számformátum) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Lotto() {
        initComponents();
        SetIcon();
    }
    private void tablafeltolto(List<HetiNyeroszamok> list){
        DefaultTableModel dtm = new DefaultTableModel();
        String[] oszlopnevek = {"húzás hete", "nyerőszámok"};
        dtm.setColumnIdentifiers(oszlopnevek);
        String hatszam;
        for (HetiNyeroszamok hetiNyeroszam : list) {
            hatszam="";
            for (int i = 0; i < hetiNyeroszam.getNyeroszamok().length; i++){
                hatszam = hatszam.concat(hetiNyeroszam.getNyeroszamok()[i]+" ");
            }
            dtm.addRow(new String[]{hetiNyeroszam.getDatum(), hatszam});
        }
        this.eredmenyTable.setModel(dtm);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        eredmenyTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        tipp = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        kiertekelesGomb = new javax.swing.JButton();
        osszesHuzasGomb = new javax.swing.JButton();
        eredmeny = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        valasz = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        nyeremenyek = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hatos lottó - feldolgozás");
        setIconImages(null);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Hatos lottó");

        jLabel2.setText("Heti nyerőszámok 2005-2018");

        eredmenyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "", "", "", ""
            }
        ));
        jScrollPane1.setViewportView(eredmenyTable);

        jLabel3.setText("Saját tipp");

        tipp.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabel4.setText("A 6 számod szóközzel elválasztva");

        kiertekelesGomb.setText("Kiértékelés");
        kiertekelesGomb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kiertekelesGombActionPerformed(evt);
            }
        });

        osszesHuzasGomb.setText("Összes húzás");
        osszesHuzasGomb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                osszesHuzasGombActionPerformed(evt);
            }
        });

        eredmeny.setText("sorok száma:");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/forras/pig.png"))); // NOI18N

        valasz.setBackground(new java.awt.Color(51, 102, 0));
        valasz.setForeground(new java.awt.Color(255, 255, 255));

        jScrollPane2.setViewportView(nyeremenyek);

        jButton1.setText("Kilépés");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(26, 26, 26)
                        .addComponent(osszesHuzasGomb))
                    .addComponent(eredmeny, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(valasz)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(tipp, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(kiertekelesGomb)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 41, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jLabel1))
                .addGap(72, 72, 72)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(osszesHuzasGomb))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(eredmeny, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tipp, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(kiertekelesGomb)
                        .addGap(18, 18, 18)
                        .addComponent(valasz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void osszesHuzasGombActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_osszesHuzasGombActionPerformed
//        this.nyeroszamok = new ArrayList<>();
        this.nyeroszamok = beolvasas("hatos.csv");
        this.eredmeny.setText("sorok száma: "+this.nyeroszamok.size());
        tablafeltolto(this.nyeroszamok);
    }//GEN-LAST:event_osszesHuzasGombActionPerformed

    private void kiertekelesGombActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kiertekelesGombActionPerformed
        this.valasz.setText("");
        this.valasz.setBackground(Color.red);
        String szamok = this.tipp.getText();
        //Ide kell a hibafeldolgozás!!!!
        List<Integer> szamokKT = null;
        try{
             szamokKT = feldolgoz( this.tipp.getText() );
        }catch(HibásSzámException kivétel){
            JOptionPane.showMessageDialog(null, kivétel.getMessage(),"Szám formátum hiba",JOptionPane.ERROR_MESSAGE);
        }catch(KevésSzámException kivétel){
            JOptionPane.showMessageDialog(null, kivétel.getMessage(),"Nem megfelelő mennyiségű szám",JOptionPane.ERROR_MESSAGE);
        }catch(IntervallumException kivétel){
            JOptionPane.showMessageDialog(null, kivétel.getMessage(),"a számok 1-45 között lehetnek",JOptionPane.WARNING_MESSAGE);
        }
        
        
            if(szamok.length()<1)
            this.valasz.setText("Nincs saját tipp");
        else {
            int szokozokSzama=0;
            for (int i = 0; i < szamok.length(); i++) {
                if(szamok.charAt(i)==' '){
                    szokozokSzama++;
                }
            }
            if(szokozokSzama!=5){
                this.valasz.setText("6 számra van szükség");
            }
            else {
                String[] szovegtippek = new String[6];
                szovegtippek = szamok.split(" ");
                int[] szamtippek = new int[6];
                for (int i = 0; i < szovegtippek.length; i++) {
                    try {
                        szamtippek[i]=Integer.parseInt(szovegtippek[i]);
                    } catch(NumberFormatException e){
                        System.out.println("Nem számformátum");
                        szamtippek[i]=0;
                    }                    
                }
                // kiválasztásos sorberendezés
                int csere;
                for (int i = 0; i < szamtippek.length-1; i++) {
                    for (int j = i+1; j < szamtippek.length; j++) {
                        if(szamtippek[i]>szamtippek[j]) {
                            csere = szamtippek[i];
                            szamtippek[i]=szamtippek[j];
                            szamtippek[j]=csere;
                        }                        
                    }                    
                }
                
                String kiiratottSzamok="";
                for (Integer elem : szamokKT) {
                    kiiratottSzamok += elem + " ";
                }
                kiiratottSzamok = kiiratottSzamok.trim();
                
                this.valasz.setBackground(new java.awt.Color(51, 102, 0));
                this.valasz.setText(kiiratottSzamok);
                TreeSet<Integer> merged = new TreeSet<>();
                int [] nyertesDarab = new int[7];
                for(int i=0; i<nyertesDarab.length; i++)
                    nyertesDarab[i] = 0;
                for(HetiNyeroszamok elem: nyeroszamok)
                    nyertesDarab[elem.találatokSzáma(szamokKT)]++;
                    
                int talalat;
                int nyert3=0, nyert4=0, nyert5=0, nyert6=0;
                for (HetiNyeroszamok hetiNyeroszam : this.nyeroszamok) {
                    for (int i = 0; i < hetiNyeroszam.getNyeroszamok().length; i++) {
                        merged.add(hetiNyeroszam.getNyeroszamok()[i]);
                    }
                    for (int i = 0; i < szamtippek.length; i++) {
                        merged.add(szamtippek[i]);
                    }
                    talalat = 12-merged.size();
                    if(talalat==6){
                        nyert6++;
                    }
                    else if(talalat==5){
                        nyert5++;
                    }
                    else if(talalat==4){
                        nyert4++;
                    }
                    else if(talalat==3){
                        nyert3++;
                    }
                    merged.clear();
                }
                System.out.println("6: "+nyert6);
                System.out.println("5: "+nyert5);
                System.out.println("4: "+nyert4);
                System.out.println("3: "+nyert3);
                DefaultListModel dlm = new DefaultListModel();
                dlm.clear();
//                if(nyert6>0)
//                    dlm.addElement("6 találat: "+nyert6+" db");  
//                if(nyert5>0)
//                    dlm.addElement("5 találat: "+nyert5+" db");  
//                if(nyert4>0)
//                    dlm.addElement("4 találat: "+nyert4+" db");  
//                if(nyert3>0)
//                    dlm.addElement("3 találat: "+nyert3+" db"); 
                for(int i=6; i>=3; i--)
                    dlm.addElement(i+" találat: "+nyertesDarab[i]+" db");
                this.nyeremenyek.setModel(dlm);
            }
        }
    }//GEN-LAST:event_kiertekelesGombActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Lotto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lotto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lotto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lotto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lotto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel eredmeny;
    private javax.swing.JTable eredmenyTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton kiertekelesGomb;
    private javax.swing.JList<String> nyeremenyek;
    private javax.swing.JButton osszesHuzasGomb;
    private javax.swing.JTextField tipp;
    private javax.swing.JTextField valasz;
    // End of variables declaration//GEN-END:variables
    private List<HetiNyeroszamok> nyeroszamok ;
    
    public static List<HetiNyeroszamok> beolvasas(String file){
                
        Ellenőrző.számol = 1;
        
        List<HetiNyeroszamok> lista = new ArrayList<>();
        try {
            RandomAccessFile beolvas = new RandomAccessFile(file, "r");
            while( beolvas.getFilePointer() < beolvas.length() ){
//                System.out.println(beolvas.length());
                lista.add(new HetiNyeroszamok( beolvas.readLine() ) );
            }            
            beolvas.close();
        } catch (IOException exc) {
            JOptionPane.showMessageDialog(null, exc.getMessage(),"Állomány hiba",JOptionPane.ERROR_MESSAGE);
            System.err.println("Hiba: "+exc.getMessage());        
        } catch (NumberFormatException exc) {
            JOptionPane.showMessageDialog(null, exc.getMessage(),"Szám formátum hiba",JOptionPane.ERROR_MESSAGE);
            System.err.println("Nem szám formátum! "+exc.getMessage());
        } finally{        
            return lista;
        }
    }
    
    public static List<Integer> feldolgoz(String sor) throws KevésSzámException, HibásSzámException, IntervallumException{
        if(Ellenőrző.számol == 0)
            JOptionPane.showMessageDialog(null, "Előbb dolgozd fel az állományt.","Állomány feldolgozás hiba",JOptionPane.WARNING_MESSAGE);
        if(sor.length() == 0)
            throw new KevésSzámException("Nem hat különböző számot adtál meg!");
        if(sor.length() != sor.replaceAll("[^0-9 ]", "").length())
            throw new HibásSzámException("Nem megfelelő számformátum");
        String [] részek = sor.split(" ");
        TreeSet<Integer> temp = new TreeSet<>();
        for(String elem : részek){
            temp.add(Integer.parseInt(elem));
        }
        if(temp.size() != 6)
            throw new KevésSzámException("Nem hat különböző számot adtál meg!");
        if(temp.first() < 1 || temp.last() >45 )
            throw new IntervallumException("A megadott számok 1-45 között lehetnek!");
        List<Integer> result = new ArrayList<>();
        result.addAll(temp); //És még rendezve is van!!!
        return result;
    }

    private void SetIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/forras/clover.png")));
    }

}




