package programmers.problem43238;

public class Problem43238 {


    private boolean isValid(long t, int n, int[] times) {
        long c = 0;
        for (int time : times) {
            c += t / time;
        }

        return c >= n;
    }
    public long solution(int n, int[] times) {

        long start = 1;
        long end = 1000;

        while (end > start) {



            long t = (start + end) / 2;
            System.out.print(" start: " + start + "/ end: " + end + "/ t: " + t + "\n");
            System.out.println("--------------------------------");

            if (isValid(t, n, times)) {
                end = t;
            } else {
                start += 1;
            }
        }

        return start;
    }

    public static void main(String[] args) {
        Problem43238 Problem43238 = new Problem43238();

        int n = 6;
        int[] time = new int[]{7, 10};

        long result = Problem43238.solution(n, time);
        System.out.println("result = " + result);
    }
}
