package programmers.p12924;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        int start = 0;
        int end = 0;
        while(start <= n && end <= n) {
            int sum = 0;
            for(int i=start; i<=end; i++) {
                sum += i;
            }
            if (sum < n) {
                end++;
            } else if (sum > n) {
                start++;
            } else {
                answer++;
                end++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(15));
    }
}
