package parainfo.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author parainformaticos.com
 */
public class ConectaDb  {

    public Connection getConnection() throws SQLException {
        Connection cn = null;

        try {
            Class.forName(driver).newInstance();
            cn = DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException 
                | InstantiationException 
                | IllegalAccessException ex) {
            
            throw new SQLException(ex.getMessage());
        }

        return cn;
    }

    public ConectaDb() {
    }

    public ConectaDb(String database) {
        url = "jdbc:mysql://localhost:3306/" + database;
    }

    private String url = "jdbc:mysql://localhost:3306/parainfo";
    private final String driver = "com.mysql.jdbc.Driver";
    private final String user = "root";
    private final String password = "sasa";
}

