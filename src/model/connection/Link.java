package model.connection ;

/**
 *
 * @author Arith Alexis Villalba Bravo
 * @date 28/04/2016
 * @time 03:43:13 PM
 */
public class Link {

    private static Link conexion;

    private java.sql.Connection connection;

    // constructor privado para no crear objetos de esta clase
    private Link() {

        try {

            // carga la clase controlador
            Class.forName(Setup.CONTROLADOR);

            // establece la conexion de la base de datos
            connection = java.sql.DriverManager.getConnection(Setup.URL_BASEDATOS,
                    Setup.USUARIO, Setup.PASSWORD);

            System.out.println("Conexión exitosa");

        } catch (java.sql.SQLException | ClassNotFoundException e) {
            System.out.println("Error en la conexión: " + e.getMessage());
        }
    }

    // sincronizado para protegerse de posibles problemas  multi-hilo
    public synchronized static Link connect() {

        if (conexion == null) {
            conexion = new Link();
        }
        return conexion;
    }

    public java.sql.Connection getConnection() {

        return connection;
    }

    public void closeConnection() {

        try {

            connection.close();

            System.out.println("Conexión cerrada");

        } catch (java.lang.NullPointerException | java.sql.SQLException e) {

            System.out.println("Error al cerrar conexión: " + e.getMessage());
        }

    }

}
