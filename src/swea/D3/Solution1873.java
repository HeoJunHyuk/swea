package swea.D3;

import java.util.Scanner;

// 상호의 배틀필드
// 풀이: dx, dy, dir 이용 switch문 또는 if문으로 문자에 따른(방향) dir를 바꿔줌

public class Solution1873 {
    static int T, H, W, x, y, dir;
    static char[][] map;
    static int[][] v = {{0,0}, {0,1}, {0,-1}, {1,0}, {-1,0}}; // 동서남북

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        for(int tc=1; tc<=T; tc++) {
            H = sc.nextInt();
            W = sc.nextInt();

            map = new char[H][W];

            x = 0;
            y = 0;
            dir = 0; // 1: 동, 2: 서, 3: 남, 4: 북

            for(int i=0; i<H; i++) {
                String st = sc.next();
                for(int j=0; j<W; j++) {
                    map[i][j] = st.charAt(j);

                    if(map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {  // 전차 찾아서 좌표, 머리 방향 찾음
                        if(map[i][j] == '^') dir = 4;
                        else if(map[i][j] == 'v') dir = 3;
                        else if(map[i][j] == '<') dir = 2;
                        else if(map[i][j] == '>') dir = 1;

                        x = i;
                        y = j;
                    }
                }
            }

            int N = sc.nextInt();
            // SURSSSSUSLSRSSSURRDSRDS

            String str = sc.next();

            for(int i=0; i<N; i++) {
                char cur = str.charAt(i);
                int nx, ny;

                if(cur == 'U' || cur == 'D' || cur == 'L' || cur =='R') {   // 4방향 중에 하나이면 방향에 맞게 dir 변경, 전차 머리 방향 변경
                    if(cur == 'U') {
                        dir = 4;
                        map[x][y] = '^';
                    } else if(cur == 'D') {
                        dir = 3;
                        map[x][y] = 'v';
                    } else if(cur == 'L') {
                        dir = 2;
                        map[x][y] = '<';
                    } else if(cur == 'R') {
                        dir = 1;
                        map[x][y] = '>';
                    }

                    nx = x + v[dir][0];
                    ny = y + v[dir][1];

                    if(isInside(nx, ny)) {  // 범위 안에 들어있는지
                        if(map[nx][ny] == '.') {    // 평지 일때만 이동 가능
                            map[nx][ny] = map[x][y];
                            map[x][y] = '.';
                            x = nx; y = ny;
                        }
                    }
                } else if(cur == 'S') { // 슈팅일 때
                    // 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.
                    nx = x;
                    ny = y;

                    while(true) {
                        nx += v[dir][0];
                        ny += v[dir][1];
                        if(!isInside(nx, ny) || map[nx][ny] == '#') break;  // 강철 벽을 만나거나 범위 밖으로 나가게 되면 탈출
                        else if(map[nx][ny] == '*') {   // 벽돌 벽을 만나면 평지로 변경 후 탈출
                            map[nx][ny] = '.';
                            break;
                        }
                    }
                }
            }

            System.out.print("#" + tc + " ");
            for(int i=0; i<H; i++) {
                for(int j=0; j<W; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
    }

    public static boolean isInside(int x, int y) {
        return x>=0 && x<H && y>=0 && y<W;
    }

}

/** 내가 풀었던 풀이. 전차가 움직이도 않아도 방향은 바꿔줘야 함. 이를 틀렸다가 수정함.
 * import java.util.Scanner;
 *
 * // 상호의 배틀필드
 *
 * public class Solution {
 *
 *     static int H, W, N;
 *     static char[][] board;
 *     static char[] input;
 *     static char[] v = {'<', '>', '^', 'v'};
 *     static int[] dx = {0, 0, -1, 1};    // 좌 우 상 하
 *     static int[] dy = {-1, 1, 0, 0};
 *
 *     public static void main(String[] args) {
 *         Scanner sc = new Scanner(System.in);
 *         int T = sc.nextInt();
 *
 *         for (int tc = 1; tc <= T; tc++) {
 *             H = sc.nextInt();   // 높이
 *             W = sc.nextInt();   // 너비
 *             board = new char[H][W];   // 게임판
 *             int x = 0;
 *             int y = 0;
 *             int dir = 0;
 *
 *
 *             for (int i = 0; i < H; i++) {
 *                 board[i] = sc.next().toCharArray();
 *
 *                 game : for (int j = 0; j < W; j++) {
 *                     for (int k = 0; k < 4; k++) {
 *                         if (board[i][j] == v[k]) {  // 전차 좌표 및 머리 방향 찾기
 *                             x = i;
 *                             y = j;
 *                             dir = k;
 *                             break game;
 *                         }
 *                     }
 *                 }
 *             }
 *
 *             N = sc.nextInt();   //사용자 입력 받음
 *             input = new char[N];
 *             String str = sc.next();
 *             for (int i = 0; i < N; i++) {
 *                 input[i] = str.charAt(i);
 *             }
 *
 *             battle(x, y, dir);
 *
 *             System.out.print("#" + tc + " ");
 *             for (int i = 0; i < H; i++) {
 *                 System.out.print(new String(board[i]));
 *                 System.out.println();
 *             }
 *         }
 *     }
 *
 *     private static void battle(int i, int j, int dir) {
 *         int x = i;
 *         int y = j;
 *
 *         for (int c = 0; c < N; c++) {
 *
 *             // S: 포탄 발사
 *             if (input[c] == 'S') {
 *                 int nx = x;
 *                 int ny = y;
 *                 while (nx >= 0 && ny >= 0 && nx < H && ny < W) {
 *                     nx += dx[dir];
 *                     ny += dy[dir];
 *                     if (nx < 0 || ny < 0 || nx >= H || ny >= W) {
 *                         break; // 포탄이 맵 밖으로 나갔을 때
 *                     }
 *                     if (board[nx][ny] == '#') {
 *                         break; // 포탄이 강철 벽에 부딪혔을 때
 *                     } else if (board[nx][ny] == '*') {
 *                         board[nx][ny] = '.';
 *                         break; // 포탄이 벽돌 벽을 파괴했을 때
 *                     }
 *                 }
 *             } else {
 *                 // 방향 전환
 *                 int newDir = dir;
 *                 if (input[c] == 'L') {
 *                     newDir = 0; // 좌
 *                 } else if (input[c] == 'R') {
 *                     newDir = 1; // 우
 *                 } else if (input[c] == 'U') {
 *                     newDir = 2; // 상
 *                 } else if (input[c] == 'D') {
 *                     newDir = 3; // 하
 *                 }
 *
 *                 // 전차의 방향 바꾸기
 *                 board[x][y] = v[newDir];
 *                 int nx = x + dx[newDir];
 *                 int ny = y + dy[newDir];
 *                 if (nx >= 0 && ny >= 0 && nx < H && ny < W && board[nx][ny] == '.') {    // 이동 가능할 경우
 *                     board[nx][ny] = board[x][y];
 *                     board[x][y] = '.';
 *                     x = nx;
 *                     y = ny;
 *                 }
 *                 dir = newDir;    // 움직이지 않아도 dir 방향은 수정
 *             }
 *         }
 *     }
 *
 * }
 */