package com.company;

import java.util.ArrayList;

public class Matching {
    ArrayList<Pair> pairs = new ArrayList<>();
    void InitMens(int[][] graph)
    {
        for(int i=0;i<graph.length;i++)
            pairs.add(new Pair(-1,i,-1));
    }
    boolean AMenIsSingle()
    {
        for (Pair p : pairs ) {
           if (p.w_index==-1)
               return true;
        }
        return false;
    }
    boolean WomenIsSingle(int index)
    {
        for (Pair p : pairs ) {
            if (p.w_index==index)
                return false;
        }
        return true;
    }
    void PerformMatching(int[][] graph)
    {
        InitMens(graph);
       while (AMenIsSingle())
       {
           for (Pair p : pairs ) {
               if (p.w_index==-1)
               {
                   //search for highest rank women
                   int maxindex = 0;
                   int maxvalue = 0;
                   for(int j=0;j<graph[0].length;j++)
                       if (graph[p.m_index][j] > maxvalue)
                       {
                           //if w is free
                           if (WomenIsSingle(j)) {
                               maxvalue = graph[p.m_index][j];
                               maxindex = j;
                           }
                       }
                   if (WomenIsSingle(maxindex)) {
                       p.w_index = maxindex;
                       p.matching_value = maxvalue;
                   }
                    //to refine algorithm
               }
           }
       }
    }

}
