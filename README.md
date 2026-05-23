Assignment 4 – Graph Traversal and Representation System
Unarzhan Yeskendirova
Project Overview
This project demonstrates graph representation and graph traversal algorithms using Java.
The graph is implemented using an adjacency list structure.
The program supports:
Vertex creation
Edge creation
Graph visualization
Breadth-First Search (BFS)
Depth-First Search (DFS)
Performance analysis using execution time measurements
The project compares traversal algorithms on graphs of different sizes:
Small graph (10 vertices)
Medium graph (30 vertices)
Large graph (100 vertices)
Graph Concepts
Vertex
A vertex represents a node in the graph.
Each vertex contains:
unique id

Example:

0, 1, 2, 3 ...
Edge

An edge represents a connection between two vertices.

Example:

0 → 1
1 → 4
3 → 8
Classes Description
Vertex.java

Represents a graph node.

Methods:

Constructor
getId()
toString()
Edge.java

Represents a connection between vertices.

Methods:

Constructor
Getters
toString()
Graph.java

Main graph implementation using adjacency list.

Methods:

addVertex()
addEdge()
printGraph()
bfs()
dfs()

The adjacency list stores neighbors for each vertex.

Example:

0 -> [1, 2, 3]
1 -> [4, 5]

Advantages of adjacency list:

memory efficient
fast neighbor traversal
suitable for sparse graphs
Experiment.java

Runs traversal experiments and performance analysis.

Methods:

runTraversals()
runMultipleTests()
printResults()

The class measures execution time using:

System.nanoTime()
BFS Algorithm
Breadth-First Search (BFS)

BFS visits graph nodes level by level.

It uses:

Queue data structure

Traversal example:

0 → 1 → 2 → 3 → 4 → 5 → 6 → 7 → 8 → 9
BFS Steps
Start from the root node
Add node to queue
Visit neighbors
Continue level by level
BFS Time Complexity

O(V + E)

Where:

V = number of vertices
E = number of edges
BFS Use Cases
shortest path
social networks
GPS navigation
web crawling
DFS Algorithm
Depth-First Search (DFS)

DFS visits nodes deeply before backtracking.

It uses:

Stack
or recursion

Traversal example:

0 → 3 → 8 → 7 → 2 → 6 → 9 → 1 → 5 → 4
DFS Steps
Start from root node
Visit one branch deeply
Backtrack
Continue remaining branches
DFS Time Complexity

O(V + E)

DFS Use Cases
maze solving
cycle detection
topological sorting
path finding
Experimental Results
Graph Size	BFS Time (ns)	DFS Time (ns)
(10 vertices)  1 085 083    391 750  ║
(30 vertices)   609 083     484 417  ║
║(100 vertices) 1 235 666   1 770 375 
Analysis
How does graph size affect BFS and DFS?
As graph size increases, traversal time also increases because more vertices and edges must be visited.
Which traversal was faster?
In my experiments, both algorithms showed similar performance because both have complexity O(V + E).
However, DFS was slightly faster in some cases because of simpler stack operations.
Do results match theoretical complexity?
Yes.
The experimental results generally match the expected complexity O(V + E).
How does graph structure affect traversal order?
Traversal order depends on:
edge connections
adjacency list order
graph shape
BFS explores level-by-level while DFS explores depth-first.
When is BFS preferred over DFS?
BFS is preferred when:
shortest path is needed
level traversal is required
searching nearest nodes
Limitations of DFS
DFS:
may consume deep recursion stack
does not guarantee shortest path
can be slower in very deep graphs
Screenshots
Graph Structure
<img width="1440" height="900" alt="Снимок экрана 2026-05-22 в 14 10 48" src="https://github.com/user-attachments/assets/65d4effb-846b-4a9f-9cfe-e764b89d4768" />
BFS Traversal Output
<img width="1440" height="900" alt="Снимок экрана 2026-05-22 в 14 11 24" src="https://github.com/user-attachments/assets/8f661eb7-87f9-4d25-92ce-2b198f9a1a27" />

DFS Traversal Output
<img width="1440" height="900" alt="Снимок экрана 2026-05-22 в 14 11 49" src="https://github.com/user-attachments/assets/b4a59118-3721-4c52-b875-3437caa526e1" />

Performance Results
<img width="511" height="225" alt="Снимок экрана 2026-05-22 в 14 12 20" src="https://github.com/user-attachments/assets/e72f5cba-330c-4363-90cb-305fb0472a1c" />



Reflection

During this assignment, I learned how graph traversal algorithms work and how graphs are represented using adjacency lists.

I understood the difference between BFS and DFS. BFS explores nodes level-by-level using a queue, while DFS explores deeply using a stack or recursion.

One challenge was implementing traversal logic correctly and avoiding repeated visits of vertices. I also learned how to measure algorithm performance using System.nanoTime().

This project improved my understanding of graph algorithms, OOP design, and algorithm complexity analysis.
## Bonus Task – Dijkstra’s Algorithm

### Implemented Features

- Added weighted edges support
- Updated Edge class with weight field
- Implemented Dijkstra’s shortest path algorithm
- Added shortest path calculations from a starting vertex
- Displayed shortest distances clearly

### Dijkstra Time Complexity

```text
O(V²)
example:
g.dijkstra(0);
