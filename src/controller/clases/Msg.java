package controller.clases;

/**
 *
 * @author Arith Alexis Villalba Bravo
 * @date 13/05/2016
 * @time 11:19:22 PM
 */
public class Msg {

    public static int confirmAction(java.awt.Component view) {

        return javax.swing.JOptionPane.showConfirmDialog(
                view, // ventana a quien se aplica
                "Desea eliminar este registro?", // mensaje
                "Advertencia", // titulo
                javax.swing.JOptionPane.YES_NO_OPTION,
                javax.swing.JOptionPane.WARNING_MESSAGE,
                new javax.swing.ImageIcon("src/view/images/warning.png"));

    }

    public static void selectEntry(java.awt.Component view) {
        javax.swing.JOptionPane.showMessageDialog(
                view,
                "Seleccione un registro",
                "Información",
                javax.swing.JOptionPane.INFORMATION_MESSAGE,
                new javax.swing.ImageIcon("src/view/images/bulb.png"));
    }

    public static void deleteRecord(java.awt.Component view) {
        javax.swing.JOptionPane.showMessageDialog(
                view,
                "Registro eliminado",
                "Información",
                javax.swing.JOptionPane.INFORMATION_MESSAGE,
                new javax.swing.ImageIcon("src/view/images/delete.png"));
    }

    public static void newRecord(java.awt.Component view) {
        javax.swing.JOptionPane.showMessageDialog(
                view,
                "Registro guardado",
                "Información",
                javax.swing.JOptionPane.INFORMATION_MESSAGE,
                new javax.swing.ImageIcon("src/view/images/save.png"));
    }

    public static void updateRecord(java.awt.Component view) {
        javax.swing.JOptionPane.showMessageDialog(
                view,
                "Registro actualizado",
                "Información",
                javax.swing.JOptionPane.INFORMATION_MESSAGE,
                new javax.swing.ImageIcon("src/view/images/update.png"));
    }
}
