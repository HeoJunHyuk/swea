package swea.D3;

import java.util.Scanner;

// 규영이와 인영이의 카드게임
// 풀이: 인영이가 가질 수 있는 카드 9개를 rem_card[]에 넣어놓고, game()를 활용해서 인영이의 카드(arrB[])에 rem_card를 하나씩 넣음. arrB가 다 차면 arrA랑 비교
// dfs를 활용한 문제. 인영이가 가질 수 있는 카드들은 check[1~18]을 활용해서 구함

public class Solution6808 {

    static int[] arrA, arrB;
    static int[] rem_card;
    static boolean[] visited;
    static int win;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            arrA = new int[9];
            arrB = new int[9];
            rem_card = new int[9];
            visited = new boolean[9];
            win = 0;
            boolean[] check = new boolean[19];  // 1 ~ 18
            check[0] = true;

            for (int i = 0; i < 9; i++) {
                arrA[i] = sc.nextInt();
                check[arrA[i]] = true;
            }
            int idx = 0;
            for (int i = 1; i <= 18; i++) {
                if (!check[i]) {
                    rem_card[idx++] = i;
                }
            }
            game(0);

            System.out.println("#" + tc + " " + win + " " + (362880 - win));

        }
    }

    private static void game(int cnt) {
        if (cnt == 9) { // 인영이의 카드가 다 차면 규영이의 카드와 비교
            int sumA = 0;
            int sumB = 0;
            for (int i = 0; i < 9; i++) {
                if (arrA[i] > arrB[i]) {
                    sumA += arrA[i] + arrB[i];
                } else sumB += arrA[i] + arrB[i];
            }
            if (sumA > sumB) win++;
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (visited[i]) continue;
            arrB[cnt] = rem_card[i];    // 인영이가 가질 수 있는 카드들을 조합해서 인영이의 카드 패를 만들어줌
            visited[i] = true;
            game(cnt + 1);
            visited[i] = false;
        }
    }

}
