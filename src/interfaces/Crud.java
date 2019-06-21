package interfaces;

/**
 *
 * @author Arith Alexis Villalba Bravo
 * @date 28/04/2016
 * @time 11:57:50 PM
 */
public interface Crud<DTO> {

    public boolean create(DTO dto);

    public DTO read(Object key);

    public boolean update(DTO dto);

    public boolean delete(Object key);

    public java.util.List<DTO> readAll();

    public java.util.List<DTO> find(String column, String value);

}
