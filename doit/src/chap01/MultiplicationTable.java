package chap01;

public class MultiplicationTable {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            if (i == 0) {
                System.out.print("  | ");
                continue;
            }
            System.out.print(i + "  ");
        }
        System.out.println("\n--+----------------------------");
        for (int i = 1; i < 10; i++) {
            System.out.print(i + " | ");
            for (int j = 1; j < 10; j++) {
                System.out.print(i * j + " ");
                if (i * j < 10) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
