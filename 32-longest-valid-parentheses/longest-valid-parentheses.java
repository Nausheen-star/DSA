class Solution {
    public int longestValidParentheses(String s) {
        
        if(s.length() ==0) return 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1); // base index
        int max =0;

        for(int i=0; i<s.length(); i++){

            if(s.charAt(i) == '('){
                st.push(i);
            }else{
                st.pop();
                if(st.isEmpty()){
                    st.push(i); // new base
                }else{
                max= Math.max(max, i-st.peek());
                }
            }
        }
        return max;
    }
}