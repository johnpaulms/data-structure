package com.training;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by JohnPaul Manohar on 9/15/2020.
 */
public class AdjacencyList {

    public static void main(String... args) {

        Graph g = new Graph();

        g.addVertex('a');
        g.addVertex('b');
        g.addVertex('c');
        g.addVertex('d');
        g.addVertex('e');
        g.addVertex('f');
        g.addVertex('g');
        g.addVertex('h');
        g.addVertex('i');

        g.addEdge('a','b');
        g.addEdge('a','c');
        g.addEdge('a','d');
        g.addEdge('a','e');
        g.addEdge('b','f');
        g.addEdge('f','h');
        g.addEdge('d','g');
        g.addEdge('g','i');

        g.show();

        g.removeEdge('a', 'e');
        g.removeEdge('g', 'i');

        System.out.println("");
        System.out.println("After removing some edge : ");
        System.out.println("");

        g.show();

        g.removeVertex('f');
        g.removeVertex('a');
        g.removeVertex('i');

        System.out.println("");
        System.out.println("After removing some vertex : ");
        System.out.println("");

        g.show();

        ArrayList<Character> edges = g.get('g');

    }

    static class Graph {

        LinkedList<Integer> adjList[];
        ArrayList<Character> vertexList = new ArrayList<>();
        HashMap<Character, Integer> vertexMap = new HashMap<>();
        int nVertex = 0;

        void addEdge(char start, char end) {

            if(vertexMap.containsKey(start) && vertexMap.containsKey(end)) {
                int v1 = vertexMap.get(start);
                int v2 = vertexMap.get(end);

                adjList[v1].add(v2);
                adjList[v2].add(v1);
            }

        }

        void addVertex(char v) {

            if(!vertexMap.containsKey(v)) {

                vertexMap.put(v, nVertex);
                vertexList.add(v);

                LinkedList<Integer> newAdjList[] = new LinkedList[vertexList.size()];

                for(int i = 0; i < nVertex; i++) {
                    newAdjList[i] = new LinkedList<>();
                    newAdjList[i] = adjList[i];
                }

                newAdjList[nVertex] = new LinkedList<>();
                adjList = newAdjList;

                nVertex++;
            }
        }

        ArrayList<Character> get(char v) {

            ArrayList<Character> edges = new ArrayList<>();

            if(vertexMap.containsKey(v)) {
                for (int i = 0; i < adjList[vertexMap.get(v)].size(); i++) {
                    edges.add(vertexList.get(adjList[vertexMap.get(v)].get(i)));
                }
            }

            return edges;
        }

        void removeEdge(char start, char end) {

            if(vertexMap.containsKey(start) && vertexMap.containsKey(end)) {
                int v1 = vertexMap.get(start);
                int v2 = vertexMap.get(end);

                int v2pos = adjList[v1].indexOf(v2);
                adjList[v1].remove(v2pos);
                int v1pos = adjList[v2].indexOf(v1);
                adjList[v2].remove(v1pos);
            }
        }

        void removeVertex(char v) {

            if(vertexMap.containsKey(v)) {
                int pos = vertexMap.get(v);

                for(int i = pos + 1; i < nVertex; i++) {
                    int currPos = vertexMap.get(vertexList.get(i));
                    vertexMap.replace(vertexList.get(i), currPos - 1);
                }

                LinkedList<Integer> newAdjList[] = new LinkedList[nVertex - 1];
                int vCounter = 0;
                for (int i = 0 ; i < nVertex; i++) {
                    if (i != pos) {
                        newAdjList[vCounter] = new LinkedList<>();
                        newAdjList[vCounter] = adjList[i];
                        vCounter++;
                    }
                }

                for (int i = 0; i < nVertex - 1; i++) {
                    int vPos = newAdjList[i].indexOf(pos);
                    if(vPos >= 0) newAdjList[i].remove(vPos);
                }

                adjList = newAdjList;

                vertexList.remove(pos);
                vertexMap.remove(v);
                nVertex--;
            }
        }

        //non-standard
        void show() {

            for (int i = 0; i < nVertex; i++) {
                System.out.print("Showing edges of vertex " + vertexList.get(i) + ": ");

                for (int j = 0; j < adjList[i].size(); j++) {
                    System.out.print(vertexList.get(adjList[i].get(j)) + ", ");
                }

                System.out.println("");
            }

        }
    }


}
