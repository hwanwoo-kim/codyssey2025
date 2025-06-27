import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("ù ��° ���ڸ� �Է��ϼ���: ");
        double num1 = scanner.nextDouble();

        System.out.println("�� ��° ���ڸ� �Է��ϼ���: ");
        double num2 = scanner.nextDouble();

        System.out.println("�����ڸ� �Է��ϼ��� (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

        double result;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    System.out.println("0���� ���� �� �����ϴ�.");
                    return;
                }
                result = num1 / num2;
                break;
            default:
                System.out.println("�ùٸ� �����ڰ� �ƴմϴ�.");
                return;
        }

        System.out.println("���: " + result);
    }
}