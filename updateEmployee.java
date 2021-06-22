import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author mukesh.dadarwal
 *
 */
public class updateEmployee {
	public static void main(String[] args) throws SQLException {

		// Editing the details of the employee like salary, contact no, mail-id
		// etc
		String dbURL = "jdbc:mysql://172.17.10.152:3306/Employee_Management_System";
		String username = "root";
		String password = "password";

		Connection con = DriverManager.getConnection(dbURL, username, password);

		int salary = 200000;
		String contct_NO = "9511224433";
		String mail_id = "arvinf@gmail.com";

		String sql = "update employee set salary=?,contact=?,email=? where id=2";

		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, salary);
		pst.setString(2, contct_NO);
		pst.setString(3, mail_id);

		int row = pst.executeUpdate();

		if (row > 0) {
			System.out.println("updated employee successfully");
		} else {
			System.out.println("can't updated ");
		}

		pst.close();
		con.close();

	}
}
