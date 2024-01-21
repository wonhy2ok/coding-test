package programmers.p12911;

import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;

        int i=1;
        while (true) {
            if (getDigitCount(n) == getDigitCount(n+i)) {
                answer = n+i;
                break;
            }
            i++;
        }

        return answer;
    }

    public int getDigitCount(int n) {
        int result = 0;
        while (n != 1) {
            if (n%2 == 1) { result++; }
            n /= 2;
        }
        result++;
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(15));
    }
}
