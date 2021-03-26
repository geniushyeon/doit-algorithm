package chap01;

import java.util.Scanner;

public class DiffOfTwoIntegers {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int a;
        int b;

        System.out.print("a의 값: ");
        a = scanner.nextInt();

        do {
            System.out.print("b의 값: ");
            b = scanner.nextInt();
            if (a >= b)
                System.out.println("a보다 큰 값을 입력하세요!");
        } while(a >= b);

        System.out.println("b - a는 " + (b - a) + "입니다.");
    }
}
