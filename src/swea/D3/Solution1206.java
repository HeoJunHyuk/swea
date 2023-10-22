package swea.D3;

import java.util.Scanner;

// [S/W 문제해결 기본] 1일차 - View
// 풀이: 좌우 2칸씩의 건물들 중 max 구하고 이를 arr[i] > max 일 때, arr[i] - max
public class Solution1206 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            int N = sc.nextInt();
            int[] arr = new int[N]; // N = 건물의 개수
            int cnt = 0;
            int maxL = 0;
            int maxR = 0;
            int max = 0;

            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }

            for (int i = 2; i < arr.length - 2; i++) {
                if (arr[i] > arr[i - 1] && arr[i] > arr[i - 2]) {
                    if (arr[i] > arr[i + 1] && arr[i] > arr[i + 2]) {
                        maxL = Math.max(arr[i - 1], arr[i - 2]);
                        maxR = Math.max(arr[i + 1], arr[i + 2]);
                        max = Math.max(maxL, maxR);
                        cnt += (arr[i] - max);
                    } else continue;
                }
            }

            System.out.println("#" + tc + " " + cnt);
        }
    }
}

/**
 *            for (int i = 2; i < N - 2; i++) {
 *                 int max = Math.max(arr[i - 2], Math.max(arr[i - 1], Math.max(arr[i + 1], arr[i + 2])));
 *                 if (arr[i] - max > 0) // 좌 우 건물 높이의 최댓값보다 현재 건물의 높이가 높으면
 *                     cnt += arr[i] - max;
 *             }
 */