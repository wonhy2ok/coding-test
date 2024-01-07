package programmers.p258712;

import java.util.*;
public class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int[][] friendMatrix = new int[friends.length][friends.length];
        List<String> friendsArray = Arrays.asList(friends);
        List<String> giftsArray   = Arrays.asList(gifts);
        HashMap<String, int[]> giveAndTakeMap = new HashMap<String, int[]>();
        
        for (int i=0 ; i<giftsArray.size() ; i++) {
            String give = giftsArray.get(i).split(" ")[0];
            String take = giftsArray.get(i).split(" ")[1];
            friendMatrix[friendsArray.indexOf(give)][friendsArray.indexOf(take)]++;
            if (giveAndTakeMap.get(give) == null) {
                giveAndTakeMap.put(give, new int[]{1, 0});
            } else {
                int[] tempArr = giveAndTakeMap.get(give);
                tempArr[0]++;
            }

            if (giveAndTakeMap.get(take) == null) {
                giveAndTakeMap.put(take, new int[]{0, 1});
            } else {
                int[] tempArr = giveAndTakeMap.get(take);
                tempArr[1]++;
            }
        }
        
        int currCount = 0;
        for (int i=0 ; i<friendMatrix.length ; i++) {
            for (int j=0 ; j<friendMatrix[0].length ; j++) {
                if (i != j) {
                    if (friendMatrix[i][j] > friendMatrix[j][i]) {
                        currCount++;
                    } else if (friendMatrix[i][j] == friendMatrix[j][i]) {
                        int[] arr1 = giveAndTakeMap.get(friends[i]) == null ? new int[] {0, 0} : giveAndTakeMap.get(friends[i]);
                        int[] arr2 = giveAndTakeMap.get(friends[j]) == null ? new int[] {0, 0} : giveAndTakeMap.get(friends[j]);
                        if (arr1[0]-arr1[1] > arr2[0]-arr2[1]) {
                            currCount++;
                        }
                    }
                }
            }
            if (currCount > answer) {
                answer = currCount;
            }
            currCount = 0;
        }
        
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        //System.out.println(sol.solution(new String[]{"muzi", "ryan", "frodo", "neo"}, new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"}));
        System.out.println(sol.solution(new String[]{"joy", "brad", "alessandro", "conan", "david"}, new String[]{"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"}));
    }
}
