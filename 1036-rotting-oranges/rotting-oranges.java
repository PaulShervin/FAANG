class Solution {
    public int orangesRotting(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int[][] visited=grid;
        Queue<int[]> queue=new LinkedList<>();
        int count_fresh_orange=0;
        for(int i_itr=0;i_itr<row;i_itr++)
        {
            for(int j_itr=0;j_itr<col;j_itr++)
            {
                if(visited[i_itr][j_itr]==2)
                {
                    queue.offer(new int[]{i_itr,j_itr});
                }
                if(visited[i_itr][j_itr]==1)
                {
                    count_fresh_orange++;
                }
            }
        }
        if(count_fresh_orange==0)
        {
            return 0;
        }
        if(queue.isEmpty())
        {
            return -1;
        }

        int minutes=-1;
        int[][] direction={{1,0},{-1,0},{0,-1},{0,1}};
        while(!queue.isEmpty())
        {
            int size=queue.size();
            while(size-- >0)
            {
                int[] cell=queue.poll();
                int axis_one=cell[0];
                int axis_two=cell[1];
                for(int[] dir:direction)
                {
                    int i_itr=axis_one+dir[0];
                    int j_itr=axis_two+dir[1];
                    if(i_itr>=0 && i_itr<row && j_itr>=0 && j_itr<col && visited[i_itr][j_itr]==1)
                    {
                        visited[i_itr][j_itr]=2;
                        count_fresh_orange--;
                        queue.offer(new int[]{i_itr,j_itr});
                    }
                }   
            }
            minutes++;
        }
        if(count_fresh_orange==0)
        {
            return minutes;
        }
        return -1;
    }
}