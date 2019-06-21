package model.dao;

import java.util.List;
import model.connection.Link;
import model.dto.ProductDTO;

/**
 *
 * @author Arith Alexis Villalba Bravo
 * @date 29/04/2016
 * @time 12:13:27 AM
 */
public class ProductDAO implements interfaces.Crud<model.dto.ProductDTO> {

    private static final String SQL_CREATE = "INSERT INTO products "
            + "VALUES (?, ?, ?, ?)";

    private static final String SQL_READ = "SELECT *FROM products WHERE id = ?";

    private static final String SQL_UPDATE = "UPDATE products SET name = ?,"
            + "amount = ?, price = ? WHERE id = ?";

    private static final String SQL_DELETE = "DELETE FROM products WHERE id = ?";

    private static final String SQL_READALL = "SELECT *FROM products";

    public static final Link CONN = Link.connect();

    @Override
    public boolean create(ProductDTO product) {
        
        java.sql.PreparedStatement ps;

        try {
            ps = CONN.getConnection().prepareStatement(SQL_CREATE);

            ps.setInt(1, product.getId());
            ps.setString(2, product.getName());
            ps.setString(3, product.getAmount());
            ps.setDouble(4, product.getPrice());

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
    public ProductDTO read(Object key) {

        return null;
    }

    @Override
    public boolean update(ProductDTO product) {
        
         java.sql.PreparedStatement ps;

        try {
            
            ps = CONN.getConnection().prepareStatement(SQL_UPDATE);

            ps.setString(1, product.getName());
            ps.setString(2, product.getAmount());
            ps.setDouble(3, product.getPrice());
            ps.setDouble(4, product.getId());

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
    public boolean delete(Object key) {
        
        
        java.sql.PreparedStatement ps;

        try {
            ps = CONN.getConnection().prepareStatement(SQL_DELETE);

            ps.setInt(1, Integer.parseInt(key.toString()));

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
    public List<ProductDTO> readAll() {
        java.sql.PreparedStatement ps;
        java.sql.ResultSet rs;
        java.util.ArrayList<ProductDTO> producDTOs = new java.util.ArrayList<>();

        try {

            ps = CONN.getConnection().prepareStatement(SQL_READALL);

            rs = ps.executeQuery();

            while (rs.next()) {

                producDTOs.add(new ProductDTO(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getDouble(4)));
            }

        } catch (java.lang.NullPointerException | java.sql.SQLException ex) {
            System.out.println("error " + ex.getMessage());
        } finally {
//            CONN.closeConnection();
        }

        return producDTOs;
    }

    @Override
    public List<ProductDTO> find(String column, String value) {
        String query = "SELECT *FROM products WHERE " + column + " LIKE '"
                + value + "%'";
        java.sql.PreparedStatement ps;
        java.sql.ResultSet rs;
        java.util.ArrayList<ProductDTO> productDTOs = new java.util.ArrayList<>();
        
        try {

            ps = CONN.getConnection().prepareStatement(query);

            rs = ps.executeQuery();

            while (rs.next()) {

                productDTOs.add(new ProductDTO(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getDouble(4)));
            }

        } catch (java.lang.NullPointerException | java.sql.SQLException ex) {
            System.out.println("error " + ex.getMessage());
        } finally {
//            CONN.closeConnection();
        }

        return productDTOs;

    }

}
