package algorithm.programmerskit;

public class Carpet {

    public static void main(String[] args) {
        int brown = 24;
        int yellow = 24;

        Carpet t = new Carpet();

        int[] solution = t.solution(brown, yellow);
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }

    private int[] solution(int brown, int yellow) {

        int innerWidth = yellow;
        int innerHeight = 1;

        while (innerWidth >= innerHeight) {
            if (yellow % innerWidth != 0) {
                innerWidth--;
                continue;
            }
            innerHeight = yellow / innerWidth;


            int width = innerWidth + 2;
            int height = innerHeight + 2;

            if (isValidBrown(brown, width, height)) {
                return new int[]{width, height};
            }
            innerWidth--;
        }
        return null;
    }

    private boolean isValidBrown(int brown, int width, int height) {
        if (brown == calculateBrown(width, height)) {
            return true;
        }
        return false;
    }

    private int calculateBrown(int width, int height) {
        return (width * 2) + (height - 2) * 2;
    }
}
