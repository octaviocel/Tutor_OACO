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
 * Servlet implementation class PersonaControlador
 */
public class PersonaControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PersonaControlador() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		procesar(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
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
			String parametroNombre = request.getParameter("nombre");
			String parametroApePat = request.getParameter("apePat");
			String parametroApeMat = request.getParameter("apeMat");
			String parametroEdad = request.getParameter("edad");
			String parametroRFC = request.getParameter("rfc");
			String parametroTelefono = request.getParameter("telefono");
			String parametroFechaNac = request.getParameter("fechaNac");
			String parametroDomicilio = request.getParameter("domicilio");

			if (parametroNombre == null || parametroNombre.isEmpty() || parametroApePat == null
					|| parametroApePat.isEmpty() || parametroApeMat == null || parametroApeMat.isEmpty()
					|| parametroEdad == null || parametroEdad.isEmpty()
					|| parametroRFC == null || parametroRFC.isEmpty() || parametroTelefono == null
					|| parametroTelefono.isEmpty() || parametroFechaNac == null || parametroFechaNac.isEmpty()
					|| parametroDomicilio == null || parametroDomicilio.isEmpty()) {
				String msg = "Error, Espacios Vacios";
				request.setAttribute("msgError", msg);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/usuario/personaRegistro.jsp");
				dispatcher.forward(request, response);
			}
			else {
				response.sendRedirect(request.getContextPath() + "/usuario/persona.jsp");

			}
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/usuario/persona.jsp");

		}
	}
}
