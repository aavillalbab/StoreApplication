package controller;

import controller.clases.Msg;
import controller.clases.Validate;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import model.dao.ProductDAO;
import model.dto.ProductDTO;
import view.product.ProductView;

/**
 *
 * @author Arith Alexis Villalba Bravo
 * @date 2/05/2016
 * @time 12:15:29 AM
 */
public class ProductContrller implements java.awt.event.ActionListener,
        java.awt.event.KeyListener {

    private final ProductDAO prodao;
    private final view.product.ProductView pv;
    private final javax.swing.JTextField[] tf;
    private final javax.swing.JLabel[] lbl;

    public ProductContrller(ProductDAO prodao, ProductView pv) {
        this.prodao = prodao;
        this.pv = pv;
        tf = new javax.swing.JTextField[]{pv.getTxtId(), pv.getTxtName(),
            pv.getTxAmount(), pv.getTxtPrice()};
        lbl = new javax.swing.JLabel[]{pv.getLblWarning(), pv.getLblWarning1(),
            pv.getLblWarning2(), pv.getLblWarning3()};
        initEvents();
    }

    // inicializar eventos de botones
    private void initEvents() {
        pv.getBtnList().addActionListener(this);
        pv.getTxtFind().addKeyListener(this);
        pv.getTxtId().addKeyListener(this);
        pv.getTxtName().addKeyListener(this);
        pv.getTxAmount().addKeyListener(this);
        pv.getTxtPrice().addKeyListener(this);
        pv.getBtnRegister().addActionListener(this);
        pv.getBtnRegister2().addActionListener(this);
        pv.getBtnUpdate().addActionListener(this);
        pv.getBtnUpdate2().addActionListener(this);
        pv.getBtnDelete().addActionListener(this);
    }

    // habilta el panel de actualización
    private void enableUpdatePnl() {
        pv.getTxtId().requestFocus();
        pv.getPnlRegister().setVisible(true);
        pv.getPnlCustomers().setVisible(false);
        pv.getLblTittleRegister().setText("Actualizar Productos");
        pv.getBtnUpdate2().setVisible(true);
        pv.getBtnRegister2().setVisible(false);
        pv.getTxtId().setEnabled(false);
        Validate.dropTxtField(pv.getPnlRegister());
        Validate.droplabel(pv.getPnlRegister());
    }

    // habilita el panel de registro
    private void enableRegisterPnl() {
        pv.getTxtId().requestFocus();
        pv.getPnlRegister().setVisible(true);
        pv.getPnlCustomers().setVisible(false);
        pv.getLblTittleRegister().setText("Registrar Productos");
        pv.getBtnRegister2().setVisible(true);
        pv.getBtnUpdate2().setVisible(false);
        pv.getTxtId().setEnabled(true);
        Validate.dropTxtField(pv.getPnlRegister());
        Validate.droplabel(pv.getPnlRegister());
    }

    private void noValidateNumber(java.awt.event.KeyEvent ke) {

        if (ke.getSource() == pv.getTxtId()) {
            pv.getTxtId().setBorder(new javax.swing.border.LineBorder(
                    java.awt.Color.RED));
            pv.getLblWarning().setIcon(new javax.swing.ImageIcon(
                    "src/view/images/no.png"));
            pv.getLblWarning().setToolTipText("Ingrese sólo números");
        }
        if (ke.getSource() == pv.getTxtPrice()) {
            pv.getTxtPrice().setBorder(new javax.swing.border.LineBorder(
                    java.awt.Color.RED));
            pv.getLblWarning3().setIcon(new javax.swing.ImageIcon(
                    "src/view/images/no.png"));
            pv.getLblWarning3().setToolTipText("Ingrese sólo números");
        }

    }

    private void isValidateNumber(java.awt.event.KeyEvent ke) {
        if (ke.getSource() == pv.getTxtId()) {
            pv.getTxtId().setBorder(new javax.swing.border.LineBorder(
                    java.awt.Color.GRAY));
            pv.getLblWarning().setIcon(new javax.swing.ImageIcon(
                    "src/view/images/ok.png"));
        }
        if (ke.getSource() == pv.getTxtPrice()) {
            pv.getTxtPrice().setBorder(new javax.swing.border.LineBorder(
                    java.awt.Color.GRAY));
            pv.getLblWarning3().setIcon(new javax.swing.ImageIcon(
                    "src/view/images/ok.png"));
        }
    }

    // obtiene los datos de los campos de texto y crea un objeto ProductDTO
    private ProductDTO getProductDTO() {
        ProductDTO pdto;
        int id = Integer.parseInt(pv.getTxtId().getText());
        String name = pv.getTxtName().getText();
        String amount = pv.getTxAmount().getText();
        double price = Double.parseDouble(pv.getTxtPrice().getText());

        pdto = new ProductDTO(id, name, amount, price);

        return pdto;
    }

    // llena los campos de texto con los datos de la tabla de clientes
    private void fillTextField() {
        int i = pv.getTableProducts().getSelectedRow();
        System.out.println(i);
        if (i >= 0) {
            pv.getTxtId().setText(""
                    + pv.getTableProducts().getValueAt(i, 0));
            pv.getTxtName().setText(""
                    + pv.getTableProducts().getValueAt(i, 1));
            pv.getTxAmount().setText(""
                    + pv.getTableProducts().getValueAt(i, 2));
            pv.getTxtPrice().setText(""
                    + pv.getTableProducts().getValueAt(i, 3));
        }
    }

    // la tabla clientes con los datos obtenidos de la DDBB
    private void fillTable(javax.swing.JTable tabla,
            java.util.ArrayList<ProductDTO> productDTOs) {

        javax.swing.table.DefaultTableModel modelo;
        modelo = new javax.swing.table.DefaultTableModel();
        tabla.setModel(modelo);

        modelo.addColumn("Código");
        modelo.addColumn("Nombre");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio");

        Object[] columna = new Object[4];

        for (int i = 0; i < productDTOs.size(); i++) {
            columna[0] = productDTOs.get(i).getId();
            columna[1] = productDTOs.get(i).getName();
            columna[2] = productDTOs.get(i).getAmount();
            columna[3] = productDTOs.get(i).getPrice();

            modelo.addRow(columna);
        }

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        // Obtener lista de clientes
        if (ae.getSource() == pv.getBtnList()) {

            pv.getPnlCustomers().setVisible(true);
            pv.getPnlRegister().setVisible(false);

            fillTable(pv.getTableProducts(),
                    (java.util.ArrayList<ProductDTO>) this.prodao.readAll());
        }

        // Habilitar panel de registro de cliente
        if (ae.getSource() == pv.getBtnRegister()) {
            enableRegisterPnl();
        }

        // Registra cliente
        if (ae.getSource() == pv.getBtnRegister2()) {
            if (!Validate.checkFields(tf, lbl)) {
                prodao.create(getProductDTO());
                pv.getBtnList().doClick();
                Msg.newRecord(pv);
            }
        }

        // Habilita panel de actualizacion de clientes
        if (ae.getSource() == pv.getBtnUpdate()) {

            int i = pv.getTableProducts().getSelectedRow();

            if (i >= 0) {
                enableUpdatePnl();
                fillTextField();
                return;
            }
            Msg.selectEntry(pv);
            pv.getBtnList().doClick();
        }

        // Actualiza datos de cliente
        if (ae.getSource() == pv.getBtnUpdate2()) {
            if (!Validate.checkFields(tf, lbl)) {
                boolean comp;
                comp = prodao.update(getProductDTO());
                if (comp) {
                    Validate.dropTxtField(pv.getPnlRegister());
                    pv.getBtnList().doClick();
                    Msg.updateRecord(pv);
                }
            }
        }

        // Eliminar Cliente
        if (ae.getSource() == pv.getBtnDelete()) {

            int i = pv.getTableProducts().getSelectedRow();

            if (i >= 0) {
                if (Msg.confirmAction(pv) == 0) {
                    int cedula = (int) pv.getTableProducts().getValueAt(i, 0);
                    boolean comp;
                    comp = prodao.delete(cedula);
                    if (comp) {
                        fillTable(pv.getTableProducts(),
                                (java.util.ArrayList<ProductDTO>) this.prodao
                                .readAll());
                        Msg.deleteRecord(pv);
                    }
                }
                return;
            }
            Msg.selectEntry(pv);
            pv.getBtnList().doClick();
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        if (ke.getSource() == pv.getTxtId() || ke.getSource() == pv
                .getTxtPrice()) {
            if (!Validate.isInteger(ke)) {
                noValidateNumber(ke);
                ke.consume();
            } else {
                isValidateNumber(ke);
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {

        // Registra cliente
        if (ke.getSource() == pv.getTxtId()
                || ke.getSource() == pv.getTxtName()
                || ke.getSource() == pv.getTxAmount()
                || ke.getSource() == pv.getTxtPrice()) {

            if (ke.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER) {
                pv.getBtnRegister2().doClick();
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent ke) {

        if (ke.getSource() == pv.getTxtFind()) {
            // obtener el valor del campo de texto y del combo box
            String column = pv.getCbProducts().getSelectedItem().toString();
            String value = pv.getTxtFind().getText();
            fillTable(pv.getTableProducts(),
                    (java.util.ArrayList<ProductDTO>) this.prodao.find(column,
                            value));
        }
    }

}
