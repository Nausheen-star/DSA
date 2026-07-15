class Solution {

    private int gcd(int a, int b){
        if(b==0) return a;

        return gcd(b, a%b);
    }
    public int gcdOfOddEvenSums(int n) {
        
        int even =0;
        int odd =0;
        int j=1;
        for(int i=0; i<n; i++){
            if(j%2 ==0){
                even++;
            }else{
                odd++;
            }
        }

        return gcd(even, odd);
    }
}