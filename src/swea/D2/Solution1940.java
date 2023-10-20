package swea.D2;

import java.util.Scanner;

// 가랏! RC카!
// 풀이: c 값이 0,1,2 중에 하나기 때문에 if문 활용하여 총 거리 계산
public class Solution1940 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 개수
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();   // 커맨드 수 = 시간
            int d = 0;  //거리
            int v = 0;  //속력
            int dv = 0; //속력 변화량
            int c = 0;  //커맨드

            for (int i = 0; i < N; i++) {
                c = sc.nextInt();
                if (c == 1) {
                    v = sc.nextInt();
                    dv += v;
                    d += dv;    // if문에서 다 공통되는 부분이라 if문 끝에 공통으로 배치해도 무방
                } else if (c == 2) {
                    v = sc.nextInt();
                    dv -= v;
                    if (dv < 0) {
                        dv = 0;
                    }
                    d += dv;
                } else d += dv;

            }

            System.out.println("#" + tc + " " + d);
        }

    }
}

/**
 * for (int t = 1; t <= T; t++) {
 * 			nowSpeed = 0;  distance = 0;
 * 			N = sc.nextInt();
 * 			for (int i = 0; i < N; i++) {
 * 				switch (sc.nextInt()) {
 * 				case 1:
 * 					nowSpeed += sc.nextInt();
 * 					break;
 * 				case 2:
 * 					nowSpeed -= sc.nextInt();
 * 					if (nowSpeed < 0)
 * 						nowSpeed = 0;
 * 					break;
 *                                }
 * 				distance += nowSpeed;* 			}
 */