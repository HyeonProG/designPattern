package singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/sakila?serverTimezone=Asia/Seoul";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "asd123";
    
    // 싱글톤 인스턴스
    private static DBConnection instance;
    
    // Connection 객체를 클래스 필드로 저장
    private Connection connection;
    
    // 생성자를 private으로 설정하여 외부에서 인스턴스화하지 못하게 함
    private DBConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    // 싱글톤 인스턴스 반환 메서드
    public static DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }
    
    public Connection getConnection() {
        return connection; // 기존 연결 반환
    }

    public void fetchData() {
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM actor");

            while (resultSet.next()) {
                System.out.println("id : " + resultSet.getInt("actor_id"));
                System.out.println("name : " + resultSet.getString("first_name") + " " + resultSet.getString("last_name"));
                System.out.println("lastUpdate : " + resultSet.getString("last_update"));
                System.out.println("==============================================");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // main 메서드
    public static void main(String[] args) {
        DBConnection dbConnection = DBConnection.getInstance(); // 싱글톤 인스턴스 사용
        dbConnection.fetchData();
    }
}
