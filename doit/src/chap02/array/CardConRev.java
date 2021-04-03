package chap02.array;

import java.util.Scanner;

// 입력받은 10진수를 2진수 ~ 36진수로 기수 변환하여 나타냄
public class CardConRev {
    public static int cardConvR(int x, int r, char[] d) {
        int digits = 0; // 변환 후의 자릿수
        String dChar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        do {
            d[digits++] = dChar.charAt(x % r); // r로 나눈 나머지를 저장
            x /= r;
        } while (x != 0);

        return digits;
    }
    // Q6. 배열의 앞쪽에 아랫자리가 아닌 윗자리를 넣어두는 메소드 작성하기
    public static int cardConv(int x, int r, char[] d) {
        int digits = 0;
        String dChar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        // 1) 배열에 아랫자리부터 저장
        while (x != 0) {
            d[digits++] = dChar.charAt(x % r);
            x /= r;
        }

        // 2) 위치 바꾸기
        for (int i = 0; i < d.length / 2; i++) {
            char temp = d[i];
            d[i] = d[digits - i - 1];
            d[digits - i - 1] = temp;
        }

        return digits;
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        int num; // 변환하는 정수
        int cd; // 기수
        int dno; // 변환 후의 자릿수
        int retry; // 다시 한 번?
        char[] cno = new char[32]; // 변환 후 각 자리의 숫 자를 넣어두는 문자의 배열

        System.out.println("10진수를 기수변환합니다.");
        do {
            do {
                System.out.print("변환하는 음이 아닌 정수 > ");
                num = scanner.nextInt();
            } while (num < 0);

            do {
                System.out.print("어떤 진수로 변환할까요? (2~36) > ");
                cd = scanner.nextInt();
            } while (cd < 2 || cd > 36);

            dno = cardConvR(num, cd, cno);
            System.out.print(cd + "진수로는 ");

            for (int i = dno - 1; i >= 0; i--) { // 윗자리부터 차례로 나타냄
                System.out.print(cno[i]);
            }
            System.out.println("입니다.");

            System.out.print("한 번 더 할까요? (1. 예 / 0. 아니오) > ");
            retry = scanner.nextInt();
        } while (retry == 1);

        scanner.close();

    }
}
