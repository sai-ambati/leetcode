class Solution {
   public boolean isValid(String s) {
        int n=s.length();
        Stack<Character>stack=new Stack<Character>();
        char newCh;
        for(int i=0;i<n;i++)
        {
            newCh=s.charAt(i);
            switch(newCh)
            {
                case '(':
                case '[':
                case '{':
                    stack.push(newCh);
                    break;
                case ')':
                    if(stack.isEmpty()||stack.pop()!='(')
                        return false;
                    break;
                case ']':
                    if(stack.isEmpty()||stack.pop()!='[')
                        return false;
                    break;
                case '}': 
                    if(stack.isEmpty()||stack.pop()!='{')
                        return false;  
                    break;
            }
        }
        return stack.isEmpty();
    }
}
