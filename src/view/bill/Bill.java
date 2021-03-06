package view.bill;

import controller.clases.Msg;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.Calendar;
import javax.swing.table.DefaultTableModel;
import model.dao.CustomerDAO;
import model.dao.ProductDAO;
import model.dto.CustomerDTO;
import model.dto.ProductDTO;

/**
 *
 * @author Arith Alexis Villalba Bravo
 * @date 2/05/2016
 * @time 11:15:29 AM
 */
public class Bill extends javax.swing.JInternalFrame implements Printable{

    private DefaultTableModel model;
    private final ProductDAO prodao;
    private final CustomerDAO customer;
    private double total;

    /**
     * Creates new form Bill
     */
    public Bill() {
        initComponents();
        prodao = new ProductDAO();
        customer = new CustomerDAO();
        lblDate.setText(date());
        java.util.Random ram = new java.util.Random();
        lblIdBill.setText("" + ram.nextInt(9999));
        total = 0.0; 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlgProducts = new javax.swing.JDialog();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProducts = new javax.swing.JTable();
        lblTittleList = new javax.swing.JLabel();
        btnAdd2 = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        pnlMain = new javax.swing.JPanel();
        pnlTittle = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        pnlDatos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblIdBill = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lblCliente = new javax.swing.JLabel();
        pnlSalesProduct = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSales = new javax.swing.JTable();
        pnlTotal = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnSub = new javax.swing.JButton();
        btnPrinter = new javax.swing.JButton();

        tblProducts.setAutoCreateRowSorter(true);
        tblProducts.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "CODIGO", "NOMBRE", "PRESENTACION", "PRECIO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblProducts);

        lblTittleList.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTittleList.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTittleList.setText("Productos Registrados");

        btnAdd2.setText("AGREGAR");
        btnAdd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd2ActionPerformed(evt);
            }
        });

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel5.setText("CANTIDAD");

        txtCantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCantidad.setText("1");

        javax.swing.GroupLayout dlgProductsLayout = new javax.swing.GroupLayout(dlgProducts.getContentPane());
        dlgProducts.getContentPane().setLayout(dlgProductsLayout);
        dlgProductsLayout.setHorizontalGroup(
            dlgProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgProductsLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lblTittleList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(48, 48, 48))
            .addGroup(dlgProductsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dlgProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(dlgProductsLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(9, 9, 9)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnAdd2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dlgProductsLayout.setVerticalGroup(
            dlgProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgProductsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTittleList)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dlgProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd2)
                    .addComponent(btnEliminar)
                    .addComponent(jLabel5)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlTittle.setBorder(javax.swing.BorderFactory.createTitledBorder("Factura"));

        jLabel7.setFont(new java.awt.Font("Mistral", 0, 48)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Tienda La fe");

        javax.swing.GroupLayout pnlTittleLayout = new javax.swing.GroupLayout(pnlTittle);
        pnlTittle.setLayout(pnlTittleLayout);
        pnlTittleLayout.setHorizontalGroup(
            pnlTittleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTittleLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        pnlTittleLayout.setVerticalGroup(
            pnlTittleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTittleLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel7)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pnlMain.add(pnlTittle, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, -1, -1));

        pnlDatos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        pnlDatos.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel1.setText("Factura No.");
        pnlDatos.add(jLabel1);
        jLabel1.setBounds(10, 10, 88, 21);

        lblIdBill.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblIdBill.setText("00000");
        pnlDatos.add(lblIdBill);
        lblIdBill.setBounds(110, 10, 80, 21);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel3.setText("Fecha:");
        pnlDatos.add(jLabel3);
        jLabel3.setBounds(290, 10, 60, 21);

        lblDate.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblDate.setText("DD/MMM/AAAA");
        pnlDatos.add(lblDate);
        lblDate.setBounds(350, 10, 130, 21);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel2.setText("Cédula: ");
        pnlDatos.add(jLabel2);
        jLabel2.setBounds(10, 50, 64, 21);

        txtId.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txtId.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdKeyReleased(evt);
            }
        });
        pnlDatos.add(txtId);
        txtId.setBounds(80, 39, 100, 30);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel4.setText("Cliente:");
        pnlDatos.add(jLabel4);
        jLabel4.setBounds(210, 50, 59, 21);

        lblCliente.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        pnlDatos.add(lblCliente);
        lblCliente.setBounds(280, 40, 200, 30);

        pnlMain.add(pnlDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 125, 490, 80));

        pnlSalesProduct.setBorder(javax.swing.BorderFactory.createTitledBorder("Productos"));

        tblSales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cantidad", "Nombre Producto", "Presentacion", "Precio Unitario", "Subtotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblSales);

        javax.swing.GroupLayout pnlSalesProductLayout = new javax.swing.GroupLayout(pnlSalesProduct);
        pnlSalesProduct.setLayout(pnlSalesProductLayout);
        pnlSalesProductLayout.setHorizontalGroup(
            pnlSalesProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSalesProductLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlSalesProductLayout.setVerticalGroup(
            pnlSalesProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSalesProductLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pnlMain.add(pnlSalesProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 217, -1, -1));

        pnlTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel6.setText("TOTAL:");

        lblTotal.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        javax.swing.GroupLayout pnlTotalLayout = new javax.swing.GroupLayout(pnlTotal);
        pnlTotal.setLayout(pnlTotalLayout);
        pnlTotalLayout.setHorizontalGroup(
            pnlTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTotalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlTotalLayout.setVerticalGroup(
            pnlTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTotalLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(pnlTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pnlMain.add(pnlTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 385, 490, -1));

        getContentPane().add(pnlMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 480));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Agregar y Eliminar Productos"));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/quit.png"))); // NOI18N
        btnAdd.setText("AGREGAR");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnSub.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/add.png"))); // NOI18N
        btnSub.setText("ELIMINAR");
        btnSub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubActionPerformed(evt);
            }
        });

        btnPrinter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/print.png"))); // NOI18N
        btnPrinter.setText("IMPRIMIR");
        btnPrinter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrinterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnAdd)
                .addGap(18, 18, 18)
                .addComponent(btnSub)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(btnPrinter)
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnSub)
                    .addComponent(btnPrinter))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 490, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAdd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd2ActionPerformed
        int selectedRow = tblProducts.getSelectedRow();

        try {
            String codigo, nombre, presentacion, precio, cantidad;
            double calcular = 0.0, x = 0.0;
            if (selectedRow == -1) {
                Msg.selectEntry(this);
            } else {
                //model = (DefaultTableModel) tblProducts.getModel();
                codigo = tblProducts.getValueAt(selectedRow, 0).toString();
                nombre = tblProducts.getValueAt(selectedRow, 1).toString();
                presentacion = tblProducts.getValueAt(selectedRow, 2).toString();
                precio = tblProducts.getValueAt(selectedRow, 3).toString();
                cantidad = txtCantidad.getText();

                x = Double.parseDouble(precio) * Integer.parseInt(cantidad);
                String subT = String.valueOf(x);
                model = (DefaultTableModel) tblSales.getModel();
                String elements[] = {cantidad, nombre, presentacion, precio, subT};
                model.addRow(elements);

                calcular = Double.parseDouble(precio) * Integer.parseInt(cantidad);
                this.total += calcular;
                lblTotal.setText("" + this.total);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnAdd2ActionPerformed

    private void txtIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyReleased
        java.util.ArrayList<CustomerDTO> cliente = new java.util.ArrayList<>();
        cliente = (java.util.ArrayList<CustomerDTO>) customer.find("cedula",
            txtId.getText());
        int id = Integer.parseInt(txtId.getText());
        if (cliente.size() == 1 && id == cliente.get(0).getId()) {
            String custome;
            custome = cliente.get(0).getNombre() + " " + cliente.get(0).getApellido();
            lblCliente.setText(custome);
        } else {
            lblCliente.setText("");
        }
    }//GEN-LAST:event_txtIdKeyReleased

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        fillTable(tblProducts, (java.util.ArrayList<ProductDTO>) prodao.readAll());
        dlgProducts.setSize(639, 340);
        dlgProducts.setLocationRelativeTo(this);
        dlgProducts.setModal(true);
        dlgProducts.setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubActionPerformed
        int selectedRow = tblSales.getSelectedRow();
        if (selectedRow == -1) {
            Msg.selectEntry(this);
        } else {
            model = (DefaultTableModel) tblSales.getModel();
            String precio = tblSales.getValueAt(tblSales.getSelectedRow(), 4).toString();
            model.removeRow(tblSales.getSelectedRow());
            total -= Double.parseDouble(precio);
            lblTotal.setText("" + this.total);
        }
    }//GEN-LAST:event_btnSubActionPerformed

    private void btnPrinterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrinterActionPerformed
        try {
            PrinterJob pj = PrinterJob.getPrinterJob();
            pj.setPrintable(this);
            boolean top = pj.printDialog();
            if (top) {
                pj.print();
            }
        } catch (HeadlessException | PrinterException e) {
        }
    }//GEN-LAST:event_btnPrinterActionPerformed

    private String date() {
        String[] months = {"ENE", "FEB", "MAR", "ABR", "MAY", "JUN", "JUL", "AGO",
            "SEP", "OCT", "NOV", "DIC"};
        java.util.Calendar calendar;
        calendar = java.util.GregorianCalendar.getInstance();
        int dia = calendar.get(Calendar.DATE);
        int mes = calendar.get(Calendar.MONTH);
        int anio = calendar.get(Calendar.YEAR);
        return "" + dia + "/" + months[mes - 1] + "/" + anio;
    }

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAdd2;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnPrinter;
    private javax.swing.JButton btnSub;
    private javax.swing.JDialog dlgProducts;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblIdBill;
    private javax.swing.JLabel lblTittleList;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel pnlDatos;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlSalesProduct;
    private javax.swing.JPanel pnlTittle;
    private javax.swing.JPanel pnlTotal;
    private javax.swing.JTable tblProducts;
    private javax.swing.JTable tblSales;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) { 
            return NO_SUCH_PAGE;
        }
        
        Graphics2D print = (Graphics2D) graphics;
        print.translate(pageFormat.getImageableX() + 30, pageFormat.getImageableY() + 30);
        print.scale(0.5, 0.5);
        
        pnlMain.printAll(graphics);
        
        return PAGE_EXISTS;
    }
}
