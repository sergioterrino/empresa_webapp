package mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mvc.controller.EmpleadoServlet;
import mvc.model.entity.Empleado;
import mvc.model.repository.Conexion;

/**
 * This class represents a Data Access Object (DAO) for handling employee data.
 * It provides methods to retrieve, search, and manipulate employee information in the database.
 */
public class EmpleadoDAO {
	private static final Logger log = LoggerFactory.getLogger(EmpleadoServlet.class);
	private Connection conn;
	private PreparedStatement st;
	//el DAO es el que tiene los metodos que acceden a la BD. El Servlet creo que es el que conecta el cliente con la BD
	
	/**
     * Retrieves a list of all employees from the database.
     *
     * @return A list of Employee objects.
     * @throws SQLException If there is an error with the database.
     */
	public List<Empleado> obtenerEmpleados() throws SQLException {
		ResultSet rs = null;
		List<Empleado> listaEmpleados = new ArrayList<>();
		String sql = null;
		conn = obtenerConexion();

		try {
			sql = "SELECT * FROM Empleados";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				Empleado empleado = new Empleado();
				empleado.setId(rs.getInt("id"));
				empleado.setDni(rs.getString("dni"));
				empleado.setNombre(rs.getString("nombre"));
				empleado.setSexo(rs.getString("sexo"));
				empleado.setCategoria(rs.getInt("categoria"));
				empleado.setAnyos(rs.getInt("anyos"));
				listaEmpleados.add(empleado);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("No se ha podido obtener la lista Empleados", e);
			System.out.println("Error, no se ha podido obtener la lista Empleados ");
		}
		return listaEmpleados;
	}
	
	/**
     * Retrieves an employee's information by their DNI (Identification Number).
     *
     * @param dni The DNI of the employee to retrieve.
     * @return An Employee object with the employee's information.
     * @throws Exception If there is an error with the database or no employee is found with the given DNI.
     */
	public Empleado obtenerEmpleadoPorDni(String dni) throws Exception {
		ResultSet rs = null;
		Empleado empleado = new Empleado();
		conn = obtenerConexion();

		try {
			PreparedStatement st = conn.prepareStatement("SELECT * FROM EMPLEADOS WHERE DNI = ?");
			st.setString(1, dni);
			rs = st.executeQuery();

			if (rs.next()) {
				empleado.setDni(rs.getString("dni"));
				empleado.setNombre(rs.getString("nombre"));
				empleado.setSexo(rs.getString("sexo"));
				empleado.setCategoria(rs.getInt("categoria"));
				empleado.setAnyos(rs.getInt("anyos"));
			}
			
			Double salario = obtenerSalario(dni);

			conn.close();
		} catch (SQLException e) {
			log.error("No se ha podido encontrar un empleado con ese DNI", e);
			System.out.println("Error, no se ha podido encontrar un empleado con ese DNI.");
		}
		return empleado;
	}
	
	/**
	 * Retrieves the salary of an employee with the given DNI (Identification Number).
	 *
	 * @param dni The DNI of the employee for whom you want to obtain the salary.
	 * @return The salary of the employee.
	 * @throws SQLException If there is an error with the database or no salary is found for the given DNI.
	 */
	public double obtenerSalario(String dni) throws SQLException {
		ResultSet rs = null;
		conn = obtenerConexion();
		double salario = 0;
		try {
			PreparedStatement st = conn.prepareStatement("SELECT SUELDO FROM NOMINAS WHERE DNI = ?");
			st.setString(1, dni);
			rs = st.executeQuery();

			if (rs.next()) {
				salario = rs.getDouble("SUELDO");
			}
			conn.close();
		} catch (SQLException e) {
			log.error("No se ha podido obtener el salario del empleado", e);
			System.out.println("Error, no se ha podido obtener el salario del empleado");
		}
		return salario;
	}
	
	
	 //METODOS BUSCAR: CHOICE--------------------------------------------------------------------------------------------------------------------------------
	
	public List<Empleado> buscarEmpPorCriterio(String choice, String busqueda) throws SQLException {
		ResultSet rs = null;
		List<Empleado> listaEmpleados = new ArrayList<>();
		conn = obtenerConexion();

		try {
			PreparedStatement st = conn.prepareStatement("SELECT * FROM EMPLEADOS WHERE " + choice + " = ?");
			st.setString(1, busqueda);
			rs = st.executeQuery();

			while (rs.next()) {
				Empleado empleado = new Empleado();
				empleado.setId(rs.getInt("id"));
				empleado.setDni(rs.getString("dni"));
				empleado.setNombre(rs.getString("nombre"));
				empleado.setSexo(rs.getString("sexo"));
				empleado.setCategoria(rs.getInt("categoria"));
				empleado.setAnyos(rs.getInt("anyos"));
				listaEmpleados.add(empleado);
			}
			System.out.println("hola");
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("No se ha podido obtener la lista Empleados con CHOICE ANYOS", e);
			System.out.println("Error, no se ha podido obtener la lista Empleados con CHOICE ANYOS ");
		}
		return listaEmpleados;
	}
	
	public Empleado obtenerEmpPorId(int id) {
		
		return null;
	}
	

	public Empleado editar(Empleado empleado) throws SQLException{
		Empleado emp = new Empleado();
		conn = obtenerConexion();
		try {
			PreparedStatement st = conn.prepareStatement("SELECT * FROM EMPLEADOS WHERE DNI = ?");
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				
			}
			
		}catch(SQLException e) {
			log.error("No se ha podido mostrar los datos del empleados", e);
		}
		return emp;
	}
	
	
	
	
	
	 /**
     * Obtains a database connection from the connection pool.
     *
     * @return A database connection.
     * @throws SQLException If there is an error obtaining the connection.
     */
	// obtener conexion desde el pool (asumiendo que tienes un método para obtener
	// la conexión)
	private Connection obtenerConexion() throws SQLException {
		return Conexion.getConnection();
	}
}
