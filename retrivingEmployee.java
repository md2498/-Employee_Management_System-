import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.ResultSet;

/**
 * @author mukesh.dadarwal
 *
 */
public class retrivingEmployee {

	/**
	 * @param args
	 * @throws SQLException
	 */

	public static void main(String[] args) throws SQLException {
		String dbURL = "jdbc:mysql://172.17.10.152:3306/Employee_Management_System";
		String username = "root";
		String password = "password";

		Connection con = DriverManager.getConnection(dbURL, username, password);

		// Searching an employee by employee name / id / dept .

		String sql1 = "select * from employee where name='mukesh'";
		String sql2 = "select * from employee where dept='hr'";
		String sql3 = "select * from employee where id<3";

		Statement smt = con.createStatement();
		ResultSet rs = smt.executeQuery(sql3);

		while (rs.next()) {
			System.out.println("id-" + rs.getString(1) + "  ,name-" + rs.getString(2) + " ,email" + rs.getString(3)
					+ " ,dept-" + rs.getString(4) + " ,salary" + rs.getString(5) + " ,contact-" + rs.getString(6));
		}
		smt.close();
		con.close();
	}

}
