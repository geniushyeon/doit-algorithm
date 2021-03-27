package chap01;

public class Triangles {
    // 왼쪽 위가 직각인 이등변삼각형
    public void triangleLU(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = n; j >= 1; j--) {
                if (j >= i)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
    // 오른쪽 위가 직각인 이등변삼각형
    public void triangleRU(int n) {
        for (int i = n; i >= 1; i--) {
            for (int j = n; j >= 1; j--) {
                if (j <= i)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println("");
        }
    }
    // 오른쪽 아래가 직각인 이등변삼각형
    public void triangleRB(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = n; j >= 1; j--) {
                if (i < j)
                    System.out.print(" ");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Triangles t = new Triangles();
        System.out.println("---------------");
        t.triangleRU(5);
    }
}
