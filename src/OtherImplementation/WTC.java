package OtherImplementation;

import java.lang.*;

public class WTC {

    final static int V = 5; //Vertices

    public void transitiveClosure(int graph[][]) {

        int reach[][] = new int[V][V];
        int i, j, k;

        for (i = 0; i < V; i++)
            for (j = 0; j < V; j++)
                reach[i][j] = graph[i][j];

            for (k = 0; k < V; k++) {

                for (i = 0; i < V; i++) {

                    for (j = 0; j < V; j++) {

                        reach[i][j] = (reach[i][j] != 0) || ((reach[i][k] != 0) && (reach[k][j] !=0 )) ? 1 : 0; //Cierre
                    }
                }
            }
            printSolution(reach);
    }

    public void printSolution(int reach[][]) {

        System.out.println("En la siguiente matriz es el cierre transitivo"+ " del gráfico dado");

        for (int i = 0; i < V; i++) {

            for (int j = 0; j < V; j++) {
                System.out.print(reach[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main (String[] args) {

        int graph[][] = new int[][] {
                {1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0},
                {1, 0, 1, 1, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 1, 1, 1}};

        WTC wtc = new WTC();
        wtc.transitiveClosure(graph);
    }
}

        /*	     10
            (0)------->(3)
            |		  /|\
          5 |		   |
            |		   | 1
           \|/	   	   |
            (1)------->(2)
			       3       */

/*
{0, 1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {1, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0}
 */