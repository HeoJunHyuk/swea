package swea.D3;

import java.io.IOException;
import java.util.Scanner;

// [S/W 문제해결 기본] 3일차 - String
// 풀이: str.substring, str.equals() 사용 , for문 범위 지정 잘해야함. -> 마지막 부분에서 배열을 벗어날 수도 있음(stack overflow)
public class Solution1213 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            int T = sc.nextInt();   // test_case 번호
            String target = sc.next();  // 찾고자하는 특정 문자열
            String input = sc.next();   // 입력받는 문자열
            int res = 0;

            // 범위가 input.len()이면 맨 마지막에 target과 비교할 때, target의 끝부분이 배열 밖으로 나감.
            for (int i = 0; i <= input.length() - target.length(); i++) {
                String str = input.substring(i, i + target.length());
                if (str.equals(target)) {
                    res++;
                }
            }
            System.out.println("#" + T + " " + res);
        }
    }

}
