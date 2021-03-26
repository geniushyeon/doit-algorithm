package chap01;

// 세 값의 중앙값 구하기
public class Median {
    public int med3(int a, int b, int c) {
        if (a >= b) {
            if (b >= c)
                return b;
            else if (a <= c)
                return a;
            else
                return c;
        }
        else if (a > c)
            return a;
        else
            return b;
    }
}
