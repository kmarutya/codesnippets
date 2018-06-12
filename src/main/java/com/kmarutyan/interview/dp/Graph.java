package com.kmarutyan.interview.dp;


import java.util.List;
import java.util.ArrayList;
/**
 * Created by apple on 8/19/17.
 */
public class Graph {

    private Node [] nodes;
    private int noOfNodes;
    private Edge[] edges;
    private int noOfEdges;


    public Graph(Edge [] edges){
        this.edges = edges;
        this.noOfNodes = calculateNoOfNodes(edges);
        this.nodes =  new Node[this.noOfNodes];

        for (int i = 0; i < this.noOfNodes; i++){
            this.nodes[i] = new Node();
        }

        // add all the edges to the nodes, each edge added to two nodes (to and from)
        this.noOfEdges = edges.length;
        for(int edgeToAdd = 0; edgeToAdd < this.noOfEdges; edgeToAdd++){
            Edge curEdge = edges[edgeToAdd];
            nodes[curEdge.getFromNodeIndex()].getEdges().add(curEdge);
            nodes[curEdge.getToNodeIndex()].getEdges().add(curEdge);
        }


    }


    public Node [] getNodes(){
        return nodes;
    }
    public int getNoOfNodes(){
        return noOfNodes;
    }
    public Edge[] getEdges(){
        return edges;
    }
    public int getNoOfEdges(){
        return noOfEdges;
    }

    private int calculateNoOfNodes(Edge[] edges){
        int noOfNodes = 0;
        for (Edge e: edges){
            if(e.getToNodeIndex() > noOfNodes){
                noOfNodes = e.getToNodeIndex();
            }
            if(e.getFromNodeIndex() > noOfNodes){
                noOfNodes = e.getFromNodeIndex();
            }
        }
        noOfNodes++;
        return noOfNodes;
    }


    public void calculateShortestDistances(){
        //node 0 as source

        nodes[0].setDistanceFromSource(0);

        int nextNodeInd = 0;

        //visit every node
        for(int i = 0; i < nodes.length; i++){
            Node nextNode = nodes[nextNodeInd];
            //loop around edges of current node
            List<Edge> currentNodeEdges = nextNode.getEdges();
            for(int joinedEdge = 0; joinedEdge < currentNodeEdges.size(); joinedEdge++){
                int neighbourIndex = currentNodeEdges.get(joinedEdge).getNeighbourIndex(nextNodeInd);
                Node curNeighbourNode = nodes[neighbourIndex];

                // only if not already visited
                if(!curNeighbourNode.isVisited()){
                    int tenative =  nodes[nextNodeInd].getDistanceFromSource() + currentNodeEdges.get(joinedEdge).getLength();
                    if(tenative < curNeighbourNode.getDistanceFromSource()){
                        curNeighbourNode.setDistanceFromSource(tenative);
                    }
                }
            }
            // all neighbours checked, hence we can mark node as visited now
            nextNode.setVisited(true);

            // next node must be one with shortest distance
            nextNodeInd = getShortestDistanced();
        }

    }

    private int getShortestDistanced(){
        int storedNodeIndex = 0;
        int storedDist = Integer.MAX_VALUE;

        for (int i = 0; i < nodes.length; i++){
            int currentDist = nodes[i].getDistanceFromSource();
            if(!nodes[i].isVisited() && currentDist < storedDist ){
                storedDist = currentDist;
                storedNodeIndex  = i;
            }
        }

        return storedNodeIndex;
    }

    public void printResult(){
        String output =  String.format("Number of nodes %d \n", noOfNodes);
        output +=  String.format("Number of edges %s \n", noOfEdges);

        for(int i = 0; i < nodes.length; i++){
            output +=  String.format("The shortest distance from node 0 to node %d is %d \n", i, nodes[i].getDistanceFromSource());
        }
        System.out.println(output);

    }


    public static void main(String []args){
        Edge[] edges = {
            new Edge(0, 2, 1),
            new Edge(0, 3, 4),
            new Edge(0, 4, 2),
            new Edge(0, 1, 3),
            new Edge(1, 3, 2),
            new Edge(1, 4, 3),
            new Edge(1, 5, 1),
            new Edge(2, 4, 1),
            new Edge(3, 5, 4),
            new Edge(4, 5, 2),
            new Edge(4, 6, 7),
            new Edge(4, 7, 2),
            new Edge(5, 6, 4),
            new Edge(6, 7, 5)
    };
         Graph g =  new Graph(edges);
         g.calculateShortestDistances();
         g.printResult();
    }

//}
}



