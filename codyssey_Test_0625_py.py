def calculator():
    try:
        num1 = float(input("ù ��° ���ڸ� �Է��ϼ���: "))
        operator = input("�����ڸ� �Է��ϼ��� (+, -, *, /): ")
        num2 = float(input("�� ��° ���ڸ� �Է��ϼ���: "))

        if operator == '+':
            result = num1 + num2
        elif operator == '-':
            result = num1 - num2
        elif operator == '*':
            result = num1 * num2
        elif operator == '/':
            if num2 == 0:
                print("0���� ���� �� �����ϴ�.")
                return
            result = num1 / num2
        else:
            print("�ùٸ� �����ڸ� �Է��ϼ���.")
            return

        print("���:", result)
    except ValueError:
        print("���ڸ� ��Ȯ�� �Է����ּ���.")

calculator()