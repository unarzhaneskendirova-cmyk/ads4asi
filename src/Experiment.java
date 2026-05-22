import java.util.*;

public class Experiment {
    private List<long[]> results;
    private List<String> labels;

    public Experiment() {
        results = new ArrayList<>();
        labels = new ArrayList<>();
    }

    public void runTraversals(Graph g, String label, boolean printTraversal) {
        System.out.println("\n--- " + label + " ---");
        System.out.println("Vertices: " + g.getVertexCount());
        int startVertex = 0;

        if (printTraversal) System.out.print("  ");
        long bfsStart = System.nanoTime();
        g.bfs(startVertex);
        long bfsEnd = System.nanoTime();

        if (printTraversal) System.out.print("  ");
        long dfsStart = System.nanoTime();
        g.dfs(startVertex);
        long dfsEnd = System.nanoTime();

        long bfsTime = bfsEnd - bfsStart;
        long dfsTime = dfsEnd - dfsStart;
        results.add(new long[]{bfsTime, dfsTime});
        labels.add(label);

        System.out.printf("  BFS time: %,d ns%n", bfsTime);
        System.out.printf("  DFS time: %,d ns%n", dfsTime);
    }

    public void runMultipleTests() {
        int[] sizes = {10, 30, 100};
        String[] sizeLabels = {
                "Small (10 vertices)",
                "Medium (30 vertices)",
                "Large (100 vertices)"
        };
        Random rand = new Random(42);

        for (int i = 0; i < sizes.length; i++) {
            int n = sizes[i];
            Graph g = new Graph();

            for (int v = 0; v < n; v++) g.addVertex(new Vertex(v));

            for (int v = 0; v < n; v++) {
                int edgesForVertex = 2 + rand.nextInt(3);
                for (int e = 0; e < edgesForVertex; e++) {
                    int neighbor = rand.nextInt(n);
                    if (neighbor != v) g.addEdge(v, neighbor);
                }
            }

            if (n == 10) {
                System.out.println("\n=== Graph Structure ===");
                g.printGraph();
            }

            runTraversals(g, sizeLabels[i], n == 10);
        }
    }

    public void printResults() {
        System.out.println("\n╔══════════════════════════════════════════════════════════╗");
        System.out.println("║              PERFORMANCE RESULTS SUMMARY                 ║");
        System.out.println("╠══════════════════════════════════════════════════════════╣");
        System.out.printf("║  %-22s  %14s  %14s  ║%n", "Graph Size", "BFS Time (ns)", "DFS Time (ns)");
        System.out.println("╠══════════════════════════════════════════════════════════╣");

        long totalBfs = 0, totalDfs = 0;
        for (int i = 0; i < results.size(); i++) {
            long bfsTime = results.get(i)[0];
            long dfsTime = results.get(i)[1];
            totalBfs += bfsTime;
            totalDfs += dfsTime;
            System.out.printf("║  %-22s  %,14d  %,14d  ║%n", labels.get(i), bfsTime, dfsTime);
        }

        String faster = (totalBfs < totalDfs) ? "BFS" : "DFS";
        System.out.println("╠══════════════════════════════════════════════════════════╣");
        System.out.printf("║  %-22s  %,14d  %,14d  ║%n", "TOTAL", totalBfs, totalDfs);
        System.out.println("╠══════════════════════════════════════════════════════════╣");
        System.out.printf("║  Overall faster algorithm: %-30s║%n", faster);
        System.out.println("╚══════════════════════════════════════════════════════════╝");
    }
}