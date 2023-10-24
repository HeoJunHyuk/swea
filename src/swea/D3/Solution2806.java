package swea.D3;

import java.util.Scanner;

// N-Queen ****
// 풀이: DFS로 풀어야 함. board[N]을 만들어 열을 내려가면서 해당 행에 어떤 위치에 퀸을 놓았는지 명시. 재귀 호출을 통해 위쪽 열(curr = 0)부터 퀸을 놓고 아래로(curr = N) 내려가는 방식

public class Solution2806 {

    static int board[]; // 퀸의 위치를 담는다. (board[0]=1 -> (0,1)에 하나의 퀸이 있다. board[1] = 3 -> (1,3)에 하나의 퀸이 있다.)
    static int answer;
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            board = new int[N];
            answer = 0;
            countNQueenCase(N, 0);
            System.out.println("#" + tc + " " + answer);

        }
    }

    public static void countNQueenCase(int N, int curr) {
        boolean isPossible;		//놓을 수 있는가
        if (curr == N) {		//모든 퀸을 놓은 경우
            answer++;
            return;
        }
        for (int i = 0; i < N; i++) {		// [curr][i]에 퀸을 놓을 수 있는지 확인
            isPossible = true;
            for (int j = 0; j < curr; j++) {
                if (board[j] == i || i == board[j]+(curr - j) || i == board[j]-(curr - j)) {		//직선, 대각선 확인
                    /**
                     *  board[j] == i : 위에서 놓은 퀸이 있는 직선이기에 이 열은 다른 퀸을 놓을 수 없다
                     *  i == board[j]+(curr - j) : 위에서 놓은 퀸의 오른쪽 대각선이 현재 행의 i를 지나가기에 다른 퀸을 놓을 수 없다
                     *  i == board[j]-(curr - j)) : 위에서 놓은 퀸의 왼쪽 대각선이 현재 행의 i를 지나가기에 다른 퀸을 놓을 수 없다
                     */
                    isPossible = false;
                    break;
                }

            }
            if (isPossible) {
                board[curr] = i;
                countNQueenCase(N, curr + 1);
            }
        }
    }
}
/**
 * private static int answer;
 *     public static void main(String[] args) {
 *         Scanner scanner = new Scanner(System.in);
 *         int T = scanner.nextInt();          // 테스트케이스 개수 T
 *
 *         for (int i = 1; i <= T; i++) {
 *             int N = scanner.nextInt();      // 퀸 N개 (1~10)
 *             int[] row = new int[N];
 *             answer = 0;
 *
 *             dfs(0, row, N);
 *
 *             System.out.println("#"+ i + " " + answer);
 *         }
 *     }
 *
 *     private static void dfs(int level, int[] row, int N) {
 *         if (level == N) {
 *             answer++;
 *             return;
 *         }
 *         for (int i = 0; i < N; i++) {
 *             row[level] = i;
 *
 *             if (isPromising(level, row)){
 *                 dfs(level + 1, row, N);
 *             }
 *         }
 *     }
 *
 *     private static boolean isPromising(int next, int[] row) {
 *         for (int i = 0; i < next; i++) {
 *             if (row[i] == row[next] || Math.abs(row[i]-row[next]) == next - i) return false;
 *         }
 *         return true;
 *     }
 */