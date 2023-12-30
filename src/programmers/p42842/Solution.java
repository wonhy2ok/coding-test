package programmers.p42842;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int ab = brown + yellow;
        int aPlusB = (brown+4) / 2;
        
        for (int i=1 ; i<=aPlusB ; i++) {
            if (i * (aPlusB-i) == ab) {
                answer[0] = aPlusB-i;
                answer[1] = i;
                break;
            }
        }
        
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(10,2));
    }
}
