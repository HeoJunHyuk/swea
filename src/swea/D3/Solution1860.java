package swea.D3;

import java.util.Arrays;
import java.util.Scanner;

// 진기의 최고급 붕어빵 *
// 풀이: 데이터 핸들링
// 방법 1: 1초씩 증가시켜서 M초 나누어서 K개의 빵을 증가, 줄 수 있는 빵이 있는지 판별
// 방법 2: M초씩 증가시키면서 M초 전에 손님이 왔는지 판별, 있다면 빵을 줄 수 있는지 판별
public class Solution1860 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();   // 고객 수
            int M = sc.nextInt();   // 붕어빵 만드는 시간
            int K = sc.nextInt();   // M초 동안 만드는 붕어빵 개수

            int[] client = new int[N];
            boolean possible = true;

            String result = "Impossible";

            for (int i = 0; i < N; i++) {   // 손님들이 오는 시간을 입력받음
                client[i] = sc.nextInt();
            }
            Arrays.sort(client);
            int lastTime = client[N - 1];
            int idx = 0;    // client[]를 각각 가리키는 인덱스 값
            int bread = 0;

            if (client[0] == 0) possible = false;   // 손님이 0초에 오는 테스트 케이스가 있음. -> 생각 못하면 틀림

            for (int i = 1; i <= lastTime; i++) {   // 1초씩 증가시켜서(i) M초로 나누어지면 K개의 빵을 증가
                if (i % M == 0) bread += K;
                if (idx < N) {
                    if (i == client[idx]) {
                        idx++;  // 다음 손님으로 idx값을 증가
                        if (bread > 0) bread--;
                        else {  // 줄 빵이 없으므로 종료
                            possible = false;
                            break;
                        }
                    }
                }
            }
            if (possible) result = "Possible";

            System.out.println("#" + tc + " " + result);

        }
    }
}

/**
 * public class Solution {
 * 	static int N, M, K;
 * 	static int[] guest;
 *
 * 	static String isPossible() {
 * 		int fishbread = 0; // 만들어진 붕어빵 수
 * 		int idx = 0; // 손님 번호
 * 		int time = 0;
 * 		while (true) {
 * 			while (time + M > guest[idx]) {
 * 				if (fishbread-- == 0) {
 * 					return "Impossible";
 *               }
 * 				if (idx++ >= N - 1) {   // idx가 0부터 시작하므로 N - 1 예를 들어, N =3 이면 guest[0]이 1번째 손님이므로
 * 					return "Possible";
 *               }
 * 			time += M;
 * 			fishbread += K;
 *    }
 * 	}
 *
 * 	public static void main(String[] args) {
 * 		Scanner sc = new Scanner(System.in);
 * 		int T = sc.nextInt();
 *
 * 		for (int t = 1; t <= T; t++) {
 * 			N = sc.nextInt(); // 손님 수
 * 			M = sc.nextInt(); // M분마다
 * 			K = sc.nextInt(); // K개 만든다
 * 			guest = new int[N];
 * 			for (int i = 0; i < N; i++) {
 * 				guest[i] = sc.nextInt();
 * 			}
 * 			Arrays.sort(guest); // 손님이 도착한시간 빨리온순서로 정렬
 *
 * 			System.out.printf("#%d %s\n", t, isPossible());
 * 		}*
 * 	}
 * }
 */