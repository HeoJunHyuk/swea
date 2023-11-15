package swea.D3;

import java.util.*;

// 진용이네 주차타워 -> 시뮬레이션(구현)
// 풀이: queue랑 우선순위 queue를 사용 -> 대기 차량을 위한 waitQueue, 주차권을 발급해주는 emptyQueue(우선 순위 큐), parkingArr에 각 자동차별 주차 공간 입력
// 풀이가 아래 더 있는데, 나는 아래의 풀이들이 더 맞는듯함.

public class Solution9280 {

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        for(int tc = 1; tc <= TC; tc++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            HashMap<Integer, Integer> spaceMap = new HashMap<>();   // 주차 공간마다의 요금
            HashMap<Integer, Integer> carMap = new HashMap<>();     // 차들의 무게
            int[] parkingArr = new int[M + 1];  // 자동차가 주차한 주차 공간 번호
            int totalProfit = 0;

            for (int i = 0; i < N; i++) {
                spaceMap.put(i + 1, sc.nextInt());
            }
            for (int i = 0; i < M; i++) {
                carMap.put(i + 1, sc.nextInt());
            }

            Queue<Integer> waitQueue = new LinkedList<>();  // 주차 공간 없을 때, 대기 차량
            PriorityQueue<Integer> emptyQueue = new PriorityQueue<>();  // 빈 주차 공간을 가지는 큐

            for (int i = 1; i <= N; i++) {
                emptyQueue.add(i);
            }
            for (int i = 0; i < 2 * M; i++) {
                int idx = sc.nextInt();
                if (idx > 0) {  //출입
                    if (emptyQueue.isEmpty()) { // 주차 공간이 꽉 참.
                        waitQueue.add(idx);
                    } else {
                        int parkingIdx = emptyQueue.poll(); // emptyQueue에서 빈 자리의 주차권을 제공
                        parkingArr[idx] = parkingIdx;   // parkingArr에 어떤 차(idx)가 몇번 주차권(parkingIdx)을 받았는지 기입
                    }
                } else {    // 퇴장
                    int carIdx = idx * -1;
                    int parkingIdx = parkingArr[carIdx];    // 자동차가 주차한 주차 공간이 몇번째인지
                    totalProfit += carMap.get(carIdx) * spaceMap.get(parkingIdx);
                    emptyQueue.add(parkingIdx); // parkingIdx 주차권 반납

                    if (!waitQueue.isEmpty()) { // 대기 차량이 있다면
                        parkingIdx = emptyQueue.poll();
                        carIdx = waitQueue.poll();
                        parkingArr[carIdx] = parkingIdx;
                    }
                }
            }

            System.out.println("#" + tc + " " + totalProfit);
        }
    }
}

