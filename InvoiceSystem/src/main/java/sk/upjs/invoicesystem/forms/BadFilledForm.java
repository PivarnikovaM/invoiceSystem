/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.invoicesystem.forms;

/**
 *
 * @author kriza
 */
public class BadFilledForm extends javax.swing.JDialog {

    /**
     * Creates new form BadFilled
     */
    public BadFilledForm(javax.swing.JDialog parent, boolean modal, String errorMessage) {
        super(parent, modal);
        
        initComponents();
        setLocationRelativeTo(parent);
        this.errorMessage.setText(errorMessage);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        errorMessage = new javax.swing.JLabel();
        OKButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(327, 95));
        setMinimumSize(new java.awt.Dimension(327, 95));
        setPreferredSize(new java.awt.Dimension(327, 95));
        getContentPane().setLayout(null);

        errorMessage.setFont(new java.awt.Font("Alegreya", 2, 14)); // NOI18N
        errorMessage.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(errorMessage);
        errorMessage.setBounds(6, 6, 304, 20);

        OKButton.setFont(new java.awt.Font("Alegreya", 3, 14)); // NOI18N
        OKButton.setForeground(new java.awt.Color(0, 51, 153));
        OKButton.setText("OK");
        OKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKButtonActionPerformed(evt);
            }
        });
        getContentPane().add(OKButton);
        OKButton.setBounds(235, 54, 75, 29);

        jLabel1.setIcon(new javax.swing.ImageIcon("/Users/martinapivarnikova/Downloads/Large_UL-877.jpg")); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-12, -5, 340, 100);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKButtonActionPerformed
        this.dispose();    }//GEN-LAST:event_OKButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton OKButton;
    private javax.swing.JLabel errorMessage;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
