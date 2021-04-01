package chap02;

public class ArrayCopyExample {
    // 배열 b의 모든 요소를 배열 a에 복사하는 메소드
    public static int[] copy(int[] a, int[] b) {
        int num = a.length <= b.length ? a.length : b.length;

        for (int i = 0; i < num; i++) {
            a[i] = b[i];
        }

        return a;
    }
    // 배열 b의 모든 요소를 배열 a에 역순으로 복사하는 rcopy
    public static int[] reverseAndCopy(int[] a, int[] b) {
        int num = a.length <= b.length ? a.length : b.length;

        for (int i = 0; i < num / 2; i++) {
            a[i] = b[b.length - i - 1];
        }

        return a;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {11, 22, 34, 56, 78, 99};
        copy(a, b);

        for (int i : a) {
            System.out.println(i);
        }
    }
}
