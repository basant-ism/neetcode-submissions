class Solution {
    HashSet<String> opSet = new HashSet<>(Set.of("+","-","*","/"));
    boolean isOp(String str) {
        return opSet.contains(str);
    }
    int val(int op1,int op2, String op) {
        if(op.equals("+")) return op1+op2;
        if(op.equals("-")) return op1-op2;
        if(op.equals("*")) return op1*op2;
        if(op.equals("/")) return op1/op2;

        return 0;
    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = tokens.length;
        for(String token : tokens){
            if(isOp(token)) {
                int op2 = stack.pop();
                int op1 = stack.pop();
                stack.push(val(op1,op2,token));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();  
    }
}
