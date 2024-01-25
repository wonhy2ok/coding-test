package programmers.p12951;
public class Solution {
    public String solution(String s) {
        String answer = "";
        char[] arrText = s.toCharArray();
        boolean space = false;
        if (arrText[0] >= 'a' && arrText[0] <= 'z') {
            answer += (char) (arrText[0] - 32);
        } else answer += (char) (arrText[0]);
        for (int i=1; i<arrText.length; i++) {
            if (arrText[i] == ' ') {
                answer += arrText[i];
                space = true;
                continue;
            }
            if (arrText[i] >= 'A' && arrText[i] <= 'Z') {
                arrText[i] = (char) (arrText[i] + 32);
            }
            if (space) {
                if (arrText[i] >= 'a' && arrText[i] <= 'z') {
                    arrText[i] = (char) (arrText[i] - 32);
                }
                space = false;
            }
            answer += arrText[i];
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("for the last week"));
    }
}
