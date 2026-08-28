import java.util.*;

public class NumbersArray {
    public static void main(String[] args) {
        Integer[] input = {1,2,3,4,1,5};

        System.out.println("Input : " + Arrays.toString(input));
        System.out.println("Max number : " + findMax(input));
        System.out.println("Duplicate numbers : " + Arrays.toString(findDuplicates(input)));
        System.out.println("Unique numbers : " + Arrays.toString(findUnique(input)));       
        
        System.out.println();

        input = new Integer[] {1,2,3,4,1,2,5,3};

        System.out.println("Input : " + Arrays.toString(input));
        System.out.println("Max number : " + findMax(input));
        System.out.println("Duplicate numbers : " + Arrays.toString(findDuplicates(input)));
        System.out.println("Unique numbers : " + Arrays.toString(findUnique(input))); 
    }

    // Write your methods here
    public static int findMax(Integer[] input) {
        if (input.length == 0) {
            return 0;
        }

        int max = input[0];
        
        for (int i = 1; i < input.length; i++) {
            if (max < input[i]) {
                max = input[i];
            }
        }

        return max;
    }

    public static Integer[] findDuplicates(Integer[] input) {
        if (input.length == 0) {
            return null;
        }

        int[] arr = new int[input.length * 2];
        
        for (int i = 0; i < input.length; i++) {
            int num = input[i];
            
            int indx = 0;
            while (arr[indx] != 0 && arr[indx] != num) {
                indx += 2;
            }
            arr[indx] = num;
            arr[indx + 1]++;
        }

        int size = 0;
        for (int i = 1; i < arr.length; i += 2) {
            if (arr[i] > 1) {
                size++;
            }
        }

        Integer[] output = new Integer[size];
        int indx = 0;
        for (int i = 0; i < arr.length; i += 2) {
            if (arr[i + 1] > 1) {
                output[indx++] = arr[i]; 
            }
        }

        return output;
    }

    public static Integer[] findUnique(Integer[] input) {
        if (input.length == 0) {
            return null;
        }

        int[] arr = new int[input.length * 2];
        
        for (int i = 0; i < input.length; i++) {
            int num = input[i];
            
            int indx = 0;
            while (arr[indx] != 0 && arr[indx] != num) {
                indx += 2;
            }
            arr[indx] = num;
            arr[indx + 1]++;
        }

        int size = 0;
        for (int i = 1; i < arr.length; i += 2) {
            if (arr[i] == 1) {
                size++;
            }
        }

        Integer[] output = new Integer[size];
        int indx = 0;
        for (int i = 0; i < arr.length; i += 2) {
            if (arr[i + 1] == 1) {
                output[indx++] = arr[i]; 
            }
        }

        return output;
    }
}

