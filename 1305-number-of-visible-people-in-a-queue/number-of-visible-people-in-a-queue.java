class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int no_of_ele=heights.length;
        int[] result=new int[no_of_ele];
        Stack<Integer> stack=new Stack<>();
        for(int itr=0;itr<no_of_ele;itr++)
        {
            while(!stack.isEmpty() && heights[stack.peek()]<=heights[itr])
            {
                result[stack.pop()]++;
            }
            if(!stack.isEmpty())
            {
                result[stack.peek()]++;
            }
            stack.add(itr);
        }
        return result;
    }
}