class Solution {
    int ans = Integer.MAX_VALUE;
    void dfs(List<List<int[]>> adj, int curr, boolean[] visited) {
        visited[curr] = true;
        for (int[] edge : adj.get(curr)) {
            int next = edge[0];
            int weight = edge[1];
            ans = Math.min(ans, weight);
            if (!visited[next]) {
                dfs(adj, next, visited);
            }
        }
    }
    public int minScore(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i=0;i<roads.length;i++) {
            int u = roads[i][0]-1;
            int v = roads[i][1]-1;
            int w = roads[i][2];
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }
        boolean[] visited = new boolean[n];
        dfs(adj,0,visited);
        return ans;
    }
}