# 2장. 기본 자료구조
## 2.1. 배열
### 자료구조란?
- 데이터 단위와 데이터 자체 사이의 물리적 또는 논리적인 관계
### 배열이란?
- 같은 자료형의 변수로 이루어진 구성 요소가 모인 것
- 배열의 선언과 참조
```java
int[] a; // 선언하기
a = new int[5] // 참조하기
int[] a = new int[5] // 선언과 참조를 동시에
```
- int형의 배열 본체를 생성하고 그것을 변수 a가 '참조'하도록 설정한다
- 배열의 구성 요소는 자동으로 0으로 초기화됨

- 배열의 요소값을 초기화하며 배열 선언하기
```java
int[] a = {1, 2, 3, 4, 5};
```
- 배열의 복제
```java
// 기본적인 사용 방법
배열 이름.clone();
// 예제
package chap02;

public class CloneArray {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = a.clone();

        b[3] = 0; // 한 요소에만 0을 대입

        System.out.print("a =");
        for (int i = 0; i < a.length; i++)
            System.out.print(" " + a[i]);
        // a = 1 2 3 4 5
        System.out.print("\nb =");
        for (int i = 0; i < b.length; i++)
            System.out.print(" " + b[i]);
        // b = 1 2 3 0 5
    }
}
```
- 주사(traverse)
  - 배열의 요소를 하나씩 차례로 살펴보는 과정(알고리즘 용어)

### 토막 상식 - 지역 변수와 전역 변수
1. 지역 변수: stack 영역
- 지역(메소드) 안에서 선언된 변수
- 그 영역을 닫는 중괄호를 만났을 때 메모리에서 해제됨.
- 사용자가 직접 초기화해야 함
- 다른 영역에서 접근할 수 없음
2. 전역 변수: data 영역
- 클래스 영역 안에 있고, 전체 영역에서 사용 가능한 변수
- 클래스 영역 외의 어떠한 영역에도 포함되어있지 않다.
- `new`를 만났을 때 초기화됨.
- 프로그램 종료 시 메모리에서 해제됨
- 다른 영역에서도 접근할 수 있음(접근 제한자에 따라 달라짐)
3. static 변수: data 영역
- 컴파일을 하게 되면 가장 먼저 메모리에 올라가고, 어떠한 경우에도 초기화되지 않음
- 프로그램 종료 시 메모리에서 해제됨
- 메모리에 고정되기 때문에 남용 시 메모리 혹은 프로그램 실행 속도에 악영향을 줄 수 있음

#### 난수 사용해 배열의 요소값 설정하기
- `java.util.Random` 클래스 사용
```java
package chap02;

import java.util.Random;
import java.util.Scanner;

public class MaxOfArrayRandom {
    public static int maxOf(int[] arr) {
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("키의 최대값을 구합니다.");
        System.out.print("사람 수: ");
        int num = scanner.nextInt();

        int[] height = new int[num];

        System.out.println("키 값은 아래와 같습니다.");
        for(int i = 0; i < num; i++) {
            height[i] = 100 + random.nextInt(90);
            System.out.println("height[" + i + "]: " + height[i]);
        }

        System.out.println("최대값은 " + maxOf(height) + "입니다. ");

    }
}
```
- random.nextInt(n): 0부터 n - 1까지의 난수 반환
- 실행 결과<br/>
![](assets/chap02_MaxOfArrayRandom.png)<br/>
- [연습문제1](doit/src/chap02/../../../../doit/src/chap02/Question1.java): 키뿐만 아니라 사람 수도 난수로 생성하도록 실습 2-5를 수정하여 프로그램 작성하기

### 💡 배열 요소를 역순으로 정렬하기
```java
package chap02;

import java.util.Scanner;

public class ReverseArray { // 배열 요소 교환
    static void swap(int[] array, int idx1, int idx2) {
        int t = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = t;

    }

    static void reverse(int[] array) { // 배열 길이만큼 for문 돌며 swap 메서드 호출
        for (int i = 0; i < array.length / 2; i++) {
            swap(array, i, array.length - i - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("요소의 개수: ");
        int num = scanner.nextInt();

        int[] array = new int[num];

        for (int i = 0; i < num; i++) {
            System.out.print("array[" + i + "]: ");
            array[i] = scanner.nextInt();
        }

        reverse(array);

        System.out.println("역순 정렬 완료");
        for (int i = 0; i < num; i++) {
            System.out.println("array[" + i + "] = " + array[i]);
        }

    }
}
```

### 두 배열의 비교
```java
import java.util.Scanner;

class ArrayEqual {
    // 두 배열 a, b의 모든 요소가 같은가?
    public boolean equals(int[] a, int[] b) {
        if (a.length != b.length) {
            return false;
        } // a와 b의 길이가 다르면 false 반환

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            } // 하나라도 다른 요소가 있으면 false 반환
        }

        return true;
    }
}
```
### 기수 변환
- 10진수 정수를 n진수 정수로 변환하려면
1. 정수를 n으로 나눈 나머지를 구하는 동시에
2. 그 몫에 대해 나눗셈을 반복
3. 이 과정을 몫이 0이 될 때까지 반복하고
4. 이런 과정으로 구한 나머지를 거꾸로 늘어 놓은 숫자 => 기수로 변환한 숫자
```java
package chap02;

// 입력받은 10진수를 2진수 ~ 36진수로 기수 변환하여 나타냄
public class CardConRev {
    public static int cardConvR(int x, int r, char[] d) {
        int digits = 0; // 변환 후의 자릿수
        String dChar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        do {
            d[digits++] = dChar.charAt(x % r); // r로 나눈 나머지를 저장
            x /= r;
        } while (x != 0);
        
        return digits;
    }
}
```
- 10진수(Decimal)
```text
0 1 2 3 4 5 6 7 8 9
```
10종류의 숫자를 사용하여 수를 나타냄
- 8진수(Octal)
```text
0 1 2 3 4 5 6 7
```
8진수의 각 자리는 아랫자리부터 8의 거듭제곱 값을 가짐

- 16진수(Hexadecimal)
```text
0 1 2 3 4 5 6 7 8 9 A B C D E F
알파벳은 소문자라도 상관없음
```

### 소수의 나열
- 어떤 정수 n은 다음의 조건을 만족하면 소수라고 판단할 수 있다.
```text
n의 제곱근 이하의 어떤 소수로도 나누어 떨어지지 않는다.
```