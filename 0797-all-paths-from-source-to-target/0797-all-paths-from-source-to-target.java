class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer>curr=new ArrayList<>();
        dfs(ans,curr,graph,0);
        return ans;
    }
    public void dfs(List<List<Integer>>ans,List<Integer>curr,int[][]graph,int v){
        curr.add(v);
        if(v==graph.length-1) ans.add(new ArrayList<>(curr));
        else{
            for (int i: graph[v]){
                dfs(ans,curr,graph,i);
            }
        }
        curr.remove(curr.size()-1);
    }
}