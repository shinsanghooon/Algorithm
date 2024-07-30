package algorithm.onepredict;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Square {

    static class Machine {

        Point currentPoint;
        List<Point> history = new ArrayList<>();

        public void move(String direction) {
            if ("U".equals(direction)) {
                this.currentPoint.y += 1;
            } else if ("R".equals(direction)) {
                this.currentPoint.x += 1;
            } else if ("D".equals(direction)) {
                this.currentPoint.y -= 1;
            } else {
                // L
                this.currentPoint.x -= 1;
            }
            history.add(new Point(this.currentPoint.x, this.currentPoint.y));
        }

        public Machine(Point currentPoint) {
            this.currentPoint = currentPoint;
            history.add(currentPoint);
        }
    }
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            return y == point.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Square t = new Square();

        String[] moves = {"U", "R", "D", "L", "U", "R", "D", "L"};
        int result = t.solution(moves);
        System.out.println("result = " + result);

    }

    private int solution(String[] directions) {

        Point initialPoint = new Point(0, 0);
        Machine machine = new Machine(initialPoint);

        for (String direction : directions) {
            machine.move(direction);
        }

        List<Point> history = machine.history;
        for (Point point : history) {
            System.out.println(point.x + " " +  point.y);
        }

        System.out.println("----");
        List<Point> duplicatePoints = getSecondVisitPoint(history);

        checkSqaurePath(duplicatePoints, history);


        return 0;
    }

    private void checkSqaurePath(List<Point> duplicatePoints, List<Point> history) {

    }

    private List<Point> getSecondVisitPoint(List<Point> history) {
        List<Point> duplicatePoints = new ArrayList<>();
        for (int i = 0; i < history.size(); i++) {
            for (int j = 0; j < history.size(); j++) {
                if (i != j) {
                    if (history.get(i).x == history.get(j).x && history.get(i).y == history.get(j).y) {
                        duplicatePoints.add(history.get(i));
                        break;
                    }
                }
            }
        }
        return duplicatePoints;
    }

}
