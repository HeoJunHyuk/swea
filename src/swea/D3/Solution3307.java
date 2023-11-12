package swea.D3;

import java.util.Scanner;

// 최장 증가 부분 수열
// 풀이: DP로 해결해야 함 -> N (1 ≤ N ≤ 1,000)
// dp 배열을 만들고 그떄의 최대 길이를 저장하면서 max를 갱신해야함. ( dp를 쓰면, 이전에 했던 최대 길이 구하는 과정을 중복 안할 수 있음 )

public class Solution3307 {

    static int[] arr;
    static int[] dp;
    static int max, N;

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++) {

            N =sc.nextInt();
            arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            max = 0;
            dp = new int[N];
            dp[0] = 1;
            for (int i = 1; i < arr.length; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (arr[j] < arr[i] && dp[i] <= dp[j]) {
                        dp[i] = dp[j] + 1;
                    }
                    max = Math.max(max, dp[i]);
                }
            }
            System.out.println("#" + tc + " " + max);   // dp[N -1] 이 최대가 아님. 때문에 max를 갱신해줘야 함
        }
    }
}

/** dp로 푼 풀이 2 -> dp[N + 1][N + 1]로 해결
 * public class Solution {
 *
 * 	public static void main(String[] args) throws Exception {
 *
 * 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 * 		StringTokenizer st;
 * 		StringBuilder sb = new StringBuilder();
 *
 * 		int T = Integer.parseInt(br.readLine());
 * 		for (int tc = 1; tc <= T; tc++) {
 * 			int N = Integer.parseInt(br.readLine());
 *
 * 			int[] arr = new int[N + 1];
 * 			st = new StringTokenizer(br.readLine());
 * 			for (int i = 1; i <= N; i++) {
 * 				arr[i] = Integer.parseInt(st.nextToken());
 *              }
 *
 * 			int[][] graph = new int[N + 1][N + 1];
 * 			Arrays.fill(graph[0], 1);
 *
 * 			int result = 0;
 * 			for (int i = 1; i <= N; i++) {
 * 				graph[i][i] = graph[i - 1][i];
 * 				for (int j = i + 1; j <= N; j++) {
 * 					if(arr[i] < arr[j]) {
 * 						graph[i][j] = Math.max(graph[i - 1][j], graph[i][i] + 1);
 * 						result = Math.max(result, graph[i][j]);
 *                    }
 * 					else {
 * 						graph[i][j]= graph[i - 1][j];
 *                    }
 *                }
 *            }
 *
 * 			sb.append("#" + tc + " " + result + "\n");
 * 			}
 *
 * 		System.out.println(sb);
 * 	}
 * }
 */

/** dfs를 사용한 풀이 BUT, N의 크기가 크므로 dfs는 런타임 에러가 발생할것임 -> DP로 풀어야 함.
 * import java.util.Scanner;
 *
 * public class LIS {
 *     static int[] arr;
 *     static int maxLen;
 *
 *     public static void main(String[] args) {
 *         Scanner sc = new Scanner(System.in);
 *         int T = sc.nextInt();
 *
 *         for (int tc = 1; tc <= T; tc++) {
 *             int N = sc.nextInt();
 *             arr = new int[N];
 *             maxLen = 0;
 *
 *             for (int i = 0; i < N; i++) {
 *                 arr[i] = sc.nextInt();
 *             }
 *
 *             for (int i = 0; i < N; i++) {
 *                 dfs(i, 1, arr[i]); // 각 원소에서 시작하는 LIS 찾기
 *             }
 *
 *             System.out.println("#" + tc + " " + maxLen);
 *         }
 *     }
 *
 *     static void dfs(int index, int length, int lastNum) {
 *         maxLen = Math.max(maxLen, length); // 현재까지의 길이와 최대 길이 비교
 *
 *         for (int i = index + 1; i < arr.length; i++) {
 *             if (arr[i] > lastNum) {
 *                 dfs(i, length + 1, arr[i]); // 증가 부분 수열이면 계속 탐색
 *             }
 *         }
 *     }
 * }
 */