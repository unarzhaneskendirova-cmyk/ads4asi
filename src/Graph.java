import java.util.*;

public class Graph {
    private Map<Integer, Vertex> vertices;
    private Map<Integer, List<int[]>> adjacencyList;

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

    public void addEdge(int from, int to, int weight) {
        if (!adjacencyList.containsKey(from) || !adjacencyList.containsKey(to)) {
            System.out.println("Error: vertex not found (" + from + ", " + to + ")");
            return;
        }
        adjacencyList.get(from).add(new int[]{to, weight});
        adjacencyList.get(to).add(new int[]{from, weight});
    }

    public void printGraph() {
        System.out.println("Graph Adjacency List:");
        List<Integer> sortedIds = new ArrayList<>(adjacencyList.keySet());
        Collections.sort(sortedIds);
        for (int id : sortedIds) {
            System.out.print("  V" + id + " -> ");
            List<int[]> neighbors = adjacencyList.get(id);
            if (neighbors.isEmpty()) {
                System.out.println("(no neighbors)");
            } else {
                StringJoiner sj = new StringJoiner(", ");
                for (int[] n : neighbors) sj.add("V" + n[0] + "(w=" + n[1] + ")");
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
            for (int[] neighbor : adjacencyList.get(current)) {
                if (!visited.contains(neighbor[0])) {
                    visited.add(neighbor[0]);
                    queue.add(neighbor[0]);
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
            for (int[] neighbor : adjacencyList.get(current)) {
                if (!visited.contains(neighbor[0])) {
                    stack.push(neighbor[0]);
                }
            }
        }
        System.out.println();
    }

    public void dijkstra(int start) {
        if (!adjacencyList.containsKey(start)) {
            System.out.println("Dijkstra: start vertex V" + start + " not found.");
            return;
        }

        List<Integer> ids = new ArrayList<>(vertices.keySet());
        Collections.sort(ids);

        Map<Integer, Integer> dist = new HashMap<>();
        Map<Integer, Boolean> visited = new HashMap<>();

        for (int id : ids) {
            dist.put(id, Integer.MAX_VALUE);
            visited.put(id, false);
        }
        dist.put(start, 0);

        for (int i = 0; i < ids.size(); i++) {
            int u = -1;
            for (int id : ids) {
                if (!visited.get(id)) {
                    if (u == -1 || dist.get(id) < dist.get(u)) u = id;
                }
            }

            if (u == -1 || dist.get(u) == Integer.MAX_VALUE) break;
            visited.put(u, true);

            for (int[] edge : adjacencyList.get(u)) {
                int neighbor = edge[0];
                int weight = edge[1];
                if (!visited.get(neighbor) && dist.get(u) + weight < dist.get(neighbor)) {
                    dist.put(neighbor, dist.get(u) + weight);
                }
            }
        }

        System.out.println("Dijkstra shortest distances from V" + start + ":");
        for (int id : ids) {
            String distStr = (dist.get(id) == Integer.MAX_VALUE) ? "unreachable" : String.valueOf(dist.get(id));
            System.out.println("  V" + start + " -> V" + id + " : " + distStr);
        }
    }

    public int getVertexCount() {
        return vertices.size();
    }

    public Map<Integer, List<int[]>> getAdjacencyList() {
        return adjacencyList;
    }
}