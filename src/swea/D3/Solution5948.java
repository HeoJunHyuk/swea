package swea.D3;

import java.util.*;

// 새샘이의 7-3-5 게임 **
// 풀이: dfs를 사용. set을 이용해서 중복을 제거해야함. 중복 때문에 7 Conbination 3 = 35 중에서 5번째로 큰 수라고 30번째를 구하면 안됨
// 때문에, set을 arr 또는 arrayList로 만들고 arrayList.size - 5 또는 arr.length - 5 를 구해야 함

public class Solution5948 {

    static int[] arr;
    static int sum;
    static TreeSet<Integer> set;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            arr = new int[7];
            set = new TreeSet<>();
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }

            sum = 0;
            dfs(0,0);

            // set을 정렬하는 방식 : arrayList, arr
            // Object[] objects = set.toArray(); Arrays.sort(objects);
            ArrayList<Integer> arrayList = new ArrayList<>(set);
            Collections.sort(arrayList);

            System.out.println("#" + tc + " " + arrayList.get(arrayList.size() - 5));

        }
    }
    private static void dfs(int cnt, int srt) {
        if (cnt == 3) {
            set.add(sum);
            return;
        } else {
            for (int i = srt; i < 7; i++) {
                sum += arr[i];
                dfs(cnt + 1, i + 1);
                sum -= arr[i];
            }
        }

    }

}

/**
 * public class Solution {
 *     static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *     static StringTokenizer st;
 *     static StringBuilder sb = new StringBuilder();
 *     static HashSet<Integer> sum;
 *     static int[] arr;
 *     public static void main(String[] args) throws NumberFormatException, IOException {
 *         // 테스트 케이스 수 입력
 *         int T = Integer.parseInt(br.readLine());
 *
 *         for(int tc = 1; tc <= T; tc++) {
 *             // 숫자들을 배열로 입력 받음
 *             String[] tmp = br.readLine().split(" ");
 *             arr = new int[tmp.length];
 *             for(int i = 0; i < tmp.length; i++)
 *                 arr[i] = Integer.parseInt(tmp[i]);
 *             sum= new HashSet<>();
 *             getSum(0,0,0);
 *             Object[] newArray = sum.toArray();
 *             Arrays.sort(newArray);
 *             sb.append("#" + tc + " " + newArray[sum.size()-5] + "\n");
 *         }
 *         System.out.println(sb);
 *
 *     }
 *     static void getSum(int idx, int cnt, int total) {
 *         if(idx == arr.length) {
 *             if(cnt == 3)
 *                 sum.add(total);
 *             return;
 *         }
 *         getSum(idx+1, cnt + 1, total+arr[idx]);
 *         getSum(idx+1, cnt , total);
 *     }
 * }
 */