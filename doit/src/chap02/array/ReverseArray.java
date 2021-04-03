package chap02.array;

import java.util.Scanner;

public class ReverseArray {
    static void swap(int[] array, int idx1, int idx2) {
        int t = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = t;

    }

    static void reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            swap(array, i, array.length - i - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("요소의 개수: ");
        int num = scanner.nextInt();

        int[] array = new int[num];

        for (int i = 0; i < num; i++) {
            System.out.print("array[" + i + "]: ");
            array[i] = scanner.nextInt();
        }

        reverse(array);

        System.out.println("역순 정렬 완료");
        for (int i = 0; i < num; i++) {
            System.out.println("array[" + i + "] = " + array[i]);
        }

        scanner.close();

    }
    
}
