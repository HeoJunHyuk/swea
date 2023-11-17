package swea.D3;

import java.util.ArrayList;
import java.util.Scanner;

// 최장 경로 ***
// 풀이: 무방향 그래프 -> dfs, visited[], ArrayList<>() 사용해서 방문했던 곳은 패스하고, 새로 방문하는 정점들을 타고 들어가면서 cnt++
// 최장 경로 = 방문한 정점의 수
public class Solution2814v {

    static int N, M, ans;
    static boolean[] visited;
    static ArrayList<Integer>[] start;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();   // 정점 수
            M = sc.nextInt();   // 간선 수
            ans = 1;

            start = new ArrayList[N + 1]; // 각 노드에 연결된 정점들
            visited = new boolean[N + 1]; // 기본 초기화 : false, 1번 arrayList부터 사용하려고 +1, 노드 방문 여부

            for (int i = 1; i < N + 1; i++) {
                start[i] = new ArrayList<>();
            }

            // 각 노드마다 연결된 정점을 arrayList에 저장
            for (int i = 0; i < M; i++) {
                int from = sc.nextInt();    // 시작 정점
                int to = sc.nextInt();      // 도착 정점

                start[from].add(to);
                start[to].add(from);
            }

            // 연결된 정점 모두 타고 들어가면서 Dfs
            for (int Strt = 1; Strt < N + 1; Strt++) {
                visited[Strt] = true;
                dfs(Strt, 1, 0);
                visited[Strt] = false;
            }
            System.out.println("#" + tc + " " + ans);

        }
    }

    private static void dfs(int startNode, int cnt, int depth) {
        ans = Math.max(ans, cnt);

        if (depth == N) return;

        // 연결된 노드로 타고 들어가기( 각 List 내에 arrayList에서 하나씩 확인 )
        for (int to = 0; to < start[startNode].size(); to++) {

            int next = start[startNode].get(to);

            // 방문했던 곳이라면 패스
            if (visited[next]) continue;

            // 처음 방문했다면
            visited[next] = true;
            dfs(next, cnt + 1, depth + 1);  // next 정점으로 이동
            visited[next] = false;

        }
    }
}
