package mx.ulsa.controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mx.ulsa.dao.hibernate.RolDAO;
import mx.ulsa.modelo.Rol;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class RolControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// private List<Rol> listaRoles;
	private RolDAO dao;

	public RolControlador() {
		super();
		// listaRoles = new ArrayList<Rol>();
		dao = new RolDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		procesar(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
			case "/eliminar":
				this.eliminar(request, response);
				break;
			case "/actualizar":
				this.actualizar(request, response);
				break;
			case "/guardar":
				this.guardar(request, response);
				break;
			case "/listarRol":
				this.listarRol(request, response);
				break;
			default:
				response.sendRedirect(request.getContextPath() + "/");
				break;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void listarRol(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {

			HttpSession session = request.getSession();
			synchronized (session) {
				session.setAttribute("listaRoles", dao.getRols());
				response.sendRedirect(request.getContextPath() + "/usuario/rol.jsp");
			}

		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/usuario/rol.jsp");
		}

	}

	private void guardar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			String parametroRol = request.getParameter("rol");
			String parametroDes = request.getParameter("descripcion");
			String parametroId = request.getParameter("idguardar");

			if (parametroRol == null || parametroRol.isEmpty() || parametroDes == null || parametroDes.isEmpty()
					|| parametroId == null || parametroId.isEmpty()) {
				String msg = "Error, Espacios Vacios";
				request.setAttribute("msgError", msg);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/usuario/registroRol.jsp");
				dispatcher.forward(request, response);
			} else {
				Rol rolecito = new Rol(Integer.parseInt(parametroId), parametroRol, parametroDes);
				dao.updateRol(rolecito);
				HttpSession session = request.getSession();
				synchronized (session) {
					session.setAttribute("listaRoles", dao.getRols());
					response.sendRedirect(request.getContextPath() + "/usuario/rol.jsp");
				}
			}
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/usuario/rol.jsp");
		}
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {

			String parametroId = request.getParameter("idactualizar");

			if (parametroId != null || parametroId != "") {
				Rol role = dao.getRol(Integer.parseInt(parametroId));
				HttpSession session = request.getSession();
				synchronized (session) {
					session.setAttribute("RolActualizar", role);
					response.sendRedirect(request.getContextPath() + "/usuario/rolActualizar.jsp");
				}

			}
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/usuario/rol.jsp");
		}

	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {

			String parametroId = request.getParameter("ideliminar");

			if (parametroId != null || parametroId != "") {
				dao.deleteRol(Integer.parseInt(parametroId));
				HttpSession session = request.getSession();
				synchronized (session) {
					session.setAttribute("listaRoles", dao.getRols());
					response.sendRedirect(request.getContextPath() + "/usuario/rol.jsp");
				}

			}
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/usuario/rol.jsp");
		}

	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			String parametroRol = request.getParameter("rol");
			String parametroDes = request.getParameter("descripcion");

			if (parametroRol == null || parametroRol.isEmpty() || parametroDes == null || parametroDes.isEmpty()) {
				String msg = "Error, Espacios Vacios";
				request.setAttribute("msgError", msg);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/usuario/registroRol.jsp");
				dispatcher.forward(request, response);
			} else {
				Rol rolecito = new Rol(parametroRol, parametroDes);
				dao.createRol(rolecito);
				HttpSession session = request.getSession();
				synchronized (session) {
					session.setAttribute("listaRoles", dao.getRols());
					response.sendRedirect(request.getContextPath() + "/usuario/rol.jsp");
				}
			}
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/usuario/rol.jsp");
		}

	}

}
