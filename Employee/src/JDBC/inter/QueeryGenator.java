package JDBC.inter;

import JDBC.Models.Employee;

public class QueeryGenator {
	public static String insertStringforExecution(Employee employee) {
		return "Insert into employee value('" + employee.id + "','" + employee.name + "','" + employee.dateFormat
				+ "','" + employee.department + "'," + employee.salary + ",'" + employee.experience + "','"
				+ employee.permanent + "','" + employee.presentAddress + "','" + employee.qualification + "','"
				+ employee.university + "'," + employee.percentage + ",'" + employee.year + "'," + employee.contactNo
				+ ",'" + employee.emailID + "','" + employee.status + "');";
	}

	public static String selectQuerry() {
		return "Select id,name,dateofjoin,department,contactno,emailid,qualification,status from employee;";
	}

	public static String selectQuerry(String id) {
		return "Select * from employee where id='" + id + "';";
	}

	public static String updateQuerry(String id) {
		return "UPDATE employee SET id=?,name=?,dateofjoin=?,department=?,salary=?,experience=?,permanent=?,present=?,qualification=?,colleage=?,precentage=?,completionyear=?,contactno=?,emailid=? WHERE id='"
				+ id + "';";

	}

	public static String statusChangeQuerry(String id) {
		return "update employee set status= Case When status='true' then 'false' when status='false' then 'true' end where id='"
				+ id + "';";
	}

	public static String adminChecking(String name, String password) {
		return "SELECT NAME,PASSWORD FROM users WHERE NAME='" + name + "' and PASSWORD='" + password + "' ;";
	}
}