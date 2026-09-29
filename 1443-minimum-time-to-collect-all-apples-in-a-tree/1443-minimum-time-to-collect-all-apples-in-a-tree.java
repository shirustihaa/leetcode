class Solution { 
    int sum = 0; 

    boolean dfs(int curr, int par, List<List<Integer>> adj, List<Boolean> hasApple) { 
        
        boolean hasAppleInSubtree = hasApple.get(curr); 
        
        for (int child : adj.get(curr)) { 
            
            if (child == par) 
                continue; 
            
            boolean childHasApple = dfs(child, curr, adj, hasApple); 
            
            if (childHasApple) { 
                sum += 2; 
                hasAppleInSubtree = true; 
            } 
        }
        
        return hasAppleInSubtree; 
    } 
 
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) { 
        
        List<List<Integer>> adj = new ArrayList<>(); 
        
        for (int i = 0; i < n; i++) { 
            adj.add(new ArrayList<>()); 
        } 
        
        for (int[] edge : edges) { 
            int u = edge[0]; 
            int v = edge[1]; 
            
            adj.get(u).add(v); 
            adj.get(v).add(u); 
        }
        
        dfs(0, -1, adj, hasApple); 
        
        return sum; 
    } 
}