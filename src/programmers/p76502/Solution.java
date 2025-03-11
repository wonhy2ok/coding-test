package programmers.p76502;
import java.util.*;

public class Solution {
    public int solution(String s) {
        // 닫는 괄호가 보이면 여는 괄호를 찾도록 하는 용도
        HashMap<Character, Character> map = new HashMap<>(){{
            put(']','[');
            put('}','{');
            put(')','(');
        }};

        int answer = 0;
        int strSize = s.length();
        s += s; // 문자열 2개를 붙여서 반복문으로 구간별로 사용
        A:for (int i=0; i<strSize; i++) {
            // ArrayDeque 는 스택, 큐 모두 사용 가능. Stack보다 성능이 뛰어나고, Stack은 비추천함.
            ArrayDeque<Character> stack = new ArrayDeque<>();
            // i + strSize : 이동한 만큼의 문자열을 읽도록 함
            for (int j=i; j<i + strSize; j++) {
                char charAt = s.charAt(j);
                if (!map.containsKey(charAt)) {
                    stack.push(charAt);
                } else {
                    if (stack.isEmpty() || stack.pop() != map.get(charAt)) {
                        continue A;
                    }
                }
            }
            // 마지막에 스택이 비어있지 않으면 괄호 부족
            if (stack.isEmpty()) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("[](){}"));
        System.out.println(sol.solution("}]()[{"));
        System.out.println(sol.solution("[)(]"));
        System.out.println(sol.solution("}}}"));
    }
}
