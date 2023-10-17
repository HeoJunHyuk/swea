package swea.D2;

import java.io.IOException;
import java.util.Scanner;

// 초심자의 회문 검사
// 풀이: String을 배열 인덱스로 넣어서 비교   / charAt()  / StringBuffer()
public class Solution1989 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            String str = sc.next();
            char[] arr = str.toCharArray();
            char[] arr2 = new char[str.length()];
            int result = 0;


            for (int i = arr.length - 1; i >= 0; i--) {
                arr2[i] = arr[arr.length - i - 1]; // 3 = 0, 2 = 1, 1 = 2, 0 = 3
            }
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == arr2[i]) {
                    result = 1;
                } else {
                    result = 0;
                }
            }

            System.out.printf("#%d %d\n", tc, result);

        }
    }
}

/**
 * String.charAt()으로 비교
 * for(int t=1; t<=T; t++) {
 *          String str = sc.next();
 *
 *          int result = 1;
 *          for(int i=0; i<str.length()/2+1; i++) {
 *              if(str.charAt(i) != str.charAt(str.length()-i-1)) { // 맨앞과 맨뒤 비교 부터 한칸씩 땡겨서
 *                  result = 0; // 다르면 0
 *                  break;
 *              }
 *          }
 *          System.out.printf("#%d %d\n", t, result);
 */

/**
 * StringBuffer()를 사용한 방법
 * for (int tc=1; tc<=t; tc++) {
 * 			String data = sc.next();
 * 			StringBuffer sb = new StringBuffer(data);
 * 			String reversed_data = sb.reverse().toString();
 * 			if (data.equals(reversed_data)) {
 * 				System.out.println("#" + tc + " " + 1);
 *                        } else {
 * 				System.out.println("#" + tc + " " + 0);
 *            }* 		}
 */