import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение (например, 2 + 3):");

        try {
            String input = scanner.nextLine();
            String result = calc(input);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static String calc(String input) throws IllegalArgumentException, ArithmeticException {
        input = input.trim();
        String[] parts = input.split(" ");

        if (parts.length != 3) {
            throw new IllegalArgumentException("Неверный формат ввода. Используйте формат: 'a оператора b'");
        }

        int a = parseNumber(parts[0]);
        String operator = parts[1];
        int b = parseNumber(parts[2]);

        switch (Operator.fromString(operator)) {
            case ADD:
                return String.valueOf(a + b);
            case SUBTRACT:
                return String.valueOf(a - b);
            case MULTIPLY:
                return String.valueOf(a * b);
            case DIVIDE:
                if (b == 0) {
                    throw new ArithmeticException("Ошибка: Деление на ноль!");
                }
                return String.valueOf(a / b);
            default:
                throw new UnsupportedOperationException("Неизвестная операция: " + operator);
        }
    }

    private static int parseNumber(String numStr)  {
        try {
            int number = Integer.parseInt(numStr);
            if (number < 1 || number > 11) {
                throw new IllegalArgumentException("Число должно быть в диапазоне от 1 до 11 включительно.");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Неправильный ввод числа: " + numStr);
        }

    }
}