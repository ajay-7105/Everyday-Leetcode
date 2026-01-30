class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1) return intervals;

        //Sort by start
        Arrays.sort(intervals , (a,b) -> Integer.compare(a[0],b[0]));

        List<int[]> merged = new ArrayList<>();

        //Start with first first interval
        int[] current = intervals[0];
        merged.add(current);
        for(int i =1;i<intervals.length;i++){
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];

            if(current[1] >= nextStart){
                current[1] = Math.max(current[1],nextEnd);
            }else{
                current = intervals[i];
                merged.add(current);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}