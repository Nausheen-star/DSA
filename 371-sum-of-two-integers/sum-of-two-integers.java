// class Solution {
//     public int getSum(int a, int b) {
        
//         if(b==0){
//             return a;
//         }
//         return getSum(a^b, (a&b) << 1);
//     }
// }

class Solution {
    public int getSum(int a, int b) {

        while (b != 0) {

            int carry = (a & b) << 1;

            a = a ^ b;

            b = carry;
        }

        return a;
    }
}