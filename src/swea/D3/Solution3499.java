package swea.D3;

import java.util.LinkedList;
import java.util.Scanner;

// 퍼펙트 셔플
// 풀이: N이 짝수,홀수일 때를 나누고 배열을 두개로 나눠서 입력값을 저장한다. 이를 번갈아가며 출력해줌

public class Solution3499 {

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            LinkedList<String> list = new LinkedList<>();
            if (N % 2 == 1) {   // 홀수일 때
                String[] arrL = new String[N / 2];
                String mid = "";
                String[] arrR = new String[N / 2];

                for (int i = 0; i < arrL.length; i++) {
                    arrL[i] = sc.next();
                }
                mid = sc.next();
                for (int i = 0; i < arrR.length; i++) {
                    arrR[i] = sc.next();
                }

                for (int i = 0; i < N / 2; i++) {
                    list.add(arrL[i]);
                    list.add(arrR[i]);
                }
                list.add(mid);
            } else {
                String[] arrL = new String[N / 2];
                String[] arrR = new String[N / 2];

                for (int i = 0; i < arrL.length; i++) {
                    arrL[i] = sc.next();
                }
                for (int i = 0; i < arrR.length; i++) {
                    arrR[i] = sc.next();
                }

                for (int i = 0; i < N / 2; i++) {
                    list.add(arrL[i]);
                    list.add(arrR[i]);
                }
            }
            System.out.print("#" + tc + " ");
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
    }
}

/** queue 를 두개 만들어서, 나눠 저장하고 번갈아가며 poll을 해줌.
 * class Solution
 * {
 * 	public static void main(String args[]) throws Exception
 *        {
 * 		Scanner sc = new Scanner(System.in);
 *         StringBuffer sb = new StringBuffer();
 *
 *
 *         int T = Integer.parseInt(sc.nextLine());
 *         for(int tc=1; tc<=T; tc++){
 *             sb.append("#").append(tc).append(" ");
 *             int N = Integer.parseInt(sc.nextLine());
 *
 *             String input[] = sc.nextLine().split(" ");
 *             Queue<String> queue1 = new LinkedList<>();
 *             Queue<String> queue2 = new LinkedList<>();
 *
 *             int index = 0;
 *             if(N % 2 == 0){
 *                 index = N/2;
 *             }else{
 *                 index = N/2+1;
 *             }
 *             for(int i=0; i<index; i++){
 *                 queue1.add(input[i]);
 *             }
 *
 *             for(int i=index; i<N; i++){
 *                 queue2.add(input[i]);
 *             }
 *
 *             //셔플
 *             for(int i=0; i<N; i+=2){
 *                 while(!queue1.isEmpty()){
 *                     sb.append(queue1.poll()).append(" ");
 *                     break;
 *                 }
 *                 while(!queue2.isEmpty()){
 *                     sb.append(queue2.poll()).append(" ");
 *                     break;
 *                 }
 *             }
 *             sb.append("\n");
 *
 *         }
 *         System.out.println(sb);
 *    }
 * }
 */