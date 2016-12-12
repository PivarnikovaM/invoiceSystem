/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.invoicesystem.forms;

import java.awt.Dialog;
import sk.upjs.invoicesystem.InvoiceTableModel;
import sk.upjs.invoicesystem.InvoicesList;
import sk.upjs.invoicesystem.InvoicesDao;
import sk.upjs.invoicesystem.ObjectFactory;

/**
 *
 * @author kriza
 */
public class InvoicesForm extends javax.swing.JDialog {

    private InvoicesDao invoicesDAO = ObjectFactory.INSTANCE.getInvoicesDao();

    /**
     * Creates new form InvoicesForm
     */
    public InvoicesForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        refreshInvoiceForm();
    }

    private void refreshInvoiceForm() {
        InvoiceTableModel model = (InvoiceTableModel) invoiceFormTable.getModel();
        model.refresh();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        deleteInvoicesButton = new javax.swing.JButton();
        createInvoiceButton = new javax.swing.JButton();
        updateInvoiceButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        invoiceFormTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Invoices");

        deleteInvoicesButton.setText("Delete invoices");
        deleteInvoicesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteInvoicesButtonActionPerformed(evt);
            }
        });

        createInvoiceButton.setText("Create invoice");
        createInvoiceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createInvoiceButtonActionPerformed(evt);
            }
        });

        updateInvoiceButton.setText("Update invoice");

        invoiceFormTable.setModel(new InvoiceTableModel());
        jScrollPane1.setViewportView(invoiceFormTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(deleteInvoicesButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(updateInvoiceButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(createInvoiceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteInvoicesButton)
                    .addComponent(createInvoiceButton)
                    .addComponent(updateInvoiceButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createInvoiceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createInvoiceButtonActionPerformed

    }//GEN-LAST:event_createInvoiceButtonActionPerformed

    private void deleteInvoicesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteInvoicesButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteInvoicesButtonActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(InvoicesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InvoicesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InvoicesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InvoicesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new InvoicesForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createInvoiceButton;
    private javax.swing.JButton deleteInvoicesButton;
    private javax.swing.JTable invoiceFormTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton updateInvoiceButton;
    // End of variables declaration//GEN-END:variables
}
