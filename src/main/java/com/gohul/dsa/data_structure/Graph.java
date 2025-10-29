package com.gohul.dsa.data_structure;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {

    List<List<Integer>> vertices;

    public Graph(int count){
        this.vertices = new LinkedList<>();

        for (int i = 0; i < count; i++) {
            this.vertices.add(new LinkedList<>());
        }

    }

    public void addEdge(Integer first, Integer second)
    {
        this.vertices.get(first).add(second);
        this.vertices.get(second).add(first);
    }

    public List<Integer> traverseGraphWithBfs(Integer v){
        List<Integer> result = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[this.vertices.size()];
        queue.add(v);
        visited[v] = true;

        while(!queue.isEmpty()){
            Integer currV = queue.remove();
            result.add(currV);
            for(int i=0; i<this.vertices.get(currV).size(); i++){
                Integer childV = this.vertices.get(currV).get(i);
                if(!visited[childV]){
                    queue.add(childV);
                    visited[childV] = true;
                }
            }
        }
        return result;
    }

    public List<Integer> traverseGraphWithDfs(int v){
        boolean[] visited = new boolean[this.vertices.size()];
        List<Integer> result = new LinkedList<>();
        traverseGraphWithDfsAssist(v, visited, result);
        return result;
    }



    public void traverseGraphWithDfsAssist(int v, boolean[] visited, List<Integer> result){
        visited[v] = true;
        result.add(v);
        for(int i=0; i<this.vertices.get(v).size();i++){
            int currV = this.vertices.get(v).get(i);
            if(!visited[currV]){
                traverseGraphWithDfsAssist(currV, visited, result);
            }
        }
    }


}
