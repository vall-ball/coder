package correcter;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        int[] message = new int[] {114, 101, 97, 100, 32, 97, 98, 111, 117, 116, 32, 65, 83, 67, 73, 73};

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        for (int code : message) {
            outputStream.write(code);
        }

        System.out.println(outputStream.toString());
        File file = new File("C:\\Users\\Lena\\Downloads\\dataset_91065.txt");
        int sum = 0;
        int n;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                n = scanner.nextInt();
                if (n % 2 == 0) {
                    System.out.println(n);
                    sum++;
                }
                if (n == 0) {
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: ");

        }
        System.out.println(sum);
    }
        /*String[] mass = new String[68];
        int k = 0;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
               mass[k] = scanner.nextLine();
               k++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: ");

        }
        long[][] massiv = new long[67][2];
        for (int i = 1; i < mass.length; i++) {
            String[] s = mass[i].split("\\s");
            massiv[i - 1][0] = Long.parseLong(s[0]);
            massiv[i - 1][1] = Long.parseLong(s[1].replaceAll(",", ""));
            System.out.println(massiv[i - 1][0]);
            System.out.println(massiv[i - 1][1]);
        }
        long year = massiv[1][0];
        long difference = massiv[1][1] - massiv[0][1];
        for (int i = 2; i < massiv.length; i++) {
            if (massiv[i][1] - massiv[i - 1][1] > difference) {
                difference = massiv[i][1] - massiv[i - 1][1];
                year = massiv[i][0];
            }
        }
        System.out.println(year);

    }*/

}
