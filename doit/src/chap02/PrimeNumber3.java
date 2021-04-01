package chap02;

// 1000 이하의 소수를 열거 v3.0
public class PrimeNumber3 {
    public static void main(String[] args) {
        int counter = 0;
        int ptr = 0;
        int[] prime = new int[500];

        prime[ptr++] = 2;
        prime[ptr++] = 3;

        for (int n = 5; n <= 1000; n += 2) {
            boolean flag = false;
            for (int i = 1; prime[i] * prime[i] <= n; i++) {
                if (n % prime[i] == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                prime[ptr++] = n;
                counter++;
            }
        }

        for (int i = 0; i < ptr; i++) { // 찾은 ptr개의 소수를 출력
            System.out.println(prime[i]);
        }
        System.out.println("곱셈과 나눗셈을 수행한 횟수: " + counter);
    }
}
