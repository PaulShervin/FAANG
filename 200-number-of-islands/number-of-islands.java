class Solution {
    public int numIslands(char[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int island=0;
        for(int i_itr=0;i_itr<row;i_itr++)
        {
            for(int j_itr=0;j_itr<col;j_itr++)
            {
                if(grid[i_itr][j_itr]=='1')
                {
                    dfs(grid,i_itr,j_itr);
                    island++;
                }
            }
        }
        return island;
    }
    public static void dfs(char[][] grid,int i_itr,int j_itr)
    {
        if(i_itr<0 || j_itr<0 || i_itr>=grid.length || j_itr>=grid[0].length || '0'-grid[i_itr][j_itr]==0)
        {
            return;
        }
        grid[i_itr][j_itr]='0';
        dfs(grid,i_itr+1,j_itr);
        dfs(grid,i_itr-1,j_itr);
        dfs(grid,i_itr,j_itr-1);
        dfs(grid,i_itr,j_itr+1);
    }
}