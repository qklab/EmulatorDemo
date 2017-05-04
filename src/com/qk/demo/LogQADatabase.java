package com.qk.demo;

import java.io.FileInputStream;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class LogQADatabase {
	
	String pagecode;
	String ispcode;
	int bandwidth;
	double responsetime;
	String errocode;
	String pagefail;
	String custcode;
	String appcode;
	String starttime;
	
	public void LogToQADB(String pagecode, String ispcode, int qadbbandwidth, double responsetime, String errocode, String pagefail, String custcode, String appcode, String starttime) {
		String insertquery;
		String selectquery;
		String scheduleid = null;
		String db_url;
		String db_driver = null;
		String db_ip;
		String db_port;
		String db_name;
		String db_username;
		String db_password;

		Connection conn = null;
		Statement stmt = null;
		try {
			// Register JDBC driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			// Reading Database Connection Parameters
			Properties prop = new Properties();
			prop.load(new FileInputStream("C:/DBConfig/config.properties"));
			db_driver = prop.getProperty("db_driver");
			db_ip = prop.getProperty("db_ip");
			db_port = prop.getProperty("db_port");
			db_name = prop.getProperty("db_name");
			db_username = prop.getProperty("db_username");
			db_password = prop.getProperty("db_password");
			
			db_url = "jdbc:sqlserver://" + db_ip + ":" + db_port + ";databaseName=" + db_name;
			
			System.out.println(db_url);
			
			// Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(db_url, db_username, db_password);
			
            System.out.println("#-----#-----#");
			System.out.println(conn.isClosed());

			stmt = conn.createStatement();
			ResultSet rs;
			
	
			// custcode = "My Solution Guru";
			// appcode = "My Solution Guru";
			// starttime = "2015-06-01 00:00:00";
			// pagecode = "Test Page 01";
			// ispcode = "";
			// bandwidth = 0;
			// responsetime = 2.001;
			// errocode = "E";
			// pagefail = "PF ";

			// Query to get schedule ID
			selectquery = "select qalogin1.GetSch2(" + "'" + custcode + "'," + "'" + appcode + "'," + "'" + starttime
					+ "'" + ") as ScheduleID";
			System.out.println(selectquery);

			rs = stmt.executeQuery(selectquery);
			while (rs.next()) {
				scheduleid = rs.getString("ScheduleID");
				System.out.println(scheduleid);
			}

			// insert into database
			insertquery = "insert into AppPageResponseMonitorDetails(ScheduleID,PageCode,ISPCode,BandWidth,PageResponseTime,ErrorCode,PageFails)"
					+ "values(" + "'" + scheduleid + "'," + "'" + pagecode + "'," + "'" + ispcode + "'," + "'"
					+ bandwidth + "'," + "'" + responsetime + "'," + "'" + errocode + "'," + "'" + pagefail + "'" + ")";
			System.out.println(insertquery);
			
			stmt.executeUpdate(insertquery);

			conn.close();
			System.out.println(conn.isClosed());

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		System.out.println("Goodbye!");
	}


	/**
	 * 
	 */
	public LogQADatabase() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param pagecode
	 * @param ispcode
	 * @param bandwidth
	 * @param responsetime
	 * @param errocode
	 * @param pagefail
	 * @param custcode
	 * @param appcode
	 * @param starttime
	 */
	public LogQADatabase(String pagecode, String ispcode, int bandwidth, double responsetime, String errocode,
			String pagefail, String custcode, String appcode, String starttime) {
		super();
		this.pagecode = pagecode;
		this.ispcode = ispcode;
		this.bandwidth = bandwidth;
		this.responsetime = responsetime;
		this.errocode = errocode;
		this.pagefail = pagefail;
		this.custcode = custcode;
		this.appcode = appcode;
		this.starttime = starttime;
	}


	@Override
	public String toString() {
		return "LogQADatabase [pagecode=" + pagecode + ", ispcode=" + ispcode + ", bandwidth=" + bandwidth
				+ ", responsetime=" + responsetime + ", errocode=" + errocode + ", pagefail=" + pagefail + ", custcode="
				+ custcode + ", appcode=" + appcode + ", starttime=" + starttime + "]";
	}
}

