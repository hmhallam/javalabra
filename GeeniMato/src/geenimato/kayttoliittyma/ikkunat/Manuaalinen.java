/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geenimato.kayttoliittyma.ikkunat;

import geenimato.luokat.Aine;
import geenimato.luokat.Interaktio;
import geenimato.luokat.Solu;

/**
 *
 * @author henriikka
 */
public class Manuaalinen extends javax.swing.JFrame {
    
    private Solu solu;
    private boolean onkoNappiaPainettu;

    /**
     * Creates new form Manuaalinen
     */
    public Manuaalinen() {
        initComponents();
        this.solu = new Solu(0);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        valmis = new javax.swing.JButton();
        lopetusnappi = new javax.swing.JButton();
        nimiKentta = new javax.swing.JFormattedTextField();
        tuottoSlider = new javax.swing.JSlider();
        hajotusSlider = new javax.swing.JSlider();
        kynnysSlider = new javax.swing.JSlider();
        tuottoLabel = new javax.swing.JLabel();
        hajotusLabel = new javax.swing.JLabel();
        kynnysLabel = new javax.swing.JLabel();
        interaktioValinat = new javax.swing.JComboBox();
        interaktioLabel = new javax.swing.JLabel();
        nimiLabel = new javax.swing.JLabel();
        geeniStatusLabel = new javax.swing.JLabel();
        geeniPaalle = new javax.swing.JRadioButton();
        geeniPois = new javax.swing.JRadioButton();
        lisatyt = new javax.swing.JLabel();
        lisaysnappi = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lisatytAineet = new javax.swing.JTextArea();
        tuottoArvo = new javax.swing.JLabel();
        hajotusArvo = new javax.swing.JLabel();
        kynnysNro = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        valmis.setText("Valmis");
        valmis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valmisActionPerformed(evt);
            }
        });

        lopetusnappi.setText("Lopeta");
        lopetusnappi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lopetusnappiActionPerformed(evt);
            }
        });

        nimiKentta.setText("Aine1");

        tuottoSlider.setMinimum(30);
        tuottoSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tuottoSliderStateChanged(evt);
            }
        });

        hajotusSlider.setMaximum(70);
        hajotusSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                hajotusSliderStateChanged(evt);
            }
        });

        kynnysSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                kynnysSliderStateChanged(evt);
            }
        });

        tuottoLabel.setText("Tuottonopeus");

        hajotusLabel.setText("Hajotusnopeus");

        kynnysLabel.setText("Kynnysarvo");

        interaktioValinat.setMaximumRowCount(3);
        interaktioValinat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ei mitään", "Inhibitio", "Aktivaatio" }));
        interaktioValinat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        interaktioLabel.setText("Interaktio");

        nimiLabel.setText("Nimi");

        geeniStatusLabel.setText("Geeni päällä");

        buttonGroup1.add(geeniPaalle);
        geeniPaalle.setText("kyllä");

        buttonGroup1.add(geeniPois);
        geeniPois.setSelected(true);
        geeniPois.setText("ei");

        lisatyt.setText("Aineita lisätty");

        lisaysnappi.setText("Lisää");
        lisaysnappi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lisaysnappiActionPerformed(evt);
            }
        });

        lisatytAineet.setColumns(20);
        lisatytAineet.setRows(5);
        jScrollPane2.setViewportView(lisatytAineet);

        tuottoArvo.setText("Arvo");

        hajotusArvo.setText("Arvo");

        kynnysNro.setText("Arvo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lopetusnappi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lisaysnappi)
                        .addGap(18, 18, 18)
                        .addComponent(valmis))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(hajotusLabel)
                                    .addComponent(kynnysLabel)
                                    .addComponent(interaktioLabel)
                                    .addComponent(nimiLabel)
                                    .addComponent(geeniStatusLabel)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tuottoLabel)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(hajotusSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hajotusArvo))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tuottoSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tuottoArvo))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(geeniPaalle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(geeniPois))
                            .addComponent(interaktioValinat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nimiKentta, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(kynnysSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(kynnysNro)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lisatyt))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nimiKentta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nimiLabel))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(geeniStatusLabel)
                            .addComponent(geeniPaalle)
                            .addComponent(geeniPois))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(tuottoArvo)
                            .addComponent(tuottoSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tuottoLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(hajotusArvo)
                            .addComponent(hajotusLabel)
                            .addComponent(hajotusSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(kynnysLabel)
                            .addComponent(kynnysSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kynnysNro))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(interaktioLabel)
                            .addComponent(interaktioValinat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lisatyt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valmis)
                    .addComponent(lopetusnappi)
                    .addComponent(lisaysnappi))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lisaysnappiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lisaysnappiActionPerformed
        solu.lisaaAine(luoAine());
        lisatytAineet.setText(lisatytAineet.getText() + nimiKentta.getText() + "\n");
        nimiKentta.setText("Aine" + (this.solu.getAineet().size() + 1));
    }//GEN-LAST:event_lisaysnappiActionPerformed

    private void lopetusnappiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lopetusnappiActionPerformed
        System.exit(0);
    }//GEN-LAST:event_lopetusnappiActionPerformed

    private void tuottoSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tuottoSliderStateChanged
        tuottoArvo.setText(tuottoSlider.getValue()+"");
    }//GEN-LAST:event_tuottoSliderStateChanged

    private void hajotusSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_hajotusSliderStateChanged
        hajotusArvo.setText(hajotusSlider.getValue()+"");
    }//GEN-LAST:event_hajotusSliderStateChanged

    private void kynnysSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_kynnysSliderStateChanged
        kynnysNro.setText(kynnysSlider.getValue()+"");
    }//GEN-LAST:event_kynnysSliderStateChanged

    private void valmisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valmisActionPerformed
        onkoNappiaPainettu = true;
    }//GEN-LAST:event_valmisActionPerformed

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
            java.util.logging.Logger.getLogger(Manuaalinen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manuaalinen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manuaalinen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manuaalinen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Manuaalinen().setVisible(true);
            }
        });
    }
    
    public boolean onkoValmis(){
        return this.onkoNappiaPainettu;
    }
    
    public Solu getSolu(){
        return this.solu;
    }
    
    private Aine luoAine(){
        String nimi = nimiKentta.getText();
        Boolean geeni = false;
        if (geeniPaalle.isSelected()){
            geeni = true;
        }
        double tuotto = (tuottoSlider.getValue()/100.0);
        double hajotus = (hajotusSlider.getValue()/100.0);
        double kynnys = (kynnysSlider.getValue()/100.0);
        Interaktio interaktio = Interaktio.EI;
        if (interaktioValinat.getSelectedIndex() == 1){
            interaktio = Interaktio.INHIBITIO;
        }else if (interaktioValinat.getSelectedIndex() == 2){
            interaktio = Interaktio.AKTIVAATIO;
        }
        return new Aine(nimi, geeni, false, tuotto, hajotus, kynnys, interaktio);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton geeniPaalle;
    private javax.swing.JRadioButton geeniPois;
    private javax.swing.JLabel geeniStatusLabel;
    private javax.swing.JLabel hajotusArvo;
    private javax.swing.JLabel hajotusLabel;
    private javax.swing.JSlider hajotusSlider;
    private javax.swing.JLabel interaktioLabel;
    private javax.swing.JComboBox interaktioValinat;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel kynnysLabel;
    private javax.swing.JLabel kynnysNro;
    private javax.swing.JSlider kynnysSlider;
    private javax.swing.JLabel lisatyt;
    private javax.swing.JTextArea lisatytAineet;
    private javax.swing.JButton lisaysnappi;
    private javax.swing.JButton lopetusnappi;
    private javax.swing.JFormattedTextField nimiKentta;
    private javax.swing.JLabel nimiLabel;
    private javax.swing.JLabel tuottoArvo;
    private javax.swing.JLabel tuottoLabel;
    private javax.swing.JSlider tuottoSlider;
    private javax.swing.JButton valmis;
    // End of variables declaration//GEN-END:variables
}