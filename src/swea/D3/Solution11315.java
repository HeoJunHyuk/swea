package swea.D3;

import java.util.Scanner;

// 오목 판정 ***
// 풀이: dx, dy, dir 사용   처음부터 끝까지 확인할거기 때문에 8방향 말고, 좌, 우, 좌하, 우하 만 확인했음.
// for문 break할때, 새로운 팁 배움 -> 이름 : for(~) {... break 이름;}
public class Solution11315 {

    static char[][] board;
    static int N;
    static int[][] v = {{0, 1}, {1, -1}, {1, 0}, {1, 1}};   // i,j 기준 -> 우, 좌하, 하, 우하
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            board = new char[N][N];
            String ans = "NO";

            for (int i = 0; i < N; i++) {
                board[i] = sc.next().toCharArray();
            }

            gaming : for (int i = 0; i < N; i++) {  // 모든 오목판 곳곳을 4개의 방향으로 확인(5개의 돌이 붙어있나)
                for (int j = 0; j < N; j++) {
                    if (board[i][j] == 'o') {   // 돌 만나면
                        for (int dir = 0; dir < 4; dir++) { // 4방향이므로 4번
                            int res = search(i, j, dir);
                            if (res == 5) { // 돌 5개 발견하면 끝
                                ans = "YES";
                                break gaming;
                            }
                        }
                    }
                }
            }

            System.out.println("#" + tc + " " + ans);

        }
    }

    private static int search(int i, int j, int dir) {
        int cnt = 1;    // 돌을 발견해야 호출되므로 1로 초기화
        int dx = i;
        int dy = j;
        for (int g = 0; g < 4; g++) {   // 방향이 4개면서 4개의 돌을 더 만나면 5개가 되므로, 4번 반복
            dx = dx + v[dir][0];
            dy = dy + v[dir][1];
            if (dx >= 0 && dx < N && dy >= 0 && dy < N && board[dx][dy] == 'o') {   // 범위 안, 돌 발견
                cnt++;
            } else break;
        }
        return cnt;
    }
}
