
package model.dto;

/**
 *
 * @author Arith Alexis Villalba Bravo
 * @date 28/04/2016
 * @time 11:43:38 PM
 */
public class CustomerDTO {
    
    private long id;
    private String nombre;
    private String apellido;
    private String direccion;
    private long telefono;

    public CustomerDTO() {
    }

    public CustomerDTO(long id) {
        this.id = id;
    }

    public CustomerDTO(long id, String nombre, String apellido, String direccion, 
            long telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "ClienteDTO{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", telefono=" + telefono + '}';
    }

}
