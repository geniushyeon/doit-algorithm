package chap02;

import java.util.Random;
import java.util.Scanner;

// 키뿐만 아니라 사람 수도 난수로 생성하도록 실습 2-5를 수정하기
public class Question1 {
    public static int maxOf(int[] arr) {
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }

        return max;
    }

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int num = random.nextInt(10);

        System.out.println(num + "명의 키의 최대값을 구합니다.");
        int[] height = new int[num];

        System.out.println("키 값은 아래와 같습니다.");
        for (int i = 0; i < num; i++) {
            height[i] = 100 + random.nextInt(90);
            System.out.println("height[" + i + "]: " + height[i]);
        }

        System.out.println("최대값은 " + maxOf(height) + " 입니다.");
    }
}
