package basic.enums;

enum Direction {
    EAST(1, "A"),
    SOUTH(2, "B"),
    WEST(3, "C"),
    NORTH(4, "D");

    private static final Direction[] DIR_ARR = Direction.values();
    private final int value;
    private final String name;

    Direction(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getNumber() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static Direction of(int num) {
        if (num < 1 || num > 4) {
            throw new IllegalArgumentException("Invalid value");
        }
        return DIR_ARR[num-1];
    }

}
