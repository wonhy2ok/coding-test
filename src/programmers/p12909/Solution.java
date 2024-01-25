package programmers.p12909;

import java.util.*;

public class Solution {
    boolean solution(String s) {
        boolean answer = true;
        try {
            Stack<Boolean> stack = new Stack<Boolean>();
            for (int i=0; i<s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push(true);
                } else {
                    stack.pop();
                }
            }
            if (!stack.isEmpty()) {
                answer = false;
            }
        } catch (EmptyStackException e) {
            answer = false;
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("()()"));
        System.out.println(sol.solution(")()("));
    }
}
