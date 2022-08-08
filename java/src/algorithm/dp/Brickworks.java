package algorithm.dp;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Brick implements Comparable<Brick>{

    public int sqaure;
    public int height;
    public int weight;

    public Brick(int sqaure, int height, int weight) {
        this.sqaure = sqaure;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Brick point) {
        return -(this.sqaure - point.sqaure);
    }

    @Override
    public String toString() {
        return "Brick{" +
                "sqaure=" + sqaure +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}

public class Brickworks {

    static int[] dy;

    private int solution(int n, ArrayList<Brick> brickList) {
        int answer = 0;

        Collections.sort(brickList);

        dy[0] = brickList.get(0).height;
        answer = dy[0];

        for (int i = 1; i < n; i++) {
            int max_h = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (brickList.get(j).weight > brickList.get(i).weight && dy[j] > max_h) {
                    max_h = dy[j];
                }
            }
            dy[i] = max_h + brickList.get(i).height;
            answer = Math.max(answer, dy[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        Brickworks T = new Brickworks();
        Scanner sc = new Scanner(System.in);

        ArrayList<Brick> brickList = new ArrayList<Brick>();

        int n = sc.nextInt();
        dy = new int[n];
        for (int i = 0; i < n; i++) {
            int square = sc.nextInt();
            int height = sc.nextInt();
            int weight = sc.nextInt();
            brickList.add(new Brick(square, height, weight));
        }

        System.out.println(T.solution(n, brickList));


    }
}
