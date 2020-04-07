package MusicAlbum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Database ourInstance;

    static {
        try {
            ourInstance = new Database();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Database getInstance() {
        return ourInstance;
    }

    public Database() throws Exception {
        Connection conn = null;
        //String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://Mysql@127.0.0.1:3306/musicalbums";
        String username = "dba";
        String password = "sql";
        try {
            //Class.forName(driver);

            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected");
        } catch (SQLException e) {
            System.err.println("Cannot connect to DB: " + e);
        } finally {
            if (conn != null) conn.close() ;
        }
    }
}
