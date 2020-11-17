package correcter;

import java.util.Arrays;

public class HammingDecoder {

    public int[] calculateParity(int[] mass) {
        int[] answer = Arrays.copyOf(mass, mass.length);
        answer[0] = (mass[2] + mass[4] + mass[6]) % 2;
        answer[1] = (mass[2] + mass[5] + mass[6]) % 2;
        answer[3] = (mass[4] + mass[5] + mass[6]) % 2;
        return answer;
    }

    public int indexOfError(int[] mass) {
        int[] standart = calculateParity(mass);
        int index = -1;
        if (mass[0] != standart[0]) {
            index++;
        }
        if (mass[1] != standart[1]) {
            index += 2;
        }
        if (mass[3] != standart[3]) {
            index += 4;
        }
        return index;
    }

    public int[] correction(int[] mass) {
        int index = indexOfError(mass);
        int[] answer = Arrays.copyOf(mass, mass.length);
        if (index != -1) {
            answer[index] = (answer[index] + 1) % 2;
        }
        return answer;
    }

    public int[][] correctionMass(int[][] mass) {
        int[][] answer = new int[mass.length][8];
        for (int i = 0; i < mass.length; i++) {
            answer[i] = correction(mass[i]);
        }
        return answer;
    }

    public int[] decodeOneHalf(int[] mass) {
        //System.out.println("decodeOneHalf");
        //System.out.println("входящий массив");
        //printMassivInt(mass);
        int[] answer = new int[4];
        answer[0] = mass[2];
        answer[1] = mass[4];
        answer[2] = mass[5];
        answer[3] = mass[6];
        //System.out.println("результируюзий массив");
        //printMassivInt(answer);
        return answer;
    }

    public int[] connect(int[] first, int[] second) {
        int[] answer = new int[8];
        for (int i = 0; i < 4; i++) {
            answer[i] = first[i];
        }
        for (int i = 4; i < 8; i++) {
            answer[i] = second[i - 4];
        }
        return answer;
    }

    public int[][] decode(int[][] mass) {
        int[][] answer = new int[mass.length / 2][8];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = connect(decodeOneHalf(mass[2 * i]), decodeOneHalf(mass[2 * i + 1]));
        }
        return answer;
    }

    public void printMassivInt(int[] mass) {
        for (int i : mass) {
            System.out.print(i);
        }
    }
}
