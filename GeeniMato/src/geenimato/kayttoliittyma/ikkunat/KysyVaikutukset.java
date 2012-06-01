/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geenimato.kayttoliittyma.ikkunat;

import geenimato.luokat.Aine;
import geenimato.luokat.Interaktio;
import geenimato.luokat.Solu;
import java.util.ArrayList;

/**
 *
 * @author henriikka
 */
public class KysyVaikutukset extends javax.swing.JFrame {
    
    private Solu solu;
    private boolean onkoNappiaPainettu;

    /**
     * Creates new form Interaktiot
     */
    public KysyVaikutukset() {
        initComponents();
        this.onkoNappiaPainettu = false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kysymys = new javax.swing.JTextField();
        valinta = new javax.swing.JComboBox();
        seuraavaNappi = new javax.swing.JButton();
        lopetusnappi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        kysymys.setText("jTextField1");

        valinta.setMaximumRowCount(3);
        valinta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ei vaikutusta", "Inhibitio", "Aktivaatio" }));

        seuraavaNappi.setText("Seuraava");
        seuraavaNappi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seuraavaNappiActionPerformed(evt);
            }
        });

        lopetusnappi.setText("Lopeta");
        lopetusnappi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lopetusnappiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(valinta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kysymys, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 45, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lopetusnappi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(seuraavaNappi)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kysymys, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(valinta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seuraavaNappi)
                    .addComponent(lopetusnappi))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public Interaktio mikaInteraktio(){
        Interaktio interaktio = Interaktio.EI;
        if (valinta.getSelectedIndex() == 1){
            interaktio = Interaktio.INHIBITIO;
        }else if (valinta.getSelectedIndex() == 2){
            interaktio = Interaktio.AKTIVAATIO;
        }
        return interaktio;
    }
    
    public void setKysymys(String teksti){
               kysymys.setText(teksti); 
    }
            
    public boolean nappiaPainettu(){
        return this.onkoNappiaPainettu;
    }
    
    public void NappiAlas(){
        this.onkoNappiaPainettu = false;
    }
    
    private void seuraavaNappiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seuraavaNappiActionPerformed
        this.onkoNappiaPainettu = true;
    }//GEN-LAST:event_seuraavaNappiActionPerformed

    private void lopetusnappiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lopetusnappiActionPerformed
        System.exit(0);
    }//GEN-LAST:event_lopetusnappiActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KysyVaikutukset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KysyVaikutukset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KysyVaikutukset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KysyVaikutukset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new KysyVaikutukset().setVisible(true);
            }
            
            
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField kysymys;
    private javax.swing.JButton lopetusnappi;
    private javax.swing.JButton seuraavaNappi;
    private javax.swing.JComboBox valinta;
    // End of variables declaration//GEN-END:variables
}