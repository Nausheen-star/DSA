// class Solution {
//    int mod= 1_000_000_007;
//       int N;
//      int M;

//     public int solve(int i, int s, boolean incresing){
//         if(i== N){
//             return 1;
//         }

//    int result =0;
//         if(incresing){

//             for(int next =s+1; next<=M; next++){
//              result = (result + solve(i+1, next, false)) % mod;
//             }
//         }else{

//             for(int next =1; next<s; next++){
//              result = (result + solve(i+1, next, true)) % mod;
//             }
//         }
//         return (int) result;
//     }
//     public int zigZagArrays(int n, int l, int r) {
        
//            N =n;
//            M = r-l+1;

//         int result=0;

//         for(int s=1; s<=M; s++){
//             // put value in 0 index
//             // incresing
//             result = (result + solve(1, s, true)) % mod;

//             // decresing 
//              result = (result + solve(1, s,false)) % mod;
//         }

//         return (int) result;
//     }
// }

class Solution {
    int mod = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        long[][] T = new long[m][m];
        for (int j = 0; j < m; j++) {
            for (int i = m - j; i < m; i++) {
                T[i][j] = 1; 
            }
        }
        long[][] powT = matPow(T, n - 1, m);

        long total = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                total = (total + powT[i][j]) % mod;
            }
        }

        return (int) (total * 2 % mod);
    }
    long[][] matPow(long[][] base, long e, int m) {
        long[][] res = new long[m][m];
        for (int i = 0; i < m; i++) res[i][i] = 1; 
        while (e > 0) {
            if (e % 2 == 1) res = mul(res, base);
            base = mul(base, base);
            e >>= 1;
        }
        return res;
    }

    long[][] mul(long[][] A, long[][] B) {
        int m = A.length;
        long[][] C = new long[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                long sum = 0;
                for (int k = 0; k < m; k++) {
                    sum = (sum + A[i][k] * B[k][j]) % mod;
                }
                C[i][j] = sum;
            }
        }
        return C;
    }
}