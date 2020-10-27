package com.training;

import java.util.*;

/**
 *
 * https://algorithms.tutorialhorizon.com/disjoint-set-data-structure-union-find-algorithm/
 *
 * Created by JohnPaul.Manohar on 10/27/2020.
 */
public class DisjointSet {
    public static void main(String... args){

        Graph g = new Graph(6);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(4,5);

        g.disjointSet();
    }

    static class Graph {
        LinkedList<Edge>[] edges;
        ArrayList<Edge> allEdge;
        int nVertex;

        public Graph(int vertex) {
            nVertex = vertex;
            edges = new LinkedList[nVertex];
            allEdge = new ArrayList<>();
            for(int i = 0; i < nVertex; i++) {
                edges[i] = new LinkedList<>();
            }
        }

        void addEdge(int source, int destination) {
            Edge e = new Edge(source, destination);
            edges[source].add(e);
            allEdge.add(e);
        }

        void makeSet(int[] parent) {

            for(int i = 0; i < nVertex; i++) parent[i] = i;
        }

        int find(int[] parent, int vertex) {

            if(parent[vertex] != vertex)
                return find(parent, parent[vertex]);

            return vertex;
        }

        void union(int[] parent, int x, int y) {
            int x_parent = find(parent, x);
            int y_parent = find(parent, y);

            parent[y_parent] = x_parent;
        }

        void disjointSet() {
            int[] parent = new int[nVertex];

            makeSet(parent);

            for(int i = 0; i < allEdge.size(); i++) {
                Edge e = allEdge.get(i);

                int x_set = find(parent, e.source);
                int y_set = find(parent, e.destination);

                if(x_set != y_set) union(parent, x_set, y_set);
            }

            printSet(parent);
        }

        void printSet(int[] parent) {

            HashMap<Integer, List<Integer>> map = new HashMap<>();

            for(int i = 0; i < parent.length; i++) {
                if(!map.containsKey(parent[i])) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(parent[i], list);
                }
                else {
                    List<Integer> list = map.get(parent[i]);
                    list.add(i);
                    map.replace(parent[i], list);
                }
            }

            for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
                System.out.println("Set Id : " + e.getKey() + " elements : " + e.getValue());
            }
        }
    }

    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int _source, int _destination) {
            source = _source;
            destination = _destination;
        }
    }
}
