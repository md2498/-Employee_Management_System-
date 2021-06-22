import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class addEmployee {

	/**
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {

		String dbURL = "jdbc:mysql://172.17.10.152:3306/Employee_Management_System";
		String username = "root";
		String password = "password";

		Connection con = DriverManager.getConnection(dbURL, username, password);

		// if(con!=null){
		// System.out.println("connected");
		// con.close();
		// }
		// else{
		// System.out.println("not connected");
		// }
		String sql = "insert into employee(name,dept) values(?,?)";

		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, "arvind");
		pst.setString(2, "hr");

		int row = pst.executeUpdate();

		if (row > 0) {
			System.out.println("user inserted successfully");
		} else {
			System.out.println("not inserted");
		}

		pst.close();
		con.close();

	}

}
