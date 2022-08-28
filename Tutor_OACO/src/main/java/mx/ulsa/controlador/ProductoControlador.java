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
 * Servlet implementation class ProductoControlador
 */
public class ProductoControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductoControlador() {
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
				this.registrarProducto(request, response);
				break;
			default:
				response.sendRedirect(request.getContextPath() + "/");
				break;

			}

		} catch (Exception e) {
			e.printStackTrace();
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

			if (parametroNombre == null || parametroNombre.isEmpty() || parametroDes == null
					|| parametroDes.isEmpty() || parametroPrecio == null || parametroPrecio.isEmpty()
					|| parametroImage == null || parametroImage.isEmpty()
					|| parametroNumexis == null || parametroNumexis.isEmpty() || parametroCodigo == null
					|| parametroCodigo.isEmpty() || parametroIVA == null || parametroIVA.isEmpty()
					) {
				String msg = "Error, Espacios Vacios";
				request.setAttribute("msgError", msg);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/usuario/productoRegistro.jsp");
				dispatcher.forward(request, response);
			}
			else {
				response.sendRedirect(request.getContextPath() + "/usuario/producto.jsp");

			}
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/usuario/producto.jsp");

		}		
	}
}
