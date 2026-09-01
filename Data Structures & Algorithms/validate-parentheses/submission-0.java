class Solution {
     boolean isOpen(char ch) {
        return ch == '(' || ch == '{' || ch == '[';
    }
    boolean isProperClose(char stackCh, char ch) {
        return (stackCh == '(' && ch == ')')
             || (stackCh == '{' && ch == '}') 
             || (stackCh == '[' && ch == ']');
    }
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int n = s.length();
        for(int i=0;i<n;i++) {
            char ch = s.charAt(i);
            if(isOpen(ch)) {
                stack.push(ch);
            } else {
                if(stack.isEmpty() || !isProperClose(stack.peek(), ch)) return false;
                stack.pop();
            }

             
            
        }
        return stack.isEmpty();
    }
}
