package br.fatec;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    private static String host = "localhost";
    private static String port = "5432";
    private static String db = "db_personagens";
    private static String user = "postgres";
    private static String password = "123456";

    public static Connection obterConexao() throws Exception{
        var s = String.format(
        "jdbc:postgresql://%s:%s/%s", host, port, db);

        Connection c = DriverManager.getConnection(s, user, password);
        return c;
  }
} 