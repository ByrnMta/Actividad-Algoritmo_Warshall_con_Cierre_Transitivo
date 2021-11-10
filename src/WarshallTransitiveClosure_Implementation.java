import java.util.Scanner;

public class WarshallTransitiveClosure_Implementation {

    private int V;
    private boolean[][] TC;

    // Método que contiene la función de realizar el cierre transitivo
    public void transitiveClosure(int[][] graph) {

        this.V = graph.length;
        TC = new boolean[V][V];

        for (int i = 0; i < V; i++) {

            for (int j = 0; j < V; j++)
                if (graph[i][j] != 0)

                    TC[i][j] = true;

            TC[i][i] = true;
        }

        for (int i = 0; i < V; i++) {

            for (int j = 0; j < V; j++) {
                if (TC[j][i])

                    for (int k = 0; k < V; k++)
                        if (TC[j][i] && TC[i][k])
                            TC[j][k] = true;
                }
            }
        }

        // Método que contiene la función para hacer el print de la matriz con cierre transitivo
        public void printTC() {

        System.out.println("\nTransitive closure :\n");
        System.out.print(" ");

        for (int v = 0; v < V; v++)
            System.out.print("   " + v );
            System.out.println();

        for (int v = 0; v < V; v++) {
            System.out.print(v +" ");

            for (int w = 0; w < V; w++) {
                if (TC[v][w])
                    System.out.print("  1 ");

                else
                    System.out.print("  0 ");
            }
            System.out.println();
        }
    }


    // Método principal
    public static void main (String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Warshall Algorithm with transitive closure\n");

        WarshallTransitiveClosure_Implementation wtci = new WarshallTransitiveClosure_Implementation();

        // Ingreso de número de vertices
        System.out.println("Enter number of vertices\n");
        int V = scan.nextInt();

        // Ingreso y obtención del grafo o del la matriz adyacente que lo contiene
        System.out.println("\nEnter matrix\n");
        int[][] graph = new int[V][V];

        for (int i = 0; i < V; i++)

            for (int j = 0; j < V; j++)

                graph[i][j] = scan.nextInt();

            wtci.transitiveClosure(graph);
            wtci.printTC();
    }
}
