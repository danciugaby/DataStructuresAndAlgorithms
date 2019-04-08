package SDA_Laborator_6;

public class Edge {
    String v1;
    String v2;
    Double value;

    public Edge(String v1, String v2, Double value) {
        this.v1 = v1;
        this.v2 = v2;
        this.value = value;
    }

    @Override
    public int hashCode() {
        return (int) (v1.hashCode() *17 * v2.hashCode()*23 + value*29);
    }

    @Override
    public boolean equals(Object obj) {
        Edge e = (Edge)obj;
        return ( v1.equals(e.v1) && v2.equals(e.v2) ) || ( v1.equals(e.v2) && v2.equals(e.v1) );
    }
}
