package com.kmarutyan.interview.dp;

/**
 * Created by apple on 8/19/17.
 */
public class Edge {
    private int fromNodeIndex;
    private int toNodeIndex;
    private int length;

    public  Edge(int fromNodeIndex, int toNodeIndex, int length){
        this.fromNodeIndex = fromNodeIndex;
        this.toNodeIndex = toNodeIndex;
        this.length = length;
    }

    public int getToNodeIndex(){
        return toNodeIndex;
    }
    public int getFromNodeIndex(){
        return fromNodeIndex;

    }
    public int getLength(){
     return length;
    }

    public int getNeighbourIndex(int nodeIndex){
        if (nodeIndex == fromNodeIndex){
                return toNodeIndex;
        }
        else if (nodeIndex == toNodeIndex){
            return fromNodeIndex;
        }
        else {
            throw new RuntimeException("Illegal Edge Index" + nodeIndex);
        }
    }
}

