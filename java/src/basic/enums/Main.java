package basic.enums;


public class Main {
    public static void main(String[] args) {
        System.out.println(Direction.EAST);
        System.out.println(Direction.NORTH);
        System.out.println("---------------");

        Direction[] values = Direction.values();
        for (Direction value : values) {
            System.out.println("value = " + value);
        }
        System.out.println("---------------");

        Direction south = Direction.valueOf("SOUTH");
        System.out.println("south = " + south);
        System.out.println("---------------");

        System.out.println("Direction.WEST.getName() = " + Direction.WEST.getName());
        System.out.println("Direction.WEST.getNumber() = " + Direction.WEST.getNumber());
        System.out.println("Direction.of(4) = " + Direction.of(4));
    }

}
