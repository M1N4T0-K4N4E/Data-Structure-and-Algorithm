package solutions.pack12b_SSP;

import java.util.Arrays;

public class Dijkstra_660859 extends Dijkstra{

    public Dijkstra_660859(int[][] adjMatrix, int source) {
        super(adjMatrix, source);
    }

    //Task 1 imeplement the findSSP method using Dijkstra's algorithm
    public void findSSP() {
        int sizeRow = adjMatrix.length;
        int sizeCol = adjMatrix[0].length;
        for (int i = 0; i < distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        // source to other (row)
        int current = source;
        visted[current] = true;
        current++;
        for (int count = 0; count < sizeRow - 1; count++) {
            // where current can go
            for (int i = 0; i < sizeCol; i++) {
                if (current == i || adjMatrix[current][i] == -1) continue;
                if (distance[i] < adjMatrix[current][i]) continue;
                distance[i] = adjMatrix[current][i];
                previous[i] = current;
            }
            current = (current + 1) % sizeRow;
        }
        System.out.println(Arrays.toString(distance) + "\n" + Arrays.toString(previous));
    }

    //Task 2 implement the printAllSSP method to print the shortest path 
    //from the source to all other nodes
    public void printAllSSP(){
        d
    }
    
}
