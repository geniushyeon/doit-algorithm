package chap02.array;

import java.util.Scanner;

public class LeftDayOfYear {

    // 각 달의 일 수
    static int[][] mdays = {
            {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}, // 평년
            {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31} // 윤년
    };

    // 윤년인지 판단 (윤년: 1 / 평년: 0)
    static int isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
    }

    // 서기 year년 month월 day일의 그 해 경과 일 수를 구함
    static int dayOfYear(int year, int month, int day) {
        int days = day;

        for (int i = 1; i < month; i++) {
            days += mdays[isLeap(year)][i - 1];
        }

        return days;
    }


    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        int retry;

        System.out.println("그 해 경과 일 수를 구합니다.");

        do {
            System.out.print("년 > ");
            int year = scanner.nextInt();
            System.out.print("월 > ");
            int month = scanner.nextInt();
            System.out.print("일 > ");
            int day = scanner.nextInt();

            System.out.printf("그 해 %d일째입니다.\n", dayOfYear(year, month, day));

            System.out.print("한 번 더 할까요? 1. 예 0. 아니오 > ");
            retry = scanner.nextInt();

        } while (retry == 1);

        scanner.close();
    }
}
