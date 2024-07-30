package algorithm.programmerskit;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Keypad {


    public static int[][] keypad = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {-1, 0, -1}
    };
    public static void main(String[] args) {
        Keypad t = new Keypad();

//        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
//        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";

        String result = t.solution(numbers, hand);
        System.out.println("result = " + result);
    }

    private String solution(int[] numbers, String hand) {

        ArrayList<String> result = new ArrayList<>();

        int rightHand = -1;
        int leftHand = -1;

        for (int idx = 0; idx < numbers.length; idx++) {
            int number = numbers[idx];

            if (number == 1 || number == 4 || number == 7) {
                result.add("L");
                leftHand = number;
            } else if (number == 3 || number == 6 || number == 9) {
                result.add("R");
                rightHand = number;
            } else {
                // 양 손의 거리를 구한다.
                int keypad_x = -1;
                int keypad_y = -1;
                int leftHand_x = -1;
                int leftHand_y = -1;
                int rightHand_x = -1;
                int rightHand_y = -1;

                for (int i = 0; i < keypad.length; i++) {
                    for (int j = 0; j < keypad[i].length; j++) {
                        if (keypad[i][j] == number) {
                            keypad_x = i;
                            keypad_y = j;
                        }
                        if (keypad[i][j] == leftHand) {
                            leftHand_x = i;
                            leftHand_y = j;
                        }
                        if (keypad[i][j] == rightHand) {
                            rightHand_x = i;
                            rightHand_y = j;
                        }
                    }
                }

                int distanceFromLeftHand = calculateDistanceFromHand(keypad_x, keypad_y, leftHand_x, leftHand_y);
                int distanceFromRightHand = calculateDistanceFromHand(keypad_x, keypad_y, rightHand_x, rightHand_y);

                if (distanceFromLeftHand == distanceFromRightHand) {
                    if(hand.equals("right")) {
                        result.add("R");
                        rightHand = number;
                    } else {
                        result.add("L");
                        leftHand = number;

                    }

                } else if (distanceFromLeftHand > distanceFromRightHand) {
                    result.add("R");
                    rightHand = number;
                } else {
                    result.add("L");
                    leftHand = number;
                }
            }
        };

        return result.stream().collect(Collectors.joining());
    }

    private int calculateDistanceFromHand(int keypadX, int keypadY, int handX, int handY) {
        return Math.abs(keypadX - handX) + Math.abs(keypadY - handY);
    }
}
