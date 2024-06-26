package mvc.model.entity;

/**
 * Represents an Employee entity with attributes such as ID, DNI, name, gender, category, and years of service.
 */
public class Empleado {

    private int id;
    private String dni;
    private String nombre;
    private String sexo;
    private int categoria;
    private int anyos;

    /**
     * Constructs an Employee object with the specified attributes.
     *
     * @param id The unique identifier for the employee.
     * @param dni The DNI (National Identity Document) of the employee.
     * @param nombre The name of the employee.
     * @param sexo The gender of the employee.
     * @param categoria The category of the employee (must be between 1 and 10).
     * @param anyos The number of years the employee has served (must be positive).
     * @throws Exception If the category is not between 1 and 10, or if the years of service are not positive.
     */
    public Empleado(int id, String dni, String nombre, String sexo, int categoria, int anyos) throws Exception {
        super();
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.sexo = sexo;
        if (categoria > 0 || categoria < 10) {
			this.categoria = categoria;
		} else {
			throw new Exception("La categoria debe estar entre 1 y 10");
		}
		if (anyos > 0) {
			this.anyos = anyos;
		} else {
			throw new Exception("Los años deben ser positivos");
		}
    }

    public Empleado() {
    	super(); //esto es por si empleado heredase de alguna clase
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getAnyos() {
        return anyos;
    }

    public void setAnyos(int anyos) {
        this.anyos = anyos;
    }

    @Override
    public String toString() {
        return "Empleado [id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", sexo=" + sexo
                + ", categoria=" + categoria + ", anyos=" + anyos + "]";
    }
}
