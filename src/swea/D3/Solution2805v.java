package swea.D3;

import java.util.Scanner;

// 농작물 수확하기 ***
// 풀이: N / 2 = mid 를 기준으로 위, 아래 나눠서 합치기. 배열의 시작점과 종료점을 바꿔가면서 각 행을 더해줌
public class Solution2805v {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();	// 농장 크기
            int mid = N / 2;
            int sum = 0;			// 총 수확한 농작물(수익)

            for(int i = 0; i < N; i++) {
                String crop = sc.next();	// 한 줄 입력받음

                if(i <= mid) {	// 농장 위쪽 절반의 경우
                    for(int j = mid - i; j < mid + i + 1; j++) {
                        sum += crop.charAt(j) - '0';    // 문자를 숫자로 변경
                    }
                } else {		// 농장 아래쪽 절반의 경우
                    for(int j = i - mid; j < N + mid - i; j++) {
                        sum += crop.charAt(j) - '0';
                    }
                } // end else
            } // end for i
            System.out.printf("#%s %s%n", test_case, sum);
        } // end for test_case
    }
}

/** 농장 중앙으로부터의 거리로 계산 (가상의 2차원 배열)
 * public static void main(String args[]) throws Exception {
 * 		Scanner sc = new Scanner(System.in);
 * 		int T = sc.nextInt();
 *
 * 		for(int test_case = 1; test_case <= T; test_case++) {
 * 			int N = sc.nextInt();			// 농장 크기
 *             int sum = 0;					// 총 수확한 농작물(수익)
 *
 *             for(int i = 0; i < N; i++) {
 *             	char[] arr = sc.next().toCharArray();	// 한 줄 입력받아 쪼개기
 *                 // 중앙으로부터의 거리가 N/2 이하이면 수확
 *                 for(int j = 0; j < N; j++) {
 *                     int distance = Math.abs(i - N/2) + Math.abs(j - N/2);
 *                     if(distance <= N / 2) {
 *                     	sum += arr[j] - '0';
 *                     }
 *                 } // end for j
 *             } // end for i
 *             System.out.printf("#%s %s%n", test_case, sum);
 *         } // end for test_case
 *     }
 */

/**
 * int ans = 0;
 * 			int start = n/2;
 * 			int end = n/2;
 * 			for (int i=0; i<n; i++) {
 * 				for (int j=start; j<=end; j++) { // 각 행마다
 * 					ans += map[i][j];
 *                                }
 * 				if (i < n/2) { // 행의 절반 전이면
 * 					start -= 1; // 시작을 줄여주고
 * 					end += 1; // 끝을 늘려서 열의 범위를 키움
 *                } else { // 행의 절반이 지나면
 * 					start += 1; // 시작을 늘리고
 * 					end -= 1; // 끝을 줄여서 열의 범위를 좁힘
 *                }* 			}
 */