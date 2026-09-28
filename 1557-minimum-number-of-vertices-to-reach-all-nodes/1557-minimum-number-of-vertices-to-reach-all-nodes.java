class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
       int ind[]=new int[n];
       for(List<Integer>edge:edges){
        int from=edge.get(0);
        int to=edge.get(1);
        ind[to]++;
       }
       List<Integer>ans=new ArrayList<>();
       for(int i=0;i<n;i++){
        if(ind[i]==0){
            ans.add(i);
        }
       }return ans;
    }
}