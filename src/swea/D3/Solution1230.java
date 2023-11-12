package swea.D3;

import java.util.LinkedList;
import java.util.Scanner;

// [S/W 문제해결 기본] 8일차 - 암호문3
// 풀이: LinkedList 써서 add, remove 진행
// 입력에 띄어쓰기가 되어 있으면 따로따로 sc.next, sc.nextInt 다 가능. ( 파싱할 필요 없다는 말 )

public class Solution1230 {

    static LinkedList<Integer> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int tc = 1 ; tc <= 10 ; tc++) {
            int N = sc.nextInt();
            list = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                list.add(sc.nextInt());
            }
            int M = sc.nextInt();

            for (int i = 0; i < M; i++) {
                String str = sc.next();
                if (str.charAt(0) == 'I') {
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    for (int j = x; j < x + y; j++) {
                        list.add(j, sc.nextInt());
                    }

                } else if (str.charAt(0) == 'D') {
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    for (int j = 0; j < y; j++) {
                        list.remove(x);
                    }
                } else if (str.charAt(0) == 'A') {
                    int y = sc.nextInt();
                    for (int j = 0; j < y; j++) {
                        list.add(sc.nextInt());
                    }
                }
            }
            System.out.print("#" + tc + " ");
            for (int i = 0; i < 10; i++) {  // 출력 10개까지임 문제 잘 읽자.
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
    }

}

