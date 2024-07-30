package algorithm.fit_together;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Stream;

public class Pelindrom {

    public static void main(String[] args) {
        Pelindrom t = new Pelindrom();

        int result = t.solution("abced");
        System.out.println("result = " + result);
    }

    public int solution(String s) {

        char[] chars = s.toCharArray();

        // lt, rt
        // lt + 1 ==rt 이거나 lt == rt 이면 끝
        int word_count = 0;
        int lt = 0;
        int rt = chars.length - 1;

        while(true) {

            if(lt == rt) {
                break;
            }

            if(lt + 1 == rt && chars[lt] == chars[rt]) {
                break;
            }

            if(chars[lt] != chars[rt]) {
                char aChar = chars[lt];
                System.out.println("word_count = " + word_count);
                char[] chars1 = Arrays.copyOfRange(chars, 0, chars.length - word_count);
                String second = String.valueOf(aChar);
                char[] chars2 = Arrays.copyOfRange(chars, chars.length - word_count, chars.length);

                char[] combined = new char[chars1.length + second.length() + chars2.length];
                System.arraycopy(chars1, 0, combined, 0, chars1.length);
                System.arraycopy(second.toCharArray(), 0, combined, chars1.length, second.length());
                System.arraycopy(chars2, 0, combined, chars1.length + second.length(), chars2.length);

                word_count++;
                chars = combined;
                lt = 0;
                rt = chars.length - 1;
            }

            lt++;
            rt--;
        }

        return chars.length;
    }
}
