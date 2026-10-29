import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCInsert {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String username = "root";
        String password = "root";

        try {
            // Step 1: Establish connection
            Connection con = DriverManager.getConnection(
                url, username, password
            );

            // Step 2: Prepare SQL query
            String query =
                "INSERT INTO student (id, name, marks) VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query);

            // Step 3: Set values
            ps.setInt(1, 101);
            ps.setString(2, "Ravi");
            ps.setInt(3, 85);

            // Step 4: Execute insert query
            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Record inserted successfully!");
            }

            // Step 5: Close resources
            ps.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}.
