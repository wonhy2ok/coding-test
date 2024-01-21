package programmers.p12979;

import java.util.*;

public class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int range = w*2+1;

        int currIndex = 1;
        for (int i=0 ; i<stations.length ; i++) {
            if (currIndex >= stations[i]) {
                currIndex = stations[i] + w + 1;
                continue;
            }
            int blocks = stations[i]-w-currIndex; // 칸수
            if (blocks <= 0) {
                currIndex = stations[i] + w + 1;
                continue;
            }

            if (blocks % range == 0) {
                answer = answer + (blocks / range);
            } else {
                answer = answer + (blocks / range) + 1;
            }

            currIndex = stations[i] + w + 1;
        }
        if (currIndex <= n) {
            int blocks = n - currIndex + 1; // 칸수
            if (blocks % (range) == 0) {
                answer = answer + (blocks / range);
            } else {
                answer = answer + (blocks / range) + 1;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(11, new int[] {4, 11}, 1)); // 3
        System.out.println(sol.solution(16, new int[] {9}, 2));     // 3
        System.out.println(sol.solution(5, new int[] {2}, 1));      // 1
        System.out.println(sol.solution(5, new int[] {1}, 1));      // 1
        System.out.println(sol.solution(10, new int[] {1,2,3}, 1)); // 2
        System.out.println(sol.solution(21, new int[] {1}, 20)); // 0
        System.out.println(sol.solution(13, new int[] {3, 7, 11}, 1)); // 4
        System.out.println(sol.solution(5, new int[] {3}, 2)); // 0
        System.out.println(sol.solution(6, new int[] {3}, 2)); // 1
        System.out.println(sol.solution(16, new int[] {1, 16}, 2)); // 2
        System.out.println(sol.solution(6, new int[] {4}, 2)); // 1
        System.out.println(sol.solution(11, new int[] {1, 4}, 1)); // 2
        System.out.println(sol.solution(11, new int[] {1, 5}, 1)); // 3
        System.out.println(sol.solution(5, new int[] {1, 2, 3, 4, 5}, 1)); // 0
        System.out.println(sol.solution(200000000, new int[] {100000000}, 5)); // 18181818
        System.out.println(sol.solution(1, new int[] {1}, 1));
    }
}