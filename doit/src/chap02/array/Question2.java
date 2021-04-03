package chap02.array;

import java.util.Scanner;

public class Question2 {
    static void swap(int[] array, int idx1, int idx2) {
        int t = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = t;
    }

    static void reverse(int[] array) {
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
            if (i == array.length - 1) {
                System.out.println();
            }
        }

        while (count < array.length / 2) {
            System.out.println("array[" + count + "]과 array[" + (array.length - count - 1) + "]를 교환합니다.");
            swap(array, count, array.length - count - 1);
            count++;

            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
                if (i == array.length - 1) {
                    System.out.println();
                }
            }
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

    }
}

