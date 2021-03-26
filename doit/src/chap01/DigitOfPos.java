package chap01;

import java.util.Scanner;

public class DigitOfPos {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int count = 0;

        while (n > 0) {
            n /= 10;
            count++;
        }
        System.out.println("그 수는 " + count + "자리입니다.");
    }
}
