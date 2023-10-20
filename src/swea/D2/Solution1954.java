package swea.D2;

import java.util.Scanner;

// 달팽이 숫자 *****
// 풀이: dx, dy를 우,하,좌,상 순으로 만들고, nums[N][N]을 만들어서 다 0으로 초기화. dir을 사용해서 배열 범위를 벗어나거나 뒤의 배열이 0이 아니면 방향 전환
public class Solution1954 {
    static int[] dx = { 0, 1, 0, -1 }; // 우 하 좌 상 순서
    static int[] dy = { 1, 0, -1, 0 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 개수
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[][] nums = new int[N][N]; // n*n 배열 생성

            int dir = 0; // 현재 방향 인덱스
            int x = 0, y = 0; // 시작 좌표
            for (int i = 1; i <= N * N; i++) { // 1부터 N*N까지 숫자를 배열에 넣기
                nums[x][y] = i;
                if (x + dx[dir] >= N || x + dx[dir] < 0 || y + dy[dir] >= N || y + dy[dir] < 0
                        || nums[x + dx[dir]][y + dy[dir]] != 0) {
                    // N * N 배열 범위 안에 있는지, 배열을 벗어나는지 //그 자리에 숫자가 입력되있는지 확인
                    dir = (dir + 1) % 4; // 방향전환
                }
                x += dx[dir];
                y += dy[dir];
            }
            System.out.println("#" + t);
            for (int i = 0; i < N; i++) {
                for (int n : nums[i])
                    System.out.print(n + " ");
                System.out.println();
            }
        }

    }
}
