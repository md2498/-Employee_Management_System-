import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * @author mukesh.dadarwal
 *
 */
public class display_org_employee {
	public static void main(String[] args) throws SQLException {
		// Displaying the working employees associated with an organisation.

		String dbURL = "jdbc:mysql://172.17.10.152:3306/Employee_Management_System";
		String username = "root";
		String password = "password";

		Connection con = DriverManager.getConnection(dbURL, username, password);

		// Searching an employee by employee name / id / dept .

		String sql = "select * from employee where dept=?";

		String dept = "r&d";

		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, dept);

		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			System.out.println("id-" + rs.getString(1) + "  ,name-" + rs.getString(2) + " ,email" + rs.getString(3)
					+ " ,dept-" + rs.getString(4) + " ,salary" + rs.getString(5) + " ,contact-" + rs.getString(6));
		}

		pst.close();
		con.close();

	}
}
