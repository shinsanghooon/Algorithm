package algorithm.programmerskit;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class LifeBoat {

    public static void main(String[] args) {
        LifeBoat t = new LifeBoat();

//        1. [30, 30, 60], 160
//        2. [10, 50, 100], 160

        int[] people = {30, 30, 60};
        int limit = 160;
        int result = t.solution(people, limit);
        System.out.println("result = " + result);
    }

    public int solution(int[] people, int limit) {

        Arrays.sort(people);

        Queue<Integer> q = new LinkedList<>();
        for (int person : people) {
            q.add(person);
        }

        int count = 0;
        while(!q.isEmpty()){
            int sum = 0;
            int numberOfPeopleOnboard = 0;
            while (sum < limit && !q.isEmpty() && numberOfPeopleOnboard < 2) {
                int nextWeight = q.peek();
                if (sum + nextWeight > limit) {
                    break;
                } else {
                    sum += q.poll();
                    numberOfPeopleOnboard++;
                }
            }
            count++;
        }

        return count;
    }
}
