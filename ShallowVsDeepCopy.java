package projects;

import java.util.Arrays;

public class ShallowVsDeepCopy {

    public static void main(String[] args) {
        int[][] arr = {{1, 4, 20}, {12, 8, 9}};
        int[][] clone = shallowCopy(arr);
        int[][] deepClone = deepCopy(arr);

        //changing one element in the basic array
        arr[1][0] = 32;

        System.out.println("Original array: ");
        printArray(arr);

        System.out.println("Shallow copy: ");
        printArray(clone);

        //the deep copy will appear as it was before the change
        System.out.println("Deep copy: ");
        printArray(deepClone);
    }

    public static int[][] shallowCopy(int[][] arr) {
        return arr;
    }

    public static int[][] deepCopy(int[][] arr) {
        int [][] dCopy = new int[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            dCopy[i] = Arrays.copyOf(arr[i], arr[i].length);
        }
        return dCopy;
    }

    public static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
