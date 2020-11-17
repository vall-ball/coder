package correcter;

import java.util.Random;
@Deprecated
public class MessageUtils {
    public final static char[] massOfChar = massOfChar();

    private static char[] massOfChar() {
        char[] massOfChar = new char[63];
        massOfChar[0] = ' ';
        for (int i = 1; i <= 10; i++) {
            massOfChar[i] = (char) (47 + i);
        }
        for (int i = 11; i < 37; i++) {
            massOfChar[i] = (char) (64 + i - 10);
        }
        for (int i = 37; i < 63; i++) {
            massOfChar[i] = (char) (96 + i - 36);
        }
        return massOfChar;
    }



    //split the string to 3-simbols arrays
    public char[][] splitMass(char[] str) {
        int length = str.length / 3;
        int remainder = str.length % 3;
        if (remainder != 0) {
            length++;
        }
        char[][] answer = new char[length][];

        if (remainder == 0) {
            for (int i = 0; i < answer.length; i++) {
                answer[i] = new char[3];
            }
        } else {
            for (int i = 0; i < answer.length - 1; i++) {
                answer[i] = new char[3];
            }
            answer[answer.length - 1] = new char[remainder];
        }

        if (remainder == 0) {
            for (int i = 0; i < str.length; i++) {
                answer[i / 3][i % 3] = str[i];

            }
        } else {

            for (int i = 0; i < str.length - remainder; i++) {
                answer[i / 3][i % 3] = str[i];
            }
            int j = 0;
            for (int i = str.length - remainder; i < str.length; i++) {
                answer[answer.length - 1][j] = str[i];
                j++;
            }
        }
        return answer;
    }

    public String generateString(char[][] str) {
        StringBuilder builder = new StringBuilder();
        for (char[] m : str) {
            for (char c : m) {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
