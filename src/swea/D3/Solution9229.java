package swea.D3;

import java.util.Arrays;
import java.util.Scanner;

// 한빈이와 Spot Mart
// 풀이: 단순 가지치기로 가능 -> 배열 하나 만들어서 max 갱신해도 가능 / 배열 sort 하고 뒤에서부터 max 찾아도 됨.
// 순서 상관 X, 중복 불가 -> 조합 문제

public class Solution9229 {

    static int N, M, max;
    static int[] weight;

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            M = sc.nextInt();
            weight = new int[N];

            for (int i = 0; i < weight.length; i++) {
                weight[i] = sc.nextInt();
            }
            Arrays.sort(weight);
            max = 0;
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (weight[i] + weight[j] <= M) {
                        max = Math.max(max, weight[i] + weight[j]);
                    }
                }
            }
            if (max == 0) {
                System.out.printf("#%d %d\n", tc, -1);
            } else System.out.println("#" + tc + " " + max);

        }
    }

}

/** 조합으로 풀기
 * import java.io.*;
 * import java.util.*;
 *
 * public class Solution {
 * 	static int maxWeight;
 * 	static int M;
 *
 * 	public static void main(String[] args) throws Exception {
 * 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 * 		StringTokenizer st = new StringTokenizer(br.readLine());
 *
 * 		int T = Integer.parseInt(st.nextToken());
 *
 * 		for (int test_case = 1; test_case <= T; test_case++) {
 * 			st = new StringTokenizer(br.readLine());
 * 			int N = Integer.parseInt(st.nextToken()); // 과자 개수
 * 			M = Integer.parseInt(st.nextToken()); // 최대 무게
 *
 * 			int[] arr = new int[N]; // 과자 무게 정보 저장
 *
 * 			st = new StringTokenizer(br.readLine());
 * 			for (int i = 0; i < arr.length; i++) {
 * 				arr[i] = Integer.parseInt(st.nextToken());
 *                        }
 *
 * 			maxWeight = 0;
 * 			recursive(arr, new int[2], 0, 0);
 * 			if (maxWeight == 0) {
 * 				maxWeight = -1;
 *            }
 * 			System.out.println("#" + test_case + " " + maxWeight);
 ** 		}
 * 	}
 *
 * 	private static void recursive(int[] arr, int[] sel, int aIdx, int sIdx) {
 * 		// basis part
 * 		if (sel.length == sIdx) {
 * 			if (sel[0] + sel[1] > maxWeight && sel[0] + sel[1] <= M) {
 * 				maxWeight = sel[0] + sel[1];
 * 			}
 * 			return;
 * 		}
 *
 * 		// inductive part
 * 		for (int i = aIdx; i < arr.length; i++) {
 * 			sel[sIdx] = arr[i];
 * 			recursive(arr, sel, i + 1, sIdx + 1);
 *    }
 * 	}
 * }
 */
