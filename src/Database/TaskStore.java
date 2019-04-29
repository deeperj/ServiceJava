package Database;

import Services.Task;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TaskStore extends database.DBConnection {

    private static final String INSERT_TASKS_SQL = "INSERT INTO admin_tasks" +
        "  (task_number, task_name, task_description) VALUES " +
        " (?, ?, ?);";

    public TaskStore(){
        super();
    }


    public boolean exists(Task k)  {
        try {
            //st.executeQuery("USE test");
            st.executeQuery("select * from admin_tasks where task_number=" + k.getTaskNumber());
            ResultSet rs = st.getResultSet();
            return rs.next();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean insert(Task k) {
        System.out.println(INSERT_TASKS_SQL);
        // Step 1: Establishing a Connection
         // Step 2:Create a statement using connection object
        try{
            PreparedStatement preparedStatement = conn.prepareStatement(INSERT_TASKS_SQL);
            preparedStatement.setInt(1, k.getTaskNumber());
            preparedStatement.setString(2, k.getTaskName());
            preparedStatement.setString(3, k.getTaskDescription());
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
