package swea.D3;

import java.util.Scanner;

// 햄버거 다이어트 * -> 제한된 칼로리 조건 하에서 가장 만족도 높은 조합을 선택하면 되는 문제
// 풀이: 부분 집합 -> 재귀 함수
/**
 * 탐색을 하면서 만족도와 현재까지의 칼로리를 계속 기록하며
 *  선택한 경우 --> 해당 항목의 만족도와 칼로리를 더해준 뒤 진행하고
 *  선택하지 않은 경우 --> 기존의 상태에서 다음 번째 항목으로 넘겨주는
 * 위 과정만 이해하신다면 유사한 문제들을 쉽게 풀이
 */
public class Solution5215 {

    static int N, L;
    static int[] scores;
    static int[] cal;
    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            L = sc.nextInt();
            scores = new int[N];
            cal = new int[N];

            for (int i = 0; i < N; i++) {
                scores[i] = sc.nextInt();
                cal[i] = sc.nextInt();
            }
            ans = 0;
            search(0, 0, 0);

            System.out.println("#" + tc + " " + ans);
        }
    }

    private static void search(int cnt, int sumS, int sumC) {
        // 칼로리 초과
        if (sumC > L) {
            return;
        }
        // 모든 조합 확인
        if (cnt == N) {
            ans = Math.max(ans, sumS);
            return;
        }
        // 해당 재료를 선택
        search(cnt + 1, sumS + scores[cnt], sumC + cal[cnt]);
        // 해당 재료는 선택하지 않고 패스
        search(cnt + 1, sumS, sumC);
    }
}
