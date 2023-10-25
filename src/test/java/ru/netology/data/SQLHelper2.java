package ru.netology.data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SQLHelper2 {
    public static QueryRunner runner = new QueryRunner();

    private SQLHelper2(){

    }
    private static Connection getConn() throws SQLException {
        return DriverManager.getConnection("jdbc.mysql://localhost:3306/app", "app","pass");
    }
    @SneakyThrows
    public static PaymentStatus getPaymentStatus() {
        var statusSQL = "SELECT status FROM payment_entity;";
        var conn = getConn();
        var code = runner.query(conn,statusSQL,new ScalarHandler<String>());
        return new PaymentStatus();
    }
    @SneakyThrows
    public static void cleanDataBase() {
        var connection = getConn();
        runner.execute(connection, "DELETE FROM credit_request_entity");
        runner.execute(connection, "DELETE FROM payment_entity");
        runner.execute(connection, "DELETE FROM order_entity");

    }
    public static class PaymentStatus {
    }
}
