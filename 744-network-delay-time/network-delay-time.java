class Solution {

    static class Pair{

        int node;
        int dist;
        Pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {

          ArrayList<ArrayList<Pair>> graph = new ArrayList<>();

        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }

          for(int[] edge: times){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            graph.get(u).add(new Pair(v,w));
          }

          int[] dist = new int[n+1];
          Arrays.fill(dist, Integer.MAX_VALUE);

          dist[k] =0;

          PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b)-> a.dist- b.dist
          );

          pq.offer(new Pair(k,0));

          while(!pq.isEmpty()){

         Pair current=   pq.poll();
         int node = current.node;
         int currdist = current.dist;

         for(Pair neighbor: graph.get(node)){

            int nextNode = neighbor.node;
            int weight = neighbor.dist;

            if(currdist + weight < dist[nextNode]){
                dist[nextNode] = currdist + weight;
                  pq.offer(
                            new Pair(nextNode,
                                     dist[nextNode]));
            }
         }
          }

          int maxTime = 0;

        for (int i = 1; i <= n; i++) {

            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
        
    }
}