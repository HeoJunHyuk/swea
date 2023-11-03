package swea.D3;

import java.util.Scanner;

// 재미있는 오셀로 게임 ****** -> simulation
// 풀이: dx, dy를 활용해서 8방향으로 움직이면서 if 문을 활용해 게임 판 내에 있는지 확인. 상대방 돌을 뒤집을 수 있으면 뒤집음
// 다시 풀어보기.

public class Solution4615 {
    static int N;// 보드 한변의 길이 (4, 6, 8 중 하나)
    static int M;// 플레이어가 돌을 놓는 횟수

    // 상, 하, 좌, 우, 좌상, 우하, 우상, 좌하
    static final int[] dx = { -1, 1, 0, 0, -1, 1, -1, 1 };
    static final int[] dy = { 0, 0, -1, 1, -1, 1, 1, -1 };

    static int[][] map;

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            M = sc.nextInt();
            init(); // 기본 세팅
            for (int i = 0; i < M; i++) {
                int x = sc.nextInt() - 1;
                int y = sc.nextInt() - 1;
                int color = sc.nextInt();// 1이면 흑돌, 2이면 백돌
                put(x, y, color);
            }
            System.out.println("#" + tc + " " + sum());
        } // end of TC
        sc.close();
    }

    private static String sum() {
        int[] res = new int[2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1)
                    res[0]++;
                else if (map[i][j] == 2)
                    res[1]++;
            }
        }
        return res[0] + " " + res[1];
    }

    private static void init() {
        map = new int[N][N];
        int half = N / 2;
        map[half - 1][half] = 1;
        map[half][half - 1] = 1;
        map[half - 1][half - 1] = 2;
        map[half][half] = 2;
    }

    private static void put(int x, int y, int color) {
        map[x][y] = color;
        for (int dir = 0; dir < 8; dir++) {
            check(x, y, dir);
        }
    }

    private static void check(int x, int y, int dir) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        while (true) {
            if (!isRange(nx, ny) || map[nx][ny] == 0)
                break;

            if (map[x][y] != map[nx][ny]) { // 다른 색의 돌(상대방 돌)일 때
                nx += dx[dir];
                ny += dy[dir];
            } else
                break;  // 같은 색 돌일 때
        }

        if (isRange(nx, ny) && map[nx][ny] == map[x][y]) {  // 같은 색 돌일 때 -> 다른 색 돌을 만났다가 다시 나의 돌을 만났을 때
            while (x != nx || y != ny) {    // 다시 원위치를 했을 때를 제외
                map[nx][ny] = map[x][y];    // 사이에 낀 상대방의 돌을 내 돌로 뒤집기
                nx -= dx[dir];
                ny -= dy[dir];
            }
        }

    }

    private static boolean isRange(int x, int y) {
        if (0 <= x && x < N && 0 <= y && y < N)
            return true;
        return false;
    }
}
