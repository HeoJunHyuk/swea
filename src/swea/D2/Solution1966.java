package swea.D2;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

// 숫자를 정렬하자
// 풀이: 오름차순 정렬 -> sort
public class Solution1966 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int[] arr = new int[N];

            for(int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);
            System.out.print("#" + tc + " ");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
