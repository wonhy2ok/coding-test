package programmers.p77884;

class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for (int i=left; i<=right; i++) {
            int count = 0;
            for (int j=1; j<=i/2; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            count++;
            if (count % 2 == 0) {
                answer+=i;
            } else {
                answer-=i;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(13,17));
    }
}
