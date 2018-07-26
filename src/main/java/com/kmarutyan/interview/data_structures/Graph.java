package com.kmarutyan.interview.data_structures;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by apple on 7/28/18.
 */
public class Graph {

    private int V;
    private LinkedList<Integer> adj[];
    //private Queue<Integer>adj[];

    Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v,int w)
    {
        adj[v].add(w);
    }


    // print bfs traversal in order
    public void BFS(int s){

        // initialize visitation array
        boolean [] visited = new boolean[V];

        //create a queue for BSF
        Queue<Integer> queue = new LinkedList<>();

        //mark current node as visited
        visited[s] = true;
        queue.offer(s);

        // start BSF
        while(!queue.isEmpty()){
            // poll head of the queue and print the node valueValal head =
            int head = queue.poll();
            System.out.println(  String.format("Current element: %d", head));

            // visit neighbours
            List<Integer> neighbours = adj[head];
            for(Integer cur: neighbours){
                if(!visited[cur]){
                    visited[cur] = true;
                    queue.add(cur);
                }
            }
        }
    }

    void DFS(int s) {
        // initialize visitation array
        boolean[] visited = new boolean[V];

        //create a stack for dfs
        Stack<Integer> stack = new Stack<>();

        //mark current node as visited
        visited[s] = true;
        stack.push(s);
        while(!stack.isEmpty()){
            // print current value
            int tail = stack.pop();
            System.out.println("Visited: " + tail);

            // move on to neighbours
            List<Integer> adjs =  adj[tail];
            for(int current: adjs){
                // if not yet visited
                if(!visited[current]){
                    stack.push(current);
                    visited[current] = true;
                }
            }
        }
    }


    public static void main(String [] args){

        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        //g.BFS(2);
        g.DFS(2);
    }
}
