import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class SonarQubeTest {

    // 보안 취약점 1: 하드코딩된 비밀번호
    private static final String DB_PASSWORD = "admin123"; // Noncompliant - 보안 취약점

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 보안 취약점 2: SQL 인젝션 가능성
        System.out.print("Enter username: ");
        String userInput = scanner.nextLine();
        String query = "SELECT * FROM users WHERE username = '" + userInput + "'"; // Noncompliant - SQL 인젝션

        try {
            // 버그 1: 리소스 누수 (Connection이 close되지 않음)
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", DB_PASSWORD);
            Statement stmt = connection.createStatement();
            stmt.executeQuery(query);

            // 버그 2: 널 포인터 접근 가능성
            String data = null;
            if (data.length() > 0) { // Noncompliant
                System.out.println("Data: " + data);
            }

            // 버그 3: 산술 오류 가능성 (0으로 나누기)
            int number = 10;
            int divisor = 0;
            int result = number / divisor; // Noncompliant

        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }

        // 코드 스멜 1: 불필요한 조건문
        if (true) { // Noncompliant - 항상 true
            System.out.println("This will always execute.");
        }
    }
}