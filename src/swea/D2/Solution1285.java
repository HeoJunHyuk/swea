package swea.D2;

import java.util.Arrays;
import java.util.Scanner;

// 아름이의 돌 던지기
// 풀이: 음의 정수는 Math.abs를 통해 양의 정수로 바꿔서 arr[]에 다 넣고, sort 정렬 후, arr[0]으로 가장 작은 값을 도출
public class Solution1285 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            int min = 0;
            int cnt = 0;
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Math.abs(sc.nextInt());
            }
            Arrays.sort(arr);
            min = arr[0];

            for (int i = 0; i < arr.length; i++) {
                if (min == arr[i]) {
                    cnt++;
                } else break;
            }
            System.out.println("#" + tc + " " + min + " " + cnt);
        }
    }
}
