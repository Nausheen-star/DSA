class Solution {

    public int earliestFinishTime(int[] landStart, int[] landDur,
                                  int[] waterStart, int[] waterDur) {

        // O(n + m)
        int bestLandFinish = Integer.MAX_VALUE;
        int bestWaterFinish = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < landStart.length; i++) {
            bestLandFinish = Math.min(bestLandFinish, landStart[i] + landDur[i]);
        }

        for (int i = 0; i < waterStart.length; i++) {
            int finishTime = Math.max(bestLandFinish, waterStart[i]) + waterDur[i];
            ans = Math.min(ans, finishTime);
        }

        for (int i = 0; i < waterStart.length; i++) {
            bestWaterFinish = Math.min(bestWaterFinish, waterStart[i] + waterDur[i]);
        }

        for (int i = 0; i < landStart.length; i++) {
            int finishTime = Math.max(bestWaterFinish, landStart[i]) + landDur[i];
            ans = Math.min(ans, finishTime);
        }

        return ans;
    }
}