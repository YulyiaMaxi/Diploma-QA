package ru.netology.data;
import lombok.SneakyThrows;
import lombok.val;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import ru.netology.pages.OrdinaryPurchase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


//public class SQLHelper2 {
   // public static QueryRunner runner = new QueryRunner();


   /* public static Connection getConn() throws SQLException {
       return DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");
   // }

 // @SneakyThrows
  /*  private static OrdinaryPurchase.approvedOperationNotification notification() {
        var statusSQL = "SELECT status FROM payment_entity ORDER BY created LIMIT 1;";
        Connection conn = null;
        try {
            conn = getConn();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            var code = runner.query(conn, statusSQL, new ScalarHandler<String>());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }





    }
    @SneakyThrows
    public static void cleanDataBase() {
        var connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");;
        runner.execute(connection, "DELETE FROM credit_request_entity");
        runner.execute(connection, "DELETE FROM payment_entity");
        runner.execute(connection, "DELETE FROM order_entity");

    }
    public static class PaymentStatus {
    }
}
}
*/
