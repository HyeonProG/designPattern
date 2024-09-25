package singleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DBMainTest {

    public static void main(String[] args) {

        // 싱글톤 인스턴스를 통해 데이터베이스 연결 가져오기
        DBConnection dbConnection = DBConnection.getInstance();
        Connection conn = dbConnection.getConnection();

        if (conn != null) {
            try (Scanner scanner = new Scanner(System.in)) {

                System.out.print("사용자 이름을 입력하세요: ");
                String userName = scanner.nextLine();

                // PreparedStatement를 사용하여 SQL 인젝션을 방지한 쿼리 작성
                String query = "SELECT * FROM users WHERE name = ?";

                try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                    pstmt.setString(1, userName);  // 사용자 입력값 바인딩
                    ResultSet resultSet = pstmt.executeQuery();

                    // 결과 처리
                    while (resultSet.next()) {
                        System.out.println("사용자 ID: " + resultSet.getInt("id"));
                        System.out.println("사용자 이름: " + resultSet.getString("name"));
                        System.out.println("사용자 이메일: " + resultSet.getString("email"));
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // 데이터베이스 연결 해제
                try {
                    if (conn != null && !conn.isClosed()) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("데이터베이스 연결에 실패했습니다.");
        }
    }
}
