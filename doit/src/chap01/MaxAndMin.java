package chap01;

public class MaxAndMin {
    // 네 값의 최대값을 구하는 max4 메서드
    public int max4(int a, int b, int c, int d) {
        int max = a;

        if (b > max) {
            max = b;
        } else if (c > max) {
            max = c;
        } else if (d > max) {
            max = d;
        }

        return max;
    }
    // 세 값의 최소값을 구하는 min3 메서드
    public int min3(int a, int b, int c) {
        int min = a;

        if (b < min) {
            min = b;
        } else if (c < min) {
            min = c;
        }

        return min;
    }
}
