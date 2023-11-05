package swea.D3;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// [S/W 문제해결 기본] 8일차 - 암호문1
// 풀이: LinkedList<Integer> 써서 add 사용. x번째 다음에 수를 입력하려면, .add(x, 숫자) 로 하면 됨.
// BufferedReader -> br.readLine() / StringTokenizer -> st.nextToken() 사용하는 법도 익혀두기
public class Solution1228 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            LinkedList<Integer> list = new LinkedList<Integer>();
            int N = sc.nextInt();   // 암호문 개수

            for (int i = 0; i < N; i++) {   // 암호문 넣기
                list.add(sc.nextInt());
            }

            int M = sc.nextInt();
            for (int i = 0; i < M; i++) {
                char command = sc.next().charAt(0);
                if (command == 'I') {
                    int x = sc.nextInt();   //  x의 위치 바로 다음에 y개의 숫자를 삽입
                    int y = sc.nextInt();
                    for (int j = 0; j < y; j++) {
                        list.add(x + j, sc.nextInt());  // x++ 로 해도 무방
                    }
                }
            }
            System.out.print("#" + tc + " ");
            for (int i = 0; i < 10; i++) {
                System.out.print(list.get(i));
            }
        }
    }

}

/**
 * public class Solution_1228 {
 *
 * 	public static void main(String[] args) throws NumberFormatException, IOException {
 *
 *
 * 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *
 * 		for(int t=1;t<=10;t++) {
 * 			LinkedList<Integer> list = new LinkedList<>();
 * 			int N = Integer.parseInt(br.readLine()); //원본암호문 길이
 * 			StringTokenizer st = new StringTokenizer(br.readLine());
 * 			for(int i = 0;i<N;i++) {
 * 				list.add(Integer.parseInt(st.nextToken()));
 *                        }
 * 			N = Integer.parseInt(br.readLine()); // 명령어 개수
 * 			st = new StringTokenizer(br.readLine());
 * 			for(int i = 0;i<N;i++) {
 * 				if(st.nextToken().equals("I")) {
 *
 * 					int x = Integer.parseInt(st.nextToken()); //x위치 다음
 * 					int y = Integer.parseInt(st.nextToken());
 * 					for(int j = 0;j<y;j++) {
 * 						list.add(x,Integer.parseInt(st.nextToken()));
 * 						x++;
 *                    }
 *                }
 *
 *            }
 * 			System.out.print("#"+t+" ");
 * 			for(int i=0;i<10;i++) {
 * 				System.out.print(list.get(i)+" ");
 *            }
 * 			System.out.println();	* 		}
 *
 * 	}
 *
 * }
 */