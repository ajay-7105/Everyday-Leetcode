class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n <= 1) return intervals;

        //Sort by start
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[][] result = new int[n][2];
        int idx=0;
        //Start with first first interval
        int[] current = intervals[0];
        result[idx] = current;
        for(int i =1;i<n;i++){
         // Compare the end of our current result with the start of the next
            if (result[idx][1] >= intervals[i][0]) {
                // Merge directly inside the result array
                result[idx][1] = Math.max(result[idx][1], intervals[i][1]);
            } else {
                // Move to the next slot in the result array
                result[++idx] = intervals[i];
            }
        }
        return Arrays.copyOf(result , idx+1);
    }
}