package Routes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JDBC.Controller.Controller;
import JDBC.SQLQueries.QueryClass;
import JDBC.inter.MainInte;

@WebServlet("/login")
@MultipartConfig
public class LoginRoute extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void init() {
		// 1. Load JDBC driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MainInte ctr = new Controller();
		PrintWriter out = resp.getWriter();
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		if (ctr.Auth(name, password)) {
			System.out.println("done");
			resp.sendRedirect("Landingpage.html");
		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Password wrong');");
			
			out.println("</script>");

		}	
	}
}
