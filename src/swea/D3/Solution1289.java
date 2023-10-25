package swea.D3;

import java.util.Scanner;

// 원재의 메모리 복구하기
// 풀이: 데이터 핸들링 -> str.charAt(i)를 통해서 비교 하면서 cnt++;

public class Solution1289 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            String str = sc.next();
            int[] input = new int[str.length()];
            int[] zero = new int[str.length()];
            int cnt = 0;

            for (int i = 0; i < input.length; i++) {
                input[i] = str.charAt(i) - '0';
                if (zero[i] != input[i]) {
                    for (int j = i; j < input.length; j++) {
                        zero[j] = input[i];
                    }
                    cnt++;
                }
            }
            System.out.println("#" + tc + " " + cnt);
        }
    }

}
/**
 * public static void main(String[] args) {
 * 		Scanner sc = new Scanner(System.in);
 * 		int T = sc.nextInt();
 * 		String memory;
 * 		char before;
 * 		int ans;
 * 		for (int t = 1; t <= T; t++) {
 * 			memory = sc.next();
 * 			before = '0';
 * 			ans = 0;
 * 			for (int i = 0; i < memory.length(); i++) {
 * 				if (before != memory.charAt(i)) {
 * 					before = memory.charAt(i);
 * 					ans++;
 *                                }* 			}
 * 			System.out.printf("#%d %d\n", t, a        ;
 *    }
 * 	}
 */