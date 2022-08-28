package mx.ulsa.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.CookieUtilerias;

import java.io.IOException;
import java.io.PrintWriter;

public class FormularioDeRegistroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FormularioDeRegistroServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String actionUrl = request.getContextPath() + "/RegistroServlet";
		String nombre = CookieUtilerias.getCookieValor(request, "nombre", "");
		String apellido = CookieUtilerias.getCookieValor(request, "apellido", "");
		String email = CookieUtilerias.getCookieValor(request, "email", "");
		String docType = "<!DOCTYPE>\n";
		String title = "Registro";
		out.println(docType+ "<HTML>\n"+"<HEAD><TITLE>"+title+"</TITLE></HEAD>\n"
				+ "<BODY BGCOLOR=\"#ECF6CE\">\n"+"<CENTER>\n<H1>"+ title+ "</H1>\n"
				+"<FORM ACTION=\""+actionUrl+"\" METHOD=\"POST\">\n"+ "Nombre:\n"+"<INPUT TYPE=\"TEXT\" NAME=\"nombre\""+
				"VALUE=\""+ nombre+ "\"> <BR>\n"
				+"Apellido:\n"+"<INPUT TYPE=\"TEXT\" NAME=\"apellido\""+
				"VALUE=\""+ apellido+ "\"> <BR>\n"
				+"Email:\n"+"<INPUT TYPE=\"TEXT\" NAME=\"email\""+
				"VALUE=\""+ email+ "\"> <P>\n"
				+"<INPUT TYPE=\"SUBMIT\" VALUE=\"Registro\">\n"
				+"</FORM></CENTER></BODY></HTML>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
