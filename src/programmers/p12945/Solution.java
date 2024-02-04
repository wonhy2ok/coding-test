package programmers.p12945;

import java.util.*;

public class Solution {

    public int solution(int n) {
        int answer = 0;
        int[] sumArr = new int[n+1];

        for (int i=0 ; i<=n ; i++) {
            int value;
            if (i == 0) { value = 0; }
            else if (i == 1) { value = 1; }
            else {
                value = sumArr[i-1] + sumArr[i-2];
            }
            sumArr[i] = value%1234567;
        }

        answer = sumArr[n];

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(5000));
        //System.out.println(sol.solution(5));
    }
}
