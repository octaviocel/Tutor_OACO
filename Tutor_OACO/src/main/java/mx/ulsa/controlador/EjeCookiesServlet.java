package mx.ulsa.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.CookieUtilerias;
import util.LargaVidaCookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

/**
 * Servlet implementation class EjeCookiesServlet
 */
public class EjeCookiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EjeCookiesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			String action = request.getPathInfo();
			switch (action) {
			case "/":
				this.repetirVisitador(request, response);
				break;
			case "/tiposCookies":
				this.cookiesSessionVsCookiesPersistencia(request, response);
				break;
			case "/contadorCookies":
				this.contadorAccesosCliente(request, response);
				break;
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void repetirVisitador(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean esNuevo = true;
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie c = cookies[i];
				if((c.getName().equals("repetirVisitador")) && (c.getValue().equals("yes"))) {
					esNuevo= false;
					break;
				}
			}
		}
		String title;
		if(esNuevo) {
			Cookie regresaCookieVisitador = new Cookie("repetirVisitador", "yes");
			regresaCookieVisitador.setMaxAge(60*60*24*365);
			response.addCookie(regresaCookieVisitador);
			title = "Saludos Visitador";
		} else {
			title = "Saludos Nuevamente";
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String docType = "<!DOCTYPE>\n";
		out.println(docType+ "<HTML>\n"+"<HEAD><TITLE>"+title+"</TITLE></HEAD>\n"
				+ "<BODY BGCOLOR=\"#ECF6CE\">\n"+"<H1 ALIGN=\"CENTER\">"+ title+ "</H1>\n"+ "</BODY></HTML>");
	}
	
	private void cookiesSessionVsCookiesPersistencia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		for (int i = 0; i < 3; i++) {
			Cookie cookie = new Cookie("Session-Cookie-"+i, "Cookie-Value-S"+i);
			response.addCookie(cookie);
			cookie = new Cookie("Persistent-Cookie-"+i, "Cookie-Value-P"+i);
			cookie.setMaxAge(10);
			response.addCookie(cookie);
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String docType = "<!DOCTYPE>\n";
		String title = "Cookies Activas";
		out.println(docType+ "<HTML>\n"+"<HEAD><TITLE>"+title+"</TITLE></HEAD>\n"
				+ "<BODY BGCOLOR=\"#ECF6CE\">\n"+"<H1 ALIGN=\"CENTER\">"+ title+ "</H1>\n"
				+"<TABLE BORDER=1 ALIGN=\"CENTER\">\n"+"<TR BGCOLOR=\"#00FF40\">\n"
				+"<TH>Nombre Cookie\n"+"<TH>Valor Cookie");
		Cookie[] cookies = request.getCookies();
		if(cookies == null) {
			out.println("<TR><TH COLSPAN=2>No hay Cookies");
		}else {
			for (Cookie cookie: cookies) {
				out.println("<TR>\n"+"<TD>"+ cookie.getName()+"\n"+" <TD>"+ cookie.getValue());
				
			}
		}
		out.println("</TABLE></BODY></HTML>");	
	}
	
	private void contadorAccesosCliente(HttpServletRequest request, HttpServletResponse response)throws IOException{
		String countString = CookieUtilerias.getCookieValor(request, "contadorDeAccesos", "1");
		int count = 1;
		try {
			count = Integer.parseInt(countString);
		} catch (NumberFormatException e) {
		}
		LargaVidaCookie c = new LargaVidaCookie("contadorDeAccesos", String.valueOf(count+1));
		response.addCookie(c);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String docType = "<!DOCTYPE>\n";
		String title = "Servlet Contador de Accesos";
		out.println(docType+ "<HTML>\n"+"<HEAD><TITLE>"+title+"</TITLE></HEAD>\n"
				+ "<BODY BGCOLOR=\"#ECF6CE\">\n"+"<CENTER>\n<H1>"+ title+ "</H1>\n"+ 
				"<H2>Es el n&uacute;mero de visista "+count+" para &eacute;ste navegador.</H2>\n"
				+"</CENTER></BODY></HTML>");

	}
	
}
