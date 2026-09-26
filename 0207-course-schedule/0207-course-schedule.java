class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        ArrayList<Integer> []ans=new ArrayList[numCourses];
        int[] ind=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            ans[i]=new ArrayList<>();
        }
        for(int[] p:prerequisites){
            int c=p[0];
            int preq=p[1];
            ans[preq].add(c);
            ind[c]++;
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<numCourses; i++){
            if(ind[i]==0){
                q.add(i);
            }
        }int count=0;
    while(!q.isEmpty()){
        int curr=q.poll();
        count++;
        for(int ngb:ans[curr]){
            ind[ngb]--;
            if(ind[ngb]==0){
                q.add(ngb);
            }
        }
    }return count==numCourses;
    }
}