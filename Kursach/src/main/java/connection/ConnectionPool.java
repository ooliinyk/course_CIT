package connection;



import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Connection Pool initializes pool and provides connections.
 */
public class ConnectionPool {

    private static DataSource ds;

    /**Initializes named data source */
    static {
        try {
            Context ic = new InitialContext();
            ds = (DataSource) ic.lookup("jdbc/NitConnectionPool");
        } catch (NamingException ex) {
            System.out.println("NamingException: " + ex.getMessage());
        }
    }

    /**
     * Returns connection from connection pool.
     * Sets connection auto commit to false.
     *
     * @return Connection
     * @throws java.sql.SQLException if a database access error occurs
     */
    public static Connection getConnection() throws SQLException {
        Connection conn = ds.getConnection();
        conn.setAutoCommit(false);
        return conn;
    }
}
