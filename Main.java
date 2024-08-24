public class Main {

    public static String calc(String input) {

        int operatorIndex = findOperatorIndex(input);
        if (operatorIndex == -1) {
            throw new IllegalArgumentException("Неверный формат ввода. Ожидается: <число> <операция> <число>");
        }
        char operation = input.charAt(operatorIndex);

        int a = Integer.parseInt(input.substring(0, operatorIndex).trim());
        int b = Integer.parseInt(input.substring(operatorIndex + 1).trim());

        if (a < 1 || a > 10 || b < 1 || b > 10) {
            //
            throw new IllegalArgumentException("Числа должны быть от 1 до 10.");
        }

        int result;
        switch (operation) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("Деление на ноль.");
                }
                result = a / b;
                break;
            default:
                throw new IllegalArgumentException("Недопустимая операция. Используйте: +, -, *, /.");
        }

        return String.valueOf(result);
    }

    private static int findOperatorIndex(String input) {
        char[] operators = {'+', '-', '*', '/'};
        for (char operator : operators) {
            int index = input.indexOf(operator);
            if (index != -1) {
                return index;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Введите выражение (например, 3 * 7):");

        java.io.Console console = System.console();
        if (console != null) {
            String input = console.readLine();
            try {
                String result = calc(input);
                System.out.println("Результат: " + result);
            } catch (Exception e) {
                System.err.println("Ошибка: " + e.getMessage());
            }
        } else {
            try {
                java.util.Scanner scanner = new java.util.Scanner(System.in);
                String input = scanner.nextLine();
                scanner.close();
                String result = calc(input);
                System.out.println("Результат: " + result);
            } catch (Exception e) {
                System.err.println("Ошибка: " + e.getMessage());
            }
        }
    }
}
