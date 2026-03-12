class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> map=new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        Deque<Character> stack=new ArrayDeque<>();
        for(char ch:s.toCharArray())
        {
            if(map.containsKey(ch))
            {
                if(!stack.isEmpty() && stack.peek()==map.get(ch))
                {
                   stack.pop(); 
                }
                else{
                    return false;
                }
            }
            else{
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}