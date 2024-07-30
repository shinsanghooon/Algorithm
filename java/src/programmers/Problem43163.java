package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Problem43163 {

    private static class CandidateState {
        public final String word;
        public final int step;

        public CandidateState(String word, int step) {
            this.word = word;
            this.step = step;
        }
    }

    public static void main(String[] args) {

        String begin = "hit";
        String target = "cog";

        String[] words = {"hot", "dot", " dog", "lot", "log", "cog"};
//        String[] words = {"hot", "dot", "dog", "lot", "log"};

        Problem43163 t = new Problem43163();

        int result = t.solution(begin, target, words);

        System.out.println("result = " + result);

    }

    public int solution(String begin, String target, String[] words) {
        boolean[] isVisited = new boolean[words.length];
        Queue<CandidateState> queue = new LinkedList<>();
        queue.offer(new CandidateState(begin, 0));

        while (!queue.isEmpty()) {
            CandidateState state = queue.poll();

            if (state.word.equals(target)) {
                return state.step;
            }

            for (int i = 0; i < words.length; i++) {
                String next = words[i];

                if (!isConvertable(state.word, next)) {
                    continue;
                }

                if (isVisited[i]) {
                    continue;
                }

                isVisited[i] = true;
                queue.add(new CandidateState(next, state.step + 1));
            }
        }
        return 0;
    }

    private boolean isConvertable(String word, String next) {
        char[] wordsArr = word.toCharArray();
        char[] nextArr = next.toCharArray();

        int diff = 0;
        for (int i = 0; i < wordsArr.length; i++) {
            if (wordsArr[i] != nextArr[i]) {
                diff++;
            }
        }

        return diff == 1;
    }

    public int solution2(String begin, String target, String[] words) {

        Queue<CandidateState> q = new LinkedList<>();
        int[] ch = new int[words.length];

        q.offer(new CandidateState(begin, 0));

        while (!q.isEmpty()) {
            CandidateState poll = q.poll();
            String word = poll.word;
            int L = poll.step;

            if (word.equals(target)) {
                return L;
            }

            ArrayList<CandidateState> candidates = new ArrayList<>();

            char[] beginChars = word.toCharArray();
            for (int idx = 0; idx < words.length; idx++) {

                if (word.equals(words[idx])) {
                    continue;
                }

                char[] candidateChars = words[idx].toCharArray();

                int count = 0;

                // abc, abb 비교시 count가 3이 나오므로 실패 !
                for (int i = 0; i < beginChars.length; i++) {
                    for (int j = 0; j < candidateChars.length; j++) {
                        if (beginChars[i] == candidateChars[j]) {
                            count++;
                        }
                    }
                }

                if (count == 2 && ch[idx] == 0) {
                    System.out.println("word = " + words[idx]);
                    System.out.println("ch[idx] = " + ch[idx]);
                    candidates.add(new CandidateState(words[idx], L+1));
                    ch[idx] = 1;
                }
            }

            for (CandidateState candidate : candidates) {
                q.offer(candidate);

            }
        }

        return 0;
    }

}
