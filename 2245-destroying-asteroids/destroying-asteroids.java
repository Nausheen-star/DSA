//Approach-1 (Simple sorting and greedy)
//T.C : O(n log n)
//S.C : O(1)
class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);

        long totalMass = mass;

        for(int asteroid : asteroids) {
            if(totalMass < asteroid)
                return false;

            totalMass += asteroid;
        }

        return true;
    }
}
