class Solution {
        public String removeDuplicates(String s, int k) {
            int[] count=new int[s.length()];
            StringBuilder str=new StringBuilder();
            for(char ch:s.toCharArray())
            {
                str.append(ch);
                int last=str.length()-1;
                if(last>0 && str.charAt(last)==str.charAt(last-1))
                {
                    count[last]=count[last-1]+1;
                }
                else{
                    count[last]=1;
                }
                if(count[last]==k)
                {
                    str.delete(str.length()-k,str.length());
                }
            }
        return str.toString();
    }
}