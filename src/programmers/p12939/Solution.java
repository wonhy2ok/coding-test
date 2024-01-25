package programmers.p12939;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public String solution(String s) {
        String answer = "";
        List<Integer> arrNum = Arrays.stream(s.split(" ")).map(num -> Integer.parseInt(num)).collect(Collectors.toList());
        arrNum.sort((a, b) -> a-b);
        answer = arrNum.get(0) + " " + arrNum.get(arrNum.size() - 1);
        return answer;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("-1 -2 -3 -4"));
    }
}
