package correcter;

import java.lang.management.BufferPoolMXBean;
import java.util.Random;
@Deprecated
public class ErrorGenerator {
    MessageUtils utils = new MessageUtils();

    public String errorGenerate(String str) {
        char[][] mass = utils.splitMass(str.toCharArray());
        for (int i = 0; i < mass.length; i++) {
            changeSimbol(mass[i]);
        }
        return utils.generateString(mass);
    }

    private char randomChar() {
        Random random = new Random();
        int i = random.nextInt(63);
        return utils.massOfChar[i];
    }

    public void changeSimbol(char[] str) {
        Random random = new Random();
        int index = random.nextInt(str.length);
        str[index] = randomChar();
    }

}
