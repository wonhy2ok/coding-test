package programmers.p70129;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];

        String prevString;
        String aftrString;
        while (!s.equals("1")) {
            prevString = s;
            answer[0]++;
            aftrString = s.replaceAll("0", "");
            answer[1] = answer[1] + (prevString.length() - aftrString.length());
            s = getBinaryString(aftrString.length());
        }

        return answer;
    }

    public String getBinaryString(int length) {
        String binaryString = "1";
        while (length != 1) {
            if (length%2 == 1) { binaryString += "1"; }
            else { binaryString += "0"; }
            length /= 2;
        }
        return binaryString;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("110010101001")[0] + ", " + sol.solution("110010101001")[1]);
    }
}