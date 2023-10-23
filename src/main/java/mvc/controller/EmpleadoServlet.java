package mvc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.dao.EmpleadoDAO;
import mvc.model.entity.Empleado;
import mvc.model.entity.Nomina;

/**
 * Servlet implementation class EmpleadoServlet
 */
@WebServlet(description = "Administra peticiones para la tabla empleados", urlPatterns = { "/empleados" })
public class EmpleadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpleadoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcion");

		if (opcion.equals("listar")) {
			System.out.println("Usted a presionado la opcion listar");
			EmpleadoDAO empleadoDAO = new EmpleadoDAO();
			try {
				List<Empleado> lista = empleadoDAO.obtenerEmpleados();
				request.setAttribute("lista", lista);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/listar.jsp");
			requestDispatcher.forward(request, response);
		}
		//cuando clique en esta opción sólo me llevará a su JSP
		if(opcion.equals("buscarEmpPorDni")) {
			System.out.println("Usted a presionado la opcion buscar por DNI");
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/buscarEmpPorDni.jsp");
			requestDispatcher.forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		String opcion = request.getParameter("opcion");

	    if (opcion.equals("buscarEmpPorDni")) {
	    	System.out.println("Usted a presionado la opcion buscar por DNI POST");
	        String dni = request.getParameter("dni");
	        
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
	                }
	            } else {
	                System.out.println("Error, introduzca un DNI válido.");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}

}