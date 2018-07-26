package com.kmarutyan.interview.data_structures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class DagLoop {
    static class Graph{
        private final int V;
        private final List<List<Integer>> adj;

        public Graph(int V)
        {
            this.V = V;
            adj = new ArrayList<>(V);

            for (int i = 0; i < V; i++)
                adj.add(new LinkedList<>());
        }

        private void addEdge(int source, int dest) {
            adj.get(source).add(dest);
        }

        public boolean isCyclic(){
            boolean [] visited = new boolean[V];
            boolean [] recr = new boolean[V];

            Arrays.fill(visited, false);
            Arrays.fill(recr, false);

            for (int i: IntStream.range(0,V).toArray()){
                if (isCyclic( i, visited, recr))
                    return true;
            }
            return false;
        }

        public boolean isCyclic( int v, boolean [] visited, boolean []recr){
            // mark current node as visited
            if(visited[v] || recr[v])
                return true;
            visited[v] = true;
            recr[v] = true;

            List<Integer> children = adj.get(v);
            for(int c: children){
                if(isCyclic(c, visited, recr))
                    return true;
            }
            recr[v] = false;

            return false;
        }
    }




    public static void main(String... args){
        Graph graph = new DagLoop.Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        if(graph.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't "
                    + "contain cycle");
    }
}
