package swea.D3;

import java.io.IOException;
import java.util.*;

// [S/W 문제해결 기본] 7일차 - 암호생성기
// 풀이: Queue<Integer> queue = new LinkedList<>() 를 써서 queue.poll() , queue.offer() 함수를 사용
public class Solution1225 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            int T = sc.nextInt();   // tc 번호
            Queue<Integer> queue = new LinkedList<>();

            for (int i = 0; i < 8; i++) {
                queue.add(sc.nextInt());
            }

            int value = 1;
            while (value != 0) {
                for (int i = 1; i < 6; i++) {
                    value = queue.poll();
                    value -= i;
                    if (value <= 0) {
                        value = 0;
                    }
                    queue.offer(value);
                    if (value == 0) {
                        break;
                    }
                }
            }

            System.out.print("#" + T + " ");

            for (int i = 0; i < 8; i++) {
                int a = queue.poll();
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }

}
