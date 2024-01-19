package programmers.p42628;

import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};

        List<Integer> queue = new ArrayList<Integer>();

        for (int i=0 ; i<operations.length ; i++) {
            String[] splitArr   = operations[i].split(" ");
            String operation    = splitArr[0];
            int value           = Integer.valueOf(splitArr[1]);

            if (operation.equals("I")) {
                if (queue.size() > 0) {
                    if (queue.get(0) < value) { queue.add(0, value); }
                    else if (queue.get(queue.size()-1) > value) { queue.add(value); }  
                    else { queue.add(queue.size()-1, value); }
                } else {
                    queue.add(value);
                }
            } else if (operation.equals("D")) {
                if (value == 1) {
                    if (queue.size() > 0) {
                        queue.remove(0);
                    }
                } else {
                    if (queue.size() > 0) {
                        queue.remove(queue.size()-1);
                    }
                }
            }
        }

        Collections.sort(queue);

        if (queue.size() > 0) {
            answer[0] = queue.get(queue.size()-1);
            answer[1] = queue.get(0);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new String[] {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}));
    }
}
