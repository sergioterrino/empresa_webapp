package mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mvc.model.entity.Empleado;
import mvc.model.repository.Conexion;

public class EmpleadoDAO {
	private Connection conn;
	private PreparedStatement st;
	private boolean estadoOperacion;

	
	// obtener lista de empleados
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
			System.out.println("lista empleados: " + listaEmpleados);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error, no se ha podido obtener la lista Empleados ");
		}
		return listaEmpleados;
	}
	

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
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	// guardar empleado
	public boolean guardar(Empleado empleado) throws SQLException {
		String sql = null;
		estadoOperacion = false;
		conn = obtenerConexion();

		try {
			conn.setAutoCommit(false);
			sql = "INSERT INTO Empleados (dni, nombre, sexo, categoria, anyos) VALUES(?,?,?,?,?)";
			st = conn.prepareStatement(sql);

			st.setString(1, empleado.getDni());
			st.setString(2, empleado.getNombre());
			st.setString(3, empleado.getSexo());
			st.setInt(4, empleado.getCategoria());
			st.setInt(5, empleado.getAnyos());

			estadoOperacion = st.executeUpdate() > 0;

			conn.commit();
			st.close();
			conn.close();
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
		}

		return estadoOperacion;
	}

	// editar empleado
	public boolean editar(Empleado empleado) throws SQLException {
		String sql = null;
		estadoOperacion = false;
		conn = obtenerConexion();
		try {
			conn.setAutoCommit(false);
			sql = "UPDATE Empleados SET dni=?, nombre=?, sexo=?, categoria=?, anyos=? WHERE id=?";
			st = conn.prepareStatement(sql);

			st.setString(1, empleado.getDni());
			st.setString(2, empleado.getNombre());
			st.setString(3, empleado.getSexo());
			st.setInt(4, empleado.getCategoria());
			st.setInt(5, empleado.getAnyos());
			// Deberías tener un método para obtener el ID de empleado o pasarlo como
			// argumento.

			estadoOperacion = st.executeUpdate() > 0;
			conn.commit();
			st.close();
			conn.close();
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
		}

		return estadoOperacion;
	}

	// eliminar empleado
	public boolean eliminar(int idEmpleado) throws SQLException {
		String sql = null;
		estadoOperacion = false;
		conn = obtenerConexion();
		try {
			conn.setAutoCommit(false);
			sql = "DELETE FROM Empleados WHERE id=?";
			st = conn.prepareStatement(sql);
			st.setInt(1, idEmpleado);

			estadoOperacion = st.executeUpdate() > 0;
			conn.commit();
			st.close();
			conn.close();

		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
		}

		return estadoOperacion;
	}

	// obtener empleado
	public Empleado obtenerEmpleado(int idEmpleado) throws SQLException {
		ResultSet resultSet = null;
		Empleado empleado = new Empleado();

		String sql = null;
		estadoOperacion = false;
		conn = obtenerConexion();

		try {
			sql = "SELECT * FROM Empleados WHERE id =?";
			st = conn.prepareStatement(sql);
			st.setInt(1, idEmpleado);

			resultSet = st.executeQuery();

			if (resultSet.next()) {
				empleado.setId(resultSet.getInt("id"));
				empleado.setDni(resultSet.getString("dni"));
				empleado.setNombre(resultSet.getString("nombre"));
				empleado.setSexo(resultSet.getString("sexo"));
				empleado.setCategoria(resultSet.getInt("categoria"));
				empleado.setAnyos(resultSet.getInt("anyos"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return empleado;
	}

	// obtener conexion desde el pool (asumiendo que tienes un método para obtener
	// la conexión)
	private Connection obtenerConexion() throws SQLException {
		return Conexion.getConnection();
	}
}
