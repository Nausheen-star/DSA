class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s.length() == 0){
            return 0;
        }

        int i=0;
        int j=1;

        HashSet<Character> set = new HashSet<>();

        int maxLen =1;
        set.add(s.charAt(0));

        while( j < s.length() && i<=j){
            while(j < s.length() && !set.contains(s.charAt(j))){
               set.add(s.charAt(j));
               j++;
            }

            if((j-i) > maxLen){
                maxLen = (j-i);
            }
            
            set.remove(s.charAt(i));
          i++;
        }
        return maxLen;
    }
}