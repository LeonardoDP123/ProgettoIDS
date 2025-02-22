import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/progetto_marketplace";
        String user = "root";
        String password = "RootPassword";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connesso al database MySQL!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

