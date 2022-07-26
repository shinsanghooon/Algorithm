package algorithm.stackqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class EduCurriculum {


    private String solution(String str1, String str2) {

        Queue<Character> queue = new LinkedList<>();
        for (char c : str1.toCharArray()) {
            queue.add(c);
        }

        for (char x : str2.toCharArray()) {
            if (queue.contains(x)) {
                if (x != queue.poll()) {
                    return "NO";
                }
            }
        }

        if (!queue.isEmpty()) {
            return "NO";
        }

        return "YES";
    }

    public static void main(String[] args) {

        EduCurriculum T = new EduCurriculum();
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();

        System.out.println(T.solution(str1, str2));
    }

}
