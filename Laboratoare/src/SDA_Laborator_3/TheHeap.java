package SDA_Laborator_3;

public class TheHeap {
    public static void main(String[] args) {
        try {
            SDA_Laborator_3.Heap heap = new SDA_Laborator_3.Heap();
            heap.Insert(5);
            heap.Insert(10);
            heap.Insert(4);
            heap.Insert(8);
            heap.Insert(11);
            System.out.println(heap);
            System.out.println(heap.ExtractRoot());
            System.out.println(heap.ExtractRoot());
            System.out.println(heap.ExtractRoot());
            heap.Insert(7);
            System.out.println(heap.ExtractRoot());
            System.out.println(heap.ExtractRoot());
        }catch(Exception ex)
        {
            System.out.println(ex);
        }

    }
}
