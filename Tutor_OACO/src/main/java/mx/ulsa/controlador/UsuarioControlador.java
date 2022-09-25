package mx.ulsa.controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mx.ulsa.dao.hibernate.PersonaDAO;
import mx.ulsa.dao.hibernate.RolDAO;
import mx.ulsa.dao.hibernate.UsuarioDAO;
import mx.ulsa.modelo.Persona;
import mx.ulsa.modelo.Rol;
import mx.ulsa.modelo.Usuario;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Servlet implementation class UsuarioControlador
 */
public class UsuarioControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsuarioDAO usuariosDAO;
	PersonaDAO daoPer;
	RolDAO roles;

	public UsuarioControlador() {
		super();
		// TODO Auto-generated constructor stub
		usuariosDAO = new UsuarioDAO();
		daoPer = new PersonaDAO();
		roles = new RolDAO();
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
			case "/listarUsuarios":
				this.listar(request, response);
				break;
			case "/nuevo":
				this.nuevasListas(request, response);
				break;
			case "/actualizar":
				this.actualizar(request, response);
				break;
			case "/eliminar":
				this.eliminar(request, response);
				break;
			case "/guardar":
				this.guardar(request, response);
				break;
			default:
				response.sendRedirect(request.getContextPath() + "/");
				break;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void guardar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			String parametroCorreo = request.getParameter("correo");
			String parametroPwd = request.getParameter("password");
			String paramStatus = request.getParameter("status");
			String paramRol = request.getParameter("rol");
			String paramPerson = request.getParameter("persona");
			String paramFechaVig = request.getParameter("fechaVigencia");
			String paramId = request.getParameter("idguardar");

			if (parametroCorreo == null || parametroCorreo.isEmpty() || parametroPwd == null
					|| parametroPwd.isEmpty()) {
				String msg = "Error, Espacios Vacios";
				request.setAttribute("msgError", msg);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/usuario/usuarioActualizar.jsp");
				dispatcher.forward(request, response);
			}

			Usuario existente = usuariosDAO.getUsuario(Integer.parseInt(paramId));
			java.sql.Date fechaVigencia = java.sql.Date.valueOf(paramFechaVig);
			boolean decision = paramStatus == null ? false : true;
			Persona per = daoPer.getPersona(Integer.parseInt(paramPerson.trim()));
			Rol rol = roles.getRol(Integer.parseInt(paramRol.trim()));

			Usuario usuario = new Usuario(Integer.parseInt(paramId), parametroCorreo.trim(), parametroPwd.trim(),
					decision, existente.getFechaResgitro(), fechaVigencia, per, rol);

			usuariosDAO.updateUsuario(usuario);

			HttpSession session = request.getSession();
			synchronized (session) {
				session.setAttribute("listaUsuarios", usuariosDAO.getUsuarios());
				response.sendRedirect(request.getContextPath() + "/usuario/usuario.jsp");
			}

		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/usuario/usuario.jsp");
			e.printStackTrace();
		}

	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {

			String parametroId = request.getParameter("ideliminarUser");
			System.out.println(parametroId);
			if (parametroId != null || parametroId != "") {
				usuariosDAO.deleteUsuario(Integer.parseInt(parametroId));
				HttpSession session = request.getSession();
				synchronized (session) {
					session.setAttribute("listaUsuarios", usuariosDAO.getUsuarios());
					response.sendRedirect(request.getContextPath() + "/usuario/usuario.jsp");
				}

			}
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/usuario/usuario.jsp");
			e.printStackTrace();
		}
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {

			String parametroId = request.getParameter("idactualizar");

			if (parametroId != null || parametroId != "") {
				Usuario userio = usuariosDAO.getUsuario(Integer.parseInt(parametroId));
				HttpSession session = request.getSession();
				synchronized (session) {
					session.setAttribute("UsuarioActualizar", userio);
					session.setAttribute("listaPersonas", daoPer.getPersonas());
					session.setAttribute("listaRoles", roles.getRols());
					response.sendRedirect(request.getContextPath() + "/usuario/usuarioActualizar.jsp");
				}

			}
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/usuario/usuario.jsp");
		}
	}

	private void nuevasListas(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			HttpSession session = request.getSession();
			synchronized (session) {
				session.setAttribute("listaPersonas", daoPer.getPersonas());
				session.setAttribute("listaRoles", roles.getRols());
				response.sendRedirect(request.getContextPath() + "/usuario/registrarUsuario.jsp");
			}

		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/usuario/registrarUsuario.jsp");
		}
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			HttpSession session = request.getSession();
			synchronized (session) {
				session.setAttribute("listaUsuarios", usuariosDAO.getUsuarios());
				response.sendRedirect(request.getContextPath() + "/usuario/usuario.jsp");
			}

		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/usuario/usuario.jsp");
			e.printStackTrace();
		}

	}

	private void registrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String parametroCorreo = request.getParameter("correo");
			String parametroPwd = request.getParameter("password");

			if (parametroCorreo == null || parametroCorreo.isEmpty() || parametroPwd == null
					|| parametroPwd.isEmpty()) {
				String msg = "Error, Espacios Vacios";
				request.setAttribute("msgError", msg);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/usuario/registrarUsuario.jsp");
				dispatcher.forward(request, response);
			}

			// System.out.println(parametroCorreo.trim());
			Boolean checador = usuariosDAO.getUsuarioByCorreo(parametroCorreo.trim());

			// System.out.println(checador.getCorreo());

			if (!checador) {
				Calendar c = Calendar.getInstance();

				SimpleDateFormat formar = new SimpleDateFormat("yyyy-MM-dd");

				String fc = formar.format(c.getTime());

				java.sql.Date fechaCreacion = java.sql.Date.valueOf(fc);

				c.add(Calendar.YEAR, 1);
				String fv = formar.format(c.getTime());
				java.sql.Date fechaVigencia = java.sql.Date.valueOf(fv);

				Usuario usuario = new Usuario(parametroCorreo.trim(), parametroPwd.trim(), true, fechaCreacion,
						fechaVigencia);

				boolean exito = usuariosDAO.saveUsuario(usuario);
				if (exito) {
					response.sendRedirect(request.getContextPath() + "/usuario/login.jsp");
				} else {
					String msg = "Error, Espacios Vacios";
					HttpSession session = request.getSession();
					synchronized (session) {
						session.setAttribute("msgError", msg);
						response.sendRedirect(request.getContextPath() + "/usuario/registrar.jsp");
					}
				}
			} else {
				String msg = "El correo ya ha sido registrado\nIntenta con otro correo";
				HttpSession session = request.getSession();
				synchronized (session) {
					session.setAttribute("msgErroRegistro", msg);
					response.sendRedirect(request.getContextPath() + "/usuario/registrar.jsp");

				}
			}
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/usuario/registrar.jsp");
			e.printStackTrace();
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

				Usuario usuario = usuariosDAO.getUsuarioByCorreoAndPassword(parametroCorreo, parametroPwd);
				if (usuario != null) {
					HttpSession session = request.getSession();
					synchronized (session) {
						session.setAttribute("usuario", usuario);
						response.sendRedirect(request.getContextPath() + "/usuario/dashboard.jsp");
					}
				} else {
					String msg = "Error de credenciales";
					HttpSession session = request.getSession();
					synchronized (session) {
						session.setAttribute("msgErrorLogin", msg);
						response.sendRedirect(request.getContextPath() + "/usuario/dashboard.jsp");
					}
				}

			}
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/usuario/login.jsp");
		}

	}

	private void registrarUsuarioPersona(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String parametroCorreo = request.getParameter("correo");
			String parametroPwd = request.getParameter("password");
			String paramStatus = request.getParameter("status");
			String paramRol = request.getParameter("rol");
			String paramPerson = request.getParameter("persona");
			String paramFechaVig = request.getParameter("fechaVigencia");

			System.out.println(parametroCorreo);
			System.out.println(parametroPwd);
			System.out.println(paramStatus);
			System.out.println(paramRol);
			System.out.println(paramPerson);
			System.out.println(paramFechaVig);

			if (parametroCorreo == null || parametroCorreo.isEmpty() || parametroPwd == null
					|| parametroPwd.isEmpty()) {
				String msg = "Error, Espacios Vacios";
				request.setAttribute("msgError", msg);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/usuario/usuario.jsp");
				dispatcher.forward(request, response);
			}

			// System.out.println(parametroCorreo.trim());
			Boolean checador = usuariosDAO.getUsuarioByCorreo(parametroCorreo.trim());

			// System.out.println(checador.getCorreo());

			if (!checador) {
				Calendar c = Calendar.getInstance();
				SimpleDateFormat formar = new SimpleDateFormat("yyyy-MM-dd");
				String fc = formar.format(c.getTime());
				java.sql.Date fechaCreacion = java.sql.Date.valueOf(fc);

				java.sql.Date fechaVigencia = java.sql.Date.valueOf(paramFechaVig);

				boolean decision = paramStatus == null ? false : true;

				System.out.println(decision);

				Persona per = daoPer.getPersona(Integer.parseInt(paramPerson.trim()));
				Rol rol = roles.getRol(Integer.parseInt(paramRol.trim()));

				Usuario usuario = new Usuario(parametroCorreo.trim(), parametroPwd.trim(), decision, fechaCreacion,
						fechaVigencia, per, rol);

				boolean exito = usuariosDAO.saveUsuario(usuario);
				if (exito) {
					HttpSession session = request.getSession();
					synchronized (session) {
						session.setAttribute("listaUsuarios", usuariosDAO.getUsuarios());
						response.sendRedirect(request.getContextPath() + "/usuario/usuario.jsp");
					}
				} else {
					String msg = "Error, Espacios Vacios";
					HttpSession session = request.getSession();
					synchronized (session) {
						session.setAttribute("msgError", msg);
						response.sendRedirect(request.getContextPath() + "/usuario/usuario.jsp");
					}
				}
			} else {
				String msg = "El correo ya ha sido registrado\nIntenta con otro correo";
				HttpSession session = request.getSession();
				synchronized (session) {
					session.setAttribute("msgErroRegistro", msg);
					response.sendRedirect(request.getContextPath() + "/usuario/usuario.jsp");

				}
			}
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/usuario/usuario.jsp");
			e.printStackTrace();
		}

	}

	protected void setAttributeInSession(HttpServletRequest request, HttpServletResponse response, String name,
			String url, Object object) throws IOException {
		HttpSession session = request.getSession();
		synchronized (session) {
			session.setAttribute(name, object);
			response.sendRedirect(request.getContextPath() + url);
		}
	}
}
