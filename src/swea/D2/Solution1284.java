package swea.D2;

import java.util.Arrays;
import java.util.Scanner;

// 수도 요금 경쟁
// 풀이: A회사, B회사 수도 요금을 계산하고 더 작은 값을 출력함
public class Solution1284 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int P = sc.nextInt(); // 9 -> A회사 리터당 9
            int Q = sc.nextInt(); // 100 -> 20L 이하 요금 -> 기본 요금
            int R = sc.nextInt(); // 20 -> 기준점
            int S = sc.nextInt(); // 3 -> 리터당 3
            int W = sc.nextInt(); // 10 -> 사용한 리터

            int A = 0;
            int B = 0;

            A = P * W;
            if (R > W) {
                B = Q;
            } else {
                B = Q + (W - R) * S;
            }

            int result = Math.min(A, B);
            System.out.println("#" + tc + " " + result);

        }
    }
}
