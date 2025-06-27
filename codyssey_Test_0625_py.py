def calculator():
    try:
        num1 = float(input("첫 번째 숫자를 입력하세요: "))
        operator = input("연산자를 입력하세요 (+, -, *, /): ")
        num2 = float(input("두 번째 숫자를 입력하세요: "))

        if operator == '+':
            result = num1 + num2
        elif operator == '-':
            result = num1 - num2
        elif operator == '*':
            result = num1 * num2
        elif operator == '/':
            if num2 == 0:
                print("0으로 나눌 수 없습니다.")
                return
            result = num1 / num2
        else:
            print("올바른 연산자를 입력하세요.")
            return

        print("결과:", result)
    except ValueError:
        print("숫자를 정확히 입력해주세요.")

calculator()