package chap02.array;

public class Question3 {
    static int sumOfArray(int[] array) {
        int sum = array[0];

        for (int i = 1 ; i < array.length; i++) {
            sum += array[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 4, 7};

        System.out.println(sumOfArray(array));
    }

}
