package correcter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Mode {

    Coder coder = new Coder();
    HammingCoder hammingCoder = new HammingCoder();
    BinaryErrorGenerator generator = new BinaryErrorGenerator();
    HammingDecoder hammingDecoder = new HammingDecoder();


    public void encode() throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get("send.txt"));
        String str = new String(bytes);
        System.out.println("send.txt:");
        System.out.println("text view: " + str);

        String[] hex = coder.fromStringToHex(str);
        System.out.print("hex view: ");
        printMassive(hex);

        String[] bin = coder.fromHexToBinaryMass(hex);
        System.out.print("bin view: ");
        printMassive(bin);

        System.out.println();

        System.out.println("encoded.txt:");
        char[][] expand =  hammingCoder.expandMass(bin);
        System.out.print("expand: ");
        printMassOfChar(expand);

        int[][] parity = hammingCoder.parityOfMass(expand);
        System.out.print("parity: ");
        printMassOfInt(parity);

        System.out.print("hex view: ");
        String[] hexOfParity = coder.fromBinaryToHexMass(fromMassToStringMass(parity));
        printMassive(hexOfParity);

        byte[] resultBytes = coder.fromBinToByte(coder.fromHexToBinaryMass(hexOfParity));
        OutputStream stream = new FileOutputStream("encoded.txt");
        stream.write(resultBytes);
        stream.close();
    }

    public void send() throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get("encoded.txt"));
        System.out.println("encoded.txt");
        String[] hex = coder.fromBytesToHex(bytes);
        System.out.print("hex view: ");
        printMassive(hex);
        System.out.print("bin view: ");
        String[] bin = coder.fromHexToBinaryMass(hex);
        printMassive(bin);

        System.out.println("received.txt:");
        String[] receivedBin = generator.codeGenerateMass(bin);
        System.out.print("bin view: ");
        printMassive(receivedBin);

        System.out.print("hex view: ");
        String[] receivedHex = coder.fromBinaryToHexMass(receivedBin);
        printMassive(receivedHex);

        byte[] resultBytes = coder.fromBinToByte(receivedBin);
        OutputStream stream = new FileOutputStream("received.txt");
        stream.write(resultBytes);
        stream.close();
    }

    public void decode() throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get("received.txt"));
        System.out.println("received.txt");
        String[] hex = coder.fromBytesToHex(bytes);
        System.out.print("hex view: ");
        printMassive(hex);
        System.out.print("bin view: ");
        String[] bin = coder.fromHexToBinaryMass(hex);
        printMassive(bin);

        System.out.println("decoded.txt:");
        int[][] notCorrect = fromStringMassToIntMass(bin);
        int[][] correct = hammingDecoder.correctionMass(notCorrect);
        System.out.print("correct: ");
        printMassOfInt(correct);
        int[][] decode = hammingDecoder.decode(correct);
        String[] decodeString = fromMassToStringMass(decode);
        System.out.println();
        System.out.print("decode: ");
        printMassive(decodeString);
        System.out.print("hex view: ");
        String[] hexOfDecode = coder.fromBinaryToHexMass(decodeString);
        printMassive(hexOfDecode);
        String result = coder.recoverText(hexOfDecode);
        System.out.println("text view: " + result);

        byte[] resultBytes = result.getBytes();
        OutputStream stream = new FileOutputStream("decoded.txt");
        stream.write(resultBytes);
        stream.close();




    }

    private void printMassive(String[] mass) {
        for (String s : mass) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    public void printMassOfChar(char[][] mass) {
        for (char[] m : mass) {
            for (char c : m) {
                System.out.print(c);
            }
            System.out.print(" ");
        }
    }


    public static void printMassOfInt(int[][] mass) {
        for (int[] m : mass) {
            for (int c : m) {
                System.out.print(c);
            }
            System.out.print(" ");
        }
    }

    public String fromMassToString(int[] mass) {
        StringBuilder builder = new StringBuilder();
        for (int i : mass) {
            builder.append(i);
        }
        return builder.toString();
    }

    public String[] fromMassToStringMass(int[][] mass) {
        String[] answer = new String[mass.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = fromMassToString(mass[i]);
        }
        return answer;
    }

    public int[] fromStringToInt(String str) {
        char[] mass = str.toCharArray();
        int[] answer = new int[mass.length];
        for (int i = 0; i < 8; i++) {
            answer[i] = Character.getNumericValue(mass[i]);
        }
        return answer;
    }

    public int[][] fromStringMassToIntMass(String[] mass) {
        int[][] answer = new int[mass.length][];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = fromStringToInt(mass[i]);
        }
        return answer;
    }

}
