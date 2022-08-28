package mx.ulsa.controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mx.ulsa.modelo.Persona;
import mx.ulsa.modelo.Usuario;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class UsuarioControlador
 */
public class UsuarioControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsuarioControlador() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		procesar(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		procesar(request, response);
	}

	protected void procesar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");

		try (PrintWriter out = response.getWriter()) {
			String action = request.getPathInfo();
			switch (action) {
			case "/login":
				this.perfil(request, response);
				break;
			case "/registrar":
				this.registrar(request, response);
				break;
			case "/registrarUsuarioPersona":
				this.registrarUsuarioPersona(request, response);
				break;
			default:
				response.sendRedirect(request.getContextPath() + "/");
				break;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void registrarUsuarioPersona(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recuperar los datos del formulario

		// Guardarlos en la base de datos

		// regresar a la pagina usuario.jsp		
		try {
			// response.setContentType("text/html;charset=\"ISO-8859-1\"");
			String parametroCorreo = request.getParameter("correo");
			String parametroPwd = request.getParameter("password");
			String parametroStatus = request.getParameter("status");
			String parametrofechaVige = request.getParameter("fechaVigencia");

			if (parametroCorreo == null || parametroCorreo.isEmpty() || parametroPwd == null
					|| parametroPwd.isEmpty()) {
				String msg = "Error, Espacios Vacios";
				request.setAttribute("msgError", msg);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/usuario/registrarUsuario.jsp");
				dispatcher.forward(request, response);
			}
			response.sendRedirect(request.getContextPath() + "/usuario/usuario.jsp");

		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/usuario/usuario.jsp");
		}

	}

	private void perfil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String parametroCorreo = request.getParameter("correo");
			String parametroPwd = request.getParameter("contrasenia");

			if ((parametroCorreo == null || parametroCorreo.isEmpty())
					&& (parametroPwd == null || parametroPwd.isEmpty())) {
				request.setAttribute("msg", "Datos de ingresos erróneos");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/usuario/login.jsp");
				dispatcher.forward(request, response);
			} else {
				// Buscar usuario y contraseña en la base de datos
				Usuario usuario = new Usuario();
				usuario.setCorreo(parametroCorreo);
				usuario.setPassword(parametroPwd.trim());

				HttpSession session = request.getSession();
				synchronized (session) {
					session.setAttribute("usuario", usuario);
					response.sendRedirect(request.getContextPath() + "/usuario/dashboard.jsp");
				}
			}
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/usuario/login.jsp");
		}

	}

	private void registrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Persona pers = new Persona();
			pers.setNombre(request.getParameter("name"));
			pers.setApePaterno(request.getParameter("paterno"));
			pers.setApeMaterno(request.getParameter("materno"));
			pers.setEdad(Integer.parseInt(request.getParameter("edad")));
			pers.setTelefono(request.getParameter("telefono"));

			Usuario user = new Usuario();
			user.setCorreo(request.getParameter("correo"));
			user.setPassword(request.getParameter("contrasenia"));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			RequestDispatcher dispacher = request.getRequestDispatcher("/usuario/login.jsp");
			dispacher.forward(request, response);
		}

	}

}
