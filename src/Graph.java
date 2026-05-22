import java.util.*;

public class Graph {
    private Map<Integer, Vertex> vertices;
    private Map<Integer, List<Integer>> adjacencyList;

    public Graph() {
        vertices = new HashMap<>();
        adjacencyList = new HashMap<>();
    }

    public void addVertex(Vertex v) {
        if (!vertices.containsKey(v.getId())) {
            vertices.put(v.getId(), v);
            adjacencyList.put(v.getId(), new ArrayList<>());
        }
    }

    public void addEdge(int from, int to) {
        if (!adjacencyList.containsKey(from) || !adjacencyList.containsKey(to)) {
            System.out.println("Error: vertex not found (" + from + ", " + to + ")");
            return;
        }
        adjacencyList.get(from).add(to);
        adjacencyList.get(to).add(from);
    }

    public void printGraph() {
        System.out.println("Graph Adjacency List:");
        List<Integer> sortedIds = new ArrayList<>(adjacencyList.keySet());
        Collections.sort(sortedIds);
        for (int id : sortedIds) {
            System.out.print("  V" + id + " -> ");
            List<Integer> neighbors = adjacencyList.get(id);
            if (neighbors.isEmpty()) {
                System.out.println("(no neighbors)");
            } else {
                StringJoiner sj = new StringJoiner(", ");
                for (int n : neighbors) sj.add("V" + n);
                System.out.println(sj);
            }
        }
    }

    public void bfs(int start) {
        if (!adjacencyList.containsKey(start)) {
            System.out.println("BFS: start vertex V" + start + " not found.");
            return;
        }
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        visited.add(start);
        queue.add(start);
        System.out.print("BFS from V" + start + ": ");
        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print("V" + current + " ");
            for (int neighbor : adjacencyList.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public void dfs(int start) {
        if (!adjacencyList.containsKey(start)) {
            System.out.println("DFS: start vertex V" + start + " not found.");
            return;
        }
        Set<Integer> visited = new HashSet<>();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(start);
        System.out.print("DFS from V" + start + ": ");
        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (visited.contains(current)) continue;
            visited.add(current);
            System.out.print("V" + current + " ");
            for (int neighbor : adjacencyList.get(current)) {
                if (!visited.contains(neighbor)) {
                    stack.push(neighbor);
                }
            }
        }
        System.out.println();
    }

    public int getVertexCount() {
        return vertices.size();
    }

    public Map<Integer, List<Integer>> getAdjacencyList() {
        return adjacencyList;
    }
}