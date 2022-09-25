package mx.ulsa.controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import mx.ulsa.dao.hibernate.ProductoDAO;
import mx.ulsa.modelo.Persona;
import mx.ulsa.modelo.Producto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.apache.tomcat.jakartaee.commons.compress.utils.IOUtils;

/**
 * Servlet implementation class ProductoControlador
 */
public class ProductoControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductoDAO dao;

	public ProductoControlador() {
		super();
		dao = new ProductoDAO();
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
				this.registrarProducto(request, response);
				break;
			case "/actualizar":
				this.actualizar(request, response);
				break;
			case "/guardar":
				this.guardar(request, response);
				break;
			case "/listarProducto":
				this.listar(request, response);
				break;
			case "/eliminar":
				this.eliminar(request, response);
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
				dao.deleteProducto(Integer.parseInt(parametroId));
				HttpSession session = request.getSession();
				synchronized (session) {
					session.setAttribute("listaProductos", dao.getProductos());
					response.sendRedirect(request.getContextPath() + "/usuario/producto.jsp");
				}

			}
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/usuario/producto.jsp");
		}
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			HttpSession session = request.getSession();
			synchronized (session) {
				session.setAttribute("listaProductos", dao.getProductos());
				response.sendRedirect(request.getContextPath() + "/usuario/producto.jsp");
			}

		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/usuario/producto.jsp");
		}

	}

	@SuppressWarnings("null")
	private void guardar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			String parametroNombre = request.getParameter("nombre");
			String parametroDes = request.getParameter("descripcion");
			String parametroPrecio = request.getParameter("precio");
			String parametroImage = request.getParameter("image");
			String parametroNumexis = request.getParameter("numExis");
			String parametroCodigo = request.getParameter("codigo");
			String parametroIVA = request.getParameter("iva");
			String parametroId = request.getParameter("idguardar");

			// System.out.println(parametroImage);
			if (parametroNombre == null || parametroNombre.isEmpty() || parametroDes == null || parametroDes.isEmpty()
					|| parametroPrecio == null || parametroPrecio.isEmpty() || parametroNumexis == null
					|| parametroNumexis.isEmpty() || parametroCodigo == null || parametroCodigo.isEmpty()
					|| parametroIVA == null || parametroIVA.isEmpty()) {
				String msg = "Error, Espacios Vacios";
				request.setAttribute("msgError", msg);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/usuario/productoRegistro.jsp");
				dispatcher.forward(request, response);
			} else {
				
				Part filePart = request.getPart("image");
				String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
				System.out.println(filePart);
				System.out.println(fileName);
				if (fileName.length()>0) {
					 // Retrieves <input type="file" name="file">
					 // MSIE fix.

					String path = request.getServletContext().getRealPath("/images/");
					File file = new File(path + fileName);

					try (InputStream input = filePart.getInputStream()) {
						Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
					} catch (Exception e) {
						e.printStackTrace();
					}

//			    System.out.println("2"+file.toPath());		        
//				System.out.println("3"+fileContent);
					Producto productito = new Producto(Integer.parseInt(parametroId),parametroNombre, parametroDes, Double.valueOf(parametroPrecio),
							request.getContextPath() + "/images/" + fileName, Integer.parseInt(parametroNumexis),
							parametroCodigo, Integer.parseInt(parametroIVA));
					// System.out.println("4");
					dao.updateProducto(productito);
				}else {
					Producto actualizar = dao.getProducto(Integer.parseInt(parametroId));
					
					Producto productito = new Producto(Integer.parseInt(parametroId),parametroNombre, parametroDes, Double.valueOf(parametroPrecio),
							actualizar.getImagen(), Integer.parseInt(parametroNumexis),
							parametroCodigo, Integer.parseInt(parametroIVA));
					// System.out.println("4");
					dao.updateProducto(productito);
				}
				// System.out.println("5");
				HttpSession session = request.getSession();
				synchronized (session) {
					session.setAttribute("listaProductos", dao.getProductos());
					response.sendRedirect(request.getContextPath() + "/usuario/producto.jsp");

				}
			}
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/usuario/producto.jsp");
			e.printStackTrace();
		}

	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {

			String parametroId = request.getParameter("idactualizar");

			if (parametroId != null || parametroId != "") {
				Producto pro = dao.getProducto(Integer.parseInt(parametroId));
				HttpSession session = request.getSession();
				synchronized (session) {
					session.setAttribute("ProductoActualizar", pro);
					response.sendRedirect(request.getContextPath() + "/usuario/productoActualizar.jsp");
				}

			}
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/usuario/producto.jsp");
		}

	}

	private void registrarProducto(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			String parametroNombre = request.getParameter("nombre");
			String parametroDes = request.getParameter("descripcion");
			String parametroPrecio = request.getParameter("precio");
			String parametroImage = request.getParameter("image");
			String parametroNumexis = request.getParameter("numExis");
			String parametroCodigo = request.getParameter("codigo");
			String parametroIVA = request.getParameter("iva");

			// System.out.println(parametroImage);
			if (parametroNombre == null || parametroNombre.isEmpty() || parametroDes == null || parametroDes.isEmpty()
					|| parametroPrecio == null || parametroPrecio.isEmpty() || parametroNumexis == null
					|| parametroNumexis.isEmpty() || parametroCodigo == null || parametroCodigo.isEmpty()
					|| parametroIVA == null || parametroIVA.isEmpty()) {
				String msg = "Error, Espacios Vacios";
				request.setAttribute("msgError", msg);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/usuario/productoRegistro.jsp");
				dispatcher.forward(request, response);
			} else {
				// System.out.println("1");

				Part filePart = request.getPart("image"); // Retrieves <input type="file" name="file">
				String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.

				String path = request.getServletContext().getRealPath("/images/");
				File file = new File(path + fileName);

				InputStream fileContent = filePart.getInputStream();

				try (InputStream input = filePart.getInputStream()) {
					Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
				} catch (Exception e) {
					e.printStackTrace();
				}

//			    System.out.println("2"+file.toPath());		        
//				System.out.println("3"+fileContent);
				Producto productito = new Producto(parametroNombre, parametroDes, Double.valueOf(parametroPrecio),
						request.getContextPath() + "/images/" + fileName, Integer.parseInt(parametroNumexis),
						parametroCodigo, Integer.parseInt(parametroIVA));
				// System.out.println("4");
				dao.createProducto(productito);
				// System.out.println("5");
				HttpSession session = request.getSession();
				synchronized (session) {
					session.setAttribute("listaProductos", dao.getProductos());
					response.sendRedirect(request.getContextPath() + "/usuario/producto.jsp");

				}
			}
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/usuario/producto.jsp");
			e.printStackTrace();
		}
	}
}
