import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {

        int n = buildings.length;   // 2차원 배열 행의 길이

        ArrayList<Integer>[][] skylineList = new ArrayList[n][2];

        Integer [][] skyline = new Integer [n][2];

        // 스카이라인 시작 L
        skyline[0][0] = buildings[0][0];          
        skyline[0][1] = buildings[0][1];          // 스카이라인 시작 H
        skyline[n-1][0] = buildings[n-1][2];      // 스카이라인 끝 R
        skyline[n-1][1] = 0;                      // 스카이라인 끝 H

        for (int i=1; i<n; i++) {

            int xGap = (buildings[i][2] - buildings[i][0]) 
                        + (buildings[i+1][2] - buildings[i+1][0])
                        - buildings[i+1][2];

            int yGap = buildings[i][2] - buildings[i+1][2];
            
            // 스카이라인 x 좌표 셋팅
            if (xGap == 0) {
                skyline[i][0] = buildings[i][0];
                skyline[i+1][0] = buildings[i][0];
            }
            if (xGap < 0) {
                skyline[i][0] = buildings[i][0];
                skyline[i+1][0] = buildings[i][2];
                skyline[i+2][0] = buildings[i+1][0];
            }
            if (xGap > 0) {
                skyline[i][0] = buildings[i][0]; 
                skyline[i+1][0] = buildings[i][2] = buildings[i+1][0];
            }

            // 스카이라인 y 좌표 셋팅
            if (yGap != 0) {
                skyline[i][1] = buildings[i][2];
                skyline[i+1][1] = buildings[i][2];
                skyline[i+2][1] = buildings[i+1][2];
                skyline[i+3][1] = buildings[i+1][2];
            }  else {
                skyline[i][1] = buildings[i][2];
            }
        }

        skylineList = Arrays.asList(skyline);
        
        return skylineList;
    }
}