package algorithm.fit_together;

public class Pelindrom2 {

    public static void main(String[] args) {
        Pelindrom2 t = new Pelindrom2();
        int result  =t.solution("abcdcba");
        System.out.println("result = " + result);
    }
    public int solution(String s) {
        int wordLength = s.length();

        if (wordLength == 1) {
            return 1;
        }

        if (isPalindrome(s, 0, s.length())) {
            return wordLength;
        }

        int answer = 1;

        for (int i = 0; i < wordLength; i++) {
            if (wordLength - i < answer) {
                break;
            }

            int loc = wordLength - 1;

            while (loc - i + 1 > answer) {
                if (s.charAt(i) == s.charAt(loc) && isPalindrome(s, i, loc - i + 1)) {
                    answer = Math.max(answer, loc - i + 1);
                    break;
                }
                loc--;
            }
        }

        return answer;
    }

    public boolean isPalindrome(String word, int start, int length) {
        int start_loc = start;
        int end_loc = start + length - 1;
        while (start_loc < end_loc) {
            if (word.charAt(start_loc) != word.charAt(end_loc)) {
                return false;
            }
            start_loc++;
            end_loc--;
        }
        return true;
    }
}
