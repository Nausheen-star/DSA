class Solution {

    public boolean palindrome(String s, int i, int j){

        while(i< j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        

        int maxLen  = Integer.MIN_VALUE;
    int start=0, end=0;
         for (int i = 0; i < n; i++) {

            for (int j = i; j < n; j++) {

                if (palindrome(s, i, j)) {

                    if (j-i+1> maxLen) {
                        
                        maxLen = j-i+1;
                        start = i;
                        end=j;
                    }
                }
            }
        }

        return s.substring(start, end+1);
    }
}