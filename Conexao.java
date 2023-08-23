import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class used to connect and disconnect from the database.
 */
public class Conexao {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();
        conexao.desconectar(conn);
    }

    public Connection conectar() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "root");
            System.out.println("Connected to the database.");
        } catch (SQLException ex) {
            System.out.println("Error: Could not connect to the database.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: Could not find the database driver.");
        }
        return conn;
    }

    public void desconectar(Connection conn) {
        try {
            if(conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Disconnected from the database.");
            }
        } catch (SQLException ex) {
            System.out.println("Could not disconnect from the database.");
        }
    }
}
