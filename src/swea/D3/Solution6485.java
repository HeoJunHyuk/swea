package swea.D3;

import java.util.Scanner;

// 삼성시의 버스 노선
// 풀이: 문제 이해만 하면 풀이는 쉬움 -> for문 사용해서 배열 값++ 해주고 출력 [주의: 맨 마지막에 다음 테케로 넘어가야 하므로 줄넘김해줘야 함]

public class Solution6485 {

    static int[] arr;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            arr = new int[5001];

            for (int i = 0; i < N; i++) {
                int A = sc.nextInt();
                int B = sc.nextInt();
                for (int j = A; j < B + 1; j++) {
                    arr[j]++;
                }
            }
            int P = sc.nextInt();
            System.out.print("#" + tc);
            for (int i = 0; i < P; i++) {
                int C = sc.nextInt();
                System.out.print(" " + arr[C]);
            }
            System.out.println();
        }
    }

}
