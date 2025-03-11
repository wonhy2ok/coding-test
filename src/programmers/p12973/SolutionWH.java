package programmers.p12973;

import java.util.*;

public class SolutionWH {
    public int solution(String s)
    {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        if (stack.isEmpty()) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("baabaa"));
        System.out.println(sol.solution("cdcd"));
    }
}
