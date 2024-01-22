package programmers.p148653;

public class Solution {
    public int solution(int storey) {
        int answer = 0;
        int count = 1;
        while (storey > 0) {
            double compare = storey % Math.pow(10, count);
            double num = Math.pow(10, count-1);
            double up = compare / num;
            //System.out.println("storey = " + storey + ", compare = " + compare + ", num = " + num + ", up = " + up + ", cc : " + (int)(storey / Math.pow(10, count) % Math.pow(10, count)) % 10);
            if ((int)(storey / Math.pow(10, count) % Math.pow(10, count)) % 10 >= 5 && up >= 5) {
                answer += (Math.pow(10, count) - (compare)) / num;
                storey += Math.pow(10, count) - (compare);
            } else if (compare < 6 * num) {
                answer += compare / num;
                storey -= compare;
            } else {
                answer += (Math.pow(10, count) - (compare)) / num;
                storey += Math.pow(10, count) - (compare);
            }
            count++;
            //System.out.println("answer = " + answer);
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(555));  //14
        System.out.println(sol.solution(65));   //9
        System.out.println(sol.solution(55));   //10
        System.out.println(sol.solution(56));   //9
        System.out.println(sol.solution(85));   //7
        System.out.println(sol.solution(45));   //9
        System.out.println(sol.solution(7));   //4
        System.out.println(sol.solution(2554)); //16
        System.out.println(sol.solution(545)); //14
        System.out.println(sol.solution(95)); //6
        System.out.println(sol.solution(14145)); //15
    }
}