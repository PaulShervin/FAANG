class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> answer=new ArrayList<>();

        dfs(0,0,"",n,answer);
        return answer;
    }
    public void dfs(int open_bracket,int close_bracket,String str,int n,List<String> answer)
    {
        if(open_bracket==close_bracket && str.length()==n*2)
        {
            answer.add(str);
        }
        if(open_bracket<n)
        {
            dfs(open_bracket+1,close_bracket,str+"(",n,answer);
        }
        if(close_bracket<open_bracket){
            dfs(open_bracket,close_bracket+1,str+")",n,answer);
        }
    }
}