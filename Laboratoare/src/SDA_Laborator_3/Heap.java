package SDA_Laborator2;

import java.util.ArrayList;

public class Heap {

    private ArrayList<Integer> heap;
    public Heap()
    {
        heap = new ArrayList<Integer>();
        heap.add(Integer.MAX_VALUE); /// dummy value on first position
        // we start always from index 1
    }
    public Integer ExtractRoot() throws Exception
    {
        if (heap.size() <=1)
            throw new Exception("Heap empty");
        Integer root = heap.get(1);     //get root value
        heap.set(1,heap.get(heap.size()-1)); //get last element and set as root
        heap.remove(heap.size()-1); //remove last element
        SiftDown(1);

        return root;
    }

    public void Insert(Integer newval) throws Exception
    {
        if (heap.size() <1)
            throw new Exception("Heap empty");

        heap.add(newval);   //insert at end of heap
        Percolate(heap.size()-1);   //remake heap
    }

    private void Percolate(int index)
    {
        int k = index;
        int j = 1;
        do {
            j=k;
            if (j > 1 && heap.get(j/2) < heap.get(k))
                k = j/2;
            int aux = heap.get(j);
            heap.set(j,heap.get(k));
            heap.set(k,aux);

        }while(j!=k);
    }

    private void SiftDown(int index) {
        int k = index;
        int j = 1;
        do {
             j=k;
            if (2*j < heap.size() && heap.get(2*j) > heap.get(k))
                k=2*j;
            if (2*j < heap.size()-1 && heap.get(2*j+1) > heap.get(k))
                k=2*j+1;
            int aux = heap.get(j);
            heap.set(j,heap.get(k));
            heap.set(k,aux);
        }
        while (j != k);
    }
    public String toString()
    {
        return heap.toString();
    }

}
