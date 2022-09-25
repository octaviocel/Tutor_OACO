package mx.ulsa.controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mx.ulsa.dao.hibernate.PersonaDAO;
import mx.ulsa.modelo.Persona;
import mx.ulsa.modelo.Rol;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Servlet implementation class PersonaControlador
 */
public class PersonaControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PersonaDAO dao;
	public PersonaControlador() {
		super();
		dao =  new PersonaDAO();
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
		
		try (PrintWriter out = response.getWriter()) {
			String action = request.getPathInfo();
			
			switch (action) {
			case "/registrar":				
				this.registrar(request, response);
				break;
			case "/actualizar":
				this.actualizar(request,response);
				break;
			case "/guardar":
				this.guardar(request,response);
				break;
			case "/listarPersona":
				this.listarPersona(request,response);
				break;
			case "/eliminar":
				this.eliminar(request,response);
				break;
			default:
				response.sendRedirect(request.getContextPath() + "/");
				break;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {

			String parametroId = request.getParameter("ideliminar");

			if (parametroId != null || parametroId != "") {
				dao.deletePersona(Integer.parseInt(parametroId));
				HttpSession session = request.getSession();
				synchronized (session) {
					session.setAttribute("listaPersonas", dao.getPersonas());
					response.sendRedirect(request.getContextPath() + "/usuario/persona.jsp");
				}

			}
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/usuario/persona.jsp");
		}
	}

	private void listarPersona(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			HttpSession session = request.getSession();
			synchronized (session) {
				session.setAttribute("listaPersonas", dao.getPersonas());
				response.sendRedirect(request.getContextPath() + "/usuario/persona.jsp");
			}

		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/usuario/persona.jsp");
		}		
	}

	private void guardar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			String parametroNombre = request.getParameter("nombre");
			String parametroApePat = request.getParameter("apePat");
			String parametroApeMat = request.getParameter("apeMat");
			String parametroEdad = request.getParameter("edad");
			String parametroRFC = request.getParameter("rfc");
			String parametroTelefono = request.getParameter("telefono");
			String parametroFechaNac = request.getParameter("fechaNac");
			String parametroDomicilio = request.getParameter("domicilio");
			String parametroId= request.getParameter("idguardar");

			if (parametroNombre == null || parametroNombre.isEmpty() || parametroApePat == null
					|| parametroApePat.isEmpty() || parametroApeMat == null || parametroApeMat.isEmpty()
					|| parametroEdad == null || parametroEdad.isEmpty()
					|| parametroRFC == null || parametroRFC.isEmpty() || parametroTelefono == null
					|| parametroTelefono.isEmpty() || parametroFechaNac == null || parametroFechaNac.isEmpty()
					|| parametroDomicilio == null || parametroDomicilio.isEmpty()) {
				String msg = "Error, Espacios Vacios";
				request.setAttribute("msgError", msg);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/usuario/personaActualizar.jsp");
				dispatcher.forward(request, response);
			}
			else {				
				java.sql.Date fechaConvertida = java.sql.Date.valueOf(parametroFechaNac);
				
				Persona personita =  new Persona(Integer.parseInt(parametroId),parametroNombre,parametroApePat,parametroApeMat,
						Integer.parseInt(parametroEdad),parametroTelefono,parametroRFC,
						fechaConvertida,parametroDomicilio);
				
				dao.updatePersona(personita);
				
				HttpSession session = request.getSession();
				synchronized (session) {
					session.setAttribute("listaPersonas", dao.getPersonas());
					response.sendRedirect(request.getContextPath() + "/usuario/persona.jsp");

				}				

			}
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/usuario/persona.jsp");
			System.out.println(e.getMessage());
		}
		
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {

			String parametroId = request.getParameter("idactualizar");

			if (parametroId != null || parametroId != "") {
				Persona persona = dao.getPersona(Integer.parseInt(parametroId));
				HttpSession session = request.getSession();
				synchronized (session) {
					session.setAttribute("PersonaActualizar", persona);
					response.sendRedirect(request.getContextPath() + "/usuario/personaActualizar.jsp");
				}

			}
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/usuario/persona.jsp");
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
				java.sql.Date fechaConvertida = java.sql.Date.valueOf(parametroFechaNac);
				
				Persona personita =  new Persona(parametroNombre,parametroApePat,parametroApeMat,
						Integer.parseInt(parametroEdad),parametroTelefono,parametroRFC,
						fechaConvertida,parametroDomicilio);
				
				dao.createPersona(personita);		
				
				HttpSession session = request.getSession();
				synchronized (session) {
					session.setAttribute("listaPersonas", dao.getPersonas());
					response.sendRedirect(request.getContextPath() + "/usuario/persona.jsp");

				}				

			}
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/usuario/persona.jsp");
			System.out.println(e.getMessage());
		}
	}
}
