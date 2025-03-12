package programmers.p42584;

import java.util.*;

public class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int size = prices.length;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(0);  //최초 가격 삽입
        for (int i=1; i<size; i++) {
            // 1. 가격을 비교해서 증가했다면 push
            if (prices[i] >= prices[stack.peek()]) {
                stack.push(i);
            } else {
                // 2. 가격을 비교해서 떨어졌다면 pop하고 해당 자리부터 아래까지 확인
                while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                    int top = stack.pop();
                    answer[top] = i - top;
                }
                // 3. 비교 후 다시 증가 값이라면 현재 인덱스 push
                stack.push(i);
            }
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            answer[top] = size - 1 - top;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[] {1, 2, 3, 2, 3}));
    }
}
