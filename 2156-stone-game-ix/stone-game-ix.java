class Solution {
    public boolean stoneGameIX(int[] stones) {
        int count[] = new int[3];

        for(int s : stones){
            count[s%3]++;
        }
        if(count[0] % 2==0){
           return count[1] >=1 && count[2]>=1;
        }
        return Math.abs(count[1]-count[2]) >=3;
    }
}