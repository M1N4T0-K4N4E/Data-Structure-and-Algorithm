package solutions.pack12b_SSP;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Dijkstra {

    int[][] adjMatrix;
    int[] previous, distance;
    boolean[] visted;
    int source;

    public Dijkstra(int[][] adjMatrix, int source) {
        this.adjMatrix = adjMatrix;
        this.source = source;
        previous = new int[adjMatrix.length];
        distance = new int[adjMatrix.length];
        visted = new boolean[adjMatrix.length];
    }
    
    //Task 1 imeplement the findSSP method using Dijkstra's algorithm
    public void findSSP() {
        
    }

    //Task 2 implement the printAllSSP method to print the shortest path 
    //from the source to all other nodes
    public void printAllSSP(){

    }

}