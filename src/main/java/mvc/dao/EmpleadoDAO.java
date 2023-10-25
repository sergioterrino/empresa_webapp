package mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mvc.model.entity.Empleado;
import mvc.model.repository.Conexion;

/**
 * This class represents a Data Access Object (DAO) for handling employee data.
 * It provides methods to retrieve, search, and manipulate employee information in the database.
 */
public class EmpleadoDAO {
	private Connection conn;
	private PreparedStatement st;
	private boolean estadoOperacion;
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
		} catch (SQLException e1) {
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
		} catch (SQLException e1) {
			System.out.println("Error, no se ha podido obtener el salario del empleado");
		}
		return salario;
	}
	
	
	 //METODOS BUSCAR: CHOICE--------------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * Retrieves a list of employees based on their DNI (Identification Number) matching a given value.
	 *
	 * @param dni The DNI value to search for in the employees' records.
	 * @return A list of Employee objects matching the DNI value.
	 * @throws SQLException If there is an error with the database.
	 */
	public List<Empleado> buscarChoiceDni(String dni) throws SQLException {
		ResultSet rs = null;
		List<Empleado> listaEmpleados = new ArrayList<>();
		String sql = null;
		conn = obtenerConexion();

		try {
			PreparedStatement st = conn.prepareStatement("SELECT * FROM EMPLEADOS WHERE DNI = ?");
			st.setString(1, dni);
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
			System.out.println("Error, no se ha podido obtener la lista Empleados con CHOICE DNI ");
		}
		return listaEmpleados;
	}
	
	/**
	 * Retrieves a list of employees based on their name matching a given value.
	 *
	 * @param nombre The name value to search for in the employees' records.
	 * @return A list of Employee objects matching the name value.
	 * @throws SQLException If there is an error with the database.
	 */
	public List<Empleado> buscarChoiceNombre(String nombre) throws SQLException {
		ResultSet rs = null;
		List<Empleado> listaEmpleados = new ArrayList<>();
		conn = obtenerConexion();

		try {
			PreparedStatement st = conn.prepareStatement("SELECT * FROM EMPLEADOS WHERE nombre = ?");
			st.setString(1, nombre);
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
			System.out.println("Error, no se ha podido obtener la lista Empleados con CHOICE NOMBRE ");
		}
		return listaEmpleados;
	}

	/**
	 * Retrieves a list of employees based on their gender (sexo) matching a given value.
	 *
	 * @param sexo The gender value to search for in the employees' records.
	 * @return A list of Employee objects matching the gender value.
	 * @throws SQLException If there is an error with the database.
	 */
	public List<Empleado> buscarChoiceSexo(String sexo) throws SQLException {
		ResultSet rs = null;
		List<Empleado> listaEmpleados = new ArrayList<>();
		conn = obtenerConexion();

		try {
			PreparedStatement st = conn.prepareStatement("SELECT * FROM EMPLEADOS WHERE sexo = ?");
			st.setString(1, sexo);
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
			System.out.println("Error, no se ha podido obtener la lista Empleados con CHOICE SEXO ");
		}
		return listaEmpleados;
	}
	
	/**
	 * Retrieves a list of employees based on their category (categoria) matching a given value.
	 *
	 * @param categoria The category value to search for in the employees' records.
	 * @return A list of Employee objects matching the category value.
	 * @throws SQLException If there is an error with the database.
	 */
	public List<Empleado> buscarChoiceCategoria(String categoria) throws SQLException {
		ResultSet rs = null;
		List<Empleado> listaEmpleados = new ArrayList<>();
		conn = obtenerConexion();

		try {
			PreparedStatement st = conn.prepareStatement("SELECT * FROM EMPLEADOS WHERE categoria = ?");
			st.setString(1, categoria);
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
			System.out.println("Error, no se ha podido obtener la lista Empleados con CHOICE CATEGORIA ");
		}
		return listaEmpleados;
	}
	
	/**
	 * Retrieves a list of employees based on the number of years (anyos) matching a given value.
	 *
	 * @param anyos The number of years value to search for in the employees' records.
	 * @return A list of Employee objects matching the number of years value.
	 * @throws SQLException If there is an error with the database.
	 */
	public List<Empleado> buscarChoiceAnyos(String anyos) throws SQLException {
		ResultSet rs = null;
		List<Empleado> listaEmpleados = new ArrayList<>();
		conn = obtenerConexion();

		try {
			PreparedStatement st = conn.prepareStatement("SELECT * FROM EMPLEADOS WHERE anyos = ?");
			st.setString(1, anyos);
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
			System.out.println("Error, no se ha podido obtener la lista Empleados con CHOICE ANYOS ");
		}
		return listaEmpleados;
	}
	
	//FIN METODOS BUSCAR: CHOICE------------------------------------------------------------------------------------------------------------------------------------

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
