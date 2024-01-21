package programmers.p12973;

import java.util.*;

public class Solution {
    public int solution(String s) {
        int answer = 0;
        int[] stack = new int[s.length()];

        int length = s.length();
        for (int i=0 ; i<length ; i++) {
            if (answer==0) { stack[answer++] = s.charAt(i); }
            else {
                if (stack[answer-1] == s.charAt(i)) {
                    stack[--answer] = 0;
                } else {
                    stack[answer++] = s.charAt(i);
                }
            }
        }

        return answer >= 1 ? 0 : 1;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("baabaa"));
        System.out.println(sol.solution("cdcd"));
    }
}
