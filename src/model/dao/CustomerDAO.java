package model.dao;

import java.util.List;
import model.connection.Link;
import model.dto.CustomerDTO;

/**
 *
 * @author Arith Alexis Villalba Bravo
 * @date 29/04/2016
 * @time 12:13:27 AM
 */
public class CustomerDAO implements interfaces.Crud<CustomerDTO> {

    private static final String SQL_CREATE = "INSERT INTO clientes "
            + "VALUES (?, ?, ?, ?, ?)";

    private static final String SQL_READ = "SELECT *FROM clientes WHERE cedula = ?";

    private static final String SQL_UPDATE = "UPDATE clientes SET nombre = ?,"
            + "apellido = ?, direccion = ?, telefono = ? WHERE cedula = ?";

    private static final String SQL_DELETE = "DELETE FROM clientes WHERE cedula = ?";

    private static final String SQL_READALL = "SELECT *FROM clientes";

    public static final Link CONN = Link.connect();

    @Override
    public boolean create(CustomerDTO customer) {

        java.sql.PreparedStatement ps;

        try {

            ps = CONN.getConnection().prepareStatement(SQL_CREATE);
            
            ps.setLong(1, customer.getId());
            ps.setString(2, customer.getNombre());
            ps.setString(3, customer.getApellido());
            ps.setString(4, customer.getDireccion());
            ps.setLong(5, customer.getTelefono());

            if (ps.executeUpdate() > 0) {
                return true;
            }

        } catch (java.lang.NullPointerException | java.sql.SQLException ex) {
            System.out.println("error " + ex.getMessage());
        } finally {
//            CONN.closeConnection();
        }

        return false;
    }

    @Override
    public CustomerDTO read(Object key) {

        CustomerDTO customer = null;
        java.sql.PreparedStatement ps;
        java.sql.ResultSet rs;

        try {

            ps = CONN.getConnection().prepareStatement(SQL_READ);
            ps.setLong(1, (int) Long.parseLong(key.toString()));
            rs = ps.executeQuery();

            while (rs.next()) {
                customer = new CustomerDTO(rs.getLong(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getLong(5));
            }

            return customer;

        } catch (java.lang.NullPointerException | java.sql.SQLException ex) {
            System.out.println("error " + ex.getMessage());
        } finally {
//            CONN.closeConnection();
        }

        return customer;
    }

    @Override
    public boolean update(CustomerDTO cliente) {
        java.sql.PreparedStatement ps;

        try {
            ps = CONN.getConnection().prepareStatement(SQL_UPDATE);

            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getDireccion());
            ps.setLong(4, cliente.getTelefono());
            ps.setLong(5, cliente.getId());

            if (ps.executeUpdate() > 0) {
                return true;
            }

        } catch (java.lang.NullPointerException | java.sql.SQLException ex) {
            System.out.println("error" + ex);
        } finally {
//            CONN.closeConnection();
        }

        return false;
    }

    @Override
    public boolean delete(Object key) {

        java.sql.PreparedStatement ps;

        try {
            ps = CONN.getConnection().prepareStatement(SQL_DELETE);

            ps.setLong(1, (int) Long.parseLong(key.toString()));

            if (ps.executeUpdate() > 0) {
                return true;
            }

        } catch (java.lang.NullPointerException | java.sql.SQLException ex) {
            System.out.println("error " + ex.getMessage());
        } finally {
//            CONN.closeConnection();
        }

        return false;
    }

    @Override
    public java.util.List<CustomerDTO> readAll() {

        java.sql.PreparedStatement ps;
        java.sql.ResultSet rs;
        java.util.ArrayList<CustomerDTO> clienteDTOs = new java.util.ArrayList<>();

        try {

            ps = CONN.getConnection().prepareStatement(SQL_READALL);

            rs = ps.executeQuery();

            while (rs.next()) {

                clienteDTOs.add(new CustomerDTO(rs.getLong(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getLong(5)));
            }

        } catch (java.lang.NullPointerException | java.sql.SQLException ex) {
            System.out.println("error " + ex.getMessage());
        } finally {
//            CONN.closeConnection();
        }

        return clienteDTOs;
    }

    @Override
    public List<CustomerDTO> find(String column, String value) {
        String query = "SELECT *FROM clientes WHERE " + column + " LIKE '"
                + value + "%'";
        java.sql.PreparedStatement ps;
        java.sql.ResultSet rs;
        java.util.ArrayList<CustomerDTO> clienteDTOs = new java.util.ArrayList<>();

        try {

            ps = CONN.getConnection().prepareStatement(query);

            rs = ps.executeQuery();

            while (rs.next()) {

                clienteDTOs.add(new CustomerDTO(rs.getLong(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getLong(5)));
            }

        } catch (java.lang.NullPointerException | java.sql.SQLException ex) {
            System.out.println("error " + ex.getMessage());
        } finally {
//            CONN.closeConnection();
        }

        return clienteDTOs;

    }

}

/*
 - Interface PreparedStatement: Un objeto que representa una instrucción SQL 
 precompilada.

 - método preparedStatement (Connection): Crea un objeto PreparedStatement 
 para enviar sentencias SQL con parámetros a la base de datos.

 - método executeUpdate (PreparedStatement): Ejecuta la instrucción SQL en un 
 objeto PreparedStatement, que debe ser un lenguaje de manipulación de datos 
 SQL, devuelve el número de filas de datos SQL ó 0
    
 - método executeQuery (PreparedStatement): Ejecuta la consulta SQL de un 
 objeto PreparedStatement y devuelve el conjunto de resultados 
 (objeto ResultSet) generado por la consulta.

 - Interface ResultSet: Una tabla de datos que representan un conjunto de 
 resultados de una base de datos, que por lo general se genera mediante la 
 ejecución de una declaración que consulta la base de datos.

 - método next (ResultSet): Mueve el cursor hacia adelante una fila de su 
 posición actual.
 */
