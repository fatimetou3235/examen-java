package Repository.jdbc.Mysql;

import Repository.jdbc.Mysql.DataSource;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class MysqlDataSource implements DataSource {
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD ="";
    public static final String NOM_BASE = "stock";

    public static final String IP = "localhost";
    public static final String PORT = "3306";

    public Connection Connection(){
        try {
            Class c = Class.forName("com.mysql.jdbc.Driver");
            Driver pilote = (Driver) c.newInstance();
            DriverManager.registerDriver(pilote);
            String protocole = "jdbc:mysql:";
            String ip = IP;
            String port = PORT;
            String nomBase = NOM_BASE;
            String chaineDeConnexion = protocole + "//" + ip + ":" + port + "/" + nomBase;
            String dbUser = DB_USER;
            String dbPassword = DB_PASSWORD;
            return DriverManager.getConnection(chaineDeConnexion, dbUser, dbPassword);
        }
        catch (Exception ex){
            System.err.println("erreur connexion: ");
            System.err.println(ex.getMessage());
            return null;
        }
    }
}
