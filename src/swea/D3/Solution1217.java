package swea.D3;

import java.io.IOException;
import java.util.Scanner;

// [S/W 문제해결 기본] 4일차 - 거듭 제곱 - 재귀함수로 풀기
// 풀이: 재귀함수 호출 -> m이 점차 감소하면서 0이되면 return
public class Solution1217 {

    static int res, N, M;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            int T = sc.nextInt();
            N = sc.nextInt();
            M = sc.nextInt();
            res = 1;
            pow(N, M);
            System.out.println("#" + T + " " + res);
        }
    }

    private static void pow(int n, int m) {
        if (m == 0) {
            return;
        }
        res *= n;
        pow(n, m - 1);
    }
}
/**
 * public class s_1217 {
 * 	public static int pow(int x, int y) {
 * 		if(y == 0)
 * 			return 1;
 * 		return x * pow(x, y-1);
 *        }
 * 	public static void main(String[] args) {
 * 		Scanner sc = new Scanner(System.in);
 * 		for(int t = 1; t <= 10; t++) {
 * 			int test = sc.nextInt();
 * 			int x = sc.nextInt();
 * 			int y = sc.nextInt();
 * 			System.out.println("#" + t + " " + pow(x, y));
 *        }
 *    }
 * }
 */