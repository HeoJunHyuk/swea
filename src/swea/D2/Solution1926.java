package swea.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 간단한 369게임 = 3, 6, 9 가 포함된 숫자에 박수치기
// 풀이: String.contains(), String.charAt() 또는 정규식(replaceAll) 또는 replace
public class Solution1926 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            String str = String.valueOf(i); // ex) i = 23일 때, String으로 바꾸면 str.length = 2
            // valueOf를 사용하면 null 값이어도 출력. (Null Pointer Exception 안터짐)

            if (str.contains("3") || str.contains("6") || str.contains("9")) {
                for (int j = 0; j < str.length(); j++) {
                    if (str.charAt(j) == '3' || str.charAt(j) == '6' || str.charAt(j) == '9') {
                        System.out.print("-");
                    }
                }
                System.out.print(" ");
            } else {
                System.out.print(i + " ");
            }
        }

    }
}

/**
 * 정규식을 활용한 풀이 -> replaceAll
 * for (int i = 1; i <= n; i++) {
 *             String tmp = String.valueOf(i);
 *
 *             if (tmp.contains("3") || tmp.contains("6") || tmp.contains("9")) {
 *                 for (int j = 0; j < tmp.length(); j++) {
 *                     tmp = tmp.replaceAll("[369]", "-");
 *                 }
 *                 tmp = tmp.replaceAll("[0124578]", "");
 *             }
 *             System.out.print(tmp + " ");
 *
 *
 *         }
 */

/**
 * replace를 활용한 풀이
 *  for (int i = 1; i <= n; i++) {
 *             String tmp = String.valueOf(i);
 *
 *             if (tmp.contains("3") || tmp.contains("6") || tmp.contains("9")) {
 *                 tmp = tmp.replace("3", "-");
 *                 tmp = tmp.replace("6", "-");
 *                 tmp = tmp.replace("9", "-");
 *
 *                 tmp = tmp.replace("0", "");
 *                 tmp = tmp.replace("1", "");
 *                 tmp = tmp.replace("2", "");
 *                 tmp = tmp.replace("4", "");
 *                 tmp = tmp.replace("5", "");
 *                 tmp = tmp.replace("7", "");
 *                 tmp = tmp.replace("8", "");
 *
 *             }
 *             System.out.print(tmp + " ");
 *         }
 *
 */