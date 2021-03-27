package chap01;

public class Pyramids {
    public void spira(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < i * 2 + 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void npira(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < (i-1) * 2 + 1; k++) {
                System.out.print(i % 10);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Pyramids p = new Pyramids();
        p.npira(4);
    }
}
