package swea.D2;

import java.io.IOException;
import java.util.Scanner;

// 패턴 마디의 길이 = 반복되는 음절 찾기
// 풀이: String.substring(_, _)
public class Solution2007 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int tc = 1; tc <= n; tc++) {
            String str = sc.next();
            for (int i = 1; i <= 10; i++) {
                if (str.substring(0, i).equals(str.substring(i, i + i))) {
                    System.out.printf("#%d %d\n", tc, i);
                    break;
                }
            }
        }

    }
}

