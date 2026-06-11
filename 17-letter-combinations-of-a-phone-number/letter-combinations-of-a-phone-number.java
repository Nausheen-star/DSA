class Solution {

     List<String> ans = new ArrayList<>();

     public void solve(int idx, String digit, StringBuilder temp, HashMap<Character, String> map){

     if(idx >= digit.length()){
         ans.add(temp.toString());
         return;
     }

     char ch = digit.charAt(idx);
     String s = map.get(ch);
     
     for(int i=0; i<s.length(); i++){
        // Do
        temp.append(s.charAt(i));
        solve(idx+1, digit, temp, map);
         // Undo (Backtrack)
         temp.deleteCharAt(temp.length()-1);

     }
     }
    public List<String> letterCombinations(String digits) {
   
   if(digits.length() ==0){
    return new ArrayList<>();
   }

   HashMap<Character, String> map = new HashMap<>();

   map.put('2', "abc");
   map.put('3', "def");
   map.put('4', "ghi");
   map.put('5', "jkl");
   map.put('6', "mno");
   map.put('7', "pqrs");
   map.put('8', "tuv");
   map.put('9', "wxyz");
    solve(0, digits, new StringBuilder(), map);
return ans;
    }
}