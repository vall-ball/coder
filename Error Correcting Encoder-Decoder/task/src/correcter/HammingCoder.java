package correcter;

public class HammingCoder {

    public String firstHalf(String str) {
        return str.substring(0, str.length() / 2);
    }

    public String secondHalf(String str) {
        return str.substring(str.length() / 2);
    }

    public char[] expand(String bin) {
        char[] answer = new char[8];
        for (int i = 0; i < 8; i++) {
            if (i == 2) {
                answer[i] = bin.charAt(0);
            } else if (i == 4) {
                answer[i] = bin.charAt(1);
            } else if (i == 5) {
                answer[i] = bin.charAt(2);
            } else if (i == 6) {
                answer[i] = bin.charAt(3);
            } else {
                answer[i] = '.';
            }
        }
        return answer;
    }

    public char[][] expandMass(String[] mass) {
        int length = mass.length * 2;
        char[][] answer = new char[length][8];
        for (int i = 0; i < mass.length; i++) {
            answer[2 * i] = expand(firstHalf(mass[i]));
            answer[2 * i + 1] = expand(secondHalf(mass[i]));
        }
        return answer;
    }

    public int[] parity(char[] mass) {
        int[] answer = new int[8];
        mass[0] = '0';
        mass[1] = '0';
        mass[3] = '0';
        mass[7] = '0';
        for (int i = 0; i < 8; i++) {
            answer[i] = Character.getNumericValue(mass[i]);
        }
        answer[0] = (mass[2] + mass[4] + mass[6]) % 2;
        answer[1] = (mass[2] + mass[5] + mass[6]) % 2;
        answer[3] = (mass[4] + mass[5] + mass[6]) % 2;
        return answer;
    }

    public int[][] parityOfMass(char[][] mass) {
        int[][] answer = new int[mass.length][8];
        for (int i = 0; i < mass.length; i++) {
            answer[i] = parity(mass[i]);
        }
        return answer;
    }

}
