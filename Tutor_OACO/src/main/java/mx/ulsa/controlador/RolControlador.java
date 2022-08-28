package mx.ulsa.controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class RolControlador
 */
public class RolControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RolControlador() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesar(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void procesar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");

		try (PrintWriter out = response.getWriter()) {
			String action = request.getPathInfo();
			switch (action) {			
			case "/registrar":
				this.registrar(request, response);
				break;
			default:
				response.sendRedirect(request.getContextPath() + "/");
				break;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	private void registrar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			String parametroRol = request.getParameter("rol");
			String parametroDes = request.getParameter("descripcion");

			if (parametroRol == null || parametroRol.isEmpty() || parametroDes == null
					|| parametroDes.isEmpty() ) {
				String msg = "Error, Espacios Vacios";
				request.setAttribute("msgError", msg);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/usuario/registroRol.jsp");
				dispatcher.forward(request, response);
			}
			else {
				response.sendRedirect(request.getContextPath() + "/usuario/rol.jsp");

			}
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/usuario/rol.jsp");

		}
		
	}

}
