package swea.D3;

import java.util.Scanner;

// 숫자 조작
// 풀이: 구현 문제 -> 문자 배열을 사용해서 min, max를 구한다. 시작이 0으로 시작되면 안되고, 이럴 경우는 본래가 min, max가 됨.

public class Solution13428 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            String input = sc.next();
            char[] arr = input.toCharArray();
            int max = Integer.parseInt(input);  // 입력 받은 것을 max, min 으로 지정해놓음
            int min = max;

            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    char temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;

                    if (arr[0] != '0' && Integer.parseInt(String.valueOf(arr)) < min) { // '0' 은 48 이다.
                        min = Integer.parseInt(String.valueOf(arr));
                    }
                    if (arr[0] != '0' && Integer.parseInt(String.valueOf(arr)) > max) {
                        max = Integer.parseInt(String.valueOf(arr));
                    }
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;

                }
            }
            System.out.println("#" + tc + " " + min + " " + max);
        }
    }
}
