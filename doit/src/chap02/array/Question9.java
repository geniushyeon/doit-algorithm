package chap02.array;

import java.util.Scanner;

public class Question9 {

    // 각 달의 일 수
    static int[][] mdays = {
            {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}, // 평년
            {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31} // 윤년
    };


    // 윤년인지 판단 (윤년: 1 / 평년: 0)
    static int isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
    }

    static int leftDaysOfYear(int year, int month, int day) {
        int leftDays = 0;

        int daysOfYear = isLeap(year) == 1 ? 366 : 365;

        for (int i = 1; i < month; i++) {
            day += mdays[isLeap(year)][i - 1];
        }

        leftDays = daysOfYear - day;

        return leftDays;
    }

    public static void main(String[] args) {

        Scanner stdIn = new Scanner(System.in);
        int retry; // 한 번 더？

        System.out.println("연내의 남은 일 수를 구합니다.");

        do {
            System.out.print("년：");
            int year = stdIn.nextInt(); // 년
            System.out.print("월：");
            int month = stdIn.nextInt(); // 월
            System.out.print("일：");
            int day = stdIn.nextInt(); // 일

            System.out.printf("연내의 남은 일 수는 %d일입니다.\n", leftDaysOfYear(year, month, day));

            System.out.print("한번 더 할까요? (1.예 / 0.아니오)：");
            retry = stdIn.nextInt();
        } while (retry == 1);

        stdIn.close();
    }
}
