import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class SonarQubeTest {

    // ���� ����� 1: �ϵ��ڵ��� ��й�ȣ
    private static final String DB_PASSWORD = "admin123"; // Noncompliant - ���� �����

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // ���� ����� 2: SQL ������ ���ɼ�
        System.out.print("Enter username: ");
        String userInput = scanner.nextLine();
        String query = "SELECT * FROM users WHERE username = '" + userInput + "'"; // Noncompliant - SQL ������

        try {
            // ���� 1: ���ҽ� ���� (Connection�� close���� ����)
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", DB_PASSWORD);
            Statement stmt = connection.createStatement();
            stmt.executeQuery(query);

            // ���� 2: �� ������ ���� ���ɼ�
            String data = null;
            if (data.length() > 0) { // Noncompliant
                System.out.println("Data: " + data);
            }

            // ���� 3: ��� ���� ���ɼ� (0���� ������)
            int number = 10;
            int divisor = 0;
            int result = number / divisor; // Noncompliant

        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }

        // �ڵ� ���� 1: ���ʿ��� ���ǹ�
        if (true) { // Noncompliant - �׻� true
            System.out.println("This will always execute.");
        }
    }
}