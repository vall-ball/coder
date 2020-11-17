package correcter;

import java.util.Random;

public class BinaryErrorGenerator {

    public String codeGenerate(String str) {
        Random random = new Random();
        int index = random.nextInt(str.length());
        char[] mass = str.toCharArray();
        if (mass[index] == '0') {
            mass[index] = '1';
        } else {
            mass[index] = '0';
        }
        return new String(mass);
    }

    public String[] codeGenerateMass(String[] str) {
        String[] answer = new String[str.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = codeGenerate(str[i]);
        }
        return answer;
    }
}
