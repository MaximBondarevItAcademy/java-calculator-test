public enum Operator {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");
    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public static Operator fromString(String symbol)  {
        for (Operator op : values()) {
            if (op.symbol.equals(symbol)) {
                return op;
            }
        }
        throw new IllegalArgumentException("Неизвестный оператор: " + symbol);
    }
}

