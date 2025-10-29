package com.gohul.dsa.data_structure;

public class GraphMain {

    public static void main(String[] args) {
//        Graph g = new Graph(5);
//        g.addEdge(0, 1);
//        g.addEdge(0, 2);
//        g.addEdge(1, 3);
//        g.addEdge(2, 4);
//
//        System.out.println(g.traverseGraphWithBfs(0)); // Output: [0, 1, 2, 3, 4]

//        Graph g = new Graph(6);
//        g.addEdge(0, 1);
//        g.addEdge(0, 2);
//        g.addEdge(1, 3);
//        g.addEdge(1, 4);
//        g.addEdge(2, 5);
//
//        System.out.println("BFS starting from vertex 0:");
//        System.out.println(g.traverseGraphWithBfs(0));
//
//        System.out.println("BFS starting from vertex 2:");
//        System.out.println(g.traverseGraphWithBfs(2));

        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);

        System.out.println("DFS starting from vertex 0:");
        System.out.println(g.traverseGraphWithDfs(0));
    }

}
