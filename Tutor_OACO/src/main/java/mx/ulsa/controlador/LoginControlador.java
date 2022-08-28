package mx.ulsa.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginControlador() {
		super();
	}

	private void procesarRespuesta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		
		String correo= request.getParameter("correo");
		String contra= request.getParameter("contrasenia");
		
		try (PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet IndexControlador</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h3>Parametros " + correo + "</h3>");
			out.println("<h3> " + contra + "</h3>");
			out.println("<h3>Rutal del archivo Servlet: " + request.getContextPath() + "</h3>");
			out.println("<p>Contenido de respuesta del Servlet</p>");
			out.println("</body>");
			out.println("</html>");
			
		}
		
		//response.sendRedirect(request.getContextPath()+"/login.jsp");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		procesarRespuesta(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		procesarRespuesta(request, response);
	}
}
