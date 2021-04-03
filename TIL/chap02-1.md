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
- [연습문제1](doit/src/chap02/../../../../doit/src/chap02/array/Question1.java): 키뿐만 아니라 사람 수도 난수로 생성하도록 실습 2-5를 수정하여 프로그램 작성하기

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
- [연습문제2](src/chap02/../../../doit/src/chap02/array/Question2.java): 배열 요소를 역순으로 정렬하는 과정을 하나하나 나타내는 프로그램 작성하기
- [연습문제3](src/chap02/../../../doit/src/chap02/array/Question3.java): 배열 a의 모든 요소의 합계를 구하여 반환하는 메서드 작성
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
- 연습문제4: 배열 b의 모든 요소를 배열 a에 복사하는 메서드 작성
- 연습문제5: 배열 b의 모든 요소를 배열 a에 역순으로 복사하는 메서드 작성
  - [코드](src/chap02/../../../doit/src/chap02/array/Question4and5.java)
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
- [연습문제6](src/chap02/../../../doit/src/chap02/array/ReverseArray.java): 배열의 앞쪽에 윗자리를 넣어두는 메소드 작성
- [연습문제7](chap02/../../doit/src/chap02/array/Question7.java): 기수 변환 과정을 자세히 나타내는 프로그램 작성
### 소수의 나열
- 어떤 정수 n은 다음의 조건을 만족하면 소수라고 판단할 수 있다.
```text
n의 제곱근 이하의 어떤 소수로도 나누어 떨어지지 않는다.
```

### 다차원 배열
- 2차원 배열: 배열을 구성 요소로 하는 것
- 3차원 배열: 2차원 배열을 구성 요소로 하는 것

### 한 해의 경과 일 수를 계산하는 프로그램
- m월 d일의 그 해 경과 일 수 = 1월, 2월 ..., m - 1월의 일 수의 합 + d
```java
// 윤년인지 판단 후 경과 일 수 구하기
public class Question8 {
    // 각 달의 일 수
    static int[][] mdays = {
            {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}, // 평년
            {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31} // 윤년
    };

    // 윤년인지 판단 (윤년: 1 / 평년: 0)
    static int isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
    }

    // 서기 year년 month월 day일의 그 해 경과 일 수를 구함
    static int dayOfYear(int year, int month, int day) {
        int days = day;

        for (int i = 1; i < month; i++) {
            days += mdays[isLeap(year)][i - 1];
        }

        return days;
    }
}
```
- [연습문제8](chap02/../../doit/src/chap02/array/Question8.java): dayOfYear 메서드를 while문을 사용하여 구현하기
- [연습문제9](chap02/../../doit/src/chap02/array/Question9.java): year년 month월 day일의 그 해 남은 일 수(ex. 12월 31일이면 0, 12월 30일이면 1)를 구하는 leftDaysOfYear 메서드 작성하기

### 다차원 배열의 내부
```java
// 2행 4열 배열의 선언 - 배열 변수 선언과 본체 생성을 동시에 수행
int[][] x = new int[2][4];
// 배열 변수 선언과 본체 생성을 개별적으로 수행
int[][] x;
x = new int[2][];
x[0] = new int[4];
x[1] = new int[4];
```