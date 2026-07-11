// T.C : O(V + E)
// S.C: O(V + E)
class Solution {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;

    static int vertics;
    static int degreeSum;

    static void dfs(int node){
        visited[node] = true;
        vertics++;
        degreeSum += graph.get(node).size();
        for(int n : graph.get(node)){
            if(!visited[n]){
                dfs(n);
            }
        }
    }

public static int countCompleteComponents(int n, int[][]edges){
     
    graph = new ArrayList<>();
    for(int i=0; i<n; i++){
        graph.add(new ArrayList<>());
    }

    for(int[] edge: edges){
        int u = edge[0];
        int v = edge[1];

        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    visited = new boolean[n];
    int answer =0;
    for(int i=0; i<n; i++){
       if(!visited[i]){
         vertics=0;
         degreeSum =0;
         dfs(i);

         int actualEdge = degreeSum/2;
         int expectedEdges = vertics*(vertics-1)/2;
         if(actualEdge== expectedEdges ){
            answer++;
         }
       }
    }
    return answer;
}
}