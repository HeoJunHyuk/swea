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
