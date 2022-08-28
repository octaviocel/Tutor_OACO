package mx.ulsa.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.LargaVidaCookie;

import java.io.IOException;
import java.io.PrintWriter;

public class RegistroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegistroServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		boolean isMissingValue = false;
		String nombre = request.getParameter("nombre");
		if(isMissing(nombre)) {
			nombre="Nombre";
			isMissingValue=true;
		}
		String apellido = request.getParameter("apellido");
		if(isMissing(apellido)) {
			apellido="Apellido";
			isMissingValue=true;
		}
		String email = request.getParameter("email");
		if(isMissing(email)) {
			email="email@abc.com";
			isMissingValue=true;
		}
		
		Cookie c1 = new LargaVidaCookie("nombre", nombre);
		response.addCookie(c1);
		Cookie c2 = new LargaVidaCookie("apellido", apellido);
		response.addCookie(c2);
		Cookie c3 = new LargaVidaCookie("email", email);
		response.addCookie(c3);
		
		String servletFormulario =  request.getContextPath()+"FormularioDeRegistroServlet";
		if(isMissingValue) {
			response.sendRedirect(servletFormulario);
		}else {
			PrintWriter out = response.getWriter();
			String docType = "<!DOCTYPE>\n";
			String title = "RegistroCompletado";
			out.println(docType+ "<HTML>\n"+"<HEAD><TITLE>"+title+"</TITLE></HEAD>\n"
					+ "<BODY BGCOLOR=\"#ECF6CE\">\n"+"<CENTER>\n<H1>"+ title+ "</H1>\n"+ 
					"<UL>\n"
					+"<LI><B>Nombre</B>: "+nombre+"\n"
					+"<LI><B>Apellido</B>: "+apellido+"\n"
					+"<LI><B>Email</B>: "+email+"\n"
					+"</UL>\n"
					+"</CENTER></BODY></HTML>");
		}
	}

	private boolean isMissing(String param) {
		return ((param ==null)||(param.trim().equals("")));
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
