package SDA_Laborator_5;

import java.util.*;
import java.util.stream.*;

class Graph {
    private Map<String, Map<Vertex,Double>> adjVertices;

    public Map<String, Map<Vertex, Double>> getAdjVertices() {
        return adjVertices;
    }

    public void setAdjVertices(Map<String, Map<Vertex, Double>> adjVertices) {
        this.adjVertices = adjVertices;
    }

    public Graph()
    {
        adjVertices = new HashMap<String, Map<Vertex,Double>>();
    }
    Graph createGraph() {
        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addEdge("A", "B",1.);
        graph.addEdge("A", "D",7.);
        graph.addEdge("E", "D",2.);
        graph.addEdge("C", "D",1.);
        graph.addEdge("C", "E",9.);
        graph.addEdge("C", "A",5.);
        graph.addEdge("D", "B",3.);
        graph.addEdge("B", "C",3.);

        return graph;
    }
    void addEdge(String label1, String label2, Double value) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        adjVertices.get(v1.getLabel()).put(v2,value);
        adjVertices.get(v2.getLabel()).put(v1,value);
    }
    void addVertex(String label) {
        adjVertices.putIfAbsent(label, new HashMap<Vertex,Double>());
    }

    Map<Vertex,Double> getAdjVerticesForOne(String label) {
        return adjVertices.get(label);
    }
    void removeVertex(String label) {
        Vertex v = new Vertex(label);
        adjVertices.values()
                .stream()
                .map(e -> e.remove(v))
                .collect(Collectors.toList());
        adjVertices.remove(new Vertex(label));
    }

    void removeEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        Map<Vertex,Double>eV1 = adjVertices.get(v1.getLabel());
        Map<Vertex,Double> eV2 = adjVertices.get(v2.getLabel());
        if (eV1 != null)
            eV1.remove(v2);
        if (eV2 != null)
            eV2.remove(v1);
    }

}