package correcter;

import java.util.Random;

public class BinaryUtils {

    public String toBinary(byte b) {
        return String.format("%8s", Integer.toBinaryString((b + 256) % 256)).replace(' ', '0');
    }

    public byte fromBinary(String str) {
        return (byte)Integer.parseInt(str, 2);
    }

    public String errorGenerate(String str) {
        Random random = new Random();
        int index = random.nextInt(8);

        char[] mass = str.toCharArray();
        mass[index] = (char) ((mass[index] + 1) % 2 + 48) ;
        return new String(mass);
    }


}
