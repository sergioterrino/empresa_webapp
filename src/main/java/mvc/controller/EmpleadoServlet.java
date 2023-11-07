package mvc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mvc.dao.EmpleadoDAO;
import mvc.model.entity.Empleado;
import mvc.model.entity.Nomina;

/**
 * Servlet implementation class EmpleadoServlet
 */
@WebServlet(description = "Administra peticiones para la tabla empleados", urlPatterns = { "/empleados" })
public class EmpleadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(EmpleadoServlet.class);

	/**
	 * Default constructor.
	 */
	public EmpleadoServlet() {
		super();
	}

	/**
	 * Handles HTTP GET requests.
	 * 
	 * @param request  The HTTP request object.
	 * @param response The HTTP response object.
	 * @throws ServletException If there is an error with the servlet.
	 * @throws IOException      If there is an input/output error.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String opcion = request.getParameter("opcion");

		if (opcion.equals("listar")) {
			System.out.println("Usted a presionado la opcion Listar");
			EmpleadoDAO empleadoDAO = new EmpleadoDAO();
			try {
				List<Empleado> lista = empleadoDAO.obtenerEmpleados();
				request.setAttribute("lista", lista);
			} catch (SQLException e) {
				log.error("No se ha podido mostrar ", e);
			}

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/listar.jsp");
			requestDispatcher.forward(request, response);
		}
		// cuando clicke en esta opción sólo me llevará a su JSP
		if (opcion.equals("buscarEmpPorDni")) {
			System.out.println("Usted a presionado la opcion Buscar por DNI");

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/buscarEmpPorDni.jsp");
			requestDispatcher.forward(request, response);
		}

		if (opcion.equals("buscarEmp")) {
			System.out.println("Usted a presionado la opcion de Buscar Empleado");

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/buscarEmp.jsp");
			requestDispatcher.forward(request, response);
		}

	}

	/**
	 * Handles HTTP POST requests.
	 * 
	 * @param request  The HTTP request object.
	 * @param response The HTTP response object.
	 * @throws ServletException If there is an error with the servlet.
	 * @throws IOException      If there is an input/output error.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		doGet(request, response);
		String opcion = request.getParameter("opcion");
		// cuando el form envia los datos desde el JSP entra por aquí
		if (opcion.equals("buscarEmpPorDni")) {
			System.out.println("Usted a presionado la opcion buscar por DNI_POST");
			// recojo el dato metido por el input del JSP
			String dni = request.getParameter("dni");

			// Expresión regular para validar el DNI español (8 dígitos y una letra)
			String regex = "^[0-9]{8}[A-Za-z]$";

			if (dni.matches(regex)) {
				log.info("El Dni es válido");

				EmpleadoDAO empleadoDAO = new EmpleadoDAO();
				Nomina n = new Nomina();

				try {
					if (!dni.isEmpty() && dni != null) {
						Empleado empleado = empleadoDAO.obtenerEmpleadoPorDni(dni);
						if (empleado != null) {
							double salario = n.sueldo(empleado);

							// Setear atributos para enviar a la página verSalario.jsp
							request.setAttribute("dni", empleado.getDni());
							request.setAttribute("nombre", empleado.getNombre());
							request.setAttribute("salario", salario);

							// Redirigir a verSalario.jsp
							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/verSalario.jsp");
							requestDispatcher.forward(request, response);
						} else {
							System.out.println("No existe un empleado con ese DNI");
							log.error("No existe un empleado con ese DNI");
						}
					} else {
						System.out.println("Error, introduzca un DNI válido.");
						log.error("Error, introduzca un DNI válido.");
					}
				} catch (Exception e) {
					log.error("Ha habido un error al buscar el Empleado por DNI", e);
				}

			} else {
				log.error("El DNI no es válido");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/error.jsp");
				requestDispatcher.forward(request, response);
			}
		}
		if (opcion.equals("buscarEmp")) {
			System.out.println("Usted a presionado la opcion buscar por Buscar Empleado_POST");
			String choice = request.getParameter("choice");
			String busqueda = request.getParameter("busqueda");

			EmpleadoDAO empleadoDAO = new EmpleadoDAO();
			Nomina n = new Nomina();

			try {
				if (choice != null) {
					if (choice.equals("DNI")) {
						List<Empleado> lista = empleadoDAO.buscarEmpPorCriterio(choice, busqueda);
						request.setAttribute("lista", lista);
					} else if (choice.equals("Nombre")) {
						List<Empleado> lista = empleadoDAO.buscarEmpPorCriterio(choice, busqueda);
						request.setAttribute("lista", lista);
					} else if (choice.equals("Sexo")) {
						List<Empleado> lista = empleadoDAO.buscarEmpPorCriterio(choice, busqueda);
						request.setAttribute("lista", lista);
					} else if (choice.equals("Categoria")) {
						List<Empleado> lista = empleadoDAO.buscarEmpPorCriterio(choice, busqueda);
						request.setAttribute("lista", lista);
					} else if (choice.equals("Anyos")) {
						List<Empleado> lista = empleadoDAO.buscarEmpPorCriterio(choice, busqueda);
						request.setAttribute("lista", lista);
					}

					// Redirigir a verEmpleado.jsp
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/verEmpleado.jsp");
					requestDispatcher.forward(request, response);

				} else {
					System.out.println("Error, seleccione una opción.");
					log.error("Error, seleccione una opción.");
				}
			} catch (Exception e) {
				e.printStackTrace();
				log.error("Error, al buscar un empleado por criterio.");
			}
		}

	}

}
