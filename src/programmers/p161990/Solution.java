package programmers.p161990;

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];

        int lux = 51;
        int luy = 51;
        int rdx = -1;
        int rdy = -1;
        
        for (int i=0 ; i<wallpaper.length ; i++) {
            for (int j=0 ; j<wallpaper[i].length() ; j++) {
                if (String.valueOf(wallpaper[i].charAt(j)).equals("#")) {
                    System.out.println(i + "," + j);
                    if (i < luy) { luy = i; }
                    if (i > rdy) { rdy = i; }
                    if (j < lux) { lux = j; }
                    if (j > rdx) { rdx = j; }
                }
            }
        }

        answer[1] = lux;
        answer[0] = luy;
        answer[3] = rdx + 1;
        answer[2] = rdy + 1;
        
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] answer = sol.solution(new String[] {".#...", "..#..", "...#."});
        for (int i=0 ; i<answer.length ; i++) {
            System.out.print(answer[i] + " ");
        }
        System.out.println();
        answer = sol.solution(new String[] {"..........", ".....#....", "......##..", "...##.....", "....#....."});
        for (int i=0 ; i<answer.length ; i++) {
            System.out.print(answer[i] + " ");
        }
        System.out.println();
    }
}