package correcter;

import java.util.Arrays;

public class Decoder {

    public String[] decodeToWithoutParityMass(String[] mass) {
        String[] answer = new String[mass.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = decodeToWithoutParity(mass[i]);
        }
        return answer;
    }

    public String decodeToWithoutParity(String str) {
        char[] mass = str.toCharArray();
        int index = indexOfPairWithError(mass);
        if (index != 3) {
            int correct = valueOfIndex(valueOfPair(mass, index));
            mass[index * 2] = Character.forDigit(correct, 10);
            mass[index * 2 + 1] = Character.forDigit(correct, 10);
        }
        return new String(Arrays.copyOf(mass, 6));
    }


    private int indexOfPairWithError(char[] mass) {
        int index = 0;
        for (int i = 0; i < mass.length; i+=2) {
            if (mass[i] != mass[i + 1]) {
                index = i / 2;
            }
        }
        return index;
    }

    private char[] valueOfPair(char[] mass, int index) {
        char[] answer = new char[3];
        int j = 0;
        for (int i = 0; i < 4; i++) {
            if (i != index) {
                answer[j] = mass[i * 2];
                j++;

            }
        }
        return answer;
    }

    private int valueOfIndex(char[] mass) {
        int answer = (Character.getNumericValue(mass[0]) + Character.getNumericValue(mass[1]) + Character.getNumericValue(mass[2])) % 2;
        return answer;
    }

    public String[] decoding(String[] expand) {
        StringBuilder builder = new StringBuilder();
        for (String s : expand) {
            builder.append(s);
        }
        char[] mass = builder.toString().toCharArray();
        char[] massWithoutParity = new char[mass.length / 2];
        for (int i = 0; i < massWithoutParity.length; i++) {
            massWithoutParity[i] = mass[i * 2];
        }

        int length = massWithoutParity.length / 8;
        if (massWithoutParity.length % 8 != 0) {
            length++;
        }
        String[] answer = new String[length];
        builder.delete(0, builder.capacity());
        for (int i = 0; i < massWithoutParity.length; i++) {
                builder.append(massWithoutParity[i]);
                if ((i + 1) % 8 == 0) {
                    answer[i / 8] = builder.toString();
                    builder.delete(0, builder.capacity());
                }
        }
        int remaining = massWithoutParity.length % 8;
        if (remaining != 0) {
            char[] appendix = Arrays.copyOfRange(massWithoutParity, massWithoutParity.length - remaining, massWithoutParity.length);
            char[] add = new char[8];
            for (int i = 0; i < 8; i++) {
                add[i] = '0';
            }
            for (int i = 0; i < appendix.length; i++) {
                add[i] = appendix[i];
            }
            answer[answer.length - 1] = new String(add);
        }

        return answer;
    }

    public String[] remove(String[] mass) {
        if ("00000000".equals(mass[mass.length -1])) {
            return Arrays.copyOf(mass, mass.length - 1);
        } else return mass;
    }

}
