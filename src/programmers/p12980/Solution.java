package programmers.p12980;

import java.util.*;

public class Solution {

    public int solution(int n) {
        int answer = 0;

        while (n > 0) {
            if (n%2==0) {
                // 짝수
                n/=2;
            } else {
                n--;
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(5000));
    }
}
