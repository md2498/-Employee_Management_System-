import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author mukesh.dadarwal
 *
 */
public class deleteEmployee {

	public static void main(String[] args) throws SQLException {
		// Deleting employee details.
		String dbURL = "jdbc:mysql://172.17.10.152:3306/Employee_Management_System";
		String username = "root";
		String password = "password";

		Connection con = DriverManager.getConnection(dbURL, username, password);

		String sql = "delete from employee where id=?";

		int id = 2;

		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, id);
		int row = pst.executeUpdate();
		if (row > 0) {
			System.out.println("employee deleted");
		} else {
			System.out.println("employee not deleted");
		}

		pst.close();
		con.close();

	}

}
