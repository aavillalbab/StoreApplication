package controller;

import controller.clases.Msg;
import controller.clases.Validate;
import model.dao.CustomerDAO;
import model.dto.CustomerDTO;

/**
 *
 * @author Arith Alexis Villalba Bravo
 * @date 2/05/2016
 * @time 12:15:29 AM
 */
public class CustomerController implements java.awt.event.ActionListener,
        java.awt.event.KeyListener {

    private final view.customer.CustomerView cv;
    private final CustomerDAO cdao;
    private final javax.swing.JTextField[] tf;
    private final javax.swing.JLabel[] lbl;

    /**
     * constructor CustomerController
     *
     * @param cv Objeto ProductView representa la GUI de acceso a datos de
     * clientes
     * @param cdao Objeto CustomerDAO
     */
    public CustomerController(view.customer.CustomerView cv, CustomerDAO cdao) {
        this.cv = cv;
        this.cdao = cdao;
        tf = new javax.swing.JTextField[]{cv.getTxtId(), cv.getTxtName(),
            cv.getTxtLastName(), cv.getTxtAddress(), cv.getTxtTelephone()};
        lbl = new javax.swing.JLabel[]{cv.getLblWarning(), cv.getLblWarning1(),
            cv.getLblWarning2(), cv.getLblWarning3(), cv.getLblWarning4()};
        initEvents();

    }

    // inicializar eventos de botones
    private void initEvents() {
        cv.getBtnList().addActionListener(this);
        cv.getTxtFind().addKeyListener(this);
        cv.getTxtId().addKeyListener(this);
        cv.getTxtName().addKeyListener(this);
        cv.getTxtLastName().addKeyListener(this);
        cv.getTxtAddress().addKeyListener(this);
        cv.getTxtTelephone().addKeyListener(this);
        cv.getBtnRegister().addActionListener(this);
        cv.getBtnRegister2().addActionListener(this);
        cv.getBtnUpdate().addActionListener(this);
        cv.getBtnUpdate2().addActionListener(this);
        cv.getBtnDelete().addActionListener(this);
    }

    // habilta el panel de actualización
    private void enableUpdatePnl() {
        cv.getTxtId().requestFocus();
        cv.getPnlRegister().setVisible(true);
        cv.getPnlCustomers().setVisible(false);
        cv.getLblTittleRegister().setText("Actualizar Clientes");
        cv.getBtnUpdate2().setVisible(true);
        cv.getBtnRegister2().setVisible(false);
        cv.getTxtId().setEnabled(false);
        Validate.dropTxtField(cv.getPnlRegister());
        Validate.droplabel(cv.getPnlRegister());
    }

    // habilita el panel de registro
    private void enableRegisterPnl() {
        cv.getTxtId().requestFocus();
        cv.getPnlRegister().setVisible(true);
        cv.getPnlCustomers().setVisible(false);
        cv.getLblTittleRegister().setText("Registrar Clientes");
        cv.getBtnRegister2().setVisible(true);
        cv.getBtnUpdate2().setVisible(false);
        cv.getTxtId().setEnabled(true);
        Validate.dropTxtField(cv.getPnlRegister());
        Validate.droplabel(cv.getPnlRegister());
    }

    private void noValidateNumber(java.awt.event.KeyEvent ke) {

        if (ke.getSource() == cv.getTxtId()) {
            cv.getTxtId().setBorder(new javax.swing.border.LineBorder(
                    java.awt.Color.RED));
            cv.getLblWarning().setIcon(new javax.swing.ImageIcon(
                    "src/view/images/no.png"));
            cv.getLblWarning().setToolTipText("Ingrese sólo números");
        }
        if (ke.getSource() == cv.getTxtTelephone()) {
            cv.getTxtTelephone().setBorder(new javax.swing.border.LineBorder(
                    java.awt.Color.RED));
            cv.getLblWarning4().setIcon(new javax.swing.ImageIcon(
                    "src/view/images/no.png"));
            cv.getLblWarning4().setToolTipText("Ingrese sólo números");
        }

    }

    private void isValidateNumber(java.awt.event.KeyEvent ke) {
        if (ke.getSource() == cv.getTxtId()) {
            cv.getTxtId().setBorder(new javax.swing.border.LineBorder(
                    java.awt.Color.GRAY));
            cv.getLblWarning().setIcon(new javax.swing.ImageIcon(
                    "src/view/images/ok.png"));
        }
        if (ke.getSource() == cv.getTxtTelephone()) {
            cv.getTxtTelephone().setBorder(new javax.swing.border.LineBorder(
                    java.awt.Color.GRAY));
            cv.getLblWarning4().setIcon(new javax.swing.ImageIcon(
                    "src/view/images/ok.png"));
        }
    }

    // obtiene los datos de los campos de texto y crea un objeto clienteDTO
    private CustomerDTO getCustomerDTO() {
        CustomerDTO cdto;
        long id = Long.parseLong(cv.getTxtId().getText());
        String name = cv.getTxtName().getText();
        String lastName = cv.getTxtLastName().getText();
        String address = cv.getTxtAddress().getText();
        long telephone = Long.parseLong(cv.getTxtTelephone().getText());
        cdto = new CustomerDTO(id, name, lastName, address, telephone);
        return cdto;
    }

    // llena los campos de texto con los datos de la tabla de clientes
    private void fillTextField() {
        int i = cv.getTableCustomers().getSelectedRow();
        System.out.println(i);
        if (i >= 0) {
            cv.getTxtId().setText(""
                    + cv.getTableCustomers().getValueAt(i, 0));
            cv.getTxtName().setText(""
                    + cv.getTableCustomers().getValueAt(i, 1));
            cv.getTxtLastName().setText(""
                    + cv.getTableCustomers().getValueAt(i, 2));
            cv.getTxtAddress().setText(""
                    + cv.getTableCustomers().getValueAt(i, 3));
            cv.getTxtTelephone().setText(""
                    + cv.getTableCustomers().getValueAt(i, 4));
        }
    }

    // la tabla clientes con los datos obtenidos de la DDBB
    private void fillTable(javax.swing.JTable tabla,
            java.util.ArrayList<CustomerDTO> clienteDTOs) {

        javax.swing.table.DefaultTableModel modelo;
        modelo = new javax.swing.table.DefaultTableModel();
        tabla.setModel(modelo);

        modelo.addColumn("Cédula");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Dirección");
        modelo.addColumn("Teléfono");

        Object[] columna = new Object[5];

        for (CustomerDTO clienteDTO : clienteDTOs) {
            columna[0] = clienteDTO.getId();
            columna[1] = clienteDTO.getNombre();
            columna[2] = clienteDTO.getApellido();
            columna[3] = clienteDTO.getDireccion();
            columna[4] = clienteDTO.getTelefono();
            modelo.addRow(columna);
        }
    }

    // eventos a realizar por la GUI clientes
    @Override
    public void actionPerformed(java.awt.event.ActionEvent ae) {

        // Obtener lista de clientes
        if (ae.getSource() == cv.getBtnList()) {

            cv.getPnlCustomers().setVisible(true);
            cv.getPnlRegister().setVisible(false);

            fillTable(cv.getTableCustomers(),
                    (java.util.ArrayList<CustomerDTO>) this.cdao.readAll());
        }

        // Habilitar panel de registro de cliente
        if (ae.getSource() == cv.getBtnRegister()) {
            enableRegisterPnl();
        }

        // Registra cliente
        if (ae.getSource() == cv.getBtnRegister2()) {
            if (!Validate.checkFields(tf, lbl)) {
                cdao.create(getCustomerDTO());
                cv.getBtnList().doClick();
                Msg.newRecord(cv);
            }
        }

        // Habilita panel de actualizacion de clientes
        if (ae.getSource() == cv.getBtnUpdate()) {

            int i = cv.getTableCustomers().getSelectedRow();

            if (i >= 0) {
                enableUpdatePnl();
                fillTextField();
                return;
            }
            Msg.selectEntry(cv);
            cv.getBtnList().doClick();
        }

        // Actualiza datos de cliente
        if (ae.getSource() == cv.getBtnUpdate2()) {
            if (!Validate.checkFields(tf, lbl)) {
                boolean comp;
                comp = cdao.update(getCustomerDTO());
                if (comp) {
                    Validate.dropTxtField(cv.getPnlRegister());
                    cv.getBtnList().doClick();
                    Msg.updateRecord(cv);
                }
            }
        }

        // Eliminar Cliente
        if (ae.getSource() == cv.getBtnDelete()) {

            int i = cv.getTableCustomers().getSelectedRow();

            if (i >= 0) {
                if (Msg.confirmAction(cv) == 0) {
                    long cedula = (long) cv.getTableCustomers().getValueAt(i, 0);
                    boolean comp;
                    comp = cdao.delete(cedula);
                    if (comp) {
                        fillTable(cv.getTableCustomers(),
                                (java.util.ArrayList<CustomerDTO>) this.cdao
                                .readAll());
                        Msg.deleteRecord(cv);
                    }
                }
                return;
            }
            Msg.selectEntry(cv);
            cv.getBtnList().doClick();
        }
    }

    @Override
    public void keyTyped(java.awt.event.KeyEvent ke) {

        if (ke.getSource() == cv.getTxtId() || ke.getSource() == cv
                .getTxtTelephone()) {
            if (!Validate.isInteger(ke)) {
                noValidateNumber(ke);
                ke.consume();
            } else {
                isValidateNumber(ke);
            }
        }
    }

    @Override
    public void keyPressed(java.awt.event.KeyEvent ke) {
        // Registra cliente
        if (ke.getSource() == cv.getTxtId() || ke.getSource() == cv.getTxtName()
                || ke.getSource() == cv.getTxtLastName()
                || ke.getSource() == cv.getTxtAddress()
                || ke.getSource() == cv.getTxtTelephone()) {
            if (ke.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER) {
                cv.getBtnRegister2().doClick();
            }
        }
    }

    @Override
    public void keyReleased(java.awt.event.KeyEvent ke) {

        if (ke.getSource() == cv.getTxtFind()) {
            // obtener el valor del campo de texto y del combo box
            String column = cv.getCbCustomers().getSelectedItem().toString();
            String value = cv.getTxtFind().getText();
            fillTable(cv.getTableCustomers(),
                    (java.util.ArrayList<CustomerDTO>) this.cdao.find(column,
                            value));
        }
    }

}
