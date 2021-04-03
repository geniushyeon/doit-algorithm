package chap02.array;

public class IntArray {
    public static void main(String[] args) {
        int[] a = new int[5]; // 배열의 선언

        a[1] = 37;
        a[2] = 51;
        a[4] = a[1] * 2;

        for (int i = 0; i < a.length; i++) {
            System.out.println("a[" + i + "] = " + a[i]);
        }
    }
}
