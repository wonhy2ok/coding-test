package programmers.p12927;

import java.util.*;

public class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) {
            queue.add(work);
        }
        while (n > 0) {
            int minus = 0;
            int first = queue.poll();
            int second = queue.poll();
            if (n - (first - second + 1) >= 0) {
                minus = first - second + 1;
            } else {
                minus = n;
            }
            queue.add(first - minus);
            queue.add(second);
            n -= minus;
        }
        while (!queue.isEmpty()) {
            int time = queue.poll();
            if (time < 0) continue;
            answer += Math.pow(time, 2);
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(15, new int[] {5, 21, 21, 31}));
        //System.out.println(sol.solution(3, new int[] {1, 1}));
    }
}
