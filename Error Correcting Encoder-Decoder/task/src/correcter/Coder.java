package correcter;

public class Coder {

    public String[] fromStringToHex(String str) {
        byte[] bytes = str.getBytes();
        String[] mass = new String[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            mass[i] = Integer.toHexString(bytes[i]).toUpperCase();
        }
        return mass;
    }

    public String[] fromBytesToHex(byte[] bytes) {
        String[] mass = new String[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            mass[i] = Integer.toHexString(bytes[i] & 0xFF).toUpperCase();
            if (mass[i].length() == 1) {
                mass[i] = "0" + mass[i];
            }
        }
        return mass;
    }


    public String fromHexToBinary(String str) {
        int n = Integer.parseInt(str, 16);
        return String.format("%8s", Integer.toBinaryString((n + 256) % 256)).replace(' ', '0');
    }

    public String[] fromHexToBinaryMass(String[] hex) {
        String[] binary = new String[hex.length];
        for (int i = 0; i < binary.length; i++) {
            binary[i] = fromHexToBinary(hex[i]);
        }
        return binary;
    }

    public String fromBinaryToHex(String binary) {
        String answer = Integer.toHexString(Integer.parseInt(binary, 2)).toUpperCase();
        if (answer.length() == 1) {
            answer = "0" + answer;
        }
        return answer;
    }

    public String[] fromBinaryToHexMass(String[] binary) {
        String[] hex = new String[binary.length];
        for (int i = 0; i < hex.length; i++) {
            hex[i] = fromBinaryToHex(binary[i]);
        }
        return hex;
    }

    public String[] expand(String[] binary) {
        int length = binary.length * 8 / 3;
        if (binary.length * 8 % 3 != 0) {
            length++;
        }
        String[] answer = new String[length];

        StringBuilder builder = new StringBuilder();
        for (String s : binary) {
            builder.append(s);
        }
        char[] charOfBinary = builder.toString().toCharArray();
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < charOfBinary.length; i++) {
            sBuilder.append(charOfBinary[i]);
            sBuilder.append(charOfBinary[i]);
            if ((i + 1) % 3 == 0) {
                answer[i / 3] = sBuilder.toString();
                sBuilder.delete(0, sBuilder.capacity());
            }
        }
        sBuilder.delete(0, sBuilder.capacity());
        if (charOfBinary.length % 3 == 2) {
            for (int i = charOfBinary.length - 2; i < charOfBinary.length; i++) {
                sBuilder.append(charOfBinary[i]);
                sBuilder.append(charOfBinary[i]);
            }
            answer[answer.length - 1] = sBuilder.toString();
        }
        if (charOfBinary.length % 3 == 1) {
                sBuilder.append(charOfBinary[charOfBinary.length - 1]);
                sBuilder.append(charOfBinary[charOfBinary.length - 1]);
            answer[answer.length - 1] = sBuilder.toString();
            }


        return answer;
    }

    public String parity(String str) {
        StringBuilder builder = new StringBuilder(str);
        if (str.length() == 4) {
            builder.append("00");
            str = builder.toString();
        }
        if (str.length() == 2) {
            builder.append("0000");
            str = builder.toString();
        }
        int parity = (Integer.parseInt(str.substring(0, 1)) + Integer.parseInt(str.substring(2, 3)) + Integer.parseInt(str.substring(4, 5))) % 2;
        builder.append(parity).append(parity);
        return builder.toString();
    }

    public String[] parityMass(String[] expand) {
        String[] parity = new String[expand.length];
        for (int i = 0; i < parity.length; i++) {
            parity[i] = parity(expand[i]);
        }
        return parity;
    }

    public String recoverText(String[] mass) {
        StringBuilder builder = new StringBuilder("");

        for (int i = 0; i < mass.length; i++) {
            builder.append((char) Integer.parseInt(mass[i], 16));
        }
        return builder.toString();
    }

    public byte fromBinaryToByte(String str) {
        return (byte)Integer.parseInt(str, 2);
    }

    public byte[] fromBinToByte(String[] bin) {
        byte[] bytes = new byte[bin.length];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = fromBinaryToByte(bin[i]);
        }
        return bytes;
    }

    public byte hexToByte(String hexString) {
        int firstDigit = toDigit(hexString.charAt(0));
        int secondDigit = toDigit(hexString.charAt(1));
        return (byte) ((firstDigit << 4) + secondDigit);
    }

    private int toDigit(char hexChar) {
        int digit = Character.digit(hexChar, 16);
        if(digit == -1) {
            throw new IllegalArgumentException(
                    "Invalid Hexadecimal Character: "+ hexChar);
        }
        return digit;
    }



}
