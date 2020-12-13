package Routes;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import JDBC.Controller.Controller;
import JDBC.Models.DisEmployee;
import JDBC.SQLQueries.QueryClass;

@WebServlet("/delete")
@MultipartConfig
public class DeleteRoute extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void init() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		Controller ctr = new Controller();
		String id = req.getParameter("id1");
		if (ctr.delete(id)) {
			System.out.println("false");
		} else {
			List<DisEmployee> dataLst = ctr.display();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			Gson data = new Gson();
			String tmp = data.toJson(dataLst); // won't work if you don't assign

			response.getWriter().write(tmp);
		}	
	}

}
