class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length ;
        int [] timeVisited = new int [n];
        boolean[] visited = new boolean [n];
        int maxCycle = -1;

        for (int i = 0 ; i < n ;i++){
            if (visited[i]) continue;
            int curr = i ; 
            int startTime = 1;
            int startNode = i;
            int step = 1 ; 
            int startStep = step ; 
            Map <Integer , Integer > path = new HashMap<>();

            while(curr != -1 ){
                if (path.containsKey(curr)){
                    maxCycle = Math.max(maxCycle , step - path.get(curr));
                    break;
                }
                if (visited[curr]) break;
                visited[curr] = true;
                path.put(curr,step);
                curr = edges[curr];
                step++;
            }
        }
        return maxCycle;
    }
}