package swea.D3;

import java.util.Scanner;

// [S/W 문제 해결 기본] 1일차 - Flatten
// 풀이: Arrays.sort(arr), arr[0]--; arr[99]++; 출력 전에 다시 sort 해준 뒤 최대 - 최소
public class Solution1208 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            int N = sc.nextInt();
            int[] arr = new int[100];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }

            for (int i = 0; i < N; i++) {
                int high = 0;
                int low = 100;
                int highTemp = 0;
                int lowTemp = 0;
                // 배열 초기화를 해줘야 함. 안그러면 누적된 값으로 비교가 됨.

                for (int j = 0; j < arr.length; j++) {
                    if (arr[j] < low) {
                        low = arr[j];
                        lowTemp = j;
                    } else continue;
                }
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j] > high) {
                        high = arr[j];
                        highTemp = j;
                    } else continue;
                }
                if (arr[highTemp] - arr[lowTemp] <= 1) {
                    break;
                }

                arr[highTemp]--;
                arr[lowTemp]++;
            }
            int high = 0;
            int low = 100;
            for (int i = 0; i < arr.length; i++) {
                high = Math.max(high, arr[i]);
                low = Math.min(low, arr[i]);
            }
            int result = high - low;
            System.out.println("#" + tc + " " + result);
        }
    }
}

/** Arrays.sort 사용하면 훨씬 깔끔한 풀이
 * for (int t = 1; t <= 10; t++) {
 * 			int dump = Integer.parseInt(br.readLine());
 *
 * 			int[] arr = new int[100];
 * 			StringTokenizer st = new StringTokenizer(br.readLine());
 * 			for (int i = 0; i < 100; i++) {
 * 				arr[i] = Integer.parseInt(st.nextToken());
 *                        }
 *
 * 			for (int i = 0; i < dump; i++) {
 * 				Arrays.sort(arr);
 * 				arr[0]++;
 * 				arr[99]--;
 *            }
 * 			Arrays.sort(arr);
 * 			int result = arr[99] - arr[0];
 * 			System.out.println("#" + t + " " + result);* 		}
 */