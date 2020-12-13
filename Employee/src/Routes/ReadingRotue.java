package Routes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

@WebServlet("/reading")
@MultipartConfig
public class ReadingRotue extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void init() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ranjith");
		Controller contr=new Controller();
		 List<DisEmployee> dataLst =contr.display() ;
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    Gson data = new Gson();
	    String tmp = data.toJson(dataLst); // won't work if you don't assign it to a string.
	    
	    response.getWriter().print(tmp);
	    QueryClass.ConnetionClose();
	}
}