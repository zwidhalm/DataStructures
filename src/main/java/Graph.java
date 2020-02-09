package main.java;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {
    private int V;// number of vertices
    private LinkedList<Integer> adj[]; //adjaceny lists

    Graph(int v){
        V = v;
        adj = new LinkedList[v];
        for(int i = 0; i < v; i++)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w){
        adj[v].add(w);
    }

    void BFS(int s){
        //mark all vertices as not visited(false)
        boolean visited[] = new boolean[V];

        //create a queue for bfs
        LinkedList<Integer> queue = new LinkedList<Integer>();

        //mark the current  node as visited and enqueue it
        visited[s] = true;
        System.out.println("Starting at " + s);
        queue.add(s);

        while(queue.size() != 0){
            //dequeue a vertex from the queue and print it
            s = queue.poll();
            System.out.println("De-queueing " + s);

            //Get all adjacent vertices of the "decked" vertex s
            //if an adjacent has not been visited, then mark it
            //visited and enqueue it
            Iterator<Integer> i = adj[s].listIterator();
            while(i.hasNext()) {
                int n = i.next();
                if(!visited[n]){
                    visited[n] = true;
                    System.out.println("Queueing " + n);
                    queue.add(n);
                }
            }


        }

    }

    void DFS(int v){
        //mark all vertices as not visited(false)
        boolean visited[] = new boolean[V];

        //create a queue for bfs
        Stack<Integer> stack= new Stack<Integer>();

        //mark the current  node as visited and enqueue it
        visited[v] = true;
        System.out.println("Starting at " + v);
        stack.add(v);

        while(!stack.isEmpty()){
            //dequeue a vertex from the queue and print it
            int current = stack.pop();
            System.out.println("Popping " + v);

            //Get all adjacent vertices of the "decked" vertex s
            //if an adjacent has not been visited, then mark it
            //visited and enqueue it
            Iterator<Integer> i = adj[current].listIterator();
            while(i.hasNext()) {
                int n = i.next();
                if(!visited[n]){
                    stack.add(n);
                    visited[n] = true;
                    System.out.println("Pushing " + n);
                }
            }


        }

    }

}
