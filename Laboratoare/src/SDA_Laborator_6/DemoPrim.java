package SDA_Laborator_6;
import java.util.*;

public class DemoPrim {
    public static void main(String[] args) {
        Graph g = new Graph();
        g = g.createGraph();
        Prim(g);
    }

    static void Prim(Graph g) {
        //list of all nodes;
        ArrayList<String> Q = new ArrayList<>();
        HashSet<Edge> edges = new HashSet<Edge>();

        g.ResetLabels(); //this creates the union/find structure

        for (String s : g.getAdjVertices().keySet() ) {
            Map<Vertex,Double> map = g.getAdjVertices().get(s);
            for(Vertex v : map.keySet())
            {
                edges.add(new Edge(v.getLabel(),s,map.get(v)));
            }
        }

        // we start with A
        String nextkey = "A";
        while (Q.size()< g.getAdjVertices().keySet().size()-1)
        {
            Q.add(nextkey);
            //u ← vertex in Q with min dist[u]
            double min = Double.MAX_VALUE;
            Iterator<Edge> it = edges.iterator();
            Edge smallesedge = new Edge("","",0.);
            while(it.hasNext())
            {
                Edge e = it.next();
                //if node is in tree we investigate its neighbours
                if (Q.contains(e.v1) || Q.contains(e.v2))
                {
                    if (e.value < min) //we take the smallest edge adjacent to nextkey
                    {
                        min = e.value;
                        smallesedge = e;
                    }
                }
            }

            // if adding this edge does not create a cycle
            if (g.Find(smallesedge.v1,smallesedge.v2))
            {
                g.Union(smallesedge.v1,smallesedge.v2); //we added it to tree
                System.out.println("Considered " + smallesedge.v1 + " " + smallesedge.v2 + " " + smallesedge.value);
                //next node considered will be set
                if (!smallesedge.v1.equals(nextkey))
                    nextkey = smallesedge.v1;
                else
                    nextkey = smallesedge.v2;
            }
            else
                System.out.println("Not considered because of cycle " + smallesedge.v1 + " " + smallesedge.v2 + " " + smallesedge.value);
            smallesedge.value = Double.MAX_VALUE;//so we do not consider it anymore;


        }
    }
}