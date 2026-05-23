public class Main {
    public static void main(String[] args) {
        System.out.println("=== Graph Traversal and Representation System ===");

        Experiment experiment = new Experiment();
        experiment.runMultipleTests();
        experiment.printResults();

        System.out.println("\n=== BONUS: Dijkstra's Algorithm ===");

        Graph g = new Graph();
        for (int i = 0; i < 6; i++) g.addVertex(new Vertex(i));

        g.addEdge(0, 1, 4);
        g.addEdge(0, 2, 1);
        g.addEdge(2, 1, 2);
        g.addEdge(1, 3, 1);
        g.addEdge(2, 4, 5);
        g.addEdge(3, 4, 3);
        g.addEdge(3, 5, 2);
        g.addEdge(4, 5, 1);

        System.out.println();
        g.printGraph();
        System.out.println();
        g.dijkstra(0);
    }
}