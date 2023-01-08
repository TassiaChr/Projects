package projects;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CombinationSixApp {

    public static void main(String[] args) throws FileNotFoundException {
        File inFile = new File("C:/tmp/integers.txt");
        File outFile = new File("C:/tmp/combinations.txt");
        Scanner in = new Scanner(inFile);
        ArrayList<Integer> numbers = new ArrayList<>();

        while (in.hasNextInt()) {
          numbers.add(in.nextInt());
        }

        int[] row = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            row[i] = numbers.get(i);
        }

        Arrays.sort(row);

        ArrayList<int[]> combinations = new ArrayList<>();
        for (int i = 0; i < row.length - 5; i++) {
            for (int j = i + 1; j < row.length -4; j++) {
                for (int k = j + 1; k < row.length - 3; k++) {
                    for (int l = k + 1; l < row.length - 2; l++) {
                        for (int m = l + 1; m < row.length - 1; m++) {
                            for (int n = m + 1; n < row.length; n++) {
                                int [] arr = {row[i], row[j], row[k], row[l], row[m], row[n]};
                                combinations.add(arr);
                            }
                        }
                    }
                }
            }
        }

        PrintWriter pw = new PrintWriter(outFile);

        for (int[] arr : combinations) {
            if (isValid(arr)) {
                for (int i = 0; i < arr.length; i++) {
                    pw.print(arr[i] + " ");
                }
                pw.println();
            }
        }
    }

    public static boolean isEven(int[] arr) {
        int evenCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                evenCount++;
            }
        }
        return (evenCount <= 4);
    }

    public static boolean isOdd(int[] arr) {
        int oddCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                oddCount++;
            }
        }
        return (oddCount <= 4);
    }

    public static boolean isContiguous(int[] arr) {
        int contCount = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] == arr[i] + 1) {
                contCount++;
            }
        }
        return (contCount <= 2);
    }

    public static boolean isSameEnding(int[] arr) {
        int endingCount = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            if ((arr[i] % 10 == arr[i + 1] % 10) && (arr[i + 1] % 10 == arr[i + 2] % 10)) {
                endingCount++;
            }
        }
        return (endingCount <= 3);
    }

    public static boolean isSameTen(int[] arr) {
        int[] tens = new int[5];
        for (int i = 0; i < arr.length; i++) {
            tens[arr[i] / 10]++;
        }
        for (int i = 0; i < tens.length; i++) {
            if (tens[i] > 3) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValid(int[] arr) {
        return isEven(arr) && isOdd(arr) && isContiguous(arr) &&
                isSameEnding(arr) && isSameTen(arr);
    }
}
