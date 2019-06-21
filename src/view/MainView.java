package view;

import javax.swing.JDesktopPane;

/**
 *
 * @author Arith Alexis Villalba Bravo
 * @date 2/05/2016
 * @time 11:15:29 AM
 */
public class MainView extends javax.swing.JFrame {

    /**
     * Creates new form MainView
     */
    public MainView() {
        initComponents();
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbMainView = new javax.swing.JToolBar();
        btnCustomers = new javax.swing.JButton();
        btnProducts = new javax.swing.JButton();
        btnBill = new javax.swing.JButton();
        dpMainView = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SISTEMA TIENDA LA FE");

        tbMainView.setRollover(true);

        btnCustomers.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btnCustomers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/customer.png"))); // NOI18N
        btnCustomers.setFocusable(false);
        btnCustomers.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCustomers.setLabel("Clientes");
        btnCustomers.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomersActionPerformed(evt);
            }
        });
        tbMainView.add(btnCustomers);

        btnProducts.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btnProducts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/prodducts.png"))); // NOI18N
        btnProducts.setText("Productos");
        btnProducts.setFocusable(false);
        btnProducts.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProducts.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductsActionPerformed(evt);
            }
        });
        tbMainView.add(btnProducts);

        btnBill.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btnBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/bill.png"))); // NOI18N
        btnBill.setText("Factura");
        btnBill.setFocusable(false);
        btnBill.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBill.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBillActionPerformed(evt);
            }
        });
        tbMainView.add(btnBill);

        javax.swing.GroupLayout dpMainViewLayout = new javax.swing.GroupLayout(dpMainView);
        dpMainView.setLayout(dpMainViewLayout);
        dpMainViewLayout.setHorizontalGroup(
            dpMainViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        dpMainViewLayout.setVerticalGroup(
            dpMainViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 331, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbMainView, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
            .addComponent(dpMainView)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tbMainView, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dpMainView))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JDesktopPane getDpMainView() {
        return dpMainView;
    }
    
    private void btnCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomersActionPerformed
        view.customer.CustomerView cv;
        cv = new view.customer.CustomerView();

        model.dao.CustomerDAO clienteDAO = new model.dao.CustomerDAO();

        new controller.CustomerController(cv, clienteDAO);

        dpMainView.add(cv);

        cv.show();
    }//GEN-LAST:event_btnCustomersActionPerformed

    private void btnProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductsActionPerformed
        view.product.ProductView pv;
        pv = new view.product.ProductView();

        model.dao.ProductDAO productDAO = new model.dao.ProductDAO();

        new controller.ProductContrller(productDAO, pv);

        dpMainView.add(pv);

        pv.show();
    }//GEN-LAST:event_btnProductsActionPerformed

    private void btnBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBillActionPerformed
        view.bill.Bill bill;
        bill = new view.bill.Bill();
        dpMainView.add(bill);
        bill.show();
    }//GEN-LAST:event_btnBillActionPerformed

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
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBill;
    private javax.swing.JButton btnCustomers;
    private javax.swing.JButton btnProducts;
    private javax.swing.JDesktopPane dpMainView;
    private javax.swing.JToolBar tbMainView;
    // End of variables declaration//GEN-END:variables
}
