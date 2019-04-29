package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

private static final String INSERT_USERS_SQL = "INSERT INTO users" +
    "  (id, name, email, country, password) VALUES " +
    " (?, ?, ?, ?, ?);";

public class EvidenceStore extends database.DBConnection {
    public EvidenceStore(){
        super();
    }

    public boolean insert() throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        // Step 1: Establishing a Connection
         // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = conn.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, "Tony");
            preparedStatement.setString(3, "tony@gmail.com");
            preparedStatement.setString(4, "US");
            preparedStatement.setString(5, "secret");

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {

            // print SQL exception information
            printSQLException(e);
            return false;
        }

        // Step 4: try-with-resource statement will auto close the connection.
    }

}
