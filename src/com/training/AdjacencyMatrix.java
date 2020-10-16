package com.training;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by JohnPaul Manohar on 9/15/2020.
 */
public class AdjacencyMatrix {

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

        ArrayList<Character> edges = g.get('a');

    }

    static class Graph {
        private char[] vertexList = new char[0];
        private int[][] adjMat = new int[0][0];
        private HashMap<Character, Integer> vertexMap = new HashMap<>();
        private int nVertex = 0;


        public Graph() {
        }

        void addEdge(char start, char end) {

            if(vertexMap.containsKey(start) && vertexMap.containsKey(end)) {

                int v1 = vertexMap.get(start);
                int v2 = vertexMap.get(end);

                adjMat[v1][v2] = 1;
                adjMat[v2][v1] = 1;
            }

        }

        void addVertex(char v) {

            char[] newVertexList = new char[nVertex + 1];

            for (int i = 0 ; i < nVertex; i++) {
                if(!vertexMap.containsKey(v)) vertexMap.put(vertexList[i], i);
                if(vertexList[i] != v) {
                    newVertexList[i] = vertexList[i];
                }
                else {
                    return;
                }
            }

            vertexMap.put(v, nVertex);
            newVertexList[nVertex] = v;
            vertexList = newVertexList;

            int[][] newAdjMat = new int[nVertex+1][nVertex+1];

            for(int i = 0; i < nVertex; i++)
                for(int j = 0; j < nVertex; j++)
                    newAdjMat[i][j] = adjMat[i][j];

            adjMat = newAdjMat;

            nVertex++;
        }

        ArrayList<Character> get(char v) {

            ArrayList<Character> edges = new ArrayList<>();

            if(vertexMap.containsKey(v)) {
                int pos = vertexMap.get(v);

                for(int i = 0; i < nVertex; i++) {
                    if(adjMat[pos][i] == 1) {
                        edges.add(vertexList[i]);
                    }
                }
            }

            return edges;
        }

        void removeEdge(int start, int end) {

            if(vertexMap.containsKey(start) && vertexMap.containsKey(end)) {

                int v1 = vertexMap.get(start);
                int v2 = vertexMap.get(end);

                adjMat[v1][v2] = 0;
                adjMat[v2][v1] = 0;
            }

        }

        void removeVertex(char v) {

            char[] newVertexList = new char[nVertex - 1];

            boolean vertextExists = false;
            int pos = 0;
            for (int i = 0; i < nVertex; i++) {
                if(vertexList[i] == v) {
                    vertextExists = true;
                    pos = i;
                    break;
                }
            }

            if(!vertextExists) return;

            vertexMap.clear();
            int icount = 0;
            for (int i = 0; i < nVertex; i++) {
                if(i != pos) {
                    vertexMap.put(v, icount);
                    newVertexList[icount++] = vertexList[i];
                }
            }

            vertexList = newVertexList;

            int[][] newAdjMat = new int[nVertex-1][nVertex-1];

            icount = 0;
            for(int i = 0; i < nVertex; i++) {
                if(i != pos) {
                    int jcount = 0;
                    for (int j = 0; j < nVertex; j++) {
                        if (j != pos) {
                            newAdjMat[icount][jcount++] = adjMat[i][j];
                        }
                    }
                    icount++;
                }
            }

            adjMat = newAdjMat;
            nVertex -= 1;
        }

        //non-standard
        void show() {
            for (int i = 0; i < nVertex; i++)
                System.out.print(vertexList[i] + " -> ");

            System.out.println("");
            System.out.println("");
            System.out.println("");

            for(int i = 0; i < nVertex; i++) {
                System.out.print("Showing edges for " + vertexList[i] + " : ");
                for (int j = 0; j < nVertex; j++) {
                    if (adjMat[i][j] == 1) System.out.print(vertexList[j] + ", ");
                }
                System.out.println("");
            }

            /*for(int i = 0; i < nVertex; i++) {
                System.out.println("");
                for (int j = 0; j < nVertex; j++)
                    System.out.print(adjMat[i][j] + "\t");
            }*/
        }
    }


}
