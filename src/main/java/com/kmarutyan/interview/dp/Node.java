package com.kmarutyan.interview.dp;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by apple on 8/19/17.
 */
public class Node {
    private int distanceFromSource = Integer.MAX_VALUE;
    private boolean visited;
    private List<Edge> edges = new ArrayList();

    public int getDistanceFromSource(){
        return distanceFromSource;
    }
    public void setDistanceFromSource(int distance){
        this.distanceFromSource = distance;
    }
    public boolean isVisited(){
        return visited;
    }
    public void setVisited(boolean visited){
        this.visited  = visited;
    }

    public List<Edge> getEdges(){
        return edges;
    }
    public void setEdges(List<Edge> edges){
        this.edges = edges;
    }
}



