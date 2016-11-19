/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.invoicesystem.forms;

import sk.upjs.invoicesystem.InvoiceTableModel;
import sk.upjs.invoicesystem.InvoicesDao;
import sk.upjs.invoicesystem.InvoicesList;

/**
 *
 * @author kriza
 */
public class MenuForm extends javax.swing.JFrame {

    private InvoicesDao invoicesDAO = InvoicesList.INSTANCE;

    /**
     * Creates new form Menu
     */
    public MenuForm() {
        initComponents();

        refreshMenuForm();
    }

    private void refreshMenuForm() {
        InvoiceTableModel model = (InvoiceTableModel) lastInvoicesTable.getModel();
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

        showCompanies = new javax.swing.JButton();
        showAllInvoices = new javax.swing.JButton();
        createInvoice = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lastInvoicesTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Invoice System");

        showCompanies.setText("Show all companies");
        showCompanies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showCompaniesActionPerformed(evt);
            }
        });

        showAllInvoices.setText("Show all invoices");
        showAllInvoices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showAllInvoicesActionPerformed(evt);
            }
        });

        createInvoice.setText("Create invoice");
        createInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createInvoiceActionPerformed(evt);
            }
        });

        lastInvoicesTable.setModel(new InvoiceTableModel());
        jScrollPane2.setViewportView(lastInvoicesTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(showCompanies)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(showAllInvoices, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(createInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showCompanies)
                    .addComponent(showAllInvoices))
                .addGap(18, 18, 18)
                .addComponent(createInvoice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showAllInvoicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showAllInvoicesActionPerformed
        new InvoicesForm().setVisible(true);
    }//GEN-LAST:event_showAllInvoicesActionPerformed

    private void createInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createInvoiceActionPerformed
        new CreateInvoiceForm(this).setVisible(true);
    }//GEN-LAST:event_createInvoiceActionPerformed

    private void showCompaniesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showCompaniesActionPerformed
        new CompaniesForm().setVisible(true);
    }//GEN-LAST:event_showCompaniesActionPerformed

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
            java.util.logging.Logger.getLogger(MenuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createInvoice;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable lastInvoicesTable;
    private javax.swing.JButton showAllInvoices;
    private javax.swing.JButton showCompanies;
    // End of variables declaration//GEN-END:variables
}
