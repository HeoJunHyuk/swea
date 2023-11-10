package swea.D3;

import java.util.*;

// 0/1 Knapsack ****
// 풀이: DP를 사용해서 푸는 대표적인 문제. bottom-up (table-filling) 방식 -> dp[N+1][K+1] 배열에 2중 for문을 통해 최대 가치 기입
// 백 트래킹으로 풀면 N <= 100 이므로 시간 초과( 시간 복잡도가 2^n 이라서 ) -> 백 트래킹은 N <= 20 일 경우에 사용하자.

public class Solution3282 {

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");

            int N = sc.nextInt();   // 물건의 개수
            int K = sc.nextInt();   // 가방의 부피

            int w[] = new int[N + 1];
            int cost[] = new int[N + 1];

            for(int i = 1; i <= N; i++){
                w[i] = sc.nextInt();    // 해당 물건의 부피
                cost[i] = sc.nextInt(); // 해당 물건의 가치
            }

            int dp[][] = new int[N+1][K+1];

            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= K; j++){
                    // 현재 고려하고 있는 물건 i의 무게가 배낭의 용량 j보다 크면 해당 물건을 배낭에 넣을 수 없기 때문에, 직전 단계 최대 가치를 가져옴
                    if(w[i] > j){
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        // dp[i - 1][j - w[i]] + cost[i] : 현재 물건을 넣었을 때의 가치. 물건을 넣으면 무게가 차감되고, 그에 따른 추가 가치가 더해짐
                        // dp[i - 1][j]: 현재 물건을 넣지 않았을 때의 가치. 이전 단계에서의 최대 가치를 그대로 가져옴
                        dp[i][j] = Math.max(dp[i - 1][j - w[i]] + cost[i], dp[i - 1][j]);
                    }
                }
            }
            sb.append(dp[N][K]).append("\n");   // dp[N][K] 가 최대 가치 -> 이를 구하기 위해 table-filling 함

        }
        System.out.println(sb);
    }
}
