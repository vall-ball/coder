package correcter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {

/*
        Coder coder = new Coder();
        HammingDecoder hammingDecoder = new HammingDecoder();
        HammingCoder hammingCoder = new HammingCoder();
        BinaryErrorGenerator generator = new BinaryErrorGenerator();
        int[][] mass = {{0,1,0,0,1,0,1,0}, {1,0,0,1,1,0,0,0}};
        /////////////
        int[][] test = hammingDecoder.decode(mass);
        printMassOfInt(test);
        System.out.println();
        ////////


        String str = "Test";
        System.out.println("text view: " + str);
        String[] hex = coder.fromStringToHex(str);
        System.out.print("hex view: ");
        printMassive(hex);

        String[] bin = coder.fromHexToBinaryMass(hex);
        System.out.println();
        System.out.print("bin view: ");
        printMassive(bin);

        System.out.println();

        System.out.println("encoded.txt:");
        char[][] expand =  hammingCoder.expandMass(bin);
        System.out.println();
        System.out.print("expand: ");
        printMassOfChar(expand);
        System.out.println();
        int[][] parity = hammingCoder.parityOfMass(expand);
        System.out.print("parity: ");
        printMassOfInt(parity);
        System.out.println();
        System.out.print("hex view: ");
        String[] hexOfParity = coder.fromBinaryToHexMass(fromMassToStringMass(parity));
        printMassive(hexOfParity);

        System.out.println("encoded.txt");
        System.out.print("hex view: ");
        printMassive(hexOfParity);
        System.out.println();
        System.out.print("bin view: ");
        String[] binOfParity = coder.fromHexToBinaryMass(hexOfParity);
        printMassive(binOfParity);
        System.out.println();
        System.out.println("received.txt:");
        String[] receivedBin = generator.codeGenerateMass(binOfParity);
        System.out.println();
        System.out.print("bin view: ");
        printMassive(receivedBin);
        System.out.println();
        System.out.print("hex view: ");
        String[] receivedHex = coder.fromBinaryToHexMass(receivedBin);
        printMassive(receivedHex);


        System.out.println("received.txt");

        System.out.print("hex view: ");
        printMassive(receivedHex);
        System.out.println();
        System.out.print("bin view: ");
        String[] receivedBin1 = coder.fromHexToBinaryMass(receivedHex);
        printMassive(receivedBin1);
        System.out.println();
        System.out.println("decoded.txt:");
        int[][] notCorrect = fromStringMassToIntMass(receivedBin1);
        int[][] correct = hammingDecoder.correctionMass(notCorrect);
        System.out.print("correct: ");
        printMassOfInt(correct);
        System.out.println();
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

*/


        Mode mode = new Mode();
        System.out.print("Write a mode: ");
        String strOfMode;
        Scanner scanner = new Scanner(System.in);
        strOfMode = scanner.nextLine();
        System.out.println();
        switch (strOfMode) {
            case "encode":
                mode.encode();
                break;
            case "send":
                mode.send();
                break;
            case "decode":
                mode.decode();
        }
    }



/*
////////////////////
private static void printMassive(String[] mass) {
    for (String s : mass) {
        System.out.print(s + " ");
    }
    System.out.println();
}

    public static void printMassOfChar(char[][] mass) {
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

    public static String fromMassToString(int[] mass) {
        StringBuilder builder = new StringBuilder();
        for (int i : mass) {
            builder.append(i);
        }
        return builder.toString();
    }

    public static String[] fromMassToStringMass(int[][] mass) {
        String[] answer = new String[mass.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = fromMassToString(mass[i]);
        }
        return answer;
    }

    public static int[] fromStringToInt(String str) {
        char[] mass = str.toCharArray();
        int[] answer = new int[mass.length];
        for (int i = 0; i < 8; i++) {
            answer[i] = Character.getNumericValue(mass[i]);
        }
        return answer;
    }

    public static int[][] fromStringMassToIntMass(String[] mass) {
        int[][] answer = new int[mass.length][];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = fromStringToInt(mass[i]);
        }
        return answer;
    }
*/
    ////////////////////////

}
