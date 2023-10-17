package swea.D2;

import java.io.IOException;
import java.util.Scanner;

// 파리 퇴치
// 풀이 : 4중 for문 -> map[i][j] ~ map[i+x][j+y]    / 누적합(?)
public class Solution2001 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();   // 5
            int M = sc.nextInt();   // 2
            int[][] map = new int[N][N];
            int maxSum = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i <= N - M; i++) {
                for (int j = 0; j <= N - M; j++) {
                    int sum = 0;
                    for (int x = 0; x < M; x++) {
                        for (int y = 0; y < M; y++) {
                            sum += map[i + x][j + y];
                        }
                    }
                    maxSum = Math.max(sum, maxSum);
                }
            }
            System.out.printf("#%d %d\n", tc, maxSum);
        }
        sc.close();
    }
}

/**
 * 누적합
 * board = new int[m][m];
 * prefixSum = new int[m + 1][m + 1];
 * int max = Integer.MIN_VALUE;
 * for (int i = 0; i < m; i++) {
 * board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
 * }
 * for (int i = 1; i < m + 1; i++) {
 * for (int j = 1; j < m + 1; j++) {
 * prefixSum[i][j] = board[i - 1][j - 1] + prefixSum[i][j - 1] + prefixSum[i - 1][j] - prefixSum[i -1][j - 1];
 * }
 * }
 *
 * for (int i = 1; i <= m - n + 1; i++) {
 * for (int j = 1; j <= m - n + 1; j++) {
 * int sum = prefixSum[n + i - 1][n + j - 1] - prefixSum[n + i - 1][j - 1] - prefixSum[i - 1][n + j - 1] + prefixSum[i - 1][j - 1];
 * max = Math.max(sum, max);
 * }
 * }
 */
