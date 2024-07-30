package algorithm.programmerskit;

public class Pccp2Robot {

    static class Robot {
        int x = 0;
        int y = 0;
        String direction = "U";

        String[] directions = {"U", "R", "D", "L"};

        public void rotate(String rotate) {
            int index = findDirectionIndex();
            int offset = getOffset(rotate, index);
            this.direction = directions[offset];
        }

        private int getOffset(String rotate, int index) {
            int offset;
            if (rotate.equals("R")) {
                offset = (index + 1) % directions.length;
            } else {
                // if index가 0일 떈 -1 하면 안됨
                // 0일 땐 3이 나와야 함
                // 인덱스가 1일 땐 0이 나와야 함

                offset = (index + 3) % directions.length;
            }
            return offset;
        }

        private int findDirectionIndex() {
            for (int i = 0; i < directions.length; i++) {
                if (direction.equals(directions[i])) {
                    return i;
                }
            }
            return -1;
        }


        public void move(String move) {
            if (direction.equals("R")) {
                moveRight(move);
            } else if (direction.equals("L")) {
                moveLeft(move);
            } else if (direction.equals("U")) {
                moveUp(move);
            } else {
                moveDown(move);
            }
        }

        private void moveDown(String move) {
            if (move.equals("G")) {
                this.y -= 1;
            } else {
                this.y += 1;
            }
        }

        private void moveUp(String move) {
            if (move.equals("G")) {
                this.y += 1;
            } else {
                this.y -= 1;
            }
        }

        private void moveLeft(String move) {
            if (move.equals("G")) {
                this.x -= 1;
            } else {
                this.x += 1;
            }
        }

        private void moveRight(String move) {
            if (move.equals("G")) {
                this.x += 1;
            } else {
                this.x -= 1;
            }
        }
    }

    public static void main(String[] args) {
        Pccp2Robot t = new Pccp2Robot();

        String command = "GRGRGRBRGRBRGRBBBBGGGGGGRLGBRLGBGRLGB";
        int[] result = t.solution(command);
        for (int i : result) {
            System.out.println("i = " + i);
        }
    }

    private int[] solution(String command) {

        char[] commands = command.toCharArray();

        Robot robot = new Robot();
        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == 'R' || commands[i] == 'L') {
                robot.rotate(String.valueOf(commands[i]));
            } else {
                robot.move(String.valueOf(commands[i]));
            }
        }

        return new int[]{robot.x, robot.y};
    }
}
