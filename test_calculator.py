from unittest.mock import patch
import pytest
import calculator
from calculator import add, subtract, multiply, divide

# 덧셈 연산 테스트
@patch('builtins.input', side_effect=['12', '+', '7'])
@patch('builtins.print')
def test_main_add(mock_print, mock_input):
    # calculator 모듈의 main 실행 환경 설정
    calculator.__name__ = "__main__"
    calculator.main()

    # 기대하는 결과값 출력 검증
    mock_print.assert_called_with('Result: 19')

# 뺄셈 연산 테스트
@patch('builtins.input', side_effect=['20', '-', '5'])
@patch('builtins.print')
def test_main_subtract(mock_print, mock_input):
    calculator.__name__ = "__main__"
    calculator.main()

    mock_print.assert_called_with('Result: 15')

# 곱셈 연산 테스트
@patch('builtins.input', side_effect=['4', '*', '3'])
@patch('builtins.print')
def test_main_multiply(mock_print, mock_input):
    calculator.__name__ = "__main__"
    calculator.main()

    mock_print.assert_called_with('Result: 12')

# 나눗셈 연산 테스트
@patch('builtins.input', side_effect=['8', '/', '2'])
@patch('builtins.print')
def test_main_divide(mock_print, mock_input):
    calculator.__name__ = "__main__"
    calculator.main()

    mock_print.assert_called_with('Result: 4')

# 0으로 나누었을 때 예외처리 테스트
@patch('builtins.input', side_effect=['5', '/', '0'])
@patch('builtins.print')
def test_main_divide_by_zero(mock_print, mock_input):
    calculator.__name__ = "__main__"
    calculator.main()

    # 0으로 나누기 예외 메시지 출력 확인
    mock_print.assert_called_with('Error: Division by zero.')

# 잘못된 연산자 입력 시 예외처리 테스트
@patch('builtins.input', side_effect=['9', '%', '3'])
@patch('builtins.print')
def test_main_invalid_operator(mock_print, mock_input):
    calculator.__name__ = "__main__"

    # 잘못된 연산자가 들어왔을 때 프로그램 종료(SystemExit) 여부 확인
    with pytest.raises(SystemExit):
        calculator.main()

    # 잘못된 연산자 예외 메시지 출력 확인
    mock_print.assert_called_with('Invalid operator.')
