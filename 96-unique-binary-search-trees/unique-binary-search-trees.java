class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;

        for(int totalNodes = 2;totalNodes <=n ; totalNodes++){
            for (int root = 1; root <= totalNodes; root++){

                int left = root - 1;
                int right = totalNodes - root;

                dp[totalNodes] += dp[left]*dp[right];
            }
        }
        return dp[n];
    }
}