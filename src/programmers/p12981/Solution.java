package programmers.p12981;

import java.util.List;
import java.util.ArrayList;

public class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        List<String> usedWordList = new ArrayList<String>();
        for (int i=0 ; i<words.length ; i++) {
            if (i==0) {
                usedWordList.add(words[i]);
                continue;
            } else {
                if (usedWordList.indexOf(words[i]) > -1) {
                    answer[0] = (i%n)+1;
                    answer[1] = (i/n)+1;
                    return answer;
                } else {
                    String prevWord = usedWordList.get(i-1);
                    if (!prevWord.substring(prevWord.length()-1, prevWord.length()).equals(words[i].substring(0, 1))) {
                        answer[0] = (i%n)+1;
                        answer[1] = (i/n)+1;
                        return answer;   
                    }
                }
                usedWordList.add(words[i]);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] answer = sol.solution(2, new String[] {"hello", "one", "even", "never", "now", "world", "draw"});
        System.out.println(answer[0] + "," + answer[1]);
    }
}
