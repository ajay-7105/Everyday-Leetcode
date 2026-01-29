class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length ;
        int[] timeVisited = new int[n];
        int maxCycle = -1 ;
        int currentStep = 1;

        for (int i = 0;i < n;i++){
            if (timeVisited[i] > 0) continue;

            int startTime = currentStep;
            int curr = i ; 

            while(curr != -1 && timeVisited[curr] == 0){
                timeVisited[curr] = currentStep++;
                curr  = edges[curr];
            }
            if(curr != -1 && timeVisited[curr] >= startTime){
                maxCycle = Math.max(maxCycle , currentStep - timeVisited[curr]);
            }
        }
        return maxCycle;
    
    }
}