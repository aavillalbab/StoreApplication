package controller.clases;

/**
 *
 * @author Arith Alexis Villalba Bravo
 * @date 10/05/2016
 * @time 10:31:46 PM
 */
public class Validate {

    public static boolean isInteger(java.awt.event.KeyEvent ke) {
        char c = ke.getKeyChar();
        return Character.isDigit(c)
                || java.awt.event.KeyEvent.VK_BACK_SPACE == c
                || java.awt.event.KeyEvent.VK_ENTER == c;
    }

    public static void dropTxtField(javax.swing.JPanel panel) {
        for (java.awt.Component component : panel.getComponents()) {
            
            if (component instanceof javax.swing.JTextField) {
                
                ((javax.swing.JTextField) component).setText(null);
                
                ((javax.swing.JTextField) component).setBorder(
                        new javax.swing.border.LineBorder(
                                java.awt.Color.lightGray));
            }
        }
    }

    public static void droplabel(javax.swing.JPanel panel) {
        for (java.awt.Component component : panel.getComponents()) {
            if (component instanceof javax.swing.JLabel) {
                ((javax.swing.JLabel) component).setIcon(null);
            }
        }
    }

    public static boolean checkFields(javax.swing.JTextField[] tf,
            javax.swing.JLabel[] lbl) {
        for (int i = 0; i < tf.length; i++) {
            if (tf[i].getText().isEmpty()) {
                tf[i].setBorder(new javax.swing.border.LineBorder(
                        java.awt.Color.YELLOW));
                lbl[i].setIcon(new javax.swing.ImageIcon(
                        "src/view/images/warning.png"));
                lbl[i].setToolTipText("Campo obligatorio");
                tf[i].requestFocus();
                return true;
            }
            lbl[i].setIcon(new javax.swing.ImageIcon("src/view/images/ok.png"));
            tf[i].setBorder(new javax.swing.border.LineBorder(
                    java.awt.Color.BLUE));
        }
        return false;
    }

}
