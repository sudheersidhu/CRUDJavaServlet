package Routes;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import JDBC.Controller.Controller;
import JDBC.Models.DisEmployee;
import JDBC.Models.Employee;
import JDBC.SQLQueries.QueryClass;
import JDBC.inter.DataValues;

@WebServlet("/insert")
@MultipartConfig
public class InsertRoute extends HttpServlet {
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

		Employee e = new Employee();
		PrintWriter pw=response.getWriter();
		e.id = req.getParameter("id1");
		e.setName(req.getParameter("fname") + " " + req.getParameter("lname"));
		e.dateFormat = req.getParameter("date");
		e.department = req.getParameter("Department");
		e.salary = Float.parseFloat(req.getParameter("sal"));
		e.contactNo = req.getParameter("num");
		e.emailID = req.getParameter("mail");
		e.experience = req.getParameter("ex");
		e.qualification = req.getParameter("qua");
		e.university = req.getParameter("col");
		e.percentage = Float.parseFloat(req.getParameter("per"));
		e.year = req.getParameter("com");
		e.permanent = req.getParameter("perm");
		e.presentAddress = req.getParameter("pres");
		e.status = true;

		Controller ctr = new Controller();
		if (ctr.insert(e)) {
			System.out.println("false");
		} else {
			pw.println("<script type=\"text/javascript\">");
			pw.println("$('[href='#Read']').tab('show');");
			pw.println("</script>");
			pw.close();			
		}	
	}

}
