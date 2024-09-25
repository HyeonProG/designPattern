package singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/sakila?serverTimezone=Asia/Seoul";
    private static final String USER = "root";
    private static final String PASSWORD = "asd123";

    // 싱글톤 인스턴스
    private static DBConnection instance;
    private Connection connection;

    // private 생성자로 외부에서 인스턴스를 생성하지 못하도록 막음
    private DBConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // 싱글톤 인스턴스를 반환하는 메서드
    public static DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    // Connection 객체를 반환하는 메서드
    public Connection getConnection() {
        return connection;
    }
}
