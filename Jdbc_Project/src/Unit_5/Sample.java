package Unit_5;

import java.sql.*;

public class Sample {
	public static void main(String[] args) throws SQLException {
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdatabase", "root", "root");
			myStmt = myConn.createStatement();
			int a = myStmt.executeUpdate("INSERT INTO jdbc_tbl VALUES (5, 'Mysql','Shashank', '2022-06-07')");
			myRs = myStmt.executeQuery("select * from jdbc_tbl");
			while (myRs.next()) {
				System.out.println(myRs.getString("jdbc_id") + ", " + myRs.getString("title") + ", "+ myRs.getString("author") + ", " + myRs.getString("submission_date"));
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			myRs.close();
			myStmt.close();
			myConn.close(); 
		}
	}
}
