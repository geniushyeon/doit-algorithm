package chap01;

import java.util.Scanner;
// 왼쪽 아래가 직각인 이등변삼각형
public class TriangleLB {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int n;

        System.out.println("왼쪽 아래가 직각인 이등변삼각형을 출력합니다. ");

        do {
            System.out.print("몇 단입니까? > ");
            n = scanner.nextInt();
        } while (n <= 0); // 입력값이 양수일 때까지 반복

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++)
                System.out.print("*");
            System.out.println();
        }

    }

}
