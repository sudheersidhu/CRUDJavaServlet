package JDBC.SQLQueries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import JDBC.inter.DataValues;
import JDBC.inter.QueeryGenator;

public class QueryClass {
	private static Connection cn;
	private static Statement st;
	private static PreparedStatement pst;

	private static Statement connection() {
		Statement st = null;
		try {
			cn = DriverManager.getConnection(DataValues.url, DataValues.user, DataValues.password);
			st = cn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return st;
	}

	private static PreparedStatement preparedConnection(String sql) {

		try {
			cn = DriverManager.getConnection(DataValues.url, DataValues.user, DataValues.password);
			pst = cn.prepareStatement(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return pst;
	}

	public  static void ConnetionClose() {
		try {
			if (st!=null) {
				st.close();
			}
			if (pst!=null) {
				pst.close();
			}
			if (cn!=null) {
				cn.close();
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	public static boolean insertData(String sql) {
		try {
			if (connection().execute(sql)) {
				return true;
			}
		} catch (SQLException e) {
			// TODO:handle exception
			e.printStackTrace();
		}finally {
			ConnetionClose();
		}

		return false;
	}

	public static ResultSet retriveData(String sql) {
		try {
			return connection().executeQuery(sql);
		} catch (Exception e) {
			// TODO:handle exception
			e.printStackTrace();
		} 
		return null;
	}

	public static PreparedStatement updateDate(String sql) {
		try {
			return preparedConnection(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static boolean UpdateStatus(String sql) {
		try {
			return connection().execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			ConnetionClose();
		}
		return false;
	}

	
}