/** 배열을 더 사용(나와 비슷한 풀이), 대기열 우선 고려
 * public class Solution9280_1 {
 *     public static void main(String[] args) throws IOException {
 *         System.setIn(new FileInputStream("res/swea/9280.txt"));
 *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *
 *         int T = Integer.parseInt(br.readLine().trim());
 *
 *         for (int test_case = 1; test_case <= T; test_case++) {
 *             int ans = 0;
 * //            입력
 *             StringTokenizer st = new StringTokenizer(br.readLine().trim());
 *             int n = Integer.parseInt(st.nextToken());
 *             int m = Integer.parseInt(st.nextToken());
 *             int[] R = new int[n];
 *             int[] park = new int[n];
 *             int[] W = new int[m + 1];
 *             LinkedList<Integer> move = new LinkedList<>();
 *             LinkedList<Integer> wait = new LinkedList<>();
 *
 *             for (int i = 0; i < n; i++) {
 *                 R[i] = Integer.parseInt(br.readLine());
 *             }
 *
 *             for (int i = 1; i <= m; i++) {
 *                 W[i] = Integer.parseInt(br.readLine());
 *             }
 *
 *             for (int i = 0; i < 2 * m; i++) {
 *                 move.add(Integer.parseInt(br.readLine()));
 *             }
 *
 *             int now = 0;
 *             int front = 0;
 *             while (!move.isEmpty()) {
 *                 now = move.poll();
 *                 if (now > 0) {    //차 대는 명령
 * //                    대기열 우선고려
 *                     wait.add(now);
 *                     front = wait.peek();
 * //                    차 대는거 시작
 *                     for (int i = 0; i < n; i++) {
 *                         if (park[i] == 0) { // 주차장이 비어있으면
 *                             park[i] = front; // 차 대고
 *                             ans += R[i] * W[front]; // 주차비용
 *                             wait.poll();
 *                             break;
 *                         }
 *                     }
 * //                    주차장 셋 다 차있는 경우
 * //                    계속 대기
 * //                    if(!parked) {
 * ////                    대기중- 아무것도 안함
 * //                    }
 *                 }
 *                 else {    //차 빼는 명령
 *                     now = -now;    //음수 양수로 바꿈
 *                     for (int i = 0; i < n; i++) {
 *                         if (park[i] == now) { // 주차장에 그 차를 찾음
 *                             park[i] = 0; // 차 빼고
 *                             if(!wait.isEmpty()) {    //대기중인 차 있으면 바로 거기에 주차시킴
 *                                 now = wait.poll();
 *                                 park[i] = now;
 *                                 ans += R[i] * W[now];
 *                             }
 *                             break;
 *                         }
 *                     }
 *                 }
 *             }
 *
 *             System.out.println("#" + test_case + " " + ans);
 *} // end test_case
         *}// end main
         *}
 */

/** 나와 비슷한 풀이 - 배열들이랑 일반 진입 큐(q), 대기열 큐(rq) 사용 / 더 나한테 맞는 풀이
 * import java.util.*;
 *
 * public class Solution {
 * 	public static void main(String[] args) {
 * 		Scanner sc = new Scanner(System.in);
 * 		int test = sc.nextInt();
 *
 * 		for(int t = 1; t <= test; t++) {
 * 			int n = sc.nextInt();
 * 			int m = sc.nextInt();
 * 			int sum = 0;
 * 			int[] r = new int[n];
 * 			int[] w = new int[m];
 * 			int[] p = new int[n];
 *
 * 			Queue <Integer> q = new LinkedList();
 * 			Queue <Integer> rq = new LinkedList();
 *
 * 			for(int i = 0; i < n; i++) {
 * 				r[i] = sc.nextInt();
 *                        }
 *
 * 			for(int i = 0; i < m; i++) {
 * 				w[i] = sc.nextInt();
 *            }
 *
 * 			for(int i = 0; i < 2 * m; i++) {
 * 				int tmp = sc.nextInt();
 * 				q.add(tmp);
 *            }
 *
 * 			int cnt = 0;    // 주차 자리가 꽉 찼는지 아닌지 확인하는 용도
 *
 * 			while(!q.isEmpty()) {
 * 				int num;
 * 				if(cnt < n && !rq.isEmpty()) {  // 대기열이 있을 때
 * 					num = rq.poll();
 * 					for(int i = 0; i < n; i++) {
 * 						if(p[i] == 0) {
 * 							p[i] = num;
 * 							sum += w[num - 1] * r[i];
 * 							cnt++;
 * 							break;
 *                        }
 *                    }
 *                }else {
 * 					num = q.poll();
 * 					if(num > 0) {
 * 						if(cnt < n) {
 * 							for(int i = 0; i < n; i++) {
 * 								if(p[i] == 0) {
 * 									p[i] = num;
 * 									sum += w[num - 1] * r[i];
 * 									cnt++;
 * 									break;
 *                                }
 *                            }
 *                        }
 * 						else {
 * 							rq.add(num);
 *                        }
 *                    }
 * 					else {
 * 						for(int i = 0; i < n; i++) {
 * 							if(p[i] == -1 * num) {
 * 								p[i] = 0;
 * 								cnt--;
 *                            }
 *                        }
 *                    }
 *                }
 *            }
 * 			System.out.println("#" + t + " " + sum);* 		}
 * 	}
 * }
 */